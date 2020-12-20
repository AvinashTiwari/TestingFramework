package learn.reflection.spring;

import learn.reflection.spring.annotation.Autowired;

import java.util.List;

public class ProductService {
    @Autowired
    ProductRepository repo ;

    public List<Product> getFinalPrice(List<Product> items){
        List<Product> list = repo.getPrice(items);
         for(Product product: list){
             product.setPrice(product.getPrice() * (100 - product.getDiscount() ) /100);
             System.out.println("Price of product " + product.getName() + " after " + product.getDiscount()
             + " % discount is " + product.getPrice() + " $.");
         }

        return list;
    }
}
