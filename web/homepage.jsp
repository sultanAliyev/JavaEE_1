<%@ page import="java.util.ArrayList" %>
<%@ page import="kz.bitlab.db.Films" %>
<%@ page import="kz.bitlab.db.Countries" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-wEmeIV1mKuiNpC+IOBjI7aAzPcEZeedi5yW5f2yOq55WWLwNGmvvx4Um1vskeMj0" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0/dist/js/bootstrap.bundle.min.js" integrity="sha384-p34f1UUtsS3wqzfto5wAAmdvj+osOnFyQFpp4Ua3gs/ZVWx6oOypYoCJhGGScy+8" crossorigin="anonymous"></script>
    <style>
        img{
            max-width: 100%;
        }
    </style>
</head>
<body>
<div class="container">
<%@include file="navbar.jsp"%>
</div>
<div class="container mb-5">
    <div class="row mt-3">
        <div class="col-12 mx-auto">
            <%
                ArrayList<Films> films = (ArrayList<Films>) request.getAttribute("kinolar");
                if (films!=null){
                    for (Films f : films){
            %>
            <div class="card mt-3">
                <div class="card-header">
                   <%=f.getGenre()%>, <%=f.getCountry().getName()%>
                </div>
                <div class="card-body">
                    <h5 class="card-title"><%=f.getName()%></h5>
                    <p class="card-text">
                        <%=f.getDescription()%>
                    </p>
                    <a href="/details?id=<%=f.getId()%>" class="btn btn-primary btn-sm">Details</a>
                </div>
                <div class="card-footer text-muted">
                   Duration : <%=f.getDuration()%> min, Posted By: <%=f.getUser().getFullName()%>
                </div>
            </div>
            <%
                    }
                }
            %>
        </div>
    </div>
</div>
</body>
</html>
