package org.example;

public class Ticket {

    private Movie movie;
    private Seat seat;
    private Customer customer;

    public Ticket(Movie movie, Seat seat, Customer customer) {
        this.movie = movie;
        this.seat = seat;
        this.customer = customer;
    }

    public Movie getMovie() {
        return movie;
    }

    public Seat getSeat() {
        return seat;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setMovie(Movie movie) {
        this.movie = movie;
    }

    public void setSeat(Seat seat) {
        this.seat = seat;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    @Override
    public String toString() {
        return "Ticket: " + movie.getTitle() + ", seat: " + seat;
    }
}