package com.got.personajes.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

@Entity
public class Mascota {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @NotNull(message = "Id es obligatorio")
    private Long id;

    @NotEmpty(message = "Nombre es obligatorio")
    private String nombre;
    @NotEmpty(message = "Especie es obligatorio")
    private String especie;

    @OneToOne(mappedBy = "mascota")
    private Personaje personaje;

    public Mascota() {
    }

    public Mascota(Long id, String nombre, String especie) {
        this.id = id;
        this.nombre = nombre;
        this.especie = especie;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEspecie() {
        return especie;
    }

    public void setEspecie(String especie) {
        this.especie = especie;
    }
}
