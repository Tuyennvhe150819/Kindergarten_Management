
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

    <head>
        <!-- Required meta tags -->
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
        <title>Profile Student</title>
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
                            <div class="col-lg-12 grid-margin stretch-card">
                                <div class="card">
                                    <div class="card-body container">
                                        <div class="row">
                                            <div class="col-2" style="margin-top: 50px;">
                                                <img style="width: 100%;border-radius: 50%;"
                                                     src="images/faces/${st.studentImg}">
                                            </div>
                                            <div class="col-10" style="padding-left: 50px;">
                                                <h2 style="color: black;margin-top: 50px;margin-bottom: 30px;">Detail Student
                                                </h2>
                                                <div class="form-group">
                                                    <label>First Name: ${st.studentFirstName}</label>
                                                </div>
                                                <div class="form-group">
                                                    <label>Last Name: ${st.studentLastName}</label>
                                                </div>
                                                <div class="form-group">
                                                    <label>Like something: ${st.likeSomething}</label>
                                                </div>
                                                <div class="form-group">
                                                    <label>Hate something: ${st.hateSomething}</label>
                                                </div>
                                                <div class="form-group">
                                                    <label>Favorite Food: ${st.favoriteFood}</label>
                                                </div>
                                                <div class="form-group">
                                                    <label>Hate Food: ${st.hateFood}</label>
                                                </div>
                                                <div class="form-group">
                                                    <label>Brithday: ${st.birthdate}</label>
                                                </div>
                                                <div class="form-group row">
                                                    <label class="col-sm-12 col-form-label">Gender: 
                                                        <c:if test="${st.gender == 1}">
                                                            Male
                                                        </c:if>
                                                        <c:if test="${st.gender == 0}">
                                                            Female
                                                        </c:if>
                                                    </label>
                                                </div>
                                                <div class="form-group">
                                                    <label for="exampleSelectGender">Class: 
                                                        <a style="text-decoration: none" href="ViewClass?classID=${st.classID}">
                                                            ${st.className}
                                                        </a>
                                                    </label>
                                                </div>
                                                <div class="form-group">
                                                    <label for="exampleSelectGender">Teacher's Name: 
                                                        <a style="text-decoration: none" ${teacher.teacherID == class.tearchID} href="ViewInforTeacher?studentID=${st.studentID}">
                                                            ${teacher.teacherFirstName}
                                                        </a>
                                                    </label>
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
    </body>

</html>