package com.clima.apiClima.controllers;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.clima.apiClima.models.Clima;
import com.clima.apiClima.services.ClimaService;

@RestController
@RequestMapping("/clima")
public class ClimaController {

    @Autowired
    ClimaService climaService;

    @GetMapping
    public ArrayList<Clima> obtenerClimas() {
        return climaService.obtenerClimas();
    }

    @PostMapping
    public Clima guardarClima(@RequestBody Clima unClima) {
        return climaService.guardarClima(unClima);
    }

    @GetMapping(path = "/{id}")
    public Optional<Clima> obtenerPorId(@PathVariable("id") Long id) {
        return climaService.obtenerPorId(id);
    }

    @GetMapping(path = "/query")
    public ArrayList<Clima> obtenerPorTemperatura(@RequestParam("temperatura") Double temperatura) {
        return climaService.obtenerPorTemperatura(temperatura);
    }

    @DeleteMapping(path = "/{id}")
    public String eliminarPorId(@PathVariable("id") Long id) {
        boolean ok = climaService.eliminarClima(id);
        if (ok) {
            return "Se elimino el clima con id : " + id;
        } else {
            return "No se pudo eliminar clima con id : " + id;
        }
    }

}
