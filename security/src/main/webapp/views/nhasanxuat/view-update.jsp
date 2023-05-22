<%--
  Created by IntelliJ IDEA.
  User: ADMIN
  Date: 3/19/2023
  Time: 10:02 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>view-update</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-GLhlTQ8iRABdZLl6O3oVMWSktQOp6b7In1Zl3/Jr59b6EGGoI1aFkw7cmDA6j6gD" crossorigin="anonymous">
</head>
<body>
<section class="container" style="width: 600px">
    <form action="/fpoly-shop/nha-san-xuat/update" method="post">
        <div class="form-floating mb-3">
            <input name="ma" type="text" class="form-control" id="floatingInput" placeholder="name@example.com"
                   value="${nhaSanXuat.ma}">
            <label for="floatingInput">Mã màu</label>
        </div>
        <div class="form-floating">
            <input name="ten" type="text" class="form-control" id="floatingPassword" placeholder="Password"
                   value="${nhaSanXuat.ten}">
            <label for="floatingPassword">Tên Màu</label>
        </div>
        <div class="container" style="margin-top: 20px ">
            <button type="submit" class="btn btn-primary">update</button>
        </div>
    </form>

</section>
<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.6/dist/umd/popper.min.js"
        integrity="sha384-oBqDVmMz9ATKxIep9tiCxS/Z9fNfEXiDAYTujMAeBAsjFuCZSmKbSSUnQlmh/jp3"
        crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/js/bootstrap.min.js"
        integrity="sha384-mQ93GR66B00ZXjt0YO5KlohRA5SY2XofN4zfuZxLkoj1gXtW8ANNCe9d5Y3eG5eD"
        crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-w76AqPfDkMBDXo30jS1Sgez6pr3x5MlQ1ZAGC+nuZB+EYdgRZgiwxhTBTkF7CXvN"
        crossorigin="anonymous"></script>
</body>
</html>
