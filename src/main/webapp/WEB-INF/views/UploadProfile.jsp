<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
      <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Testkiller</title>
<jsp:include page="AllCss2.jsp"></jsp:include>

</head>
<body themebg-pattern="theme1">
	<div id="pcoded" class="pcoded iscollapsed" nav-type="st2"
		theme-layout="vertical" vertical-placement="left"
		vertical-layout="wide" pcoded-device-type="desktop"
		vertical-nav-type="expanded" vertical-effect="shrink"
		vnavigation-view="view1" fream-type="theme1" layout-type="light">
		<div class="pcoded-overlay-box"></div>
		<div class="pcoded-container navbar-wrapper">



			<jsp:include page="StudentHeader.jsp"></jsp:include>


			<div class="pcoded-main-container" style="margin-top: 70.3906px;">
				<div class="pcoded-wrapper">

					<jsp:include page="StudentSideBar.jsp"></jsp:include>
								<div class="pcoded-content">
				
<!-- Begin Page Content -->
                <div class="container-fluid">
                    
                    <!-- Page Heading -->
                    <h1 class="h3 mb-4 text-gray-800"></h1>

                    <!-- DataTales Example -->
                    
                    <form method="post" action="saveprofile" enctype="multipart/form-data">
                        <div class="row">
                        <div class="col-md-6">
                        <span id="message"></span>
                        <div class="card shadow mb-4">
                            <div class="card-header py-3">
                                <div class="row">
                                    <div class="col">
                                        <h6 class="m-0 font-weight-bold text-primary">Edit Profile Photo</h6>
                                    </div>
                                    <div class="col" align="right">
                                        
                                        <button type="submit" name="edit_button" id="edit_button" class="btn btn-primary btn-sm"><i class="fas fa-edit"></i>Edit</button>
                                        &nbsp;&nbsp;
                                        
                                    </div>
                                </div>
                            </div>
                            <div class="card-body">
                            <input type="hidden" name="studentId" value="${s.studentId }">
                                <!--<div class="row">
                                    <div class="col-md-6">!-->
                      <p style="color:green;">${success }</p>
		          	  <div class="form-group">
																<label>ProfilePic</label>
																
																	<input type="file" value="${s.profilePic }" name="profilePic" required class="form-control">
																	<span class="text-muted">Only .jpg,.jpeg,.png file allowed for upload</span>
												
															</div>
		          	
                                      
                                    <!--</div>
                                </div>!-->
                            </div>
                        </div></div></div>
                    </form>
                    </div>
                <!-- /.container-fluid -->

            </div>
            <!-- End of Main Content -->
</div>
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