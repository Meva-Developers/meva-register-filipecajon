package com.meva.finance.api.service;

import com.meva.finance.api.dto.FamilyDto;
import com.meva.finance.api.dto.UserDto;
import com.meva.finance.api.exception.InvalidFamilyException;
import com.meva.finance.api.model.Family;
import com.meva.finance.api.model.User;
import com.meva.finance.api.repository.FamilyRepository;
import com.meva.finance.api.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.Objects;
import java.util.Optional;

@Service //Entende que é uma classe Service
@Slf4j
public class UserService {

    private final UserRepository userRepository;
    private final FamilyRepository familyRepository;

    @Autowired
    public UserService(UserRepository userRepository, FamilyRepository familyRepository) {
        this.userRepository = userRepository;
        this.familyRepository = familyRepository;
    }


    public String register(UserDto userDto) {
        User user = new User();
        BeanUtils.copyProperties(userDto, user);

        user.setFamily(this.validateFamily(userDto.getFamilyDto()));

        if (!Objects.nonNull(user.getFamily())) {
            log.error("Familia nao existe");
            throw new InvalidFamilyException("Family ID not exist", HttpStatus.BAD_REQUEST);

        }
        return userRepository.save(user).getCpf();
        //  return userRepository.save(user);

    }

    private Family validateFamily(FamilyDto familyDto) {
        Family family = new Family();
        BeanUtils.copyProperties(familyDto, family);
        if (familyDto.getIdFamily() == 0) {
            return familyRepository.save(family);
        } else if (Objects.isNull(familyRepository.findFamily(familyDto.getIdFamily()))
                || familyRepository.findFamily(familyDto.getIdFamily()) == 0) {
            throw new InvalidFamilyException("Family ID not exist", HttpStatus.BAD_REQUEST);
        }
        return family;
    }

    public User update(UserDto userDto) {
        User user = userDto.update(userDto);
        return userRepository.save(user);
    }


    public void delete(String cpf) {
        userRepository.deleteById(cpf);
    }

    public Optional<User> findById(String cpf) {
        return userRepository.findById(cpf);
    }

}