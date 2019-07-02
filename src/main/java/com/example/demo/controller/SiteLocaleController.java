package com.example.demo.controller;

import com.example.demo.domain.SiteLocale;
import com.example.demo.service.SiteLocaleService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.Optional;

@Log4j2
@RestController
public class SiteLocaleController {

    private static final String RESOURCE_PATH = "/locales";

    @NotNull
    private SiteLocaleService service;

    @Autowired
    public SiteLocaleController(SiteLocaleService service) {
        this.service = service;
    }

    @GetMapping(RESOURCE_PATH)
    @ResponseBody
    @ResponseStatus(HttpStatus.OK)
    public Page<SiteLocale> findAll(Pageable pageable) {
        return service.findAll(pageable);
    }

    @GetMapping(RESOURCE_PATH + "/code/{code}")
    @ResponseBody
    @ResponseStatus(HttpStatus.OK)
    public Optional<SiteLocale> findByCode(@PathVariable(name = "code") String code) {
        return service.findByCode(code);
    }

    @GetMapping(RESOURCE_PATH + "/id/{id}")
    @ResponseBody
    @ResponseStatus(HttpStatus.OK)
    public Optional<SiteLocale> findById(@PathVariable(name = "id") Long id) {
        return service.findById(id);
    }

    @DeleteMapping(RESOURCE_PATH + "/delete/{id}")
    @ResponseBody
    @ResponseStatus(HttpStatus.OK)
    public void deleteById(@PathVariable(name = "id") Long id) {
        service.deleteById(id);
    }

    @PostMapping(RESOURCE_PATH)
    @ResponseBody
    @ResponseStatus(HttpStatus.CREATED)
    public SiteLocale create(@Valid @RequestBody SiteLocale locale) {
        return service.create(locale);
    }

    @PutMapping(RESOURCE_PATH)
    @ResponseBody
    @ResponseStatus(HttpStatus.OK)
    public SiteLocale update(@Valid @RequestBody SiteLocale locale) {
        return service.update(locale);
    }
}
