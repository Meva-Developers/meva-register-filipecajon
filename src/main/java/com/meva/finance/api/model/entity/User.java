package com.meva.finance.api.model.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "user_meva")
public class User {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String cpf;
    @Column(name = "name")
    private String name;
    @Column(name = "genre")
    private String genre;
    @Column(name = "birth")
    private Date birth;
    @Column(name = "state")
    private String state;
    @Column(name = "city")
    private String city;

    //Referenciando Familia
    @ManyToOne @JoinColumn(name = "id_family")
    private Family family;
}
