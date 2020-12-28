package or.sid.inventoryservice;

import or.sid.inventoryservice.dao.ProductRepository;
import or.sid.inventoryservice.entities.Product;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;

@SpringBootApplication
public class InventoryServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(InventoryServiceApplication.class, args);
    }

    @Bean
    CommandLineRunner start(ProductRepository productRepository, RepositoryRestConfiguration repositoryRestConfiguration){
        return args -> {
            productRepository.save(new Product(null,"pc",8000,35));
            productRepository.save(new Product(null,"television",3000,46));
            productRepository.save(new Product(null,"smartphone",1900,19));
            productRepository.save(new Product(null,"tablette",3900,12));
            productRepository.findAll().forEach(product -> {
                System.out.println(product);
            });
            repositoryRestConfiguration.exposeIdsFor(Product.class);
        };
    }

}
