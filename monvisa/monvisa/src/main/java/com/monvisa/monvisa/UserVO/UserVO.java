package com.monvisa.monvisa.UserVO;

import com.monvisa.monvisa.User.User;

/*
* Classe permettant de ne pas utiliser directement les donnée de l'entité User et aussi restreindre à utiliser
* Initialisations des propriétés qui correspondent à celles de l'entity User
* Correspondance des variables de l'entité User à celles du VO dans un constructeur
* Mise en place des Getter et Setter des propriétés du VO
* NB: Le but de ce VO est de seulement que les données moins sensible de l'entité
* */
public class UserVO {
    // propriétés
    private Integer id;
    private String nom;
    private String prenom;
    private String email;


    // Constructeurs

    // Sans Paramètres
    public UserVO(){}

    // Avec paramètres
    public UserVO(User user){
        this.id = user.getId();
        this.nom = user.getNom();
        this.prenom = user.getPrenom();
        this.email = user.getEmail();
    }

    // Getter et Setter des propriétés du VO

    // Getter & Setter Id
    public Integer getId(){return id;}
    public void SetId(Integer id){ this.id = id;}

    // Getter & Setter nom
    public String getNom(){return nom;}
    public void SetNom(String nom){ this.nom = nom;}

    // Getter & Setter prenom
    public String getPrenom(){return prenom;}
    public void SetPenom(String prenom){ this.prenom = prenom;}

    // Getter & Setter email
    public String getEmail(){return email;}
    public void SetEmail(String email){ this.nom = email;}

}
