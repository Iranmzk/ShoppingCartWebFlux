package repository;

import model.Product;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Walmart extends ReactiveMongoRepository<Product,String> {
}
