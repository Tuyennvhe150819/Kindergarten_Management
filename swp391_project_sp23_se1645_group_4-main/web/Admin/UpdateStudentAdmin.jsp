
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
                                        <form action="UpdateStudentAdmin" method="POST" id="formStudent">
                                            <div class="card-body container">
                                                <div class="row">
                                                    <div class="imageBox col-2" style="margin-top: 50px;">
                                                        <img style="width: 100%;border-radius: 50%;"
                                                             src="images/faces/${student.studentImg}">
                                                    <div class="round6">
                                                        <input name="img" type="file">
                                                        <i style="color: #fff;" class="bi bi-camera"></i>
                                                    </div>
                                                    <input name="stid" value="${student.studentID}" hidden>

                                                </div>
                                                <div class="col-10" style="padding-left: 50px;">
                                                    <h2 style="color: black;margin-top: 50px;margin-bottom: 30px; font-weight: bold">Update student information
                                                    </h2>
                                                    <div class="form-group">
                                                        <label style="font-weight: bold">First Name</label><span style="color: red">*</span>
                                                        <input name="firstName" type="text" required maxlength="20" class="form-control form-control-lg"
                                                               value="${student.studentFirstName}" id="firstName">
                                                        <span class="form-message"></span>
                                                    </div>
                                                    <div class="form-group" >
                                                        <label style="font-weight: bold">Last Name</label><span style="color: red">*</span>
                                                        <input name="lastName" type="text" required maxlength="20" class="form-control form-control-lg"
                                                               value="${student.studentLastName}" id="lastName">
                                                        <span class="form-message"></span>
                                                    </div>
                                                    <div class="form-group">
                                                        <label style="font-weight: bold">Gender</label><span style="color: red">*</span>    
                                                        <div>
                                                            <span style="margin-right: 20px"><input type="radio" name="gender" value="1" ${student.gender == 1?"checked":""} />Male</span>
                                                            <span><input  type="radio" name="gender" value="0" ${student.gender == 0?"checked":""} />Female</span>
                                                        </div>
                                                    </div>
                                                    <div class="form-group">
                                                        <label style="font-weight: bold">What interests you? </label><span style="color: red">*</span>
                                                        <input name="likeSomething" type="text" required maxlength="100" class="form-control form-control-lg"
                                                               value="${student.likeSomething}" id="likeSomething">
                                                        <span class="form-message"></span>
                                                    </div>
                                                    <div class="form-group">
                                                        <label style="font-weight: bold">What bothers you?</label><span style="color: red">*</span>
                                                        <input name="hateSomething" type="text" required maxlength="100" class="form-control form-control-lg"
                                                               value="${student.hateSomething}" id="hateSomething">
                                                        <span class="form-message"></span>
                                                    </div>
                                                    <div class="form-group">
                                                        <label style="font-weight: bold">Your favorite food</label><span style="color: red">*</span>
                                                        <input name="favoriteFood" type="text" required maxlength="100" class="form-control form-control-lg"
                                                               value="${student.favoriteFood}" id="favoriteFood">
                                                        <span class="form-message"></span>
                                                    </div>
                                                    <div class="form-group">
                                                        <label style="font-weight: bold">Food you dislike</label><span style="color: red">*</span>
                                                        <input name="hateFood" type="text" required maxlength="100" class="form-control form-control-lg"
                                                               value="${student.hateFood}" id="hateFood">
                                                        <span class="form-message"></span>
                                                    </div>
                                                    <div class="form-group">
                                                        <label style="font-weight: bold">Birthday</label><span style="color: red">*</span>
                                                        <input name="birth" type="date" value="${student.birthdate}" 
                                                               class="form-control" id="birth" placeholder="dd/mm/yyyy">
                                                        <span class="form-message"></span>
                                                    </div>

                                                    <div class="form-group">
                                                        <label style="font-weight: bold">Class Name</label><span style="color: red">*</span>
                                                        <select name="ClassId" class="form-control form-control-lg">
                                                            <c:forEach items="${class}" var="c">
                                                                <option value="${c.classID}" ${student.classID == c.classID ?'selected' : ''}>${c.className}</option>
                                                            </c:forEach>
                                                        </select>
                                                    </div>

                                                    <div class="form-group row">
                                                        <div class="col-12" style="margin-top: 50px;margin-bottom: 50px;">
                                                            <button type="submit" class="btn btn-dark btn-icon-text" style="font-weight: bold">
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
                form: "#formStudent",
                errorSelector: '.form-message',
                rules: [
                    Validator.isRequired('#firstName', 'First Name of Student cannot be blank'),
                    Validator.isRequired('#lastName', 'Last Name of Student cannot be blank'),
                    Validator.isRequired('#likeSomething', 'What interests you? cannot be blank'),
                    Validator.isRequired('#hateSomething', 'What bothers you? cannot be blank'),
                    Validator.isRequired('#favoriteFood', 'Your favorite food cannot be blank'),
                    Validator.isRequired('#hateFood', 'Food you dislike cannot be blank'),
                    Validator.isRequired('#birth', 'Birthday of Student cannot be blank'),
                    Validator.isCheckAge('#birth',3,6)
                ]
            });
        </script>
        <script>
            document.getElementById('formStudent').addEventListener('submit', function () {
                alert('Success');
            });
        </script>
    </body>

</html>
