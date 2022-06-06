package application;

import entities.ImportedProduct;
import entities.Product;
import entities.UsedProduct;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class Program {

    public static void main(String[] args) throws ParseException {

        SimpleDateFormat sdf1 = new SimpleDateFormat("dd/MM/yyyy");
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);
        List<Product> products = new ArrayList<>();

        System.out.print("Enter the number of products: ");
        int n = sc.nextInt();

        for (int i = 1; i <= n; i++) {
            System.out.println("Product #" + i + " data:");
            while (true) {
                System.out.print("Common, used or imported? (c/u/i)\n>>> ");
                char productType = sc.next().charAt(0);
                if (productType != 'c' && productType != 'u' && productType != 'i') {
                    System.out.println("Invalid option, try again... ");

                } else {

                    System.out.print("Name: ");
                    sc.nextLine();
                    String name = sc.nextLine();

                    System.out.print("Price: ");
                    double price = sc.nextDouble();

                    if (productType == 'c') {
                        Product product = new Product(name, price);
                        products.add(product);
                    }

                    if (productType == 'i') {
                        System.out.print("Custom fee: ");
                        double customFee = sc.nextDouble();
                        Product product = new ImportedProduct(name, price, customFee);
                        products.add(product);
                    }
                    if (productType == 'u') {
                        System.out.print("Manufacture date (DD/MM/YYYY): ");
                        Date manufactureDate = sdf1.parse(sc.next());
                        Product product = new UsedProduct(name, price, manufactureDate);
                        products.add(product);
                    }
                    break;
                }
            }
        }
        System.out.println();
        System.out.println("PRICE TAGS:");
        for (Product prod : products){
            System.out.println(prod.priceTag());
        }
        sc.close();
    }
}
