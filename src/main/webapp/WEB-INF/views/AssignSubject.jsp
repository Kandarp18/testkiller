<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<!DOCTYPE html>
<html lang="en">

<head>
    <script data-ad-client="ca-pub-4529508631166774" async src="https://pagead2.googlesyndication.com/pagead/js/adsbygoogle.js"></script>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>Testkiller</title>

    <jsp:include page="AllCss.jsp"></jsp:include>
</head>

<body id="page-top">

    <!-- Page Wrapper -->
    <div id="wrapper">
<jsp:include page="AdminSideBar.jsp"></jsp:include>
               <!-- Content Wrapper -->
        <div id="content-wrapper" class="d-flex flex-column">

            <!-- Main Content -->
            <div id="content">
<jsp:include page="AdminHeader.jsp"></jsp:include>
                <!-- Begin Page Content -->
                <div class="container-fluid">
                   
                    <!-- Page Heading -->
                    <h1 class="h3 mb-4 text-gray-800">Assign Subject Management</h1>

                    <!-- DataTales Example -->
                    <span id="message"></span>
                    <div class="card shadow mb-4">
                        <div class="card-header py-3">
                        	<div class="row">
                            	<div class="col">
                            		<h6 class="m-0 font-weight-bold text-primary">Class List with Subject</h6>
                            	</div>
                            	<div class="col" align="right">
                            	<!-- Button trigger modal -->
                                  <button type="button" class="btn btn-primary" data-toggle="modal" data-target="#exampleModalLong">
                                 <i class="fas fa-plus"></i>
                                   </button>
                            		
                            	</div>
                            </div>
                        </div>
                        <div class="card-body">
                            <div class="table-responsive">
                                <table class="table table-bordered" id="subject_table" width="100%" cellspacing="0">
                                    <thead>
                                        <tr>
                                            <th>Class Name</th>
                                            <th>Subject Name</th>
                                            <th>Created On</th>
                                            <th>Action</th>
                                        </tr>
                                    </thead>
                                    <tbody>
                                        
                                    </tbody>
                                </table>
                            </div>
                        </div>
                    </div>

                                </div>
                <!-- /.container-fluid -->

            </div>
            <!-- End of Main Content -->

            <!-- Footer -->
            <footer class="sticky-footer bg-white">
                <div class="container my-auto">
                    <div class="copyright text-center my-auto">
                        <span>Copyright &copy; Testkiller 2022</span>
                    </div>
                </div>
            </footer>
            <!-- End of Footer -->

        </div>
        <!-- End of Content Wrapper -->

    </div>
    <!-- End of Page Wrapper -->

    <!-- Scroll to Top Button-->
    <a class="scroll-to-top rounded" href="#page-top">
        <i class="fas fa-angle-up"></i>
    </a>

    <!-- Logout Modal-->
    <div class="modal fade" id="logoutModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel"
        aria-hidden="true">
        <div class="modal-dialog" role="document">
            <div class="modal-content">
                <div class="modal-header">
                    <h5 class="modal-title" id="exampleModalLabel">Ready to Leave?</h5>
                    <button class="close" type="button" data-dismiss="modal" aria-label="Close">
                        <span aria-hidden="true">×</span>
                    </button>
                </div>
                <div class="modal-body">Select "Logout" below if you are ready to end your current session.</div>
                <div class="modal-footer">
                    <button class="btn btn-secondary" type="button" data-dismiss="modal">Cancel</button>
                    <a class="btn btn-primary" href="logout">Logout</a>
                </div>
            </div>
        </div>
    </div>
    <jsp:include page="AllJs.jsp"></jsp:include>
     <!-- Modal -->
