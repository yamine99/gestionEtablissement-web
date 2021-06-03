package eu.ensup.dao;

import eu.ensup.domaine.Directeur;
import eu.ensup.domaine.Responsable;

import java.sql.SQLException;
import java.util.List;
import java.util.Set;

/**
 * The interface Responsable dao.
 */
public interface IResponsableDao {
    /**
     * Create responsable int.
     *
     * @param r the r
     * @return the int
     * @throws SQLException the sql exception
     */
    int createResponsable(Responsable r) throws SQLException;

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
     * Gets credential by email.
     *
     * @param email the email
     * @return the credential by email
     * @throws SQLException the sql exception
     */
    Responsable getCredentialByEmail(String email) throws SQLException;

}
