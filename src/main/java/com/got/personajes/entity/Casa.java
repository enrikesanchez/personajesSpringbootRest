package com.got.personajes.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

import java.util.List;

@Entity
public class Casa {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @NotNull(message = "Id es obligatorio")
    private Long id;

    @NotEmpty(message = "Nombre es obligatorio")
    private String nombre;
    @NotEmpty(message = "Reino es obligatorio")
    private String reino;

    @OneToMany(mappedBy = "casa")
    private List<Personaje> personajes;

    public Casa() {
    }

    public Casa(Long id, String nombre, String reino) {
        this.id = id;
        this.nombre = nombre;
        this.reino = reino;
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

    public String getReino() {
        return reino;
    }

    public void setReino(String reino) {
        this.reino = reino;
    }
}
