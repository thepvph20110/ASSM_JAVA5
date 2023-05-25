<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 3/9/2023
  Time: 5:41 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link rel="icon" type="image/x-icon" href="../assets/favicon.ico"/>
    <!-- Bootstrap icons-->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.5.0/font/bootstrap-icons.css" rel="stylesheet"/>
    <!-- Core theme CSS (includes Bootstrap)-->
    <link href="../css/custom/styles.css" rel="stylesheet"/>
    <!-- includes Bootstrap-->
<%--    <link href="../css/plugin/bootstrap.css" rel="stylesheet"/>--%>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-KK94CHFLLe+nY2dmCWGMq91rCGa5gtU4mk92HdvYe+M/SXH301p5ILy+dN9+nJOZ" crossorigin="anonymous">
</head>
<body>
<jsp:include page="../layout/header.jsp"/>
<!-- Page header with logo and tagline-->
<header class="bg-dark py-5">
    <div class="container px-4 px-lg-5 my-5">
        <div class="text-center text-white">
            <h1 class="display-4 fw-bolder">Welcome Detail Product Page!</h1>
            <p class="lead fw-normal text-white-50 mb-0">Uy Tín Đặt Lên Hàng Đầu</p>
        </div>
    </div>
</header>
<br>
<!-- Page content-->
<div class="container mt-5">
    <div class="row">
        <div class="col-lg-12">
            <!-- Post content-->
            <article>
                <!-- Post header-->
                <header class="mb-4">
                    <!-- Post title-->
                    <h1 class="fw-bolder mb-1">Tên Sản phẩm : ${ctsp.tenSP}</h1>
                    <!-- Post meta content-->
                    <div class="text-muted fst-italic mb-2">Price : ${ctsp.giaBan}$</div>
                    <!-- Post categories-->
                    <a class="badge bg-secondary text-decoration-none link-light" href="#!">Brand
                        : ${ctsp.nhaSanXuat.ten}</a>
                </header>
                <!-- Preview image figure-->
                <figure class="mb-4"><img class="img-fluid rounded"
                                          src="../../img/${ctsp.img}" alt="..."/></figure>
                <!-- Post content-->
                <section class="mb-5">
                    <p class="fs-5 mb-4">${ctsp.moTa}</p>
                </section>
                <a href="/user/detail/${ctsp.id}" class="btn btn-primary">Add To Cart</a>
                <button onclick="buyNow('${ctsp.id}')" class="btn btn-success">Buy Now</button>
            </article>
            <br>
            <!-- Comments section-->
            <section class="mb-5">
                <div class="card bg-light">
                    <div class="card-body">
                        <!-- Comment form-->
                        <form class="mb-4"><textarea class="form-control" rows="3"
                                                     placeholder="Join the discussion and leave a comment!"></textarea>
                        </form>
                        <!-- Comment with nested comments-->
                        <div class="d-flex mb-4">
                            <!-- Parent comment-->
                            <div class="flex-shrink-0"><img class="rounded-circle"
                                                            src="https://dummyimage.com/50x50/ced4da/6c757d.jpg"
                                                            alt="..."/></div>
                            <div class="ms-3">
                                <div class="fw-bold">Triển Đoàn</div>
                                This Product is the best ever
                                <!-- Child comment 1-->
                                <div class="d-flex mt-4">
                                    <div class="flex-shrink-0"><img class="rounded-circle"
                                                                    src="https://dummyimage.com/50x50/ced4da/6c757d.jpg"
                                                                    alt="..."/></div>
                                    <div class="ms-3">
                                        <div class="fw-bold">Văn Sỹ</div>
                                        I never seen anyone like you before
                                    </div>
                                </div>
                                <!-- Child comment 2-->
                                <div class="d-flex mt-4">
                                    <div class="flex-shrink-0"><img class="rounded-circle"
                                                                    src="https://dummyimage.com/50x50/ced4da/6c757d.jpg"
                                                                    alt="..."/></div>
                                    <div class="ms-3">
                                        <div class="fw-bold">Lâm Xung</div>
                                        Hey, I was doing just fine before I met you
                                        I drink too much and that's an issue, but I'm okay
                                        Hey, you tell your friends it was nice to meet them
                                        But I hope I never see them again
                                    </div>
                                </div>
                            </div>
                        </div>
                        <!-- Single comment-->
                        <div class="d-flex">
                            <div class="flex-shrink-0"><img class="rounded-circle"
                                                            src="https://dummyimage.com/50x50/ced4da/6c757d.jpg"
                                                            alt="..."/></div>
                            <div class="ms-3">
                                <div class="fw-bold">Cao Đình</div>
                                So, baby, pull me closer
                                In the back seat of your Rover
                                That I know you can't afford
                                Bite that tattoo on your shoulder
                                Pull the sheets right off the corner
                                Of that mattress that you stole
                                From your roommate back in Boulder
                            </div>
                        </div>
                    </div>
                </div>
            </section>
        </div>
    </div>
</div>
<jsp:include page="../layout/footer.jsp"/>
<!-- Bootstrap core JS-->
<script src="../js/plugin/bootstrap.bundle.min.js"></script>
<!-- Core theme JS-->
<script src="../js/custom/scripts.js"></script>
<script src="../js/custom/cart.js"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-ENjdO4Dr2bkBIFxQpeoTz1HIcje39Wm4jDKdf19U8gI4ddQ3GYNS7NTKfAdVQSZe"
        crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.7/dist/umd/popper.min.js"
        integrity="sha384-zYPOMqeu1DAVkHiLqWBUTcbYfZ8osu1Nd6Z89ify25QV9guujx43ITvfi12/QExE"
        crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/js/bootstrap.min.js"
        integrity="sha384-Y4oOpwW3duJdCWv5ly8SCFYWqFDsfob/3GkgExXKV4idmbt98QcxXYs9UoXAB7BZ"
        crossorigin="anonymous"></script>
<script src="../js/plugin/bootstrap.bundle.min.js"></script>
<script src="../js/custom/img.js"></script>
<script src="../js/custom/quanlysanpham.js"></script>
</body>
</html>
