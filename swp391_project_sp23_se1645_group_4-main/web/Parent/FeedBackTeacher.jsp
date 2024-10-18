<%-- 
    Document   : FeedBackStudent
    Created on : 15-02-2023, 20:29:38
    Author     : MSII
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

    <head>
        <!-- Required meta tags -->
        <meta charset="utf-8">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"> 
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
        <title>Feed Back Teacher</title>
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
                                    <a href="#" class="nav-link horizontal-nav-left-menu"><i
                                            class="mdi mdi-format-list-bulleted"></i></a>
                                </li>
                            </ul>
                            <div class="text-center navbar-brand-wrapper d-flex align-items-center justify-content-center">
                                <a class="navbar-brand brand-logo" href="homePageController"><img src="img/logo.png"
                                                                                                  alt="logo" /></a>
                            </div>
                            <c:if test="${sessionScope.parent != null}">
                                <ul class="navbar-nav navbar-nav-right">
                                    <li class="nav-item nav-profile dropdown">
                                        <a class="nav-link dropdown-toggle" href="#" data-bs-toggle="dropdown"
                                           id="profileDropdown">
                                            <span class="nav-profile-name">${sessionScope.parent.parentLastName}</span>
                                            <span class="online-status"></span>
                                            <img src="images/faces/${sessionScope.parent.parentImage}" alt="profile" style="width: 40px; border-radius: 50%"/>
                                        </a>
                                        <div class="dropdown-menu dropdown-menu-right navbar-dropdown"
                                             aria-labelledby="profileDropdown">
                                            <a class="dropdown-item" href="viewProfileParent">
                                                <i class="mdi mdi-account-circle"></i>
                                                View Profile
                                            </a>
                                            <a class="dropdown-item" href="ListStudent?parentID=${sessionScope.parent.parentID}">
                                                <i class="mdi mdi-human-child"></i>
                                                View Profile child
                                            </a>
                                            <a class="dropdown-item" href="Change">
                                                <i class="mdi mdi-key-change"></i>
                                                Change Password
                                            </a>
                                            <a class="dropdown-item" href="Logout">
                                                <i class="mdi mdi-logout text-primary"></i>
                                                Logout
                                            </a>
                                        </div>
                                    </li>
                                </ul>
                            </c:if>      
                            <c:if test="${sessionScope.parent == null}">
                                <ul class="navbar-nav navbar-nav-right">
                                    <li class="nav-item nav-profile dropdown">
                                        <a class="nav-link dropdown-toggle" href="Login"
                                           id="profileDropdown">
                                            <span class="nav-profile-name">Login</span>
                                            <span class="online-status"></span>
                                            <img src="images/faces/face28.png" alt="profile" />
                                        </a>
                                    </li>
                                </ul>
                            </c:if> 
                            <button class="navbar-toggler navbar-toggler-right d-lg-none align-self-center" type="button"
                                    data-toggle="horizontal-menu-toggle">
                                <span class="mdi mdi-menu"></span>
                            </button>
                        </div>
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
                                    <div class="col-lg-4 d-flex grid-margin stretch-card">
                                        <div class="card sale-diffrence-border">
                                            <div class="card-body">
                                                <h2 class="text-dark mb-2 font-weight-bold">6475+</h2>
                                                <h4 class="card-title mb-2">Class</h4>
                                                <small class="text-muted">APRIL 2023</small>
                                            </div>
                                        </div>
                                    </div>
                                    <div class="col-lg-4 d-flex grid-margin stretch-card">
                                        <div class="card sale-diffrence-border">
                                            <div class="card-body">
                                                <h2 class="text-dark mb-2 font-weight-bold">6475+</h2>
                                                <h4 class="card-title mb-2">Term</h4>
                                                <small class="text-muted">APRIL 2023</small>
                                            </div>
                                        </div>
                                    </div>
                                    <div class="col-lg-4 d-flex grid-margin stretch-card">
                                        <div class="card sale-visit-statistics-border">
                                            <div class="card-body">
                                                <h2 class="text-dark mb-2 font-weight-bold">3479+</h2>
                                                <h4 class="card-title mb-2">Student</h4>
                                                <small class="text-muted">APRIL 2023</small>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                                <form action="FeedBackTeacher" method="post" id="feedbacks">
                                    <div class="row">
                                        <div class="col-sm-12 grid-margin d-flex stretch-card">
                                            <div class="card">
                                                <div class="card-body">
                                                    <h4 class="card-title">Feed back Teacher</h4>
                                                    <div class="form-group">
                                                        <label>Teacher Name : </label>
                                                        <img src="images/faces/${teach.teacherImg}" alt="image" />
                                                        <input type="text" class="form-control form-control-lg"
                                                               value="${teach.teacherFirstName}" aria-label="Username" readonly>
                                                        <input name="teacherID" value="${teach.teacherID}" hidden>
                                                        <input name="classID" value="${feedback.classID}" hidden>
                                                    </div>
                                                    <div class="form-group">
                                                        <label>Teacher assessment</label>
                                                        <c:if test="${feedback.teacherID == null}">
                                                            <textarea name="assessment" class="form-control" placeholder="Assessment" id="assessment"></textarea>
                                                            <span class="form-message"></span>
                                                        </c:if>
                                                        <c:if test="${feedback.teacherID != null}">
                                                            <textarea name="assessment" class="form-control" placeholder="Assessment" id="assessment">${feedback.note}</textarea>	
                                                            <span class="form-message"></span>
                                                        </c:if>
                                                    </div>
                                                    <div class="form-group">
                                                        <label>Teacher attitude</label>
                                                        <c:if test="${feedback.teacherID == null}">
                                                            <textarea name="attitude" class="form-control" placeholder="Attitude" id="attitude"></textarea>	
                                                            <span class="form-message"></span>
                                                        </c:if>
                                                        <c:if test="${feedback.teacherID != null}">
                                                            <textarea name="attitude" class="form-control" placeholder="Attitude" id="attitude">${feedback.attitude}</textarea>
                                                            <span class="form-message"></span>
                                                        </c:if>
                                                    </div>
                                                    <div class="form-group">
                                                        <label>Teacher ratings</label>
                                                        <c:if test="${feedback.teacherID == null}">
                                                            <select name="rating" id="" class="form-control">
                                                                <option value="1">Very Good</option>
                                                                <option value="2">Good</option>
                                                                <option value="3">Bad</option>
                                                            </select>
                                                        </c:if>
                                                        <c:if test="${feedback.teacherID != null}">
                                                            <select name="rating" id="" class="form-control">
                                                                <option value="1" ${feedback.rank eq 1 ? '' : 'selected'}>Very Good</option>
                                                                <option value="2" ${feedback.rank eq 2 ? 'selected' : ''}>Good</option>
                                                                <option value="3" ${feedback.rank eq 3 ? 'selected' : ''}>Bad</option>
                                                            </select>
                                                        </c:if>
                                                    </div>
                                                    <c:if test="${feedback.teacherID == null}">
                                                        <button type="submit" class="btn btn-dark btn-icon-text">
                                                            Save
                                                            <i class="mdi mdi-file-check btn-icon-append"></i>
                                                        </button>
                                                    </c:if>
                                                    <c:if test="${feedback.teacherID != null}">
                                                        <button type="submit" class="btn btn-dark btn-icon-text">
                                                            Edit
                                                            <i class="mdi mdi-file-check btn-icon-append"></i>
                                                        </button>
                                                    </c:if>
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                </form>
                            </div>
                            <div class="col-lg-4 mb-3 mb-lg-0">
                                <div class="card congratulation-bg text-center">
                                    <div class="card-body pb-0">
                                        <img src="images/faces/${sessionScope.teach.teacherImg}" alt="">
                                        <h2 class="mt-3 text-white mb-3 font-weight-bold">Congratulations
                                            <br>
                                            ${sessionScope.parent.parentFirstName} ${sessionScope.parent.parentLastName}
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
                form: "#feedbacks",
                errorSelector: '.form-message',
                rules: [
                    Validator.isRequired('#assessment', 'assessment cannot be blank'),
                    Validator.isRequired('#attitude', 'attitude cannot be blank')
                ]
            });
        </script>
        <script>
            document.getElementById('feedbacks').addEventListener('submit', function () {
                alert('Success');
            });
        </script>
    </body>

</html>