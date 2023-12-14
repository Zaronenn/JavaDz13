package ru.netology.tickets;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.tickets.AviaSouls;
import ru.netology.tickets.Ticket;
import ru.netology.tickets.TicketTimeComparator;

import java.util.Arrays;

public class AviaSoulsTest {
    AviaSouls aviaSouls = new AviaSouls();
    Ticket ticket1 = new Ticket("Moscow", "Saint- Petersburg", 17000, 9_00, 10_00);
    Ticket ticket2 = new Ticket("Moscow", "Saint- Petersburg", 9000, 8_00, 14_00);
    Ticket ticket3 = new Ticket("Moscow", "Saint- Petersburg", 12000, 7_00, 9_00);
    Ticket ticket4 = new Ticket("Moscow", "Saint- Petersburg", 10000, 14_00, 17_00);
    Ticket ticket5 = new Ticket("Moscow", "Saint- Petersburg", 7000, 15_00, 19_00);

    @BeforeEach
    public void setAviaSouls() {
        aviaSouls.add(ticket1);
        aviaSouls.add(ticket2);
        aviaSouls.add(ticket3);
        aviaSouls.add(ticket4);
        aviaSouls.add(ticket5);
    }

    @Test
    public void shouldFindAllTickets() {
        Ticket[] expected = {ticket1, ticket2, ticket3, ticket4, ticket5};
        Ticket[] actual = aviaSouls.findAll();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void compareToMost() {
        Assertions.assertEquals(-1, ticket5.compareTo(ticket1));
    }

    @Test
    public void compareToLeast() {
        Assertions.assertEquals(1, ticket2.compareTo(ticket5));
    }

    @Test
    public void sortByTime() {
        TicketTimeComparator comparator = new TicketTimeComparator();

        Ticket[] expected = {ticket1, ticket3, ticket4, ticket5, ticket2};
        Ticket[] actual = aviaSouls.searchAndSortBy("Moscow", "Saint- Petersburg", comparator);

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldFindOneTicket() {
        AviaSouls souls = new AviaSouls();

        souls.add(ticket1);

        Ticket[] expected = {ticket1};
        Ticket[] actual = souls.search("Moscow", "Saint- Petersburg");

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldNotFindTickets() {
        AviaSouls souls = new AviaSouls();

        Ticket[] expected = {};
        Ticket[] actual = souls.search("Moscow", "Saint- Petersburg");

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldFindSomeTickets() {
        AviaSouls souls = new AviaSouls();

        souls.add(ticket1);
        souls.add(ticket2);
        souls.add(ticket3);


        Ticket[] expected = {ticket2, ticket3, ticket1};
        Ticket[] actual = souls.search("Moscow", "Saint- Petersburg");

        Assertions.assertArrayEquals(expected, actual);
    }
}