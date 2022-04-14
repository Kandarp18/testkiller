
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