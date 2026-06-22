package exercicio.entities;

public class Individual extends Base{

    private double health_expenditures;

    public Individual(double health_expenditures) {
        this.health_expenditures = health_expenditures;
    }

    public Individual(String name, double anual_income, double health_expenditures) {
        super(name, anual_income);
        this.health_expenditures = health_expenditures;
    }

    public double getHealth_expenditures() {
        return health_expenditures;
    }

    public void setHealth_expenditures(double health_expenditures) {
        this.health_expenditures = health_expenditures;
    }

    @Override
    public double calc_taxes() {
        double anual_income = getAnual_income();
        double taxes = 0.0;
        double porcent_taxes = anual_income < 20000 ? 0.15 : 0.25;

        taxes += anual_income * porcent_taxes;

        if (health_expenditures > 0)
            taxes -= health_expenditures * 0.5;

        return taxes;
    }
}
