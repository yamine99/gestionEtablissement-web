package eu.ensup.dao;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

import java.sql.*;
import java.util.ResourceBundle;

public class BaseDao {

    /**
     * L'url de la base de donnée
     */
    private final String url;
    /**
     * Le login de la base de données
     */
    private final String login;
    /**
     * Le mot de passe de la base de données
     */
    private final String password;
    /**
     * Permet de créer la connection avec la base
     */
    private static Connection cn = null;
    /**
     * Permet d'excuter des requete a partir de la connection
     */
    private static Statement st = null;
    /**
     * Le resultat d'une requete SQL faite dans la base de données
     */
    private static ResultSet rs = null;

    private static PreparedStatement ps = null;

    private static CallableStatement cs = null;

    private  static int result;

    /**
     * The constant logger.
     */
    final static Logger logger = Logger.getLogger(BaseDao.class);


    /**
     * Constructor
     */
    public BaseDao() {

        this.url = "jdbc:mysql://localhost:3306/etablissement_scolaire?serverTimezone=Europe/Berlin";
        this.login = "root";
        this.password = "root";
    }

    /**
     * Methode qui permet la connexion a la bdd
     */
    public void connexion() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            cn = DriverManager.getConnection(url, login, password);
            st = cn.createStatement();
        } catch (SQLException | ClassNotFoundException e) {
            logger.error(e);
            e.printStackTrace();
        }
    }

    /**
     * Methode qui permet de ce deconnecter de la bdd
     */
    public void disconnect() {
        /*try {
            /*assert cn != null;
            cn.close();
            assert cs != null;
            cs.close();
            assert ps != null;
            ps.close();
            assert st != null;
            st.close();
        } catch (SQLException e) {
            logger.error(e);
            e.printStackTrace();
        }*/

    }

    /**
     * Gets ps.
     *
     * @return the ps
     */
    public static PreparedStatement getPs() {
        return ps;
    }

    /**
     * Sets ps.
     *
     * @param ps the ps
     */
    public static void setPs(PreparedStatement ps) {
        BaseDao.ps = ps;
    }

    /**
     * Gets cs.
     *
     * @return the cs
     */
    public static CallableStatement getCs() {
        return cs;
    }

    /**
     * Sets cs.
     *
     * @param cs the cs
     */
    public static void setCs(CallableStatement cs) {
        BaseDao.cs = cs;
    }

    /**
     * Gets cn.
     *
     * @return the cn
     */
    public static Connection getCn() {
        return cn;
    }

    /**
     * Sets cn.
     *
     * @param cn the cn
     */
    public static void setCn(Connection cn) {
        BaseDao.cn = cn;
    }

    /**
     * Gets st.
     *
     * @return the st
     */
    public static Statement getSt() {
        return st;
    }

    /**
     * Sets st.
     *
     * @param st the st
     */
    public static void setSt(Statement st) {
        BaseDao.st = st;
    }

    /**
     * Gets rs.
     *
     * @return the rs
     */
    public static ResultSet getRs() {
        return rs;
    }

    /**
     * Sets rs.
     *
     * @param rs the rs
     */
    public static void setRs(ResultSet rs) {
        BaseDao.rs = rs;
    }

    /**
     * Gets result.
     *
     * @return the result
     */
    public static int getResult() {
        return result;
    }

    /**
     * Sets result.
     *
     * @param result the result
     */
    public static void setResult(int result) {
        BaseDao.result = result;
    }
}
