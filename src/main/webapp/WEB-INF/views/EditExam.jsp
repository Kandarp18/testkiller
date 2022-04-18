<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
        <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Testkiller</title>
<jsp:include page="AllCss.jsp"></jsp:include>
</head>
<body>
 <div id="wrapper">
<jsp:include page="AdminSideBar.jsp"></jsp:include>&nbsp;&nbsp;&nbsp;&nbsp;
               <!-- Content Wrapper -->
        <div id="content-wrapper" class="d-flex flex-column">

            <!-- Main Content -->
            <div id="content">


                   <jsp:include page="AdminHeader.jsp"></jsp:include>
 <form method="post" action="updateexam">
                        <div class="row"><div class="col-md-6"><span id="message"></span><div class="card shadow mb-4">
                            <div class="card-header py-3">
                                <div class="row">
                                    <div class="col">
                                        <h6 class="m-0 font-weight-bold text-primary">Edit Data</h6>
                                    </div>
                                  
                                </div>
                            </div>
                                   <div class="modal-body">
      
       
        			<span id="form_message">
        			        <p style="color:red;">  ${error }</p>
        			</span>
        			<input type="hidden" name="examId" value="${exam.examId }" />
		          	<div class="form-group">
		          		<label>Exam Name</label>
		          		<input type="text" name="examName" value="${exam.examName }"  class="form-control" />
		          	</div>
		          	 <div class="form-group">
                        <label>Class Name</label>
                        <select name="classId" class="form-control" readonly required>
                         <option value="${exam.classId }">${exam.className }</option>
                      </select>
                    </div>
                    <div class="form-group">
                        <label>Exam Duration for Each Subject <span class="text-danger">*</span></label>
                        <select name="duration" id="duration" class="form-control" required data-parsley-id="9">
                <option value="${exam.duration }">${exam.duration } Minute</option>
                           
                            <option value="">Select</option>
                            <option value="5">5 Minute</option>
                            <option value="10">10 Minute</option>
                              <option value="15">15 Minute</option>
                             <option value="20">20 Minute</option>
                              <option value="30">30 Minute</option>
                            <option value="60">60 Minute</option>
                            <option value="90">90 Minute</option>
                            <option value="120">120 Minute</option>
                        </select>
                    </div>
                   
		          	<div class="form-group" id="ifedit">
		          	<label>Exam Status <span class="text-danger">*</span></label>
		          	<select name="statusId" id="statusId" class="form-control">
		          	<option value="1">Pending</option>
		          	<option value="2">Created</option>
		          	</select>
		          	<span class="text-muted"><small>If you have select Created status, then Student will able to view Exam details in their dashboard &amp; you will not able to edit or delete this exam data.</small>
		          	</span>
		          	</div>
		         
        		</div>
      
      <div class="modal-footer">
        <input type="submit" name="submit" id="submit" class="btn btn-success" value="Edit" />
       <a href="exam"> <button type="button" class="btn btn-default">Close</button></a>
      </div>
    </div>
     </div>
     </div>
     </form> 
     </div>
     </div>
     </div>        
<jsp:include page="AllJs.jsp"></jsp:include>                                  
</body>
</html>