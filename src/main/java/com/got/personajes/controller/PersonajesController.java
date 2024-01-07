package com.got.personajes.controller;

import com.got.personajes.valueobject.Personaje;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("juego-de-tronos")
public class PersonajesController {
    @GetMapping("/personajes")
    public ResponseEntity<List<Personaje>> getAll() {
        List<Personaje> personajes = new ArrayList<>();
        personajes.add(new Personaje(1L, "Jon", "Snow"));
        personajes.add(new Personaje(2L, "Ned", "Stark"));
        return new ResponseEntity<>(personajes, HttpStatus.OK);
    }
}
