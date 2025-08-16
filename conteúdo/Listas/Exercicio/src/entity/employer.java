package entity;

public class employer {
    private Integer id;
    private String name;
    private Double salary;

    public employer(Integer id, String name , Double salary) {
        this.id = id;
        this.name = name;
        this.salary = salary;
    }


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void increaseSalary(double percentage){
        this.salary *= (percentage / 100) + 1;
    }

    @Override
    public String toString() {
        return id +
                ", " + name +
                String.format(", %.2f", salary);
    }
}

