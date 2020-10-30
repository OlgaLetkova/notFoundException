package ru.netology.manager;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.domain.Movie;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class MovieManagerWithOneMovieTest {
    private MovieManager manager = new MovieManager();
    private Movie first = new Movie(1, "number-one", "Number one", "image URL", "comedy", true);
    private Movie second = new Movie(2, "trolls", "Trolls. World tour", "image URL", "animated cartoon", true);

    @BeforeEach
    public void setUp() {
        manager.add(first);
    }

    @Test
    public void shouldAddToAfishaWithOneMovie() {
        manager.add(second);
        Movie[] actual = manager.getAll();
        Movie[] expected = new Movie[]{second, first};
        assertArrayEquals(expected, actual);
    }
}



  /*  @Test
    public void shouldRemoveIfExists() {
        int idToRemove = 1;
        manager.removeById(idToRemove);

        Movie[] actual = manager.getAll();
        Movie[] expected = new Movie[]{third, second};

//    assertEquals(expected, actual);
        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldNotRemoveIfNotExists() {
        int idToRemove = 4;

        manager.removeById(idToRemove);

        Movie[] actual = manager.getAll();
        Movie[] expected = new Movie[]{third, second, first};

        assertArrayEquals(expected, actual);
    }*/
