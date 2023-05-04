package com.monvisa.monvisa.User;

import javax.persistence.*;

@Entity
@Table(name="utilisateurs")
public class User {
    /*
     * Initialisation des propriété de la classe User
     * Creation de constructeur
     * Mise en place des Getter et les Setter des differentes propriétes
     */

    // Propriétés
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name ="id_u")
    private Integer id;
    @Column(name="nom")
    private String nom;
    @Column(name="prenom")
    private String prenom;
    @Column(name="email")
    private String email;
    @Column(name="password")
    private String password;

    //Constructeurs
    //Constructeur sans paramètre
    public User(){}

    //Constructeur avec paramètres et assignation des ces paramètres aux propriétés
    public User(Integer id, String nom, String prenom, String email, String password){
        this.id = id;
        this.nom = nom;
        this.prenom = prenom;
        this.email = email;
        this.password = password;
    }

    // Getter et Setter des différentes propriétés

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
    public void SetEmail(String email){ this.email = email;}

    // Getter & Setter nom
    public String getPassword(){return password;}
    public void SetPassword(String password){ this.password = password;}


}
