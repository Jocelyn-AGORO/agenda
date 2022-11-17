package agenda;

import java.time.LocalDate;
import java.util.*;

/**
 * Description : An agenda that stores events
 */
public class Agenda {
    /**
     * Adds an event to this agenda
     *
     * @param e the event to add
     */
    private List<Event> events = new ArrayList<>();

    public void addEvent(Event e) {
        this.events.add(e);
    }

    /**
     * Computes the events that occur on a given day
     *
     * @param day the day toi test
     * @return and iteraror to the events that occur on that day
     */
    public List<Event> eventsInDay(LocalDate day) {
        List<Event> eventsThisDay = new ArrayList<>();
        for(Event e : events) {
            if(e.isInDay(day)){
                eventsThisDay.add(e);
            }
        }
        return eventsThisDay;
    }

    /**
     * Trouver les événements de l'agenda en fonction de leur titre
     * @param title le titre à rechercher
     * @return les événements qui ont le même titre
     */
    public List<Event> findByTitle(String title) {
        List<Event> eventsMatched = new ArrayList<>();
        for(Event e : events) {
            if(e.getTitle().equals(title)){
                eventsMatched.add(e);
            }
        }
        return eventsMatched;
    }

    /**
     * Déterminer s’il y a de la place dans l'agenda pour un événement
     * @param e L'événement à tester (on se limitera aux événements simples)
     * @return vrai s’il y a de la place dans l'agenda pour cet événement
     */
    public boolean isFreeFor(Event e) {
        boolean isFree = true;
        for(Event event: events) {
            if(event.isAtSameTime(e)){
                isFree = false;
                break;
            }
        }
        return isFree;
    }
}
