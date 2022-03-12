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
                    <h1 class="h3 mb-4 text-gray-800">Assign Student Management</h1>

                    <!-- DataTales Example -->
                    <span id="message"></span>
                    <div class="card shadow mb-4">
                        <div class="card-header py-3">
                        	<div class="row">
                            	<div class="col">
                            		<h6 class="m-0 font-weight-bold text-primary">Student List with Class Name</h6>
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
                                <table class="table table-bordered" id="subjecttable" width="100%" cellspacing="0">
                                    <thead>
                                        <tr>
                                            <th>Roll No.</th>
                                            <th>Student Name</th>
                                            <th>Class Name</th>
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
    <jsp:include page="AllJs.jsp"></jsp:include> <!-- Modal -->
<div class="modal fade" id="exampleModalLong" tabindex="-1" role="dialog" aria-labelledby="exampleModalLongTitle" aria-hidden="true">
  <div class="modal-dialog" role="document">
   <form method="post" id="student_assign_form">
      		<div class="modal-content">
        		<div class="modal-header">
          			<h4 class="modal-title" id="modal_title">Assign Student to Class</h4>
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
		          		<label>Student Name</label>
		          		<select name="student_id" id="student_id" class="form-control" required>
                            <option value="">Select Student</option>
                            <option value="96">aa</option><option value="17">aaa</option><option value="164">AAA</option><option value="32">aaaa</option><option value="35">abc</option><option value="74">abc</option><option value="187">ABC</option><option value="196">abc</option><option value="67">Abcd</option><option value="195">Abdulrahman Ibrahim</option><option value="95">Abhishek</option><option value="133">Ade Kalis</option><option value="4">Adrian Ireland</option><option value="65">AJAY</option><option value="58">Alandra</option><option value="44">Aldrin</option><option value="102">ali</option><option value="28">ALI BONGO</option><option value="129">ana</option><option value="99">Anas</option><option value="12">Andrea Estes</option><option value="116">Anuja</option><option value="81">arslan</option><option value="82">arslan</option><option value="214">Arun</option><option value="215">Arun</option><option value="141">asd</option><option value="115">Asdi Student</option><option value="21">Ask</option><option value="85">ATAMATI SAM ERIC</option><option value="139">avadhoot</option><option value="148">ayush</option><option value="179">Baha</option><option value="87">bahar</option><option value="127">Benson Sam</option><option value="118">Bittu</option><option value="41">chaima</option><option value="134">chinna</option><option value="7">Chrystal Byrd</option><option value="143">da</option><option value="152">damigaw304</option><option value="23">Davies</option><option value="219">DC</option><option value="15">Deep</option><option value="37">Demo</option><option value="194">demo</option><option value="125">demo ajay</option><option value="218">dev</option><option value="199">dh</option><option value="73">dixa</option><option value="131">Dudun Malidun</option><option value="170">Durgesh Kumar Mahato</option><option value="217">dwadad</option><option value="47">ee</option><option value="122">Ehsan</option><option value="132">Emeng Konyeh</option><option value="2">Eric Simpson</option><option value="88">Farhad</option><option value="147">fe</option><option value="31">flavian</option><option value="89">Foysal</option><option value="11">Frank Nicholson</option><option value="150">ganta dinesh</option><option value="19">Gdjdjsjsjdjdjdjdjejejejej</option><option value="55">gem</option><option value="153">Getachew</option><option value="190">Giro Salah</option><option value="207">Gurvinder Singh</option><option value="70">haasini</option><option value="56">Haritha Fernando</option><option value="20">Hdjdjdjdjdd</option><option value="216">helo</option><option value="1">Hugh Proper</option><option value="60">Islom</option><option value="186">itan</option><option value="68">j411</option><option value="62">jagdish prasad</option><option value="80">jk</option><option value="154">john</option><option value="160">John</option><option value="191">john</option><option value="163">john Bushy</option><option value="142">Joshua name</option><option value="210">JOY</option><option value="144">JT A</option><option value="161">Juan Pedro</option><option value="151">kamaljeet</option><option value="145">keggg</option><option value="203">kirubel</option><option value="180">Korn Sok An</option><option value="182">Kunal</option><option value="149">kundan Dhore</option><option value="159">kurt</option><option value="84">lnc</option><option value="192">lo</option><option value="3">Lori Alexander</option><option value="64">Madonna Diaz</option><option value="209">Manjeet Singh</option><option value="189">Marco</option><option value="112">Margarett</option><option value="6">Mark Jones</option><option value="13">Mary Qualls</option><option value="117">massi</option><option value="104">Mg Nyan</option><option value="178">mk</option><option value="27">Mohammad ali</option><option value="72">moynul</option><option value="205">Muddathir Samir</option><option value="206">Nam</option><option value="137">Nguyen van n</option><option value="183">njohnsmith</option><option value="197">Nu</option><option value="105">oix</option><option value="162">Oparah Divine</option><option value="201">osama</option><option value="185">pandu</option><option value="208">Pankaj Kumawat</option><option value="193">Park</option><option value="126">Phoy</option><option value="33">PONSIVA</option><option value="93">Pooja</option><option value="54">Prathmesh</option><option value="101">pratyush</option><option value="198">Priya</option><option value="25">PumNr </option><option value="26">PumNr</option><option value="40">qwabena</option><option value="22">Raj</option><option value="146">Raj PAtel</option><option value="200">ram</option><option value="177">rao</option><option value="42">Ravshan</option><option value="30">rilind</option><option value="14">Rosalyn Jones</option><option value="63">Roy</option><option value="50">rrrR</option><option value="156">sabiriin mohamed</option><option value="43">SADASDASD</option><option value="155">salah ahmed</option><option value="211">Sam</option><option value="71">sanaulla</option><option value="39">sara</option><option value="61">Sareer Hussain</option><option value="167">sasuke</option><option value="46">saurav kumar</option><option value="34">Shahzad</option><option value="135">Sheraj</option><option value="136">Sheraj</option><option value="16">shrikant</option><option value="36">sitaram</option><option value="51">siva vadlamuri</option><option value="188">Sobraj</option><option value="49">Sola</option><option value="94">Student A</option><option value="38">Student Student1</option><option value="176">student1</option><option value="175">sudheer</option><option value="59">Sunny</option><option value="114">suraj</option><option value="66">test</option><option value="113">test</option><option value="168">Test</option><option value="171">test</option><option value="174">test</option><option value="90">test testila</option><option value="45">Test User</option><option value="166">testi</option><option value="181">Tima</option><option value="24">tkr</option><option value="86">vinoth</option><option value="48">Vishnu</option><option value="212">Warrennnn</option><option value="184">wisarut</option><option value="213">xtte</option><option value="52">Yabibal Zelalem</option>                        </select>
		          	</div>
                    <div class="form-group">
                        <label>Roll No.</label>
                        <input type="text" name="student_roll_no" id="student_roll_no" class="form-control" required />
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
    <script type="text/javascript">
			$(document).ready(function() {
				$('#subjecttable').DataTable();
			});
		</script>
</body>

</html>
