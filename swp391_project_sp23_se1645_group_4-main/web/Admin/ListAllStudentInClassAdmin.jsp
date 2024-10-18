

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
                                        <div class="card-body">
                                            <div class="d-flex justify-content-between">
                                                <h4 class="card-title">List All Students</h4>
                                                <a href="#">Export file</a>
                                            </div>
                                            <div class="table-responsive">
                                                <table class="table table-striped">
                                                    <thead>
                                                        <tr>
                                                            <th>
                                                                STT
                                                            </th>
                                                            <th>
                                                                Picture
                                                            </th>
                                                            <th>
                                                                Name
                                                            </th>

                                                            <th>
                                                                Gender
                                                            </th>
                                                            <th>
                                                                BirthDay
                                                            </th>
                                                            <th>
                                                                What interests you?
                                                            </th>
                                                            <th>
                                                                What bothers you?
                                                            </th>
                                                            <th>
                                                                Your favorite food
                                                            </th>
                                                            <th>
                                                                Food you dislike
                                                            </th>
                                                            <th>
                                                                Class
                                                            </th>
                                                        </tr>
                                                    </thead>
                                                    <tbody>
                                                    <c:set var="stt" value="0" />
                                                    <c:forEach items="${listStudent}" var="s">
                                                        <c:set var="stt" value="${stt + 1}"/>
                                                        <tr>
                                                            <td>
                                                                ${stt}
                                                            </td>
                                                            <td class="py-1" >
                                                                <img src="images/faces/${s.studentImg}" alt="image" /> <br>
                                                            </td>
                                                            <td>
                                                                ${s.studentLastName} ${s.studentFirstName}
                                                            </td>
                                                            <td>
                                                                <c:if test="${s.gender == 1}">
                                                                    Male
                                                                </c:if>
                                                                <c:if test="${s.gender == 0}">
                                                                    Female
                                                                </c:if>
                                                            </td>                                                           
                                                            <td>
                                                                ${s.birthdate}
                                                            </td>
                                                            <td>
                                                                ${s.likeSomething}
                                                            </td>  
                                                            <td>
                                                                ${s.hateSomething}
                                                            </td>  
                                                            <td>
                                                                ${s.favoriteFood}
                                                            </td>  
                                                            <td>
                                                                ${s.hateFood}
                                                            </td> 
                                                            <td>
                                                                ${s.className}
                                                            </td>

                                                        </tr>
                                                    </c:forEach>
                                                </tbody>
                                            </table>
                                        </div>
                                    </div>
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