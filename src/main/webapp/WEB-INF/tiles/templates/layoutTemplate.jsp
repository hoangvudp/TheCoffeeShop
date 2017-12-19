<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles"%>


<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">

<title><tiles:insertAttribute name="title" /></title>

<link rel="stylesheet" type="text/css" href="<c:url value="/css/main.css"/>">
<link rel="stylesheet" type="text/css" href="<c:url value="/css/rest.css"/>">

</head>
<body>
<div id="header">
	<h3 class="heading">CoffeeShop</h3>
	<tiles:insertAttribute name="navigation" />
</div>
<div id="content">
	<tiles:insertAttribute name="body" />
</div>
<div id="footer">
	 <tiles:insertAttribute name="footer" />
</div>

</body>
</html>
