
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

<head>
  <!-- Required meta tags -->
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
  <title>Kapella Bootstrap Admin Dashboard Template</title>
  <!-- base:css -->
  <link rel="stylesheet" href="vendors/mdi/css/materialdesignicons.min.css">
  <link rel="stylesheet" href=vendors/base/vendor.bundle.base.css">
  <!-- endinject -->
  <!-- plugin css for this page -->
  <!-- End plugin css for this page -->
  <!-- inject:css -->
  <link rel="stylesheet" href="css/style.css">
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
              <form class="pt-3" action="changePass" method="post" id="formchangepass">
                  <p class="text-danger">${smess}</p>
                <div class="form-group">
                  <label for="exampleInputEmail">Email</label>
                  <div class="input-group">
                    <div class="input-group-prepend bg-transparent">
                      <span class="input-group-text bg-transparent border-right-0">
                        <i class="mdi mdi-account-outline text-primary"></i>
                      </span>
                    </div>
                      <input type="text" name="email" class="form-control form-control-lg border-left-0" id="exampleInputEmail" value="${sessionScope.account.email}" readonly>
                  </div>
                </div>
                <div class="form-group">
                  <label for="exampleInputPassword">Old Password</label>
                  <div class="input-group">
                    <div class="input-group-prepend bg-transparent">
                      <span class="input-group-text bg-transparent border-right-0">
                        <i class="mdi mdi-lock-outline text-primary"></i>
                      </span>
                    </div>
                      <input type="password" name="oldpassword" class="form-control form-control-lg border-left-0" id="exampleInputPassword" placeholder="Password">                        
                  </div>
                </div>
                <div class="form-group">
                  <label for="exampleInputPassword">New Password</label>
                  <div class="input-group">
                    <div class="input-group-prepend bg-transparent">
                      <span class="input-group-text bg-transparent border-right-0">
                        <i class="mdi mdi-lock-outline text-primary"></i>
                      </span>
                    </div>
                      <input type="password" name="newpassword" class="form-control form-control-lg border-left-0" id="newpassword" placeholder="Password">                        
                  </div>
<!--                  <span class="form-message" style="color:red"></span>-->
                </div>
                <div class="my-2 d-flex justify-content-between align-items-center">
                  <div class="form-check">
                  </div>
                </div>
                <div class="my-3">
                    <button class="btn btn-block btn-primary btn-lg font-weight-medium auth-form-btn" name="submit">SAVE</button>
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
  <!-- container-scroller -->
  <!-- base:js -->
  <script src="vendors/base/vendor.bundle.base.js"></script>
  <!-- endinject -->
  <!-- Plugin js for this page-->
  <!-- End plugin js for this page-->
  <!-- inject:js -->
  <script src="js/template.js"></script>
  <!-- endinject -->
  <!-- plugin js for this page -->
  <!-- End plugin js for this page -->
  <!-- Custom js for this page-->
  <!-- End custom js for this page-->
</body>
<script src="js/ValidateLogin.js"></script>
        <script>
            Validator({
                form: "#formchangepass",
                errorSelector: '.form-message',
                rules: [
                    Validator.isRequired('#email', 'Email cannot be blank'),
                    Validator.isEmail('#email', 'Invalid email address'),
                    Validator.isRequired('#newpassword', 'New Password cannot be blank'),
                    Validator.isPass('#newpassword', '- Password must be 8 to 15 characters.\n' +
                            '- Contain at least one lowercase letter.\n' +
                            '- One uppercase letter.\n' +
                            '- One numeric digit.\n' +
                            '- One special character.')
                ]
            });
        </script>
</html>
