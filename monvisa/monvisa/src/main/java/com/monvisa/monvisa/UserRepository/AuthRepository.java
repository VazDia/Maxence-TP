package com.monvisa.monvisa.UserRepository;

import com.monvisa.monvisa.User.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AuthRepository extends JpaRepository<User,Integer> {

    public User findByEmail(String email);
    public User findByEmailAndPassword(String email, String Password);


}
