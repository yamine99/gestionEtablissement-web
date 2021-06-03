package eu.ensup.dao;

import eu.ensup.domaine.Directeur;

import java.sql.SQLException;
import java.util.Set;

/**
 * Interface DAO de directeur
 */
public interface IDirecteurDao {

    /**
     * Create directeur int.
     *
     * @param p the p
     * @return the int
     * @throws SQLException the sql exception
     */
    int createDirecteur(Directeur p) throws SQLException;

    /**
     * Update directeur int.
     *
     * @param p the p
     * @return the int
     * @throws SQLException the sql exception
     */
    int updateDirecteur(Directeur p) throws SQLException;

    /**
     * Delete directeur int.
     *
     * @param id the id
     * @return the int
     * @throws SQLException the sql exception
     */
    int deleteDirecteur(int id) throws SQLException;

    /**
     * Gets directeur.
     *
     * @param id the id
     * @return the directeur
     * @throws SQLException the sql exception
     */
    Directeur getDirecteur(int id) throws SQLException;


    /**
     * Gets all directeurs.
     *
     * @return the all directeurs
     * @throws SQLException the sql exception
     */
    Set<Directeur> getAllDirecteurs() throws SQLException;



}
