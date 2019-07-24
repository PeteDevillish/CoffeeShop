package wsiz.groupproject.demo.Service;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import wsiz.groupproject.demo.ProductRepository;

import javax.persistence.*;
import java.time.LocalDate;
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
    private long id;
    private LocalDate date;
    @ManyToOne
    private User user;
    private Status status;
    private HashMap<Product, Integer> products;

    public Order(HashMap<Product, Integer> products, User user) {
        this.products = products;
        date = LocalDate.now();
        status = Status.ORDERED;
    }

}
