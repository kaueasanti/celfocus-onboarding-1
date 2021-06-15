package com.training.springbootbuyitem.entity.model;

import com.training.springbootbuyitem.utils.validators.EmailConstraint;
import com.training.springbootbuyitem.utils.validators.PasswordConstraint;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Proxy;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;


@Proxy(lazy = false)
@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EntityListeners(AuditingEntityListener.class)
public class User extends Auditable implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userUid;
    @Column(unique = true)
    private String name;
    @EmailConstraint
    private String email;
    @PasswordConstraint
    private String password;
    /*@OneToMany(mappedBy = "user")
    private List<Item> items = new ArrayList<>();*/

}