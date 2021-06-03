package eu.ensup.dao;

import eu.ensup.domaine.Directeur;

import java.sql.SQLException;
import java.util.HashSet;
import java.util.Set;

/**
 * Classe dao étendant la classe BaseDao et implémentant l'interface IDirecteurDao gérant le CRUD d'un directeur
 *
 * @see BaseDao
 * @see IDirecteurDao
 */
public class DirecteurDao extends BaseDao implements IDirecteurDao {

    /**
     * Méthode permettant de créer dans la base de données un directeur
     * @param d un directeur
     * @return un entier représentant le résultat
     * @throws SQLException exception SQL
     */
    @Override
    public int createDirecteur(Directeur d) throws SQLException {
        connexion();
        setCs(getCn().prepareCall("{CALL insertDirecteur('"+ d.getNom() +"'," +
                "'"+ d.getPrenom() +
                "','"+ d.getEmail() +
                "','"+ d.getAdresse() +
                "','"+ d.getTelephone() +
                "','"+ d.getMotDePasse() +
                "','" + d.getSalt() +
                "','directeur')}"));
        logger.info("nouveau directeur créé: \n"+d);
        setResult(getCs().executeUpdate());
        return getResult();
    }

    /**
     * Méthode permettant de mettre à jour un directeur dans la base de données
     * @param d un directeur
     * @return un entier représentant le résultat
     * @throws SQLException exception SQL
     */
    @Override
    public int updateDirecteur(Directeur d) throws SQLException {
        connexion();
        setCs(getCn().prepareCall("{CALL updateDirecteur("+d.getId()+
                ",'"+ d.getNom() +"'," +
                "'"+ d.getPrenom() +
                "','"+ d.getEmail() +
                "','"+ d.getAdresse() +
                "','"+ d.getTelephone() +
                "','"+ d.getMotDePasse() +
                "','" + d.getSalt() +
                "','directeur')}"));
        setResult(getCs().executeUpdate());
        return getResult();
    }
    /**
     * Methode permettant la supression d'un directeur dans la base de données
     * @param id identifiant du directeur
     * @return un entier représentant le résultat
     * @throws SQLException exception SQL
     */
    @Override
    public int deleteDirecteur(int id) throws SQLException {
        connexion();
        setCs(getCn().prepareCall("{CALL deleteDirecteur("+id+")}"));
        setResult(getCs().executeUpdate());
        return getResult();
    }
    /**
     * Méthode permettant la récupération d'un directeur de la base de données par son identifiant
     * @param id identifiant du directeur
     * @return un directeur
     * @throws SQLException exception SQL
     */
    @Override
    public Directeur getDirecteur(int id) throws SQLException {
        Directeur d1 = new Directeur();
        connexion();
        setPs(getCn().prepareStatement("select id_personne,nom,prenom,email,adresse,telephone,mdp,salt,id_role " +
                "from personne a join  personne_phys b on a.id_personne = b.id_phys join directeur c on b.id_phys = c.id_dir " +
                "where id_personne = "+ id +";"));
        setRs(getPs().executeQuery());
        while (getRs().next()){
            d1.setId(getRs().getInt("id_personne"));
            d1.setNom(getRs().getString("nom"));
            d1.setPrenom(getRs().getString("prenom"));
            d1.setEmail(getRs().getString("email"));
            d1.setAdresse(getRs().getString("adresse"));
            d1.setTelephone(getRs().getString("telephone"));
            d1.setMotDePasse(getRs().getString("mdp"));
            d1.setSalt(getRs().getString("salt"));
        }
        return d1;
    }



    /**
     * Mérhode permettant la récupération de tous les directeurs de la base de données
     * @return une liste de directeurs
     * @throws SQLException exception SQL
     */
    @Override
    public Set<Directeur> getAllDirecteurs() throws SQLException {
        connexion();
        setPs(getCn().prepareStatement("select id_personne,nom,prenom,email,adresse,telephone,mdp,salt,id_role " +
                "from personne a join  personne_phys b on a.id_personne = b.id_phys join directeur c on b.id_phys = c.id_dir;"));
        setRs(getPs().executeQuery());
        Set<Directeur> directeurs = new HashSet<>();
        while(getRs().next()){
            directeurs.add(new Directeur(
                    getRs().getInt("id_personne"),
                    getRs().getString("nom"),
                    getRs().getString("prenom"),
                    getRs().getString("email"),
                    getRs().getString("adresse"),
                    getRs().getString("telephone"),
                    getRs().getString("mdp"),
                    getRs().getString("salt"),
                    null));
        }
        disconnect();
        return directeurs;
    }
}
