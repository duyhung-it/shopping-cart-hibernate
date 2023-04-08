<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Nguyen Duy Hung
  Date: 3/12/2023
  Time: 11:10 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%--<html>--%>
<%--<head>--%>
<%--    <title>Title</title>--%>
<%--    <link href="<c:url value="/template/assets/css/icons.min.css"/>" rel="stylesheet" type="text/css"/>--%>
<%--    <link href="<c:url value="/template/assets/css/app-creative.min.css"/>" rel="stylesheet" type="text/css"--%>
<%--          id="light-style"/>--%>
<%--    &lt;%&ndash;  <link href="<c:url value="/template/assets/css/app-creative-dark.min.css"/>" rel="stylesheet" type="text/css" id="dark-style" />&ndash;%&gt;--%>
<%--</head>--%>
<%--<body>--%>
<%--<div class="wrapper">--%>
<%--&lt;%&ndash;    Menu&ndash;%&gt;--%>
<%--    <%@include file="/layout/menu.jsp"%>--%>
<%--&lt;%&ndash;    End Menu&ndash;%&gt;--%>
<%--    <div class="content-page">--%>
<%--        <div class="content">--%>
<%--            <%@include file="/layout/header.jsp"%>--%>
            <div class="container-fluid">

                <!-- start page title -->
                <div class="row">
                    <div class="col-12">
                        <div class="page-title-box">
                            <h4 class="page-title">Màu Sắc</h4>
                        </div>
                    </div>
                </div>
                <!-- end page title -->

                <div class="row">
                    <div class="col-12">
                        <div class="card">
                            <div class="card-body">
                                <div class="row mb-2">
                                    <div class="col-sm-4">
                                        <a href="<c:url value="/mau-sac/add"/>" class="btn btn-danger mb-2"><i
                                                class="mdi mdi-plus-circle mr-2"></i> Thêm màu sắc</a>
                                    </div>
                                    <div class="col-sm-8">
                                        <div class="text-sm-right">
                                            <button type="button" class="btn btn-success mb-2 mr-1"><i class="mdi mdi-settings"></i>
                                            </button>
                                            <button type="button" class="btn btn-light mb-2 mr-1">Import</button>
                                            <button type="button" class="btn btn-light mb-2">Export</button>
                                        </div>
                                    </div><!-- end col-->
                                </div>

                                <div class="table-responsive">
                                    <div id="products-datatable_wrapper" class="dataTables_wrapper dt-bootstrap4 no-footer">
                                        <div class="row">
                                            <div class="col-sm-12">
                                                <table class="table table-centered w-100 dt-responsive nowrap dataTable no-footer dtr-inline"
                                                       id="products-datatable" role="grid"
                                                       aria-describedby="products-datatable_info" style="width: 1108px;">
                                                    <thead class="thead-light">
                                                    <tr role="row">
                                                        <th>Id</th>
                                                        <th>Mã</th>
                                                        <th>Tên</th>
                                                        <th></th>
                                                    </tr>
                                                    </thead>
                                                    <tbody>
                                                    <c:forEach var="item" items="${list}">
                                                        <tr role="row" class="odd">
                                                            <td>${item.id}</td>
                                                            <td>${item.ma}</td>
                                                            <td>${item.ten}</td>
                                                            <td class="table-action">
                                                                <a href="<c:url value="/mau-sac/detail?id=${item.id}"/>"
                                                                   class="action-icon"> <i
                                                                        class="mdi mdi-eye"></i></a>
                                                                <a href="<c:url value="/mau-sac/delete?id=${item.id}"/>"
                                                                   class="action-icon"> <i
                                                                        class="mdi mdi-delete"></i></a>
                                                            </td>
                                                        </tr>
                                                    </c:forEach>
                                                    </tbody>
                                                </table>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div> <!-- end card-body-->
                        </div> <!-- end card-->
                    </div> <!-- end col -->
                </div>
                <!-- end row -->
            </div>
<%--        </div>--%>
<%--        <%@include file="/layout/footer.jsp"%>--%>
<%--    </div>--%>
<%--</div>--%>
<%--&lt;%&ndash;bundle&ndash;%&gt;--%>
<%--<script src="<c:url value="/template/assets/js/vendor.min.js"/>"></script>--%>
<%--<script src="<c:url value="/template/assets/js/app.min.js"/>"></script>--%>
<%--</body>--%>
<%--</html>--%>