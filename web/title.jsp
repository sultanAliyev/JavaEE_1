<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <%
        String text = (String)request.getAttribute("resultText");
    %>
    <title><%out.print(text);%></title>
</head>
<body>
<form action="/title" method="post">
    <label>
        Name of a Site:
    </label>
    <input type="text" name="title_name">
    <button>SET SITE NAME</button>
</form>
</body>
</html>
