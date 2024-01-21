package com.got.personajes.service;

import com.got.personajes.entity.Casa;
import com.got.personajes.repository.CasasRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CasasService {
    @Autowired
    CasasRepository casasRepository;

    public List<Casa> findAll() {
        return casasRepository.findAll();
    }

    public Optional<Casa> findById(final Long id) {
        return casasRepository.findById(id);
    }

    public Casa add(final Casa casaNuevo) {
        return casasRepository.save(casaNuevo);
    }

    public Optional<Casa> update(final Long id, final Casa casa) {
        Optional<Casa> casaEncontrado = casasRepository.findById(id);

        if (casaEncontrado.isPresent()) {
            return Optional.of(casasRepository.save(casa));
        }

        return casaEncontrado;
    }

    public Optional<Casa> delete(final Long id) {
        Optional<Casa> casaEncontrado = casasRepository.findById(id);

        casaEncontrado.ifPresent(casa -> casasRepository.delete(casa));

        return casaEncontrado;
    }
}
