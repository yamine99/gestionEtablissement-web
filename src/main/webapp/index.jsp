<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <link rel="stylesheet"
          href="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
    <meta charset="ISO-8859-1">
    <title>Insert title here</title>
</head>
<body>
<div class="container">
    <div class="row">
        <div class="col-sm-9 col-md-7 col-lg-5 mx-auto">
            <div class="card card-signin my-5">
                <div class="card-body">
                    <h5 class="card-title text-center">Sign In</h5>
                    <h6><% String loged= (String) session.getAttribute("error"); if (loged!=null)%><%= loged %></h6>
                    <form class="form-signin" method="post" action="login">
                        <div class="form-label-group">
                            <label
                                    for="login">Email address</label>
                            <input type="email" name="login" id="login" class="form-control"
                                   placeholder="Email address" required autofocus>
                        </div>

                        <div class="form-label-group">
                            <label
                                    for="password">Password</label>
                            <input type="password" name="password" class="form-control" id="password"
                                   placeholder="Password" required>
                        </div>

                        <div >
                            <p><a href="">mot de passe oublie</a></p>
                        </div>
                        <button class="btn btn-lg btn-primary btn-block text-uppercase"
                                type="submit" >Sign in</button>
                        <hr class="my-4">
                    </form>
                </div>
            </div>
        </div>
    </div>
</div>
</body>
</html>