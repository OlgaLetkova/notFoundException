package ru.netology.manager;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import ru.netology.domain.Movie;
import ru.netology.repository.MovieRepository;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.doReturn;

@ExtendWith(MockitoExtension.class)

public class MovieManagerEmptyTest {
    @Mock
    private MovieRepository repository;
    @InjectMocks
    private MovieManager manager;
    Movie first = new Movie(1, "number-one", "Number one", "image URL", "comedy", true);
    @Test
    public void shouldAddToEmptyAfisha() {
        doNothing().when(repository).save(first);
        Movie[] returned = new Movie[]{first};
        doReturn(returned).when(repository).findAll();
        manager.add(first);
        Movie[] actual = manager.getAll();
        Movie[] expected = new Movie[]{first};
        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldGetEmptyAfisha() {
        Movie[] returned = new Movie[0];
        doReturn(returned).when(repository).findAll();
        Movie[] actual = manager.getAll();
        Movie[] expected = new Movie[0];
        assertArrayEquals(expected, actual);
    }
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
