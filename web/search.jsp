<%@ page import="java.util.ArrayList" %>
<%@ page import="kz.bitlab.db.Films" %>
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
<div class="container mt-5">
    <div class="row">
        <div class="col-12">
            <table class="table table-striped table-hover">
                <thead>
                <tr>
                    <th>NAME</th>
                    <th>DESCRIPTION</th>
                    <th>COUNTRY</th>
                    <th>DURATION</th>
                    <th>GENRE</th>
                </tr>
                </thead>
                <tbody>
                <%
                    ArrayList<Films> films = (ArrayList<Films>) request.getAttribute("foundFilm");
                    if (films!=null){
                        for (Films f : films){
                %>
                <tr>
                    <td>
                        <%
                            out.print(f.getName());
                        %>
                    </td>
                    <td>
                        <%
                            out.print(f.getDescription());
                        %>
                    </td>
                    <td>
                        <%
                            out.print(f.getCountry());
                        %>
                    </td>
                    <td>
                        <%
                            out.print(f.getDuration());
                        %>
                    </td>
                    <td>
                        <%
                            out.print(f.getGenre());
                        %>
                    </td>
                </tr>
                <%
                        }
                    }
                %>
                </tbody>
            </table>
        </div>
    </div>
</div>
</body>
</html>

