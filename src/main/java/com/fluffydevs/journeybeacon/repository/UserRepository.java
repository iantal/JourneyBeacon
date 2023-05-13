package com.fluffydevs.journeybeacon.repository;

import com.fluffydevs.journeybeacon.model.Users;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface UserRepository extends CrudRepository<Users,String> {

    @Query("SELECT * FROM USERS WHERE email = :email")
    List<Users> findByEmail(String email);

    @Query("SELECT * FROM USERS WHERE email = :email and idToken = :idToken")
    List<Users> findByEmailAndToken(String email, String idToken);
}