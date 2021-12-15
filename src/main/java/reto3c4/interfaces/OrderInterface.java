package reto3c4.interfaces;

import reto3c4.model.Order;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface OrderInterface extends MongoRepository<Order, Integer> {
    List<Order> findBySalesManZone(String zone);
}
