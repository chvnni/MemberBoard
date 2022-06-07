<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 2022-05-23
  Time: 오후 3:28
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
    <head>
        <title>Title</title>
    </head>
    <body>
        <header>
            <a href="/">Home</a> &nbsp;
            <a href="/save-form">글쓰기</a> &nbsp;
            <a href="/paging">글목록</a> &nbsp;
            <c:if test="${sessionScope.loginMemberId ne null}">
                <a href="/myPage">마이페이지</a>
            </c:if>
        </header>
    </body>
</html>
