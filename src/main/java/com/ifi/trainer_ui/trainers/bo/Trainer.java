package com.ifi.trainer_ui.trainers.bo;

import com.ifi.trainer_ui.pokemonTypes.bo.PokemonType;

import java.util.List;

public class Trainer {

    private String name;

    private String password;

    private List<PokemonType> team;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<PokemonType> getTeam() {
        return team;
    }

    public void setTeam(List<PokemonType> team) {
        this.team = team;
    }

    public String getPassword() {
        return password;
    }
}

