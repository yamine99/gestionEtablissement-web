package eu.ensup.service;

import eu.ensup.domaine.Etudiant;

import java.sql.SQLException;
import java.util.List;
import java.util.Set;

/**
 * The interface Etudiant service.
 */
public interface IEtudiantService {
    /**
     * Add etudiant int.
     *
     * @param etudiant the etudiant
     * @return the int
     * @throws SQLException the sql exception
     */
    int addEtudiant(Etudiant etudiant) throws SQLException;

    /**
     * Update etudiant int.
     *
     * @param etudiant the etudiant
     * @return the int
     * @throws SQLException the sql exception
     */
    int updateEtudiant(Etudiant etudiant) throws SQLException;

    /**
     * Delete etudiant int.
     *
     * @param is the is
     * @return the int
     * @throws SQLException the sql exception
     */
    int deleteEtudiant(int is) throws SQLException;

    /**
     * Gets etudiant.
     *
     * @param id the id
     * @return the etudiant
     * @throws SQLException the sql exception
     */
    Etudiant getEtudiant(int id) throws SQLException;

    /**
     * Find all list.
     *
     * @return the list
     * @throws SQLException the sql exception
     */
    Set<Etudiant> getfindAll() throws SQLException;

}
