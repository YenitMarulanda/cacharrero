package com.usa.ciclo4.reto1.app.repositories;

import com.usa.ciclo4.reto1.app.model.User;
import com.usa.ciclo4.reto1.app.repositories.crud.UserCrudRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
/*
Esa capa se encarga del manejo de los datos
 */
public class UserRepository {

    @Autowired
    private UserCrudRepository userCrudRepository;
    
        /*
    1.1 Esto es una abstraccion voy de abajo hacia arriba
    Aqui estoy implementando una coleccion de usuarios(findAll) que toca convertirlo a un tipo de dato propiamente dicho
    porque retorna un iterable
     */
    public List<User> getAll() {
        return (List<User>) userCrudRepository.findAll();
    }
    
    public User save(User user) {
        return userCrudRepository.save(user);
    }
        /*
    1.7 hice un abstraccion implementada
     */
    public Optional<User> getUserByName(String name) {
        return userCrudRepository.findByName(name);
    }
    
    public Optional<User> getUserByEmail(String email) {
        return userCrudRepository.findByEmail(email);
    }
    
    /*
    metodo para abstraer implementar
     */
    public List<User> getUserByNameOrEmail(String name, String email){
        return userCrudRepository.findByNameOrEmail(name, email);
    }
    
    public Optional<User> getUserEmailAndPassword(String email, String password) {
        return userCrudRepository.findByEmailAndPassword(email,password);
    }
    
    public Optional<User> getUserById(Integer id) {
        return userCrudRepository.findById(id);
    }
    
    

    


}