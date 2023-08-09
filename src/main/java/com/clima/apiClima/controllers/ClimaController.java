package com.clima.apiClima.controllers;

import java.util.ArrayList;
import java.util.Optional;

import javax.print.attribute.standard.MediaTray;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.configurationprocessor.json.JSONException;
import org.springframework.boot.configurationprocessor.json.JSONObject;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.clima.apiClima.models.Clima;
import com.clima.apiClima.services.ClimaService;
import com.fasterxml.jackson.databind.util.JSONPObject;

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

    @GetMapping(value = "/getForecast", produces = MediaType.APPLICATION_JSON_VALUE)
    public String getForeCast() throws JSONException {
        String uri = "http://dataservice.accuweather.com/currentconditions/v1/349727?apikey=WTcU6za9qLVZh7ZqSkseHQYsWdbABtQh";
        RestTemplate restTemplate = new RestTemplate();
        String result = restTemplate.getForObject(uri, String.class);
        return result;
    }

}
