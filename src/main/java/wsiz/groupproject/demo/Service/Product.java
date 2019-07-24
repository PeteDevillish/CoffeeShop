package wsiz.groupproject.demo.Service;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "products")
@Data
@NoArgsConstructor
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private BigDecimal price;
    private Category category;
    private boolean isPromo;
    private double promoPrice;
    private static Long numberOfSoldProducts = 0L;
    private static Long numberOfProductsInStock;


    public Product(BigDecimal price, Category category, double promoPrice, Long numberOfProductsInStock) {
        this.price = price;
        this.category = category;
        this.promoPrice = promoPrice;
        isPromo = true;
        this.numberOfProductsInStock = numberOfProductsInStock;
    }

    public Product(BigDecimal price, Category category, Long numberOfProductsInStock) {
        this.price = price;
        this.category = category;
        this.numberOfProductsInStock = numberOfProductsInStock;
        isPromo = false;
    }

    public static void addProductsToStock(Long numberOfProducts){
        numberOfProductsInStock += numberOfProducts;
    }

    public static void soldProducts(Long id, Long numberOfProducts){
        numberOfSoldProducts += numberOfProducts;
        numberOfProductsInStock -= numberOfProducts;
    }
}
