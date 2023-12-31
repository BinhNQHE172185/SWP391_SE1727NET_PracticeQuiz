<%@page import = "Model.Account" %>
<%@page import = "Model.Expert" %>
<%@page import = "DAO.*" %>
<%@page import = "java.util.*" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<style>
    /* Style for the dropdown container */
    .dropdown {
        position: relative;
        display: inline-block;
    }

    /* Style for the button to toggle the dropdown */
    .dropdown-button {
        background-color: transparent;
        color: #fff;
        border: 2px solid #fff; /* Đặt viền màu trắng với độ rộng 2px */
        padding: 10px;
        cursor: pointer;
        transition: background-color 0.3s; /* Thêm hiệu ứng chuyển đổi cho background-color */
    }

    .dropdown-button:hover {
        background-color: rgb(255, 191, 0); /* Màu nền khi di chuột vào */
    }

    /* Style for the dropdown content */
    .dropdown-content {
        display: none;
        position: absolute;
        background-color: #f1f1f1;
        min-width: 160px;
        box-shadow: 0px 8px 16px 0px rgba(0,0,0,0.2);
        z-index: 1;
    }

    /* Style for individual dropdown items */
    .dropdown-content a {
        color: #333;
        padding: 12px 16px;
        text-decoration: none;
        display: block;
    }

    /* Change color on hover */
    .dropdown-content a:hover {
        background-color: #ddd;
    }

    /* Show the dropdown when hovering over the container */
    .dropdown:hover .dropdown-content {
        display: block;
    }
</style>
<header class="header rs-nav header-transparent">
    <%
        Account acc = (Account) session.getAttribute("currUser");
        Expert ex = (Expert) session.getAttribute("currExpert");
        AccountDAO ad = new AccountDAO();
    %>
    <div class="top-bar">
        <div class="container">
            <div class="row d-flex justify-content-between">
                <div class="topbar-left">
                    <ul>

                        <li><a href="javascript:;"><i class="fa fa-envelope-o"></i>binhmebuncha978@gmail.com</a></li>
                    </ul>
                </div>
                <div class="topbar-right">
                    <ul>
                        <% if(acc!=null){%>
                        <li><a href="#">Welcome <%=acc.getUsername()%></a></li>
                        <li><a href="Logout">Logout</a></li>
                            <%}else if(ex!=null){%>
                        <li><a href="#">Welcome <%=ex.getUsername()%></a></li>
                        <li><a href="Logout">Logout</a></li>
                            <%}else{%>
                        <li><a href="Login">Login</a></li>
                        <li><a href="RegisterUser">Register</a></li>
                            <%}%>
                    </ul>
                </div>

            </div>
        </div>
    </div>
    <div class="sticky-header navbar-expand-lg">
        <div class="menu-bar clearfix">
            <div class="container clearfix">
                <!-- Header Logo ==== -->
                <div class="menu-logo">
                    <a href="home.jsp"><img src="FrontEnd/assets/images/Logo2.png" alt=""></a>
                </div>
                <!-- Mobile Nav Button ==== -->
                <button class="navbar-toggler collapsed menuicon justify-content-end" type="button" data-toggle="collapse" data-target="#menuDropdown" aria-controls="menuDropdown" aria-expanded="false" aria-label="Toggle navigation">
                    <span></span>
                    <span></span>
                    <span></span>
                </button>
                <!-- Author Nav ==== -->
                <div class="secondary-menu">
                    <div class="secondary-inner">

                        <% if(acc!=null){%>
                        <div class="dropdown">
                            <button class="dropdown-button"><%=acc.getUsername()%></button>
                            <div class="dropdown-content">
                                <a href="Profile">My profile</a>
                                <a href="YourSubject">My courses</a>
                                <% if(acc != null && ad.checkRole(acc.getAccountId()) == 3) { %>
                                    <a href="userlists">Management</a>
                                <% } %>
                            </div>
                        </div>
                        <%}else if(ex!=null){%>
                        <div class="dropdown">
                            <button class="dropdown-button"><%=ex.getUsername()%></button>
                            <div class="dropdown-content">
                                <a href="ExpertProfile">My profile</a>
                                <a href="ExpertSubjectList ">My courses</a>

                            </div>
                        </div>
                        <%}%>
                        <ul>
                            <li><a href="https://www.facebook.com/DaihocFPTHaNoi" class="btn-link"><i class="fa fa-facebook"></i></a></li>
                            <li><a href="https://daihoc.fpt.edu.vn/" class="btn-link"><i class="fa fa-google-plus"></i></a></li>

                            <!-- Search Button ==== -->
                            <!--                            <li class="search-btn"><button id="quik-search-btn" type="button" class="btn-link"><i class="fa fa-search"></i></button></li>-->
                        </ul>
                    </div>
                </div>
                <!-- Search Box ==== -->

                <!-- Navigation Menu ==== -->
                <div class="menu-links navbar-collapse collapse justify-content-start" id="menuDropdown">
                    <div class="menu-logo">
                        <a href="home"><img src="FrontEnd/assets/images/logo.png" alt=""></a>
                    </div>
                    <ul class="nav navbar-nav">	
                        <li class="active"><a href="home">Home</a>

                        </li>

                        <li class="add-mega-menu"><a href="SubjectList">Our Courses</a>

                        </li>
                        <li><a href="Aboutus">About us </a>

                        </li>
                        <% if(acc != null && ad.checkRole(acc.getAccountId()) == 1) { %>
                        <!-- User is logged in and has role 1 (premium) -->
                        <li><a href="MembershipPage">Upgrade Premium</a></li>
                            <% } else if (acc == null && ex == null) { %>
                        <!-- User is not logged in -->
                        <li><a href="Login">Upgrade Premium</a></li>
                        <!-- Add more logic or links as needed for non-logged-in users -->
                        <% } %>
                    </ul>

                </div>
                <!-- Navigation Menu END ==== -->
            </div>
        </div>
    </div>
</header>
