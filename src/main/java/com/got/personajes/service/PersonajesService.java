package com.got.personajes.service;

import com.got.personajes.repository.PersonajesRepository;
import com.got.personajes.entity.Personaje;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonajesService {
    @Autowired
    PersonajesRepository personajesRepository;

    public List<Personaje> findAll() {
        return personajesRepository.findAll();
    }
}
