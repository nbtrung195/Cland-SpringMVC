<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" lang="en">
	<head>
		<title>CLand | VinaEnter Edu</title>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
		<meta name="viewport" content="width=device-width, initial-scale=1.0">
		<!--Oswald Font -->
		<link href='http://fonts.googleapis.com/css?family=Oswald:400,300,700' rel='stylesheet' type='text/css'>
		<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/public/css/tooltipster.css" />
		<!-- home slider-->
		<link href="${pageContext.request.contextPath}/resources/public/css/pgwslider.css" rel="stylesheet">
		<!-- Font Awesome -->
		<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/public/css/font-awesome.min.css">
		<link href="${pageContext.request.contextPath}/resources/public/style.css" rel="stylesheet" media="screen">	
		<link href="${pageContext.request.contextPath}/resources/public/responsive.css" rel="stylesheet" media="screen">		
	</head>

	<body>
	
		<tiles:insertAttribute name="header"></tiles:insertAttribute>
		
		<section id="content_area">
			<div class="clearfix wrapper main_content_area">
			
				<tiles:insertAttribute name="body"></tiles:insertAttribute>
				<tiles:insertAttribute name="sidebar"></tiles:insertAttribute>
				</div>
			</div>
		</section>
		<tiles:insertAttribute name="footer"></tiles:insertAttribute>
		
		<script type="text/javascript" src="http://code.jquery.com/jquery-1.7.0.min.js"></script>	
		<script type="text/javascript" src="${pageContext.request.contextPath}/resources/public/js/jquery.tooltipster.min.js"></script>		
		<script type="text/javascript">
			$(document).ready(function() {
				$('.tooltip').tooltipster();
			});
		</script>
		 <script type="text/javascript" src="${pageContext.request.contextPath}/resources/public/js/selectnav.min.js"></script>
		<script type="text/javascript">
			selectnav('nav', {
			  label: '-Navigation-',
			  nested: true,
			  indent: '-'
			});
		</script>		
		<script src="${pageContext.request.contextPath}/resources/public/js/pgwslider.js"></script>
		<script type="text/javascript">
			$(document).ready(function() {
				$('.pgwSlider').pgwSlider({
					
					intervalDuration: 5000
				
				});
			});
		</script>
		<script type="text/javascript" src="${pageContext.request.contextPath}/resources/public/js/placeholder_support_IE.js"></script>
	</body>
</html>

		
