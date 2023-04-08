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
                <h4 class="page-title">Khách Hàng</h4>
            </div>
        </div>
    </div>
    <!-- end page title -->
    <div class="row">
        <div class="col-12">
            <div class="card">
                <div class="card-body">
                    <form action="<c:url value="/khach-hang/${action}"/>" method="post">
                        <div class="mb-3 row">
                            <label for="inputMa" class="col-sm-2 col-form-label">Mã</label>
                            <div class="col-sm-10">
                                <input type="text" class="form-control" id="inputMa" name="ma" value="${khachHang.ma}">
                            </div>
                        </div>
                        <div class="mb-3 row">
                            <label  class="col-sm-2 col-form-label">Họ</label>
                            <div class="col-sm-10">
                                <input type="text" class="form-control" name="ho" value="${khachHang.ho}">
                            </div>
                        </div>
                        <div class="mb-3 row">
                            <label  class="col-sm-2 col-form-label">Tên Đệm</label>
                            <div class="col-sm-10">
                                <input type="text" class="form-control" name="tenDem" value="${khachHang.tenDem}">
                            </div>
                        </div>
                        <div class="mb-3 row">
                            <label  class="col-sm-2 col-form-label">Tên</label>
                            <div class="col-sm-10">
                                <input type="text" class="form-control" name="ten" value="${khachHang.ten}">
                            </div>
                        </div>
                        <div class="mb-3 row">
                            <label  class="col-sm-2 col-form-label">Ngày sinh</label>
                            <div class="col-sm-10">
                                <input type="date" class="form-control" name="ngaySinh" value="${ngaySinh}">
                            </div>
                        </div>
                        <div class="mb-3 row">
                            <label  class="col-sm-2 col-form-label">Địa chỉ</label>
                            <div class="col-sm-10">
                                <input type="text" class="form-control" name="diaChi" value="${khachHang.diaChi}">
                            </div>
                        </div>
                        <div class="mb-3 row">
                            <label  class="col-sm-2 col-form-label">Thành phố</label>
                            <div class="col-sm-10">
                                <input type="text" class="form-control" name="thanhPho" value="${khachHang.thanhPho}">
                            </div>
                        </div>
                        <div class="mb-3 row">
                            <label  class="col-sm-2 col-form-label">Quốc gia</label>
                            <div class="col-sm-10">
                                <input type="text" class="form-control" name="quocGia" value="${khachHang.quocGia}">
                            </div>
                        </div>
                        <div class="mb-3 row">
                            <label  class="col-sm-2 col-form-label">Số điện thoại</label>
                            <div class="col-sm-10">
                                <input type="number" class="form-control" name="soDienThoai" value="${khachHang.soDienThoai}">
                            </div>
                        </div>
                        <div class="mb-3 row">
                            <label  class="col-sm-2 col-form-label">Mật khẩu</label>
                            <div class="col-sm-10">
                                <input type="text" class="form-control" name="matKhau" value="${khachHang.matKhau}">
                            </div>
                        </div>
                        <input type="text" class="form-control d-none" name="id" value="${khachHang.id}">
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
