package com.example.demo.domain;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;

@Entity
@Data
@Getter
@Setter
@Table(name = "locales")
public class SiteLocale {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotEmpty(message = "Name cannot be empty!!!")
    @Column(name = "name", nullable = false)
    private String name;

    @NotEmpty(message = "Code cannot be empty!!!")
    @Column(name = "code", nullable = false)
    private String code;

    @Column(name = "is_default", nullable = false)
    private Boolean isDefault = false;

    @Column(name = "is_enabled", nullable = false)
    private Boolean isEnabled = false;

}
