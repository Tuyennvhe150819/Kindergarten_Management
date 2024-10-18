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
                            <div class="row  d-flex justify-content-center">
                                <div class="col-sm-8 flex-column">
                                    <div class="row">
                                        <div class="col-lg-12 d-flex grid-margin stretch-card">
                                            <div class="card school-bg text-center">
                                                <div class="card-body">
                                                    <h2 class="mt-3 text-title mb-3 font-weight-bold">
                                                        Account Management
                                                    </h2>
                                                </div>
                                            </div>
                                        </div>                                       
                                    </div>
                                    <div class="row">
                                        <div class="col-sm-12 grid-margin d-flex stretch-card">
                                            <div class="card">
                                                <div class="card-body">
                                                    <div class="box-search d-flex justify-content-between mb-4">
                                                        <form class="search-bar d-flex justify-content-around">
                                                            <input type="text" placeholder="Search..." id=""/>
                                                            <a class="icon_Search"><i class="bi bi-search"></i></a>
                                                        </form>
                                                        <a class="btn btn-success" href="CreateAccountAD"><i class="bi bi-file-plus"></i> Add</a> 
                                                    </div>
                                                    <div class="table-responsive">
                                                        <table class="table table-striped" id="table_Account">
                                                            <thead>
                                                                <tr>
                                                                    <th>
                                                                        STT
                                                                    </th>
                                                                    <th>
                                                                        Email
                                                                    </th>
                                                                    <th>
                                                                        Password
                                                                    </th>
                                                                    <th>
                                                                        Role
                                                                    </th>
                                                                </tr>
                                                            </thead>
                                                            <tbody id="contentAccount">
                                                            <c:set var="stt" value="0" />
                                                            <c:forEach items="${listAccount}" var="a">
                                                                <c:set var="stt" value="${stt + 1}"/>
                                                                <tr>
                                                                    <td>
                                                                        ${stt}
                                                                    </td>
                                                                    <td>
                                                                        ${a.email}
                                                                    </td>
                                                                    <td>
                                                                        ${a.password}
                                                                    </td>   
                                                                    <td>
                                                                        <c:if test="${a.role == 0}">
                                                                            Admin
                                                                        </c:if>
                                                                        <c:if test="${a.role == 1}">
                                                                            Teacher
                                                                        </c:if>
                                                                        <c:if test="${a.role == 2}">
                                                                            Parent
                                                                        </c:if>
                                                                    </td>  
                                                                    <td >
                                                                        <a class="btn btn-primary me-2" href="UPAccountAD?id=${a.accountID}"><i class="bi bi-pen"></i></a>                                                   
                                                                    </td>
                                                                </tr>
                                                            </c:forEach>

                                                        </tbody>
                                                    </table>
                                                </div>
                                                <div class="content__paging">
                                                    <ul>
                                                        <c:if test="${numPage > 1}">
                                                            <li><a class="fas fa-angle-left" href="ListAllAccountAD?index=${numPage-1}"></a></li>
                                                            </c:if>

                                                        <div class="number-page" id="number-page">
                                                            <c:forEach begin="1" end="${endPageAccount}" var="i">
                                                                <li class="${numPage == i ? "active":""}"><a href="ListAllAccountAD?index=${i}">${i}</a></li>
                                                                </c:forEach>                                                           
                                                        </div>
                                                        <c:if test="${numPage < endPageAccount}">
                                                            <li><a class="fas fa-angle-right" href="ListAllAccountAD?index=${numPage+1}"></a></li>
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