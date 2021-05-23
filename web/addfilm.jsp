<%@ page import="java.util.ArrayList" %>
<%@ page import="kz.bitlab.db.Films" %>
<%@ page import="kz.bitlab.db.Countries" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-wEmeIV1mKuiNpC+IOBjI7aAzPcEZeedi5yW5f2yOq55WWLwNGmvvx4Um1vskeMj0" crossorigin="anonymous">
    <script src="/tinymce/jquery-3.6.0.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0/dist/js/bootstrap.bundle.min.js" integrity="sha384-p34f1UUtsS3wqzfto5wAAmdvj+osOnFyQFpp4Ua3gs/ZVWx6oOypYoCJhGGScy+8" crossorigin="anonymous"></script>
    <script src="/tinymce/tinymce.min.js" referrerpolicy="origin"></script>
    <script>
        tinymce.init({
            selector:'textarea',
            plugins:'preview image link media table'
        });
    </script>
</head>
<body>
<div class="container">
<%@include file="navbar.jsp"%>
</div>
<div class="container">
    <div class="row mt-3">
        <div class="col-12 mx-auto">
            <form action="/addfilm" method="post">
                <div class="mt-3">
                    <label>
                        NAME:
                    </label>
                    <input type="text" class="form-control mt-3" placeholder="Name of film" name="film_name">
                </div>
                <div class="mt-3">
                    <label class="mb-3">
                        DESCRIPTION:
                    </label>
                 <textarea class="form-control mt-3" name="film_description" placeholder="Describe your film"></textarea>
                </div>
                <div class="mt-3">
                    <label>
                        COUNTRY:
                    </label>
                 <select class="form-control mt-3" name="film_country">
                     <%
                     ArrayList<Countries> countries = (ArrayList<Countries>) request.getAttribute("countries");
                     if (countries!=null){
                         for(Countries c : countries){
                     %>
                     <option value="<%=c.getId()%>"><%=c.getName() + " / " + c.getCode()%></option>
                     <%

                             }
                         }
                     %>
                 </select>
                </div>
                <div class="mt-3">
                    <label>
                        DURATION:
                    </label>
                 <select class="form-control mt-3" name="film_duration">
                     <%
                     for (int i = 0; i<=400;i++){
                     %>
                     <option value="<% out.print(i); %>">
                         <% out.print(i + " mins"); %>
                     </option>
                     <%
                         }
                     %>
                 </select>
                </div>
                <div class="mt-3">
                    <label>
                        GENRE:
                    </label>
                    <select class="form-control mt-3" name="film_genre">
                        <option>Horror</option>
                        <option>Action</option>
                        <option>Comedy</option>
                        <option>Drama</option>
                        <option>Fantasy</option>
                        <option>Other</option>
                    </select>
                </div>
                <div class="mt-3">
                    <button class="btn btn-success">ADD FILM TO</button>
                </div>
            </form>
        </div>
    </div>
</div>
</body>
</html>
