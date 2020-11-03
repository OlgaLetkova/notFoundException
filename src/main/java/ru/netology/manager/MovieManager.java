package ru.netology.manager;

import ru.netology.domain.Movie;
import ru.netology.repository.MovieRepository;

public class MovieManager {
    private int requestSize = 10;
    private MovieRepository repository;

    public MovieManager() {
    }

    public MovieManager(int requestSize) {
        this.requestSize = requestSize;
    }


    public MovieManager(MovieRepository repository) {
        this.repository = repository;
    }

    public void setRequestSize(int requestSize) {
        this.requestSize = requestSize;
    }

    public void add(Movie item) {
        this.repository.save(item);
    }

    public Movie[] getAll() {
        Movie[] items = this.repository.findAll();
        Movie[] result = new Movie[items.length];
        for (int i = 0; i < result.length; i++) {
            int index = items.length - i - 1;
            result[i] = items[index];
        }
        return result;
    }

    public Movie[] getLast() {
        Movie[] items = this.repository.findAll();
        int length = 0;
        if (items.length >= this.requestSize) {
            length = this.requestSize;
        } else {
            length = items.length;
        }
        Movie[] movies = new Movie[length];
        for (int i = 0; i < movies.length; i++) {
            int index = items.length - i - 1;
            movies[i] = items[index];
        }
        return movies;
    }
}




