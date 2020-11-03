package ru.netology.repository;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.domain.Movie;

import static org.junit.jupiter.api.Assertions.*;

class MovieRepositoryWithOneMovieTest {
    private MovieRepository repository = new MovieRepository();
    private Movie first = new Movie(1, "number-one", "Number one", "image URL", "comedy", true);
    private Movie second = new Movie(2, "trolls", "Trolls. World tour", "image URL", "animated cartoon", true);

    @BeforeEach
    public void setUp() {
        repository.save(first);
    }

    @Test
    void save() {
        repository.save(second);
        Movie[] actual = repository.findAll();
        Movie[] expected = new Movie[]{first, second};
        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldRemoveIfExists() {
        int idToRemove = 1;
        repository.removeById(idToRemove);
        Movie[] actual = repository.findAll();
        Movie[] expected = new Movie[0];
        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldNotRemoveIfNotExists() {
        int idToRemove = 4;
        repository.removeById(idToRemove);

        Movie[] actual = repository.findAll();
        Movie[] expected = new Movie[]{first};

        assertArrayEquals(expected, actual);
    }

    @Test
    void removeAll() {
        repository.removeAll();
        Movie[] actual = repository.findAll();
        Movie[] expected = new Movie[0];
        assertArrayEquals(expected, actual);
    }
}