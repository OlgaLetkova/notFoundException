package ru.netology.domain;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
    @Data

    public class Movie {
        private int id;
        private String movieId;
        private String name;
        private String imageUrl;
        private String genre;
        private boolean premiereTomorrow;
    }

