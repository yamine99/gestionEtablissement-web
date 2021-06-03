package eu.ensup.dao;

import eu.ensup.domaine.Etudiant;

import java.sql.Date;
import java.sql.SQLException;
import java.sql.Types;
import java.util.*;

/**
 * The type Data base etudiant dao.
 */
public class EtudiantDao extends BaseDao implements IEtudiantDao {
    @Override
    public int addEtudiant(Etudiant etudiant) {
        String sql;
        try {
            connexion();
            sql = "{CALL insertEtudiant(?,?,?,?,?,?,?,?,?,?) } ";
            setCs(getCn().prepareCall(sql));
            getCs().setString(1, etudiant.getNom());
            getCs().setString(2, etudiant.getPrenom());
            getCs().setString(3, etudiant.getEmail());
            getCs().setString(4, etudiant.getAdresse());
            getCs().setString(5, etudiant.getTelephone());
            getCs().setString(6, etudiant.getMotDePasse());
            getCs().setString(7, etudiant.getSalt());
            getCs().setString(8, "etudiant");
            getCs().setDate(9,etudiant.getDateNaissance());
            getCs().registerOutParameter(10, Types.INTEGER);
            setRs(getCs().executeQuery());
            setResult(getCs().getInt(10));
            logger.info("l'étudiant " + etudiant + " a été créé.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        disconnect();
        return getResult();
    }

    @Override
    public int updateEtudiant(Etudiant etudiant) {

        String sql;
        try {
            connexion();
            sql = "{CALL updateEtudiant(?,?,?,?,?,?,?,?,?,?,?) } ";
            setCs(getCn().prepareCall(sql));
            getCs().setInt(1, etudiant.getId());
            getCs().setString(2, etudiant.getNom());
            getCs().setString(3, etudiant.getPrenom());
            getCs().setString(4, etudiant.getEmail());
            getCs().setString(5, etudiant.getAdresse());
            getCs().setString(6, etudiant.getTelephone());
            getCs().setString(7, etudiant.getMotDePasse());
            getCs().setString(8, etudiant.getSalt());
            getCs().setString(9, "etudiant");
            getCs().setDate(10,etudiant.getDateNaissance());
            getCs().registerOutParameter(11, Types.INTEGER);
            setRs(getCs().executeQuery());
            setResult(getCs().getInt(11));
            logger.info("l'étudiant " + etudiant + " a été modifié.");

        } catch (SQLException e) {
            e.printStackTrace();
        }
        disconnect();
        return getResult();
    }

    @Override
    public int deleteEtudiant(int id) {
        String sql;
        try {
            connexion();
            sql = "{CALL deleteEtudiant(?,?) } ";
            setCs(getCn().prepareCall(sql));
            getCs().setInt(1, id);
            getCs().registerOutParameter(2, Types.INTEGER);
            setRs(getCs().executeQuery());
            setResult(getCs().getInt(2));
            logger.info("l'étudiant a été supprimé.");

        } catch (SQLException e) {
            e.printStackTrace();
        }
        disconnect();
        return getResult();

    }

    @Override
    public Etudiant getEtudiant(int id) {
        String sql;
        Etudiant etudiant = new Etudiant();
        try {
            connexion();
            sql = "select id_personne,date_naissance,nom,prenom,email,adresse,telephone,mdp,salt,id_role from personne a join  personne_phys b on a.id_personne = b.id_phys join etudiant c on b.id_phys = c.id_etudiant WHERE id_personne = ?";
            setPs(getCn().prepareStatement(sql));
            getPs().setInt(1, id);
            setRs(getPs().executeQuery());
            while (getRs().next()) {
                etudiant.setDateNaissance(getRs().getDate("date_naissance"));
                etudiant.setNom(getRs().getString("nom"));
                etudiant.setPrenom(getRs().getString("prenom"));
                etudiant.setEmail(getRs().getString("email"));
                etudiant.setAdresse(getRs().getString("adresse"));
                etudiant.setTelephone(getRs().getString("telephone"));
                etudiant.setMotDePasse(getRs().getString("mdp"));
                etudiant.setSalt(getRs().getString("salt"));
            }
            disconnect();
            return etudiant;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        disconnect();
        return null;
    }

    @Override
    public Set<Etudiant> getfindAll() throws SQLException {
        connexion();
        String sql;

        Set<Etudiant> etudiantList = new HashSet<>();

        sql = "SELECT * FROM personne_phys as pp , personne as p , etudiant as e WHERE pp.id_phys = p.id_personne AND p.id_personne = e.id_etudiant ";
        setPs(getCn().prepareStatement(sql));
        setRs(getPs().executeQuery());
        while (getRs().next()) {
            etudiantList.add(new Etudiant(getRs().getInt("id_personne"),getRs().getString("nom"), getRs().getString("email"), getRs().getString("adresse"),
                    getRs().getString("telephone"), getRs().getString("prenom"), getRs().getString("mdp"), getRs().getString("salt"), getRs().getDate("date_naissance")));
        }
        getPs().close();
        getRs().close();
        disconnect();
        return etudiantList;

    }
}
