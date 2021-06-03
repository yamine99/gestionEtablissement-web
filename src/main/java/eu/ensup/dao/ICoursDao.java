package eu.ensup.dao;
import eu.ensup.domaine.Cours;
import eu.ensup.domaine.Etudiant;

import java.sql.ResultSet;
import java.util.List;

/**
 * The interface Cours dao.
 */
public interface ICoursDao {

    /**
     * add cours int
     *
     * @param cours the cours
     * @return int int
     */
    int addCours(Cours cours);

    /**
     * Update cours int.
     *
     * @param cours the cours
     * @return int int
     */
    int updateCours(Cours cours);

    /**
     * Delete cours int
     *
     * @param cours the cours
     * @return int int
     */
    int deleteCours(Cours cours);

    /**
     * get cours
     *
     * @param id the id
     * @return cours cours
     */
    Cours getCours(int id);

    /**
     * Find all list.
     *
     * @return list list
     */
    List<Cours> findAll();

    /**
     * Inscreption result set.
     *
     * @param c the c
     * @param e the e
     * @return the result set
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
