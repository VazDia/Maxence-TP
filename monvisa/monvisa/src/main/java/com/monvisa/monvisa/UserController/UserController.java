package com.monvisa.monvisa.UserController;

import com.monvisa.monvisa.User.User;
import com.monvisa.monvisa.UserService.UserService;
import com.monvisa.monvisa.UserVO.UserVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

/*
* Class de création des URL et endpoints de l'API
*Appel aux methode de la classe UserService pour excuter les différentes tâches
*  */
@RestController
@RequestMapping(path = "api/v1", name ="app_User") // Url et nom de notre API
public class UserController {
    // Déclaration de propriété de type UserService pour faire appel au service corespondant
    private UserService userService;
    // Crétion de constructeur
    @Autowired
    public UserController(UserService userService){
        this.userService = userService;
    }

    // Endpoint et méthode de création de compte utilisateur
    @PostMapping(path = "/User", name ="Create")
    @ResponseStatus(HttpStatus.CREATED)
    public User Add(@RequestBody User user) {

        return this.userService.saveUser(user);
    }


    // Endpoint et méthode d'affichage de la liste des utilisateurs
    @GetMapping(path = "/User", name = "GetAll")
    @ResponseStatus(HttpStatus.OK)
    public List<UserVO> readList(){
        return this.userService.getAllUsers();
    }

    // Endpoint et méthode d'affichage d'une occurence utilisateur
    @GetMapping(path = "/User/{id}", name ="GetUser")
    @ResponseStatus(HttpStatus.OK)
    public Optional<UserVO> readOne(@PathVariable Integer id){
        return this.userService.getOneUser(id);
    }

    // Endpoint et méthode de mise à jour des données d'un utilisateur
    @PutMapping(path ="/User/{id}", name ="Update")
    @ResponseStatus(HttpStatus.OK)
    public User update(@RequestBody User user,@PathVariable Integer id){
        return this.userService.UpdateUserDetails(user, id);
    }

    // Endpoint et méthode de suppression des détails d'un utilisateur
    @DeleteMapping(path = "/User/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void remove(@PathVariable Integer id){
        this.userService.removeUserDetail(id);
    }
}
