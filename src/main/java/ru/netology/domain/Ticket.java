package ru.netology.domain;

import java.util.Objects;

public class Ticket implements Comparable<Ticket>{

    private int id;
    private int price;
    private String departureTerm;
    private String arrivalTerm;
    private int travelTime;

    public Ticket() {
    }

    public Ticket(int id, int price, String departureTerm, String arrivalTerm, int travelTime) {
        this.id = id;
        this.price = price;
        this.departureTerm = departureTerm;
        this.arrivalTerm = arrivalTerm;
        this.travelTime = travelTime;
    }


    @Override
    public int compareTo(Ticket o) {
        return price - o.price;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getDepartureTerm() {
        return departureTerm;
    }

    public void setDepartureTerm(String departureTerm) {
        this.departureTerm = departureTerm;
    }

    public String getArrivalTerm() {
        return arrivalTerm;
    }

    public void setArrivalTerm(String arrivalTerm) {
        this.arrivalTerm = arrivalTerm;
    }

    public int getTravelTime() {
        return travelTime;
    }

    public void setTravelTime(int travelTime) {
        this.travelTime = travelTime;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Ticket ticket = (Ticket) o;
        return id == ticket.id && price == ticket.price && travelTime == ticket.travelTime && departureTerm.equals(ticket.departureTerm) && arrivalTerm.equals(ticket.arrivalTerm);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, price, departureTerm, arrivalTerm, travelTime);
    }

    @Override
    public String toString() {
        return "Ticket{" +
                "id=" + id +
                ", price=" + price +
                ", departureTerm='" + departureTerm + '\'' +
                ", arrivalTerm='" + arrivalTerm + '\'' +
                ", travelTime=" + travelTime +
                '}';
    }

    public boolean matches(String from, String to) {
        return departureTerm.equalsIgnoreCase(from) && arrivalTerm.equalsIgnoreCase(to);
    }
}
