<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<!DOCTYPE html>
<html lang="en">
    <head>
        <!-- Required meta tags -->
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
        <title>View Feedback Teacher</title>
        <!-- base:css -->
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.11.2/css/all.css">
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.10.3/font/bootstrap-icons.css">
        <link rel="stylesheet" href="vendors/mdi/css/materialdesignicons.min.css">
        <link rel="stylesheet" href="vendors/base/vendor.bundle.base.css">
        <link rel="stylesheet" href="css/style.css">
        <link rel="stylesheet" href="css/stylebase.css">

        <!-- endinject -->
        <link rel="shortcut icon" href="images/logo.png" />
    </head>
    <body>
        <div class="container-scroller">

            <!--================Menu Information =================-->
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
                                <a href="teacherSchedule" class="nav-link">
                                    <i class="mdi mdi-calendar"></i>
                                    <span class="menu-title">Schedule</span>
                                    <i class="menu-arrow"></i>
                                </a>
                            </li>
                        </ul>
                    </div>
                </nav>
            </div>
            <!--================Menu Information =================--> 
            <!-- partial -->
            <div class="container-fluid page-body-wrapper">
                <div class="main-panel">
                    <div class="content-wrapper">
                        <div class="row d-flex justify-content-center">
                            <div class="col-sm-10 flex-column d-flex stretch-card">
                                <div class="row">
                                    <div class="col-lg-12 d-flex grid-margin stretch-card">
                                        <div class="card school-bg text-center">
                                            <div class="card-body">
                                                <h2 class="mt-3 text-title mb-3 font-weight-bold">
                                                    View Feedback Teacher
                                                </h2>
                                            </div>
                                        </div>
                                    </div>                                       
                                </div>
                                <div class="row">
                                    <div class="col-sm-12 grid-margin d-flex stretch-card">
                                        <div class="card">
                                            <div class="card-body">

                                                <div class="box-search d-flex justify-content-between mb-4">
                                                    <form class="search-bar d-flex justify-content-around">
                                                        <input type="text" placeholder="Search..." id="txtSearch_feedbackTeacher"/>
                                                        <a class="icon_Search"><i class="bi bi-search"></i></a>
                                                    </form>

                                                </div>
                                                <div class="table-responsive">
                                                    <table class="table table-striped" id="table_feedbackTeacher">
                                                        <thead>
                                                            <tr>
                                                                <th>
                                                                    STT
                                                                </th>
                                                                <th>
                                                                    Name of Teacher
                                                                </th>
                                                                <th>
                                                                    Rank
                                                                </th>
                                                                <th>
                                                                    Attitude
                                                                </th>
                                                                <th>
                                                                    Note
                                                                </th>
                                                                <th>
                                                                    Feedback Day
                                                                </th>

                                                            </tr>
                                                        </thead>
                                                        <tbody>
                                                            <c:set var="stt" value="0" />
                                                            <c:forEach items="${listFeedBackTeachers}" var="f">
                                                                <c:set var="stt" value="${stt + 1}"/>
                                                                <tr>
                                                                    <td>
                                                                        ${stt}
                                                                    </td>

                                                                    <td>
                                                                        ${f.teacherLastName} ${f.teacherFirstName}
                                                                    </td>
                                                                    <td>
                                                                        ${f.rank}
                                                                    </td>    
                                                                    <td>
                                                                        ${f.attitude}
                                                                    </td>    
                                                                    <td>
                                                                        ${f.note}
                                                                    </td>   
                                                                    <td>
                                                                        ${f.feedbackDay}
                                                                    </td> 

                                                                </tr>
                                                            </c:forEach>

                                                        </tbody>
                                                    </table>
                                                </div>
                                                <div class="content__paging col-12 d-flex justify-content-center">
                                                    <ul>
                                                        <c:if test="${numPage > 1}">
                                                            <li><a class="fas fa-angle-left" href="ListAllFeedbackTeacherAdmin?index=${numPage-1}"></a></li>
                                                            </c:if>

                                                        <div class="number-page" id="number-page">
                                                            <c:forEach begin="1" end="${endPageFeedBackTeacher}" var="i">
                                                                <li class="${numPage == i ? "active":""}"><a href="ListAllFeedbackTeacherAdmin?index=${i}">${i}</a></li>
                                                                </c:forEach>                                                           
                                                        </div>
                                                        <c:if test="${numPage < endPageFeedBackTeacher}">
                                                            <li><a class="fas fa-angle-right" href="ListAllFeedbackTeacherAdmin?index=${numPage+1}"></a></li>
                                                            </c:if>
                                                    </ul>
                                                </div>
                                            </div>
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
        <script src="vendors/progressbar.js/progressbar.min.js"></script>
        <script src="vendors/justgage/raphael-2.1.4.min.js"></script>
        <script src="vendors/justgage/justgage.js"></script>
        <script src="js/jquery.cookie.js" type="text/javascript"></script>

        <script src="js/search.js"></script>
        <script src="js/jsbase.js"></script>
        <script src="js/dashboard.js"></script>
    </body>
</html>