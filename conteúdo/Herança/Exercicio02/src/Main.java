import entities.ImportedProduct;
import entities.Product;
import entities.UsedProduct;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);
        List<Product> list = new ArrayList<>();
        inputData(sc, list);
        showPriceTags(list);
    }

    public static void inputData(Scanner sc, List<Product> list){
        DateTimeFormatter fmt1 = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        System.out.print("Enter the number of products: ");
        int qtde = sc.nextInt();

        for (int i = 0; i < qtde; i++) {
            sc.nextLine();
            System.out.println();
            System.out.println("Product #" + (i + 1) + " data: ");
            System.out.print("Common, used or imported (c/u/i)? ");
            char type = sc.nextLine().charAt(0);

            System.out.print("Name: ");
            String name = sc.nextLine();

            System.out.print("Price: ");
            double price = sc.nextDouble();

            if (type == 'u'){
                sc.nextLine();
                System.out.print("Manufacture date (DD/MM/YYYY): ");
                LocalDate manufacturedDate = LocalDate.parse(sc.nextLine(), fmt1);
                list.add(new UsedProduct(name, price, manufacturedDate));
            } else if (type == 'i') {
                System.out.print("Custom fee: ");
                double customFee = sc.nextDouble();
                list.add(new ImportedProduct(name, price, customFee));
            } else {
                list.add(new Product(name, price));
            }
        }
    }
    public static void showPriceTags(List<Product> list){
        System.out.println();
        System.out.println("PRICE TAGS: ");
        for (Product prod : list){
            System.out.println(prod.priceTag());
        }
    }
}