package com.meva.finance.api.repository;


import com.meva.finance.api.model.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;



//Jpa Informo a Classe e o Atributo da classe Primary Key
@Repository
public interface UserRepository extends JpaRepository<User, String> {


}
