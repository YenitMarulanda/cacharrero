package com.usa.ciclo4.reto1.app.model;


import java.io.Serializable;

import javax.persistence.*;
import javax.persistence.metamodel.SingularAttribute;
import lombok.*;
import org.springframework.data.jpa.domain.AbstractPersistable;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "user")
//@Table(name = "user", indexes = @Index(name = "indx_email", columnList = "user_email", unique = true))
public class User implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    //@NonNull
    @Column(name = "user_email", unique = true, length = 50, nullable = false)
    private String email;
    //@NonNull
    @Column(name = "user_password", nullable = false, length = 50)
    private String password;
    //@NonNull
    @Column(name = "user_name", nullable = false, length = 80)
    private String name;

    public User(SingularAttribute<AbstractPersistable, Serializable> id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
