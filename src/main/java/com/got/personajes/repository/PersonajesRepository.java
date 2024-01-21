package com.got.personajes.repository;

import com.got.personajes.entity.Casa;
import com.got.personajes.entity.Personaje;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PersonajesRepository extends JpaRepository<Personaje, Long> {
    @Query("select p from Personaje p where p.casa = ?1")
    List<Personaje> findByCasa(Casa casa);
}
