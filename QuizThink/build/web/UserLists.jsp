<%-- 
    Document   : UserLists
    Created on : Sep 18, 2023, 11:54:34 PM
    Author     : Dell
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"  %>  
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
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
    <body>
    <jsp:include page="Dashboard_header.jsp"></jsp:include>   
    
    <main class="ttr-wrapper">
        <div class="container-fluid">
                <div class="db-breadcrumb">
                        <h4 class="breadcrumb-title">Dashboard</h4>
                        <ul class="db-breadcrumb-list">
                                <li><a href="#"><i class="fa fa-home"></i>Home</a></li>
                                <li>Dashboard</li>
                        </ul>
                </div>	
        </div>
        
        
        <!-- NEED REPAIR -->
        <div class="container-fluid">
            <table>
                <tr>
                    <td >
                        <label for="category">Search</label>
                        <form action="userlists" class="form" onsubmit="countRows()">
                            <div class="input-group">
                                <input type="text" name="search" class="form-control" placeholder="Search user by name">
                                <div class="input-group-append">
                                    <button type="submit" class="btn btn-success">Search</button>
                                </div>
                            </div>
                        </form>
                    </td>
                    <td>
                            <label for="category">Choose a Role</label>
                            <select id="category" name="role" onchange="redirectToURL(this)">
                                <option value="">All</option>
                                <c:forEach items="${listRole}" var="o">
                                    <option value="${o.roleID}" <c:if test="${selectedRole == o.roleID}">selected="selected" </c:if> >${o.roleName}</option>
                                </c:forEach>
                            </select>
                    </td>
                    <td>
                        <label for="category"></label>
                        <a href="createaccount" class="btn btn-block btn-success">Add</a>
                    </td>
                </tr>
            </table>
                
        </div>
            <!-- Main content -->
        <p id="rowCount"></p>
        <section class="content">
          <div class="row">
            <div class="col-lg-12 m-b30">
              <div class="box">
                <!-- /.box-header -->
                <div class="box-body">
                  <table id="example2" class="table table-bordered table-hover">
                    <thead>
                        <tr>
                            <th>Account ID</th>
                            <th>Username</th>
                            <th>Email</th>
                            <th>Status</th>
                            <th>Gender</th>
                            <th>Avatar</th>
                            <th>Full name</th>
                            <th>Date of Birth</th>
                            <th>Create Date</th>
                            <th>Modify Date</th>
                            
                        </tr>
                    </thead>
                    <tbody id="userdata">
                        <c:forEach items="${listAccount}" var="o" varStatus="status">
                            <tr>
                                <td>${o.accountId}</td>
                                <td><a href="edituser?accountId=${o.accountId}">${o.username}</a></td>
                                <td>${o.email}</td>
                                <td>${o.status}</td>
                                <td>${o.gender}</td>
                                <td>${o.avatar}</td>
                                <td>${o.fullname}</td>
                                <td>${o.dob}</td>
                                <td>${o.createdDate}</td>
                                <td>${o.modifyDate}</td>
                            </tr>
                        </c:forEach>

                    </tbody>
                  </table>
                </div>
                <!-- /.box-body -->
              </div>
            </div>
            <!-- /.col -->
          </div>
          <!-- /.row -->
            <div >
                <ul class="pagination">	
                    <c:forEach begin="1" end="${lastPage}" var="i">
                        <li <c:if test="${i == currentPage}">class="active"</c:if>><a data-param="page" data-value="${i}" onclick="handleLinkClick(event, this)">${i}</a></li>
                    </c:forEach>
                </ul>
            </div>
        </section>
        <!-- /.content -->
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
    
    <script>
    // Tạo một hàm để đếm số hàng
    function countRows() {
        var rowCount = table.getElementsByTagName("tr").length - 2;

        // Hiển thị kết quả trong phần tử có ID "rowCount"
        document.getElementById("rowCount").textContent = "Số hàng: " + rowCount;

        // Ngăn form tiếp tục submit (nếu cần)
        return false;
    }

    // Gọi hàm countRows() khi trang tải lại
    window.onload = function() {
        countRows();
    }
</script>
    
    <script>
        function handleLinkClick(event, link) {
            event.preventDefault();

            let currentURL = window.location.href;
            let url = new URL(currentURL);
            let param = link.getAttribute('data-param');
            let value = link.getAttribute('data-value');
            let newHref;
            if (currentURL.indexOf('role') !== -1 && currentURL.indexOf('page') === -1) {
                newHref = currentURL + '&' + param + '=' + value;
            }else if(currentURL.indexOf('role') === -1 && currentURL.indexOf('page') === -1){
                newHref = '/QuizThink/userlists?' + param + '=' + value;  
            }else if(currentURL.indexOf('page') !== -1){
                url.searchParams.set('page', value); 
                newHref = url.toString();
            }
            window.location.href = newHref;
          }
    </script>
    <script>
        function redirectToURL(selectElement) {
            var selectedOption = selectElement.value; // Lấy giá trị của option đã chọn
            var url;
            if(selectedOption === ''){
                url = 'userlists';
            }else{
                url = 'userlists?roleId=' + selectedOption; // Thay đổi thành URL của servlet hoặc trang bạn muốn chuyển hướng đến
            }
           // Chuyển hướng người dùng đến URL
            window.location.href = url;
        }
    </script>
    <!-- <script src='assets/vendors/switcher/switcher.js'></script> -->
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
</html>
