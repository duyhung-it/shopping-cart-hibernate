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
                <h4 class="page-title">Nhân Viên</h4>
            </div>
        </div>
    </div>
    <!-- end page title -->
    <div class="row">
        <div class="col-12">
            <div class="card">
                <div class="card-body">
                    <form action="<c:url value="/nhan-vien/${action}"/>" method="post">
                        <div class="mb-3 row">
                            <label for="inputMa" class="col-sm-2 col-form-label">Mã</label>
                            <div class="col-sm-10">
                                <input type="text" class="form-control" id="inputMa" name="ma" value="${nhanVien.ma}">
                            </div>
                        </div>
                        <div class="mb-3 row">
                            <label  class="col-sm-2 col-form-label">Họ</label>
                            <div class="col-sm-10">
                                <input type="text" class="form-control" name="ho" value="${nhanVien.ho}">
                            </div>
                        </div>
                        <div class="mb-3 row">
                            <label  class="col-sm-2 col-form-label">Tên Đệm</label>
                            <div class="col-sm-10">
                                <input type="text" class="form-control" name="tenDem" value="${nhanVien.tenDem}">
                            </div>
                        </div>
                        <div class="mb-3 row">
                            <label  class="col-sm-2 col-form-label">Tên</label>
                            <div class="col-sm-10">
                                <input type="text" class="form-control" name="ten" value="${nhanVien.ten}">
                            </div>
                        </div>
                        <div class="mb-3 row">
                            <label  class="col-sm-2 col-form-label">Giới tính</label>
                            <div class="col-sm-10">
                                <div class="form-check form-check-inline">
                                    <input class="form-check-input" type="radio" name="gioiTinh" id="inlineRadio1" value="Nam"
                                    <c:if test="${nhanVien.gioiTinh == 'Nam'}">
                                            checked
                                    </c:if>
                                    >
                                    <label class="form-check-label" for="inlineRadio1">Nam</label>
                                </div>
                                <div class="form-check form-check-inline">
                                    <input class="form-check-input" type="radio" name="gioiTinh" id="inlineRadio2" value="Nu"
                                    <c:if test="${nhanVien.gioiTinh != 'Nam'}">
                                           checked
                                    </c:if>
                                    >
                                    <label class="form-check-label" for="inlineRadio2">Nữ</label>
                                </div>
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
                                <input type="text" class="form-control" name="diaChi" value="${nhanVien.diaChi}">
                            </div>
                        </div>
                        <div class="mb-3 row">
                            <label  class="col-sm-2 col-form-label">Số điện thoại</label>
                            <div class="col-sm-10">
                                <input type="number" class="form-control" name="soDienThoai" value="${nhanVien.soDienThoai}">
                            </div>
                        </div>
                        <div class="mb-3 row">
                            <label  class="col-sm-2 col-form-label">Mật khẩu</label>
                            <div class="col-sm-10">
                                <input type="text" class="form-control" name="matKhau" value="${nhanVien.matKhau}">
                            </div>
                        </div>
                        <div class="mb-3 row">
                            <label  class="col-sm-2 col-form-label">Cửa hàng</label>
                            <div class="col-sm-10">
                                <select class="form-control" aria-label="Default select example" name="cuaHang">
                                    <option selected value="">Open this select menu</option>
                                    <c:forEach items="${listCuaHang}" var="item">
                                        <option value="${item.id}"
                                                <c:if test="${nhanVien.cuaHang.id == item.id}">
                                                    selected
                                                </c:if>
                                        >${item.ten}</option>
                                    </c:forEach>
                                </select>
                            </div>
                        </div>
                        <div class="mb-3 row">
                            <label  class="col-sm-2 col-form-label">Chức vụ</label>
                            <div class="col-sm-10">
                                <select class="form-control" aria-label="Default select example" name="chucVu">
                                    <option selected>Open this select menu</option>
                                    <c:forEach items="${listChucVu}" var="item">
                                        <option value="${item.id}"
                                                <c:if test="${nhanVien.chucVu.id == item.id}">
                                                    selected
                                                </c:if>
                                        >${item.ten}</option>
                                    </c:forEach>
                                </select>
                            </div>
                        </div>
<%--                        <div class="mb-3 row form-group">--%>
<%--                            <label  class="col-sm-2 col-form-label">Trưởng phòng</label>--%>
<%--                            <div class="col-sm-10">--%>
<%--                                <select class="form-control" aria-label="Default select example" name="truongPhong">--%>
<%--                                    <option selected>Open this select menu</option>--%>
<%--                                    <c:forEach items="${listTruongPhong}" var="item">--%>
<%--                                        <option value="${item.id}"--%>
<%--                                                <c:if test="${nhanVien.truongPhong.id == item.id}">--%>
<%--                                                    selected--%>
<%--                                                </c:if>--%>
<%--                                        >${item.ho} ${item.tenDem} ${item.ten}</option>--%>
<%--                                    </c:forEach>--%>
<%--                                </select>--%>
<%--                            </div>--%>
<%--                        </div>--%>
                        <div class="mb-3 row">
                            <label  class="col-sm-2 col-form-label">Trạng thái</label>
                            <div class="col-sm-10">
                                <div class="form-check form-check-inline">
                                    <input class="form-check-input" type="radio" name="trangThai" id="inlineRadio01" value="1"
                                    <c:if test="${nhanVien.trangThai == 1}">
                                           checked
                                    </c:if>
                                    >
                                    <label class="form-check-label" for="inlineRadio01">Hoạt động</label>
                                </div>
                                <div class="form-check form-check-inline">
                                    <input class="form-check-input" type="radio" name="trangThai" id="inlineRadio02" value="0"
                                    <c:if test="${nhanVien.trangThai != 1}">
                                           checked
                                    </c:if>
                                    >
                                    <label class="form-check-label" for="inlineRadio02">Không hoạt động</label>
                                </div>
                            </div>
                        </div>
                        <input type="text" class="form-control d-none" name="id" value="${nhanVien.id}">
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
