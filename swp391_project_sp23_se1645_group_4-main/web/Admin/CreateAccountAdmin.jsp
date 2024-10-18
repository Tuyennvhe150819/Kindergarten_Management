
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
                                    <form action="CreateAccountAD" method="POST" id="formCreateAccAD">
                                        <div class="card-body container">
                                            <div class="row">                          
                                                <div class="col-10" style="padding-left: 50px;">
                                                    <h2 style="color: black;margin-top: 50px;margin-bottom: 30px; font-weight: bold">Create Account
                                                    </h2>
                                                    <div class="form-group">
                                                        <label style="font-weight: bold">Email</label><span style="color: red">*</span>
                                                        <input name="email" type="text" class="form-control form-control-lg" required maxlength="50" id="email">
                                                        <span class="form-message"></span>
                                                    </div>
                                                    <div class="form-group">
                                                        <label style="font-weight: bold">Password</label><span style="color: red">*</span>
                                                        <input name="pass" type="text" class="form-control form-control-lg" required maxlength="20" id="password">
                                                        <span class="form-message"></span>
                                                    </div>

                                                    <div class="form-group">
                                                        <label style="font-weight: bold">Role</label>
                                                        <select name="role" class="form-control form-control-lg">
                                                            <option value="0">Admin</option>
                                                            <option value="1">Teacher</option>
                                                            <option value="2">Parent</option>
                                                        </select>
                                                    </div>

                                                    <div class="form-group row">
                                                        <div class="col-12" style="margin-top: 50px;margin-bottom: 50px;">
                                                            <button type="submit" class="btn btn-dark btn-icon-text">
                                                                Save
                                                                <i class="mdi mdi-file-check btn-icon-append"></i>
                                                            </button>
                                                            <p class="text-danger">${smess}</p>
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
                form: "#formCreateAccAD",
                errorSelector: '.form-message',
                rules: [
                    Validator.isRequired('#email', 'Email cannot be blank'),
                    Validator.isEmail('#email', 'Invalid email address'),
                    Validator.isRequired('#password', 'Password cannot be blank'),
                    Validator.isPass('#password', '- Password must be 8 to 15 characters.\n' +
                            '- Contain at least one lowercase letter.\n' +
                            '- One uppercase letter.\n' +
                            '- One numeric digit.\n' +
                            '- One special character.')
                ]
            });
        </script>
        <script>
            document.getElementById('formCreateAccAD').addEventListener('submit', function () {
                alert('Success');
            });
        </script>
    </body>

</html>
