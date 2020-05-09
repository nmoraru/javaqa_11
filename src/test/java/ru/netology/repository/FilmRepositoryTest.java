package ru.netology.repository;

import org.junit.jupiter.api.Test;
import ru.netology.domain.Film;
import ru.netology.manager.AfishaManager;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class FilmRepositoryTest {
    FilmRepository repository = new FilmRepository();
    Film film1 = new Film(1, "Достучаться до небес", "мелодрамма", "http://test.jpg", 1997);
    Film film2 = new Film(2, "Назад в будущее", "фантастика", "http://test.jpg", 1985);
    Film film3 = new Film(3, "Кин-дза-дза", "комедия", "http://test.jpg", 1986);
    Film film4 = new Film(4, "1+1", "мелодрамма", "http://test.jpg", 2011);
    Film film5 = new Film(5, "О мышах и людях", "мелодрамма", "http://test.jpg", 1992);


    @Test
    void shoulSave() {
        Film[] expected = new Film[]{film1};
        repository.save(film1);
        assertArrayEquals(expected, repository.findAll());

    }

    @Test
    void shouldReturn() {
        Film[] expected = new Film[]{film1, film2, film3, film4, film5};
        repository.save(film1);
        repository.save(film2);
        repository.save(film3);
        repository.save(film4);
        repository.save(film5);

        assertArrayEquals(expected, repository.findAll());
    }

    @Test
    void shouldReturnEmptyArray() {
        assertArrayEquals(new Film[0], repository.findAll());
    }

}
