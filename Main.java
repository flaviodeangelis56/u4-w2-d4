import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        List<Product> productList = new ArrayList<>();
        Product ilSilenzioDegliInnocenti = new Product("Il silenzio degli innocenti", "Books", 123.23);
        Product ilSignoreDegliAnelli = new Product("il Signore Degli Anelli", "Books", 97.99);
        Product ilSignoreDegliAnelli2 = new Product("il Signore Degli Anelli: le due torri", "Books", 104.97);
        Product ciuccio = new Product("ciuccio", "Baby", 23.99);
        Product segiolino = new Product("segiolino", "Baby", 120.99);
        Product tShirt = new Product("t-shirt", "Boys", 129.99);
        Product boxer = new Product("Boxer", "Boys", 19.99);
        Product calzini = new Product("calzini", "Boys", 9.99);
        productList.add(ilSilenzioDegliInnocenti);
        productList.add(ilSignoreDegliAnelli);
        productList.add(ilSignoreDegliAnelli2);
        productList.add(ciuccio);
        productList.add(segiolino);
        productList.add(tShirt);
        productList.add(boxer);
        productList.add(calzini);

        Customers baki = new Customers("Baki");
        Customers gon = new Customers("Gon");
        Customers killua = new Customers("Killua");
        Customers sasuke = new Customers("Sasuke");

        List<Product> orderProductByBaki = new ArrayList<>();
        List<Product> orderProductByGon = new ArrayList<>();
        List<Product> orderProductByKillua = new ArrayList<>();
        List<Product> orderProductBySasuke = new ArrayList<>();

        orderProductBySasuke.add(segiolino);
        orderProductBySasuke.add(ilSilenzioDegliInnocenti);

        orderProductByBaki.add(ciuccio);
        orderProductByBaki.add(ilSilenzioDegliInnocenti);


        orderProductByGon.add(tShirt);
        orderProductByGon.add(ilSignoreDegliAnelli);


        orderProductByKillua.add(boxer);
        orderProductByKillua.add(ilSignoreDegliAnelli2);
        LocalDate date1 = LocalDate.of(2021, 2, 21);
        LocalDate date2 = LocalDate.of(2021, 3, 11);
        LocalDate date3 = LocalDate.of(2021, 3, 23);
        LocalDate date4 = LocalDate.of(2021, 2, 4);


        Order order1 = new Order("in progress", orderProductByBaki, baki, date1);
        Order order2 = new Order("in progress", orderProductByGon, gon, date2);
        Order order3 = new Order("in progress", orderProductByKillua, killua, date3);
        Order order4 = new Order("in progress", orderProductBySasuke, sasuke, date4);
        Order order5 = new Order("in progress", orderProductByBaki, baki, date1);

        List<Order> orderList = new ArrayList<>();
        orderList.add(order1);
        orderList.add(order2);
        orderList.add(order3);
        orderList.add(order4);
        orderList.add(order5);

        List<Order> orderListCustomersTier2 = new ArrayList<>();
        LocalDate onefeb = LocalDate.of(2021, 2, 1);
        LocalDate oneApr = LocalDate.of(2021, 4, 1);

        System.out.println("-------------------U4-W2-D3-------------------");
        System.out.println("-------------------EXERCISE 1-------------------");
        productList.stream().filter(product -> product.getCategory().equals("Books")).filter(product -> product.getPrice() > 100).forEach(product -> System.out.println(product));
        System.out.println("-------------------EXERCISE 2-------------------");
        orderList.stream().forEach(order -> order.getProducts().stream().filter(product -> product.getCategory().equals("Baby")).forEach(filteredOrder -> System.out.println(filteredOrder)));
        System.out.println("-------------------EXERCISE 3-------------------");
        productList.stream().filter(product -> product.getCategory().equals("Boys")).forEach(product -> product.setPrice(product.sconto(product.getPrice())));
        productList.stream().filter(product -> product.getCategory().equals("Boys")).forEach(product -> System.out.println(product));
        System.out.println("-------------------EXERCISE 4-------------------");
        orderList.stream().filter(order -> order.getCustomers().getTier() == 2).forEach(order -> orderListCustomersTier2.add(order));
        orderListCustomersTier2.stream().filter(order -> order.getOrderDate().isAfter(onefeb)).filter(order -> order.getOrderDate().isBefore(oneApr)).forEach(order -> System.out.println(order.getProducts().toString()));
        System.out.println("-------------------U4-W2-D4-------------------");
        System.out.println("-------------------EXERCISE 1-------------------");
        orderList.stream().collect(Collectors.groupingBy(order -> order.getCustomers().getName())).forEach((k,v) -> System.out.println( k + ", Order: " + v ));
        System.out.println("-------------------EXERCISE 2-------------------");
    }


}