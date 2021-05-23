<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>WEB</title>
</head>
<body>
<%
    String text_name = (String)request.getAttribute("user_name");
    String text_surname = (String)request.getAttribute("user_surname");
    String text_age = (String)request.getAttribute("user_age");
    String text_country = (String)request.getAttribute("user_country");
    String text_card = (String)request.getAttribute("user_card");
%>

<form action="/draft" method="post">
    <label>
        NAME :
    </label>
    <input type="text" name="user_name" style="margin-bottom: 20px;" value="<%out.print(text_name);%>">
    <br>
    <label>
        SURNAME :
    </label>
    <input type="text" name="user_surname" style="margin-bottom: 20px;" value="<%out.print(text_surname);%>">
    <br>
    <label>
        AGE :
    </label>
    <input type="text" name="user_age" style="margin-bottom: 20px;" value="<%out.print(text_age);%>">
    <br>
    <label>
        COUNTRY :
    </label>
    <input type="text" name="user_country" style="margin-bottom: 20px;" value="<%out.print(text_country);%>">
    <br>
    <label>
        CREDIT CARD :
    </label>
    <input type="number" name="user_card" style="margin-bottom: 20px;" value="<%out.print(text_card);%>">
    <br>
    <button>SAVE</button>
</form>
</body>
</html>
