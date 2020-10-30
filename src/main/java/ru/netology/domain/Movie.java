package ru.netology.domain;

import lombok.AllArgsConstructor;

    @AllArgsConstructor

    public class Movie {
        private int id;
        private String movieId;
        private String name;
        private String imageUrl;
        private String genre;
        private boolean premiereTomorrow;
    }

