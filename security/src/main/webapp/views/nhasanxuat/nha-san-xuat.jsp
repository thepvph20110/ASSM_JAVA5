<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Ngày sản xuất</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-GLhlTQ8iRABdZLl6O3oVMWSktQOp6b7In1Zl3/Jr59b6EGGoI1aFkw7cmDA6j6gD" crossorigin="anonymous">
</head>
<body>
<br>
<section class="container" style="width: 600px">
    <form action="/fpoly-shop/nha-san-xuat/add" method="post">
        <div class="form-floating mb-3">
            <input name="ma" type="text" class="form-control" id="floatingInput" placeholder="name@example.com"
                   value="${nhaSanXuat.ma}">
            <label for="floatingInput">Mã nhà sản xuất</label>
        </div>
        <div class="form-floating">
            <input name="ten" type="text" class="form-control" id="floatingPassword" placeholder="Password"
                   value="${nhaSanXuat.ten}">
            <label for="floatingPassword">Tên nhà sản xuất</label>
        </div>
        <br>
        <div class="row">
            <div class="col-6">
                <button type="submit" class="btn btn-primary">Add</button>
            </div>
            <div class="col-5">
                <div class="d-grid gap-2 d-md-flex justify-content-md-end">
                    <a class="btn btn-info" href="/fpoly-shop/chi-tiet-san-pham/view-add">Back</a>
                </div>
            </div>
        </div>
    </form>

</section>
<section>

</section>
<section class="container" style="width: 900px">
    <table class="table ">
        <thead>
        <tr>
            <th scope="col">STT</th>
            <th scope="col">Mã nhà sản xuất</th>
            <th scope="col">Tên nhà sản xuất</th>
            <th scope="col">Action</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${list}" var="nhaSanXuat" varStatus="i">
            <tr>
                <th scope="row">${i.index+1}</th>
                <td>${nhaSanXuat.ma}</td>
                <td>${nhaSanXuat.ten}</td>
                <td>
                    <a href="/fpoly-shop/nha-san-xuat/detail?id=${nhaSanXuat.id}" class="btn btn-success">Detail</a>
                    <a href="/fpoly-shop/nha-san-xuat/remove?id=${nhaSanXuat.id}" class="btn btn-danger">Remove</a>
                    <a href="/fpoly-shop/nha-san-xuat/view-update?id=${nhaSanXuat.id}"
                       class="btn btn-warning">Update</a>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</section>


<%--//bootstrap--%>
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

</body>
</html>
