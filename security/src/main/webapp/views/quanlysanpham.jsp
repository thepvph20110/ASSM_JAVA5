<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 3/10/2023
  Time: 8:20 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Trang Quản Lý</title>
    <!-- Core theme CSS (includes Bootstrap)-->
    <link href="../css/custom/styles.css" rel="stylesheet"/>
    <!-- includes Bootstrap-->
    <link href="../css/plugin/bootstrap.css" rel="stylesheet"/>
</head>
<body>
<jsp:include page="../layout/header.jsp"/>
<header class="bg-dark py-5">
    <div class="container px-4 px-lg-5 my-5">
        <div class="text-center text-white">
            <h1 class="display-4 fw-bolder">Trang Quản Lý Sản Phẩm</h1>
            <p class="lead fw-normal text-white-50 mb-0">Uy Tín Đặt Lên Hàng Đầu</p>
        </div>
    </div>
</header>
<br>
<div class="container">
    <div class="container" style="width: 900px">
        <form action="/admin/add-san-pham" method="post" enctype="multipart/form-data">
            <img width="200px" height="150px"
                    src="${empty sp ? "https://www.freeiconspng.com/thumbs/photography-icon-png/photo-album-icon-png-14.png": "/wepapp/img/"+sp.img}"
                    class="img-fluid rounded-pill"
                    alt="Townhouses and Skyscrapers"
            />
            <br>
            <div class="row">
                <div class="col-6">

                    <div class="mb-3">
                        <label for="formFileMultiple" class="form-label">Image</label>
                        <input class="form-control" name="image" type="file" id="formFileMultiple" multiple value="${sp.Img}">
                        <c:if test="${error.imgError != null}">
                            <p style="color: red">${error.imgError}</p>
                        </c:if>
                    </div>

                    <div class="mb-3">
                        <label for="exampleInputEmail1" class="form-label">Tên Sản Phẩm</label>
                        <input type="text" name="ten" class="form-control" id="exampleInputEmail1"
                               aria-describedby="emailHelp" value="${sp.tenSP}">
                        <c:if test="${error.tenError != null}">
                            <p style="color: red">${error.tenError}</p>
                        </c:if>
                    </div>


                    <div class="mb-3">
                        <label for="exampleInputDescription" class="form-label">Mô Tả</label>
                        <input type="text" name="moTa" class="form-control" id="exampleInputDescription" value="${sp.moTa}">
                        <c:if test="${error.moTaError != null}">
                            <p style="color: red">${error.moTaError}</p>
                        </c:if>
                    </div>
                    <div class="mb-3">
                        <label for="exampleInputPrice" class="form-label">Giá Bán</label>
                        <input type="text" name="giaBan" class="form-control" id="exampleInputPrice" value="${sp.giaban}">
                        <c:if test="${error.giaBanError != null}">
                            <p style="color: red">${error.giaBanError}</p>
                        </c:if>
                    </div>

                </div>

                <div class="col-6">


                    <div class="mb-3">
                        <label for="exampleInputAmount" class="form-label">Số Lượng</label>
                        <input type="text" name="soLuongTon" class="form-control" id="exampleInputAmount" value="${sp.soLuongton}">
                        <c:if test="${error.soLuongTonError != null}">
                            <p style="color: red">${error.soLuongTonError}</p>
                        </c:if>
                    </div>

                    <div class="row">
                        <label for="floatingSelect">Màu Sắc</label>
                        <div class="col-10">
                            <select class="form-select" name="mauSac" id="floatingSelect"
                                    aria-label="Floating label select example">
                                <c:forEach items="${mauSacs}" var="l">
                                    <option ${sp.mauSac.id == l.id ? "selected": ""} value="${l.id}">${l.ten}</option>
                                </c:forEach>
                            </select>

                        </div>
                        <div class="col-2">
                            <a class="btn btn-outline-dark" href="/admin/mau-sac/list">+</a>
                        </div>
                    </div>
                    <br>
                    <div class="row">
                        <label for="floatingSelect">Nhà Sản Xuất</label>
                        <div class="col-10">

                            <select class="form-select" name="nsx" aria-label="Floating label select example">
                                <c:forEach items="${nsx}" var="l">
                                    <option ${sp.nhaSanXuat.id == l.id ? "selected": ""} value="${l.id}">${l.ten}</option>
                                </c:forEach>
                            </select>

                        </div>
                        <div class="col-2">
                            <a class="btn btn-outline-dark" href="/admin/nha-san-xuat/list">+</a>
                        </div>
                    </div>
                </div>
            </div>


            <br>
            <div>
                <button class="btn btn-success">${empty sp ? "ADD": "UPDATE"}</button>
            </div>
        </form>
    </div>


    <br>
    <table class="table table-hover">
        <thead class="table-dark">
        <tr>
            <th scope="col">STT</th>
            <th scope="col">Tên Sản Phẩm</th>
            <th scope="col">Brand</th>
            <th scope="col">Giá</th>
            <th scope="col">Image</th>
            <th scope="col">Số Lượng</th>
            <th scope="col">Chức Năng</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${productPage.content}" var="l" varStatus="status">
            <tr>
                <th scope="row">${status.index +1 }</th>
                <td>${l.tenSP}</td>
                <td>${l.nhaSanXuat.ten}</td>
                <td>${l.giaBan}$</td>
                <td><img class="card-img-top" src="../img/${l.img}" alt="" height="35px" width="30px"></td>
                <td>${l.soLuongTon}</td>
                <td>
                    <a class="btn btn-danger" href="/admin/delete/${l.id}">Delete</a>
                    <a onclick="detailProduct('${l.id}')" type="button" class="btn btn-primary" data-toggle="modal"
                            data-target="#modal_update_can_bo">
                        Detail
                    </a>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>

    <%--    <div>--%>
    <%--        <c:if test="${productPage.totalPages > 1}">--%>
    <%--            <c:forEach var="i" begin="1" end="${productPage.totalPages}">--%>
    <%--                <c:url value="/admin/quan-ly-san-pham" var="pageUrl">--%>
    <%--                    <c:param name="page" value="${i}" />--%>
    <%--                </c:url>--%>
    <%--                <a href="${pageUrl}">${i}</a>--%>
    <%--            </c:forEach>--%>
    <%--        </c:if>--%>
    <%--    </div>--%>

    <nav aria-label="...">
        <ul class="pagination pagination-sm">
            <c:if test="${productPage.totalPages > 1}">
                <c:forEach var="i" begin="1" end="${productPage.totalPages}">
                    <c:url value="/admin/quan-ly-san-pham" var="pageUrl">
                        <c:param name="page" value="${i-1}"/>
                    </c:url>
                    <li class="page-item"><a class="page-link" href="${pageUrl}">${i}</a></li>
                </c:forEach>
            </c:if>

        </ul>
    </nav>
