package com.example.demo;

import com.example.demo.entity.Hero;
import com.example.demo.repository.HeroRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.Arrays;
import java.util.List;

import static org.springframework.boot.SpringApplication.run;

@SpringBootApplication
public class BackendApplication {

    private final HeroRepository heroRepository;

    public BackendApplication(HeroRepository heroRepository) {
        this.heroRepository = heroRepository;
    }

    public static void main(String[] args) {
        run(BackendApplication.class, args);
    }

    @Bean
    public CommandLineRunner runner() {
        return (args) -> {
            heroRepository.saveAll(createHeroes());
        };
    }

    private List<Hero> createHeroes() {
        return Arrays.asList(
                new Hero(1, "Batman"),
                new Hero(2, "Superman"),
                new Hero(3, "Wiedźman"),
                new Hero(4, "Hero")
        );
    }


}
