package ru.netology.repository;

import org.junit.jupiter.api.Test;
import ru.netology.domain.Movie;

import static org.junit.jupiter.api.Assertions.*;

class MovieRepositoryEmptyTest {

    @Test
    void save() {
        MovieRepository repository = new MovieRepository();
        Movie first = new Movie(1, "number-one", "Number one", "image URL", "comedy", true);
        repository.save(first);
        Movie[] actual = repository.findAll();
        Movie[] expected = new Movie[]{first};
        assertArrayEquals(expected, actual);
    }


    @Test
    void findAll() {
        MovieRepository repository = new MovieRepository();
        Movie[] actual = repository.findAll();
        Movie[] expected = new Movie[0];
        assertArrayEquals(expected, actual);
    }
}