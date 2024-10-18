
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

    <head>
        <!-- Required meta tags -->
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
        <title>Kapella Bootstrap Admin Dashboard Template</title>
        <!-- base:css -->
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.10.3/font/bootstrap-icons.css">
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
            <!--================Menu Information =================-->
            <jsp:include page="menuAdmin.jsp"></jsp:include>
                <!--================Menu Information =================--> 
                <!-- partial -->
                <div class="container-fluid page-body-wrapper">
                    <div class="main-panel">
                        <div class="content-wrapper">
                            <div class="row">
                                <div class="col-lg-12 grid-margin stretch-card">
                                    <div class="card">
                                        <form action="UPNotificationAD" method="POST">
                                            <div class="card-body container">
                                                <div class="row">
                                                    <div class="imageBox col-2" style="margin-top: 50px;">
                                                        <img style="width: 100%;border-radius: 50%;"
                                                             src="images/faces/${viewInfoTeacher.teacherImg}">

                                                </div>
                                                <div class="col-10" style="padding-left: 50px;">
                                                    <h2 style="color: black;margin-top: 50px;margin-bottom: 30px;">Detail Teacher
                                                    </h2>
                                                    <div class="form-group">
                                                        <label>Name</label>
                                                        <p class="form-control form-control-lg">
                                                            ${viewInfoTeacher.teacherLastName} ${viewInfoTeacher.teacherFirstName}
                                                        </p>
                                                    </div>
                                                    <div class="form-group">
                                                        <label>Phone</label>
                                                        <p class="form-control form-control-lg">${viewInfoTeacher.phone}</p>
                                                    </div>
                                                    <div class="form-group">
                                                        <label>Gender</label>
                                                        <p class="form-control form-control-lg">
                                                            <c:if test="${viewInfoTeacher.gender == 1}">
                                                                Male
                                                            </c:if>
                                                            <c:if test="${viewInfoTeacher.gender == 0}">
                                                                Female
                                                            </c:if>
                                                        </p>
                                                    </div>
                                                    <div class="form-group">
                                                        <label>Address</label>
                                                        <p class="form-control form-control-lg">${viewInfoTeacher.address}</p>
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
        <script src="vendors/base/vendor.bundle.base.js"></script>
        <script src="js/template.js"></script>
    </body>

</html>
