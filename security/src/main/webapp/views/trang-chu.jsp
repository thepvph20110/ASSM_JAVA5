<%--
  Created by IntelliJ IDEA.
  User: ADMIN
  Date: 5/17/2023
  Time: 4:05 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<html>
<head>
    <title>Shop Giày Siêu Cấp Vip Pro</title>
    <link rel="icon" type="image/x-icon" href="../assets/favicon.ico"/>
    <!-- Bootstrap icons-->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.5.0/font/bootstrap-icons.css" rel="stylesheet"/>
    <!-- Core theme CSS (includes Bootstrap)-->
    <link href="../css/custom/styles.css" rel="stylesheet"/>
    <!-- includes Bootstrap-->
    <link href="../css/plugin/bootstrap.css" rel="stylesheet"/>
    <sec:authentication var="auth">
        <c:set var="username" value="${auth.principal.username}"/>
    </sec:authentication>
</head>
<body>
<jsp:include page="../layout/header.jsp"/>
<!-- Header-->
<header class="bg-dark py-5">
    <div class="container px-4 px-lg-5 my-5">
        <div class="text-center text-white">
            <h1 class="display-4 fw-bolder">Top 5 Sản Phẩm Bán Chạy Nhất</h1>
            <p class="lead fw-normal text-white-50 mb-0">Uy Tín Đặt Lên Hàng Đầu</p>
        </div>
    </div>
</header>
<!-- Section-->
<section class="py-5">
    <div class="container px-4 px-lg-5 mt-5">
        <div class="row gx-4 gx-lg-5 row-cols-2 row-cols-md-3 row-cols-xl-4 justify-content-center">
            <c:forEach items="${list}" var="l">
                <div class="col mb-5">
                    <div class="card h-100">
                        <!-- Product image-->
                        <a href="/user/detail/${l.id}"><img class="card-img-top" src="../img/${l.img}" alt="..."/></a>
                        <!-- Product details-->
                        <div class="card-body p-4">
                            <div class="text-center">
                                <!-- Product name-->
                                <h5 class="fw-bolder">Tên Sản Phẩm : ${l.tenSP}</h5>
                                <!-- Product price-->
                                Price : ${l.giaBan}$
                            </div>
                        </div>
                        <!-- Product actions-->
                        <div class="card-footer p-4 pt-0 border-top-0 bg-transparent">
                            <div class="text-center">
                                <a href="/user/add-to-cart?idSP=${l.id}&urlnow=/home/list" class="btn btn-success" type="submit">Add To
                                    Cart
                                </a>
                            </div>
                        </div>
                        <div class="card-footer p-4 pt-0 border-top-0 bg-transparent">
                            <div class="text-center">
                                <button onclick="buyNow('${l.id}')" class="btn btn-primary" >Buy Now</button>
                            </div>
                        </div>
                    </div>
                </div>
            </c:forEach>
        </div>
    </div>
</section>
<jsp:include page="../layout/footer.jsp"/>
<!-- Bootstrap core JS-->
<script src="../js/plugin/bootstrap.bundle.min.js"></script>
<!-- Core theme JS-->
<script src="../js/custom/scripts.js"></script>
<script src="../js/custom/cart.js"></script>
</body>
</html>