<%--
  Created by IntelliJ IDEA.
  User: channi
  Date: 2022-06-02
  Time: 오후 5:47
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
    <head>
        <title>Title</title>
        <link rel="stylesheet" href="/resources/css/bootstrap.min.css">
    </head>
    <body>
        <div class="container">
            <h2 class="display-4 fw-normal">회원정보 수정</h2>
            <form action="/member/update" method="post" name="updateForm">
                회원번호:<input class="form-control mb-2" type="text" name="id" value="${updateMember.id}" readonly> <br>
                아이디:<input class="form-control mb-2" type="text" name="memberId" value="${updateMember.memberId}" readonly> <br>
                비밀번호:<input class="form-control mb-2" type="text" name="memberPassword" id="pwConfirm" placeholder="비밀번호를 입력하세요" > <br>
                이름:<input class="form-control mb-2" type="text" name="memberName" value="${updateMember.memberName}" > <br>
                이메일:<input class="form-control mb-2" type="text" name="memberEmail" value="${updateMember.memberEmail}" > <br>
                전화번호:<input class="form-control mb-2" type="text" name="memberMobile" value="${updateMember.memberMobile}"> <br>
                <input class="btn btn-primary" type="button" onclick="update()" value="정보수정">
            </form>
        </div>
    </body>
    <script>
        const update = () => {
            const pwConfirm = document.getElementById("pwConfirm").value;
            const pwDB = '${updateMember.memberPassword}';
            if (pwConfirm == pwDB) {
                updateForm.submit();
            } else {
                alert("비밀번호가 일치하지 않습니다")
            }
        }
    </script>
</html>
