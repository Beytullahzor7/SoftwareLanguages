package com.languages.webApi.controllers;

import com.languages.business.abstracts.LanguagesService;
import com.languages.entities.concretes.SoftwareLanguages;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/languages")
public class LanguagesController {

    private LanguagesService service;

    public LanguagesController(LanguagesService service) {
        this.service = service;
    }

    @PostMapping()
    public SoftwareLanguages add(@RequestBody SoftwareLanguages languages) {
        return service.add(languages);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable int id) {
        service.delete(id);
    }

    @PutMapping("/{id}")
    public SoftwareLanguages update(@PathVariable int id, @RequestBody SoftwareLanguages languages) {
        return service.update(id, languages);
    }

    @GetMapping("/list")
    public List<SoftwareLanguages> list() {
        return service.list();
    }

    @GetMapping("/{id}")
    public SoftwareLanguages getById(@PathVariable int id) {
        return service.getById(id);
    }
}
