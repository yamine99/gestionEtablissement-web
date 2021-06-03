package eu.ensup.service;

import eu.ensup.dao.ResponsableDao;
import eu.ensup.domaine.Directeur;
import eu.ensup.domaine.Responsable;

import java.security.NoSuchAlgorithmException;
import java.sql.SQLException;
import java.util.Base64;
import java.util.List;
import java.util.Set;

/**
 * The type Responsable service.
 */
public class ResponsableService implements IResponsableService {

    private final ResponsableDao responsableDao = new ResponsableDao();
    private final PersonnePhysiqueService personnePhysiqueService = new PersonnePhysiqueService();

    /**
     * Méthode permettant d'ajouter un responsable
     * @param r
     * @return integer
     * @throws NoSuchAlgorithmException
     */
    @Override
    public int addResponsable(Responsable r) throws NoSuchAlgorithmException {
        byte[] salt = personnePhysiqueService.createSalt();
        String hash = personnePhysiqueService.generateHashPassword(r.getMotDePasse(),salt);

        r.setSalt(Base64.getEncoder().encodeToString(salt));
        r.setMotDePasse(hash);
        return responsableDao.createResponsable(r);
    }

    /**
     * Méthode permettant de mettre à jour un responsable
     * @param r
     * @return integer
     * @throws SQLException
     */
    @Override
    public int updateResponsable(Responsable r) throws SQLException {
        return responsableDao.updateResponsable(r);
    }

    /**
     * Méthode permettant la suppression  d'un responsable
     * @param id
     * @return integer
     * @throws SQLException
     */
    @Override
    public int deleteResponsable(int id) throws SQLException {
        return responsableDao.deleteResponsable(id);
    }

    /**
     * Méthode permettant la récupération d'un directeur par son identifiant
     * @param id
     * @return responsable
     * @throws SQLException
     */
    @Override
    public Responsable getResponsable(int id) throws SQLException {
        return responsableDao.getResponsable(id);
    }

    /**
     * Mérhode permettant la récupération de tous les directeurs
     * @return integer
     * @throws SQLException
     */
    @Override
    public Set<Responsable> getAllResponsables() throws SQLException {
        return responsableDao.getAllResponsables();
    }

    /**
     *
     * @param r
     * @param password
     * @return integer
     * @throws NoSuchAlgorithmException return exception
     */
    @Override
    public int validResponsableAuthentification(Responsable r, String password) throws NoSuchAlgorithmException {
        return personnePhysiqueService.validPersonnePhysique(r,password);
    }

    @Override
    public Responsable getCredentialByEmail(String email) throws SQLException {
        return responsableDao.getCredentialByEmail(email);
    }
    @Override
    public int validAuthentification(Responsable r, String password) throws NoSuchAlgorithmException {
        if(r == null || r.getEmail() == null){
            return -1;
        } else {
            return personnePhysiqueService.validPersonnePhysique(r,password);
        }

    }
}
