package wsiz.groupproject.demo.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import wsiz.groupproject.demo.ProductRepository;
import wsiz.groupproject.demo.Service.Product;

import java.util.List;
import java.util.Optional;
@RestController
public class ProductController {
    @Autowired
    ProductRepository productRepository;

    @GetMapping("/allProducts")
    List<Product> getAllProducts(){
        return (List<Product>) productRepository.findAll();
    }

    //dlaczego tak?
    @GetMapping("/product/{id}")
    //dlaczego nie dziala @RequestParam
    Optional<Product> getProduct(@PathVariable long id){

        Optional<Product> byId = productRepository.findById(id);
        return byId;
    }

    @PostMapping("/addProduct")
    Product addProduct(@RequestBody Product product) {
        productRepository.save(product);
        return product;
    }

    //keidy requestparam a kiedy pathvariable
    @DeleteMapping("delete/{id}")
    String deleteProduct(@PathVariable long id){
        try{
            productRepository.deleteById(id);
        }
        catch (Exception e){
            return "Error";
        }
        System.out.println("Customer Stores after DELETE ");
        System.out.println(productRepository.findAll());
        return "Done";
    }

    @GetMapping("/getPromotions")
    List<Product> getPromoProducts(){
        return productRepository.findByIsPromoTrue();
    }

}
