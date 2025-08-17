import java.time.Duration;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

public class Main {
    public static void main(String[] args) {
        LocalDate d04 = LocalDate.parse("2022-07-20");
        LocalDateTime d05 = LocalDateTime.parse("2022-07-20T01:30:26");
        Instant d06 = Instant.parse("2022-07-20T01:30:26Z"); // Horário de Londres

        //Somente data:
        //−1 semana
        LocalDate pastWeekLocalDate = d04.minusWeeks(1);
        System.out.println("pastWeekLocalDate = " + pastWeekLocalDate);

        //+1 semana
        LocalDate nextWeekLocalDate = d04.plusWeeks(1);
        System.out.println("nextWeekLocalDate = " + nextWeekLocalDate);

        System.out.println();

        //Data e Hora:
        //−1 semana
        LocalDateTime pastWeekLocalDateTime = d05.minusWeeks(1);
        System.out.println("pastWeekLocalDateTime = " + pastWeekLocalDateTime);

        //+1 semana
        LocalDateTime nextWeekLocalDateTime = d05.plusWeeks(1);
        System.out.println("nextWeekLocalDateTime = " + nextWeekLocalDateTime);

        System.out.println();

        //Global:
        //−1 semana
        Instant pastWeekInstant = d06.minus(7, ChronoUnit.DAYS);
        System.out.println("pastWeekInstant = " + pastWeekInstant);

        //+1 semana
        Instant nextWeekInstant = d06.plus(7, ChronoUnit.DAYS);
        System.out.println("nextWeekInstant = " + nextWeekInstant);

        System.out.println();

        //Duração:
//        Duration t1 = Duration.between(pastWeekLocalDate.atTime(0,0), d04.atTime(0, 0));
        Duration t1 = Duration.between(pastWeekLocalDate.atStartOfDay(), d04.atStartOfDay());
        System.out.println("t1 = " + t1.toDays());

        Duration t2 = Duration.between(pastWeekLocalDateTime, d05);
        System.out.println("t2 = " + t2.toDays());

        Duration t3 = Duration.between(pastWeekInstant, d06);
        System.out.println("t3 = " + t3.toDays());

        Duration t4 = Duration.between(d06, pastWeekInstant);
        System.out.println("t4 = " + t4.toDays());
    }
}