
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
                                        <form action="CreateEventAdmin" method="POST" id="formEvent">
                                            <div class="card-body container">
                                                <div class="row">
                                                    <div class="imageBox col-2" style="margin-top: 50px;">
                                                        <img style="width: 100%;border-radius: 50%;"
                                                             src="images/faces/person-icon.png">
                                                        <div class="round3">
                                                            <input name="image" type="file">
                                                            <i style="color: #fff;" class="bi bi-camera"></i>
                                                        </div>

                                                    </div>
                                                    <div class="col-10" style="padding-left: 50px;">
                                                        <h2 style="color: black;margin-top: 50px;margin-bottom: 30px;">Create Event
                                                        </h2>
                                                        <div class="form-group">
                                                            <label>Name of Event</label>
                                                            <input name="name" type="text" id="name" class="form-control form-control-lg">
                                                            <span class="form-message"></span>
                                                        </div>
                                                        <div class="form-group">
                                                            <label>Start Event</label>
                                                            <input name="startEvent" type="date"
                                                                   class="form-control" id="startEvent" placeholder="dd/mm/yyyy">
                                                            <span class="form-message"></span>
                                                        </div>
                                                        <div class="form-group">
                                                            <label>End Event</label>
                                                            <input name="endEvent" type="date"
                                                                   class="form-control" id="endEvent" placeholder="dd/mm/yyyy">
                                                            <span class="form-message"></span>
                                                        </div>
                                                        <div class="form-group">
                                                            <label>Organizational Sponsor</label>
                                                            <input name="organizationalSponsor" id="organizationalSponsor" type="text" class="form-control form-control-lg">
                                                            <span class="form-message"></span>
                                                        </div>
                                                        <div class="form-group">
                                                            <label>Class Name</label>
                                                            <select name="ClassId" class="form-control form-control-lg">
                                                            <c:forEach items="${class}" var="c">
                                                                <option value="${c.classID}">${c.className}</option>
                                                            </c:forEach>
                                                        </select>
                                                    </div>
                                                    <div class="form-group row">
                                                        <div class="col-12" style="margin-top: 50px;margin-bottom: 50px;">
                                                            <button type="submit" class="btn btn-dark btn-icon-text">
                                                                SAVE
                                                                <i class="mdi mdi-file-check btn-icon-append"></i>
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
                form: "#formEvent",
                errorSelector: '.form-message',
                rules: [
                    Validator.isRequired('#name', 'Name of Event cannot be blank'),
                    Validator.isRequired('#startEvent', 'Start Date Event cannot be blank'),
                    Validator.isRequired('#endEvent', 'End Date Event cannot be blank'),
                    Validator.isRequired('#organizationalSponsor', 'Organizational Sponsor cannot be blank'),
                    Validator.isCompareDate('#endEvent', function () {
                        return document.querySelector('#formEvent #startEvent').value;
                    }, 'Event end date must be greater than or equal to start date'),
                ]
            });
        </script>
        <script>
            document.getElementById('formEvent').addEventListener('submit', function () {
                alert('Success');
            });
        </script>
    </body>

</html>
