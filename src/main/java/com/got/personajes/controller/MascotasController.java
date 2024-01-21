package com.got.personajes.controller;

import com.got.personajes.entity.Mascota;
import com.got.personajes.service.MascotasService;
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
public class MascotasController {
    @Autowired
    MascotasService mascotasService;

    @GetMapping("/mascotas")
    public ResponseEntity<List<Mascota>> getAll() {
        List<Mascota> mascotas = mascotasService.findAll();
        return new ResponseEntity<>(mascotas, HttpStatus.OK);
    }

    @GetMapping("/mascotas/{id}")
    public ResponseEntity<Mascota> getById(@PathVariable("id") Long id) {
        Optional<Mascota> mascota = mascotasService.findById(id);

        return mascota.map(value -> new ResponseEntity<>(value, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NO_CONTENT));
    }

    @PostMapping("/mascotas")
    public ResponseEntity<Mascota> create(@RequestBody @Valid Mascota mascotaNuevo) {
        Mascota mascotaAgregado = mascotasService.add(mascotaNuevo);
        return new ResponseEntity<>(mascotaAgregado, HttpStatus.CREATED);
    }

    @PutMapping("/mascotas/{id}")
    public ResponseEntity<Mascota> updateById(@PathVariable("id") Long id, @RequestBody @Valid Mascota mascotaActualizado) {
        Optional<Mascota> mascota = mascotasService.update(id, mascotaActualizado);

        return mascota.map(value -> new ResponseEntity<>(value, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NO_CONTENT));
    }

    @DeleteMapping("/mascotas/{id}")
    public ResponseEntity<Object> deleteById(@PathVariable("id") Long id) {
        Optional<Mascota> mascota = mascotasService.delete(id);

        return mascota.map(value -> new ResponseEntity<>(HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NO_CONTENT));
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Object> handleMethodArgumentNotValid(final MethodArgumentNotValidException manve) {
        Map<String, Object> body = new HashMap<>();
        body.put("message", manve.getMessage());

        return new ResponseEntity<>(body, HttpStatus.BAD_REQUEST);
    }    
}
