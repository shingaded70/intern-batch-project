package com.example.internbatch.service;

import com.example.internbatch.model.Batch;
import com.example.internbatch.model.Intern;
import com.example.internbatch.repository.BatchRepository;
import com.example.internbatch.repository.InternRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class InternService {
    private final InternRepository internRepository;
    private final BatchRepository batchRepository;
    private final IdGenerator idGenerator;

    public InternService(InternRepository internRepository, BatchRepository batchRepository, IdGenerator idGenerator) {
        this.internRepository = internRepository;
        this.batchRepository = batchRepository;
        this.idGenerator = idGenerator;
    }

    @Transactional
    public Intern addIntern(Intern intern) {
        // ensure batch exists
        Batch batch = batchRepository.findById(intern.getBatch().getId())
                .orElseThrow(() -> new RuntimeException("Batch not found"));
        intern.setBatch(batch);

        // generate internId
        LocalDate doj = intern.getDateOfJoining();
        String prefix = idGenerator.formatPrefix(intern.getIdCardType());
        String datePart = idGenerator.datePart(doj);
        long already = internRepository.countByDateOfJoiningAndIdCardType(doj, intern.getIdCardType());
        int seq = (int) already + 1;
        String candidate = idGenerator.compose(prefix, datePart, seq);
        // ensure unique; increment if collision
        while (internRepository.existsByInternId(candidate)) {
            seq++;
            candidate = idGenerator.compose(prefix, datePart, seq);
        }
        intern.setInternId(candidate);
        return internRepository.save(intern);
    }

    public List<Intern> listAll() {
        return internRepository.findAll();
    }

    public Optional<Intern> get(Long id) { return internRepository.findById(id); }

    public Intern update(Intern intern) {
        // internId immutable; fetch existing
        Intern existing = internRepository.findById(intern.getId()).orElseThrow(() -> new RuntimeException("Not found"));
        existing.setName(intern.getName());
        existing.setEmail(intern.getEmail());
        existing.setMobileNumber(intern.getMobileNumber());
        existing.setIdCardType(intern.getIdCardType());
        existing.setDateOfJoining(intern.getDateOfJoining());
        if (intern.getBatch() != null) existing.setBatch(intern.getBatch());
        return internRepository.save(existing);
    }

    public void delete(Long id) { internRepository.deleteById(id); }
}
