import entity.Estoque;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        double total;
        int add, remove;
        System.out.println("Enter product data:");
        System.out.print("Name: ");
        String name = sc.nextLine();
        System.out.print("Price: ");
        double price = sc.nextDouble();
        System.out.print("Quantity in stock: ");
        int quantity = sc.nextInt();
        Estoque product = new Estoque(name, price, quantity);
//        total = product.totalPrice();
        System.out.printf("Product data: " + product);


        System.out.print("Enter the number of products to be added in stock: ");
        add = sc.nextInt();
        product.add(add);
        System.out.printf("Updated data: " + product.toString());


        System.out.print("Enter the number of products to be removed in stock: ");
        remove = sc.nextInt();
        product.remove(remove);
        System.out.printf("Updated data: " + product.toString());
    }
}