<%-- 
    Document   : Left_Sidebar_Menu
    Created on : Oct 27, 2023, 4:17:52 PM
    Author     : minhk
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<!-- Left sidebar menu start -->
<div class="ttr-sidebar">
    <div class="ttr-sidebar-wrapper content-scroll">
        <!-- side menu logo start -->
        <div class="ttr-sidebar-logo">
            <a href="#"><img alt="" src="admin/assets/images/logo.png" width="122" height="27"></a>
            <!-- <div class="ttr-sidebar-pin-button" title="Pin/Unpin Menu">
                    <i class="material-icons ttr-fixed-icon">gps_fixed</i>
                    <i class="material-icons ttr-not-fixed-icon">gps_not_fixed</i>
            </div> -->
            <div class="ttr-sidebar-toggle-button">
                <i class="ti-arrow-left"></i>
            </div>
        </div>
        <!-- side menu logo end -->
        <!-- sidebar menu start -->
        <nav class="ttr-sidebar-navi">
            <ul>
                <li>
                    <a href="ListCustomerServlet" class="ttr-material-button">
                        <span class="ttr-icon"><i class="ti-home"></i></span>
                        <span class="ttr-label">Customers</span>
                    </a>
                </li>
                <li>
                    <a href="ManageSliders.jsp" class="ttr-material-button">
                        <span class="ttr-icon"><i class="ti-book"></i></span>
                        <span class="ttr-label">Sliders</span>
                    </a>
                </li>


                <li>
                    <a href="bookmark.html" class="ttr-material-button">
                        <span class="ttr-icon"><i class="ti-bookmark-alt"></i></span>
                        <span class="ttr-label">Add new Slider</span>
                    </a>
                </li>
                <li>
                    <a href="review.html" class="ttr-material-button">
                        <span class="ttr-icon"><i class="ti-comments"></i></span>
                        <span class="ttr-label">Edit</span>
                    </a>
                </li>
                <!--                        <li>
                                            <a href="add-listing.html" class="ttr-material-button">
                                                <span class="ttr-icon"><i class="ti-layout-accordion-list"></i></span>
                                                <span class="ttr-label">Add listing</span>
                                            </a>
                                        </li>-->
                <li class="ttr-seperate"></li>
            </ul>
            <!-- sidebar menu end -->
        </nav>
        <!-- sidebar menu end -->
    </div>
</div>
<!-- Left sidebar menu end -->