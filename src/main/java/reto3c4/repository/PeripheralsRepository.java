package reto3c4.repository;

import reto3c4.model.Peripherals;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Optional;
import reto3c4.interfaces.PeripheralsInterface;

@Repository
public class PeripheralsRepository {
    @Autowired
    private PeripheralsInterface peripheralsCrudRepository;

    public List<Peripherals> getAll() {
        return peripheralsCrudRepository.findAll();
    }

    public Optional<Peripherals> getPeripherals(String reference) {
        return peripheralsCrudRepository.findById(reference);
    }

    public Peripherals create(Peripherals peripherals) {
        return peripheralsCrudRepository.save(peripherals);
    }

    public void update(Peripherals peripherals) {
        peripheralsCrudRepository.save(peripherals);
    }

    public void delete(Peripherals peripherals) {
        peripheralsCrudRepository.delete(peripherals);
    }

}
