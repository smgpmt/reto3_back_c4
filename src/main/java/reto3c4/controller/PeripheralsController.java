package reto3c4.controller;

import reto3c4.model.Peripherals;
import reto3c4.service.PeripheralsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/peripherals/")
@CrossOrigin("*")
public class PeripheralsController {
    @Autowired
    private PeripheralsService peripheralsService;

    @GetMapping("/all")
    public List<Peripherals> getAll() {
        return peripheralsService.getAll();
    }

    @GetMapping("/{reference}")
    public Optional<Peripherals> getPeripherals(@PathVariable("reference") String reference) {
        return peripheralsService.getPeripherals(reference);
    }

    @PostMapping("/new")
    @ResponseStatus(HttpStatus.CREATED)
    public Peripherals create(@RequestBody Peripherals user) {
        return peripheralsService.create(user);
    }

    @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public Peripherals update(@RequestBody Peripherals user) {
        return peripheralsService.update(user);
    }

    @DeleteMapping("/{reference}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public boolean delete(@PathVariable("reference") String reference) {
        return peripheralsService.delete(reference);
    }
}
