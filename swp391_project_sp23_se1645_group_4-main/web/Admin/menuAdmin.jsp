<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<div class="horizontal-menu">
    <nav class="navbar top-navbar col-lg-12 col-12 p-0">
        <div class="container-fluid">
            <div class="navbar-menu-wrapper d-flex align-items-center justify-content-between">
                <ul class="navbar-nav navbar-nav-left">
                </ul>
                <div class="text-center navbar-brand-wrapper d-flex align-items-center justify-content-center">
                    <a class="navbar-brand brand-logo" href="dashboard"><img src="images/logo.svg" alt="logo"/></a>
                    <a class="navbar-brand brand-logo-mini" href="dashboard"><img src="images/logo-mini.svg" alt="logo"/></a>
                </div>
                <ul class="navbar-nav navbar-nav-right">
                    <li class="nav-item nav-profile dropdown">
                        <a class="nav-link dropdown-toggle" href="#" data-bs-toggle="dropdown" id="profileDropdown">
                            <span class="nav-profile-name">ADMIN</span>
                            <span class="online-status"></span>
                            <img src="images/faces/face28.png" alt="profile"/>
                        </a>
                        <div class="dropdown-menu dropdown-menu-right navbar-dropdown" aria-labelledby="profileDropdown">
                            <a class="dropdown-item" href="Logout">
                                <i class="mdi mdi-logout text-primary"></i>
                                Logout
                            </a>
                            <a class="dropdown-item" href="changePass">
                                <i class="mdi mdi-key-change"></i>
                                Change Password
                            </a>
                        </div>
                    </li>
                </ul>
                <button class="navbar-toggler navbar-toggler-right d-lg-none align-self-center" type="button" data-toggle="horizontal-menu-toggle">
                    <span class="mdi mdi-menu"></span>
                </button>
            </div>
        </div>
    </nav>
    <nav class="bottom-navbar">
        <div class="container">
            <ul class="nav page-navigation">
                <li class="nav-item">
                    <a class="nav-link" href="dashboard">
                        <i class="mdi mdi-file-document-box menu-icon"></i>
                        <span class="menu-title">Dashboard</span>
                    </a>
                </li>
                <li class="nav-item">
                    <a href="listN" class="nav-link">
                        <i class="mdi mdi-notification-clear-all menu-icon"></i>
                        <span class="menu-title">Notification</span>
                    </a>
                </li>
                <li class="nav-item">
                    <a href="ListAllEventAdmin" class="nav-link">
                        <i class="mdi mdi-eventbrite menu-icon"></i>
                        <span class="menu-title">Event</span>
                    </a>
                </li>
                <li class="nav-item">
                    <a href="ListAllParentAdmin" class="nav-link">
                        <i class="mdi mdi-account menu-icon"></i>
                        <span class="menu-title">Parent</span>
                    </a>
                </li>
                <li class="nav-item">
                    <a href="ListAllTeacherAdmin" class="nav-link">
                        <i class="mdi mdi-account menu-icon"></i>
                        <span class="menu-title">Teacher</span>
                    </a>
                </li>
                <li class="nav-item">
                    <a href="ListAllStudentAdmin" class="nav-link">
                        <i class="mdi mdi-account menu-icon"></i>
                        <span class="menu-title">Student</span>
                    </a>
                </li>
                <li class="nav-item">
                    <a href="ListAllClassAdmin" class="nav-link">
                        <i class="mdi mdi-google-classroom menu-icon"></i>
                        <span class="menu-title">Class</span>
                    </a>
                </li>
                <li class="nav-item">
                    <a href="ListAllTermAD" class="nav-link">
                        <i class="mdi mdi-account menu-icon"></i>
                        <span class="menu-title">Term</span>
                    </a>
                </li>
                <li class="nav-item">
                    <a href="ListAllAccountAD" class="nav-link">
                        <i class="mdi mdi-account menu-icon"></i>
                        <span class="menu-title">Account</span>
                    </a>
                </li>
                <li class="nav-item">
                    <a href="ListAllFeedbackStudentAdmin" class="nav-link">
                        <i class="mdi mdi-account menu-icon"></i>
                        <span class="menu-title">Feedback Student</span>
                    </a>
                </li>
            </ul>
        </div>
    </nav>
</div>