package org.example;

import java.time.LocalDateTime;

public class Main {

    public static void main(String[] args) {

        Cinema cinema1 = new Cinema("Super Tarasy", "ul. Akademicka 5");
        Cinema cinema2 = new Cinema("Mega Kino", "ul. Filmowa 10");

        Hall hall1 = new Hall("Hall 1");

        Seat seat1 = new Seat("H34");
        Seat seat2 = new Seat("H35");
        Seat seat3 = new Seat("H36");
        Seat seat4 = new Seat("A1");
        Seat seat5 = new Seat("A2");

        hall1.addSeat(seat1);
        hall1.addSeat(seat2);
        hall1.addSeat(seat3);
        hall1.addSeat(seat4);
        hall1.addSeat(seat5);

        cinema1.addHall(hall1);

        Movie movie1 = new Movie("James Bond", 140);
        Movie movie2 = new Movie("Avatar", 160);

        Screening screening1 = new Screening(
                movie1,
                hall1,
                LocalDateTime.now().plusDays(1),
                false,
                false
        );

        Screening screening2 = new Screening(
                movie2,
                hall1,
                LocalDateTime.now().plusDays(2),
                true,
                true
        );

        cinema1.addScreening(screening1);
        cinema1.addScreening(screening2);

        cinema1.printProgramme();

        Screening screening = cinema1.getScreenings()[0];

        screening.reservePlaces("H34", "H35", "H36");

        screening.reservePlaces(seat4, seat5);

        Customer customer = new Customer("Jan Kowalski");

        screening.reservePlaces(customer, "A1", "A2");

        screening.buyTicket("H34", customer);

        Movie foundMovie = cinema1.findMovie("James Bond");

        System.out.println("\nFound movie:");
        System.out.println(foundMovie);

        customer.printTickets();

        cinema2.printProgramme();
    }
}