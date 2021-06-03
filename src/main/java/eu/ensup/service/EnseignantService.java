package eu.ensup.service;

import eu.ensup.dao.EnseignantDao;
import eu.ensup.dao.IEnseignantDao;
import eu.ensup.domaine.Enseignant;

import java.sql.SQLException;
import java.util.Set;

/**
 * The type Enseignant service.
 */
public class EnseignantService implements IEnseignantService{
    private final IEnseignantDao enseignantDao = new EnseignantDao();

    @Override
    public int createEnseignant(Enseignant enseignant) throws SQLException {
        return enseignantDao.createEnseignant(enseignant);
    }

    @Override
    public int updateEnseignant(Enseignant enseignant) throws SQLException {
        return enseignantDao.updateEnseignant(enseignant);
    }

    @Override
    public int deleteEnseignant(int id) throws SQLException {
        return enseignantDao.deleteEnseignant(id);
    }

    @Override
    public Enseignant getEnseignant(int id) throws SQLException {
        return enseignantDao.getEnseignant(id);
    }

    @Override
    public Set<Enseignant> getAllEnseignants() throws SQLException {
        return enseignantDao.getAllEnseignants();
    }
}
