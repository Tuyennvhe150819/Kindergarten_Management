
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

    <head>
        <!-- Required meta tags -->
        <meta charset="utf-8">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"> 
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
        <title>Profile Teacher</title>
        <!-- base:css -->
        <link rel="stylesheet" href="vendors/mdi/css/materialdesignicons.min.css">
        <link rel="stylesheet" href="vendors/base/vendor.bundle.base.css">
        <!-- endinject -->
        <!-- plugin css for this page -->
        <!-- End plugin css for this page -->
        <!-- inject:css -->
        <link rel="stylesheet" href="css/maps/iconInputImage.css">
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
                            <div class="col-lg-12 grid-margin stretch-card">
                                <div class="card">
                                    <div class="card-body container">
                                        <form action="updateProfileTeach" method="post" id="formTeacher">
                                        <div class="row">
                                            <div class="col-2" style="margin-top: 50px;">
                                                <img style="width: 100%;border-radius: 50%;"
                                                     src="images/faces/${sessionScope.teach.teacherImg}">
                                                <input value="${sessionScope.teach.teacherImg}" name="img" class="mdi mdi-upload btn-icon-prepend" id="imageFile" type="file"
                                                       required accept="image/gif, image/jpeg, image/jpg, image/png" onchange="chooseFile(this)">

                                            </div>
                                            <div class="col-10" style="padding-left: 50px;">
                                                <h2 style="color: black;margin-top: 50px;margin-bottom: 30px;">Detail Teacher
                                                </h2>
                                                <div class="form-group">
                                                    <label>First Name</label>
                                                    <input name="firstname" type="text" class="form-control form-control-lg" id="firstName"
                                                           placeholder="Username" aria-label="Username" value="${sessionScope.teach.teacherFirstName}">
                                                    <span class="form-message"></span>
                                                </div>
                                                <div class="form-group">
                                                    <label>Last Name</label>
                                                    <input name="lastname" type="text" class="form-control form-control-lg" id="lastName"
                                                           placeholder="Username" aria-label="Username" value="${sessionScope.teach.teacherLastName}">
                                                    <span class="form-message"></span>
                                                </div>
                                                <div class="form-group">
                                                    <label>Phone</label>
                                                    <input name="phone" type="number" class="form-control form-control-lg" id="phone"
                                                           placeholder="Username" aria-label="Phone" value="${sessionScope.teach.phone}">
                                                    <span class="form-message"></span>
                                                </div>
                                                <div class="form-group">
                                                    <label>Brithday</label>
                                                    <input name="date" type="date" class="form-control form-control-lg" id="birth"
                                                           placeholder="Username" aria-label="Username" value="${sessionScope.teach.birthdate}">
                                                    <span class="form-message"></span>
                                                </div>
                                                <div class="form-group">
                                                    <label>Address</label>
                                                    <input name="address" type="text" class="form-control form-control-lg" id="address"
                                                           placeholder="Username" aria-label="Username" value="${sessionScope.teach.address}">
                                                    <span class="form-message"></span>
                                                </div>
                                                <div class="form-group">
                                                    <label>year Of EXp</label>
                                                    <input type="text" class="form-control form-control-lg"
                                                           placeholder="Username" aria-label="Username" value="${sessionScope.teach.yearOfEXp}" readonly>
                                                </div>
                                                <div class="form-group">
                                                    <label>Salary</label>
                                                    <input type="text" class="form-control form-control-lg"
                                                           placeholder="Username" aria-label="Username" value="${sessionScope.teach.salaryFixed}" readonly>
                                                </div>
                                                <div class="form-group row">
                                                    <label class="col-sm-12 col-form-label">Gender</label>
                                                    <div class="col-sm-4">
                                                        <div class="form-check">
                                                            <label class="form-check-label">
                                                                <c:if test="${sessionScope.teach.gender == 1}">
                                                                    Male
                                                                </c:if>
                                                                <c:if test="${sessionScope.teach.gender == 0}">
                                                                    Female
                                                                </c:if>
                                                            </label>
                                                        </div>
                                                    </div>
                                                    <div class="col-12" style="margin-top: 50px;margin-bottom: 50px;">
                                                        <button type="submit" class="btn btn-dark btn-icon-text">
                                                            Edit
                                                            <i class="mdi mdi-file-check btn-icon-append"></i>
                                                        </button>
                                                    </div>
                                                </div>
                                            </div>
                                        </div>
                                                </form>
                                    </div>
                                </div>
                            </div>
                        </div>

                    </div>
                </div>

            </div>

        </div>
        <script>
            function chooseFile(fileInput) {
                if (fileInput.files && fileInput.files[0]) {
                    var reader = new FileReader();

                    reader.onload = function (e) {
                        $('#image').attr('src', e.target.result);
                    }
                    reader.readAsDataURL(fileInput.files[0])
                }
            }
        </script>
        <script src="vendors/base/vendor.bundle.base.js"></script>
        <script src="js/template.js"></script>
        <script src="js/Validate.js"></script>
    <script>
        Validator({
            form: "#formTeacher",
            errorSelector: '.form-message',
            rules: [
                Validator.isRequired('#firstName', 'First Name of Teacher cannot be blank'),
                Validator.isRequired('#lastName', 'Last Name of Teacher cannot be blank'),
                Validator.isRequired('#phone', 'Phone of Teacher cannot be blank'),
                Validator.isPhone('#phone',10),
                Validator.isRequired('#birth', 'Birthday of Teacher cannot be blank'),
                Validator.isRequired('#address', 'Address of Teacher cannot be blank')
            ]
        });
    </script>
    <script>
            document.getElementById('formTeacher').addEventListener('submit', function () {
                alert('Success');
            });
        </script>
    </body>

</html>
