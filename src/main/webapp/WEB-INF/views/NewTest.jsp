<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!doctype html>
<html lang="en">
	<head>
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
                                  
                                   
                        <form method="post" action="listexamsubject?examId=${e.examId }&studentId=${st.studentId}" onsubmit="return confirm('Do you really want to submit this test?');">          
                                 
                     <c:forEach items="${q}" var="q">  
					<b>Question - </b>${q.question }
					<br>
					
					
				
					<div class="col-md-6 mb-4">
						<div class="radio">
							<label><b>&nbsp;&nbsp;</b><input type="radio" name="option1" class="answer_option" >${q.option1 }</label>
						</div>
					</div>
					
					<div class="col-md-6 mb-4">
						<div class="radio">
							<label><b>&nbsp;&nbsp;</b><input type="radio" name="option1" class="answer_option" >${q.option2 }</label>
						</div>
					</div>
					
					<div class="col-md-6 mb-4">
						<div class="radio">
							<label><b>&nbsp;&nbsp;</b><input type="radio" name="option1" class="answer_option" >${q.option3 }</label>
						</div>
					</div>
					
					<div class="col-md-6 mb-4">
						<div class="radio">
							<label><b>&nbsp;&nbsp;</b><input type="radio" name="option1" class="answer_option" > ${q.option4 }</label>
						</div>
					</div>
					
				
				</c:forEach>
				<div class="text-center">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
				<input type="submit" name="submit"  class="btn btn-success" value="Final Submit">
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
                		
	    
		<!-- Bootstrap core JavaScript-->
	    <script src="vendor/jquery/jquery.min.js"></script>
	    <script src="vendor/bootstrap/js/bootstrap.bundle.min.js"></script>

	    <script src="/vendor/datatables/jquery.dataTables.min.js"></script>
	    <script src="vendor/datatables/dataTables.bootstrap4.min.js"></script>

	    <!-- Core plugin JavaScript-->
	    <script src="vendor/jquery-easing/jquery.easing.min.js"></script>

	    <script type="text/javascript" src="vendor/parsley/dist/parsley.min.js"></script>

	    <script type="text/javascript" src="vendor/TimeCircle/TimeCircles.js"></script>

	    <script>
		  (function(i,s,o,g,r,a,m){i['GoogleAnalyticsObject']=r;i[r]=i[r]||function(){
		  (i[r].q=i[r].q||[]).push(arguments)},i[r].l=1*new Date();a=s.createElement(o),
		  m=s.getElementsByTagName(o)[0];a.async=1;a.src=g;m.parentNode.insertBefore(a,m)
		  })(window,document,'script','https://www.google-analytics.com/analytics.js','ga');

		  ga('create', 'UA-87739877-1', 'auto');
		  ga('send', 'pageview');

		</script>

	</body>
</html>
<script type="text/javascript">
$(document).ready(function(){
 
    $("#exam_timer").TimeCircles({
        "animation": "smooth",
        "bg_width": 1.2,
        "fg_width": 0.1,
        "circle_bg_color": "#eee",
        "time": {
            "Days":
            {
                "show": false
            },
            "Hours":
            {
                "show": false
            },
            "Minutes": {
                "text": "Minutes",
                "color": "#ffc107",
                "show": true
            },
            "Seconds": {
                "text": "Seconds",
                "color": "#007bff",
                "show": true
            }
        }
    });

   

    $("#exam_timer").TimeCircles().addListener(function(unit, value, total) {
        if(total < 1)
        {
            $("#exam_timer").TimeCircles().destroy();
            alert('Exam Time Completed');
            location.href="/listexamsubject?examId=${e.examId}&studentId=${st.studentId}";
        }
    });

});
</script>