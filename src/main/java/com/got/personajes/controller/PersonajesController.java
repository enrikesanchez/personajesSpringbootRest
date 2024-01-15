package com.got.personajes.controller;

import com.got.personajes.service.PersonajesService;
import com.got.personajes.entity.Personaje;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("juego-de-tronos")
public class PersonajesController {
    @Autowired
    PersonajesService personajesService;

    @GetMapping("/personajes")
    public ResponseEntity<List<Personaje>> getAll() {
        List<Personaje> personajes = personajesService.findAll();
        return new ResponseEntity<>(personajes, HttpStatus.OK);
    }

    @PostMapping("/personajes")
    public ResponseEntity<Personaje> create(@RequestBody @Valid Personaje personajeNuevo) {
        Personaje personajeAgregado = personajesService.add(personajeNuevo);
        return new ResponseEntity<>(personajeAgregado, HttpStatus.CREATED);
    }
}
