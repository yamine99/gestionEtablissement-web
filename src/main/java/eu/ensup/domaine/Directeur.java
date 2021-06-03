package eu.ensup.domaine;

import eu.ensup.domaine.Responsable;
import java.util.ArrayList;
import java.util.List;

/**
 * The type Directeur.
=======
import java.util.ArrayList;
import java.util.List;

/**
 * Classe métier représentant un directeur
 */
public class Directeur extends Responsable {

    private List<Etablissement> etablissements = new ArrayList<>();

    /**
     * Constructeur vide
     */
    public Directeur() {
    }

    /**
     * Constructeur avec tous les paramètres
     * @param nom le nom du directeur
     * @param email l'email du directeur
     * @param adresse l'adresse du directeur
     * @param telephone le téléphone du directeur
     * @param prenom le prénom du directeur
     * @param motDePasse le mot de passe du directeurPersonnePhysique
     * @param salt le salt du directeur
     * @param etablissements l'établissement du directeur
     */
    public Directeur(int id, String nom, String email, String adresse, String telephone, String prenom, String motDePasse, String salt, List<Etablissement> etablissements) {
        super(id, nom, email, adresse, telephone, prenom, motDePasse, salt);
        this.etablissements = etablissements;
    }

    /**
     *
     * @return l'état de la propriété etablissements
     */
    public List<Etablissement> getEtablissements() {
        return etablissements;
    }

    /**
     *
     * @param etablissements la liste des etablissements du directeur
     */
    public void setEtablissements(List<Etablissement> etablissements) {
        this.etablissements = etablissements;
    }


    /**
     * Méthode permettant d'afficher l'état d'un directeur
     * @return l'état du directeur sous forme de String
     */
    @Override
    public String toString() {
        return super.toString() + "etablissements=" + etablissements + '\n';
    }
}
