package eu.ensup.service;

import eu.ensup.dao.DirecteurDao;
import eu.ensup.domaine.Directeur;

import java.security.NoSuchAlgorithmException;
import java.sql.SQLException;
import java.util.Base64;
import java.util.Set;

/**
 * Classe service de directeur implémentant l'interface IDirecteurService
 *
 * @see IDirecteurService
 */
public class DirecteurService implements IDirecteurService {

    /**
     * Constante faisant appel à la classe dao DirecteurDao
     */
    private final DirecteurDao directeurDao = new DirecteurDao();

    private final PersonnePhysiqueService personnePhysiqueService = new PersonnePhysiqueService();

    /**
     * Méthode permettant d'ajouter un directeur
     * @param d un directeur
     * @return un entier représentant le résultat
     * @throws SQLException exception SQL
     */
    @Override
    public int addDirecteur(Directeur d) throws SQLException, NoSuchAlgorithmException {
        byte[] salt = personnePhysiqueService.createSalt();
        String hash = personnePhysiqueService.generateHashPassword(d.getMotDePasse(),salt);

        d.setSalt(Base64.getEncoder().encodeToString(salt));
        d.setMotDePasse(hash);
        return directeurDao.createDirecteur(d);
    }

    /**
     * Méthode permettant de mettre à jour un directeur
     * @param d un directeur
     * @return un entier représentant le résultat
     * @throws SQLException exception SQL
     */
    @Override
    public int updateDirecteur(Directeur d) throws SQLException {
        return directeurDao.updateDirecteur(d);
    }

    /**
     * Methode permettant la supression d'un directeur
     * @param id identifiant du directeur
     * @return un entier représentant le résultat
     * @throws SQLException exception SQL
     */
    @Override
    public int deleteDirecteur(int id) throws SQLException {
        return directeurDao.deleteDirecteur(id);
    }

    /**
     * Méthode permettant la récupération d'un directeur par son identifiant
     * @param id identifiant du directeur
     * @return un directeur
     * @throws SQLException exception SQL
     */
    @Override
    public Directeur getDirecteur(int id) throws SQLException {
        return directeurDao.getDirecteur(id);
    }


    /**
     * Mérhode permettant la récupération de tous les directeurs
     * @return une liste de directeurs
     * @throws SQLException exception SQL
     */
    @Override
    public Set<Directeur> getAllDirecteurs() throws SQLException {
        return directeurDao.getAllDirecteurs();
    }


}
