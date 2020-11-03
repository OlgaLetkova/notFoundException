package ru.netology.manager;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import ru.netology.domain.Movie;
import ru.netology.repository.MovieRepository;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.doReturn;

@ExtendWith(MockitoExtension.class)
class MovieManagerWithMaxQuantityOfMovieTest {
    @Mock
    private MovieRepository repository;
    @InjectMocks
    private MovieManager manager;

    private Movie first = new Movie(1, "number-one", "Number one", "image URL", "comedy", true);
    private Movie second = new Movie(2, "trolls", "Trolls. World tour", "image URL", "animated cartoon", true);
    private Movie third = new Movie(3, "invisible-man", "Invisible-Man", "image URL", "horrors", false);
    private Movie fourth = new Movie(4, "gentlemen", "Gentlemen", "image URL", "thriller", false);
    private Movie fifth = new Movie(5, "hotel-Belgrade", "Hotel Belgrade", "image URL", "comedy", false);
    private Movie sixth = new Movie(6, "forward", "Forward", "image URL", "animated cartoon", false);


    @Test
     public void shouldGetFullAfisha() {
        Movie[] returned = new Movie[]{first,second, third,fourth};
        doReturn(returned).when(repository).findAll();
        Movie[] actual = manager.getAll();
        Movie[] expected = new Movie[]{fourth, third, second, first};
        assertArrayEquals(expected, actual);

    }

    @Test
    public void getLastOverLimit() {
        manager.setRequestSize(5);
        Movie[] returned = new Movie[]{first,second, third,fourth,fifth,sixth};
        doReturn(returned).when(repository).findAll();
        Movie[] actual = manager.getLast();
        Movie[] expected = new Movie[]{sixth, fifth, fourth, third, second};
        assertArrayEquals(expected, actual);
    }

    @Test
    public void getLastUnderLimit() {
        Movie[] returned = new Movie[]{first,second, third,fourth};
        doReturn(returned).when(repository).findAll();
        Movie[] actual = manager.getLast();
        Movie[] expected = new Movie[]{fourth, third, second, first};
        assertArrayEquals(expected, actual);
    }
}
