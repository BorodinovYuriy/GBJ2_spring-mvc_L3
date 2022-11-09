package ru.adt.springmvc.repository;

import org.springframework.stereotype.Component;
import ru.adt.springmvc.models.Product;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@Component
public class RepoProducts {
    private List<Product> someProducts = new ArrayList<>();
    private static int IDCOUNT = 0;

    @PostConstruct
    public void addSomeProducts(){
        someProducts.add(new Product(++IDCOUNT,"Лапка суриката",10));
        someProducts.add(new Product(++IDCOUNT,"Глазик воробья",100));
        someProducts.add(new Product(++IDCOUNT,"Рог единорога",100));
        someProducts.add(new Product(++IDCOUNT,"Хвостик кабана",100));
        someProducts.add(new Product(++IDCOUNT,"Печень кашалота",1000));
        someProducts.add(new Product(++IDCOUNT,"Кровь врагов",50));
        someProducts.add(new Product(++IDCOUNT,"Кизяк",300));
        someProducts.add(new Product(++IDCOUNT,"Высохшие соты",50));
        someProducts.add(new Product(++IDCOUNT,"Вой ночных собак",2000));
    }

    public List<Product> getSomeProductsArrayList() {
        return someProducts;
    }
    public void printAllProductList(){
        someProducts.forEach((product) -> {
            System.out.println(product.toString());
        });
    }
    public Product getProductById(int id) {
        for (int i = 0; i < someProducts.size(); i++) {
            if (someProducts.get(i).getId() == id) {
                return someProducts.get(i);
            } else {
                System.out.println("Нет товара с заданным id");
            }
        }
        return null;
    }
    public void addProduct(Product product){
        product.setId(++IDCOUNT);
        someProducts.add(product);
    }

}
