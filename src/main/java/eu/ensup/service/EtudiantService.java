package eu.ensup.service;

import eu.ensup.dao.EtudiantDao;
import eu.ensup.dao.IEtudiantDao;
import eu.ensup.domaine.Etudiant;

import java.security.NoSuchAlgorithmException;
import java.sql.SQLException;
import java.util.Base64;
import java.util.List;
import java.util.Set;

/**
 * The type Etudiant service.
 */
public class EtudiantService implements IEtudiantService{

    private final IEtudiantDao etudiantDao = new EtudiantDao();
    private final PersonnePhysiqueService personnePhysiqueService = new PersonnePhysiqueService();

    @Override
    public int addEtudiant(Etudiant etudiant) throws SQLException {
        byte[] salt = personnePhysiqueService.createSalt();
        String hash = null;
        try {
            hash = personnePhysiqueService.generateHashPassword(etudiant.getMotDePasse(),salt);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }

        etudiant.setSalt(Base64.getEncoder().encodeToString(salt));
        etudiant.setMotDePasse(hash);
        return etudiantDao.addEtudiant(etudiant);
    }

    @Override
    public int updateEtudiant(Etudiant etudiant) throws SQLException {
        return etudiantDao.updateEtudiant(etudiant);
    }

    @Override
    public int deleteEtudiant(int id) throws SQLException {
        return etudiantDao.deleteEtudiant(id);

    }

    @Override
    public Etudiant getEtudiant(int id) throws SQLException {
        return etudiantDao.getEtudiant(id);

    }

    @Override
    public Set<Etudiant> getfindAll() throws SQLException {
        return etudiantDao.getfindAll();

    }
}
