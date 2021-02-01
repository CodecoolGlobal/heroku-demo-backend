package com.example.demo.dto;

import com.example.demo.entity.Hero;

import static java.lang.Math.toIntExact;

public class HeroDto {

    public int id;

    public String name;

    public HeroDto() {
    }

    public static HeroDto fromHero(Hero hero) {
        return new HeroDto(toIntExact(hero.getId()), hero.getName());
    }

    private HeroDto(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
