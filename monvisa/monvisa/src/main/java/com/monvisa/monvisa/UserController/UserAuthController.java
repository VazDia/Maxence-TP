package com.monvisa.monvisa.UserController;

import com.monvisa.monvisa.User.User;
import com.monvisa.monvisa.UserRepository.AuthRepository;
import com.monvisa.monvisa.UserService.UserAuthService;
import com.monvisa.monvisa.UserVO.UserVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping(path ="api/v2", name ="App_user")
public class UserAuthController {
    private UserAuthService userAuthService;

    @Autowired
    public UserAuthController(UserAuthService userAuthService){
        this.userAuthService = userAuthService;
    }

    // Enregistrement de données
    @PostMapping(path = "/User/Register")
    @ResponseStatus(HttpStatus.CREATED)
    public User registerUser(@RequestBody User user) throws Exception{
        String tempEmail = user.getEmail();
        if (tempEmail != null && !"".equals(tempEmail)){
            User userObj = userAuthService.fetchByEmailId(tempEmail);
            if (userObj != null){
                throw new Exception("Cet utilisateur avec l'addresse email"+ tempEmail +"existe déjà");
            }
        }
        return this.userAuthService.Register(user);
    }

    // Connexion à un compte
    @PostMapping(path = "/User/Login")
    @ResponseStatus(HttpStatus.OK)
    public User login(@RequestBody User user) throws Exception{
        String tempEmail = user.getEmail();
        String tempPassword = user.getPassword();
        User userObj=null;
        if (tempEmail != null && tempPassword != null){
            userObj = this.userAuthService.fetchByEmailIdAndPassword(tempEmail,tempPassword);
        }
        if (userObj == null){
            throw new Exception("Cet compte d'utilisateur n'existe");
        }
        return userObj ;
    }



}
