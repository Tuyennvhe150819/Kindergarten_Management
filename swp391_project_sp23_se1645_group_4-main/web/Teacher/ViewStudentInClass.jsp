

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

<head>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <title>Student</title>
    <!-- base:css -->
    <link rel="stylesheet" href="vendors/mdi/css/materialdesignicons.min.css">
    <link rel="stylesheet" href="vendors/base/vendor.bundle.base.css">
    <!-- endinject -->
    <!-- plugin css for this page -->
    <!-- End plugin css for this page -->
    <!-- inject:css -->
    <link rel="stylesheet" href="css/style.css">
    <!-- endinject -->
    <link rel="shortcut icon" href="images/favicon.png" />
</head>

<body>
    <div class="container-scroller">
        <!-- partial:../../partials/_horizontal-navbar.html -->



        <div class="horizontal-menu">
                <nav class="navbar top-navbar col-lg-12 col-12 p-0">
                    <div class="container-fluid">
                        <div class="navbar-menu-wrapper d-flex align-items-center justify-content-between">
                            <ul class="navbar-nav navbar-nav-left">
                                <li class="nav-item ms-0 me-5 d-lg-flex d-none">
                                    <a href="#" class="nav-link horizontal-nav-left-menu"><i class="mdi mdi-format-list-bulleted"></i></a>
                                </li>
                            </ul>
                            <div class="text-center navbar-brand-wrapper d-flex align-items-center justify-content-center">
                                <a class="navbar-brand brand-logo" href="ViewTerm"><img src="images/logo.png" alt="logo"/></a>
                                <a class="navbar-brand brand-logo-mini" href="ViewTerm"><img src="images/logo-mini.svg" alt="logo"/></a>
                            </div>
                            <c:if test="${sessionScope.teach != null}">
                                <ul class="navbar-nav navbar-nav-right">
                                    <li class="nav-item nav-profile dropdown">
                                        <a class="nav-link dropdown-toggle" href="#" data-bs-toggle="dropdown" id="profileDropdown">
                                            <span class="nav-profile-name">${sessionScope.teach.teacherLastName}</span>
                                            <span class="online-status"></span>
                                            <img src="images/faces/${sessionScope.teach.teacherImg}" alt="profile"/>
                                        </a>
                                        <div class="dropdown-menu dropdown-menu-right navbar-dropdown" aria-labelledby="profileDropdown">
                                            <a class="dropdown-item" href="ViewProfileTeacher">
                                                <i class="mdi mdi-settings text-primary"></i>
                                                View Profile
                                            </a>
                                           <a class="dropdown-item" href="Change">
                                            <i class="mdi mdi-key-change"></i>
                                            Change Password
                                        </a>
                                            <a class="dropdown-item" href="listFeedBackTearch">
                                                <i class="mdi mdi-seal"></i>
                                                Your FeedBack
                                            </a>
                                            <a class="dropdown-item" href="Logout">
                                                <i class="mdi mdi-logout text-primary"></i>
                                                Logout
                                            </a>
                                        </div>
                                    </li>
                                </ul>
                            </c:if>
                            <c:if test="${sessionScope.teach == null}">
                            <ul class="navbar-nav navbar-nav-right">
                                <li class="nav-item nav-profile dropdown">
                                    <a class="nav-link dropdown-toggle" href="Login" id="profileDropdown">
                                        <span class="nav-profile-name">Login</span>
                                        <span class="online-status"></span>
                                        <img src="images/faces/" alt="profile"/>
                                    </a>
                                </li>
                            </ul>
                                    </c:if>
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
                                <a class="nav-link" href="ViewTerm">
                                    <i class="mdi mdi-file-document-box menu-icon"></i>
                                    <span class="menu-title">Dashboard</span>
                                </a>
                            </li>
                            <li class="nav-item">
                                <a href="ListClass" class="nav-link">
                                    <i class="mdi mdi-account-multiple"></i>
                                    <span class="menu-title">Class</span>
                                    <i class="menu-arrow"></i>
                                </a>
                            </li>

                            <li class="nav-item">
                                <a href="#" class="nav-link">
                                    <i class="mdi mdi-calendar"></i>
                                    <span class="menu-title">Schedule</span>
                                    <i class="menu-arrow"></i>
                                </a>
                            </li>
                        </ul>
                    </div>
                </nav>
            </div>



        <!-- partial -->
        <div class="container-fluid page-body-wrapper">
            <div class="main-panel">
                <div class="content-wrapper">
                    <div class="row">
                        <div class="col-lg-12 grid-margin stretch-card">
                            <div class="card">
                                <div class="card-body">
                                    <h4 class="card-title">Students</h4>
                                    <div class="table-responsive">
                                        <table class="table table-striped">
                                            <thead>
                                                <tr>
                                                    <th>
                                                        Name
                                                    </th>
                                                    <th>
                                                        Gender
                                                    </th>
                                                    <th>
                                                        Class
                                                    </th>
                                                    <th>
                                                        View
                                                    </th>
                                                </tr>
                                            </thead>
                                            <tbody>
                                                <c:forEach items="${listStudent}" var="s">
                                                <tr>
                                                    <td class="py-1" >
                                                        <img src="images/faces/${s.studentImg}" alt="image" /> <br>
                                                        ${s.studentFirstName} ${s.studentLastName} 
                                                    </td>
                                                    <td>
                                                        <c:if test="${s.gender == 1}">
                                                            Male
                                                        </c:if>
                                                        <c:if test="${s.gender == 0}">
                                                            Female
                                                        </c:if>
                                                    </td>
                                                    <td>
                                                        ${s.className}
                                                    </td>
                                                    <td>
                                                        <a type="button" class="btn btn-primary btn-icon-text" href="ViewFIStudent?studentID=${s.studentID}">
                                                            <i class="mdi mdi-eye btn-icon-prepend"></i>
                                                            View
                                                        </a>
                                                        <a type="button" class="btn btn-primary btn-icon-text" href="FeedBackStudent?studentID=${s.studentID}">
                                                            <i class="mdi mdi-seal"></i>
                                                            FeedBack
                                                        </a>
                                                    </td>
                                                </tr>
                                                </c:forEach>
                                            </tbody>
                                        </table>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>

                </div>
            </div>

        </div>

    </div>

    <script src="vendors/base/vendor.bundle.base.js"></script>
    <script src="js/template.js"></script>
</body>

</html>