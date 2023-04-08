<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<div class="content">
  <div class="navbar-custom topnav-navbar topnav-navbar-dark">
    <div class="container-fluid">
      <!-- LOGO -->
      <a href="<c:url value="/trang-chu/hien-thi"/>" class="topnav-logo d-flex flex-row p-3">
        <span class="topnav-logo-lg">
          <img
            src="<c:url value="/template/assets/images/logo.png"/>"
            alt=""
            height="32"
          />
        </span>
        <span class="topnav-logo-sm">
          <img src="<c:url value="/template/assets/images/logo_sm.png"/>" alt="" height="16" />
        </span>
      </a>

      <ul class="list-unstyled topbar-right-menu float-right mb-0">
        <li class="notification-list d-lg-none">
          <a
            class="nav-link d-flex flex-row p-3"
            href="#"
            role="button"
            data-toggle="dropdown"
            aria-haspopup="false"
            aria-expanded="false"
          >
            <i class="dripicons-search noti-icon"></i>
          </a>
          <div class="dropdown-menu dropdown-menu-animated dropdown-lg p-0">
            <form class="p-3">
              <input
                type="text"
                class="form-control"
                placeholder="Search ..."
                aria-label="Recipient's username"
              />
            </form>
          </div>
        </li>
        <li class="notification-list d-flex flex-row p-3">
          <a
            class="nav-link"
            href="<c:url value="/gio-hang/hien-thi"/>"
            aria-haspopup="false"
            aria-expanded="false"
          >
            <i class="dripicons-cart noti-icon"></i>
          </a>
        </li>


        <li ng-show="user == undefined" class="notification-list d-flex flex-row p-3">
          <a
            class="nav-link"
            href="#login"
            aria-haspopup="false"
            aria-expanded="false"
          >
             <i>Đăng nhập</i>
          </a>
          <a
          class="nav-link"
          href="#sign-up"
          aria-haspopup="false"
          aria-expanded="false"
        >
           <i>Đăng ký</i>
        </a>
        </li>
      </li>
      </ul>
      <a
        class="navbar-toggle "
        data-toggle="collapse"
        data-target="#topnav-menu-content"
      >
        <div class="lines">
          <span></span>
          <span></span>
          <span></span>
        </div>
      </a>
      <div class="app-search dropdown">
        <form>
          <div class="input-group">
            <input
              type="text"
              class="form-control"
              placeholder="Search..."
              id="top-search"
            />
            <span class="mdi mdi-magnify search-icon"></span>
            <div class="input-group-append">
              <button class="btn btn-primary" type="submit">Search</button>
            </div>
          </div>
        </form>
      </div>
    </div>
  </div>
  <!-- end top bar -->
  <div class="topnav shadow-sm">
    <div class="container-fluid active">
      <nav class="navbar navbar-light navbar-expand-lg topnav-menu">
        <div class="collapse navbar-collapse active" id="topnav-menu-content">
          <ul class="navbar-nav">
            <li class="nav-item active">
              <a
                class="nav-link"
                href="#home"
                aria-haspopup="true"
                aria-expanded="false"
              >
                <i class="uil-dashboard mr-1"></i>Trang chủ
                <!-- <div class="arrow-down"></div> -->
              </a>
            </li>
            <li class="nav-item">
              <a
                class="nav-link"
                href="<c:url value="/"/>"
                aria-haspopup="true"
                aria-expanded="false"
              >
                <i class="uil-apps mr-1"></i>Sản phẩm
                <!-- <div class="arrow-down"></div> -->
              </a>
            </li>           
            <li class="nav-item">
              <a
                class="nav-link"
                href="#contact"
                aria-haspopup="true"
                aria-expanded="false"
              >
                <i class="uil-window mr-1"></i>Liên hệ
                <!-- <div class="arrow-down"></div> -->
              </a>
            </li>
            <li class="nav-item">
              <a
                class="nav-link"
                href="#events"
                aria-haspopup="true"
                aria-expanded="false"
              >
                <i class="uil-window mr-1"></i>Sự kiện
                <!-- <div class="arrow-down"></div> -->
              </a>
            </li>
            <li class="nav-item">
              <a
                class="nav-link"
                href="#about"
                aria-haspopup="true"
                aria-expanded="false"
              >
                <i class="uil-window mr-1"></i>Giới thiệu
                <!-- <div class="arrow-down"></div> -->
              </a>
            </li>
          </ul>
        </div>
      </nav>
    </div>
  </div>
</div>

