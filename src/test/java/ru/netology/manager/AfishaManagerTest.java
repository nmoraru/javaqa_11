package ru.netology.manager;

import org.junit.jupiter.api.Test;
import ru.netology.domain.Film;

import static org.junit.jupiter.api.Assertions.*;

class AfishaManagerTest {
    AfishaManager manager = new AfishaManager(4);
    Film film1 = new Film(1, "Достучаться до небес", "мелодрамма", "http://test.jpg", 1997);
    Film film2 = new Film(2, "Назад в будущее", "фантастика", "http://test.jpg", 1985);
    Film film3 = new Film(3, "Кин-дза-дза", "комедия", "http://test.jpg", 1986);
    Film film4 = new Film(4, "1+1", "мелодрамма", "http://test.jpg", 2011);
    Film film5 = new Film(5, "О мышах и людях", "мелодрамма", "http://test.jpg", 1992);


    @Test
    void shouldAdd() {
        Film[] expected = new Film[]{film1};
        manager.add(film1);
        assertArrayEquals(expected, manager.getFilms());

    }

    @Test
    void shouldReturnLessThenAddByDefault() {
        Film[] expected = new Film[]{film5, film4, film3, film2};
        manager.add(film1);
        manager.add(film2);
        manager.add(film3);
        manager.add(film4);
        manager.add(film5);

        assertArrayEquals(expected, manager.getFilms());
    }

    @Test
    void shouldReturnEmptyArray() {
        assertArrayEquals(new Film[0], manager.getFilms());
    }

}