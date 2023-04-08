<%--
  Created by IntelliJ IDEA.
  User: Nguyen Duy Hung
  Date: 4/2/2023
  Time: 11:14 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<section>
    <div class="container-fluid">
        <!-- start page title -->
        <div class="row">
            <div class="col-12">
                <div class="page-title-box">
                    <h4 class="page-title">Product Details</h4>
                </div>
            </div>
        </div>
        <!-- end page title -->

        <div class="row">
            <div class="col-12">
                <div class="card">
                    <div class="card-body">
                        <div class="row">
                            <div class="col-lg-5">
                                <!-- Product image -->
                                <a href="#" class="text-center d-block mb-4">
                                    <img
                                            src="<c:url value="/uploads/${chiTietSanPham.images}"/>"
                                            class="img-fluid"
                                            style="max-width: 280px"
                                            alt="Product-img"
                                    />
                                </a>
                            </div>
                            <!-- end col -->
                            <div class="col-lg-7">
                                <form class="pl-lg-4" action="<c:url value="/gio-hang/add"/>" method="post">
                                    <!-- Product title -->
                                    <h3 class="mt-0">
                                        ${chiTietSanPham.sanPham.ten}(${chiTietSanPham.mauSac.ten}),NSX: ${chiTietSanPham.nhaSanXuat.ten}
                                        <a href="" class="text-muted"
                                        ><i class="mdi mdi-square-edit-outline ml-2"></i
                                        ></a>
                                    </h3>
                                    <p class="mb-1">Ngày tạo: 09/12/2018</p>
                                    <p class="font-16">
                                        <span class="text-warning mdi mdi-star"></span>
                                        <span class="text-warning mdi mdi-star"></span>
                                        <span class="text-warning mdi mdi-star"></span>
                                        <span class="text-warning mdi mdi-star"></span>
                                        <span class="text-warning mdi mdi-star"></span>
                                    </p>

                                    <!-- Product stock -->
                                    <div class="mt-3">
                                        <h4>
                                            <span class="badge badge-success-lighten">Hot</span>
                                        </h4>
                                    </div>

                                    <!-- Product description -->
                                    <div class="mt-4">
                                        <h6 class="font-14">Giá:</h6>
                                        <h3>${chiTietSanPham.giaBan}</h3>
                                    </div>
                                    <!-- Quantity -->
                                        <div class="mt-4">
                                            <h6 class="font-14">Số lượng</h6>
                                            <div class="d-flex">
                                                <input
                                                        type="number"
                                                        min="1"
                                                        class="form-control"
                                                        placeholder="Qty"
                                                        style="width: 90px"
                                                        name="soLuong"

                                                />
                                                <input type="text"
                                                       name="id"
                                                       aria-controls="products-datatable"
                                                       class="d-none"
                                                       value="${chiTietSanPham.id}"
                                                >
                                                <button
                                                        type="submit"
                                                        class="btn btn-danger ml-2"
                                                >
                                                    <i class="mdi mdi-cart mr-1"></i> Add to cart
                                                </button>

                                            </div>
                                        </div>
                                    <!-- Product description -->
                                    <div class="mt-4">
                                        <h6 class="font-14">Mô tả sản phẩm:</h6>
                                        <p>${chiTietSanPham.moTa}</p>
                                    </div>

                                    <!-- Product information -->
                                    <div class="mt-4">
                                        <div class="row">
                                            <div class="col-md-4">
                                                <h6 class="font-14">Available Stock:</h6>
                                                <p class="text-sm lh-150">
                                                    ${chiTietSanPham.soLuongTon}
                                                </p>
                                            </div>
                                        </div>
                                    </div>
                                </form>
                            </div>
                            <!-- end col -->
                        </div>
                        <!-- end row-->

                        <!-- end table-responsive-->
                    </div>
                    <!-- end card-body-->
                </div>
                <!-- end card-->
            </div>
            <!-- end col-->
        </div>
    </div>
</section>
