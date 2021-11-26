package com.usa.ciclo4.reto1.app.services;

import com.usa.ciclo4.reto1.app.model.User;
import com.usa.ciclo4.reto1.app.repositories.UserRepository;
import com.usa.ciclo4.reto1.app.repositories.crud.UserCrudRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import static org.hibernate.criterion.Projections.id;
import static org.springframework.data.jpa.domain.AbstractPersistable_.id;
import org.springframework.data.repository.CrudRepositoryExtensionsKt;

@Service
/*
esta capa controla la logica de negocio las validaciones, todas las operaciones de validacion de
elementos de logica de comportamiento de servicio y demas aspectos que tienen que ver con lo operacional
 */
public class UserServices {

    @Autowired
    private UserRepository userRepository;
    
        /*
    1.2 Para listar todos los usuarios
     */
    public List<User> getAll() {
        return userRepository.getAll();
    }
    
    public User save(User user) {
        if(user.getName() == null || user.getPassword()==null){
            return user;
        }else{
            List<User> existUser = userRepository.getUserByNameOrEmail(user.getName(), user.getEmail());
            if(existUser.isEmpty()){
                if(user.getId()==null){
                    return userRepository.save(user);
                }else{
                    Optional<User> existUser2 = userRepository.getUserById(user.getId());
                    if(existUser2.isEmpty()){
                        return userRepository.save(user);
                    }else{
                        return user;
                    }
                }
            }else{
                return user;
            }
        }
    }
    /**
     * 
     * @param email
     * @return 
     */
    public boolean getUserByEmail(String email){
        return userRepository.getUserByEmail(email).isPresent();
    }
    
    public User getByEmailPass(String email, String password){
        Optional<User> userExist = userRepository.getUserEmailAndPassword(email, password);
        if(userExist.isPresent()){
            return userExist.get();
        }else{
            return new User(null,email,password,"NO DEFINIDO");
        }
    }   

}