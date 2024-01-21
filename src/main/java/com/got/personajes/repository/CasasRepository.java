package com.got.personajes.repository;

import com.got.personajes.entity.Casa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CasasRepository extends JpaRepository<Casa, Long> {
}
