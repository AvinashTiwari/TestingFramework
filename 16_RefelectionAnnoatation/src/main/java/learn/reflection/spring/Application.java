package learn.reflection.spring;

import java.util.ArrayList;
import java.util.List;

public class Application {
    public static void main(String[] args) {
      ApplicationContext context = new ApplicationContext(AppConfig.class);
        ProductService service = context.getBean(ProductService.class);
        List<Product> items = new ArrayList<>();
        items.add(new Product("YM", 40.0, 10));
        items.add(new Product("YM", 40.0, 10));

        List<Product> item = service.getFinalPrice(items);

        for(Product product : item){
            System.out.println(product.getPrice());
        }
    }
}
