package reto3c4.controller;

import reto3c4.model.User;
import reto3c4.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/user/")
@CrossOrigin("*")
/**
 * Clase principal controllador de usuario
 */
public class UserController {
    @Autowired
    private UserService userService;
    /**
     * Se consultan todos los datos de la lista usuario
     * @return userService
     */
    @GetMapping("/all")
    public List<User> getAll() {
        return userService.getAll();
    }
    /**
     * Se consulta el usuario por medio del id
     * @param id
     * @return el usuario
     */
    @GetMapping("/{id}")
    public Optional<User> getUser(@PathVariable("id") Integer id) {
        return userService.getUser(id);
    }
    /**
     * Se hace un post y se crea un nuevo usuario
     * @param user
     * @return 
     */
    @PostMapping("/new")
    @ResponseStatus(HttpStatus.CREATED)
    public User create(@RequestBody User user) {
        return userService.create(user);
    }
    /**
     * Se hace la actualización del usuario
     * @param user
     * @return el usuario actualizado
     */
    @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public User update(@RequestBody User user) {
        return userService.update(user);
    }
    /**
     * Se eliminan datos por medio del id
     * @param id
     * @return campo vacio por la eliminación
     */
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public boolean delete(@PathVariable("id") Integer id) {
        return userService.delete(id);
    }
    /**
     * Se hace una autenticación del usuario por medio del correo y la contraseña
     * @param email
     * @param password
     * @return autenticación del usuario
     */
    @GetMapping("/{email}/{password}")
    public User authenticateUser(@PathVariable("email") String email, @PathVariable("password") String password) {
        return userService.authenticateUser(email, password);
    }
    /**
     * Se verifica si el email existe
     * @param email
     * @return si existe el email
     */
    @GetMapping("/emailexist/{email}")
    public boolean emailExists(@PathVariable("email") String email) {
        return userService.emailExists(email);
    }
}
