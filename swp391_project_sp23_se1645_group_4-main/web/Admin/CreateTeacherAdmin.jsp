
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
                                    <form action="CreateTeacherAD" method="POST" id="formTeacher">
                                        <div class="card-body container">
                                            <div class="row">
                                                <div class="imageBox col-2" style="margin-top: 50px;">
                                                    <img style="width: 100%;border-radius: 50%;"
                                                         src="images/faces/person-icon.png">
                                                    <div class="round5">
                                                        <input name="img" type="file">
                                                        <i style="color: #fff;" class="bi bi-camera"></i>
                                                    </div>                                      

                                                </div>
                                                <div class="col-10" style="padding-left: 50px;">
                                                    <h2 style="color: black;margin-top: 50px;margin-bottom: 30px;font-weight: bold">Teacher information
                                                    </h2>
                                                    <div class="form-group">
                                                        <label style="font-weight: bold">First Name</label><span style="color: red">*</span>
                                                        <input name="firstName" type="text" required maxlength="50" id="firstName" class="form-control form-control-lg">
                                                        <span class="form-message"></span>
                                                    </div>
                                                    <div class="form-group">
                                                        <label style="font-weight: bold">Last Name</label><span style="color: red">*</span>
                                                        <input name="lastName" type="text" required maxlength="50"  id="lastName" class="form-control form-control-lg">
                                                        <span class="form-message"></span>
                                                    </div>
                                                    <div class="form-group">
                                                        <label style="font-weight: bold">Gender</label><span style="color: red">*</span>
                                                        <div>
                                                            <span style="margin-right: 20px"><input type="radio" name="gender" value="1" />Male</span>
                                                            <span><input  type="radio" name="gender" value="0" />Female</span>
                                                        </div>
                                                    </div>
                                                    <div class="form-group">
                                                        <label style="font-weight: bold">Phone</label><span style="color: red">*</span>
                                                        <input name="phone" type="text" required maxlength="10"  id="phone" class="form-control form-control-lg"
                                                               aria-label="phone">
                                                        <span class="form-message"></span>
                                                    </div>
                                                    <div class="form-group">
                                                        <label style="font-weight: bold">Address</label><span style="color: red">*</span>
                                                        <input name="address" type="text" required maxlength="50"  id="address" class="form-control form-control-lg"
                                                               aria-label="address">
                                                        <span class="form-message"></span>
                                                    </div>
                                                    <div class="form-group">
                                                        <label style="font-weight: bold">BirthDay</label><span style="color: red">*</span>
                                                        <input name="birth" type="date" class="form-control" id="birth" placeholder="dd/mm/yyyy">
                                                        <span class="form-message"></span>
                                                    </div>
                                                    <div class="form-group">
                                                        <label style="font-weight: bold">Year Of Experience</label><span style="color: red">*</span>
                                                        <input name="yearOfEXp" type="number" required maxlength="2"  class="form-control form-control-lg"
                                                               id="yearOfEXp">
                                                        <span class="form-message"></span>
                                                    </div>
                                                    <div class="form-group">
                                                        <label style="font-weight: bold">Salary</label><span style="color: red">*</span>
                                                        <input name="salaryFixed" type="number" required maxlength="5"  class="form-control form-control-lg"
                                                               id="salaryFixed">
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
                form: "#formTeacher",
                errorSelector: '.form-message',
                rules: [
                    Validator.isRequired('#firstName', 'First Name of Teacher cannot be blank'),
                    Validator.isRequired('#lastName', 'Last Name of Teacher cannot be blank'),
                    Validator.isRequired('#phone', 'Phone of Teacher cannot be blank'),
                    Validator.isPhone('#phone', 10),
                    Validator.isRequired('#birth', 'Birthday of Teacher cannot be blank'),
                    Validator.isRequired('#address', 'Address of Teacher cannot be blank'),
                    Validator.isRequired('#yearOfEXp', 'Year of experience cannot be blank'),
                    Validator.isRequired('#salaryFixed', 'Salary of Teacher cannot be blank')
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
