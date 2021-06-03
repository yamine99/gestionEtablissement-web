<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="fr">
<head>
  <meta charset="UTF-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <!-- Bootstrap CSS -->
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-eOJMYsd53ii+scO/bJGFsiCZc+5NDVN2yr8+0RDqr0Ql0h+rP48ckxlpbzKgwra6" crossorigin="anonymous">
  <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/animate.css/4.1.1/animate.min.css"/>
  <title>Etudiant - Bootstrap</title>

  <style>
    .page{display:none;}
    .current{display: block!important;}
  </style>
</head>
<body class="container bg-light">
<nav class="navbar navbar-expand-lg navbar-light bg">
  <div class="container-fluid">
    <img class="navbar-brand" src="./ensitech.png" width="150">
    <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
      <span class="navbar-toggler-icon"></span>
    </button>
    <div class="collapse navbar-collapse" id="navbarSupportedContent">
      <ul class="navbar-nav me-auto mb-2 mb-lg-0">
        <li class="nav-item">
          <a class="nav-link active text-info" href="#" id="p_student">Créer un étudiant</a>
        </li>
        <li class="nav-item">
          <a class="nav-link text-info" href="course" id="p_courses">Gérer les cours</a>
        </li>
        <li class="nav-item">
          <a class="nav-link text-info" href="etudiants" id="p_list">Liste des étudiants</a>
        </li>
      </ul>
    </div>
  </div>
</nav>

<div class="page current">
  <div class="row">
    <div class="col mx-auto bg-white rounded shadow mt-5 py-3 animate__animated animate__slideInLeft">
      <h1>Créer un étudiant</h1>
      <div class="row">
        <form action="etudiants" class="form-group" method="post">
        <div class="col">
          <label for="name">Nom</label><br>
          <input type="text" placeholder="Nom" id="name" name="name" class="form-control"><br>
          <label for="firstname">Prénom</label><br>
          <input type="text" placeholder="Prénom" id="firstname" name="firstname" class="form-control"><br>
          <label for="birthday">Date de naissance</label><br>
          <input type="date" id="birthday" class="form-control" name="birthday"><br>
          <label for="mail">Email</label><br>
          <input type="text" placeholder="Email" id="mail" class="form-control" name="email"><br>
        </div>
        <div class="col">
          <label for="address">Adresse</label><br>
          <input type="text" placeholder="Adresse" id="address" class="form-control" name="address"><br>
          <label for="phone">Téléphone</label><br>
          <input type="text" placeholder="Téléphone" id="phone" class="form-control" name="tele"><br>
          <label for="password">Mot de passe</label><br>
          <input type="text" placeholder="Mot de passe" id="password" class="form-control" name="password"><br>

          <div class="row text-center px-3">
            <input type="submit" value="Créer l'étudiant" class="btn btn-success">
          </div>
        </div>
        </form>
      </div>
    </div>
  </div>
</div>


<script type="text/javascript">
  document.getElementById("p_student").addEventListener("click", function(){goToPage(this, 0)}, false);
  document.getElementById("p_students").addEventListener("click", function(){goToPage(this, 1)}, false);
  document.getElementById("p_courses").addEventListener("click", function(){goToPage(this, 2)}, false);
  document.getElementById("p_list").addEventListener("click", function(){goToPage(this, 3)}, false);

  function goToPage(el, page) {
    let allPage = document.querySelectorAll(".page");
    let allLink = document.querySelectorAll("a");
    for (let i = 0; i < allPage.length; i++) {
      allPage[i].classList.remove("current");
      allLink[i].classList.remove("active", "text-primary");
      if (i == page) {allPage[i].classList.add("current"); allLink[i].classList.add("active", "text-primary");}
    }
  }
</script>
</body>
</html>