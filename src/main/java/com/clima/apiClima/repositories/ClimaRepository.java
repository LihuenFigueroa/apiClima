package com.clima.apiClima.repositories;

import java.util.ArrayList;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.clima.apiClima.models.Clima;

@Repository
public interface ClimaRepository extends CrudRepository<Clima, Long> {

    public abstract ArrayList<Clima> findByTemperatura(Double temperatura);
}
