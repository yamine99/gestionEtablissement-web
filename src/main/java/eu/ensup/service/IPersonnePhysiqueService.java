package eu.ensup.service;

import java.security.NoSuchAlgorithmException;
import java.util.Set;

/**
 * interface pour le service Personne Physique
 */
public interface IPersonnePhysiqueService {


    /**
     * Generate hash password set.
     *
     * @param password the password
     * @param salt     the salt
     * @return the set
     * @throws NoSuchAlgorithmException the no such algorithm exception
     */
    String generateHashPassword(String password, byte[] salt) throws NoSuchAlgorithmException;

    /**
     * Create salt byte [ ].
     *
     * @return the byte [ ]
     */
    byte[] createSalt();
}
