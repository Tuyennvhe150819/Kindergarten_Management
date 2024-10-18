
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
                                    <form action="CreateTermAD" method="POST" id="formTerm">
                                        <div class="card-body container">
                                            <div class="row">                         
                                                <div class="col-10" style="padding-left: 50px;">
                                                    <h2 style="color: black;margin-top: 50px;margin-bottom: 30px;">Create Term
                                                    </h2>
                                                    <div class="form-group">
                                                        <label>Term Name</label>
                                                        <input name="name" type="text" class="form-control form-control-lg"
                                                               id="name">
                                                        <span class="form-message"></span>
                                                    </div>
                                                    <div class="form-group">
                                                        <label>Start Day </label>
                                                        <input name="startD" type="date" class="form-control" id="startD" placeholder="dd/mm/yyyy">
                                                        <span class="form-message"></span>
                                                    </div>
                                                    <div class="form-group">
                                                        <label>End Day</label>
                                                        <input name="endD" type="date" class="form-control" id="endD" placeholder="dd/mm/yyyy">
                                                        <span class="form-message"></span>
                                                    </div>


                                                    <div class="form-group row">
                                                        <div class="col-12" style="margin-top: 50px;margin-bottom: 50px;">
                                                            <button type="submit" class="btn btn-dark btn-icon-text">
                                                                Save
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
                form: "#formTerm",
                errorSelector: '.form-message',
                rules: [
                    Validator.isRequired('#name', 'Term name cannot be blank'),
                    Validator.isRequired('#startD', 'Start Date cannot be blank'),
                    Validator.isRequired('#endD', 'End Date cannot be blank'),
                    Validator.isCompareDate('#endD', function () {
                        return document.querySelector('#formTerm #startD').value;
                    }, 'Term end date must be greater than or equal to start date'),
                ]
            });
        </script>
        <script>
            document.getElementById('formTerm').addEventListener('submit', function () {
                alert('Success');
            });
        </script>
    </body>

</html>
