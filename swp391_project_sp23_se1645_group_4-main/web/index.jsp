
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

    <head>
        <!-- Required meta tags -->
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
        <title>Login</title>
        <!-- base:css -->
        <link rel="stylesheet" href="vendors/mdi/css/materialdesignicons.min.css">
        <!-- endinject -->
        <!-- plugin css for this page -->
        <!-- End plugin css for this page -->
        <!-- inject:css -->
        <link rel="stylesheet" href="css/style.css">
        <link rel="stylesheet" href="css/maps/iconInputImage.css">
        <!-- endinject -->
        <link rel="shortcut icon" href="images/favicon.png" />
        <link href="https://fonts.googleapis.com/css2?family=Capriola&display=swap" rel="stylesheet">
    </head>

    <body style="font-family: 'Capriola', sans-serif;">
        <div class="container-scroller">
            <div class="container-fluid page-body-wrapper full-page-wrapper">
                <div class="content-wrapper d-flex align-items-stretch auth auth-img-bg">
                    <div class="row flex-grow">
                        <div class="col-lg-6 d-flex align-items-center justify-content-center">
                            <div class="auth-form-transparent text-left p-3">
                                <div class="brand-logo">
                                    <a class="navbar-brand" href="homePageController">
                                        <img src="img/logo.png" alt="logo">
                                    </a>
                                </div>
                                <h4>Welcome back!</h4>
                                <h6 class="font-weight-light">Happy to see you again!</h6>
                                <form class="pt-3" action="controllogin" method="POST" id="formLogin">
                                    <p class="text-danger">${mess}</p>
                                    <div class="form-group">
                                        <label for="exampleInputEmail">Email</label>
                                        <div class="input-group">
                                            <div class="input-group-prepend bg-transparent">
                                                <span class="input-group-text bg-transparent border-right-0">
                                                    <i class="mdi mdi-account-outline text-primary"></i>
                                                </span>
                                            </div>
                                            <input type="text" name="email" class="form-control form-control-lg border-left-0" id="email" placeholder="Email">
                                        </div>
                                        <span class="form-message"></span>
                                    </div>
                                    <div class="form-group">
                                        <label for="exampleInputPassword">Password</label>
                                        <div class="input-group">
                                            <div class="input-group-prepend bg-transparent">
                                                <span class="input-group-text bg-transparent border-right-0">
                                                    <i class="mdi mdi-lock-outline text-primary"></i>
                                                </span>
                                            </div>
                                            <input type="password" name="password" class="form-control form-control-lg border-left-0" id="password" placeholder="Password">                                                             
                                        </div>
                                        <span class="form-message"></span>
                                    </div>
                                    <div class="my-3">
                                        <button class="btn btn-block btn-primary btn-lg font-weight-medium auth-form-btn" name="submit">LOGIN</button>
                                    </div>
                                </form>
                            </div>
                        </div>
                        <div class="col-lg-6 login-half-bg d-flex flex-row" style="background-color: #EB1551;">
                            <img src="images/slider_group_image.png" style="width: 90%; height: 80%;margin-top: 50px;" >

                        </div>
                    </div>
                </div>
                <!-- content-wrapper ends -->
            </div>
            <!-- page-body-wrapper ends -->
        </div>

        <script src="js/ValidateLogin.js"></script>
        <script>
            Validator({
                form: "#formLogin",
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
    </body>

</html>
