package com.got.personajes.controller;

import com.got.personajes.service.PersonajesService;
import com.got.personajes.entity.Personaje;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

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

    @GetMapping("/personajes/{id}")
    public ResponseEntity<Personaje> getById(@PathVariable("id") Long id) {
        Optional<Personaje> personaje = personajesService.findById(id);

        return personaje.map(value -> new ResponseEntity<>(value, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NO_CONTENT));
    }

    @PostMapping("/personajes")
    public ResponseEntity<Personaje> create(@RequestBody @Valid Personaje personajeNuevo) {
        Personaje personajeAgregado = personajesService.add(personajeNuevo);
        return new ResponseEntity<>(personajeAgregado, HttpStatus.CREATED);
    }

    @PutMapping("/personajes/{id}")
    public ResponseEntity<Personaje> updateById(@PathVariable("id") Long id, @RequestBody @Valid Personaje personajeActualizado) {
        Optional<Personaje> personaje = personajesService.update(id, personajeActualizado);

        return personaje.map(value -> new ResponseEntity<>(value, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NO_CONTENT));
    }

    @DeleteMapping("/personajes/{id}")
    public ResponseEntity<Object> deleteById(@PathVariable("id") Long id) {
        Optional<Personaje> personaje = personajesService.delete(id);

        return personaje.map(value -> new ResponseEntity<>(HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NO_CONTENT));
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Object> handleMethodArgumentNotValid(final MethodArgumentNotValidException manve) {
        Map<String, Object> body = new HashMap<>();
        body.put("message", manve.getMessage());

        return new ResponseEntity<>(body, HttpStatus.BAD_REQUEST);
    }
}
