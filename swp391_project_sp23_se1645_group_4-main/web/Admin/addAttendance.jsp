
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

    <head>
        <!-- Required meta tags -->
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
        <title>Admin</title>
        <!-- base:css -->
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.10.3/font/bootstrap-icons.css">
        <link rel="stylesheet" href="vendors/mdi/css/materialdesignicons.min.css">
        <link rel="stylesheet" href="vendors/base/vendor.bundle.base.css">
        <!-- endinject -->
        <!-- plugin css for this page -->
        <!-- End plugin css for this page -->
        <!-- inject:css -->
        <link rel="stylesheet" href="css/style.css">
        <link rel="stylesheet" href="css/maps/iconInputImage.css">
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
                                        <form action="addAttendance" method="POST" id="formNotification">
                                            <div class="card-body container">
                                                <div class="row">
                                                    <div class="col-10" style="padding-left: 50px;">
                                                        <h2 style="color: black;margin-top: 50px;margin-bottom: 30px;">Create schedule for attendance
                                                        </h2>
                                                        <div class="form-group">
                                                            <label>Title</label><span style="color: red">*</span>
                                                            <input name="title" type="text" required maxlength="20" class="form-control form-control-lg" id="subject"
                                                                   aria-label="subject">
                                                            <input value="${id}" name="cid" hidden>
                                                        <span class="form-message"></span>
                                                    </div>
                                                    <div class="form-group">
                                                        <label>Attendance Date</label><span style="color: red">*</span>
                                                        <input name="date" type="date" id="startDate"
                                                               class="form-control" id="exampleInputEmail3" placeholder="dd/mm/yyyy">
                                                        <span class="form-message"></span>
                                                    </div>
                                                    <div class="form-group row">
                                                        <div class="col-12" style="margin-top: 50px;margin-bottom: 50px;">
                                                            <button type="submit" class="btn btn-dark btn-icon-text" onclick="return confirm('Do you want to add ?');">
                                                                SAVE
                                                                <i class="mdi mdi-file-check btn-icon-append" ></i>
                                                            </button>
                                                        </div>
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
        <script src="js/Validate.js"></script>
        <script>
            Validator({
                form: "#formNotification",
                errorSelector: '.form-message',
                rules: [
                    Validator.isRequired('#subject', 'Title cannot be blank'),
                    Validator.isRequired('#startDate', 'Attendance Date cannot be blank')
                ]
            });
        </script>
        <script>
            document.getElementById('formNotification').addEventListener('submit', function () {
                alert('Success');
            });
        </script>
    </body>

</html>
