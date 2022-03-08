  <!-- Sidebar -->
        <ul class="navbar-nav bg-gradient-primary sidebar sidebar-dark accordion" id="accordionSidebar">

            <!-- Sidebar - Brand -->
            <a class="sidebar-brand d-flex align-items-center justify-content-center" href="dashboard.php">
                <div class="sidebar-brand-icon rotate-n-15">
                    
                </div>
                <i class="fas fa-laugh-wink"></i>
                <div class="sidebar-brand-text mx-3">Admin</div>
            </a>

            <!-- Divider -->
            <hr class="sidebar-divider my-0">

            <!-- Nav Item - Dashboard -->
            <li class="nav-item">
                <a class="nav-link" href="class">
                    <i class="fas fa-door-open"></i>
                    <span>Classes</span></a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="#" data-toggle="collapse" data-target="#subject_collapse" aria-expanded="false" aria-controls="subject_collapse">
                    <i class="fas fa-book-open"></i>
                    <span>Subject</span>
                </a>
                <div id="subject_collapse" class="collapse" aria-labelledby="headingTwo" data-parent="#accordionSidebar" style="">
                    <div class="bg-white py-2 collapse-inner rounded">
                        <a class="collapse-item" href="subject">Subject</a>
                        <a class="collapse-item" href="assignsubject">Assign Subject</a>
                    </div>
                </div>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="#" data-toggle="collapse" data-target="#student_collapse" aria-expanded="false" aria-controls="student_collapse">
                    <i class="fas fa-address-book"></i>
                    <span>Student</span>
                </a>
                <div id="student_collapse" class="collapse" aria-labelledby="headingTwo" data-parent="#accordionSidebar" style="">
                    <div class="bg-white py-2 collapse-inner rounded">
                        <a class="collapse-item" href="student">Student</a>
                        <a class="collapse-item" href="assignstudent">Assign Student</a>
                    </div>
                </div>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="#" data-toggle="collapse" data-target="#exam_collapse" aria-expanded="false" aria-controls="exam_collapse">
                    <i class="fas fa-edit"></i>
                    <span>Exam</span>
                </a>
                <div id="exam_collapse" class="collapse" aria-labelledby="headingTwo" data-parent="#accordionSidebar" style="">
                    <div class="bg-white py-2 collapse-inner rounded">
                        <a class="collapse-item" href="exam">Exam</a>
                        <a class="collapse-item" href="examsubject">Exam Subject</a>
                        <a class="collapse-item" href="examsubjectquestion">Question</a>
                    </div>
                </div>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="users">
                    <i class="fas fa-users-cog"></i>
                    <span>User</span></a>
            </li>
            
            <!-- Sidebar Toggler (Sidebar) -->
            <div class="text-center d-none d-md-inline">
                <button class="rounded-circle border-0" id="sidebarToggle"></button>
            </div>

        </ul>
        <!-- End of Sidebar -->
