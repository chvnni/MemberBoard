<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 2022-05-26
  Time: 오후 1:59
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
    <head>
        <title>Title</title>
        <link rel="stylesheet" href="/resources/css/bootstrap.min.css">
    </head>
    <body>
        <jsp:include page="../layout/header.jsp" flush="false"></jsp:include>
        <div class="container">
            <h2 class="display-4 fw-normal">회원가입</h2>
            <div class="py-5 text-center">
                <form action="/member/save" method="post" enctype="multipart/form-data">
                    아이디: <input type="text" class="form-control mb-2" id="memberId" name="memberId" placeholder="아이디"> <br>
                    비밀번호: <input type="text" class="form-control mb-2" id="memberPassword" name="memberPassword" placeholder="비밀번호"> <br>
                    이름: <input type="text" class="form-control mb-2" id="memberName" name="memberName" placeholder="이름"> <br>
                    이메일: <input type="text" class="form-control mb-2" id="memberEmail" name="memberEmail" placeholder="이메일"> <br>
                    전화번호: <input type="text" class="form-control mb-2" id="memberMobile" name="memberMobile" placeholder="전화번호"> <br>
                    프로필사진: <input type="file" class="form-control mb-2" name="memberFile"> <br>
                    <input type="submit" class="form-control mb-2" value="회원가입">
                </form>
            </div>
        </div>
    </body>
</html>
