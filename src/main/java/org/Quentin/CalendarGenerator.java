package org.Quentin;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;


/**
 * Classe contenant la fonction permettant de générer un calendrier pour un mois et une année donnés.
 */
public class CalendarGenerator {

    /**
     * Génère un calendrier pour le mois et l'année spécifiés.
     *
     * @param year  Année du calendrier
     * @param month Mois du calendrier (1 pour janvier, 2 pour février, etc.)
     * @return Liste bidimensionnelle d'integer représentant le calendrier
     */
    public static List<List<Integer>> generateCalendar(int year, int month) {
        List<List<Integer>> calendar = new ArrayList<>();

        // Créez une LocalDate pour le premier jour du mois
        LocalDate date = LocalDate.of(year, month, 1);

        // Déterminez le jour de la semaine du premier jour du mois
        DayOfWeek firstDayOfWeek = date.getDayOfWeek();

        // Ajoutez des jours vides au début du calendrier pour atteindre le premier jour de la semaine (lundi)
        int daysUntilMonday = (firstDayOfWeek.getValue() - DayOfWeek.MONDAY.getValue() + 7) % 7;
        List<Integer> week = new ArrayList<>();
        for (int i = 0; i < daysUntilMonday; i++) {
            week.add(null);
        }

        // Ajoutez les jours du mois au calendrier
        while (date.getMonthValue() == month) {
            week.add(date.getDayOfMonth());
            if (week.size() == 7) {
                calendar.add(week);
                week = new ArrayList<>();
            }
            date = date.plusDays(1);
        }

        // Ajoutez des jours vides à la fin du calendrier pour compléter la dernière semaine
        while (week.size() < 7) {
            week.add(null);
        }
        calendar.add(week);

        return calendar;
    }
}
