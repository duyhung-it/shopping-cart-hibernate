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
                <h4 class="page-title">Dòng Sản Phẩm</h4>
            </div>
        </div>
    </div>
    <!-- end page title -->
    <div class="row">
        <div class="col-12">
            <div class="card">
                <div class="card-body">
                    <form action="<c:url value="/dong-san-pham/${action}"/>" method="post">
                        <div class="mb-3 row">
                            <label for="inputMa" class="col-sm-2 col-form-label">Ma</label>
                            <div class="col-sm-10">
                                <input type="text" class="form-control" id="inputMa" name="ma" value="${dongSanPham.ma}">
                            </div>
                        </div>
                        <div class="mb-3 row">
                            <label  class="col-sm-2 col-form-label">Ten</label>
                            <div class="col-sm-10">
                                <input type="text" class="form-control" name="ten" value="${dongSanPham.ten}">
                            </div>
                        </div>
                        <input type="text" class="form-control d-none" name="id" value="${dongSanPham.id}">
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