<div class="modal fade" id="exampleModalLong" tabindex="-1" role="dialog" aria-labelledby="exampleModalLongTitle" aria-hidden="true">
  <div class="modal-dialog" role="document">
    <form method="post" id="subject_assign_form">
      		<div class="modal-content">
        		<div class="modal-header">
          			<h4 class="modal-title" id="modal_title">Assign Subject to Class</h4>
          			<button type="button" class="close" data-dismiss="modal">&times;</button>
        		</div>
        		<div class="modal-body">
        			<span id="form_message"></span>
                    <div class="form-group">
                        <label>Class Name</label>
                        <select name="class_id" id="class_id" class="form-control" required>
                            <option value="">Select Class</option>
                            <option value="78">123</option><option value="76">12th cs tm</option><option value="148">1777</option><option value="48">287</option><option value="8">2adeasdfadsf</option><option value="62">3</option><option value="81">42t</option><option value="11">5th</option><option value="116">A11</option><option value="70">accountancy</option><option value="57">ajloun</option><option value="114">Almaty</option><option value="16">AP1</option><option value="31">Arts99</option><option value="74">Asdi Class</option><option value="105">Batch 2021</option><option value="101">BS SE 6th Semester 2021</option><option value="79">BSC</option><option value="100">BSc 6th Semester Batch 2024</option><option value="71">BTech</option><option value="39">Btech 601</option><option value="37">Btech 8</option><option value="55">CABM</option><option value="38">clasa a</option><option value="110">class 001</option><option value="120">Class PHP Exam</option><option value="84">Class Six</option><option value="82">Class V</option><option value="49">Class X</option><option value="83">CLASS XI</option><option value="40">CLS102</option><option value="137">CM21</option><option value="150">cntt1</option><option value="122">co5</option><option value="7">coding bootcamp</option><option value="22">computer science 2020</option><option value="91">Computer Science 2022</option><option value="3">Computer Science Batch 2 Jan 2021</option><option value="2">Computer Science Batch July 2020</option><option value="144">Control System</option><option value="146">CS</option><option value="153">CS101</option><option value="23">cse</option><option value="54">DABM</option><option value="14">dds</option><option value="147">demo</option><option value="58">dgf</option><option value="15">edawedasddse</option><option value="53">EDBAM</option><option value="135">ELPA</option><option value="47">fdfff</option><option value="69">First Sem</option><option value="65">First1</option><option value="139">fitosanitara</option><option value="21">FY</option><option value="136">fybca</option><option value="36">geography</option><option value="9">Hello</option><option value="108">hi</option><option value="145">Industrial Instrumentation</option><option value="143">Instrumentation Engineering</option><option value="123">ITdept</option><option value="80">ITWM85 Web and Mobile Technology</option><option value="66">java</option><option value="52">javascript</option><option value="95">jimm</option><option value="87">JLClass</option><option value="119">john</option><option value="93">joshua class</option><option value="61">JS1</option><option value="103">just b 4</option><option value="86">Kelas 1 SD</option><option value="19">lili</option><option value="113">Loka</option><option value="109">lop 1</option><option value="127">Mate</option><option value="73">math</option><option value="126">Mathematics</option><option value="77">MCA</option><option value="6">MCA 1st year</option><option value="41">MCA 2021</option><option value="4">MCA Sem 1 JAN 2021</option><option value="140">Mike</option><option value="56">mobile computing</option><option value="50">moynul</option><option value="20">MUET</option><option value="51">mysql</option><option value="142">Network Theory</option><option value="152">PARK</option><option value="29">Paul</option><option value="64">PHP 1</option><option value="125">Quant</option><option value="63">RangerClass</option><option value="28">react js</option><option value="90">REET 2021</option><option value="46">S</option><option value="115">sch</option><option value="32">Science</option><option value="35">sfas</option><option value="89">Sheraj</option><option value="10">Special</option><option value="104">Study Habit 1</option><option value="85">Terminal</option><option value="107">Testing666</option><option value="99">TI 001A</option><option value="75">Toan</option><option value="106">Trap</option><option value="98">TYIt</option><option value="72">vbb</option><option value="151">X TKJ 1</option><option value="24">Yab</option><option value="102">zuma college</option><option value="138">zxzx</option>                        </select>
                    </div>
		          	<div class="form-group">
		          		<label>Subject Name</label>
		          		<select name="subject_id" id="subject_id" class="form-control" required>
                            <option value="">Select Subject</option>
                            <option value="101">2112</option><option value="85">5155</option><option value="50">5555</option><option value="144">abc</option><option value="11">Acccc</option><option value="137">Accounting</option><option value="104">airplane</option><option value="14">algo</option><option value="117">app</option><option value="152">Arabic</option><option value="102">asdasd</option><option value="90">asdfghjk</option><option value="148">Astana</option><option value="151">Astana1</option><option value="77">Bangla</option><option value="61">Bca</option><option value="147">c</option><option value="150">C Program</option><option value="155">CBD</option><option value="44">Chemistry</option><option value="31">compiler</option><option value="56">compiler1001</option><option value="33">Computer</option><option value="109">Computer Application</option><option value="99">COMPUTER ARCHITECTURE</option><option value="24">computer enginerring</option><option value="110">Computer Network</option><option value="78">CRS</option><option value="16">Crucx</option><option value="72">CS</option><option value="158">CSC111</option><option value="53">dasda</option><option value="70">database</option><option value="17">databaze</option><option value="130">dob</option><option value="146">eng</option><option value="60">English</option><option value="82">English Writing</option><option value="48">exam35</option><option value="96">fghj</option><option value="165">Fitosanitara</option><option value="54">French</option><option value="51">Fuzzy Logic999</option><option value="174">giai tich 1</option><option value="177">GS1</option><option value="19">H</option><option value="142">hi</option><option value="22">History</option><option value="129">History JT</option><option value="94">How to</option><option value="73">HRMY</option><option value="92">HTML 1</option><option value="175">htttt</option><option value="66">IT</option><option value="119">JLSubject</option><option value="127">joshua subject</option><option value="71">junior</option><option value="80">kiik</option><option value="52">kkk</option><option value="55">LES BASES RESEAUX</option><option value="10">LOL</option><option value="20">lolo</option><option value="23">M1</option><option value="128">MA101</option><option value="30">Mastermath</option><option value="171">Mate777</option><option value="172">Mate777x</option><option value="156">Matematica</option><option value="176">Matematika</option><option value="120">math</option><option value="135">math1</option><option value="139">Mathd</option><option value="39">maths</option><option value="87">MATJ1</option><option value="15">MERISE MCD</option><option value="83">Mff</option><option value="167">Mike24hfh</option><option value="108">mon toan</option><option value="95">Myanmars</option><option value="105">mysub</option><option value="169">Name</option><option value="91">nbnbmbnbndfy</option><option value="26">network</option><option value="125">Network practical</option><option value="168">networking</option><option value="123">os</option><option value="65">pagolbabasub</option><option value="160">Pawan Subject</option><option value="118">Pendidikan Sejarah Perjuangan Bangsa</option><option value="88">php1</option><option value="112">PHPH</option><option value="97">PHPTEST</option><option value="140">Phusica</option><option value="98">Physics 101</option><option value="43">pop</option><option value="173">Programming</option><option value="143">PYthon</option><option value="124">REET</option><option value="32">rrrR</option><option value="84">Sathish</option><option value="153">sci</option><option value="121">science</option><option value="81">Scientific Query</option><option value="122">Sheraj</option><option value="86">shortendfds</option><option value="164">SQL</option><option value="138">statistics401</option><option value="126">sunday subject</option><option value="42">Tahamid</option><option value="134">test</option><option value="170">Try</option><option value="76">ttest</option><option value="13">Urdu</option><option value="89">Vladislav</option><option value="21">WASH</option><option value="111">Web and Mobile Technologies</option><option value="93">Web Design</option><option value="163">web design 2</option><option value="100">werthj</option>                        </select>
		          	</div>
        		</div>
        		<div class="modal-footer">
          			
          			<input type="submit" name="submit" id="submit_button" class="btn btn-success" value="Add" />
          			<button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
        		</div>
      		</div>
    	</form>
  </div>
</div>
</body>

</html>
