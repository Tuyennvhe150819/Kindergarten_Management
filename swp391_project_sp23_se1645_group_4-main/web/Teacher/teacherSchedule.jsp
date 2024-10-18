
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <!-- Required meta tags -->
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
        <title>Schedule</title>
        <!-- base:css -->

        <link rel="stylesheet" href="vendors/mdi/css/materialdesignicons.min.css">
        <link rel="stylesheet" href="vendors/base/vendor.bundle.base.css">
        <link rel="stylesheet" href="css/style.css">
        <link rel="stylesheet" href="css/maps/iconInputImage.css">
        <!-- endinject -->
        <link rel="shortcut icon" href="images/logo.png" />
    </head>
    <body>
        <div class="container-scroller">

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
            <!-- partial -->
            <div class="container-fluid page-body-wrapper">
                <div class="main-panel">
                    <div class="content-wrapper">
                        <div class="row">
                            <div class="col-sm-8 flex-column d-flex stretch-card">
                                
                                <div class="row">
                                    <div class="col-sm-12 grid-margin d-flex stretch-card">
                                        <div class="card">
                                            <form action="teacherSchedule" method="post" id="shedule">
                                                <div class="card-body">
                                                    <h4 class="card-title">Schedule</h4>
                                                    <div class="table-responsive">
                                                        <table class="table table-striped">
                                                            <thead style="background-color: blue;color:white;">
                                                            <th>
                                                                <input type="week" name="week" id="check">
                                                                <span class="form-message"></span>
                                                                <button class="btn btn-dark btn-icon-text" type="submit">
                                                                    submit
                                                                </button>
                                                            </th>
                                                            <th style="padding: 20px 40px;">Sun</th>
                                                            <th style="padding: 20px 40px;">Mon</th>
                                                            <th style="padding: 20px 40px;">Tues</th>
                                                            <th style="padding: 20px 40px;">Wed</th>
                                                            <th style="padding: 20px 40px;">Thu</th>
                                                            <th style="padding: 20px 40px;">Fri</th>
                                                            <th style="padding: 20px 40px;">Sat</th>
                                                            </thead>
                                                            <tbody>
                                                                <tr>
                                                                    <jsp:useBean id="now" class="java.util.Date"/>
                                                                    <fmt:formatDate var="datenow" value="${now}" pattern="yyyy-MM-dd"/>
                                                                    <td class="text-center"
                                                                        style="border: 1px solid black;width: 100px;height: 100px;background-color: white;color:black;">Subject</td>
                                                                    <c:forEach begin="1" end="7" step="1" var="day">
                                                                        <td style="border: 1px solid black;width: 100px;height: 100px;">
                                                                            <c:forEach items="${listA}" var="at">
                                                                                <c:if test="${at.dateweek == day}">
                                                                                    <c:out value="${at.title}" />
                                                                                    <c:if test="${at.status == 0}">
                                                                                        <h6 style="color: red">NOT YET</h6>
                                                                                    </c:if>
                                                                                    <c:if test="${at.status != 0}">
                                                                                        <h6 style="color: green">Done</h6>
                                                                                    </c:if>
                                                                                    <c:if test="${at.attendanceDate == datenow}">
                                                                                        <a type="button" class="btn btn-primary btn-icon-text" href="checkAttendance?classID=${at.classID}" style="text-decoration: none">
                                                                                            ${at.className}
                                                                                        </a>
                                                                                    </c:if>
                                                                                    <c:if test="${at.attendanceDate < datenow}">
                                                                                        <a type="button" class="btn btn-primary btn-icon-text" href="viewAttendance?classID=${at.classID}&date=${at.attendanceDate}" style="text-decoration: none">
                                                                                            ${at.className}
                                                                                        </a>
                                                                                    </c:if>
                                                                                </c:if>
                                                                            </c:forEach>
                                                                        </td>
                                                                    </c:forEach>
                                                                </tr>
                                                            </tbody>
                                                        </table>
                                                    </div>
                                                </div>
                                            </form>
                                        </div>
                                    </div>
                                </div>
                            </div>
                            <div class="col-lg-4 mb-3 mb-lg-0">
                                <div class="card congratulation-bg text-center">
                                    <div class="card-body pb-0">
                                        <img src="images/faces/${sessionScope.teach.teacherImg}" alt="">
                                        <h2 class="mt-3 text-white mb-3 font-weight-bold">Congratulations 
                                            <br>
                                            ${sessionScope.teach.teacherFirstName}
                                        </h2>
                                        <p>Welcome to School
                                        </p>
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

        <script src="js/dashboard.js"></script>
        <script src="js/Validate.js"></script>
        <script>
            Validator({
                form: "#shedule",
                errorSelector: '.form-message',
                rules: [
                    Validator.isRequired('#check', 'Can not is empty'),
                ]
            });
        </script>
    </body>
</html>
