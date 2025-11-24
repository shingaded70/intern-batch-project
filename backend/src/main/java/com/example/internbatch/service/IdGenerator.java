package com.example.internbatch.service;

import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@Component
public class IdGenerator {
    private static final DateTimeFormatter F = DateTimeFormatter.ofPattern("yyyyMMdd");

    public String formatPrefix(String idCardType) {
        if ("Premium".equalsIgnoreCase(idCardType) || "EMP".equalsIgnoreCase(idCardType)) return "EMP";
        return "TDA";
    }

    public String datePart(LocalDate date) {
        return date.format(F);
    }

    // Compose final id: PREFIX + date + - + three digit sequence (caller must ensure uniqueness)
    public String compose(String prefix, String datePart, int seq) {
        return String.format("%s%s-%03d", prefix, datePart, seq);
    }
}
