<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:url value="/resources" var="resources"></c:url>
<div class="clearfix main_content floatleft">
	<div class="clearfix content">

		<h1>${land.lname}</h1>
		<div class="clearfix post-meta">
			<p>
				<span><i class="fa fa-clock-o"></i> Địa chỉ: ${land.address}</span>
				<span><i class="fa fa-folder"></i> Diện tích: ${land.area}m2</span>
			</p>
		</div>

		<div class="vnecontent">
			<p>${land.detail}</p>
		</div>

	</div>

	<div class="more_themes">
		<h2>
			Bất động sản liên quan <i class="fa fa-thumbs-o-up"></i>
		</h2>
		<div class="more_themes_container">
			<c:choose>
				<c:when test="${relative != null}">
					<c:forEach items="${relative}" var="relative">
						<div class="single_more_themes floatleft">
							<img src="${resources}/upload/${relative.picture}"
								alt="" /> <a href=""><h2>${relative.lname}</h2></a>
						</div>
					</c:forEach>
				</c:when>
				<c:otherwise></c:otherwise>
			</c:choose>
		</div>
	</div>

</div>
