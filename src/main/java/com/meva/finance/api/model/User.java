package com.meva.finance.api.model;

import lombok.*;

import javax.persistence.*;
import java.util.Date;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "user_meva")
public class User {

    @Id
    //criei a coluna sozinho
    @Column(nullable = false, unique = true, length = 11)
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
