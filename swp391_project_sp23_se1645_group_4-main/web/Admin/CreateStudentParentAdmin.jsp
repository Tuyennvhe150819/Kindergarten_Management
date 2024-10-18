
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
                                        <form action="CreateSTParent" method="POST" id="formStudentParent">
                                            <div class="card-body container">
                                                <div class="row">
                                                    <div class="imageBox col-2" style="margin-top: 50px;">
                                                        <img style="width: 100%;border-radius: 50%;"
                                                             src="images/faces/person-icon.png">
                                                        <div class="round1">
                                                            <input name="imgST" type="file">
                                                            <i style="color: #fff;" class="bi bi-camera"></i>
                                                        </div>

                                                    </div>
                                                    <div class="col-10" style="padding-left: 50px;">
                                                        <h2 style="color: black;margin-top: 50px;margin-bottom: 30px; font-weight: bold">Student Information
                                                        </h2>
                                                        <div class="form-group">
                                                            <label style="font-weight: bold">First Name Of Student</label><span style="color: red">*</span>
                                                            <input name="firstNameST" type="text" id="firstNameST" required maxlength="20" class="form-control form-control-lg"
                                                                   >
                                                            <span class="form-message"></span>
                                                        </div>
                                                        <div class="form-group">
                                                            <label style="font-weight: bold">Last Name Of Student</label><span style="color: red">*</span>
                                                            <input name="lastNameST" type="text" required maxlength="20" id="lastNameST" class="form-control form-control-lg"
                                                                   >
                                                            <span class="form-message"></span>
                                                        </div>
                                                        <div class="form-group">
                                                            <label style="font-weight: bold">Gender of Student</label>   <span style="color: red">*</span>      
                                                            <div>
                                                                <span style="margin-right: 20px"><input type="radio" name="genderST" value="1"/>Male</span>
                                                                <span><input  type="radio" name="genderST" value="0"/>Female</span>
                                                            </div>
                                                        </div>
                                                        <div class="form-group">
                                                            <label style="font-weight: bold">What interests you? </label><span style="color: red">*</span>
                                                            <input name="likeSomethingST" type="text" id="likeSomethingST" required maxlength="100" class="form-control form-control-lg"
                                                                   >
                                                            <span class="form-message"></span>
                                                        </div>
                                                        <div class="form-group">
                                                            <label style="font-weight: bold">What bothers you?</label><span style="color: red">*</span>
                                                            <input name="hateSomethingST" type="text" id="hateSomethingST" required maxlength="100" class="form-control form-control-lg"
                                                                   >
                                                            <span class="form-message"></span>
                                                        </div>
                                                        <div class="form-group">
                                                            <label style="font-weight: bold">Your favorite food</label><span style="color: red">*</span>
                                                            <input name="favoriteFoodST" type="text" id="favoriteFoodST" required maxlength="100" class="form-control form-control-lg"
                                                                   >
                                                            <span class="form-message"></span>
                                                        </div>
                                                        <div class="form-group">
                                                            <label style="font-weight: bold">Food you dislike</label><span style="color: red">*</span>
                                                            <input name="hateFoodST" type="text" id="hateFoodST" required maxlength="100" class="form-control form-control-lg"
                                                                   >
                                                            <span class="form-message"></span>
                                                        </div>
                                                        <div class="form-group">
                                                            <label style="font-weight: bold">Birthday of Student</label><span style="color: red">*</span>
                                                            <input name="birthST" type="date"
                                                                   class="form-control" id="birthST" placeholder="dd/mm/yyyy">
                                                            <span class="form-message"></span>
                                                        </div>

                                                        <div class="form-group">
                                                            <label style="font-weight: bold">Class Name</label><span style="color: red">*</span>
                                                            <select name="ClassId" class="form-control form-control-lg">
                                                            <c:forEach items="${class}" var="c">
                                                                <option value="${c.classID}">${c.className}</option>
                                                            </c:forEach>
                                                        </select>
                                                    </div>
                                                    <div class="row">
                                                        <div class="imageBox col-2" style="margin-top: 50px;">
                                                            <img style="width: 100%;border-radius: 50%;"
                                                                 src="images/faces/person-icon.png">
                                                            <div class="round2">
                                                                <input name="imgPA" type="file">
                                                                <i style="color: #fff;" class="bi bi-camera"></i>
                                                            </div>


                                                        </div>

                                                        <div class="col-10" style="padding-left: 50px;">
                                                            <h2 style="color: black;margin-top: 50px;margin-bottom: 30px;">Parent Information
                                                            </h2>
                                                            <div class="form-group">
                                                                <label style="font-weight: bold">First Name Of Parents</label><span style="color: red">*</span>
                                                                <input name="firstNamePA" type="text" required maxlength="20" class="form-control form-control-lg"
                                                                       id="firstNamePA">
                                                                <span class="form-message"></span>
                                                            </div>
                                                            <div class="form-group">
                                                                <label style="font-weight: bold">Last Name of Parents</label><span style="color: red">*</span>
                                                                <input name="lastNamePA" type="text" required maxlength="20" class="form-control form-control-lg"
                                                                       id="lastNamePA">
                                                                <span class="form-message"></span>
                                                            </div>
                                                            <div class="form-group">
                                                                <label style="font-weight: bold">Phone Of Parents</label><span style="color: red">*</span>
                                                                <input name="phonePA" type="text" required maxlength="10" class="form-control form-control-lg"
                                                                       id="phonePA" >
                                                                <span class="form-message"></span>
                                                            </div>
                                                            <div class="form-group">
                                                                <label style="font-weight: bold">Birthday Of Parents</label><span style="color: red">*</span>
                                                                <input name="birthPA" type="date"
                                                                       class="form-control" id="birthPA" placeholder="dd/mm/yyyy">
                                                                <span class="form-message"></span>
                                                            </div>
                                                            <div class="form-group">
                                                                <label style="font-weight: bold">Address of Parents</label><span style="color: red">*</span>
                                                                <input name="addressPA" type="text" required maxlength="100" class="form-control form-control-lg"
                                                                       id="addressPA">
                                                                <span class="form-message"></span>
                                                            </div>
                                                            <div class="form-group">
                                                                <label style="font-weight: bold">Job Of Parents</label><span style="color: red">*</span>
                                                                <input name="jobPA" type="text" required maxlength="50" class="form-control form-control-lg"
                                                                       id="jobPA">
                                                                <span class="form-message"></span>
                                                            </div>
                                                        </div>
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
                form: "#formStudentParent",
                errorSelector: '.form-message',
                rules: [
                    Validator.isRequired('#firstNameST', 'First Name of Student cannot be blank'),
                    Validator.isRequired('#lastNameST', 'Last Name of Student cannot be blank'),
                    Validator.isRequired('#likeSomethingST', 'What interests you? cannot be blank'),
                    Validator.isRequired('#hateSomethingST', 'What bothers you? cannot be blank'),
                    Validator.isRequired('#favoriteFoodST', 'Your favorite food cannot be blank'),
                    Validator.isRequired('#hateFoodST', 'Food you dislike cannot be blank'),
                    Validator.isRequired('#birthST', 'Birthday of Student cannot be blank'),
                    Validator.isCheckAge('#birthST', 3, 6),
                    
                    Validator.isRequired('#firstNamePA', 'First Name of Parents cannot be blank'),
                    Validator.isRequired('#lastNamePA', 'Last Name of Parents cannot be blank'),
                    Validator.isRequired('#phonePA', 'Phone of Parents cannot be blank'),
                    Validator.isPhone('#phonePA', 10),
                    Validator.isRequired('#birthPA', 'Birthday of Parents cannot be blank'),
                    Validator.isRequired('#addressPA', 'Address of Parents cannot be blank'),
                    Validator.isRequired('#jobPA', 'Job of Parents cannot be blank')
                ]
            });
        </script>
        <script>
            document.getElementById('formStudentParent').addEventListener('submit', function () {
                alert('Success');
            });
        </script>
    </body>

</html>
