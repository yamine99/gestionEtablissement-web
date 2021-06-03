package eu.ensup.dao;

import eu.ensup.domaine.Cours;
import eu.ensup.domaine.Enseignant;
import eu.ensup.domaine.NoteEleve;

import java.sql.SQLException;
import java.sql.Types;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class NoteEleveDao extends BaseDao implements INoteEleve {
    @Override
    public int addNoteEleve(NoteEleve noteEleve) throws SQLException {
        String sql;
        try {
            connexion();
            sql = "{CALL InsertNote(?,?,?,?) } ";
            setCs(getCn().prepareCall(sql));
            getCs().setInt(1, noteEleve.getCours().getId());
            getCs().setInt(2, noteEleve.getEtudiant().getId());
            getCs().setFloat(3, noteEleve.getNote());
            getCs().setFloat(4, noteEleve.getCoeff());
            getCs().registerOutParameter(10, Types.INTEGER);
            setRs(getCs().executeQuery());
            setResult(getCs().getInt(10));
            logger.info("la note de l'eléve " + noteEleve.getEtudiant().getPrenom() +" "+ noteEleve.getEtudiant().getNom() + " a été créé.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        disconnect();
        return getResult();
    }

    @Override
    public int updateNoteEleve(NoteEleve noteEleve) throws SQLException{
        String sql;
        try {
            connexion();
            sql = "{CALL updateNote(?,?,?,?) } ";
            setCs(getCn().prepareCall(sql));
            getCs().setInt(1, noteEleve.getCours().getId());
            getCs().setInt(2, noteEleve.getEtudiant().getId());
            getCs().setFloat(3, noteEleve.getNote());
            getCs().setFloat(4, noteEleve.getCoeff());
            getCs().registerOutParameter(11, Types.INTEGER);
            setRs(getCs().executeQuery());
            setResult(getCs().getInt(11));
            logger.info("la note de l'eléve " + noteEleve.getEtudiant().getPrenom() +" "+ noteEleve.getEtudiant().getNom() + " a été modifié.");

        } catch (SQLException e) {
            e.printStackTrace();
        }
        disconnect();
        return getResult();
    }

    @Override
    public int deleteNoteEleve(int id) throws SQLException {
        String sql;
        try {
            connexion();
            sql = "{CALL deleteNote(?,?) } ";
            setCs(getCn().prepareCall(sql));
            getCs().setInt(1, id);
            getCs().registerOutParameter(2, Types.INTEGER);
            setRs(getCs().executeQuery());
            setResult(getCs().getInt(2));
            logger.info("la note de l'eléve a été supprimé.");

        } catch (SQLException e) {
            e.printStackTrace();
        }
        disconnect();
        return getResult();
    }

    @Override
    public NoteEleve getNoteEleve(int id) throws SQLException {
        String sql;
        NoteEleve noteEleve = new NoteEleve();
        try {
            connexion();
            sql = "Select * from notes where id_note=?";
            BaseDao.setPs(BaseDao.getCn().prepareStatement(sql));
            BaseDao.getPs().setInt(1, id);
            BaseDao.setRs(BaseDao.getPs().executeQuery());
            while (getRs().next()) {
                return new NoteEleve(getRs().getInt("id_note"), getRs().getFloat("note"), getRs().getFloat("coeif"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        disconnect();
        return null;
    }

    @Override
    public List<NoteEleve> findAll() throws SQLException {
        connexion();
        String sql;

        List<NoteEleve> noteEleves = new ArrayList<NoteEleve>();

        sql = "SELECT * FROM notes ";
        setPs(getCn().prepareStatement(sql));
        setRs(getPs().executeQuery());
        while (getRs().next()) {
            noteEleves.add(new NoteEleve(getRs().getInt("id_note"),getRs().getFloat("note"),getRs().getFloat("coeif")));
        }
        disconnect();
        return noteEleves;
    }
}
