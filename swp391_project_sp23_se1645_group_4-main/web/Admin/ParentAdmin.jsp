<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<!DOCTYPE html>
<html lang="en">
    <head>
        <!-- Required meta tags -->
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
        <title>Admin</title>
        <!-- base:css -->
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.11.2/css/all.css">
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.10.3/font/bootstrap-icons.css">
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
                            <div class="row d-flex justify-content-center">
                                <div class="col-sm-10 flex-column d-flex stretch-card">
                                    <div class="row">
                                        <div class="col-lg-12 d-flex grid-margin stretch-card">
                                            <div class="card school-bg text-center">
                                                <div class="card-body">
                                                    <h2 class="mt-3 text-title mb-3 font-weight-bold">
                                                        Parent Management
                                                    </h2>
                                                </div>
                                            </div>
                                        </div>                                       
                                    </div>
                                    <div class="row">
                                        <div class="col-sm-12 grid-margin d-flex stretch-card">
                                            <div class="card">
                                                <div class="card-body">
                                                    <div class="d-flex justify-content-between mb-4">
                                                        <form class="search-bar d-flex justify-content-around">
                                                            <input type="text" placeholder="Search..." id="txtSearch_Parent"/>
                                                            <a class="icon_Search"><i class="bi bi-search"></i></a>
                                                        </form>
                                                    </div>
                                                    <div class="table-responsive">
                                                        <table class="table table-striped" id="table_Parent">
                                                            <thead>
                                                                <tr>
                                                                    <th>
                                                                        No.
                                                                    </th>
                                                                    <th>
                                                                        Picture
                                                                    </th>
                                                                    <th>
                                                                        Name
                                                                    </th>
                                                                    <th>
                                                                        Phone
                                                                    </th>
                                                                    <th>
                                                                        Birthday
                                                                    </th>
                                                                    <th>
                                                                        Address
                                                                    </th>
                                                                    <th>
                                                                        Job
                                                                    </th>
                                                                </tr>
                                                            </thead>
                                                            <tbody>
                                                            <c:set var="stt" value="0" />
                                                            <c:forEach items="${listParent}" var="p">
                                                                <c:set var="stt" value="${stt + 1}"/>
                                                                <tr>
                                                                    <td>
                                                                        ${stt}
                                                                    </td>
                                                                    <td class="py-1">
                                                                        <img src="images/faces/${p.parentImage}" alt="image" />
                                                                    </td>
                                                                    <td>
                                                                        ${p.parentLastName} ${p.parentFirstName}
                                                                    </td>
                                                                    <td>
                                                                        ${p.phone}
                                                                    </td>
                                                                    <td>
                                                                        ${p.datebirth}
                                                                    </td>   
                                                                    <td>
                                                                        ${p.address}
                                                                    </td>
                                                                    <td>
                                                                        ${p.job}
                                                                    </td> 
                                                                    <td class="d-flex">
                                                                        <a class="btn btn-primary me-2" href="UpdateParentAdmin?id=${p.parentID}"><i class="bi bi-pen"></i></a>                                                   
                                                                    </td>
                                                                </tr>
                                                            </c:forEach>

                                                        </tbody>
                                                    </table>
                                                </div>
                                                <div class="content__paging">
                                                    <ul>
                                                        <c:if test="${numPage > 1}">
                                                            <li><a class="fas fa-angle-left" href="ListAllParentAdmin?index=${numPage-1}"></a></li>
                                                            </c:if>

                                                        <div class="number-page" id="number-page">
                                                            <c:forEach begin="1" end="${endPageParent}" var="i">
                                                                <li class="${numPage == i ? "active":""}"><a href="ListAllParentAdmin?index=${i}">${i}</a></li>
                                                                </c:forEach>                                                           
                                                        </div>
                                                        <c:if test="${numPage < endPageParent}">
                                                            <li><a class="fas fa-angle-right" href="ListAllParentAdmin?index=${numPage+1}"></a></li>
                                                            </c:if>

                                                    </ul>
                                                </div>
                                            </div>
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
        <script src="vendors/progressbar.js/progressbar.min.js"></script>
        <script src="vendors/justgage/raphael-2.1.4.min.js"></script>
        <script src="vendors/justgage/justgage.js"></script>
        <script src="js/jquery.cookie.js" type="text/javascript"></script>

        <script src="js/search.js"></script>
        <script src="js/jsbase.js"></script>
        <script src="js/dashboard.js"></script>
    </body>
</html>