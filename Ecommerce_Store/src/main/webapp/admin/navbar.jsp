<%@page import="com.entity.Category"%>
<%@page import="java.util.List"%>
<%@page import="com.dao.CategoryDao"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page isELIgnored="false"%>
<style>
      /* foot */
      .foot {
        background-color: #333;
        color: #fff;
        font-size: 14px;
        padding: 10px;
        border-top: 2px solid #fff;
      }

      /* lowbar */
      .lowbar {
        background-color: #eee;
        color: #333;
        font-size: 16px;
        padding: 8px;
        border-top: 2px solid #ddd;
      }

      /* navhigh */
      .navhigh {
        background-color: #6699cc;
        color: #fff;
        font-size: 18px;
        padding: 12px;
        border-bottom: 2px solid #fff;
      }

      /* high */
      .high {
        background-color: #ff6666;
        color: #fff;
        font-size: 22px;
        padding: 14px;
        border: 2px solid #fff;
      }

      /* low */
      .low {
        background-color: #f5f5f5;
        color: #333;
        font-size: 16px;
        padding: 10px;
        border: 1px solid #ddd;
      }

      /* blank */
      .blank {
        background-color: transparent;
        color: #333;
        font-size: 16px;
        padding: 10px;
        border: none;
      }

      /* mid */
      .mid {
        background-color: #ddd;
        color: #333;
        font-size: 18px;
        padding: 12px;
        border: 1px solid #bbb;
        margin-top: 20px;
        margin-bottom: 20px;
      }
    </style>
<nav class="navbar navbar-expand-lg navbar-dark bg-primary fixed-top">
	<div class="container-fluid">
		<a class="navbar-brand" href="index.jsp"><i
			class="fa-solid fa-cart-shopping"></i>MAPSCLOTHS</a>
		<button class="navbar-toggler" type="button" data-bs-toggle="collapse"
			data-bs-target="#navbarSupportedContent"
			aria-controls="navbarSupportedContent" aria-expanded="false"
			aria-label="Toggle navigation">
			<span class="navbar-toggler-icon"></span>
		</button>
		<div class="collapse navbar-collapse" id="navbarSupportedContent">

			<ul class="navbar-nav me-auto mb-2 mb-lg-0">
				<c:if test="${not empty adminObj }">
					<li class="nav-item"><a class="nav-link active"
						aria-current="page" href="index.jsp"><i class="fas fa-home"></i>
							HOME</a></li>
				</c:if>
			</ul>

			<ul class="navbar-nav ms-auto mb-2 mb-lg-0">

				<c:if test="${not empty adminObj }">

					<li class="nav-item dropdown"><a
						class="nav-link active dropdown-toggle" href="#"
						id="navbarDropdownMenuLink" role="button"
						data-bs-toggle="dropdown" aria-expanded="false"><i
							class="fas fa-user-circle"></i> ${adminObj.fullName } </a>
						<ul class="dropdown-menu" aria-labelledby="navbarDropdownMenuLink">

							<li><a class="dropdown-item" href="alogout">Logout</a></li>

						</ul></li>
				</c:if>


			</ul>
		</div>
	</div>
</nav>