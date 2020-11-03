package ru.netology.repository;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.domain.Movie;

import static org.junit.jupiter.api.Assertions.*;

class MovieRepositoryWithFewMoviesTest {

    private MovieRepository repository = new MovieRepository();
    private Movie first = new Movie(1, "number-one", "Number one", "image URL", "comedy", true);
    private Movie second = new Movie(2, "trolls", "Trolls. World tour", "image URL", "animated cartoon", true);
    private Movie third = new Movie(3, "invisible-man", "Invisible-Man", "image URL", "horrors", false);
    private Movie fourth = new Movie(4, "gentlemen", "Gentlemen", "image URL", "thriller", false);
    private Movie fifth = new Movie(5, "hotel-Belgrade", "Hotel Belgrade", "image URL", "comedy", false);

    @BeforeEach
    public void setUp() {
        repository.save(first);
        repository.save(second);
        repository.save(third);
        repository.save(fourth);
    }

    @Test
    void save() {
        repository.save(fifth);
        Movie[] actual = repository.findAll();
        Movie[] expected = new Movie[]{first, second, third, fourth, fifth};
        assertArrayEquals(expected, actual);
    }

    @Test
    void findAll() {
        Movie[] actual = repository.findAll();
        Movie[] expected = new Movie[]{first, second, third, fourth};
        assertArrayEquals(expected, actual);
    }

    @Test
    void findByExistId() {
        int idToFind = 2;
        Movie actual = repository.findById(idToFind);
        Movie expected = second;
        assertEquals(expected, actual);
    }

    @Test
    void findByNonExistId() {
        int idToFind = 7;
        Movie actual = repository.findById(idToFind);
        assertNull(actual);
    }

    @Test
    void removeAll() {
        repository.removeAll();
        Movie[] actual = repository.findAll();
        Movie[] expected = new Movie[0];
        assertArrayEquals(expected, actual);
    }
}