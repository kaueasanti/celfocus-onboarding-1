package com.training.springbootbuyitem.repository;

import com.training.springbootbuyitem.entity.model.Item;
import com.training.springbootbuyitem.entity.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Set;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    @Query(value = "SELECT * From user WHERE email = ?1", nativeQuery = true)
    User getByEmail(String email);

    @Query(value = "SELECT items From user WHERE user_uid = ?1", nativeQuery = true)
    Set<Item> getUserItems(Long id);

}
