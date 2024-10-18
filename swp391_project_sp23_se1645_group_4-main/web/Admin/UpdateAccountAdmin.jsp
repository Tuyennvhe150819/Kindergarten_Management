
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
                                <form action="UPAccountAD" method="POST">
                                <div class="card-body container">
                                    <div class="row">
                                        <input name="aid" value="${account.accountID}" hidden>                           
                                        <div class="col-10" style="padding-left: 50px;">
                                            <h2 style="color: black;margin-top: 50px;margin-bottom: 30px;">Update Account
                                            </h2>
                                            <div class="form-group">
                                                <label>Email</label><span style="color: red">*</span>
                                                <input name="email" type="text" class="form-control form-control-lg"
                                                       value="${account.email}">
                                            </div>
                                            <div class="form-group">
                                                <label>Password</label><span style="color: red">*</span>
                                                <input name="pass" type="text" class="form-control form-control-lg"
                                                       value="${account.password}">
                                            </div>
                             
                                            <div class="form-group">
                                                <label>Role</label>
                                                <select name="role" class="form-control form-control-lg">
                                                    <option value="0" ${account.role == 0 ?'selected' : ''}>0</option>
                                                    <option value="1" ${account.role == 1 ?'selected' : ''}>1</option>
                                                    <option value="2" ${account.role == 2 ?'selected' : ''}>2</option>
                                                </select>
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
</body>

</html>
