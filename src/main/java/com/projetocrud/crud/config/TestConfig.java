package com.projetocrud.crud.config;


import com.projetocrud.crud.entities.*;
import com.projetocrud.crud.entities.enuns.OrderStatus;
import com.projetocrud.crud.repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.time.Instant;
import java.util.Arrays;

//Classe de configuração para popular o banco de dados com objetos
@Configuration
@Profile("test") //anotação para test
public class TestConfig implements CommandLineRunner {
    @Autowired //Anotação para passociar a dependencia
    private UserRepository userRepository;

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private CategoryRepository categoryRepository;


    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private OrderItemRepository orderItemRepository;

    @Override //Para ser executando quando a aplicação for iniciada
    public void run(String... args) throws Exception {

        //Usuarios
        User u1 = new User(null,"Adriano Bianchi","adrianobiancih@outlook.com","99999999","1234");
        User u2 = new User(null,"Tamara Correa Crosoletto","tamy.comercial@gmail.com","99999999","142321");
        User u3 = new User(null,"Tamires Correa Crosoletto","tamirescorrea@gmail.com","9898989989","1212232");

        userRepository.saveAll(Arrays.asList(u1,u2,u3));//Usuarios

        //Pedidos
        Order o1 = new Order(null,Instant.parse("2022-05-24T10:13:07Z"), OrderStatus.AGUARDANDO_PAGAMENTO,u1);
        Order o2 = new Order(null,Instant.parse("2021-02-12T11:23:22Z"),OrderStatus.PAGO,u2);
        Order o3 = new Order(null,Instant.parse("2022-11-01T08:05:02Z"),OrderStatus.ENTREGUE,u3);
        Order o4 = new Order(null,Instant.parse("2022-06-13T11:50:22Z"),OrderStatus.ENVIADO,u1);
        Order o5 = new Order(null,Instant.parse("2022-03-23T10:25:33Z"),OrderStatus.CANCELADO,u2);

        orderRepository.saveAll(Arrays.asList(o1,o2,o3,o4,o5));//Pedidos
        //Produtos
        Product p1 = new Product(null, "The Lord of the Rings", "Lorem ipsum dolor sit amet, consectetur.", 90.5, "");
        Product p2 = new Product(null, "Smart TV", "Nulla eu imperdiet purus. Maecenas ante.", 2190.0, "");
        Product p3 = new Product(null, "Macbook Pro", "Nam eleifend maximus tortor, at mollis.", 1250.0, "");
        Product p4 = new Product(null, "PC Gamer", "Donec aliquet odio ac rhoncus cursus.", 1200.0, "");
        Product p5 = new Product(null, "Rails for Dummies", "Cras fringilla convallis sem vel faucibus.", 100.99, "");

        productRepository.saveAll(Arrays.asList(p1,p2,p3,p4,p5));//Produtos
        //Categorias
        Category cat1 = new Category(null,"Eletronicos");
        Category cat2 = new Category(null,"Livros");
        Category cat3 = new Category(null,"Computadores");

        categoryRepository.saveAll(Arrays.asList(cat1,cat2,cat3));//Categorias

        //Produtos X Categoria
        p1.getCategories().add(cat2);
        p2.getCategories().add(cat1);
        p2.getCategories().add(cat3);
        p3.getCategories().add(cat3);
        p4.getCategories().add(cat3);
        p5.getCategories().add(cat2);

        productRepository.saveAll(Arrays.asList(p1,p2,p3,p4,p5));//Produtos X Categoria


        //Itens do pedido
        OrderItem oi1 = new OrderItem(o1, p1, 2, p1.getPrice());
        OrderItem oi2 = new OrderItem(o1, p3, 1, p3.getPrice());
        OrderItem oi3 = new OrderItem(o2, p3, 2, p3.getPrice());
        OrderItem oi4 = new OrderItem(o3, p5, 2, p5.getPrice());
        OrderItem oi5 = new OrderItem(o4, p4, 1, p4.getPrice());
        OrderItem oi6 = new OrderItem(o5, p2, 2, p2.getPrice());

        orderItemRepository.saveAll(Arrays.asList(oi1,oi2,oi3,oi4,oi5,oi6));

        Payment pay1 = new Payment(null,Instant.parse("2021-02-12T21:23:22Z"),o2);
        o2.setPayment(pay1);

        orderRepository.save(o2);
    }
}
