<%@ page import="eu.ensup.domaine.Cours" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: hp
  Date: 12/05/2021
  Time: 00:11
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
    <title>Cours</title>
</head>
<body>
<div class="page">
  <div class="container">
    <div class="col">
      <h3>Créer un cours</h3>
      <form action="course" method="post">
        <label for="course">Thème du cours</label><br>
        <input name="theme" type="text" placeholder="Thème du cours" id="course" class="form-control"><br>

        <label for="hour">Nombre d'heures</label><br>
        <input name="heures" type="text" placeholder="Nombre d'heure" id="hour" class="form-control"><br>

        <div class="row px-5">
          <input type="submit" value="Créer" class="btn btn-dark">
        </div>
      </form>
    </div>


    <div class="col">
      <h3>Associer un étudiant à un cours</h3>

      <form action="course" method="post">
        <label for="course">Saisir Id étudiant</label><br>
        <input name="idetudiant" type="text" placeholder="id étudiant" id="course" class="form-control"><br>
        <input type="hidden" name="associer" value="associer">

        <label for="hour">Saisir Id cours</label><br>
        <input name="idcours" type="text" placeholder="Id cours" id="hour" class="form-control"><br>

        <div class="row px-5">
          <input type="submit" value="Associer" class="btn btn-dark">
        </div>
      </form>
    </div>

  </div>
  <div class="container"><div class="row">
    <% List<Cours> coursList = (List<Cours>) request.getAttribute("cours");%>
    <div class="col bg-white rounded shadow mt-5 py-3 animate__animated animate__slideInLeft">
      <h1>Liste des cours</h1>
      <table class="table table-hover">
        <tr>
          <th>Thème</th>
          <th>Nombre d'heures</th>
          <th>Nombre des étudiants</th>
        </tr>
        <% for (Cours course : coursList){

        %>
        <tr>

          <td><%=course.getTheme()%></td>
          <td><%=course.getNbHeures()%> </td>
          <td><%=course.getEtudiants().size()%></td>
        </tr>  <% } %>
      </table>
    </div>
  </div> </div>
</div>
</body>
</html>
