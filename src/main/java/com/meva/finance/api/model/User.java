package com.meva.finance.api.model;

import com.meva.finance.api.dto.UserDto;
import lombok.*;

import javax.persistence.*;
import java.util.Date;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "user_meva")
@Builder
public class User {

    @Id
    //criei a coluna sozinho
    @Column(nullable = false, unique = true, length = 11)
    private String cpf;
    private String name;
    private String genre;
    private Date birth;
    private String state;
    private String city;

    //Referenciando Familia
    @ManyToOne @JoinColumn(name = "id_family")
    private Family family;

    //Convertendo user para userDto
    public User (UserDto userDto) {
        this.cpf = userDto.getCpf();
        this.name = userDto.getName();
        this.genre = userDto.getGenre();
        this.birth = userDto.getBirth();
        this.state = userDto.getState();
        this.city = userDto.getCity();
    }
}
