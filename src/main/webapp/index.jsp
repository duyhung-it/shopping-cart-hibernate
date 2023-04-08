  <%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>>
<html>
<head>
  <title>Title</title>
  <link href="<c:url value="/template/assets/css/icons.min.css"/>" rel="stylesheet" type="text/css"/>
  <link href="<c:url value="/template/assets/css/app-creative.min.css"/>" rel="stylesheet" type="text/css"
        id="light-style"/>
  <%--  <link href="<c:url value="/template/assets/css/app-creative-dark.min.css"/>" rel="stylesheet" type="text/css" id="dark-style" />--%>
</head>
<body>
<%--    Menu--%>
<%@include file="/layout/menu.jsp" %>
<%--    End Menu--%>
<div class="content-page">
  <div class="content">
    <%@include file="/layout/header.jsp" %>
<%--    <jsp:include page="${view}"/>--%>
  </div>
</div>
<%@include file="/layout/footer.jsp" %>
<%--bundle--%>
<script src="<c:url value="/template/assets/js/vendor.min.js"/>"></script>
<script src="<c:url value="/template/assets/js/app.min.js"/>"></script>
</body>
</html>