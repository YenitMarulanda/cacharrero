package com.usa.ciclo4.reto1.app.repositories.crud;

import com.usa.ciclo4.reto1.app.model.User;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface UserCrudRepository extends CrudRepository<User,Integer> {
    /*
    este es para practicar
     */
    public Optional<User> findByName(String name);
    /*
    1.6 utilizar elementos que el crud repository me permite implementar
    buscar un unico usuario por email
    Select * from user where user_email=''
     */
    public Optional<User> findByEmail(String email);
    /*
    buscar un unico usuario por email y password
    Select * from user where user_email='' and user_password=''
     */
    public Optional<User> findByEmailAndPassword(String email,String password);

    /*
    con list los valores no son unicos
     */
    public List<User> findByNameOrEmail(String name, String email);

}


