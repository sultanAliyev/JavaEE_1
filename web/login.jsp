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
            String error = request.getParameter("error");
            if (error!=null){
            %>
            <div class="alert alert-danger alert-dismissible fade show" role="alert">
                Incorrect email or password. Try again!
                <button type="button" class="btn-close" data-bs-dismiss="alert" aria-label="Close"></button>
            </div>
            <%
                }
            %>
            <form action="/login" method="post">
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
                   <button class="btn btn-dark">Sign In</button>
                </div>
            </form>
        </div>
    </div>
</div>
</body>
</html>
