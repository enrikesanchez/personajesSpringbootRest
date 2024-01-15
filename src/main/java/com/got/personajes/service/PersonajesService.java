package com.got.personajes.service;

import com.got.personajes.repository.PersonajesRepository;
import com.got.personajes.entity.Personaje;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PersonajesService {
    @Autowired
    PersonajesRepository personajesRepository;

    public List<Personaje> findAll() {
        return personajesRepository.findAll();
    }

    public Optional<Personaje> findById(final Long id) {
        return personajesRepository.findById(id);
    }

    public Personaje add(final Personaje personajeNuevo) {
        return personajesRepository.save(personajeNuevo);
    }

    public Optional<Personaje> delete(final Long id) {
        Optional<Personaje> personajeEncontrado = personajesRepository.findById(id);

        personajeEncontrado.ifPresent(personaje -> personajesRepository.delete(personaje));

        return personajeEncontrado;
    }

}
