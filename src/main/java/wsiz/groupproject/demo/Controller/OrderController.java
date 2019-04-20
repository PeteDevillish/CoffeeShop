package wsiz.groupproject.demo.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import wsiz.groupproject.demo.OrderRepository;
import wsiz.groupproject.demo.Service.Order;
import wsiz.groupproject.demo.Service.Product;

import java.util.HashMap;
import java.util.List;
import java.util.Optional;

@RestController
//@CrossOrigin
public class OrderController {
    @Autowired
    OrderRepository orderRepository;

    @GetMapping("/allOrders")
    List<Order> getAllOrders(){
        return (List<Order>) orderRepository.findAll();
    }

    //dlaczego tak?
    @GetMapping("/order/{id}")
    Optional<Order> getProduct(@RequestParam long id){

        Optional<Order> byId = orderRepository.findById(id);
        return byId;
    }


    //todo: Dołożyć date zamówienia (coś w stylu Date.now wewnątrz konstruktora orderu, albo pobierac date requstem "od użytkownika")
    @PostMapping("/createOrder")
    public Order addOrder(@RequestParam HashMap<Product, Integer> products){
        Order _order = new Order(products);
        orderRepository.save(_order);
        return _order;
    }
    @DeleteMapping("/removeOrder/{id}")
    String deleteProduct(@PathVariable long id){
        try{
            orderRepository.deleteById(id);
        }
        catch (Exception e){
            return "Error " + e;
        }
        System.out.println("Orders after DELETE");
        System.out.println(orderRepository.findAll());
        return "Done";
    }


}
