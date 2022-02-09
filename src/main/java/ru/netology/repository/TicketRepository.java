package ru.netology.repository;

import ru.netology.domain.Ticket;

public class TicketRepository {
    private Ticket[] tkt = new Ticket[0];

    public void add(Ticket ticket) {
        int length = tkt.length + 1;
        Ticket[] tmp = new Ticket[length];
        System.arraycopy(tkt, 0, tmp, 0, tkt.length);
        int lastIndex = tmp.length - 1;
        tmp[lastIndex] = ticket;
        tkt = tmp;
    }

    public void removeById(int id) {
        int length = tkt.length - 1;
        Ticket[] tmp = new Ticket[length];
        int index = 0;
        for (Ticket ticket : tkt) {
            if (ticket.getId() != id) {
                tmp[index] = ticket;
                index++;
            }
        }
        tkt = tmp;
    }

    public Ticket[] findAll() {
        return tkt;
    }
}
