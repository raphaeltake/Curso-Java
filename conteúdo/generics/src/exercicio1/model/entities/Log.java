package exercicio1.model.entities;

import java.time.Instant;
import java.time.LocalDate;
import java.util.Date;
import java.util.Objects;

public class Log {
    private String name;
    private Instant date;

    public Log() {
    }

    public Log(String name, Instant date) {
        this.name = name;
        this.date = date;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Instant getDate() {
        return date;
    }

    public void setDate(Instant date) {
        this.date = date;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Log log = (Log) o;
        return Objects.equals(name, log.name);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(name);
    }
}