</div>
<!-- Modal -->
<!--  Start Modal Update-->
<div
        class="modal fade"
        tabindex="-1"
        id="modal_update_can_bo"
        aria-labelledby="exampleModalLabel"
        aria-hidden="true">
    <div class="modal-dialog modal-lg modal-lg"
         role="document">
        <div class="modal-content">
            <form id="form_hoc_ky_update">
                <div class="modal-header">
                    <h5 class="modal-title">Detail Product</h5>
                    <button type="button" class="close"
                            data-dismiss="modal" aria-label="Close">
                        <span aria-hidden="true">&times;</span>
                    </button>
                </div>
                <div class="modal-body">
                    <span id="id_san_pham_update" style="color:red;"></span>

                    <div class="form-group">
                        <br>
                        <label class="col-form-label">Tên Sản Phẩm</label>
                        <input
                                type="text"
                                class="form-control"
                                id="tenSP">
                        <span class="text-danger"
                              id="tenSP_error"></span>

                        <br>
                        <label class="col-form-label">Image</label>
                        <input
                                type="file"
                                class="form-control"
                                id="image">
                        <span class="text-danger"
                              id="image_error"></span>

                        <br>
                        <label class="col-form-label">Mô Tả</label>
                        <input
                                type="text"
                                class="form-control"
                                id="mo_ta">
                        <span class="text-danger"
                              id="mo_ta_error"></span>

                        <br>
                        <label class="col-form-label">Giá Bán</label>
                        <input
                                type="text"
                                class="form-control"
                                id="giaBan">
                        <span class="text-danger"
                              id="giaBan_error"></span>

                        <br>
                        <label class="col-form-label">Số Lượng</label>
                        <input
                                type="text"
                                class="form-control"
                                id="soLuong">
                        <span class="text-danger"
                              id="soLuong_error"></span>
                        <br>
                        <label class="col-form-label">Màu Sắc</label>
                        <select id="mauSac" class="form-control col-8">
                            <c:forEach items="${mauSacs}" var="l">
                                <option value="${l.id}">${l.ten}</option>
                            </c:forEach>
                        </select>
                        <br>
                        <label class="col-form-label">Màu Sắc</label>
                        <select id="nsx" class="form-control col-8">
                            <c:forEach items="${nsx}" var="l">
                                <option value="${l.id}">${l.ten}</option>
                            </c:forEach>
                        </select>
                    </div>
                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-secondary"
                            data-dismiss="modal">Hủy
                    </button>
                    <button type="submit" class="btn btn-primary">Cập
                        nhật
                    </button>
                </div>
            </form>
        </div>
    </div>
</div>
<!--   End Modal Update -->
<jsp:include page="../layout/footer.jsp"/>
<!-- Bootstrap core JS-->
<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/2.9.3/umd/popper.min.js"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
<script src="../js/custom/img.js"></script>
<script src="../js/custom/quanlysanpham.js"></script>
<script src="../js/plugin/bootstrap.bundle.min.js"></script>
</body>
</html>
