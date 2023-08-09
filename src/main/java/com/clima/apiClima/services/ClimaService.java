package com.clima.apiClima.services;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.clima.apiClima.repositories.ClimaRepository;
import com.clima.apiClima.models.Clima;

@Service
public class ClimaService {

    @Autowired
    ClimaRepository climaRepository;

    public ArrayList<Clima> obtenerClimas() {
        return (ArrayList<Clima>) climaRepository.findAll();
    }

    public Clima guardarClima(Clima unClima) {
        return climaRepository.save(unClima);
    }

    public Optional<Clima> obtenerPorId(Long id) {
        return climaRepository.findById(id);
    }

    public ArrayList<Clima> obtenerPorTemperatura(Double temperatura) {
        return climaRepository.findByTemperatura(temperatura);
    }

    public boolean eliminarClima(Long id) {
        try {
            climaRepository.deleteById(id);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
