* Etablissement Scolaire web

  * prérequis
    * Avoir java avec le jdk et jre 11 
    *  Avoir maven d'installé
    *  Avoir tomcat 9 installé et aucun server lancé
    * Avoir phpMyAdmin d'installé et lancé
    
  * Installation
    * Aller dans le fichier DB et lancer le script de la base de données dans phpMyAdmin.
    *  Aller Ensup/src/main/java/eu.ensup/dao/BaseDao.java et modifier vos identifiants de connexion this.login avec votre login et this.password avec votre password
    *  Aller a la racine du projet dans \Ensup et ouvrir un cmd et lancer la commande "mvn clean package"
    *lancer le serveur tomcat9 et déployer le war dans le target  
  * Lancement
    * une fois dans le navigateur le login est directeur@gmail.com et le mot de passe est directeur
