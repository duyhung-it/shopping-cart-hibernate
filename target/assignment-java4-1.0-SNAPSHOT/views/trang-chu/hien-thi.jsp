<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Nguyen Duy Hung
  Date: 3/12/2023
  Time: 11:10 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<div class="container-fluid">

    <!-- start page title -->
    <div class="row">
        <div class="col-12">
            <div class="page-title-box">
                <h4 class="page-title">Sản Phẩm</h4>
            </div>
        </div>
    </div>
    <!-- end page title -->

    <div class="row">
        <div class="col-12">
            <div class="row mb-2">
                <div class="col-sm-8">
                </div><!-- end col-->
            </div>
            <div class="row">
                <c:forEach var="item" items="${list}">
                    <div
                            class="col-lg-3 col-md-4 col-sm-6"
                    >
                        <div class="box card">
                            <a href="<c:url value="/trang-chu/chi-tiet/hien-thi?id=${item.id}"/>">
                                <div class="img-box w-100">
                                    <img src="<c:url value="/uploads/${item.images}"/>" alt=""/>
                                </div>
                                <div class="detail-box">
                                    <h6>${item.sanPham.ten}(${item.mauSac.ten}),NSX: ${item.nhaSanXuat.ten}</h6>
                                    <h6>
                                        <span>${item.giaBan}</span>
                                    </h6>
                                </div>
                            </a>
                        </div>
                        <div style="clear: both"></div>
                    </div>
                </c:forEach>
            </div> <!-- end col -->
        </div>
    </div>
</div>