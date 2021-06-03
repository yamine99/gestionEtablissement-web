package eu.ensup.service;

import eu.ensup.domaine.Enseignant;

import java.sql.SQLException;
import java.util.Set;

/**
 * The interface Enseignant service.
 */
public interface IEnseignantService {
    /**
     * Create enseignant int.
     *
     * @param enseignant the enseignant
     * @return the int
     * @throws SQLException the sql exception
     */
    int createEnseignant(Enseignant enseignant) throws SQLException;

    /**
     * Update enseignant int.
     *
     * @param enseignant the enseignant
     * @return the int
     * @throws SQLException the sql exception
     */
    int updateEnseignant(Enseignant enseignant) throws SQLException;

    /**
     * Delete enseignant int.
     *
     * @param id the id
     * @return the int
     * @throws SQLException the sql exception
     */
    int deleteEnseignant(int id) throws SQLException;

    /**
     * Gets enseignant.
     *
     * @param id the id
     * @return the enseignant
     * @throws SQLException the sql exception
     */
    Enseignant getEnseignant(int id) throws SQLException;

    /**
     * Gets all enseignants.
     *
     * @return the all enseignants
     * @throws SQLException the sql exception
     */
    Set<Enseignant> getAllEnseignants() throws SQLException;
}
