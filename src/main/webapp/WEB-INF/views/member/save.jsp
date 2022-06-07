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
        <script src="https://code.jquery.com/jquery-3.6.0.js"></script>
        <script type="text/javascript"
                src="https://cdnjs.cloudflare.com/ajax/libs/moment.js/2.24.0/moment.min.js"></script>
    </head>
    <body>
        <jsp:include page="../layout/header.jsp" flush="false"></jsp:include>
        <div class="container">
            <h2 class="display-4 fw-normal">회원가입</h2>
            <div class="py-5 text-center">
                <form action="/member/save" method="post" enctype="multipart/form-data">
                    아이디: <input type="text" onblur="duplicateCheck()" class="form-control mb-2" id="memberId"
                                name="memberId" placeholder="아이디">
                    <br>
                    <span id="dupCheckResult"></span> <br>
                    비밀번호: <input type="text" class="form-control mb-2" id="memberPassword" name="memberPassword"
                                 placeholder="비밀번호"> <br>
                    이름: <input type="text" class="form-control mb-2" id="memberName" name="memberName" placeholder="이름">
                    <br>
                    이메일: <input type="text" class="form-control mb-2" id="memberEmail" name="memberEmail"
                                placeholder="이메일"> <br>
                    전화번호: <input type="text" class="form-control mb-2" id="memberMobile" name="memberMobile"
                                 placeholder="전화번호"> <br>
                    프로필사진: <input type="file" class="form-control mb-2" name="memberFile"> <br>
                    <input type="submit" class="form-control mb-2" value="회원가입">
                </form>
            </div>
        </div>
    </body>
    <script>
        const duplicateCheck = () => {
            const memberId = document.getElementById("memberId").value;
            const checkResult = document.getElementById("dupCheckResult");
            $.ajax({
                type: "post",
                url: "duplicate-check",
                data: {"memberId": memberId},
                dataType: "text",
                success: function (result) {
                    if (result == "ok") {
                        checkResult.innerHTML = "사용가능한 아이디"
                        checkResult.style.color = "green"
                    } else {
                        checkResult.innerHTML = "이미 사용중인 아이디"
                        checkResult.style.color = "red"
                    }
                },
                error: function () {
                    alert("오타체크");
                }
            });
        }
    </script>
</html>
