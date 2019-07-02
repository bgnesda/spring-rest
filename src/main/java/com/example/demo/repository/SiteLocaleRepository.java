package com.example.demo.repository;

import com.example.demo.domain.SiteLocale;
import org.springframework.data.domain.Page;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.awt.print.Pageable;
import java.util.List;
import java.util.Optional;

@Repository
public interface SiteLocaleRepository extends PagingAndSortingRepository<SiteLocale, Long> {
    Optional<SiteLocale> findByCode(String code);
    List<SiteLocale> findAllByIsEnabledTrue();
}
