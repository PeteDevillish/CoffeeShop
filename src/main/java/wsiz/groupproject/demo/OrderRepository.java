package wsiz.groupproject.demo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import wsiz.groupproject.demo.Service.Order;

public interface OrderRepository extends CrudRepository<Order, Long>{
}
