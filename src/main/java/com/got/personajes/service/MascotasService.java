package com.got.personajes.service;

import com.got.personajes.entity.Mascota;
import com.got.personajes.repository.MascotasRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MascotasService {
    @Autowired
    MascotasRepository mascotasRepository;

    public List<Mascota> findAll() {
        return mascotasRepository.findAll();
    }

    public Optional<Mascota> findById(final Long id) {
        return mascotasRepository.findById(id);
    }

    public Mascota add(final Mascota mascotaNuevo) {
        return mascotasRepository.save(mascotaNuevo);
    }

    public Optional<Mascota> update(final Long id, final Mascota mascota) {
        Optional<Mascota> mascotaEncontrado = mascotasRepository.findById(id);

        if (mascotaEncontrado.isPresent()) {
            return Optional.of(mascotasRepository.save(mascota));
        }

        return mascotaEncontrado;
    }

    public Optional<Mascota> delete(final Long id) {
        Optional<Mascota> mascotaEncontrado = mascotasRepository.findById(id);

        mascotaEncontrado.ifPresent(mascota -> mascotasRepository.delete(mascota));

        return mascotaEncontrado;
    }
}
