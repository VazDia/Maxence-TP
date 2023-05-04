package com.monvisa.monvisa.UserService;

import com.monvisa.monvisa.User.User;
import com.monvisa.monvisa.UserRepository.AuthRepository;
import com.monvisa.monvisa.UserVO.UserVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserAuthService {
    private AuthRepository authRepository;

    @Autowired
    public UserAuthService(AuthRepository authRepository){
        this.authRepository = authRepository;
    }

    public User Register(User user){
        return authRepository.save(user);
    }

    public User fetchByEmailId(String email){

        return this.authRepository.findByEmail(email);
    }

    public User fetchByEmailIdAndPassword(String email, String Password){

        return this.authRepository.findByEmailAndPassword(email,Password);

    }
}
