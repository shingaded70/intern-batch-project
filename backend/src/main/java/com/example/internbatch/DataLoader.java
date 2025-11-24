package com.example.internbatch;

import com.example.internbatch.model.Batch;
import com.example.internbatch.model.Intern;
import com.example.internbatch.repository.BatchRepository;
import com.example.internbatch.repository.InternRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.Arrays;

@Component
public class DataLoader implements CommandLineRunner {

    private final BatchRepository batchRepository;
    private final InternRepository internRepository;

    public DataLoader(BatchRepository batchRepository, InternRepository internRepository) {
        this.batchRepository = batchRepository;
        this.internRepository = internRepository;
    }

    @Override
    public void run(String... args) throws Exception {

        Batch b1 = new Batch();
        b1.setStartDate(LocalDate.now());
        b1.setEndDate(LocalDate.now().plusMonths(6));
        batchRepository.save(b1);

        Intern i1 = new Intern();
        i1.setName("Alice Example");
        i1.setEmail("alice@example.com");
        i1.setMobileNumber("9999999999");
        i1.setIdCardType("Premium");
        i1.setDateOfJoining(LocalDate.now());
        i1.setBatch(b1);

        internRepository.save(i1);
    }
}