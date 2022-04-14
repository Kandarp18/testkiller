<%@page import="com.arth.bean.StudentBean"%>
<%@page import="com.arth.bean.ExamBean"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!doctype html>
<html lang="en">
	<head>
	<script src="https://code.jquery.com/jquery-3.6.0.min.js" integrity="sha256-/xUj+3OJU5yExlq6GSYGSHk7tPXikynS7ogEvDej/m4=" crossorigin="anonymous"></script>
	
		<script data-ad-client="ca-pub-4529508631166774" async src="https://pagead2.googlesyndication.com/pagead/js/adsbygoogle.js"></script>
		<meta charset="utf-8">
		<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
		<meta name="description" content="">
		<meta name="author" content="">
		<title>Testkiller</title>

	    <!-- Custom styles for this page -->
	    <link href="vendor/bootstrap/bootstrap.min.css" rel="stylesheet">

	    <link href="vendor/fontawesome-free/css/all.min.css" rel="stylesheet" type="text/css">

	    <!-- Custom styles for this page -->
    	<link href="vendor/datatables/dataTables.bootstrap4.min.css" rel="stylesheet">

	    <link rel="stylesheet" type="text/css" href="vendor/parsley/parsley.css"/>

	    <link rel="stylesheet" type="text/css" href="vendor/TimeCircle/TimeCircles.css"/>
	    <style>
	    	.border-top { border-top: 1px solid #e5e5e5; }
			.border-bottom { border-bottom: 1px solid #e5e5e5; }

			.box-shadow { box-shadow: 0 .25rem .75rem rgba(0, 0, 0, .05); }
	    </style>
	</head>
	<body>
			    <div class="container-fluid">
	    	<br />
	    	<div class="text-center">
                 
            </div>
                    <br />
                    <!-- Page Heading -->
                    <h1 class="h3 mt-4 mb-4 text-gray-800"></h1>
                    
                    <div class="card shadow mb-4">
                        <div class="card-header">
                            <div class="row">
                                <div class="col-md-6">
                                <b>Exam : </b>
                              
                                ${e.examName }                              
                              
                                 </div>
                                <div class="col-md-6">
                                
                                    <b>Subject : </b>
                                    
                                    ${s.subjectName }
                                                               
                                 </div>
                            </div>
                        </div>
                      
                            
                            <div class="row">
                          
                                <div class="col-md-8">
                                  
                                   
                        <form method="post" action="saveuserexamans" onsubmit="return confirm('Do you really want to submit this test?');">          
                                 <%
		                          int i = 0;
		                          %>
                     <c:forEach items="${q}" var="q"> 
                     <fieldset id="group1"> 
					<b>Question - </b>${q.question }
					<br>
					
					
				<input type="hidden" value="${q.questionId}" name="question<%=i%>"> 
					<div class="col-md-6 mb-4">
						<div class="radio">
							<label id="option1"><b>&nbsp;&nbsp;</b><input type="radio" value="${q.option1 }" name="userAns<%=i%>" class="answer_option" >${q.option1 }</label>
						</div>
					</div>
					
					<div class="col-md-6 mb-4">
						<div class="radio">
							<label id="option2"><b>&nbsp;&nbsp;</b><input type="radio" value="${q.option2 }" name="userAns<%=i%>" class="answer_option" >${q.option2 }</label>
						</div>
					</div>
					
					<div class="col-md-6 mb-4">
						<div class="radio">
							<label id="option3"><b>&nbsp;&nbsp;</b><input type="radio" value="${q.option3 }" name="userAns<%=i%>" class="answer_option" >${q.option3 }</label>
						</div>
					</div>
					
					<div class="col-md-6 mb-4">
						<div class="radio">
							<label id="option4"><b>&nbsp;&nbsp;</b><input type="radio" value="${q.option4 }" name="userAns<%=i%>" class="answer_option" > ${q.option4 }</label>
						</div>
					</div>
					
				</fieldset>
			<%
			i++;
			%>
				</c:forEach>
				<div class="text-center">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
				<input type="submit" name="submit" onclick="saveAns()" class="btn btn-success" value="Final Submit">
				</div>
				 </form>    
                

	
                  </div>
                                <div class="col-md-4">
                                    <div class="text-center mt-2 mb-2">
                                        <div id="exam_timer" data-timer=100 style="max-width:375px; width: 100%; height: 190px; margin:0 auto">
                                        </div>
                                    </div>
                                    <div class="card shadow">
                                        <div class="card-header"><b>Student Details</b></div>
                                        <div class="card-body">
                                            <div class="row">
                                              
                                                <div class="col-md-8">
                                                    <b>Roll No : </b>${ast.rollNo }<br />
                                                    <b>Name : </b>${ast.studentName }<br />
                                                    <b>Class : </b>${ast.className }                                           
                                                 </div>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                            </div>
                  
</div>
                		
	<jsp:include page="AllJs.jsp"></jsp:include>
	
	                     <%
	               ExamBean exam = (ExamBean) request.getAttribute("exam");
	                %>
	<%
	StudentBean student = (StudentBean) session.getAttribute("student");
	%>  
<script>
function saveAns() {
	let total =<%=i%>;
	let userAns = [];
	let examId =<%=exam.getExamId()%>;
	let studentId =<%=student.getStudentId()%>;
	for (let i = 0; i < total; i++) {
		let questions = document.getElementsByName("question" + i)
		let ans = document.getElementsByName("userAns" + i);
		for (let a = 0; a < 4; a++) {
			if (ans[a].checked) {
				let ua = {
					"userAns" : ans[a].value,
					"questionId" : questions[0].value,
					"examId" : examId,
					"studentId" : studentId
				}
				userAns.push(ua);
				$.ajax({
					url : "saveuserexamans",
					type : "post",
					data : ua,
					success : function(data, textStatus, jqXHR) {
						//data - response from server
						console.log(data);
					},
					error : function(jqXHR, textStatus, errorThrown) {
						console.log("error")
					}
				});
			}
		}
	}//main loop 
	
	alert("exam submited please view result");
}

</script>
	</body>
</html>