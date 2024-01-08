package com.got.personajes.controller;

import com.got.personajes.service.PersonajesService;
import com.got.personajes.entity.Personaje;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
