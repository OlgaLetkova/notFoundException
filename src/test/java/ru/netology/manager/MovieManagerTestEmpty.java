package ru.netology.manager;

import org.junit.jupiter.api.Test;
import ru.netology.domain.Movie;

import static org.junit.jupiter.api.Assertions.*;

public class MovieManagerTestEmpty {

    @Test
    public void shouldAddToEmptyAfisha() {
        MovieManager manager = new MovieManager();
        Movie first = new Movie(1,"number-one", "Number one", "image URL", "comedy", true);
        manager.add(first);
        Movie[] actual = manager.getAll();
        Movie[] expected = new Movie[]{first};
        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldGetEmptyAfisha(){
        MovieManager manager = new MovieManager();
        Movie[] actual = manager.getAll();
        Movie[] expected = new Movie[0];
        assertArrayEquals(expected, actual);
    }


    /*@Test
    public void shouldRemoveIfExists() {
        MovieManager manager = new MovieManager();
        int idToRemove = 1;
        Movie first = new Movie(1, 1, "first", 1, 1);
        Movie second = new Movie(2, 2, "second", 1, 1);
        Movie third = new Movie(3, 3, "third", 1, 1);
        manager.add(first);
        manager.add(second);
        manager.add(third);

        manager.removeById(idToRemove);

        Movie[] actual = manager.getAll();
        Movie[] expected = new Movie[]{third, second};

//    assertEquals(expected, actual);
        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldNotRemoveIfNotExists() {
        MovieManager manager = new MovieManager();
        int idToRemove = 4;
        Movie first = new Movie(1, 1, "first", 1, 1);
        Movie second = new Movie(2, 2, "second", 1, 1);
        Movie third = new Movie(3, 3, "third", 1, 1);
        manager.add(first);
        manager.add(second);
        manager.add(third);

        manager.removeById(idToRemove);

        Movie[] actual = manager.getAll();
        Movie[] expected = new Movie[]{third, second, first};

        assertArrayEquals(expected, actual);
    }*/

}