package com.example.demo.controller;

import com.example.demo.dto.HeroDto;
import com.example.demo.entity.Hero;
import com.example.demo.service.HeroService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

import static java.util.stream.Collectors.toList;

@RestController
@RequestMapping("/heroes")
public class HeroController {

    private final HeroService heroService;

    public HeroController(HeroService heroService) {
        this.heroService = heroService;
    }

    @GetMapping
    public List<HeroDto> getAllHeroes() {
        return toHeroDtos(heroService.getAllHeroes());
    }

    @GetMapping("/{id}")
    public HeroDto getHeroById(@PathVariable Long id) {
        Optional<Hero> maybeHero = heroService.getHeroById(id);

        return maybeHero
                .map(HeroDto::fromHero)
                .orElseGet(HeroDto::new);
    }

    private List<HeroDto> toHeroDtos(List<Hero> heroes) {
        return heroes.stream()
                .map(HeroDto::fromHero)
                .collect(toList());
    }
}
