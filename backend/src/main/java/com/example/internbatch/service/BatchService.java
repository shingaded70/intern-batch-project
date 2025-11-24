package com.example.internbatch.service;

import com.example.internbatch.model.Batch;
import com.example.internbatch.repository.BatchRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.Period;
import java.util.List;

@Service
public class BatchService {
    private final BatchRepository batchRepository;

    public BatchService(BatchRepository batchRepository) {
        this.batchRepository = batchRepository;
    }

    public Batch createBatch(Batch batch) {
        // calculate end date = start + 6 months
        LocalDate start = batch.getStartDate();
        batch.setEndDate(start.plusMonths(6));
        return batchRepository.save(batch);
    }

    public List<Batch> listAll() { return batchRepository.findAll(); }

    public Batch get(Long id){ return batchRepository.findById(id).orElseThrow(() -> new RuntimeException("Not found")); }
 public void delete(Long id) {
    batchRepository.deleteById(id);
}
}
