package com.meva.finance.api.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

import static javax.persistence.GenerationType.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "family")
public class Family {

   @Id
    @SequenceGenerator(name = "family_id_seq", sequenceName = "family_id_seq", allocationSize = 1)
    @GeneratedValue(strategy = SEQUENCE, generator = "family_id_seq")
    @Column(name = "id_family", updatable = false)
    private Long idFamily;
     @Column(name = "description")
    private String description;

    /* @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_family;
    @Column(name = "description")
    private String description;*/






}
