
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
                                        <form action="UpdateParentAdmin" method="POST" id="formParent">
                                            <div class="card-body container">
                                                <div class="row">
                                                    <div class="imageBox col-2" style="margin-top: 50px;">
                                                        <img style="width: 100%;border-radius: 50%;"
                                                             src="images/faces/${parent.parentImage}">
                                                    <div class="round4">
                                                        <input name="img" type="file" value="${parent.parentImage}">
                                                        <i style="color: #fff;" class="bi bi-camera"></i>
                                                    </div>
                                                    <input name="pid" value="${parent.parentID}" hidden>  

                                                </div>

                                                <div class="col-10" style="padding-left: 50px;">
                                                    <h2 style="color: black;margin-top: 50px;margin-bottom: 30px;">Update Parent
                                                    </h2>
                                                    <div class="form-group">
                                                        <label>First Name</label>
                                                        <input name="firstName" type="text" id="firstName" class="form-control form-control-lg"
                                                               value="${parent.parentFirstName}" aria-label="name">
                                                        <span class="form-message"></span>
                                                    </div>
                                                    <div class="form-group">
                                                        <label>Last Name</label>
                                                        <input name="lastName" type="text" id="lastName" class="form-control form-control-lg"
                                                               value="${parent.parentLastName}" aria-label="name">
                                                        <span class="form-message"></span>
                                                    </div>
                                                    <div class="form-group">
                                                        <label>Phone</label>
                                                        <input name="phone" type="text" id="phone" class="form-control form-control-lg"
                                                               value="${parent.phone}" aria-label="phone">
                                                        <span class="form-message"></span>
                                                    </div>
                                                    <div class="form-group">
                                                        <label>Birthday</label>
                                                        <input name="birth" type="date" id="birth" value="${parent.datebirth}" 
                                                               class="form-control" id="exampleInputEmail3" placeholder="dd/mm/yyyy">
                                                        <span class="form-message"></span>
                                                    </div>
                                                    <div class="form-group">
                                                        <label>Address</label>
                                                        <input name="address" type="text" id="address" class="form-control form-control-lg"
                                                               value="${parent.address}" aria-label="address">
                                                        <span class="form-message"></span>
                                                    </div>
                                                    <div class="form-group">
                                                        <label>Job</label>
                                                        <input name="job" type="text" id="job" class="form-control form-control-lg"
                                                               value="${parent.job}" aria-label="job">
                                                        <span class="form-message"></span>
                                                    </div>


                                                    <div class="form-group row">
                                                        <div class="col-12" style="margin-top: 50px;margin-bottom: 50px;">
                                                            <button type="submit" class="btn btn-dark btn-icon-text">
                                                                Edit
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
                form: "#formParent",
                errorSelector: '.form-message',
                rules: [
                    Validator.isRequired('#firstName', 'First Name of Parents cannot be blank'),
                    Validator.isRequired('#lastName', 'Last Name of Parents cannot be blank'),
                    Validator.isRequired('#phone', 'Phone of Parents cannot be blank'),
                    Validator.isPhone('#phone',10),
                    Validator.isRequired('#birth', 'Birthday of Parents cannot be blank'),
                    Validator.isRequired('#address', 'Address of Parents cannot be blank'),
                    Validator.isRequired('#job', 'Job of Parents cannot be blank')
                ]
            });
        </script>
        <script>
            document.getElementById('formParent').addEventListener('submit', function () {
                alert('Success');
            });
        </script>
    </body>

</html>
