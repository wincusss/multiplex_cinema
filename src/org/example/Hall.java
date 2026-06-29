package org.example;

import java.util.ArrayList;
import java.util.List;

public class Hall {

    private String name;
    private List<Seat> seats;

    public Hall(String name) {
        this.name = name;
        this.seats = new ArrayList<>();
    }

    public void addSeat(Seat seat) {
        seats.add(seat);
    }

    public Seat findSeat(String number) {
        for (Seat seat : seats) {
            if (seat.getNumber().equalsIgnoreCase(number)) {
                return seat;
            }
        }
        return null;
    }

    public boolean hasSeat(Seat seat) {
        return seats.contains(seat);
    }

    public String getName() {
        return name;
    }

    public List<Seat> getSeats() {
        return seats;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSeats(List<Seat> seats) {
        this.seats = seats;
    }
}