package org.example;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Screening {

    private Movie movie;
    private Hall hall;
    private LocalDateTime dateTime;

    private boolean vip;
    private boolean threeD;

    private List<Seat> reservedSeats;
    private List<Seat> soldSeats;

    public Screening(Movie movie, Hall hall, LocalDateTime dateTime, boolean vip, boolean threeD) {
        this.movie = movie;
        this.hall = hall;
        this.dateTime = dateTime;
        this.vip = vip;
        this.threeD = threeD;
        this.reservedSeats = new ArrayList<>();
        this.soldSeats = new ArrayList<>();
    }

    public void reservePlaces(String... seatNumbers) {
        for (String seatNumber : seatNumbers) {
            Seat seat = hall.findSeat(seatNumber);

            if (seat != null) {
                reserveOneSeat(seat);
            } else {
                System.out.println("Seat does not exist: " + seatNumber);
            }
        }
    }

    public void reservePlaces(Seat... seats) {
        for (Seat seat : seats) {
            reserveOneSeat(seat);
        }
    }

    public void reservePlaces(Customer customer, String... seatNumbers) {
        reservePlaces(seatNumbers);
        System.out.println("Reservation assigned to customer: " + customer.getName());
    }

    public Ticket buyTicket(String seatNumber, Customer customer) {
        Seat seat = hall.findSeat(seatNumber);

        if (seat == null) {
            System.out.println("Seat does not exist: " + seatNumber);
            return null;
        }

        if (soldSeats.contains(seat)) {
            System.out.println("Seat is already sold: " + seat);
            return null;
        }

        soldSeats.add(seat);
        reservedSeats.remove(seat);

        Ticket ticket = new Ticket(movie, seat, customer);

        if (customer != null) {
            customer.addTicket(ticket);
        }

        System.out.println("Bought ticket for seat: " + seat);

        return ticket;
    }

    private void reserveOneSeat(Seat seat) {
        if (!hall.hasSeat(seat)) {
            System.out.println("Seat does not exist in this hall: " + seat);
            return;
        }

        if (reservedSeats.contains(seat) || soldSeats.contains(seat)) {
            System.out.println("Seat is not available: " + seat);
            return;
        }

        reservedSeats.add(seat);
        System.out.println("Reserved seat: " + seat);
    }

    public Movie getMovie() {
        return movie;
    }

    public Hall getHall() {
        return hall;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public boolean isVip() {
        return vip;
    }

    public boolean isThreeD() {
        return threeD;
    }

    public List<Seat> getReservedSeats() {
        return reservedSeats;
    }

    public List<Seat> getSoldSeats() {
        return soldSeats;
    }

    public void setMovie(Movie movie) {
        this.movie = movie;
    }

    public void setHall(Hall hall) {
        this.hall = hall;
    }

    public void setDateTime(LocalDateTime dateTime) {
        this.dateTime = dateTime;
    }

    public void setVip(boolean vip) {
        this.vip = vip;
    }

    public void setThreeD(boolean threeD) {
        this.threeD = threeD;
    }

    public void setReservedSeats(List<Seat> reservedSeats) {
        this.reservedSeats = reservedSeats;
    }

    public void setSoldSeats(List<Seat> soldSeats) {
        this.soldSeats = soldSeats;
    }

    @Override
    public String toString() {
        return movie + ", hall: " + hall.getName()
                + ", date: " + dateTime
                + (vip ? ", VIP" : "")
                + (threeD ? ", 3D" : "");
    }
}