
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
        <link rel="stylesheet" href="vendors/mdi/css/materialdesignicons.min.css">
        <link rel="stylesheet" href="vendors/base/vendor.bundle.base.css">
        <link rel="stylesheet" href="css/style.css">
        <link rel="stylesheet" href="css/stylebase.css">
        <!-- endinject -->
        <link rel="shortcut icon" href="images/logo.png" />

    </head>
    <body>
        <div class="container-scroller">

            <!--================Menu Information =================-->
            <jsp:include page="menuAdmin.jsp"></jsp:include>
                <!--================Menu Information =================--> 
                <!-- partial -->
                <div class="container-fluid page-body-wrapper">
                    <div class="main-panel">
                        <div class="content-wrapper">
                            <div class="row">
                                <div class="col-sm-6 flex-column d-flex stretch-card">                               
                                    <div class="row">
                                        <div class="col-sm-12 grid-margin d-flex stretch-card">
                                            <div class="card">
                                                <div id="curve_chart" style='width: 100%; height: 400px;'></div>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                                <div class="select_box col-sm-5 flex-column d-flex stretch-card">  

                                </div>

                            </div>
                        </div>
                    </div>
                </div>
            </div>
            <script src="vendors/base/vendor.bundle.base.js"></script>
            <script src="js/template.js"></script>
            <script src="vendors/progressbar.js/progressbar.min.js"></script>
            <script src="vendors/justgage/raphael-2.1.4.min.js"></script>
            <script src="vendors/justgage/justgage.js"></script>
            <script src="js/jquery.cookie.js" type="text/javascript"></script>

            <script src="js/jsbase.js"></script>
            <script type="text/javascript" src="https://www.gstatic.com/charts/loader.js"></script>
            <script src="js/dashboard.js"></script>
           
    </body>
</html>