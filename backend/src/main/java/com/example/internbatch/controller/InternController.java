package com.example.internbatch.controller;

import com.example.internbatch.model.Intern;
import com.example.internbatch.service.InternService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/interns")
@CrossOrigin(origins = "*")
public class InternController {
    private final InternService service;

    public InternController(InternService service) { this.service = service; }

    @GetMapping
    public List<Intern> list() { return service.listAll(); }

    @PostMapping
    public Intern add(@RequestBody Intern intern) { return service.addIntern(intern); }

    @GetMapping("/{id}")
    public ResponseEntity<Intern> get(@PathVariable Long id) {
        return service.get(id).map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public Intern update(@PathVariable Long id, @RequestBody Intern intern) {
        intern.setId(id);
        return service.update(intern);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) { service.delete(id); }
}
