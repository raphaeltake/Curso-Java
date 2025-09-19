package entities;

public class OutsourceEmployee extends Employee{
    private Double additionalCharge;

    @Override
    public Double payment(){
        return super.payment() + additionalCharge * 1.10;
    }
}
