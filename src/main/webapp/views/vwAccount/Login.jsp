<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>E-Commerce Web Application</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css" integrity="sha384-xOolHFLEh07PJGoPkLv1IbcEPTNtaed2xpHsD9ESMhqIYd0nLMwNLD69Npy4HI+N" crossorigin="anonymous">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
    <style>
        body{
            height: 100vh;
            background-image: url("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQC1F-1BjSFCpvnNMRqwxkzxssfTXXlDfusmA&usqp=CAU") ;
            }
    </style>
</head>
<body>
    <div class="container-fluid h-100">
        <div class="row h-100 justify-content-center align-items-center">
            <div class="col-sm-4">
                <c:if test="${hasError}">
                    <div class="alert alert-warning alert-dismissible fade show" role="alert">
                        <strong>Login failed!</strong> Invalid login.
                        <button type="button" class="close" data-dismiss="alert" aria-label="Close">
                            <span aria-hidden="true">&times;</span>
                        </button>
                    </div>
                </c:if>
                <form action="" method="post">

                    <div class="form-group ">
                        <label class="sr-only" for="txtUsername">Username</label>
                        <div class="input-group ">
                            <input type="text" class="form-control form-control-lg border-right-0" id="txtUsername" name="username" autofocus placeholder="Username">
                            <div class="input-group-append">
                                <span class="input-group-text bg-white">
                                     <i class="fa fa-user" aria-hidden="true"></i>
                                </span>
                            </div>
                        </div>
                    </div>
                    <div class="form-group ">
                        <label class="sr-only" for="txtPassword">Username</label>
                        <div class="input-group ">
                            <input type="password" class="form-control form-control-lg border-right-0" id="txtPassword" name="password"  placeholder="Password">
                            <div class="input-group-append">
                                <span class="input-group-text bg-white">
                                     <i class="fa fa-key" aria-hidden="true"></i>
                                </span>
                            </div>
                        </div>
                    </div>
                    <div class="form-group d-flex ">
                        <div>
                            <a  class="btn btn-lg btn-primary" href="${pageContext.request.contextPath}/Home" role="button">
                                <i class="fa fa-home" aria-hidden="true"></i>
                                Home
                            </a>
                        </div>
                        <div class="flex-fill">
                            <button type="submit" class="btn btn-lg ml-1 btn-info btn-block">
                                <i class="fa fa-sign-in" aria-hidden="true"></i>
                                Sign In
                            </button>
                        </div>
                    </div>
                </form>
            </div>
        </div>
    </div>


<script src="https://code.jquery.com/jquery-3.6.1.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js" integrity="sha384-9/reFTGAW83EW2RDu2S0VKaIzap3H66lZH81PoYlFhbGU+6BZp6G7niu735Sk7lN" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/js/bootstrap.min.js" integrity="sha384-+sLIOodYLS7CIrQpBjl+C7nPvqq+FbNUBDunl/OZv93DB7Ln/533i8e/mZXLi/P+" crossorigin="anonymous"></script>
</body>
</html>