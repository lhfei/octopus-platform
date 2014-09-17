<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>

<%
	String basePath=request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+request.getContextPath();
	request.setAttribute("basePath", basePath);
%>

<meta http-equiv="Content-Type" content="text/html;charset=UTF-8">
<link rel="stylesheet" type="text/css" href="${basePath}/resources/touch/resources/css/sencha-touch.css">
<script type="text/javascript" src="${basePath}/resources/touch/sencha-touch-all.js"></script>
