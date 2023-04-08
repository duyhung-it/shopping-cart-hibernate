<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Nguyen Duy Hung
  Date: 3/12/2023
  Time: 11:10 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<html>
<head>
    <title>Title</title>
    <link href="<c:url value="/template/assets/css/icons.min.css"/>" rel="stylesheet" type="text/css"/>
    <link href="<c:url value="/template/assets/css/app-creative.min.css"/>" rel="stylesheet" type="text/css"
          id="light-style"/>
    <link href="<c:url value="/template/assets/css/style.css"/>" rel="stylesheet" type="text/css"/>

<%--  <link href="<c:url value="/template/assets/css/app-creative-dark.min.css"/>" rel="stylesheet" type="text/css" id="dark-style" />--%>
</head>
<body data-layout="topnav">
    <div class="">
        <div class="content-page">
            <div class="content">
                <%@include file="/layout/customer/header.jsp" %>
                <jsp:include page="${view}"/>
            </div>
        </div>
        <%@include file="/layout/customer/footer.jsp" %>
    </div>
<%--bundle--%>
<script src="<c:url value="/template/assets/js/vendor.min.js"/>"></script>
<script src="<c:url value="/template/assets/js/app.min.js"/>"></script>
</body>
</html>