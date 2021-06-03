package eu.ensup.domaine;

import java.util.ArrayList;
import java.util.List;

/**
 * Classe métier représentant une personne
 */
public class Personne {

    private int id;
    private String nom;
    private String email;
    private String adresse;
    private String telephone;

    /**
     * Constructeur vide
     */
    public Personne() {
    }

    /**
     * Constructeur avec toutes les propriétés
     *
     * @param id        the id
     * @param nom       le nom de la personne
     * @param email     l'email de la personne
     * @param adresse   l'adresse de la personne
     * @param telephone le téléphone de la personne
     */
    public Personne(int id,String nom, String email, String adresse, String telephone) {
        this.id = id;
        this.nom = nom;
        this.email = email;
        this.adresse = adresse;
        this.telephone = telephone;
    }

    /**
     * Instantiates a new Personne.
     *
     * @param nom       the nom
     * @param email     the email
     * @param adresse   the adresse
     * @param telephone the telephone
     */
    public Personne(String nom, String email, String adresse, String telephone) {
        this.nom = nom;
        this.email = email;
        this.adresse = adresse;
        this.telephone = telephone;
    }


    /**
     * Gets id.
     *
     * @return l 'état de l'id
     */
    public int getId() {
        return id;
    }

    /**
     * Sets id.
     *
     * @param id le nouvel id de la personne
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Gets nom.
     *
     * @return l 'état du nom
     */
    public String getNom() {
        return nom;
    }

    /**
     * Sets nom.
     *
     * @param nom le nouveau nom de la personne
     */
    public void setNom(String nom) {
        this.nom = nom;
    }

    /**
     * Gets email.
     *
     * @return l 'état de l'email
     */
    public String getEmail() {
        return email;
    }

    /**
     * Sets email.
     *
     * @param email le nouvel email de la personne
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * Gets adresse.
     *
     * @return l 'état de l'adresse
     */
    public String getAdresse() {
        return adresse;
    }

    /**
     * Sets adresse.
     *
     * @param adresse la nouvelle adresse de la personne
     */
    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    /**
     * Gets telephone.
     *
     * @return l 'état du téléphone
     */
    public String getTelephone() {
        return telephone;
    }

    /**
     * Sets telephone.
     *
     * @param telephone the telephone
     */
    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    /**
     * Méthode permettant d'afficher l'état de l'objet
     * @return retourne l'état sous forme de string
     */
    @Override
    public String toString() {
        return "id=" + id + '\n' +
                "nom=" + nom + '\n' +
                "email=" + email + '\n' +
                "adresse=" + adresse + '\n' +
                "telephone=" + telephone + '\n';
    }


}
