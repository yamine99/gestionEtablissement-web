package eu.ensup.service;

import eu.ensup.domaine.Directeur;
import eu.ensup.domaine.Responsable;

import java.security.NoSuchAlgorithmException;
import java.sql.SQLException;
import java.util.List;
import java.util.Set;

/**
 * The interface Responsable service.
 */
public interface IResponsableService {

    /**
     * Add responsable int.
     *
     * @param r the r
     * @return the int
     * @throws SQLException             the sql exception
     * @throws NoSuchAlgorithmException the no such algorithm exception
     */
    int addResponsable(Responsable r) throws SQLException, NoSuchAlgorithmException;

    /**
     * Update responsable int.
     *
     * @param r the r
     * @return the int
     * @throws SQLException the sql exception
     */
    int updateResponsable(Responsable r) throws SQLException;

    /**
     * Delete responsable int.
     *
     * @param id the id
     * @return the int
     * @throws SQLException the sql exception
     */
    int deleteResponsable(int id) throws SQLException;

    /**
     * Gets responsable.
     *
     * @param id the id
     * @return the responsable
     * @throws SQLException the sql exception
     */
    Responsable getResponsable(int id) throws SQLException;

    /**
     * Gets all responsables.
     *
     * @return the all responsables
     * @throws SQLException the sql exception
     */
    Set<Responsable> getAllResponsables() throws SQLException;

    /**
     * Valid responsable authentification int.
     *
     * @param r        the r
     * @param password the password
     * @return the int
     * @throws NoSuchAlgorithmException the no such algorithm exception
     */
    int validResponsableAuthentification(Responsable r, String password) throws NoSuchAlgorithmException;

    /**
     * Gets credential by email.
     *
     * @param email the email
     * @return the credential by email
     * @throws SQLException the sql exception
     */
    Responsable getCredentialByEmail(String email) throws SQLException;

    /**
     * Valid directeur authentification int.
     *
     * @param r        the Responsable
     * @param password the password
     * @return the int
     * @throws NoSuchAlgorithmException the no such algorithm exception
     */
    int validAuthentification(Responsable r, String password) throws NoSuchAlgorithmException;

}
