<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Home</title>
<%@include file="../component/css.jsp"%>
</head>
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
<body>
	<c:if test="${empty adminObj }">
		<c:redirect url="../login.jsp"></c:redirect>
	</c:if>
	<%@include file="navbar.jsp"%>
	<div class="container">

		<div class="row p-5 mt-5">
			<h3 class="text-center mb-5">Admin Dashboard</h3>
			<div class="col-md-4 ">
				<a href="add_product.jsp" class="text-decoration-none">
					<div class="card card-sh">
						<div class="card-body text-center">
							<i class="fas fa-plus-square fa-3x text-primary"></i><br>
							<h4>Add Product</h4>
							-----------
						</div>
					</div>
				</a>
			</div>
			<div class="col-md-4">
				<a href="category.jsp" class="text-decoration-none">
					<div class="card card-sh">
						<div class="card-body text-center">
							<i class="fas fa-sign-out-alt fa-3x text-primary"></i><br>
							<h4>Category</h4>
							-----------
						</div>
					</div>
				</a>
			</div>

			<div class="col-md-4">
				<a href="view_product.jsp" class="text-decoration-none">
					<div class="card card-sh">
						<div class="card-body text-center">
							<i class="fas fa-book-open fa-3x text-danger"></i></i><br>
							<h4>View Product</h4>
							-----------
						</div>
					</div>
				</a>
			</div>


			<div class="col-md-4 mt-3">
				<a href="orders.jsp" class="text-decoration-none">
					<div class="card card-sh">
						<div class="card-body text-center">
							<i class="fas fa-box-open fa-3x text-warning"></i><br>
							<h4>Orders</h4>
							-----------
						</div>
					</div>
				</a>
			</div>

			<div class="col-md-4 mt-3">
				<a href="alogout" class="text-decoration-none">
					<div class="card card-sh">
						<div class="card-body text-center">
							<i class="fas fa-sign-out-alt fa-3x text-primary"></i><br>
							<h4>Logout</h4>
							-----------
						</div>
					</div>
				</a>
			</div>
		</div>

	</div>
</body>
</html>