<%-- 
    Document   : ListCustomer
    Created on : Oct 27, 2023, 4:10:52 PM
    Author     : minhk
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import= "Model.*" %>
<%@page import = "java.util.*" %>
<%@page import= "java.text.SimpleDateFormat" %>
<%@page import= "java.util.Date" %>
<!DOCTYPE html>
<html lang="en">

    <!-- Mirrored from educhamp.themetrades.com/demo/admin/review.html by HTTrack Website Copier/3.x [XR&CO'2014], Fri, 22 Feb 2019 13:11:35 GMT -->
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
        <title>QUIZ THINK-Online Quiz Practice Web</title>

        <!-- MOBILE SPECIFIC ============================================= -->
        <meta name="viewport" content="width=device-width, initial-scale=1">

        <!--[if lt IE 9]>
        <script src="admin/assets/js/html5shiv.min.js"></script>
        <script src="admin/assets/js/respond.min.js"></script>
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
        <% List<Membership> mem = (List<Membership>) request.getAttribute("MemList");%>
    </head>
    <body class="ttr-opened-sidebar ttr-pinned-sidebar">

        <jsp:include page = "MarketerHeader.jsp"/>	<!-- header end -->
        <jsp:include page = "Left_Sidebar_Menu.jsp"/>
        <!--Main container start -->
        <main class="ttr-wrapper">
            <div class="container-fluid">
                <div class="db-breadcrumb">
                    <h4 class="breadcrumb-title">Customers</h4>
                    <ul class="db-breadcrumb-list">
                        <li><a href="#"><i class="fa fa-home"></i>Home</a></li>
                        <li>List Membership</li>
                    </ul>
                </div>	
                <div class="row">
                    <!-- Your Profile Views Chart -->
                    <div class="col-lg-12 m-b30">
                        <div class="widget-box">
                            <div class="wc-title">
                                <h4>List Membership</h4>
                            </div>
                            <section>
                                <div>
                                    <section class="content">
                                        <div class="row">
                                            <div class="col-lg-6 m-b30">
                                                <a href="AddMembership" class="btn btn-success">
                                                    Add
                                                </a>
                                            </div>
                                            <div class="col-lg-12 m-b30">
                                                <div class="box">
                                                    <!-- /.box-header -->
                                                    <div class="box-body">
                                                        <table id="example2" class="table table-bordered table-hover">
                                                            <thead>
                                                                <tr>
                                                                    <th>No</th>
                                                                    <th>ID</th>
                                                                    <th>Title</th>
                                                                    <th>Price</th>
                                                                    <th>Discount</th>
                                                                    <th>Description</th>
                                                                    <th>Action</th>
                                                                    <th>Remove</th>
                                                                </tr>
                                                            </thead>
                                                            <tbody id="userdata">
                                                                <% if(mem == null || mem.isEmpty()) { %>
                                                                <tr>
                                                                    <td colspan="6">No data found</td>
                                                                </tr>
                                                                <% } else { %>
                                                                <% for(int i=0; i<mem.size(); i++) { %>
                                                                <tr>
                                                                    <td><%= i+1 %></td>
                                                                    <td><%= mem.get(i).getMembershipID() %></td>
                                                                    <td><%= mem.get(i).getTitle() %></td>
                                                                    <td><%= mem.get(i).getPrice() %></td>
                                                                    <td><%= mem.get(i).getDiscount() %></td>
                                                                    <td><%= mem.get(i).getDescription() %></td>
                                                                    <td><a href="EditMembership?id=<%= mem.get(i).getMembershipID() %>">Edit</a></td>
                                                                    <td><a href="DeleteMembership?id=<%= mem.get(i).getMembershipID() %>">Remove</a></td>
                                                                </tr>
                                                                <% } %>
                                                                <% } %>
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
                                            <!--                                <ul class="pagination">	
                                            <c:forEach begin="1" end="${lastPage}" var="i">
                                                <li <c:if test="${i == currentPage}">class="active"</c:if>><a data-param="page" data-value="${i}" onclick="handleLinkClick(event, this)">${i}</a></li>
                                            </c:forEach>
                                        </ul>-->
                                        </div>
                                    </section>
                                </div>
                            </section>

                        </div>
                    </div>
                    <!-- Your Profile Views Chart END-->
                </div>
            </div>
        </main>
        <div class="ttr-overlay"></div>

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
    </body>
</html>
