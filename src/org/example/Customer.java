package org.example;

import java.util.ArrayList;
import java.util.List;

public class Customer {

    private String name;
    private List<Ticket> tickets;

    public Customer(String name) {
        this.name = name;
        this.tickets = new ArrayList<>();
    }

    public void addTicket(Ticket ticket) {
        tickets.add(ticket);
    }

    public void printTickets() {
        System.out.println("\nTickets of customer: " + name);

        for (Ticket ticket : tickets) {
            System.out.println(ticket);
        }
    }

    public String getName() {
        return name;
    }

    public List<Ticket> getTickets() {
        return tickets;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setTickets(List<Ticket> tickets) {
        this.tickets = tickets;
    }
}