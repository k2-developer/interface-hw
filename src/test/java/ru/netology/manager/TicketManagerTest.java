package ru.netology.manager;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.domain.Ticket;
import ru.netology.repository.TicketRepository;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class TicketManagerTest {

    private TicketRepository repository = new TicketRepository();
    private TicketManager manager = new TicketManager(repository);

    private Ticket first = new Ticket(1, 100, "LED", "VNU", 60);
    private Ticket second = new Ticket(2, 200, "BCN", "LED", 70);
    private Ticket third = new Ticket(3, 150, "LED", "DME", 80);
    private Ticket fourth = new Ticket(4, 400, "VNU", "LED", 90);
    private Ticket fifth = new Ticket(5, 500, "SVO", "LED", 100);
    private Ticket sixth = new Ticket(6, 600, "LED", "BCN", 110);
    private Ticket seventh = new Ticket(7, 700, "VKO", "LED", 120);
    private Ticket eighth = new Ticket(8, 800, "LED", "DME", 130);
    private Ticket ninth = new Ticket(9, 900, "DME", "VKO", 140);
    private Ticket tenth = new Ticket(10, 1000, "LED", "DME", 150);

    @BeforeEach
    public void setUp() {
        manager.add(first);
        manager.add(second);
        manager.add(third);
        manager.add(fourth);
        manager.add(fifth);
        manager.add(sixth);
        manager.add(seventh);
        manager.add(eighth);
        manager.add(ninth);
        manager.add(tenth);
    }

    @Test
    public void shouldPriceSort() {
        Ticket[] expected = new Ticket[]{first, third, second, fourth, fifth, sixth, seventh, eighth, ninth, tenth};
        Ticket[] actual = repository.findAll();
        Arrays.sort(actual);
        assertArrayEquals(expected,actual);
    }

    @Test
    public void shouldFindFromTo() {
        Ticket[] actual = manager.findAll("LED", "dmE");
        Ticket[] expected = new Ticket[]{third, eighth, tenth};
        assertArrayEquals(actual, expected);
    }

    @Test
    public void shouldFindNoOne() {
        Ticket[] actual = manager.findAll("BCN", "DME");
        Ticket[] expected = new Ticket[]{};
        assertArrayEquals(actual, expected);
    }

}