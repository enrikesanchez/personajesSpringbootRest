package com.got.personajes.controller;

import com.got.personajes.entity.Casa;
import com.got.personajes.service.CasasService;
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
public class CasasController {
    @Autowired
    CasasService casasService;

    @GetMapping("/casas")
    public ResponseEntity<List<Casa>> getAll() {
        List<Casa> casas = casasService.findAll();
        return new ResponseEntity<>(casas, HttpStatus.OK);
    }

    @GetMapping("/casas/{id}")
    public ResponseEntity<Casa> getById(@PathVariable("id") Long id) {
        Optional<Casa> casa = casasService.findById(id);

        return casa.map(value -> new ResponseEntity<>(value, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NO_CONTENT));
    }

    @PostMapping("/casas")
    public ResponseEntity<Casa> create(@RequestBody @Valid Casa casaNuevo) {
        Casa casaAgregado = casasService.add(casaNuevo);
        return new ResponseEntity<>(casaAgregado, HttpStatus.CREATED);
    }

    @PutMapping("/casas/{id}")
    public ResponseEntity<Casa> updateById(@PathVariable("id") Long id, @RequestBody @Valid Casa casaActualizado) {
        Optional<Casa> casa = casasService.update(id, casaActualizado);

        return casa.map(value -> new ResponseEntity<>(value, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NO_CONTENT));
    }

    @DeleteMapping("/casas/{id}")
    public ResponseEntity<Object> deleteById(@PathVariable("id") Long id) {
        Optional<Casa> casa = casasService.delete(id);

        return casa.map(value -> new ResponseEntity<>(HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NO_CONTENT));
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Object> handleMethodArgumentNotValid(final MethodArgumentNotValidException manve) {
        Map<String, Object> body = new HashMap<>();
        body.put("message", manve.getMessage());

        return new ResponseEntity<>(body, HttpStatus.BAD_REQUEST);
    }    
}
