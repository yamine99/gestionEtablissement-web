package eu.ensup.service;

import eu.ensup.dao.CoursDao;
import eu.ensup.dao.ICoursDao;
import eu.ensup.domaine.Cours;

import eu.ensup.domaine.Etudiant;

import java.sql.ResultSet;
import java.util.List;

/**
 * The type Cours service.
 */
public class CoursService implements ICoursService {
    private final ICoursDao coursDao = new CoursDao();
    @Override
    public int addCours(Cours cours) {
        return coursDao.addCours(cours);
    }

    @Override
    public int updateCours(Cours cours) {
        return coursDao.updateCours(cours);
    }

    @Override
    public int deleteCours(Cours cours) {
        return coursDao.deleteCours(cours);
    }

    @Override
    public Cours getCours(int id) {
        return coursDao.getCours(id);
    }

    @Override
    public List<Cours> findAll() {
        return coursDao.findAll();
    }

    @Override
    public int inscription(Cours c, Etudiant e) {
        return coursDao.inscription(c, e);
    }

    @Override
    public List<Cours> getCoursEtudiant(int idEtudiant) {
        return coursDao.getCoursEtudiant(idEtudiant);
    }

}
