
<script type="text/javascript" src="js/jquery.min.js"></script>
	<script type="text/javascript" src="js/jquery-ui.min.js"></script>
	<script type="text/javascript" src="js/popper.min.js"></script>
	<script type="text/javascript" src="js/bootstrap.min.js"></script>

	<script src="js/waves.min.js" type="text/javascript"></script>

	<script type="text/javascript" src="js/jquery.slimscroll.js"></script>

	<script type="text/javascript" src="js/jquery.datatables.min.js"></script>

	<script src="js/jquery.flot.js" type="text/javascript"></script>
	<script src="js/jquery.flot.categories.js" type="text/javascript"></script>
	<script src="js/curvedlines.js" type="text/javascript"></script>
	<script src="js/jquery.flot.tooltip.min.js" type="text/javascript"></script>

	<script src="js/amcharts.js" type="text/javascript"></script>
	<script src="js/serial.js" type="text/javascript"></script>
	<script src="js/light.js" type="text/javascript"></script>

	<script src="js/markerclusterer.js" type="text/javascript"></script>
	<script type="text/javascript"
		src="https://maps.google.com/maps/api/js?sensor=true"></script>
	<script type="text/javascript" src="js/gmaps.js"></script>

	<script src="js/pcoded.min.js" type="text/javascript"></script>
	<script src="js/vertical-layout.min.js" type="text/javascript"></script>
	<script type="text/javascript" src="js/crm-dashboard.min.js"></script>
	<script type="text/javascript" src="js/script.min.js"></script>
	<script type="text/javascript" src="js/html2pdf.js"></script>

	<script async=""
		src="https://www.googletagmanager.com/gtag/js?id=UA-23581568-13"
		type="text/javascript"></script>
	<script type="text/javascript">
		window.dataLayer = window.dataLayer || [];
		function gtag() {
			dataLayer.push(arguments);
		}
		gtag('js', new Date());

		gtag('config', 'UA-23581568-13');
	</script>
<script type="text/javascript">
			function exportPdf() {
				const element = document.getElementById('studenttable');
				var opt = {
					margin : 1,
					filename : 'Report.pdf',
					image : {
						type : 'jpeg',
						quality : 0.98
					},
					html2canvas : {
						scale : 1
					},
					jsPDF : {
						unit : 'in',
						format : 'letter',
						orientation : 'landscape'
					}
				};
				html2pdf().set(opt).from(element).save();
			}
		</script>
