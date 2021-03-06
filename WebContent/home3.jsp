<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Dept Emp App</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>

<style type="text/css">
#header {
	background-color: black;
	width: 100%;
	height: 50px;
	text-align: center;
}

#sidebar-left {
	float: left;
	width: 15%;
	background-color: #83A0FF;
}

#main {
	float: left;
	width: 85%;
	background-color: lightgray;
}

#footer {
	clear: both;
	height: 50px;
	width: 100%;
	text-align: center;
	background-color: black;
}

#sidebar-left, #main {
	min-height: 600px
}

input[type=text], input[type=date] {
	border: 1px solid black;
	background-color: lightgrey;
}

/* .container {
	position: absolute;
	top: 200px;
	right: 350px;
	margin: 20px;
	max-width: 500px;
	padding: 16px;
	background-color: white;
}

.container2 {
	position: absolute;
	top: 170px;
	right: 150px;
	margin: 20px;
	max-width: 1000px;
	padding: 16px;
	background-color: white;
}

.container3 {
	position: absolute;
	top: 400px;
	right: 550px;
	margin: 20px;
	max-width: 1000px;
	padding: 16px;
}

.container4 {
	position: absolute;
	top: 420px;
	right: 350px;
	margin: 20px;
	max-width: 1000px;
	padding: 16px;
}

.container5 {
	position: absolute;
	top: 180px;
	right: 250px;
	margin: 20px;
	max-width: 1000px;
	padding: 16px;
	background-color: white;
}

.container6 {
	width: 100%;
	height: 100%;
}
 */
t {
	text-align: left;
}

.pl {
	float: right;
	text-align: right;
}

.p2 {
	float: left;
	text-align: left;
}

table.d, td {
	table-layout: fixed;
	width: 95%;
	height: 80px;
	padding: 16px;
}

table.c, td {
	table-layout: auto;
	width: 95%;
	height: 50px;
	
}

/* .pos_right {
  position: relative;
  top:15px;
  right: 600px;
 
}

.pos_left
{
position: relative;
  top:-18px;
  left: 600px;
}
 */

.pos_right{
float: left;
    padding: 15px;
    background-color: green;
   
    margin-left: 25px;

}

.pos_left{
float: right;
    padding: 15px;
    background-color: green;
    margin-right: 25px;
}

