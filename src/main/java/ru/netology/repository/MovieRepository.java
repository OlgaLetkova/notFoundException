package ru.netology.repository;

import ru.netology.domain.Movie;

public class MovieRepository {

    private Movie[] items = new Movie[0];

    public void save(Movie item) {
        // создаём новый массив размером на единицу больше
        int length = items.length + 1;
        Movie[] tmp = new Movie[length];
        // itar + tab
        // копируем поэлементно
        // for (int i = 0; i < items.length; i++) {
        //   tmp[i] = items[i];
        // }
        System.arraycopy(items, 0, tmp, 0, items.length);
        // кладём последним наш элемент
        int lastIndex = tmp.length - 1;
        tmp[lastIndex] = item;
        items = tmp;
    }

    public Movie[] findAll() {
        return items;
    }

    public Movie findById(int id) {
        for (Movie item : items) {
            if (item.getId() == id) {
                return item;
            }
        }
        return null;
    }

    public void removeById(int id) {
        int length = items.length - 1;
        Movie[] tmp = new Movie[length];
        int index = 0;
        for (Movie item : items) {
            if (item.getId() != id) {
                tmp[index] = item;
                index++;
            }
        }
        // меняем наши элементы
        items = tmp;
    }

    public void removeAll() {
        Movie[] tmp = new Movie[0];
        items = tmp;
    }
}
