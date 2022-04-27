 <nav class="navbar header-navbar pcoded-header iscollapsed"
				header-theme="themelight1" pcoded-header-position="fixed">
				<div class="navbar-wrapper">
					<div class="navbar-logo" logo-theme="theme6">
						<a href="studentdashboard?studentId=${s.studentId }">
			
							Testkiller

						</a> <a class="mobile-menu" id="mobile-collapse" href="#!"> <i
							class="feather icon-menu icon-toggle-right"></i>
						</a> <a class="mobile-options waves-effect waves-light"> <i
							class="feather icon-more-horizontal"></i>
						</a>
					</div>
					<div class="navbar-container container-fluid">
						<ul class="nav-left">
							<li class="header-search">
								<div class="main-search morphsearch-search">
									<div class="input-group">
										<span class="input-group-prepend search-close"> <i
											class="feather icon-x input-group-text"></i>
										</span> <input type="text" class="form-control"
											placeholder="Enter Keyword"> <span
											class="input-group-append search-btn"> <i
											class="feather icon-search input-group-text"></i>
										</span>
									</div>
								</div>
							</li>
							<li><a href="#!"
								onclick="if (!window.__cfRLUnblockHandlers) return false; javascript:toggleFullScreen()"
								class="waves-effect waves-light"> <i
									class="full-screen feather icon-maximize"></i>
							</a></li>
						</ul>
						<ul class="nav-right">
							

							<li class="user-profile header-notification">
								<div class="dropdown-primary dropdown">
									<div class="dropdown-toggle" data-toggle="dropdown"
										aria-expanded="false">
										<img src="${s.profilePic }" class="img-radius"
											alt=""> <span>${s.studentName}</span> <i
											class="feather icon-chevron-down"></i>
									</div>
									<ul
										class="show-notification profile-notification dropdown-menu"
										data-dropdown-in="fadeIn" data-dropdown-out="fadeOut">
										
										<li><a href="studentprofile?studentId=${s.studentId }"> <i class="feather icon-user"></i>
												Profile
										</a></li>
										<li><a href="uploadprofile?studentId=${s.studentId }"> <i class="feather icon-upload-cloud"></i>
												Change Profile Photo
										</a></li>
										
										<li><a href="#" data-toggle="modal" data-target="#logoutModal"> 
										<i class="feather icon-log-out"></i> Logout
										</a></li>
									</ul>
								</div>
							</li>
						</ul>
					</div>
				</div>
			</nav>