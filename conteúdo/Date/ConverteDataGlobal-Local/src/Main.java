import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;

public class Main {
    public static void main(String[] args) {
        LocalDate d04 = LocalDate.parse("2022-07-20");
        LocalDateTime d05 = LocalDateTime.parse("2022-07-20T01:30:26");
        Instant d06 = Instant.parse("2022-07-20T01:30:26Z"); // Horário de Londres

        //Somente data:
        LocalDate r1 = LocalDate.ofInstant(d06, ZoneId.systemDefault());
        LocalDate r2 = LocalDate.ofInstant(d06, ZoneId.of("Portugal"));
        System.out.println("Brasil = " + r1);
        System.out.println("Portugal = " + r2);

        System.out.println();

        //Data e Hora:
        LocalDateTime r3 = LocalDateTime.ofInstant(d06, ZoneId.systemDefault());
        LocalDateTime r4 = LocalDateTime.ofInstant(d06, ZoneId.of("Portugal"));
        System.out.println("Brasil = " + r3);
        System.out.println("Portugal = " + r4);

        System.out.println();

        //Obter valores separados das datas:
        System.out.println("d04 dia = " + d04.getDayOfMonth());
        System.out.println("d04 mês = " + d04.getMonth());
        System.out.println("d04 ano = " + d04.getYear());

        System.out.println();

        System.out.println("d05 hora = " + d05.getHour());
        System.out.println("d05 hora = " + d05.getMinute());
    }
}