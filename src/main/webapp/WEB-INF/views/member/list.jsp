<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 2022-05-27
  Time: 오후 2:12
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
    <head>
        <title>Title</title>
        <script src="/resources/js/jquery.js"></script>
        <script src="/resources/css/bootstrap.min.css"></script>
    </head>
    <body>
        <h2>회원목록</h2>
        <div class="container">
            <table class="table">
                <tr>
                    <th>회원번호</th>
                    <th>아이디</th>
                    <th>비밀번호</th>
                    <th>이름</th>
                    <th>이메일</th>
                    <th>전화번호</th>
                </tr>
                <c:forEach items="${memberList}" var="member">
                    <tr>
                        <td>${member.id}</td>
                        <td>${member.memberId}</td>
                        <td>${member.memberPassword}</td>
                        <td>${member.memberName}</td>
                        <td>${member.memberEmail}</td>
                        <td>${member.memberMobile}</td>
                        <td><a href="/member/delete?id=${member.id}">회원삭제</a></td>
                    </tr>
                </c:forEach>
            </table>
        </div>
    </body>
</html>
