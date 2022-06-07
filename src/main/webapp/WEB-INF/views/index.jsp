<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 2022-05-26
  Time: 오후 1:59
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
    <head>
        <title>Title</title>
    </head>
    <body>
        <h2>index.jsp</h2>

        <c:if test="${sessionScope.loginMemberId eq null}">
        <a href="/saveForm">회원가입</a>
        <a href="/loginForm">로그인</a>
        </c:if>

        <c:if test="${sessionScope.loginMemberId ne null}">
            <a href="/logout">로그아웃</a>
        </c:if>
        <a href="/paging">글목록</a>

        <c:if test="${sessionScope.loginMemberId eq 'admin'}">
        <a href="/findAllMember">회원목록 보기</a>
        </c:if>

    </body>
    <script>
    </script>
</html>
