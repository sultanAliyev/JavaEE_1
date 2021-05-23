<%@ page import="java.util.ArrayList" %>
<%@ page import="kz.bitlab.db.Films" %>
<%@ page import="kz.bitlab.db.Countries" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-wEmeIV1mKuiNpC+IOBjI7aAzPcEZeedi5yW5f2yOq55WWLwNGmvvx4Um1vskeMj0" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0/dist/js/bootstrap.bundle.min.js" integrity="sha384-p34f1UUtsS3wqzfto5wAAmdvj+osOnFyQFpp4Ua3gs/ZVWx6oOypYoCJhGGScy+8" crossorigin="anonymous"></script>
</head>
<body>
<div class="container">
<%@include file="navbar.jsp"%>
</div>
<div class="container">
    <div class="row mt-5">
        <div class="col-6 mx-auto">
            <%
            String passworderror = request.getParameter("passworderror");
            if (passworderror!=null){
            %>
            <div class="alert alert-danger alert-dismissible fade show" role="alert">
                Passwords are not the same!
                <button type="button" class="btn-close" data-bs-dismiss="alert" aria-label="Close"></button>
            </div>
            <%
                }
            %>
            <%
                String emailerror = request.getParameter("emailerror");
                if (emailerror!=null){
            %>
            <div class="alert alert-danger alert-dismissible fade show" role="alert">
                Email already exists!
                <button type="button" class="btn-close" data-bs-dismiss="alert" aria-label="Close"></button>
            </div>
            <%
                }
            %>
            <%
                String success = request.getParameter("success");
                if (success!=null){
            %>
            <div class="alert alert-success alert-dismissible fade show" role="alert">
                User registered successfully!
                <button type="button" class="btn-close" data-bs-dismiss="alert" aria-label="Close"></button>
            </div>
            <%
                }
            %>
            <form action="/register" method="post">
                <div class="mt-3">
                    <label>
                        EMAIL :
                    </label>
                    <input type="email" class="form-control mt-3" name="email" required placeholder="User Email">
                </div>
                <div class="mt-3">
                    <label>
                       PASSWORD :
                    </label>
                    <input type="password" class="form-control mt-3" name="password" required placeholder="User Password">
                </div>
                <div class="mt-3">
                    <label>
                      REPEAT PASSWORD :
                    </label>
                    <input type="password" class="form-control mt-3" name="re_password" required placeholder="Repeat User Password">
                </div>
                <div class="mt-3">
                    <label>
                        FUL NAME :
                    </label>
                    <input type="text" class="form-control mt-3" name="full_name" required placeholder="User Full Name">
                </div>
                <div class="mt-3">
                   <button class="btn btn-dark">Sign Up</button>
                </div>
            </form>
        </div>
    </div>
</div>
</body>
</html>
