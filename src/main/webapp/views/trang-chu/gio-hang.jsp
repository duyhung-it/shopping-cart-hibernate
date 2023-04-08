<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Nguyen Duy Hung
  Date: 3/12/2023
  Time: 11:10 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<section>
    <div class="container-fluid">
        <!-- start page title -->
        <div class="row">
            <div class="col-12">
                <div class="page-title-box">
                    <h4 class="page-title">Giỏ hàng</h4>
                </div>
            </div>
        </div>
        <!-- end page title -->

        <div class="row">
            <div class="col-12">
                <div class="card">
                    <div class="card-body">
                        <div class="row">
                            <div class="col-lg-12">
                                <div class="table-responsive">
                                    <table class="table table-borderless table-centered w-100 dt-responsive nowrap dataTable no-footer dtr-inline"
                                           id="products-datatable" role="grid"
                                           aria-describedby="products-datatable_info" style="width: 1108px;">
                                        <thead class="thead-light">
                                        <tr role="row">
                                            <%--                                            <th>Id</th>--%>
                                            <th>Mã</th>
                                            <th>Tên</th>
                                            <%--                                            <th>Màu Sắc</th>--%>
                                            <%--                                            <th>Nhà sản xuất</th>--%>
                                            <th>Giá</th>
                                            <th>Số lượng</th>
                                            <th>Thành tiền</th>
                                            <th></th>
                                        </tr>
                                        </thead>
                                        <tbody>
                                        <c:forEach var="item" items="${list}">
                                            <tr role="row" class="odd">
                                                    <%--                                                <td>${item.id.sanPham.id}</td>--%>
                                                <td>${item.id.sanPham.sanPham.ma}</td>
                                                <td class="sorting_1">
                                                    <img src="<c:url value="/uploads/${item.id.sanPham.images}"/>"
                                                         alt="contact-img" title="contact-img" class="rounded mr-3"
                                                         height="48">
                                                    <p class="m-0 d-inline-block align-middle font-16">
                                                            ${item.id.sanPham.sanPham.ten}(${item.id.sanPham.mauSac.ten}),NSX: ${item.id.sanPham.nhaSanXuat.ten}
                                                        <br>
                                                    </p>
                                                </td>
                                                <td>${item.donGia}</td>
                                                <td>${item.soLuong}</td>
                                                <td>${item.thanhTien}</td>
                                                <td><a href="<c:url value="/gio-hang/delete?id=${item.id.sanPham.id}"/>"
                                                       class="action-icon"> <i
                                                        class="mdi mdi-delete"></i></a></td>
                                            </tr>
                                        </c:forEach>
                                        </tbody>
                                    </table>
                                </div>
                                <!-- end table-responsive-->

                                <!-- action buttons-->
                                <div class="row mt-4">
                                    <div class="col-sm-6">
                                        <a
                                                href="<c:url value="/trang-chu/hien-thi"/>"
                                                class="btn text-muted d-none d-sm-inline-block btn-link font-weight-semibold"
                                        >
                                            <i class="mdi mdi-arrow-left"></i> Continue Shopping
                                        </a>
                                    </div>
                                    <!-- end col -->
                                </div>
                                <!-- end row-->
                            </div>
                            <!-- end col -->


                            <!-- end col -->
                        </div>
                        <!-- end row -->
                    </div>
                    <!-- end card-body-->
                </div>
                <!-- end card-->
            </div>
            <!-- end col -->
        </div>
        <!-- end row -->
    </div>
</section>