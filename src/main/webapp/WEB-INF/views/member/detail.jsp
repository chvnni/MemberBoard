<%--
  Created by IntelliJ IDEA.
  User: channi
  Date: 2022-06-02
  Time: 오후 5:59
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
    <head>
        <title>Title</title>
    </head>
    <body>
        <button onclick="updateForm()">회원정보 수정</button>
    </body>
    <script>
        const updateForm = () => {
          location.href = "/updateForm"
        }
    </script>
</html>
