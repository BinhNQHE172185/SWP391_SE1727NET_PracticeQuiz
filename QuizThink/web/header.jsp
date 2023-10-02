<%@page import = "Model.Account" %>
<%@page import = "java.util.*" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<header class="header rs-nav header-transparent">
    <%
        Account acc = (Account) session.getAttribute("currUser");
        String username = "";
        Cookie[] cookies = request.getCookies();
    
        if (cookies != null) {
            for (Cookie cookie : cookies) {
                if (cookie.getName().equals("username")) {
                    username = cookie.getValue();
                    break;
            }
        }
    }
    %>
    <div class="top-bar">
        <div class="container">
            <div class="row d-flex justify-content-between">
                <div class="topbar-left">
                    <ul>
                        <li><a href="faq-1.html"><i class="fa fa-question-circle"></i>Ask a Question</a></li>
                        <li><a href="javascript:;"><i class="fa fa-envelope-o"></i>binhmebuncha978@gmail.com</a></li>
                    </ul>
                </div>
                <div class="topbar-right">
                    <ul>
                        <%if(!username.equals("")){%>
                        <li><a href="#"><%=username%></a></li>
                        <li><a href="#">Logout</a></li>
                            <%}else if(acc!=null){%>
                        <li><a href="#"><%=acc.getUsername()%></a></li>
                        <li><a href="#">Logout</a></li>
                            <%}else{%>
                        <li><a href="Login.jsp">Login</a></li>
                        <li><a href="Register.jsp">Register</a></li>
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
                        <ul>
                            <li><a href="https://www.facebook.com/DaihocFPTHaNoi" class="btn-link"><i class="fa fa-facebook"></i></a></li>
                            <li><a href="https://daihoc.fpt.edu.vn/" class="btn-link"><i class="fa fa-google-plus"></i></a></li>

                            <!-- Search Button ==== -->
                            <li class="search-btn"><button id="quik-search-btn" type="button" class="btn-link"><i class="fa fa-search"></i></button></li>
                        </ul>
                    </div>
                </div>
                <!-- Search Box ==== -->
                <div class="nav-search-bar">
                    <form action="#">
                        <input name="search" value="" type="text" class="form-control" placeholder="Type to search">
                        <span><i class="ti-search"></i></span>
                    </form>
                    <span id="search-remove"><i class="ti-close"></i></span>
                </div>
                <!-- Navigation Menu ==== -->
                <div class="menu-links navbar-collapse collapse justify-content-start" id="menuDropdown">
                    <div class="menu-logo">
                        <a href="home.jsp"><img src="FrontEnd/assets/images/logo.png" alt=""></a>
                    </div>
                    <ul class="nav navbar-nav">	
                        <li class="active"><a href="home.jsp">Home</a>

                        </li>

                        <li class="add-mega-menu"><a href="courses.jsp">Our Courses</a>

                        </li>
                        <li><a href="about.jsp">About us </a>

                        </li>

                    </ul>

                </div>
                <!-- Navigation Menu END ==== -->
            </div>
        </div>
    </div>
</header>
