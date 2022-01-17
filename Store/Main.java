package ua.kiev.prog;

import ua.kiev.prog.DAO.AbstractDAO;
import ua.kiev.prog.DAO.ClientDAO;
import ua.kiev.prog.DAO.GoodsDAO;
import ua.kiev.prog.DAO.OrderDAO;
import ua.kiev.prog.entity.Address;
import ua.kiev.prog.entity.Client;
import ua.kiev.prog.entity.Goods;
import ua.kiev.prog.entity.Order;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws ParseException {

        OrderDAO orderDAO = new OrderDAO("orders");
        ClientDAO clientDAO = new ClientDAO("clients");
        GoodsDAO goodsDAO = new GoodsDAO("goods");
        Scanner sc = new Scanner(System.in);

        Client client = createNewClient(sc, clientDAO);

        Goods goods1 = new Goods("Toy", 1111);
        Goods goods2 = new Goods("Car", 2222);
        Goods goods3 = new Goods("Boots", 3333);
        Goods goods4 = new Goods("Bra", 4444);
        Goods goods5 = new Goods("Phone", 5555);

        goodsDAO.add(goods1);
        goodsDAO.add(goods2);
        goodsDAO.add(goods3);
        goodsDAO.add(goods4);
        goodsDAO.add(goods5);



        while (true) {
            System.out.println("1: add order");
            System.out.println("2: view orders by phone number");
            System.out.println("3: view orders my date");
            System.out.println("4: create new client");
            System.out.print("-> ");

            String s = sc.next();
            switch (s) {
                case "1":
                    List<Goods> goods = goodsDAO.getAll(Goods.class);
                    for (Goods gds : goods){
                        System.out.println(gds);
                    }

                    Order order = new Order();
                    while (true) {
                        System.out.print("Enter the id or 0 to finish: ");
                        int id = sc.nextInt();
                        if (id == 0 && !order.getGoods().isEmpty()) {
                            order.setClient(client);
                            client.setOrders(order);
                            orderDAO.add(order);
                            break;
                        } else {
                            for (Goods gds : goods) {
                                if (gds.getId() == id) {
                                    order.setGoods(gds);
                                }
                            }
                        }
                    }
                    break;
                case "2":
                    System.out.print("Enter the phone number: ");
                    int num = sc.nextInt();
                    List<Order> orders = orderDAO.findOrderByPhone(num);
                    for (Order ord : orders){
                        System.out.println(ord);
                    }
                    break;
                case "3":
                    SimpleDateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy");
                    System.out.print("Enter the first date dd.MM.yyyy: ");
                    String firstDateText = sc.next();
                    Date firstDate = dateFormat.parse(firstDateText);
                    System.out.print("Enter the second date dd.MM.yyyy: ");
                    String secondDateText = sc.next();
                    Date secondDate = dateFormat.parse(secondDateText);
                    List<Order> orders2 = orderDAO.findOrderByDates(firstDate, secondDate);


                    for (Order ord : orders2){
                        System.out.println(ord);
                    }

                    break;
                case "4":
                    client = createNewClient(sc, clientDAO);
                    break;
                default:
                    return;
            }
        }

        }

        public static Client createNewClient (Scanner sc, ClientDAO dao){
            Client client = new Client();
            Address address = new Address();
            System.out.println("Enter your name: ");
            client.setName(sc.next());
            System.out.println("Enter your phone number: ");
            client.setPhoneNum(sc.nextInt());
            System.out.println("Enter your country: ");
            address.setCountry(sc.next());
            System.out.println("Enter your city: ");
            address.setCity(sc.next());
            System.out.println("Enter your street: ");
            address.setStreet(sc.next());
            client.setAddress(address);

            dao.add(client);

            return client;
        }
    }

//    Client client1 = new Client("Ivan", 11111111);
//    Client client2 = new Client("Petr", 22222222);
//
//    Address adr1 = new Address("Ukraine", "Kiev", "First");
//    Address adr2 = new Address("USA", "New-York", "Second");
//
//        client1.setAddress(adr1);
//                client2.setAddress(adr2);
//
//                adr1.setClient(client1);
//                adr2.setClient(client2);
//
//
//
//
//                clientDAO.add(client1);
//                clientDAO.add(client2);
//
//
//
//                Goods goods1 = new Goods("Toy", 1111);
//                Goods goods2 = new Goods("Car", 2222);
//                Goods goods3 = new Goods("Boots", 3333);
//                Goods goods4 = new Goods("Bra", 4444);
//                Goods goods5 = new Goods("Phone", 5555);
//
//                Order order1 = new Order();
//                Order order2 = new Order();
//                Order order3 = new Order();
//
//                order1.setGoods(goods1);
//                goods1.setOrders(order1);
//
//                order1.setGoods(goods2);
//                goods2.setOrders(order1);
//
//                order1.setGoods(goods5);
//                goods5.setOrders(order1);
//
//                client1.setOrders(order1);
//                order1.setClient(client1);
//
//                orderDAO.add(order1);
//
//                order2.setGoods(goods2);
//                goods2.setOrders(order2);
//
//                order2.setGoods(goods3);
//                goods3.setOrders(order2);
//
//                order2.setGoods(goods4);
//                goods4.setOrders(order2);
//
//                client1.setOrders(order2);
//                order2.setClient(client1);
//
//                orderDAO.add(order2);
//
//                order3.setGoods(goods2);
//                goods2.setOrders(order3);
//
//                client2.setOrders(order3);
//                order3.setClient(client2);
//
//                orderDAO.add(order3);