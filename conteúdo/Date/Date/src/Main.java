import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Main {
    public static void main(String[] args) {
        //Somente data:
        LocalDate d01 = LocalDate.now();
        System.out.println("d01 = " + d01);

        //Data e hora:
        LocalDateTime d02 = LocalDateTime.now();
        System.out.println("d02 = " + d02);

        //Instant:
        Instant d03 = Instant.now();
        System.out.println("d03 = " + d03); //Horário de Londres

        //Texto ISO 8601 → data:
        LocalDate d04 = LocalDate.parse("2022-07-20");
        System.out.println("d04 = " + d04);

        //Texto ISO 8601 → data-hora:
        LocalDateTime d05 = LocalDateTime.parse("2022-07-20T01:30:26");
        System.out.println("d05 = " + d05);

        //Texto ISO 8601 → data-hora:
        Instant d06 = Instant.parse("2022-07-20T01:30:26Z");
        System.out.println("d06 = " + d06);

        //Texto ISO 8601 → data-hora:
        Instant d07 = Instant.parse("2022-07-20T01:30:26-03:00");
        System.out.println("d07 = " + d07);

        //Texto em formato customizado para data-hora:
        //java dateTimeFormatter
        DateTimeFormatter fmt1 = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate d08 = LocalDate.parse("16/08/2025", fmt1);
        System.out.println("d08 = " + d08);

        DateTimeFormatter fmt2 = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
        LocalDateTime d09 = LocalDateTime.parse("16/08/2025 01:30", fmt2);
        System.out.println("d09 = " + d09);

        //Instanciar datas de dados isolados:
        LocalDate d10 = LocalDate.of(2025, 8, 16);
        System.out.println("d10 = " + d10);

        LocalDateTime d11 = LocalDateTime.of(2025, 8, 16, 19, 50);
        System.out.println("d11 = " + d11);
    }
}