package wsiz.groupproject.demo.Service;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import wsiz.groupproject.demo.ProductRepository;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@Table(name = "orders")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    long id;
    Date date;
//    User user;
    Status status;
    //m,apa z produktami jako kluczami i integerami jako iloscia produktow
    HashMap<Product, Integer> products;

    public Order(HashMap<Product, Integer> products) {
        this.products = products;
//        dodac automatyczne dodawanie daty zakupu
//        date = Date.
        status = Status.ORDERED;
    }

}
