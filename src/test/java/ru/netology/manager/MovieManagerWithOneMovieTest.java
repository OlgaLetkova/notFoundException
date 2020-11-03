package ru.netology.manager;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import ru.netology.domain.Movie;
import ru.netology.repository.MovieRepository;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.doReturn;

@ExtendWith(MockitoExtension.class)

public class MovieManagerWithOneMovieTest {
    @Mock
    private MovieRepository repository;

    @InjectMocks
    private MovieManager manager;

    private Movie first = new Movie(1, "number-one", "Number one", "image URL", "comedy", true);
    private Movie second = new Movie(2, "trolls", "Trolls. World tour", "image URL", "animated cartoon", true);

    @Test
    public void shouldAddToAfishaWithOneMovie() {
        doNothing().when(repository).save(second);
        Movie[] returned = new Movie[]{first,second};
        doReturn(returned).when(repository).findAll();
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
