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
    <link rel="stylesheet" href="/resources/css/bootstrap.min.css">
    <title>Title</title>
</head>
<body>
<div class="container">
    <h2>글작성</h2>
    <div class="py-5 text-center">
        <form action="/board/save"  method="post" enctype="multipart/form-data">
            <input type="text" class="form-control mb-2" id="boardTitle" name="boardTitle" placeholder="글제목"> <br>
            <input type="text" class="form-control mb-2" id="boardWriter" name="boardWriter"
                   value=${sessionScope.loginMemberId} readonly> <br>
            <input type="text" class="form-control mb-2" id="boardContents" name="boardContents" placeholder="글내용"> <br>
            <input type="file"  class="form-control mb-2" name="boardFile" <%--multiple="multiple"--%>> <br>
            <input type="submit" value="글작성">
        </form>
    </div>
</div>
</body>
</html>
