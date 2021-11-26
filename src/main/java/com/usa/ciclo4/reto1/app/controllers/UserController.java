package com.usa.ciclo4.reto1.app.controllers;

import com.usa.ciclo4.reto1.app.model.User;
import com.usa.ciclo4.reto1.app.services.UserServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("user")
@CrossOrigin("*")
/*
Esta capa es la encargada de dar acceso cuando va a consumir este servicio a esa cpa logica la que interactua con el usuario
 */
public class UserController {
    @Autowired
    private UserServices userService;

    /*
    1.3 Aqui estoy implementando mis servicios este me permite acceder a el por el metodo get, en los servios me va permitir
    acceder a el entrar a esa capa de datos y tomar segun la logica que se defina, en la capa de repositorio me va a poder
    manipular esos datos
     */
    @GetMapping("/all")
    public List<User> getUsers(){
        return userService.getAll();
    }

    /**
     * Aqui podemos registrar
     * @param user
     * @return
     */
    @PostMapping("/new")
    @ResponseStatus(HttpStatus.CREATED)
    public User save(@RequestBody User user) {
        return userService.save(user);
    }

    /**
     * consultar
     * @param email
     * @param password
     * @return
     */
    @GetMapping("/{email}/{password}")
    public User existUser(@PathVariable("email") String email, @PathVariable("password") String password) {
        return userService.getByEmailPass(email, password);
    }
    


    /**
     * consultar email
     * @param email
     * @return
     */
    @GetMapping("/{email}")
    public boolean existEmail(@PathVariable("email") String email) {
        return userService.getUserByEmail(email);
    }
}


