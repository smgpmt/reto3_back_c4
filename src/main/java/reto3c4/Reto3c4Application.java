package reto3c4;

import reto3c4.interfaces.OrderInterface;
import reto3c4.interfaces.UserInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Component;
import reto3c4.interfaces.PeripheralsInterface;

@Component
@SpringBootApplication
public class Reto3c4Application implements CommandLineRunner {
    @Autowired
    private PeripheralsInterface peripheralsInterface;
    @Autowired
    private UserInterface userInterface;
    @Autowired
    private OrderInterface orderInterface;
    public static void main(String[] args) {
        SpringApplication.run(Reto3c4Application.class, args);
    }
    @Override
    public void run(String... args) throws Exception {
        peripheralsInterface.deleteAll();
        userInterface.deleteAll();
        orderInterface.deleteAll();
    }
}
