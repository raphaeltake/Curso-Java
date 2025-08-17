import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;

public class Main {
    public static void main(String[] args) {
        LocalDate d04 = LocalDate.parse("2022-07-20");
        LocalDateTime d05 = LocalDateTime.parse("2022-07-20T01:30:26");
        Instant d06 = Instant.parse("2022-07-20T01:30:26Z");

        //Apenas data:
        DateTimeFormatter fmt1 = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        System.out.println("d04 original = " + d04);
        System.out.println("d04 formatado 01 = " + d04.format(fmt1));
        System.out.println("d04 formatado 02 = " + fmt1.format(d04));

        System.out.println();

        //Data e hora:
        DateTimeFormatter fmt2 = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
        System.out.println("d05 original = " + d05);
        System.out.println("d05 formatado 01 = " + d05.format(fmt2));
        System.out.println("d05 sem hora = " + d05.format(fmt1));
        System.out.println("d05 formatado 02 = " + fmt2.format(d05));

        System.out.println();

        //Data global
        DateTimeFormatter fmt3 = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm").withZone(ZoneId.systemDefault());
        System.out.println("d06 original = " + d06);
        System.out.println("d06 formatado = " + fmt3.format(d06));

        System.out.println();

        DateTimeFormatter fmt4 = DateTimeFormatter.ISO_DATE_TIME;
        DateTimeFormatter fmt5 = DateTimeFormatter.ISO_INSTANT;
        System.out.println("d05 formatado = " + d05.format(fmt4));
        System.out.println("d06 formatado = " + fmt5.format(d06));

    }
}