<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<div class="clearfix main_content floatleft">
	<c:url value="/resources" var="contextPath" scope="application"></c:url>
	<div class="clearfix slider">
		<ul class="pgwSlider">
			<li><img
				src="${pageContext.request.contextPath}/resources/public/images/thumbs/megamind_07.jpg"
				alt="Paris, France"
				data-description="Eiffel Tower and Champ de Mars"
				data-large-src="${pageContext.request.contextPath}/resources/public/images/slides/megamind_07.jpg" /></li>
			<li><img
				src="${pageContext.request.contextPath}/resources/public/images/thumbs/wall-e.jpg"
				alt="Montréal, QC, Canada"
				data-large-src="${pageContext.request.contextPath}/resources/public/images/slides/wall-e.jpg"
				data-description="Eiffel Tower and Champ de Mars" /></li>
			<li><img
				src="${pageContext.request.contextPath}/resources/public/images/thumbs/up-official-trailer-fake.jpg"
				alt="Shanghai, China"
				data-large-src="${pageContext.request.contextPath}/resources/public/images/slides/up-official-trailer-fake.jpg"
				data-description="Shanghai ,chaina"></li>


		</ul>
	</div>
	<div class="clearfix content">
		<div class="content_title">
			<h2>Bài viết mới</h2>
		</div>
		<c:choose>
			<c:when test="${ListLand != null}">
				<c:forEach items="${ListLand}" var="ListLand">
					<div class="clearfix single_content">
						<div class="clearfix post_date floatleft">
							<div class="date">
								<p>${ListLand.date_create}</p>
							</div>
						</div>
						<div class="clearfix post_detail">
							<h2>
								<a
									href="${pageContext.request.contextPath}/public/detail/${ListLand.lid}">${ListLand.lname}</a>
							</h2>
							<div class="clearfix post-meta">
								<p>
									<span><i class="fa fa-clock-o"></i> Địa chỉ:
										${ListLand.address}</span> <span><i class="fa fa-folder"></i>
										Diện tích: ${ListLand.area}</span>
								</p>
							</div>
							<div class="clearfix post_excerpt">
								<img src="${contextPath}/upload/${ListLand.picture}" alt="" />
								<p>${ListLand.description}</p>
							</div>
							<a
								href="${pageContext.request.contextPath}/public/detail/${ListLand.lid}">Đọc
								thêm</a>
						</div>
					</div>
				</c:forEach>
			</c:when>
			<c:otherwise>Data empty</c:otherwise>
		</c:choose>
	</div>

	<div class="pagination">
		<nav>
			<ul>
				<li><a
					href="${pageContext.request.contextPath}/public/index/${CurrentPage-1}">
						<< </a></li>
				<c:choose>
					<c:when test="${NumberOfPages != null}">
						<c:forEach var="page" begin="1" end="${NumberOfPages}">
							<c:choose>
								<c:when test="${page == CurrentPage}">
									<li><a class="bg-dark text-light" href="${pageContext.request.contextPath}/public/index/${page}">${page}</a></li>
								</c:when>
								<c:otherwise>
									<li><a class="page-link" href="${pageContext.request.contextPath}/public/index/${page}">${page}</a></li>
								</c:otherwise>
							</c:choose>
						</c:forEach>
					</c:when>
				</c:choose>
				<li><a
					href="${pageContext.request.contextPath}/public/index/${CurrentPage+1}">
						>> </a></li>
			</ul>
		</nav>
	</div>
</div>
