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
<div class="container mb-5">
    <div class="row mt-3">
        <div class="col-12 mx-auto">
            <%
            Films films = (Films) request.getAttribute("film");
            if (films!=null){
            %>

            <form action="/editfilm" method="post">
                <input type="hidden" name="id" value="<%=films.getId()%>">
                <div class="mt-3">
                    <label>
                        NAME:
                    </label>
                    <input type="text" class="form-control mt-3" placeholder="Name of film" name="film_name" value="<%=films.getName()%>">
                </div>
                <div class="mt-3">
                    <label class="mb-3">
                        DESCRIPTION:
                    </label>
                    <textarea class="form-control mt-3" name="film_description" placeholder="Describe your film"><%=films.getDescription()%></textarea>
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
                        <option value="<%=c.getId()%>"><%=c.getName() + " / " + c.getCode()%> <% if (c.getId()==films.getCountry().getId()) {out.print("selected");}%></option>
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
                        <option value="<% out.print(i); %>" <%if (films.getDuration()==i){out.print("selected");}%>>
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
                        <option <%if (films.getGenre().equals("Horror")){out.print("selected");}%>>Horror</option>
                        <option <%if (films.getGenre().equals("Action")){out.print("selected");}%>>Action</option>
                        <option <%if (films.getGenre().equals("Comedy")){out.print("selected");}%>>Comedy</option>
                        <option <%if (films.getGenre().equals("Drama")){out.print("selected");}%>>Drama</option>
                        <option <%if (films.getGenre().equals("Fantasy")){out.print("selected");}%>>Fantasy</option>
                        <option <%if (films.getGenre().equals("Other")){out.print("selected");}%>>Other</option>
                    </select>
                </div>
                <div class="mt-3">
                    <button class="btn btn-success">ADD FILM TO</button>
                </div>
            </form>

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
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0/dist/js/bootstrap.min.js" integrity="sha384-lpyLfhYuitXl2zRZ5Bn2fqnhNAKOAaM/0Kr9laMspuaMiZfGmfwRNFh8HlMy49eQ" crossorigin="anonymous"></script>
</body>
</html>

