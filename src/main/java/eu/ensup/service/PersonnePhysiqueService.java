package eu.ensup.service;

import eu.ensup.domaine.PersonnePhysique;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.sql.SQLException;
import java.util.Base64;

/**
 * Classe personne physique permettant la gestion des propriétés d'une personne physique
 */
public class PersonnePhysiqueService implements IPersonnePhysiqueService{

    private static final String  algo = "SHA-256";

    /**
     * Valid personne physique int.
     *
     * @param p1       the p 1
     * @param password the password
     * @return the int
     * @throws NoSuchAlgorithmException the no such algorithm exception
     */
    public int validPersonnePhysique(PersonnePhysique p1, String password) throws NoSuchAlgorithmException {
        byte[] salt = Base64.getDecoder().decode(p1.getSalt());
        String hash = generateHashPassword(password,salt);
        return hash.equals(p1.getMotDePasse()) ? 1 : 0;
    }


    /**
     * Constante de l'algorithme utilisé pour le hashage des mots de passes.
     */

    /**
     * Méthode permettant de générer le salt et le mot de passe d'une personne
     * @param password mot de passe de l'utilisateur non hashé
     * @return un set de string comportant le salt et le mot de passe hashé
     * @throws NoSuchAlgorithmException erreur employée si l'algorithme de hashage n'existe pas
     */
    @Override
    public String generateHashPassword(String password, byte[] salt) throws NoSuchAlgorithmException {
        MessageDigest digest = MessageDigest.getInstance(algo);
        digest.reset();
        digest.update(salt);
       return Base64.getEncoder().encodeToString(digest.digest(password.getBytes()));
    }

    /**
     * Méthode permettant de créer le salt
     * @return le salt en type bytes
     */
    public  byte[] createSalt(){
        byte[] bytes = new byte[20];
        SecureRandom random = new SecureRandom();
        random.nextBytes(bytes);
        return bytes;
    }


}
