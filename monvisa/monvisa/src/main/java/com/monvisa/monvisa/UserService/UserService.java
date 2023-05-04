package com.monvisa.monvisa.UserService;

import com.monvisa.monvisa.Exceptions.UserNotFoundException;
import com.monvisa.monvisa.User.User;
import com.monvisa.monvisa.UserRepository.UserRepository;
import com.monvisa.monvisa.UserVO.UserVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.net.UnknownServiceException;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/*
* Création de classe UserService qui aura pour fonction, service utilisé pour la création des methodes appellée pour nos tâches
* Appel UserRepository pour que les méthode interagissent avec la base de données
* */
@Service
public class UserService {
    // Intialisation d'une propriété de type UserRepository
    private UserRepository userRepository;

    // création de constructeur avec paramètre correspondant à la propriété userRepository
    @Autowired
    public UserService(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    // Les différentes méthodes du service

    //Méthode de creation d'utilisateur
    public User saveUser(User user){
        return this.userRepository.save(user);
    }

    // Méthode d'affichage de la liste des personnes
    // Ici on va faire appelle à la UserVO pour ne pas afficher les mot de passes des utilisateurs
    public List<UserVO> getAllUsers(){
       List<User> users = this.userRepository.findAll();
       return users.stream().map(UserVO::new).collect(Collectors.toList());
    }


    // Méthode d'affiche d'une occurence User par son Id et sans son mot de passe
    public Optional<UserVO> getOneUser(Integer id){
        Optional<User> user = this.userRepository.findById(id);
        if(!user.isPresent()){
            throw new UserNotFoundException(String.format("Aucun utilisateur correspond à l'identifiant %s" + id));
        }
        return user.map(UserVO::new);
    }

    // Methode de mise à jour des données d'un utilisateur
    public User UpdateUserDetails(User user, Integer id){
        Optional<User> userExist = this.userRepository.findById(id);
        if(!userExist.isPresent()){
            throw new UserNotFoundException(String.format("Aucun utilisateur correspond à l'identifiant %s" + id));
        }
        return this.userRepository.save(user);
    }

    // Methode de suppression des données d'un utilisateurs
    public void removeUserDetail(Integer id){
        Optional<User> user = this.userRepository.findById(id);
        if(!user.isPresent()){
            throw new UserNotFoundException(String.format("Aucun utilisateur correspond à l'identifiant %s" + id));
        }
        this.userRepository.delete(user.get());
    }

}
