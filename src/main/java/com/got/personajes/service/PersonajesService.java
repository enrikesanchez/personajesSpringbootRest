package com.got.personajes.service;

import com.got.personajes.entity.Casa;
import com.got.personajes.repository.PersonajesRepository;
import com.got.personajes.entity.Personaje;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class PersonajesService {
    @Autowired
    PersonajesRepository personajesRepository;

    @Autowired
    CasasService casasService;

    public List<Personaje> findAll() {
        return personajesRepository.findAll();
    }

    public Optional<Personaje> findById(final Long id) {
        return personajesRepository.findById(id);
    }

    public List<Personaje>  findByCasaId(final Long id) {
        Optional<Casa> casaEncontrada = casasService.findById(id);
        List<Personaje> personajes = new ArrayList<>();

        if (casaEncontrada.isPresent()) {
            personajes = personajesRepository.findByCasa(casaEncontrada.get());
        }

        return personajes;
    }

    public Personaje add(final Personaje personajeNuevo) {
        return personajesRepository.save(personajeNuevo);
    }

    public Optional<Personaje> update(final Long id, final Personaje personaje) {
        Optional<Personaje> personajeEncontrado = personajesRepository.findById(id);

        if (personajeEncontrado.isPresent()) {
            return Optional.of(personajesRepository.save(personaje));
        }

        return personajeEncontrado;
    }

    public Optional<Personaje> delete(final Long id) {
        Optional<Personaje> personajeEncontrado = personajesRepository.findById(id);

        personajeEncontrado.ifPresent(personaje -> personajesRepository.delete(personaje));

        return personajeEncontrado;
    }

}
