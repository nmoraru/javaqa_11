package ru.netology.manager;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import ru.netology.domain.Film;
import ru.netology.repository.FilmRepository;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class AfishaManagerTest {
    @Mock
    FilmRepository repository;

    @InjectMocks
    AfishaManager manager = new AfishaManager(7);
    Film film1 = new Film(1, "Достучаться до небес", "мелодрамма", "http://test.jpg", 1997);
    Film film2 = new Film(2, "Назад в будущее", "фантастика", "http://test.jpg", 1985);
    Film film3 = new Film(3, "Кин-дза-дза", "комедия", "http://test.jpg", 1986);
    Film film4 = new Film(4, "1+1", "мелодрамма", "http://test.jpg", 2011);
    Film film5 = new Film(5, "О мышах и людях", "мелодрамма", "http://test.jpg", 1992);


    @Test
    void shouldAdd() {
        doReturn(new Film[]{film1}).when(repository).findAll();
        doNothing().when(repository).save(film1);

        Film[] expected = new Film[]{film1};
        manager.add(film1);
        assertArrayEquals(expected, manager.getFilms());
        verify(repository, times(1)).save(film1);

    }

    @Test
    void shouldReturnLessThenAddByDefault() {
        Film[] toBeReturned = {film2, film3, film4, film5};
        doReturn(toBeReturned).when(repository).findAll();

        Film[] expected = new Film[]{film5, film4, film3, film2};

        assertArrayEquals(expected, manager.getFilms());
        verify(repository).findAll();
    }

    @Test
    void shouldGetFilms() {
        Film[] toBeReturned = {film1, film2};
        doReturn(toBeReturned).when(repository).findAll();

        Film[] expected = new Film[]{film2, film1};
        manager.add(film1);
        manager.add(film2);

        assertArrayEquals(expected, manager.getFilms());
    }

}
