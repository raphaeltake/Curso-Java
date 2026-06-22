package exercicio.entities;

public abstract class Base {
    protected String name;
    protected double Anual_income;

    public Base() {
    }

    public Base(String name, double anual_income) {
        this.name = name;
        Anual_income = anual_income;
    }

    public abstract double calc_taxes();

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getAnual_income() {
        return Anual_income;
    }

    public void setAnual_income(double anual_income) {
        Anual_income = anual_income;
    }
}
