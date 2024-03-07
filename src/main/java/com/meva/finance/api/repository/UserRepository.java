package com.meva.finance.api.repository;


import com.meva.finance.api.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;


//Jpa Informo a Classe e o Atributo da classe Primary Key
@Repository

public interface UserRepository extends JpaRepository<User, String> {

Optional<User> findById(String cpf);
}
