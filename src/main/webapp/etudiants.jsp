<%@ page import="java.util.Set" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="eu.ensup.domaine.Etudiant" %><%--
  Created by IntelliJ IDEA.
  User: hp
  Date: 11/05/2021
  Time: 12:57
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <!-- Bootstrap CSS -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-eOJMYsd53ii+scO/bJGFsiCZc+5NDVN2yr8+0RDqr0Ql0h+rP48ckxlpbzKgwra6" crossorigin="anonymous">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/animate.css/4.1.1/animate.min.css"/>
    <title>Etudiant - Bootstrap</title>

</head>
<body>
<% Set<Etudiant> etudiants = (Set<Etudiant>) request.getAttribute("etudiants"); %>
<div class="container">
    <div class="row">
        <div class="col bg-white rounded shadow mt-5 py-3 animate__animated animate__slideInLeft">
            <h1>Liste des étudiants</h1>
            <table class="table table-hover">
                <tr>
                    <th>Nom</th>
                    <th>Prénom</th>
                    <th>Email</th>
                    <th>Adresse</th>
                    <th>Téléphone</th>
                    <th>Date de naissance</th>
                </tr>
                <% for (Etudiant etudiant : etudiants){

                %>
                    <tr>
                        <td><%=etudiant.getNom()%> </td>
                        <td><%=etudiant.getPrenom()%></td>
                        <td><%=etudiant.getEmail()%></td>
                        <td><%=etudiant.getAdresse()%></td>
                        <td><%=etudiant.getTelephone()%></td>
                        <td><%=etudiant.getDateNaissance()%></td>
                    </tr>  <% } %>
            </table>
        </div>
    </div>
</div>
</body>
</html>
