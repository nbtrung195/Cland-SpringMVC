<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:url value="/resources" var="contextPath"></c:url>
<div class="clearfix main_content floatleft">
	<div class="clearfix content">
		<div class="content_title">
			<h2>Có ${msg} kết quả được tìm thấy</h2>
		</div>
		<div class="clearfix single_work_container">
			<c:choose>
				<c:when test="${ListLand != null}">
					<c:forEach items="${ListLand}" var="ListLand">
						<div class="clearfix single_work">
							<img class="img_top"
								src="${contextPath}/upload/${ListLand.picture}" alt="" /> <img
								class="img_bottom"
								src="${contextPath}/upload/${ListLand.picture}" alt="" />
							<h2>${ListLand.lname}</h2>
							<a
								href="${pageContext.request.contextPath}/public/detail/${ListLand.lid}"><p class="caption">${ListLand.description}</p></a>
						</div>
					</c:forEach>
				</c:when>
				<c:otherwise>Không tìm thấy kết quả nào</c:otherwise>
			</c:choose>
		</div>
	</div>

</div>
