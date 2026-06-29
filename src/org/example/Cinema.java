package org.example;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Cinema {

    private String name;
    private String address;
    private List<Hall> halls;
    private List<Screening> screenings;

    public Cinema(String name, String address) {
        this.name = name;
        this.address = address;
        this.halls = new ArrayList<>();
        this.screenings = new ArrayList<>();
    }

    public void addHall(Hall hall) {
        halls.add(hall);
    }

    public void addScreening(Screening screening) {
        screenings.add(screening);
    }

    public void printProgramme() {
        System.out.println("\nProgramme for cinema: " + name);
        System.out.println("Address: " + address);

        LocalDateTime now = LocalDateTime.now();
        LocalDateTime nextWeek = now.plusDays(7);

        for (Screening screening : screenings) {
            if (screening.getDateTime().isAfter(now)
                    && screening.getDateTime().isBefore(nextWeek)) {
                System.out.println(screening);
            }
        }
    }

    public Movie findMovie(String title) {
        for (Screening screening : screenings) {
            if (screening.getMovie().getTitle().equalsIgnoreCase(title)) {
                return screening.getMovie();
            }
        }

        return null;
    }

    public Screening[] getScreenings() {
        return screenings.toArray(new Screening[0]);
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public List<Hall> getHalls() {
        return halls;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setHalls(List<Hall> halls) {
        this.halls = halls;
    }

    public void setScreenings(List<Screening> screenings) {
        this.screenings = screenings;
    }
}