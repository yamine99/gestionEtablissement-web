package eu.ensup.dao;

import eu.ensup.domaine.Enseignant;

import java.sql.SQLException;
import java.sql.Types;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * The type Enseignant dao.
 */
public class EnseignantDao extends BaseDao implements IEnseignantDao {
    @Override
    public int createEnseignant(Enseignant enseignant) throws SQLException {

        String sql;
        try {
            connexion();
            sql = "{CALL insertEnseignant(?,?,?,?,?,?,?,?,?) } ";
            setPs(getCn().prepareCall(sql));
            getCs().setString(1, enseignant.getNom());
            getCs().setString(2, enseignant.getPrenom());
            getCs().setString(3, enseignant.getEmail());
            getCs().setString(4, enseignant.getAdresse());
            getCs().setString(5, enseignant.getTelephone());
            getCs().setString(6, enseignant.getMotDePasse());
            getCs().setString(7, enseignant.getSalt());
            getCs().setString(8, "enseignant");
            getCs().setString(9, enseignant.getMatiereEnseigne());
            getCs().registerOutParameter(10, Types.INTEGER);
            setRs(getCs().executeQuery());
            setResult(getCs().getInt(10));
            logger.info("l'enseignant " + enseignant + " à été crée.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        disconnect();
        return getResult();
    }

    @Override
    public int updateEnseignant(Enseignant enseignant) throws SQLException {
        String sql;
        try {
            connexion();
            sql = "{CALL updateEnseignant(?,?,?,?,?,?,?,?,?,?) } ";
            setCs(getCn().prepareCall(sql));
            getCs().setInt(1, enseignant.getId());
            getCs().setString(2, enseignant.getNom());
            getCs().setString(3, enseignant.getPrenom());
            getCs().setString(4, enseignant.getEmail());
            getCs().setString(5, enseignant.getAdresse());
            getCs().setString(6, enseignant.getTelephone());
            getCs().setString(7, enseignant.getMotDePasse());
            getCs().setString(8, enseignant.getSalt());
            getCs().setString(9, "enseignant");
            getCs().setString(10, enseignant.getMatiereEnseigne());
            getCs().registerOutParameter(11, Types.INTEGER);
            setRs(getCs().executeQuery());
            setResult(getCs().getInt(11));
            logger.info("l'enseignant " + enseignant + " à été modifier.");

        } catch (SQLException e) {
            e.printStackTrace();
        }
        disconnect();
        return getResult();    }

    @Override
    public int deleteEnseignant(int id) throws SQLException {
        String sql;
        try {
            connexion();
            sql = "{CALL deleteEnseignant(?,?) } ";
            setCs(getCn().prepareCall(sql));
            getCs().setInt(1, id);
            getCs().registerOutParameter(2, Types.INTEGER);
            setRs(getCs().executeQuery());
            setResult(getCs().getInt(2));
            logger.info("l'enseignant d'id " + id + " à été supprimer.");

        } catch (SQLException e) {
            e.printStackTrace();
        }
        disconnect();
        return getResult();    }

    @Override
    public Enseignant getEnseignant(int id) throws SQLException {
        String sql;
        Enseignant enseignant = new Enseignant();
        try {
            connexion();
            //sql = "SELECT * FROM personne_phys as pp ,personne as p , enseignant as e WHERE pp.id_phys = ? AND p.id_personne = ? AND e.id_ens = ? ";
            sql = "select id_personne,mat_ens,nom,prenom,email,adresse,telephone,mdp,salt,id_role from personne a join  personne_phys b on a.id_personne = b.id_phys join enseignant c on b.id_phys = c.id_ens WHERE id_personne = ?";
            setPs(getCn().prepareStatement(sql));
            getPs().setInt(1, id);
            setRs(getPs().executeQuery());
            while (getRs().next()) {
                enseignant.setId(getRs().getInt("id_personne"));
                enseignant.setMatiereEnseigne(getRs().getString("mat_ens"));
                enseignant.setNom(getRs().getString("nom"));
                enseignant.setPrenom(getRs().getString("prenom"));
                enseignant.setEmail(getRs().getString("email"));
                enseignant.setAdresse(getRs().getString("adresse"));
                enseignant.setTelephone(getRs().getString("telephone"));
                enseignant.setMotDePasse(getRs().getString("mdp"));
                enseignant.setSalt(getRs().getString("salt"));
            }
            disconnect();
            return enseignant;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        disconnect();
        return null;
    }

    @Override
    public Set<Enseignant> getAllEnseignants() throws SQLException {
        connexion();
        String sql;

        Set<Enseignant> enseignantList = new HashSet<Enseignant>();

        sql = "SELECT * FROM personne_phys as pp , personne as p , enseignant as e WHERE pp.id_phys = p.id_personne AND p.id_personne = e.id_ens ";
        setPs(getCn().prepareStatement(sql));
        setRs(getPs().executeQuery());
        while (getRs().next()) {
            enseignantList.add(new Enseignant(getRs().getInt("id_personne"),getRs().getString("nom"), getRs().getString("email"), getRs().getString("adresse"),
                    getRs().getString("telephone"), getRs().getString("prenom"), getRs().getString("mdp"), getRs().getString("salt"), getRs().getString("mat_ens")));
        }
        disconnect();
        return enseignantList;
    }
}

