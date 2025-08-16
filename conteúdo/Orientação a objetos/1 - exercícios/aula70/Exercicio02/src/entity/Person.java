package entity;

public class Person {
    public String name;
    public double salary;
    public double tax;

    public double netSalary(){
        return salary - tax;
    }

    public void increaseSalary(double percentage){
        this.salary = salary * ((percentage/100) + 1);
    }

    public String toString(){
        return name + ", $ " + String.format("%.2f", netSalary());
    }
}
