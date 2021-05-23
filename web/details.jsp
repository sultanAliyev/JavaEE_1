<%@ page import="java.util.ArrayList" %>
<%@ page import="kz.bitlab.db.Films" %>
<%@ page import="kz.bitlab.db.Countries" %>
<%@ page import="kz.bitlab.db.Comments" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-+0n0xVW2eSR5OomGNYDnhzAbDsOXxcvSN1TPprVMTNDbiYZCxYbOOl7+AMvyTG2x" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/js/bootstrap.bundle.min.js" integrity="sha384-gtEjrD/SeCtmISkJkNUaaKMoLD0//ElJ19smozuHV6z3Iehds+3Ulb9Bn9Plx0x4" crossorigin="anonymous"></script>
</head>
<body>
<div class="container">
    <%@include file="navbar.jsp"%>
</div>
<div class="container mb-5">
    <div class="row mt-3">
        <div class="col-12 mx-auto">
            <%
                Films film = (Films)request.getAttribute("film");
                if(film!=null){
            %>

            <div class="card mt-3">
                <div class="card-header">
                    <%=film.getGenre()%>, <%=film.getCountry().getName()%>
                </div>
                <div class="card-body">
                    <h5 class="card-title"><%=film.getName()%></h5>
                    <p class="card-text">
                        <%=film.getDescription()%>
                    </p>
                </div>
                <div class="card-footer text-muted">
                    Duration : <%=film.getDuration()%> min, posted by: <%=film.getUser().getFullName()%>
                </div>
            </div>
            <div class="mt-3">
                <%
                    if(currentUser!=null && currentUser.getId()==film.getUser().getId()){
                %>
                <a href="/editfilm?id=<%=film.getId()%>" class="btn btn-dark btn-sm">EDIT FILM</a>
                <%
                    }
                %>
            </div>
            <div class="mt-3">
                <%
                    if(currentUser!=null){
                %>
                <form action="/addcomment" method="post">
                    <input type="hidden" name="id" value="<%=film.getId()%>">
                    <textarea class="form-control" name="comment"></textarea>
                    <button class="btn btn-success btn-sm mt-3">ADD COMMENT</button>
                </form>
                <%
                }else{
                %>
                <p>
                    Please, <a href="/login" style="text-decoration: none;font-weight: bold;">sign in</a> to leave comment
                </p>
                <%
                    }
                %>
            </div>
            <div class="mt-3" id = "commentBlock">
                <div class="list-group">
                    <%
                        ArrayList<Comments> comments = (ArrayList<Comments>)request.getAttribute("comment");
                        if(comments!=null){
                            for(Comments c : comments){
                    %>
                    <a href="JavaScript:void(0)" class="list-group-item list-group-item-action">
                        <div class="d-flex w-100 justify-content-between">
                            <h5 class="mb-1"><%=c.getUser().getFullName()%></h5>
                            <small><%=c.getPost_date()%></small>
                        </div>
                        <p class="mb-1"><%=c.getComment()%></p>
                    </a>
                    <%
                            }
                        }
                    %>
                </div>
            </div>

            <%
            }else{
            %>
            <h1 class="text-center">404 NOT FOUND</h1>
            <%
                }
            %>
        </div>
    </div>
</div>
<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.2/dist/umd/popper.min.js" integrity="sha384-IQsoLXl5PILFhosVNubq5LC7Qb9DXgDA9i+tQ8Zj3iwWAwPtgFTxbJ8NT4GN1R8p" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/js/bootstrap.min.js" integrity="sha384-Atwg2Pkwv9vp0ygtn1JAojH0nYbwNJLPhwyoVbhoPwBhjQPR5VtM2+xf0Uwh9KtT" crossorigin="anonymous"></script>
</body>
</html>

