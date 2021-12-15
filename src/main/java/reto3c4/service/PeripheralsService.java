package reto3c4.service;

import reto3c4.model.Peripherals;
import reto3c4.repository.PeripheralsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class PeripheralsService {
    @Autowired
    private PeripheralsRepository peripheralsRepository;

    public List<Peripherals> getAll() {
        return peripheralsRepository.getAll();
    }

    public Optional<Peripherals> getPeripherals(String reference) {
        return peripheralsRepository.getPeripherals(reference);
    }

    public Peripherals create(Peripherals peripherals) {
        if (peripherals.getReference() == null) {
            return peripherals;
        } else {
            return peripheralsRepository.create(peripherals);
        }
    }

    public Peripherals update(Peripherals peripherals) {

        if (peripherals.getReference() != null) {
            Optional<Peripherals> peripheralsDb = peripheralsRepository.getPeripherals(peripherals.getReference());
            if (!peripheralsDb.isEmpty()) {

                if (peripherals.getBrand()!= null) {
                    peripheralsDb.get().setBrand(peripherals.getBrand());
                }

                if (peripherals.getCategory() != null) {
                    peripheralsDb.get().setCategory(peripherals.getCategory());
                }

                if (peripherals.getDescription() != null) {
                    peripheralsDb.get().setDescription(peripherals.getDescription());
                }

                if (peripherals.getPrice() != 0.0) {
                    peripheralsDb.get().setPrice(peripherals.getPrice());
                }

                if (peripherals.getQuantity() != 0) {
                    peripheralsDb.get().setQuantity(peripherals.getQuantity());
                }

                if (peripherals.getPhotography() != null) {
                    peripheralsDb.get().setPhotography(peripherals.getPhotography());
                }

                peripheralsDb.get().setAvailability(peripherals.isAvailability());
                peripheralsRepository.update(peripheralsDb.get());
                return peripheralsDb.get();
            } else {
                return peripherals;
            }
        } else {
            return peripherals;
        }
    }

    public boolean delete(String reference) {
        Boolean aBoolean = getPeripherals(reference).map(peripherals -> {
            peripheralsRepository.delete(peripherals);
            return true;
        }).orElse(false);
        return aBoolean;
    }

}
