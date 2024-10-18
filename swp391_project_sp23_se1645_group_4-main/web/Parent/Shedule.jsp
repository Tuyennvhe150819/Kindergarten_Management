<%-- 
    Document   : Shedule
    Created on : 16-02-2023, 22:42:10
    Author     : MSII
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

    <head>
        <meta charset="UTF-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="preconnect" href="https://fonts.googleapis.com">
        <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
        <link href="https://fonts.googleapis.com/css2?family=Capriola&display=swap" rel="stylesheet">
        <link rel="stylesheet" href="css/trangchu.css">
        <link rel="stylesheet" href="css/maps/iconInputImage.css">
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css">
        <script src="https://cdn.jsdelivr.net/npm/jquery@3.6.1/dist/jquery.slim.min.js"></script>
        <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/js/bootstrap.bundle.min.js"></script>
        <link rel="stylesheet" href="vendors/mdi/css/materialdesignicons.min.css">
        <title>Shedule</title>
    </head>

    <body style="background-color: #FAF5F2;">
        <!--Header-->
        <header class="header">
            <div class="header-inner">
                <div class="container-fluid px-lg-5">
                    <nav class="navbar navbar-expand-lg my-navbar">
                        <a class="navbar-brand" href="homePageController">
                            <img src="img/logo.png" class="img-fluid" style="width: 100px; margin: -3px 0px 0px 0px;">
                        </a>
                        <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent"
                                aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
                            <span class="navbar-toggler-icon">
                                <i class="fa-solid fa-bars" style="margin: 5px 0px 0px 0px;"></i>
                            </span>
                        </button>

                        <div class="collapse navbar-collapse" id="navbarSupportedContent">
                            <ul class="navbar-nav m-auto">
                                <li class="nav-item">
                                    <a class="nav-link" href="homePageController">Home <span class="sr-only">(current)</span></a>
                                </li>
                                <li class="nav-item">
                                    <a class="nav-link" href="event">Event</a>
                                </li>
                                <li class="nav-item">
                                    <a class="nav-link" href="NotificationController">Notification</a>
                                </li>
                                <li class="nav-item active">
                                    <a class="nav-link" href="viewStudentToSchedule">Schedule</a>
                                </li>
                            </ul>
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
                        </div>
                    </nav>
                </div>
            </div>
        </header>

        <section class="content-banner">
            <div class="row" style="padding: 0; margin: 0;">
                <div class="col-12" style="padding: 0; margin: 0;">
                    <div class="row" style="padding: 0; margin: 0;">
                        <div class="col-12 " style="padding: 0; margin: 0;">
                            <img style="width: 100%;" src="img/breadcrumb-contact.png">
                            <div style="position: absolute; top: 45%;left: 45%;">
                                <h1 style="color: #fff;font-weight: 600;">Schedule</h1>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </section>
        <div class="col-12">
            <div class="container">
                <div class="row">
                    <form action="shedule" method="post" id="shedule">
                        <div class="col-8">
                            <table style="width: 100%;margin: 100px 100px;margin-top: 10px;">
                                <thead style="background-color: #EB1551;color:white;">
                                <th style="padding: 20px 40px;">
                                    <input type="week" name="week" id="check">
                                    <span class="form-message" style="color: yellow">${error}</span> 
                                    <button type="submit">
                                        submit
                                    </button>
                                    <input name="studentId" value="${st.studentID}" hidden>
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
                                        <td class="text-center"
                                            style="border: 1px solid #EB1551;width: 100px;height: 100px;background-color: #EB1551;color:white;">Day</td>
                                        <c:forEach begin="1" end="7" step="1" var="day">
                                            <td style="border: 1px solid #EB1551;width: 100px;height: 100px;">
                                                <c:forEach items="${listA}" var="at">
                                                    <c:if test="${at.dateweek == day}">
                                                        <c:out value="${at.title}" />
                                                        <br>
                                                        <a href="ViewClass?classID=${at.classID}">
                                                            <h6>(at ${at.className})</h6> 
                                                        </a>
                                                        <c:if test="${at.status == 0}">
                                                            <h6 style="color: red">NOT YET</h6>
                                                        </c:if>
                                                        <c:if test="${at.status == 1}">
                                                            <h6 style="color: red">Absent</h6>
                                                        </c:if>  
                                                        <c:if test="${at.status == 2}">
                                                            <h6 style="color: green">Attended</h6>
                                                        </c:if>   
                                                    </c:if>
                                                </c:forEach>
                                            </td>
                                        </c:forEach>
                                    </tr>
                                </tbody>
                            </table>

                        </div>
                    </form>

                </div>
            </div>
        </div>
        <footer class="col-12" style="background-color: #EB1551;">
            <div class="row">
                <div class="col-5" style="border-right: 2px  dotted white; border-bottom: 2px  dotted white;">
                    <div class="col-12">
                        <div class="row">
                            <div class="col-6">
                                <img style="width: 100%;margin-top: 30px;" src="img/icon-baby-girl-diving.png">
                            </div>
                            <div class="col-6" style="color: white;">
                                <h3 style="margin-top: 100px;font-weight: 600;">Newsletter</h3>
                                <p style="margin-top: 20px;">Norem ipsum dolor sit amet, consectetur adipiscing elit, eiusm
                                </p>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="col-2" style="border-right: 2px  dotted white; border-bottom: 2px  dotted white;">
                    <img style="margin-top: 60%;margin-left: 30px;" src="img/logo.png">
                </div>
                <div class="col-5" style="border-bottom: 2px  dotted white; color: white;">
                    <div class="col-12">
                        <div class="row">
                            <div class="col-6" style="margin-top: 100px;padding-left: 50px;">
                                <h3 style="font-weight: 600;">Home</h3>
                                <h5>About</h5>
                                <h5>Blog</h5>
                                <h5>Contact</h5>
                            </div>
                            <div class="col-6 d-flex justify-content-center">
                                <img style="width: 80%;" class="col-12" src="img/draw_boy_img.png">
                            </div>
                        </div>
                    </div>
                </div>
                <div class="col-12 text-center">
                    <h5 style="padding: 20px 20px;color:white;">Copyright © 2023</h5>
                </div>
            </div>
        </footer>
        <!-- nav-->
        <script type="text/javascript">
            $(function () {
                var navbar = $('.header-inner');
                $(window).scroll(function () {
                    if ($(window).scrollTop() <= 40) {
                        navbar.removeClass('navbar-scroll');
                    } else {
                        navbar.addClass('navbar-scroll');
                    }
                });
            });
        </script>
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
        <script src="vendors/base/vendor.bundle.base.js"></script>
        <script src="js/template.js"></script>
    </body>

</html>