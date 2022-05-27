<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 2022-05-26
  Time: 오후 1:48
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
    <head>
        <title>Title</title>
    </head>
    <body>
        <h2>글작성</h2>
        <form action="/board/save" method="post">
            <input type="text" id="boardTitle" name="boardTitle" placeholder="글제목"> <br>
            <input type="text" id="boardWriter" name="boardWriter" placeholder="작성자"> <br>
            <input type="text" id="boardContents" name="boardContents" placeholder="글내용"> <br>
            <input type="text" id="boardCreatedDate" placeholder="작성시간"> <br>
            <input type="submit" value="글작성">
        </form>
    </body>
</html>
