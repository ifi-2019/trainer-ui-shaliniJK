package com.ifi.trainer_ui.pokemonTypes.service;

import com.ifi.trainer_ui.pokemonTypes.bo.PokemonType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class PokemonTypeServiceImpl implements PokemonTypeService {

    @Autowired
    private RestTemplate restTemplate;

    private String pokemonServiceUrl;

    @Autowired
    public PokemonTypeServiceImpl () {

    }

    public List<PokemonType> listPokemonsTypes() {
        PokemonType[] pokemons = restTemplate.getForObject(pokemonServiceUrl + "/pokemon-types/", PokemonType[].class);
        List<PokemonType> pokemonTypeList = new ArrayList<>(Arrays.asList(pokemons));
        return pokemonTypeList;
    }

    @Autowired
    void setRestTemplate(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @Value("${pokemonType.service.url}")
    void setPokemonTypeServiceUrl(String pokemonServiceUrl) {
        this.pokemonServiceUrl = pokemonServiceUrl;
    }

}
