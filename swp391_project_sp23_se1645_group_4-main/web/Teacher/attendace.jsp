
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

    <head>
        <!-- Required meta tags -->
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
        <title>Check Attendance</title>
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
                                    <form action="checkAttendance" method="post" id="attendance">
                                        <div class="card-body">
                                            <h1 class="card-title">Attendance for student</h1>
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
                                                                Note
                                                            </th>
                                                            <th>
                                                                Attendance
                                                            </th>
                                                        </tr>
                                                    </thead>
                                                    <tbody>
                                                        <c:forEach items="${Attendance}" var="a">
                                                            <c:if test="${a.status == 0}">
                                                                <c:set var="description" value="0" />
                                                            </c:if>
                                                            <tr>
                                                                <td class="py-1">
                                                                    <img src="images/faces/${a.studentImg}" alt="image" />
                                                                    <input name="attendanceID" value="${a.attendanceID}" hidden>
                                                                    <input name="studentID" value="${a.studentID}" hidden>
                                                                    <br>
                                                                    ${a.studentFirstName}
                                                                </td>
                                                                <td>

                                                                    <c:if test="${a.gender == 1}">
                                                                        Male
                                                                    </c:if>
                                                                    <c:if test="${a.gender == 0}">
                                                                        Female
                                                                    </c:if>
                                                                </td>
                                                                <td>

                                                                    <c:if test="${a.status == 0}">
                                                                        <textarea name="note" type="text" maxlength="50"></textarea>
                                                                    </c:if>
                                                                    <c:if test="${a.status != 0}">  
                                                                        <textarea name="note" type="text" maxlength="50">${a.note}</textarea>
                                                                    </c:if>
                                                                </td>
                                                                <td>
                                                                    <select name="status">
                                                                        <option value="1" ${a.status == 1 ? '' : 'selected'}>Attended</option>
                                                                        <option value="2" ${a.status == 2 ? 'selected' : ''}>Absent</option>
                                                                    </select>
                                                                </td>
                                                            </tr>
                                                        </c:forEach>
                                                    </tbody>
                                                </table>
                                            </div>
                                            <c:if test="${description == 0}">
                                                <button class="btn btn-success" type="submit" style="margin-top: 50px;" onclick="return confirm('Do you want to save ?');">Save </button>
                                            </c:if>
                                            <c:if test="${description != 0}">
                                                <button class="btn btn-success" type="submit" style="margin-top: 50px;" onclick="return confirm('Do you want to edit ?');">Edit </button>
                                            </c:if>
                                        </div>
                                    </form>
                                </div>
                            </div>
                        </div>

                    </div>
                </div>

            </div>

        </div>
        <style>
            label {
                margin-bottom: 0;
            }

            /* Hide the checkboxes */
            input[type='checkbox'] {
                display: none;
            }

            /* Default styling for labels to make them look like buttons */
            input[type='checkbox']+label {
                display: inline-block;
                box-shadow: 1px 1px grey;
                background-color: #e0e0e0;
                padding: 0 40px;
                border-radius: 3px;
                font-family: Arial, Helvetica, sans-serif;
                cursor: pointer;
                margin-left: 16px;
                margin-top: 16px;
                margin-bottom: 16px;
            }

            /* Styling for labels when corresponding radio button is checked */
            input[type='checkbox']:checked+label {
                box-shadow: -1px -1px grey;
                background-color: #7fad39;
            }

            .modal-body p {
                margin: 0;
            }
        </style>
        <script src="vendors/base/vendor.bundle.base.js"></script>
        <script src="js/template.js"></script>
        <script>
            document.getElementById('attendance').addEventListener('submit', function () {
                alert('Save success');
            });
        </script>
    </body>

</html>
