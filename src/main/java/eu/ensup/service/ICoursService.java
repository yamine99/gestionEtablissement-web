package eu.ensup.service;

import eu.ensup.domaine.Cours;
import eu.ensup.domaine.Etudiant;

import java.sql.ResultSet;


import java.util.List;

/**
 * The interface Cours service.
 */
public interface ICoursService {
    /**
     * Add cours int.
     *
     * @param cours the cours
     * @return the int
     */
    int addCours(Cours cours);

    /**
     * Update cours int.
     *
     * @param cours the cours
     * @return the int
     */
    int updateCours(Cours cours);

    /**
     * Delete cours int.
     *
     * @param cours the cours
     * @return the int
     */
    int deleteCours(Cours cours);

    /**
     * Gets cours.
     *
     * @param id the id
     * @return the cours
     */
    Cours getCours(int id);

    /**
     * Find all list.
     *
     * @return the list
     */
    List<Cours> findAll();

    /**
     * Inscription int.
     *
     * @param c the c
     * @param e the e
     * @return the int
     */
    int inscription(Cours c, Etudiant e);

    /**
     * Gets cours etudiant.
     *
     * @param idEtudiant the id etudiant
     * @return the cours etudiant
     */
    List<Cours> getCoursEtudiant(int idEtudiant);
}
