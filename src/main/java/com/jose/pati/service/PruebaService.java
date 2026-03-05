package com.jose.pati.service;

import com.jose.pati.model.Prueba;
import com.jose.pati.repository.PruebaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PruebaService {

    private final PruebaRepository repository;

    public Prueba crear(Prueba prueba) {
        return repository.save(prueba);
    }

    public List<Prueba> listar() {
        return repository.findAll();
    }
}
