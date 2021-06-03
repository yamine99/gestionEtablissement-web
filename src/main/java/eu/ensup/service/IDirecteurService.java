package eu.ensup.service;

import eu.ensup.domaine.Directeur;
import eu.ensup.domaine.PersonnePhysique;

import java.security.NoSuchAlgorithmException;
import java.sql.SQLException;
import java.util.Set;


/**
 * Interface du service Directeur
 */
public interface IDirecteurService {

    /**
     * Add directeur int.
     *
     * @param d the d
     * @return the int
     * @throws SQLException             the sql exception
     * @throws NoSuchAlgorithmException the no such algorithm exception
     */
    int addDirecteur(Directeur d) throws SQLException, NoSuchAlgorithmException;


    /**
     * Update directeur int.
     *
     * @param d the d
     * @return the int
     * @throws SQLException the sql exception
     */
    int updateDirecteur(Directeur d) throws SQLException;

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
