package eu.ensup.domaine;

/**
 * Classe métier représentant une personne physique et qui étend une personne
 *
 * @see Personne
 */
public class PersonnePhysique extends Personne {

    private String prenom;
    private String motDePasse;
    private String salt;

    /**
     * Constructeur vide
     */
    public PersonnePhysique() {
    }

    /**
     * Instantiates a new Personne physique.
     *
     * @param id         the id
     * @param nom        the nom
     * @param email      the email
     * @param adresse    the adresse
     * @param telephone  the telephone
     * @param prenom     the prenom
     * @param motDePasse the mot de passe
     * @param salt       the salt
     */
    public PersonnePhysique(int id,String nom, String email, String adresse, String telephone, String prenom, String motDePasse, String salt) {
        super(id,nom, email, adresse, telephone);
        this.prenom = prenom;
        this.motDePasse = motDePasse;
        this.salt = salt;
    }

    /**
     * Instantiates a new Personne physique.
     *
     * @param nom        the nom
     * @param email      the email
     * @param adresse    the adresse
     * @param telephone  the telephone
     * @param prenom     the prenom
     * @param motDePasse the mot de passe
     * @param salt       the salt
     */
    public PersonnePhysique(String nom, String email, String adresse, String telephone, String prenom, String motDePasse, String salt) {
        super(nom, email, adresse, telephone);
        this.prenom = prenom;
        this.motDePasse = motDePasse;
        this.salt = salt;
    }

    /**
     * Gets prenom.
     *
     * @return l 'état du prénom
     */
    public String getPrenom() {
        return prenom;
    }

    /**
     * Sets prenom.
     *
     * @param prenom le nouveau prénom
     */
    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    /**
     * Gets mot de passe.
     *
     * @return l 'état du mot de passe
     */
    public String getMotDePasse() {
        return motDePasse;
    }

    /**
     * Sets mot de passe.
     *
     * @param motDePasse le nouveau mot de passe
     */
    public void setMotDePasse(String motDePasse) {
        this.motDePasse = motDePasse;
    }

    /**
     * Gets salt.
     *
     * @return l 'état du salt
     */
    public String getSalt() {
        return salt;
    }

    /**
     * Sets salt.
     *
     * @param salt le nouveau salt
     */
    public void setSalt(String salt) {
        this.salt = salt;
    }

    /**
     * Méthode affichant l'état d'une personne physique
     * @return l'état de la personne physique sous forme de string
     */
    @Override
    public String toString() {

        return super.toString() + "prenom=" + prenom + '\n' +
                "mot de passe=" + motDePasse + '\n' +
                "salt=" + salt + '\n' ;
    }
}
