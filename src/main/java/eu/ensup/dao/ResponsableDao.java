package eu.ensup.dao;

import eu.ensup.domaine.Directeur;
import eu.ensup.domaine.Responsable;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Types;
import java.util.HashSet;
import java.util.Set;

/**
 * The type Responsable dao.
 */
public class ResponsableDao extends BaseDao implements IResponsableDao {
    /**
     * Méthode permettant de créer dans la base de données un responsable
     * @param r un responsable
     * @return un entier validant ou non l'opération
     */
    @Override
    public int createResponsable(Responsable r) {
        String sql;
        try {
            connexion();
            sql = "{CALL insertRes_etude(?,?,?,?,?,?,?,?,?) } ";
            setCs(getCn().prepareCall(sql));
            getCs().setString(1, r.getNom());
            getCs().setString(2, r.getPrenom());
            getCs().setString(3, r.getEmail());
            getCs().setString(4, r.getAdresse());
            getCs().setString(5, r.getTelephone());
            getCs().setString(6, r.getMotDePasse());
            getCs().setString(7, r.getSalt());
            getCs().setString(8, "responsable");
            getCs().registerOutParameter(9, Types.INTEGER);
            setRs(getCs().executeQuery());
            setResult(getCs().getInt(9));
            logger.info("le responsable  " + r + " à été crée.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        disconnect();
        return getResult();
    }

    /**
     * Méthode permettant de mettre à jour un responsable dans la base de données
     * @param r un responsable
     * @return un entier validant ou non l'opération
     */
    @Override
    public int updateResponsable(Responsable r) {
        String sql;
        try {
            connexion();
            sql = "{CALL updateResponsable(?,?,?,?,?,?,?,?,?,?) } ";
            setCs(getCn().prepareCall(sql));
            getCs().setInt(1, r.getId());
            getCs().setString(2, r.getNom());
            getCs().setString(3, r.getPrenom());
            getCs().setString(4, r.getEmail());
            getCs().setString(5, r.getAdresse());
            getCs().setString(6, r.getTelephone());
            getCs().setString(7, r.getMotDePasse());
            getCs().setString(8, r.getSalt());
            getCs().setString(9, "responsable");
            getCs().registerOutParameter(10, Types.INTEGER);
            setRs(getCs().executeQuery());
            setResult(getCs().getInt(10));
            logger.info("le responsable " + r + " à été modifier.");

        } catch (SQLException e) {
            e.printStackTrace();
        }
        disconnect();
        return getResult();
    }

    /**
     * Methode permettant la supression d'un responsable dans la base de données
     * @param id l'identifiant d'un responsable
     * @return un entier validant ou non l'opération
     */
    @Override
    public int deleteResponsable(int id)  {
        String sql;
        try {
            connexion();
            sql = "{CALL deleteResponsable(?,?) } ";
            setCs(getCn().prepareCall(sql));
            getCs().setInt(1, id);
            getCs().registerOutParameter(2, Types.INTEGER);
            setRs(getCs().executeQuery());
            setResult(getCs().getInt(2));
            logger.info("le responsable d'id " + id + " à été supprimer.");

        } catch (SQLException e) {
            e.printStackTrace();
        }
        disconnect();
        return getResult();
    }

    /**
     * Méthode permettant la récupération d'un responsable de la base de données par son identifiant
     * @param id identifiant du reponsable
     * @return un responsable
     */
    @Override
    public Responsable getResponsable(int id) {
        String sql;
        Responsable res = new Responsable();
        try {
            connexion();
            sql = "select * from res_etude WHERE id_res= ?";
            setPs(getCn().prepareStatement(sql));
            getPs().setInt(1, id);
            setRs(getPs().executeQuery());
            while (getRs().next()) {
                res = new Responsable(getRs().getInt("id_res"),getRs().getString("nom"), getRs().getString("email"), getRs().getString("adresse"),
                        getRs().getString("telephone"), getRs().getString("prenom"), getRs().getString("mdp"), getRs().getString("salt"));
            }
            disconnect();
            return res;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        disconnect();
        return null;
    }

    /**
     * Mérhode permettant la récupération de tous les responsables de la base de données
     * @return tous les responsables
     * @throws SQLException exception sql
     */
    @Override
    public Set<Responsable> getAllResponsables() throws SQLException {
        connexion();
        String sql;

        Set<Responsable> responsables = new HashSet<>();

        sql = "SELECT * FROM personne_phys as pp , personne as p , enseignant as e WHERE pp.id_phys = p.id_personne AND p.id_personne = e.id_ens ";
        setPs(getCn().prepareStatement(sql));
        setRs(getPs().executeQuery());
        while (getRs().next()) {
            responsables.add(new Responsable(getRs().getInt("id_res"),getRs().getString("nom"), getRs().getString("email"), getRs().getString("adresse"),
                    getRs().getString("telephone"), getRs().getString("prenom"), getRs().getString("mdp"), getRs().getString("salt")));
        }
        disconnect();
        return responsables;

    }
    public Responsable getCredentialByEmail(String email) throws SQLException {
        Responsable R1 = null;
        connexion();
        setPs(getCn().prepareStatement("SELECT DISTINCT id_personne,nom,prenom,email,adresse,telephone,mdp,salt,libelle " +
                                            "FROM personne a, personne_phys b, directeur c, role e " +
                                            "WHERE a.id_personne = b.id_phys and b.id_phys = c.id_dir and b.id_role = e.id_role and email = ?;"));
        PreparedStatement p2;
        p2 = getCn().prepareStatement("SELECT DISTINCT id_personne,nom,prenom,email,adresse,telephone,mdp,salt,libelle " +
                                            "FROM personne a, personne_phys b, res_etude c, role e " +
                                            "WHERE a.id_personne = b.id_phys and b.id_phys = c.id_res and b.id_role = e.id_role and email = ?");
        getPs().setString(1, email);
        p2.setString(1,email);
        setRs(getPs().executeQuery());

        while (getRs().next()){
               R1 = new Directeur(getRs().getInt("id_personne"),getRs().getString("nom"),getRs().getString("prenom"),getRs().getString("email"),getRs().getString("adresse"),getRs().getString("telephone"),getRs().getString("mdp"),getRs().getString("salt"),null);

        }
        if(R1 == null){
            setRs(p2.executeQuery());

            while(getRs().next()){
                R1 = new Responsable(getRs().getInt("id_personne"),getRs().getString("nom"),getRs().getString("prenom"),getRs().getString("email"),getRs().getString("adresse"),getRs().getString("telephone"),getRs().getString("mdp"),getRs().getString("salt"));

            }
        }
        return R1;
    }

}
