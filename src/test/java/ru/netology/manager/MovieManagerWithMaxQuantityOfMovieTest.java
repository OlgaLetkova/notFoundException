package ru.netology.manager;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.domain.Movie;

import static org.junit.jupiter.api.Assertions.*;

class MovieManagerWithMaxQuantityOfMovieTest {

    private MovieManager manager = new MovieManager(5);
    private Movie first = new Movie(1, "number-one", "Number one", "image URL", "comedy", true);
    private Movie second = new Movie(2, "trolls", "Trolls. World tour", "image URL", "animated cartoon", true);
    private Movie third = new Movie(3, "invisible-man", "Invisible-Man", "image URL", "horrors", false);
    private Movie fourth = new Movie(4, "gentlemen", "Gentlemen", "image URL", "thriller", false);
    private Movie fifth = new Movie(5, "hotel-Belgrade", "Hotel Belgrade", "image URL", "comedy", false);
    private Movie sixth = new Movie(6, "forward", "Forward", "image URL", "animated cartoon", false);

    @BeforeEach
    public void setUp() {
        manager.add(first);
        manager.add(second);
        manager.add(third);
        manager.add(fourth);
    }

    @Test
    public void shouldGetFullAfisha() {
        Movie[] actual = manager.getAll();
        Movie[] expected = new Movie[]{fourth, third, second, first};
        assertArrayEquals(expected, actual);
    }

    @Test
    public void getLastOverLimit() {
        manager.add(fifth);
        manager.add(sixth);
        Movie[] actual = manager.getLast();
        Movie[] expected = new Movie[]{sixth, fifth, fourth, third, second};
        assertArrayEquals(expected, actual);
    }

    @Test
    public void getLastUnderLimit() {
        Movie[] actual = manager.getLast();
        Movie[] expected = new Movie[]{fourth, third, second, first};
        assertArrayEquals(expected, actual);
    }
}
