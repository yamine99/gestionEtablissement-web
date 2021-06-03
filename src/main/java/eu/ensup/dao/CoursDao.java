package eu.ensup.dao;

import eu.ensup.domaine.Cours;
import eu.ensup.domaine.Etudiant;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


/**
 * The type Cours dao.
 */
public class CoursDao extends BaseDao implements ICoursDao {
    @Override
    public int addCours(Cours cours) {
        try {
            connexion();
            String sql = "SELECT * FROM `cours` WHERE `theme` = ? AND `nb_heures`  = ? ";
            BaseDao.setPs(BaseDao.getCn().prepareStatement(sql));
            BaseDao.getPs().setString(1, cours.getTheme());
            BaseDao.getPs().setInt(2, cours.getNbHeures());
            BaseDao.setRs(BaseDao.getPs().executeQuery());
            if (!BaseDao.getRs().next()) {
                sql = "INSERT INTO cours(theme,nb_heures) VALUES (?,?)";
                BaseDao.setPs(BaseDao.getCn().prepareStatement(sql));
                BaseDao.getPs().setString(1, cours.getTheme());
                BaseDao.getPs().setInt(2, cours.getNbHeures());

                BaseDao.setResult(BaseDao.getPs().executeUpdate());
                BaseDao.logger.info("le cours :" + cours + " a ete ajouté");
            } else {
                BaseDao.logger.info("le cours:" + cours + " exsite déjà");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        disconnect();
        return BaseDao.getResult();
    }

    @Override
    public int updateCours(Cours cours) {
        try {
            connexion();
            String sql = "UPDATE `cours` SET `theme`= ?,`nb_heures`= ?";
            BaseDao.setPs(BaseDao.getCn().prepareStatement(sql));
            BaseDao.getPs().setString(1, cours.getTheme());
            BaseDao.getPs().setInt(2, cours.getNbHeures());

            BaseDao.setResult(BaseDao.getPs().executeUpdate());
        } catch (SQLException e) {
            e.printStackTrace();
        }
        disconnect();
        return BaseDao.getResult();
    }

    @Override
    public int deleteCours(Cours cours) {
        String sql;
        try {
            connexion();
            sql = "DELETE FROM `cours` WHERE `id_cours` = ?";
            BaseDao.setPs(BaseDao.getCn().prepareStatement(sql));
            BaseDao.getPs().setInt(1, cours.getId());
            BaseDao.setResult(BaseDao.getPs().executeUpdate());
        } catch (SQLException e) {
            e.printStackTrace();
        }
        disconnect();
        return BaseDao.getResult();

    }

    @Override
    public Cours getCours(int id) {
        String sql;
        Cours cours = new Cours();
        try {
            connexion();
            sql = "Select * from cours where id_cours=?";
            BaseDao.setPs(BaseDao.getCn().prepareStatement(sql));
            BaseDao.getPs().setInt(1, id);
            BaseDao.setRs(BaseDao.getPs().executeQuery());
            while (getRs().next()) {
                return new Cours(getRs().getInt("id_cours"), getRs().getString("theme"), getRs().getInt("nb_heures"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        disconnect();
        return null;
    }

    @Override
    public List<Cours> findAll() {

        String sql;
        List<Cours> cours = new ArrayList<>();
        try {
            connexion();
            sql = "SELECT * FROM cours ";
            BaseDao.setPs(BaseDao.getCn().prepareStatement(sql));
            BaseDao.setRs(BaseDao.getPs().executeQuery());
            while (BaseDao.getRs().next()) {
                cours.add(new Cours(BaseDao.getRs().getInt("id_cours"), BaseDao.getRs().getString("theme"), BaseDao.getRs().getInt("nb_heures")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        disconnect();
        return cours;
    }

    @Override
    public int inscription(Cours c, Etudiant e) {

        // TODO Auto-generated method stub
        String sql;
        try {
            //creer la connexion
            connexion();
            sql = "SELECT * FROM `suivre` WHERE `id_etudiant` = ? AND `id_cours` = ?";
            BaseDao.setPs(BaseDao.getCn().prepareStatement(sql));
            BaseDao.getPs().setInt(1, e.getId());
            BaseDao.getPs().setInt(2, c.getId());
            BaseDao.setRs(BaseDao.getPs().executeQuery());
            if (getRs().next()) {
                BaseDao.setResult(-1);
            } else {
                //ajouter la requete
                sql = "INSERT INTO suivre(`id_etudiant`, `id_cours`) VALUES (?,?)";
                BaseDao.setPs(BaseDao.getCn().prepareStatement(sql));
                BaseDao.getPs().setInt(1, e.getId());
                BaseDao.getPs().setInt(2, c.getId());
                BaseDao.setResult(BaseDao.getPs().executeUpdate());
            }
        } catch (SQLException exp) {
            exp.printStackTrace();
        }
        disconnect();
        return getResult();

    }

    @Override
    public List<Cours> getCoursEtudiant(int idEtudiant) {
        // TODO Auto-generated method stub
        List<Cours> cours = new ArrayList<Cours>();
        try {
            connexion();
            //2- créer la requête
            String sql = "SELECT * FROM cours, suivre, etudiant" +
                    " where suivre.id_etudiant = etudiant.id_etudiant" +
                    " and suivre.id_cours = club.id_cours" +
                    " and inscription.id_etudiant=?";
            BaseDao.setPs(BaseDao.getCn().prepareStatement(sql));
            BaseDao.getPs().setInt(1, idEtudiant);
            BaseDao.setRs(BaseDao.getPs().executeQuery());
            //4- récupérer le résultat
            while (BaseDao.getRs().next()) {
                //1- créer un objet de type cours
                Cours c = new Cours();
                BaseDao.getPs().setString(1, c.getTheme());
                BaseDao.getPs().setInt(2, c.getNbHeures());

                //2- ajouter l'objet etudiant à la liste créée
                cours.add(c);
            }
            //5- fermer la connexion
            disconnect();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return cours;
    }

}
