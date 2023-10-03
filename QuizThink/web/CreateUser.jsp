<%-- 
    Document   : CreateUser
    Created on : Sep 19, 2023, 10:24:41 AM
    Author     : Dell
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"  %>  
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">

<!-- Mirrored from educhamp.themetrades.com/demo/admin/index.html by HTTrack Website Copier/3.x [XR&CO'2014], Fri, 22 Feb 2019 13:08:15 GMT -->
<head>

	<!-- META ============================================= -->
	<meta charset="utf-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<meta name="keywords" content="" />
	<meta name="author" content="" />
	<meta name="robots" content="" />
	
	<!-- DESCRIPTION -->
	<meta name="description" content="EduChamp : Education HTML Template" />
	
	<!-- OG -->
	<meta property="og:title" content="EduChamp : Education HTML Template" />
	<meta property="og:description" content="EduChamp : Education HTML Template" />
	<meta property="og:image" content="" />
	<meta name="format-detection" content="telephone=no">
	
	<!-- FAVICONS ICON ============================================= -->
	<link rel="icon" href="../error-404.html" type="image/x-icon" />
	<link rel="shortcut icon" type="image/x-icon" href="admin/assets/images/favicon.png" />
	
	<!-- PAGE TITLE HERE ============================================= -->
	<title>EduChamp : Education HTML Template </title>
	
	<!-- MOBILE SPECIFIC ============================================= -->
	<meta name="viewport" content="width=device-width, initial-scale=1">
	
	<!--[if lt IE 9]>
	<script src="assets/js/html5shiv.min.js"></script>
	<script src="assets/js/respond.min.js"></script>
	<![endif]-->
	
	<!-- All PLUGINS CSS ============================================= -->
	<link rel="stylesheet" type="text/css" href="admin/assets/css/assets.css">
	<link rel="stylesheet" type="text/css" href="admin/assets/vendors/calendar/fullcalendar.css">
	
	<!-- TYPOGRAPHY ============================================= -->
	<link rel="stylesheet" type="text/css" href="admin/assets/css/typography.css">
	
	<!-- SHORTCODES ============================================= -->
	<link rel="stylesheet" type="text/css" href="admin/assets/css/shortcodes/shortcodes.css">
	
	<!-- STYLESHEETS ============================================= -->
	<link rel="stylesheet" type="text/css" href="admin/assets/css/style.css">
	<link rel="stylesheet" type="text/css" href="admin/assets/css/dashboard.css">
	<link class="skin" rel="stylesheet" type="text/css" href="admin/assets/css/color/color-1.css">
	
</head>
<body class="ttr-opened-sidebar ttr-pinned-sidebar">
	<jsp:include page="Dashboard_header.jsp"></jsp:include>  
        <!--Main container start -->
	<main class="ttr-wrapper">
		<div class="container-fluid">	
			<div class="row">
				<!-- Your Profile Views Chart -->
				<div class="col-lg-12 m-b30">
					<div class="widget-box">
						<div class="wc-title">
							<h4>Create User</h4>
						</div>
						<div class="widget-inner">
                                                    <form class="edit-profile m-b30" action="/QuizThink/createaccount" method="post">
								<div class="">
                                                                        <div class="form-group row">
                                                                            <div class="col-sm-10  ml-auto">
                                                                                    <h3>1. Account</h3>
                                                                            </div>
									</div>
                                                                        <div class="form-group row">
										<label class="col-sm-2 col-form-label">UserName</label>
										<div class="col-sm-7">
                                                                                    <input class="form-control" type="text" name="username" placeholder="Input Username">
										</div>
									</div>
                                                                        <div class="form-group row">
										<label class="col-sm-2 col-form-label">Password</label>
										<div class="col-sm-7">
											<input class="form-control" type="password" name="password" placeholder="Input Password">
										</div>
									</div>
                                                                        <div class="form-group row">
										<label class="col-sm-2 col-form-label">Email</label>
										<div class="col-sm-7">
											<input class="form-control" type="email" name="email" placeholder="Input Email">
										</div>
									</div>
                                                                        <div class="form-group row">
                                                                            <label class="col-sm-2 col-form-label">Role</label>
                                                                            <div class="col-sm-7">
                                                                                
<!--                                                                                <input type="radio" id="customerRole" name="role" value="1">
                                                                                <label class="col-sm-2 col-form-label" for="customerRole">Customer</label><br>-->
                                                                                <select name="role">
                                                                                    <option value="">None</option> 
                                                                                    <c:forEach items = "${listRole}" var="o" varStatus="status">
                                                                                        <option>${o.roleName}</option>
                                                                                    </c:forEach>
                                                                                </select>
                                                                            </div>
                                                                        </div>
									<div class="form-group row">
                                                                            <div class="col-sm-10  ml-auto">
                                                                                <h3>2. Personal Details</h3>
                                                                            </div>
									</div>
									<div class="form-group row">
										<label class="col-sm-2 col-form-label">Full Name</label>
										<div class="col-sm-7">
											<input class="form-control" type="text" name="fullname" placeholder="Full Name">
										</div>
									</div>
									<div class="form-group row">
										<label class="col-sm-2 col-form-label">Gender</label>
										<div class="col-sm-7">
                                                                                    <input type="radio" id="saleRole" name="gender" value="Male">
                                                                                    <label class="col-sm-2 col-form-label" for="saleRole">Male</label><br>

                                                                                    <input type="radio" id="membershipRole" name="gender" value="Female">
                                                                                    <label class="col-sm-2 col-form-label" for="membershipRole">Female</label><br>
										</div>
									</div>
									<div class="form-group row">
										<label class="col-sm-2 col-form-label">DOB</label>
										<div class="col-sm-7">
                                                                                    <input class="form-control" type="date" name="DOB" placeholder="Date of birth">
										</div>
									</div>
									<div class="form-group row">
										<label class="col-sm-2 col-form-label">Phone Number</label>
										<div class="col-sm-7">
                                                                                    <input class="form-control" type="text" name="phonenumber" placeholder="Phone Number">
										</div>
									</div>
									<div class="form-group row">
                                                                            
										<label class="col-sm-1 col-form-label">Province</label>
                                                                                <div class="col-sm-2">
                                                                                    <select name="role" id="selectProvince">
                                                                                        <option value="">None</option>
                                                                                        <c:forEach items = "${listRole}" var="o" varStatus="status">
                                                                                            <option>${o.roleName}</option>
                                                                                        </c:forEach>
                                                                                    </select>
                                                                                </div>
                                                                                <div class="col-sm-1"></div>
                                                                                <label class="col-sm-1 col-form-label">District</label>
                                                                                <div class="col-sm-2">
                                                                                    <select name="role" id="selectDistrict">
                                                                                        <option value="">None</option>
                                                                                    </select>
                                                                                </div>
                                                                        </div>
									<div class="form-group row">
										<label class="col-sm-2 col-form-label">Avatar</label>
										<div class="col-sm-7">
                                                                                    <input class="form-control" type="text" name="avatar" placeholder="Image URL">
										</div>
									</div>  
                                                                        <div class="form-group row">
										<label class="col-sm-2 col-form-label">Status</label>
										<div class="col-sm-7">
											<input class="form-control" type="text" name="status" placeholder="Status">
										</div>
									</div>
								</div>
								<div class="">
									<div class="">
										<div class="row">
											<div class="col-sm-2">
											</div>
											<div class="col-sm-7">
												<button type="submit" class="btn">Save changes</button>
												<button type="reset" class="btn-secondry">Cancel</button>
											</div>
										</div>
									</div>
								</div>
							</form>
						</div>
					</div>
				</div>
				<!-- Your Profile Views Chart END-->
			</div>
		</div>
	</main>
<!-- External JavaScripts -->
<script src="admin/assets/js/jquery.min.js"></script>
<script src="admin/assets/vendors/bootstrap/js/popper.min.js"></script>
<script src="admin/assets/vendors/bootstrap/js/bootstrap.min.js"></script>
<script src="admin/assets/vendors/bootstrap-select/bootstrap-select.min.js"></script>
<script src="admin/assets/vendors/bootstrap-touchspin/jquery.bootstrap-touchspin.js"></script>
<script src="admin/assets/vendors/magnific-popup/magnific-popup.js"></script>
<script src="admin/assets/vendors/counter/waypoints-min.js"></script>
<script src="admin/assets/vendors/counter/counterup.min.js"></script>
<script src="admin/assets/vendors/imagesloaded/imagesloaded.js"></script>
<script src="admin/assets/vendors/masonry/masonry.js"></script>
<script src="admin/assets/vendors/masonry/filter.js"></script>
<script src="admin/assets/vendors/owl-carousel/owl.carousel.js"></script>
<script src='admin/assets/vendors/scroll/scrollbar.min.js'></script>
<script src="admin/assets/js/functions.js"></script>
<script src="admin/assets/vendors/chart/chart.min.js"></script>
<script src="admin/assets/js/admin.js"></script>
<script src='admin/assets/vendors/calendar/moment.min.js'></script>
<script src='admin/assets/vendors/calendar/fullcalendar.js'></script>

<!-- <script src='assets/vendors/switcher/switcher.js'></script> -->
<script>
    var selectProvince = document.getElementById(selectProvince);
    var selectDistrict = document.getElementById(selectDistrict);
    
    selectProvince.addEventListener("change",function() {
    // Get the selected option from bảng 1
    var selectedOption = selectProvince.value;
    
    if(selectedOption !== ''){
        selectDistrict.disabled = "false";
        
        //AJAX
        fetch('your-servlet-url?selectedOption=' + selectedOption)
            .then(function (response) {
                return response.json();
            })
            .then(function (data) {
                // Populate bảng 2 with options fetched from the servlet
                data.forEach(function (option) {
                    var optionElement = document.createElement("option");
                    optionElement.value = option;
                    optionElement.text = option;
                    bang2Select.appendChild(optionElement);
                });
            })
            .catch(function (error) {
                console.error('Error:', error);
            });
    }else {
        // If no option is selected in bảng 1, disable bảng 2 and display a message
        selectDistrict.disabled = true;
        var defaultOption = document.createElement("option");
        defaultOption.value = "";
        defaultOption.text = "None";
        bang2Select.appendChild(defaultOption);
    }
});
</script>
<script>
  $(document).ready(function() {

    $('#calendar').fullCalendar({
      header: {
        left: 'prev,next today',
        center: 'title',
        right: 'month,agendaWeek,agendaDay,listWeek'
      },
      defaultDate: '2019-03-12',
      navLinks: true, // can click day/week names to navigate views

      weekNumbers: true,
      weekNumbersWithinDays: true,
      weekNumberCalculation: 'ISO',

      editable: true,
      eventLimit: true, // allow "more" link when too many events
      events: [
        {
          title: 'All Day Event',
          start: '2019-03-01'
        },
        {
          title: 'Long Event',
          start: '2019-03-07',
          end: '2019-03-10'
        },
        {
          id: 999,
          title: 'Repeating Event',
          start: '2019-03-09T16:00:00'
        },
        {
          id: 999,
          title: 'Repeating Event',
          start: '2019-03-16T16:00:00'
        },
        {
          title: 'Conference',
          start: '2019-03-11',
          end: '2019-03-13'
        },
        {
          title: 'Meeting',
          start: '2019-03-12T10:30:00',
          end: '2019-03-12T12:30:00'
        },
        {
          title: 'Lunch',
          start: '2019-03-12T12:00:00'
        },
        {
          title: 'Meeting',
          start: '2019-03-12T14:30:00'
        },
        {
          title: 'Happy Hour',
          start: '2019-03-12T17:30:00'
        },
        {
          title: 'Dinner',
          start: '2019-03-12T20:00:00'
        },
        {
          title: 'Birthday Party',
          start: '2019-03-13T07:00:00'
        },
        {
          title: 'Click for Google',
          url: 'http://google.com/',
          start: '2019-03-28'
        }
      ]
    });

  });

</script>
</body>

<!-- Mirrored from educhamp.themetrades.com/demo/admin/index.html by HTTrack Website Copier/3.x [XR&CO'2014], Fri, 22 Feb 2019 13:09:05 GMT -->
</html>