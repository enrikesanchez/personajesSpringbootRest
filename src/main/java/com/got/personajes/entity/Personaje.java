package com.got.personajes.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

@Entity
public class Personaje {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @NotNull(message = "Id es obligatorio")
    private Long id;
    @NotEmpty(message = "Nombre es obligatorio")
    private String nombre;
    @NotEmpty(message = "Apellido es obligatorio")
    private String apellido;

    @OneToOne
    @JoinColumn(name = "mascotaId")
    private Mascota mascota;

    @ManyToOne
    @JoinColumn(name="casaId")
    private Casa casa;

    public Personaje() {
    }

    public Personaje(final Long id, final String nombre, final String apellido) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
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

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public Mascota getMascota() {
        return mascota;
    }

    public void setMascota(Mascota mascota) {
        this.mascota = mascota;
    }

    public Casa getCasa() {
        return casa;
    }

    public void setCasa(Casa casa) {
        this.casa = casa;
    }
}
