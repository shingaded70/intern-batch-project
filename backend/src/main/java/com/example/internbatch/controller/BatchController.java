package com.example.internbatch.controller;

import com.example.internbatch.model.Batch;
import com.example.internbatch.service.BatchService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/batches")
@CrossOrigin(origins = "*")
public class BatchController {
    private final BatchService service;

    public BatchController(BatchService service) { this.service = service; }

    @GetMapping
    public List<Batch> list() { return service.listAll(); }

    @PostMapping
    public Batch create(@RequestBody Batch batch) { return service.createBatch(batch); }

    @GetMapping("/{id}")
    public Batch get(@PathVariable Long id) { return service.get(id); }
@DeleteMapping("/{id}")
public void delete(@PathVariable Long id){
    service.delete(id);
}
}
