package com.got.personajes.repository;

import com.got.personajes.entity.Mascota;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MascotasRepository extends JpaRepository<Mascota, Long> {
}