</style>
</head>
<body>
	<%
		if (session.getAttribute("unam") == null) {
			response.sendRedirect("login.jsp");
		}
	%>
	<div class="container6">
		<div id="header">
			<div class="pos_right">
				<a href="homeserv" ><font color="white">Home</font></a>
			</div>
			<font color="white">Dept Emp App</font>
			<div class="pos_left">
				<a href="logout"><font color="white">Logout</font></a>
			</div>
		</div>
		<div id="sidebar-left">

			<form action="home">
				<br> &nbsp <input type="submit" value="+"> Department
			</form>

			<c:if test="${hom eq 'homep'}">
				<c:forEach var="dept" items="${lis}">
					<c:if test="${not empty dept}">

						<input type="hidden" name="deptId" value="${dept.deptId}">

						<br>
				&nbsp <a href="homeserv"><b>=></b></a>&nbsp <button type="button"
							class="btn btn-success" style="width:100px;">
							<a href="listEmp?deptId=${dept.deptId}"><font color="white">${dept.deptName}
							</font></a>
						</button>
						<br>

					</c:if>
				</c:forEach>

			</c:if>

		</div>

		<div id="main">


			<c:if test="${hoser eq 'hseval'}">

				
				<br>
				<br>
				<div align="center">
					<c:if test="${deptva != 0}">
						<form action="updatedept" method="post">
					</c:if>
					<c:if test="${deptva == 0}">
						<form action="savedept" method="post">
					</c:if>



					<table class="d" border="1px solid black" align="center">

						<tr>
							<th colspan="2.5" style="text-align: center"><font
								color="green">Department Table</font></th>
							<th colspan="3" style="text-align: center"><a href="regDept">Add
									new department</a></th>


						</tr>

						<tr>

							<th style="text-align: center"><font color="#EE8742">Dept
									Id</font></th>
							<th style="text-align: center"><font color="#EE8742">Dept
									Name</font></th>
							<th style="text-align: center"><font color="#EE8742">Dept
									Location</font></th>
							<th style="text-align: center"><font color="#EE8742">Edit</font></th>
							<th style="text-align: center"><font color="#EE8742">Delete</font></th>

						</tr>

						<c:forEach items="${deptlv}" var="dval">
							<c:if test="${deptva eq dval.deptId}">

								<tr>
									<td><input type="" name="deptId" value="${dval.deptId}"
										disabled style="background-color: lightgrey;" /></td>
									<td><input type="text" name="deptName"
										value="${dval.deptName}"></td>
									<td><input type="text" name="deptLoc"
										value="${dval.deptLoc}"></td>
									<td>
											<button type="submit" class="btn btn-primary">update
												</button>
										</td><td><button type="button" class="btn btn-warning"><a href="homeserv">Cancel</a>
												</button></td>
								</tr>
							</c:if>
							<c:if test="${deptva ne dval.deptId}">
								<tr>
									<td style="vertical-align: top">${dval.deptId}</td>
									<td style="vertical-align: top">${dval.deptName}</td>
									<td style="vertical-align: top">${dval.deptLoc}</td>
									<td style="vertical-align: top"><a
										href="editdepartment?depId=${dval.deptId}">Edit</a></td>
									<td style="vertical-align: top"><a
										href="deledept?deptId=${dval.deptId}">Delete</a></td>
								</tr>
							</c:if>
						</c:forEach>
						<c:if test="${adddept eq 'regdept'}">

							<tr>
								<td><input type="hidden" name="deptId" /></td>
								<td><input type="text" name="deptName"
									placeholder="Enter DeptName" required /></td>
								<td><input type="text" name="deptLoc"
									placeholder="Enter DeptLoc" required /></td>
								<td >


										
											<button type="submit" class="btn btn-info">save</button>
										

									</td><td><button type="button" class="btn btn-warning"><a href="homeserv">cancel</a></button></td>
							</tr>
						</c:if>
					</table>
					</form>

				</div>

				
			</c:if>
			<c:if test="${hom eq 'homep'}">

				<br>
				<div align="center">
				<c:if test="${empty val}">
					<c:if test="${newtab eq 'ntabl'}">
						<form action="saveemployee" method="post">
							<table class="c" border="1px solid black" >

								<tr>
									<th colspan="5" style="text-align: center"><font color="green">Employee Table</font></b>
										</th>
									<th colspan="5" style="text-align: center"><a
										href="addemployee">Add new Employee</a></th>


								</tr>

								<tr >
									<th style="text-align:center;"><font color="#AB2F9A">EmpId</font></th>
									<th style="text-align:center;"><font color="#AB2F9A">Emp Name</font></th>
									<th style="text-align:center;"><font color="#AB2F9A">DateOfBirth</font></th>
									<th style="text-align:center;"><font color="#AB2F9A">Mail Id</font></th>
									<th style="text-align:center;"><font color="#AB2F9A">DeptName</font></th>
									<th style="text-align:center;"><font color="#AB2F9A">Mobile Number</font></th>
									<th style="text-align:center;"><font color="#AB2F9A">Salary</font></th>
									<th style="text-align:center;"><font color="#AB2F9A">Company Name</font></th>
									<th style="text-align:center;"><font color="#AB2F9A">Edit</font></th>
									<th style="text-align:center;"><font color="#AB2F9A">Delete</font></th>
								</tr>
								<tr>
									<td><input type="hidden" name="empId" size="3" /></td>



									<td><input type="text" name="empName" size="9" required></td>



									<td><input type="date" name="dob" size="5" required></td>
									<td><input type="text" name="mailId" size="16" required></td>
									<td><select name="deptEmpNa" required>
											

											<c:forEach items="${lis}" var="depnt">

												<option>${depnt.deptName}</option>


											</c:forEach>
									</select></td>
									<td><input type="text" name="mobileNo" size="5" required></td>
									<td><input type="text" name="salary" size="5" required></td>

									<td><input type="text" name="companyName" size="5" required></td>

									<td><div align="center">
											<button type="submit" class="btn btn-info">Save</button>
										</div></td><td><button type="submit" class="btn btn-warning"><a href="listEmp?deptId=${depId}">Back</a></button></td>
								</tr>


							</table>
						</form>


					</c:if>

					<c:if test="${newtab ne 'ntabl'}">
						<div align="center">


							<h4>
								No Employee Table Associated with This Department Kindly <a
									href="addemployee?empId=0">Add Employee</a> to this.
							</h4>
						</div>
					</c:if>
				</c:if></div>
				
				
				
				
			<div align="center">
				<c:if test="${not empty val }">

					<c:if test="${empl != 0}">
           <form action="updateemployee" method="post">
					</c:if>
					<c:if test="${empl == 0}">
						<form action="saveemployee" method="post">
					</c:if>

					


						<table class="c" border="1px solid black">

							<tr>
								<th colspan="5" style="text-align: center"><font
									color="green">Employee Table</font></th>
								<th colspan="5" style="text-align: center"><a
									href="addemployee">Add new Employee</a></th>


							</tr>
							<tr>
								<th style="vertical-align: top;text-align: center ; "><font color="#AB2F9A">EmpId</font></th>
								<th style="vertical-align: top;text-align: center ;"><font color="#AB2F9A">Emp Name</font></th>
								<th style="vertical-align: top;text-align: center ;" ><font color="#AB2F9A">Date Of Birth</font></th>
								<th style="vertical-align: top;text-align: center ;"><font color="#AB2F9A">Mail Id</font></th>
								<th style="vertical-align: top;text-align: center ;"><font color="#AB2F9A">Dept Name</font></th>
								<th style="vertical-align: top;text-align: center ; "><font color="#AB2F9A">Mobile Number</font></th>
								<th style="vertical-align: top;text-align: center ;"><font color="#AB2F9A">Salary</font></th>
								<th style="vertical-align: top;text-align: center ;"><font color="#AB2F9A">Company Name</font></th>
								<th style="vertical-align: top;text-align: center ; "><font color="#AB2F9A">Edit</font></th>
								<th style="vertical-align: top;text-align: center ; "><font color="#AB2F9A">Delete</font></th>
							</tr>
							<c:forEach var="emp" items="${val}">
								<c:if test="${mainemps eq 'checktableedit'}">
									<c:if test="${empl eq emp.empId}">
										<tr>
											<td style="width:70px;"><input type=""
												name="empId" value="${emp.empId}" size="3" disabled style="background-color: lightgrey;"/></td>

											<td style="width:350px;"><input type="text"
												name="empName" value="${emp.empName}" size="10"></td>

											<td style="width:300px;"><input type="date" name="dob"
												value="${emp.dateOfBirth}" maxlength="4"></td>
											<td style="width:250px;"><input type="" name="mailId"
												value="${emp.mailId}" size="19" readonly style="background-color: lightgrey;"></td>
											<td style="width:290px;"><select name="deptEmpName" style="max-width: 100%;">
													<option>${deptName}</option>

													<c:forEach items="${lis}" var="depnt">
														<c:if test="${deptName ne depnt.deptName}">
														<option>${depnt.deptName}</option></c:if>


													</c:forEach>
											</select></td>
											<td style="width:280px;"><input type="text" name="mobileNo"
												value="${emp.mobileNo}" size="6"></td>
											<td style="width:280px;"><input type="text" name="salary"
												value="${emp.salary}" size="6"></td>

											<td style="width:250px;"><input type="text" name="companyName"
												value="${emp.companyName}" size="6"></td>

											<td style="width:70px;">
											<button type="submit" class="btn btn-primary" style="width:60px;">Update </button>
										</td><td style="width:70px;"><button type="submit" class = "btn btn-warning" style="width:50px;"><a href="listEmp?deptId=${emp.department.deptId}">Back</a></button></td>


										</tr>

									</c:if>
								</c:if>

								<c:if test="${empl ne emp.empId}">
									<tr>
										<td style="text-align: center ;width:100px;">${emp.empId}</td>
										<td style="width:300px;">${emp.empName}</td>
										<td style="width:900px;">${emp.dateOfBirth}</td>
										<td style="width:500px;">${emp.mailId}</td>
										<c:forEach items="${lis}" var="dtn">
											<c:if test="${emp.department.deptId eq dtn.deptId}">
												<td style="width:500px;">${dtn.deptName}</td>
											</c:if>
										</c:forEach>
										<td style="width:500px;">${emp.mobileNo}</td>
										<td style="width:500px;">${emp.salary}</td>
										<td style="width:500px;"> ${emp.companyName}</td>


										<td style="width:500px;"><a
											href="editemployee?empId=${emp.empId}&deptId=${emp.department.deptId}">Edit</a></td>
										<td style="width:500px;"><a
											href="deleteemployee?empId=${emp.empId}&deptEmpId=${emp.department.deptId}">Delete</a></td>
									</tr>
								</c:if>
							</c:forEach>
							<c:if test="${valcheck eq 'regemployee'}">
								<tr>
									<td><input type="hidden" name="empId" size="3" /></td>



									<td><input type="text" name="empName" size="9" required></td>



									<td><input type="date" name="dob" size="5" required></td>
									<td><input type="text" name="mailId" size="16" required></td>
									<td><select name="deptEmpNa" required>
											

											<c:forEach items="${lis}" var="depnt">

												<option>${depnt.deptName}</option>


											</c:forEach>
									</select></td>
									<td><input type="text" name="mobileNo" size="5" required></td>
									<td><input type="text" name="salary" size="5" required></td>

									<td><input type="text" name="companyName" size="5" required></td>

									<td><div align="center">
											<button type="submit" class="btn btn-info">Save</button>
										</div></td><td><button type="submit" class="btn btn-warning"><a href="listEmp?deptId=${depId}">Back</a></button></td>
								</tr>
							</c:if>


						</table>
					</div>

					</form>

</c:if>
				</c:if>
				
			
			
			</div>






			<c:if test="${not empty deleteDoneDept}">
				<script>
					alert("Department deleted");
				</script>
				<c:remove var="deleteDoneDept" scope="session" />
			</c:if>
			<c:if test="${not empty EditDept}">
				<script>
					alert("Department Details Updated");
				</script>
				<c:remove var="EditDept" scope="session" />
			</c:if>

			<c:if test="${not empty submitDoneEmp}">
				<script>
					alert("Employee Added");
				</script>
				<c:remove var="submitDoneEmp" scope="session" />
			</c:if>

			<c:if test="${not empty submitDoneDept}">
				<script>
					alert("Department Added");
				</script>
				<c:remove var="submitDoneDept" scope="session" />
			</c:if>

			<c:if test="${not empty deleteDone}">
				<script>
					alert("Employee deleted");
				</script>
				<c:remove var="deleteDone" scope="session" />
			</c:if>
			<c:if test="${not empty submitDone}">
				<script>
					alert("Employee Details Updated");
				</script>
				<c:remove var="submitDone" scope="session" />
			</c:if>


		</div>


		<div id="footer">Department Employee Application :)</div>
	</div>
</body>
</html>