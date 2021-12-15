package reto3c4.interfaces;

import java.util.Optional;
import reto3c4.model.Peripherals;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface PeripheralsInterface extends MongoRepository<Peripherals, String> {

    public Optional<Peripherals> findById(String reference);

}
