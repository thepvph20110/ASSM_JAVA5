<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 3/9/2023
  Time: 9:40 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link rel="icon" type="image/x-icon" href="../assets/favicon.ico"/>
    <!-- Bootstrap icons-->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.5.0/font/bootstrap-icons.css" rel="stylesheet"/>
    <link href="../css/custom/styles.css" rel="stylesheet"/>
    <!-- includes Bootstrap-->
    <link href="../css/plugin/bootstrap.css" rel="stylesheet"/>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-KK94CHFLLe+nY2dmCWGMq91rCGa5gtU4mk92HdvYe+M/SXH301p5ILy+dN9+nJOZ" crossorigin="anonymous">
</head>
</head>
<body>
<jsp:include page="../layout/header.jsp"/>
<!-- Page header with logo and tagline-->
<header class="bg-dark py-5">
    <div class="container px-4 px-lg-5 my-5">
        <div class="text-center text-white">
            <h1 class="display-4 fw-bolder">Welcome To Product Page !</h1>
            <p class="lead fw-normal text-white-50 mb-0">Uy Tín Đặt Lên Hàng Đầu</p>
        </div>
    </div>
</header>
<br>
<br>
<!-- Page content-->
<div class="container">
    <div class="row">
        <!-- Blog entries-->
        <div class="col-lg-8">
            <!-- Featured blog post-->
            <div class="card mb-4" >
                <a href="/user/detail/${sp.id}"><img class="card-img-top" src="../../img/${sp.img}" alt="..."/></a>
                <div class="card-body">
                    <div class="small text-muted">Price : ${sp.giaBan}$</div>
                    <h2 class="card-title">Tên Sản Phẩm : ${sp.tenSP} ${sp.nhaSanXuat.ten}</h2>
                    <p class="card-text">Mô Tả : ${sp.moTa}</p>

                    <button onclick="addToCart('${sp.id}')" class="btn btn-primary">Add To Cart</button>
                    <button onclick="buyNow('${sp.id}')" class="btn btn-success">Buy Now</button>
                </div>
            </div>
            <br>
            <!-- Nested row for non-featured blog posts-->
            <div class="row">
                <c:forEach items="${list}" var="l">
                    <div class="col-lg-6">
                        <!-- Blog post-->
                        <div class="card mb-4">
                            <a href="/user/detail/${l.id}"><img class="card-img-top" src="../../img/${l.img}" alt="..." /></a>
                            <div class="card-body">
                                <div class="small text-muted">Giá Bán : ${l.giaBan}$</div>
                                <h2 class="card-title h4">Tên Sản Phẩm : ${l.tenSP} ${l.nhaSanXuat.ten}</h2>
                                <p class="card-text">Mô Tả : ${l.moTa}</p>

                                <button onclick="addToCart('${l.id}')" class="btn btn-primary">Add To Cart</button>
                                <button onclick="buyNow('${l.id}')" class="btn btn-success">Buy Now</button>
                            </div>
                        </div>
                    </div>
                </c:forEach>
            </div>
            <!-- Pagination-->
            <nav aria-label="Pagination">
                <hr class="my-0"/>
                <ul class="pagination justify-content-center my-4">
                    <li class="page-item disabled"><a class="page-link" href="#" tabindex="-1" aria-disabled="true">Newer</a>
                    </li>
                    <li class="page-item active" aria-current="page"><a class="page-link" href="#!">1</a></li>
                    <li class="page-item"><a class="page-link" href="#!">2</a></li>
                    <li class="page-item"><a class="page-link" href="#!">3</a></li>
                    <li class="page-item disabled"><a class="page-link" href="#!">...</a></li>
                    <li class="page-item"><a class="page-link" href="#!">15</a></li>
                    <li class="page-item"><a class="page-link" href="#!">Older</a></li>
                </ul>
            </nav>
        </div>
        <!-- Side widgets-->
        <div class="col-lg-4">
            <!-- Categories widget-->
            <div class="card mb-4">
                <div class="card-header">Categories</div>
                <div class="card-body">
                    <div class="row">
                        <div class="col-sm-6">
                            <ul class="list-unstyled mb-0">
                                <c:forEach items="${nsx}" var="o">
                                    <li><a href="/user/nha-san-xuat/${o.id}">${o.ten}</a></li>
                                </c:forEach>
                            </ul>
                        </div>
                    </div>
                </div>
            </div>
            <!-- Side widget-->
            <div class="card mb-4">
                <div class="card-header">Side Widget</div>
                <div class="card-body">You can put anything you want inside of these side widgets. They are easy to use,
                    and feature the Bootstrap 5 card component!
                </div>
            </div>
        </div>
    </div>
</div>
<jsp:include page="../layout/footer.jsp"/>
<!-- Bootstrap core JS-->
<script src="../js/plugin/bootstrap.bundle.min.js"></script>
<!-- Core theme JS-->
<script src="../js/custom/scripts.js"></script>
<script src="../js/custom/cart.js"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ENjdO4Dr2bkBIFxQpeoTz1HIcje39Wm4jDKdf19U8gI4ddQ3GYNS7NTKfAdVQSZe" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.7/dist/umd/popper.min.js" integrity="sha384-zYPOMqeu1DAVkHiLqWBUTcbYfZ8osu1Nd6Z89ify25QV9guujx43ITvfi12/QExE" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/js/bootstrap.min.js" integrity="sha384-Y4oOpwW3duJdCWv5ly8SCFYWqFDsfob/3GkgExXKV4idmbt98QcxXYs9UoXAB7BZ" crossorigin="anonymous"></script>
</body>
</html>
