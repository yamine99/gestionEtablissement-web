package eu.ensup.service;

import eu.ensup.dao.CoursDao;
import eu.ensup.dao.ICoursDao;
import eu.ensup.dao.INoteEleve;
import eu.ensup.dao.NoteEleveDao;
import eu.ensup.domaine.NoteEleve;

import java.sql.SQLException;
import java.util.List;

public class NoteEleveService implements INoteEleveService{
    private final INoteEleve noteEleveDao = new NoteEleveDao();
    @Override
    public int addNoteEleve(NoteEleve noteEleve) throws SQLException {
        return noteEleveDao.addNoteEleve(noteEleve);
    }

    @Override
    public int updateNoteEleve(NoteEleve noteEleve) throws SQLException {
        return noteEleveDao.updateNoteEleve(noteEleve);
    }

    @Override
    public int deleteNoteEleve(int id) throws SQLException {
        return noteEleveDao.deleteNoteEleve(id);
    }

    @Override
    public NoteEleve getNoteEleve(int id) throws SQLException {
        return noteEleveDao.getNoteEleve(id);
    }

    @Override
    public List<NoteEleve> findAll() throws SQLException {
        return noteEleveDao.findAll();
    }
}
