package entity;

public class Estoque {
    public String name;
    public double price;
    public int quantity;

    public Estoque(String name, double price, int quantity){
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }

    public double totalPrice(){
        return price * quantity;
    }

    public void remove(int qtde){
        this.quantity -= qtde;
    }

    public void add(int qtde){
        this.quantity += qtde;
    }

    public String toString(){
        return name
                + ", $ "
                + String.format("%.2f", price)
                + ", "
                + quantity
                + " units, Total: $ "
                + String.format("%.2f%n", totalPrice());
    }
}
