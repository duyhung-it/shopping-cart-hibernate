<%--
  Created by IntelliJ IDEA.
  User: Nguyen Duy Hung
  Date: 3/12/2023
  Time: 10:03 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<div class="left-side-menu">
    <!-- LOGO -->
    <a href="<c:url value="/trang-chu/hien-thi"/>" class="logo text-center logo-light p-3">
                    <span class="logo-lg">
                        <img src="<c:url value="/template/assets/images/logo.png"/>" alt="" height="16">
                    </span>
        <span class="logo-sm">
                        <img src="<c:url value="/template/assets/images/logo_sm.png"/>" alt="" height="16">
                    </span>
    </a>
    <div class="h-100 mm-active" id="left-side-menu-container" data-simplebar="init">
        <div class="simplebar-wrapper" style="margin: 0;">
            <div class="simplebar-height-auto-observer-wrapper">
                <div class="simplebar-height-auto-observer"></div>
            </div>
            <div class="simplebar-mask">
                <div class="simplebar-offset" style="right: 0; bottom: 0;">
                    <div class="simplebar-content-wrapper" style="height: 100%; overflow: hidden;">
                        <div class="simplebar-content" style="padding: 0;">

                            <!--- Sidemenu -->
                            <ul class="metismenu side-nav mm-show">

                                <li class="side-nav-title side-nav-item">Navigation</li>

                                <li class="side-nav-item">
                                    <a href="<c:url value="/chuc-vu/hien-thi"/>" class="side-nav-link">
                                        <i class="uil-annoyed-alt"></i>
                                        <span> Chức Vụ </span>
                                    </a>
                                </li>
                                <li class="side-nav-item">
                                    <a href="<c:url value="/cua-hang/hien-thi"/>" class="side-nav-link">
                                        <i class="uil-store-alt"></i>
                                        <span> Cửa Hàng </span>
                                    </a>
                                </li>
                                <li class="side-nav-item">
                                    <a href="<c:url value="/nhan-vien/hien-thi"/>" class="side-nav-link">
                                        <i class="uil-users-alt"></i>
                                        <span> Nhân Viên </span>
                                    </a>
                                </li>
                                <li class="side-nav-item">
                                    <a href="<c:url value="/khach-hang/hien-thi"/>" class="side-nav-link">
                                        <i class="uil-users-alt"></i>
                                        <span> Khách Hàng </span>
                                    </a>
                                </li>
                                <li class="side-nav-item">
                                    <a href="<c:url value="/mau-sac/hien-thi"/>" class="side-nav-link">
                                        <i class="uil-users-alt"></i>
                                        <span> Màu Sắc </span>
                                    </a>
                                </li>
                                <li class="side-nav-item">
                                    <a href="<c:url value="/san-pham/hien-thi"/>" class="side-nav-link">
                                        <i class="uil-users-alt"></i>
                                        <span> Sản Phẩm </span>
                                    </a>
                                </li>
                                <li class="side-nav-item">
                                    <a href="<c:url value="/nha-san-xuat/hien-thi"/>" class="side-nav-link">
                                        <i class="uil-processor"></i>
                                        <span> Nhà Sản Xuất </span>
                                    </a>
                                </li>
                                <li class="side-nav-item">
                                    <a href="<c:url value="/dong-san-pham/hien-thi"/>" class="side-nav-link">
                                        <i class="uil-apple"></i>
                                        <span> Dòng Sản Phẩm </span>
                                    </a>
                                </li>
                                <li class="side-nav-item">
                                    <a href="<c:url value="/chi-tiet-san-pham/hien-thi"/>" class="side-nav-link">
                                        <i class="uil-users-alt"></i>
                                        <span> Chi tiết sản phẩm </span>
                                    </a>
                                </li>
                                <li class="side-nav-title side-nav-item">Apps</li>
                            </ul>
                            <!-- End Sidebar -->

                            <div class="clearfix"></div>

                        </div>
                    </div>
                </div>
            </div>
            <div class="simplebar-placeholder" style="width: auto; height: 72px;"></div>
        </div>
        <div class="simplebar-track simplebar-horizontal" style="visibility: hidden;">
            <div class="simplebar-scrollbar" style="width: 0; display: none;"></div>
        </div>
        <div class="simplebar-track simplebar-vertical" style="visibility: hidden;">
            <div class="simplebar-scrollbar"
                 style="height: 0; transform: translate3d(0px, 0px, 0px); display: none;"></div>
        </div>
    </div>
    <!-- Sidebar -left -->

</div>