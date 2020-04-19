package iwilllearnjava.petshop;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by david on 3/4/2017.
 */
public class Application {
    NewPetShop shop = new NewPetShop();
    List<Customer> customers = new ArrayList<Customer>();

    public static void main(String[] args) {
        Application app = new Application();
        app.init();
        Scanner scanner = new Scanner(System.in);
        while (true) {
            String message = scanner.nextLine();
            if (message.equals("exit")) {
                break;
            } else if (message.equals("status")) {
                System.out.println(app.shop.toString());
                System.out.println();
                for (Customer customer : app.customers) {
                    System.out.println(customer);
                }
            } else if (message.equals("status shop")) {
                System.out.println(app.shop.toString());
            } else if (message.startsWith("status customer ")) {
                String customerName = message.substring("status customer ".length());
                Customer foundCustomer = null;
                for (Customer customer : app.customers) {
                    if (customerName.equals(customer.name)) {
                        foundCustomer = customer;
                        break;
                    }
                }
                if (foundCustomer == null) {
                    System.out.println("Customer with name: " + customerName + " not found");
                } else {
                    System.out.println(foundCustomer.toString());
                }
            } else if (message.startsWith("create customer")) {
                String[] parts = message.split(" ");
                String customerName = parts[2];
                int customerMoney = Integer.valueOf(parts[3]);
                Customer customer = new Customer(customerMoney, customerName);
                app.customers.add(customer);
            } else if (message.startsWith("buy")){
                String[] parts = message.split(" ");
                String customerName = parts[1];
                String petName = parts[2];
                Customer foundCustomer = null;
                for (Customer customer : app.customers) {
                    if (customerName.equals(customer.name)) {
                        foundCustomer = customer;
                        break;
                    }
                }
                app.shop.buy(petName, foundCustomer);
            }

        }
    }

    public void init() {
        shop.pets.add(new Cat(300, "Vasya", 10));
        shop.pets.add(new Cat(330, "Timofey", 10));
        shop.pets.add(new Dog(500, "Kolya"));
        shop.pets.add(new Dog(560, "Sharik"));
        shop.pets.add(new Dog(550, "Dima"));
        shop.pets.add(new Spider(700, "Venya"));
        Customer andrey = new Customer(1400, "Andrey");
        customers.add(andrey);
    }
}
