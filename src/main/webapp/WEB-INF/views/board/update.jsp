<%--
  Created by IntelliJ IDEA.
  User: channi
  Date: 2022-06-02
  Time: 오후 4:11
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
    <head>
        <link rel="stylesheet" href="/resources/css/bootstrap.min.css">
        <title>Title</title>
    </head>
    <body>
        <form action="/update" method="post" enctype="multipart/form-data">
            글번호: <input type="text" name="id" value="${boardUpdate.id}" readonly> <br>
            제목: <input type="text" name="boardTitle" value="${boardUpdate.boardTitle}" > <br>
            작성자: <input type="text" name="boardWriter" value="${boardUpdate.boardWriter}" readonly> <br>
            글내용: <input type="text" name="boardContents" value="${boardUpdate.boardContents}" > <br>
            파일: <input type="file" name="boardFile" value="${boardUpdate.boardFile}" > <br>
            <input type="submit" value="수정">
        </form>
    </body>
</html>
