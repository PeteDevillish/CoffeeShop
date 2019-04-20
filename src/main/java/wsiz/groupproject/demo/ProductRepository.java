package wsiz.groupproject.demo;

import org.springframework.data.repository.CrudRepository;
import wsiz.groupproject.demo.Service.Product;

import java.util.List;
import java.util.Optional;

public interface ProductRepository extends CrudRepository<Product, Long> {
    List<Product> findByIsPromoTrue();
}
