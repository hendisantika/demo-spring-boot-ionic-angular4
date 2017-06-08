package com.hendisantika.beer;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.stream.Stream;

/**
 * Created by hendisantika on 6/6/17.
 */
@Component
public class BeerCommandLineRunner implements CommandLineRunner {
    private final BeerRepository repository;

    public BeerCommandLineRunner(BeerRepository repository) {
        this.repository = repository;
    }

    @Override
    public void run(String... strings) throws Exception {
        // Top beers from https://www.beeradvocate.com/lists/top/
        Stream.of("Kentucky Brunch Brand Stout", "Good Morning", "Very Hazy", "King Julius",
                "Budweiser", "Coors Light", "PBR").forEach(name ->
                repository.save(new Beer(name))
        );
        repository.findAll().forEach(System.out::println);
    }

}
