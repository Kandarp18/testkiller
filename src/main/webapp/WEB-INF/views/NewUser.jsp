<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"  %>  
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <meta http-equiv="X-UA-Compatible" content="ie=edge">
  <title>Testkiller</title>
  <link href="https://fonts.googleapis.com/css?family=Karla:400,700&display=swap" rel="stylesheet">
  <link rel="stylesheet" href="https://cdn.materialdesignicons.com/4.8.95/css/materialdesignicons.min.css">
  <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css">
  <link rel="stylesheet" href="/css/login.css">
</head>
<body>
  <main class="d-flex align-items-center min-vh-100 py-3 py-md-0">
    <div class="container">
      <div class="card login-card">
        <div class="row no-gutters">
          <div class="col-md-5">
            <img src="/images/login.jpg" alt="login" class="login-card-img">
          </div>
          <div class="col-md-7">
            <div class="card-body">
              <div class="brand-wrapper">
                <img src="/images/logo.jpg" class="logo" alt="logo">
              </div>
              <p class="login-card-description">Register Now!</p>
              <form action="saveuser" method="post">
              <div class="form-group">
                    <label for="firstName" class="sr-only">FirstName</label>
                    <input type="text" name="firstName" id="email" class="form-control" placeholder="FirstName" required>
                  </div>
                  <div class="form-group">
                    <label for="email" class="sr-only">Email</label>
                    <input type="email" name="email" id="email" class="form-control" placeholder="Email address" required>
                  </div>
                    
                     <div class="form-group">
                       <label for="gender" class="sr-only">Gender</label>
                   <select name="gender" id="gender" class="form-control" required>
                    <option>Select Gender</option>
                        <option value="Male">Male</option>
                          <option value="Female">Female</option>
                            <option value="Other">Other</option>
                   </select>
                  </div>
                   <div class="form-group">
                    <label for="contactNo" class="sr-only">ContactNo</label>
                    <input type="text" name="contactNo" id="contactNo" class="form-control" placeholder="Contact No" required>
                  </div>
                   <div class="form-group">
                       <label for="role" class="sr-only">Role</label>
                   <select name="roleId" id="role" class="form-control" required>
                         <option>Select Role</option>
                         <c:forEach items="${roles }" var="role">
                              <option value="${role.roleId }">${role.roleName }</option>
                         </c:forEach>
                   </select>
                  </div>
                 
                 
                  <div class="form-group mb-4">
                    <label for="password" class="sr-only">Password</label>
                    <input type="password" name="password" id="password" class="form-control" placeholder="***********" required>
                  </div>
                  <input  id="login" class="btn btn-block login-btn mb-4" type="submit" value="Register" >
                 <p style="color:red;">  ${error }</p>
                </form>
                
                <nav class="login-card-footer-nav">
                  <a href="#!">Terms of use.</a>
                  <a href="#!">Privacy policy</a>
                </nav>
            </div>
          </div>
        </div>
      </div>
    
     
    </div>
  </main>
  <script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
  <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js"></script>
  <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js"></script>
</body>
</html>
