package eu.ensup.service;

import eu.ensup.domaine.NoteEleve;

import java.sql.SQLException;
import java.util.List;

public interface INoteEleveService {
    /**
     * add note eleve int
     *
     * @param noteEleve the cours
     * @return int int
     */
    int addNoteEleve(NoteEleve noteEleve) throws SQLException;;

    /**
     * Update cours int.
     *
     * @param noteEleve the cours
     * @return int int
     */
    int updateNoteEleve(NoteEleve noteEleve) throws SQLException;;

    /**
     * Delete Note eleve int
     *
     * @param id the cours
     * @return int int
     */
    int deleteNoteEleve(int id) throws SQLException;

    /**
     * get Note eleve
     *
     * @param id the id
     * @return NoteEleve noteEleve
     */
    NoteEleve getNoteEleve(int id) throws SQLException;

    /**
     * Find all list.
     *
     * @return list list
     */
    List<NoteEleve> findAll() throws SQLException;
}
