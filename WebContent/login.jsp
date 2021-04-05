<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="all_component/style.css">
<meta charset="ISO-8859-1">
<title>Employee Login Form</title>
<%@include file="all_component/allcss.jsp"%>
</head>
<body style="background-color: #FBD786">

	<div class="container-fluid">
		<div class="row">
			<div class="col-md-4 offset-md-4">
				<div class="card mt-5">
					<div class="card-header text-center login-test">
						<i class='fa fa-user-circle-o'></i> Employee Login Form
					</div>
					<div class="card-body">

						<form action="login" method="post">
							<div class="form-group">
								<label for="exampleInputEmail1">Email Address</label> <input
									type="email" name="email_" class="form-control"
									placeholder="Enter email">

							</div>
							<div class="form-group">
								<label for="exampleInputPassword1">Password</label> <input
									type="password" name="password_" class="form-control"
									id="exampleInputPassword1" placeholder="Password">
							</div>

							<button type="submit" class="btn btn-danger badge-pill btn-block">Submit</button>
						</form>

					</div>


				</div>


			</div>


		</div>



	</div>

</body>
</html>