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
<%
if (currentUser!=null){
%>
<div class="container">
    <div class="row mt-5">
    <div class="col-6 mx-auto">
        <h2 class="text-center">
            <%=currentUser.getFullName()%>
        </h2>
    </div>
    </div>
    <div class="row mt-5">
        <div class="col-6 mx-auto">
            <%
                String profilesuccess = request.getParameter("profilesuccess");
                if (profilesuccess!=null){
            %>
            <div class="alert alert-success alert-dismissible fade show" role="alert">
                Profile updated successfully!
                <button type="button" class="btn-close" data-bs-dismiss="alert" aria-label="Close"></button>
            </div>
            <%
                }
            %>
            <%
                String error = request.getParameter("error");
                if (error!=null){
            %>
            <div class="alert alert-danger alert-dismissible fade show" role="alert">
                Something went wrong!
                <button type="button" class="btn-close" data-bs-dismiss="alert" aria-label="Close"></button>
            </div>
            <%
                }
            %>
           <form action="profile" method="post">
               <div class="mt-3">
                <label>
                    EMAIL :
                </label>
                   <input type="text" class="form-control bg-light" value="<%=currentUser.getEmail()%>" readonly>
               </div>
               <div class="mt-3">
                   <label>
                       FULL NAME :
                   </label>
                   <input type="text" class="form-control bg-light" value="<%=currentUser.getFullName()%>" name="full_name">
               </div>
               <div class="mt-3">
                   <button class="btn btn-success">UPDATE PROFILE</button>
               </div>
           </form>
        </div>
    </div>
    <div class="row mt-5">
        <div class="col-6 mx-auto">
            <%
                String passwordsuccess = request.getParameter("passwordsuccess");
                if (passwordsuccess!=null){
            %>
            <div class="alert alert-success alert-dismissible fade show" role="alert">
                Password updated successfully!
                <button type="button" class="btn-close" data-bs-dismiss="alert" aria-label="Close"></button>
            </div>
            <%
                }
            %>
            <%
                String passworderror = request.getParameter("passworderror");
                if (passworderror!=null){
            %>
            <div class="alert alert-danger alert-dismissible fade show" role="alert">
                Password error! Try again, please!
                <button type="button" class="btn-close" data-bs-dismiss="alert" aria-label="Close"></button>
            </div>
            <%
                }
            %>
            <form action="updatepassword" method="post">
                <div class="mt-3">
                </div>
                <div class="mt-3">
                    <label>
                        OLD PASSWORD :
                    </label>
                    <input type="password" class="form-control bg-light" name="old_password">
                </div>
                <div class="mt-3">
                    <label>
                        NEW PASSWORD :
                    </label>
                    <input type="password" class="form-control bg-light" name="new_password">
                </div>
                <div class="mt-3">
                    <label>
                        REPEAT NEW PASSWORD :
                    </label>
                    <input type="password" class="form-control bg-light" name="re_new_password">
                </div>
                <div class="mt-3">
                    <button class="btn btn-success">UPDATE PASSWORD</button>
                </div>
            </form>
        </div>
    </div>
</div>
<%
    }
%>
</body>
</html>
