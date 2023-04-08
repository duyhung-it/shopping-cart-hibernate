<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Nguyen Duy Hung
  Date: 3/12/2023
  Time: 11:48 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<div class="container-fluid">
    <!-- start page title -->
    <div class="row">
        <div class="col-12">
            <div class="page-title-box">
                <h4 class="page-title">Chi Tiết Sản Phẩm</h4>
            </div>
        </div>
    </div>
    <!-- end page title -->
    <div class="row">
        <div class="col-12">
            <div class="card">
                <div class="card-body">
                    <form action="<c:url value="/chi-tiet-san-pham/${action}"/>" method="post" enctype="multipart/form-data">
                        <div class="mb-3 row">
                            <label  class="col-sm-2 col-form-label">Sản phẩm</label>
                            <div class="col-sm-10">
                                <select class="form-control" aria-label="Default select example" name="sanPham">
                                    <option selected value="">Open this select menu</option>
                                    <c:forEach items="${listSanPham}" var="item">
                                        <option value="${item.id}"
                                                <c:if test="${chiTietSanPham.sanPham.id == item.id}">
                                                    selected
                                                </c:if>
                                        >${item.ten}</option>
                                    </c:forEach>
                                </select>
                            </div>
                        </div>
                        <div class="mb-3 row">
                            <label  class="col-sm-2 col-form-label">Màu sắc</label>
                            <div class="col-sm-10">
                                <select class="form-control" aria-label="Default select example" name="mauSac">
                                    <option selected>Open this select menu</option>
                                    <c:forEach items="${listMauSac}" var="item">
                                        <option value="${item.id}"
                                                <c:if test="${chiTietSanPham.mauSac.id == item.id}">
                                                    selected
                                                </c:if>
                                        >${item.ten}</option>
                                    </c:forEach>
                                </select>
                            </div>
                        </div>
                        <div class="mb-3 row form-group">
                            <label  class="col-sm-2 col-form-label">Dòng sản phẩm</label>
                            <div class="col-sm-10">
                                <select class="form-control" aria-label="Default select example" name="dongSanPham">
                                    <option selected>Open this select menu</option>
                                    <c:forEach items="${listDongSanPham}" var="item">
                                        <option value="${item.id}"
                                                <c:if test="${chiTietSanPham.dongSanPham.id == item.id}">
                                                    selected
                                                </c:if>
                                        >${item.ten}</option>
                                    </c:forEach>
                                </select>
                            </div>
                        </div>
                        <div class="mb-3 row form-group">
                            <label  class="col-sm-2 col-form-label">Nhà sản xuất</label>
                            <div class="col-sm-10">
                                <select class="form-control" aria-label="Default select example" name="nhaSanXuat">
                                    <option selected>Open this select menu</option>
                                    <c:forEach items="${listNhaSanXuat}" var="item">
                                        <option value="${item.id}"
                                                <c:if test="${chiTietSanPham.nhaSanXuat.id == item.id}">
                                                    selected
                                                </c:if>
                                        >${item.ten}</option>
                                    </c:forEach>
                                </select>
                            </div>
                        </div>
                        <div class="mb-3 row">
                            <label class="col-sm-2 col-form-label">Ảnh</label>
                            <div class="col-sm-10">
                                <input type="file" class="form-control-file"  name="image">
                            </div>
                        </div>
                        <div class="mb-3 row">
                            <label class="col-sm-2 col-form-label">Năm bảo hành</label>
                            <div class="col-sm-10">
                                <input type="number" class="form-control"  name="namBaoHanh" value="${chiTietSanPham.namBaoHanh}">
                            </div>
                        </div>
                        <div class="mb-3 row">
                            <label class="col-sm-2 col-form-label">Mô tả</label>
                            <div class="col-sm-10">
                                <input type="text" class="form-control"  name="moTa" value="${chiTietSanPham.moTa}">
                            </div>
                        </div>
                        <div class="mb-3 row">
                            <label class="col-sm-2 col-form-label">Số lượng tồn</label>
                            <div class="col-sm-10">
                                <input type="number" class="form-control"  name="soLuongTon" value="${chiTietSanPham.soLuongTon}">
                            </div>
                        </div>
                        <div class="mb-3 row">
                            <label class="col-sm-2 col-form-label">Giá nhập</label>
                            <div class="col-sm-10">
                                <input type="number" class="form-control"  name="giaNhap" value="${chiTietSanPham.giaNhap}">
                            </div>
                        </div>
                        <div class="mb-3 row">
                            <label class="col-sm-2 col-form-label">Giá bán</label>
                            <div class="col-sm-10">
                                <input type="number" class="form-control"  name="giaBan" value="${chiTietSanPham.giaBan}">
                            </div>
                        </div>
                        <input type="text" class="form-control d-none" name="id" value="${chiTietSanPham.id}">
                        <button type="submit" class="btn btn-dark">${button}</button>
                    </form>
                </div>
                <!-- end card-body-->
            </div>
            <!-- end card-->
        </div>
        <!-- end col -->
    </div>
    <!-- end row -->
</div>
