<%@ page import="kz.bitlab.db.Users" %>
<%@ page import="java.util.IllegalFormatCodePointException" %>
<%
String siteName = "KINO.KZ";

    Users currentUser = (Users)session.getAttribute("CURRENT_USER");
%>
<nav class="navbar navbar-expand-lg navbar-dark bg-dark">
    <div class="container-fluid">
        <a class="navbar-brand" href="/"><% out.print(siteName);%></a>
        <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="navbarSupportedContent">
            <ul class="navbar-nav me-auto mb-2 mb-lg-0">
                <%
                    if (currentUser!=null){
                %>
                <li class="nav-item">
                    <a class="nav-link" aria-current="page" href="/profile.jsp">
                        <%=currentUser.getFullName()%>
                    </a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="/addfilm">Add film</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="/logout">Sign Out</a>
                </li>
                <%
                    }else {
                %>
                <li class="nav-item">
                    <a class="nav-link" aria-current="page" href="/">Home</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="/login">Sign In</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="/register">Sign Up</a>
                </li>
                <%
                    }
                %>
            </ul>
            <%
            String query = "";
            if (request.getParameter("my_query")!=null)
                query = request.getParameter("my_query");
            %>
            <form class="d-flex my-auto" action="/search" method="get">
                <input class="form-control me-2" type="search" placeholder="Search" aria-label="Search" name="my_query" value="<% out.print(query);%>">
                <button class="btn btn-outline-light" type="submit">Search</button>
            </form>
        </div>
    </div>
</nav>