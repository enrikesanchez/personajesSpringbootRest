package com.got.personajes.service;

import com.got.personajes.valueobject.Personaje;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PersonajesService {
    public List<Personaje> findAll() {
        List<Personaje> personajes = new ArrayList<>();
        personajes.add(new Personaje(1L, "Jon", "Snow"));
        personajes.add(new Personaje(2L, "Ned", "Stark"));
        return personajes;
    }
}
