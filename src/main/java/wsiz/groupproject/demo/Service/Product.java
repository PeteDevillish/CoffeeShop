package wsiz.groupproject.demo.Service;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Service;

import javax.persistence.*;

@Entity
@Table(name = "products")
@Data
@NoArgsConstructor
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private double price;
    private Category category;
    boolean isPromo;
    private double promoPrice;
    //is it good idea to note how much products we have, and how much product we sold???
    private int numberOfSoldProducts = 0;
    private int numberOfProductsInStock;

    public Product(double price, Category category, double promoPrice, int numberOfProductsInStock) {
        this.price = price;
        this.category = category;
        this.promoPrice = promoPrice;
        isPromo = true;
        this.numberOfProductsInStock = numberOfProductsInStock;
    }

    public Product(double price, Category category, int numberOfProductsInStock) {
        this.price = price;
        this.category = category;
        this.numberOfProductsInStock = numberOfProductsInStock;
        isPromo = false;
    }
}
