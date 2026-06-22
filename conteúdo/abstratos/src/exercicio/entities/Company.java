package exercicio.entities;

public class Company extends Base{

    private double quantity_employees;

    public Company(double quantity_employees) {
        this.quantity_employees = quantity_employees;
    }

    public Company(String name, double anual_income, double quantity_employees) {
        super(name, anual_income);
        this.quantity_employees = quantity_employees;
    }

    public double getQuantity_employees() {
        return quantity_employees;
    }

    public void setQuantity_employees(double quantity_employees) {
        this.quantity_employees = quantity_employees;
    }

    @Override
    public double calc_taxes() {
        double anual_income = getAnual_income();
        double taxes = 0.0;
        double porcent_taxes = quantity_employees < 10 ? 0.16 : 0.14;

        taxes = anual_income * porcent_taxes;

        return taxes;
    }
}
