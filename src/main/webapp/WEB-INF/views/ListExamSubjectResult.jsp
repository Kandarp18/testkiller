<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Testkiller</title>
<jsp:include page="AllCss2.jsp"></jsp:include>

</head>

<body>
	<div id="pcoded" class="pcoded iscollapsed">
		<div class="pcoded-overlay-box"></div>
		<div class="pcoded-container navbar-wrapper">
			<jsp:include page="StudentHeader.jsp"></jsp:include>

			<div class="pcoded-main-container">
				<div class="pcoded-wrapper">

					<jsp:include page="StudentSideBar.jsp"></jsp:include>

					<div class="pcoded-content">

						<div class="page-header card">
							<div class="row align-items-end">
								<div class="col-lg-8">
									<div class="page-header-title">
										<i class="feather icon-inbox bg-c-blue"></i>
										<div class="d-inline">
											<h5>Exam Schedule Details</h5>
										</div>
									</div>
								</div>
								<div class="col-lg-4">
									<div class="page-header-breadcrumb">
										<ul class=" breadcrumb breadcrumb-title">
											<li class="breadcrumb-item"><a href="studentdashboard?studentId=${s.studentId }"><i
													class="feather icon-home"></i></a></li>
											<li class="breadcrumb-item"><a href="#!">Exams
													</a></li>
													<li class="breadcrumb-item">
													
													<a href="#!">Completed Exams
													
													
													
													</a></li>
											
										</ul>
									</div>
								</div>
							</div>
						</div>

						<div class="pcoded-inner-content">

							<div class="main-body">
								<div class="page-wrapper">

									<div class="page-body">
										<div class="row">
											<div class="col-sm-12">
												<div class="card">
													<div class="card-header">
														<h5>Completed Exams</h5>

													</div>
													<div class="card-block">
														<div class="dt-responsive table-responsive">
															<div id="order-table_wrapper"
																class="dataTables_wrapper dt-bootstrap4">
																<div class="row">
																	<div class="col-xs-12 col-sm-12">
																		<table id="listRoles" class="table table-striped" style="text-align:center;">
																			<thead>
																				<tr role="row">
																					<th>Subject Name</th>
																					<th>Exam Date</th>
																					<th>Total Question</th>
																					<th>Correct Answer</th>
																					<th>Status</th>
																					<th>Action</th>
																				</tr>
																			</thead>
																			<tbody>


																				<c:forEach items="${exam}" var="e">
																					<tr >
																						<td>${e.subjectName}</td>
																						<td>${e.examDate}</td>
																						<td >${e.totalQuestion}</td>
																						<td><b class="text-success">+${e.rightMark} Mark</b></td>
																						<td>
																						<c:if test="${e.statusId==2}">
																						<span class="badge badge-success">Started</span>
																						</c:if>
																						<c:if test="${e.statusId==3}">
																						<span class="badge badge-dark">Completed</span>
																						</c:if>
																						</td>
																					
																						<td> 
																						
																						
																						<a href="examsubjectreport?examId=${e.examId }&subjectId=${e.subjectId}&studentId=${s.studentId}" class="btn btn-warning btn-circle btn-sm edit_button">View Result</a> 		       
																						
																						</td>
																					</tr>
																				</c:forEach>



																			</tbody>

																		</table>
																	</div>
																</div>

															</div>
														</div>
													</div>


												</div>
											</div>
										</div>

									</div>
								</div>

								<div id="styleSelector"></div>
							</div>
						</div>


					</div>
					<!-- pcoded wrapper -->
				</div>
				<!-- pcoded main container -->
			</div>
			<!-- pcoded-navwrap -->
		</div>
		<!--  pcoded -->
</div>
<!-- Footer -->
            <footer class="sticky-footer bg-white">
                <div class="container my-auto">
                    <div class="copyright text-center my-auto">
                       &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <span>Copyright &copy; TestKiller 2022</span>
                    </div>
                </div>
            </footer>
            <!-- End of Footer -->
 <!-- Logout Modal-->
    <div class="modal fade" id="logoutModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel"
        aria-hidden="true">
        <div class="modal-dialog" role="document">
            <div class="modal-content">
                <div class="modal-header">
                    <h5 class="modal-title" id="exampleModalLabel">Ready to Leave?</h5>
                    <button class="close" type="button" data-dismiss="modal" aria-label="Close">
                        <span aria-hidden="true">&times;</span>
                    </button>
                </div>
                <div class="modal-body">Select "Logout" below if you are ready to end your current session.</div>
                <div class="modal-footer">
                    <button class="btn btn-secondary" type="button" data-dismiss="modal">Cancel</button>
                    <a class="btn btn-primary" href="logoutstudent">Logout</a>
                </div>
            </div>
        </div>
    </div>
<jsp:include page="AllJs2.jsp"></jsp:include>
</body>
</html>