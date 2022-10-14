package repository;

import model.Product;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

public interface Walmart extends ReactiveMongoRepository<Product,String> {
}
