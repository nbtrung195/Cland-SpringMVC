<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<!-- header -->
<!DOCTYPE html>
<html>
  <head>
    <title>Bootstrap Admin Theme v3</title>
    <link rel="shortcut icon" type="image/ico" href="${pageContext.request.contextPath}/resources/admin/images/icon-180x180.png" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <!-- Bootstrap -->
    <link href="${pageContext.request.contextPath}/resources/admin/bootstrap/css/bootstrap.min.css" rel="stylesheet">
    <!-- styles -->
    <link href="${pageContext.request.contextPath}/resources/admin/css/style1.css" rel="stylesheet">
    <link href="//cdn.datatables.net/1.11.3/css/jquery.dataTables.min.css">
	 <!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
    <script src="https://code.jquery.com/jquery.js"></script>
     <!-- Include all compiled plugins (below), or include individual files as needed -->
    <script src="${pageContext.request.contextPath}/resources/admin/bootstrap/js/bootstrap.min.js"></script>
    <script src="${pageContext.request.contextPath}/resources/admin/js/custom.js"></script>
    <script type="text/javascript" src="https://cdn.datatables.net/1.11.3/js/jquery.dataTables.min.js"></script>
	<script type="text/javascript" src="https://cdn.datatables.net/1.11.3/js/dataTables.bootstrap4.min.js"></script>
    <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
      <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
      <script src="https://oss.maxcdn.com/libs/respond.js/1.3.0/respond.min.js"></script>
    <![endif]-->
  </head>
  <body>
  	<tiles:insertAttribute name="header"></tiles:insertAttribute>
<!-- /.header -->
    <div class="page-content">
    	<div class="row">
		  <div class="col-md-2">
		  	<tiles:insertAttribute name="sidebar"></tiles:insertAttribute>
		  </div>
		  <tiles:insertAttribute name="body"></tiles:insertAttribute>
		</div><!-- /.row -->
    </div><!-- /.page-content -->

    <!-- Footer -->
     <tiles:insertAttribute name="footer"></tiles:insertAttribute>
    
  </body>
</html>
    <!-- /.footer -->