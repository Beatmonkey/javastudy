package iwilllearnjava.socket;//package com.ithata.iwilllearnjava.socket;
//
//import com.ithata.iwilllearnjava.petshop.Customer;
//import com.ithata.iwilllearnjava.petshop.NewPetShop;
//
//import java.io.*;
//import java.net.ServerSocket;
//import java.net.Socket;
//import java.util.ArrayList;
//import java.util.List;
//import java.util.Scanner;
//
///**
// * Created by david on 3/16/2017.
// */
//public class PetShopServer {
//    public static void main(String[] args) throws Exception {
//        ServerSocket serverSocket = new ServerSocket(55555);
//        while (true) {
//            Socket socket = serverSocket.accept(); // blocking
//            System.out.println(socket.getLocalPort());
//            InputStream userInput = socket.getInputStream();
//            BufferedReader br = new BufferedReader(new InputStreamReader(userInput));
//            OutputStream outputStream = socket.getOutputStream();
//            PrintWriter pw = new PrintWriter(outputStream, true);
//            String clientSay;
//            while ((clientSay = br.readLine()) != null) {
//                System.out.println(clientSay);
//                public class Application {
//                    NewPetShop shop = new NewPetShop();
//                    List<Customer> customers = new ArrayList<Customer>();
//
//                    public void main(String[] args) {
//                        Application app = new Application();
////                        app.init();
//                        Scanner scanner = new Scanner(System.in);
//                        while (true) {
//                            String message = scanner.nextLine();
//                            if (message.equals("exit")) {
//                                break;
//                            } else if (message.equals("status")) {
//                                System.out.println(app.shop.toString());
//                                System.out.println();
//                                for (Customer customer : app.customers) {
//                                    System.out.println(customer);
//                                }
//                            } else if (message.equals("status shop")) {
//                                System.out.println(app.shop.toString());
//                            } else if (message.startsWith("status customer ")) {
//                                String customerName = message.substring("status customer ".length());
//                                Customer foundCustomer = null;
//                                for (Customer customer : app.customers) {
////                                    if (customerName.equals(customer.name)) {
////                                        foundCustomer = customer;
////                                        break;
////                                    }
//                                }
//                                if (foundCustomer == null) {
//                                    System.out.println("Customer with name: " + customerName + " not found");
//                                } else {
//                                    System.out.println(foundCustomer.toString());
//                                }
//                            } else if (message.startsWith("create customer")) {
//                                String[] parts = message.split(" ");
//                                String customerName = parts[2];
//                                int customerMoney = Integer.valueOf(parts[3]);
//                                Customer customer = new Customer(customerMoney, customerName);
//                                app.customers.add(customer);
//                            } else if (message.startsWith("buy")) {
//                                String[] parts = message.split(" ");
//                                String customerName = parts[1];
//                                String petName = parts[2];
//                                Customer foundCustomer = null;
//                                for (Customer customer : app.customers) {
////                                    if (customerName.equals(customer.name)) {
////                                        foundCustomer = customer;
////                                        break;
////                                    }
//                                }
//                                app.shop.buy(petName, foundCustomer);
//                            }
//
//                        }
////                if (clientSay.equals("Hello")) {
////                    pw.println("Hello u 2");
////                } else if (clientSay.equals("buy")) {
////                    pw.println("buy\n");
////                    System.out.println("Disconnecting client: " + socket.getRemoteSocketAddress());
////                    socket.close();
////                    break;
////                } else {
////                    pw.println("echo: " + clientSay);
////
//                    }
//
//                }
//
//            }
//        }
//    }
//}