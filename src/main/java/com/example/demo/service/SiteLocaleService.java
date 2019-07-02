package com.example.demo.service;

import com.example.demo.domain.SiteLocale;
import com.example.demo.repository.SiteLocaleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Optional;

@Service
public class SiteLocaleService {
    private SiteLocaleRepository repository;

    @Autowired
    public SiteLocaleService(SiteLocaleRepository repository) {
        this.repository = repository;
    }

    public Page<SiteLocale> findAll(Pageable pageable) {
        return repository.findAll(pageable);
    }

    public Optional<SiteLocale> findByCode(String code) {
        return repository.findByCode(code);
    }

    public Optional<SiteLocale> findById(Long id) {
        return repository.findById(id);
    }

    public List<SiteLocale> findAllByIsEnabledTrue() {
        return repository.findAllByIsEnabledTrue();
    }

    public void deleteById(Long id) {
        repository.deleteById(id);
    }

    public SiteLocale create(SiteLocale locale) {
        return repository.save(locale);
    }

    public SiteLocale update(SiteLocale locale) {
        Optional<SiteLocale> current = findById(locale.getId());
        if(!current.isPresent()) {
            throw new IllegalArgumentException("Locale not found!");
        }
        current.get().setCode(locale.getCode());
        current.get().setName(locale.getName());
        current.get().setIsDefault(locale.getIsDefault());
        current.get().setIsEnabled(locale.getIsEnabled());
        return repository.save(current.get());
    }

}
