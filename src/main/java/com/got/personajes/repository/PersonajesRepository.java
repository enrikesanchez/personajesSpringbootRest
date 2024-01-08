package com.got.personajes.repository;

import com.got.personajes.entity.Personaje;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonajesRepository extends JpaRepository<Personaje, Long> {
}
