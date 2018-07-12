<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Home
  Date: 05.12.2017
  Time: 2:11
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="">
    <title>SB Admin</title>
    <!-- Bootstrap core CSS-->
    <link href="<c:url value="/static/vendor/bootstrap/css/bootstrap.min.css" />" rel="stylesheet">
    <!-- Custom fonts for this template-->
    <link href="<c:url value="/static/vendor/font-awesome/css/font-awesome.min.css" />" rel="stylesheet" type="text/css">
    <!-- Page level plugin CSS-->
    <link href="<c:url value="/static/vendor/datatables/dataTables.bootstrap4.css" />" rel="stylesheet">
    <!-- Custom styles for this template-->
    <link href="<c:url value="/static/css/sb-admin.css" />" rel="stylesheet">
</head>

<body class="fixed-nav sticky-footer bg-dark" id="page-top">
<!-- Navigation-->
<nav class="navbar navbar-expand-lg navbar-dark bg-dark fixed-top" id="mainNav">
    <a class="navbar-brand" href="<c:url value="/"/> ">Welcome, ${username}</a>
    <button class="navbar-toggler navbar-toggler-right" type="button" data-toggle="collapse" data-target="#navbarResponsive" aria-controls="navbarResponsive" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
    </button>
    <div class="collapse navbar-collapse" id="navbarResponsive">
        <ul class="navbar-nav navbar-sidenav" id="exampleAccordion">

                <li class="nav-item" data-toggle="tooltip" data-placement="right" title="Tables">
                    <a class="nav-link" href="<c:url value="/" />">
                        <i class="fa fa-fw fa-table"></i>
                        <span class="nav-link-text">Home</span>
                    </a>
                </li>



        </ul>
        <ul class="navbar-nav sidenav-toggler">
            <li class="nav-item">
                <a class="nav-link text-center" id="sidenavToggler">
                    <i class="fa fa-fw fa-angle-left"></i>
                </a>
            </li>
        </ul>
        <ul class="navbar-nav ml-auto">

            <li class="nav-item">
                <a class="nav-link" data-toggle="modal" data-target="#exampleModal">
                    <i class="fa fa-fw fa-sign-out"></i>Logout</a>
            </li>
        </ul>
    </div>
</nav>
<div class="content-wrapper">
    <div class="container-fluid">

        <!-- Example DataTables Card-->
        <div class="card w-75 mx-auto mb-3">
            <div class="card-header">
                <i class="fa fa-area-chart"></i> Student information:</div>
            <div class="card-body">
                <ul class="nav nav-tabs" role="tablist">
                    <li class="nav-item">
                        <a class="nav-link active" href="#profile" role="tab" data-toggle="tab">Profile</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="#parents" role="tab" data-toggle="tab">Parents</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="#documents" role="tab" data-toggle="tab">Documents</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="#education" role="tab" data-toggle="tab">Education</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="#education-history" role="tab" data-toggle="tab">Education History</a>
                    </li>
                </ul>

                <!-- Tab panes -->
                <div class="tab-content">
                    <div role="tabpanel" class="tab-pane fade show active" id="profile">

                        <div class="panel panel-info">
                            <div class="panel-heading">
                                <h3 class="panel-title">${student.firstName} ${student.lastName}</h3>
                            </div>
                            <div class="panel-body">
                                <div class="row">
                                    <div class="col-md-3 col-lg-3 " align="center">
                                        <img alt="User Pic" style="width: 170px;height: 170px;" src="${student.imagePath}" class="rounded-circle img-responsive">
                                    </div>
                                    <br>

                                    <div class=" col-md-9 col-lg-9 ">
                                        <table class="table table-user-information">
                                            <tbody>
                                            <tr>
                                                <td>Date of Birth:</td>
                                                <td>${student.birthDate}</td>
                                            </tr>
                                            <tr>
                                                <td>Gender:</td>
                                                <td>${student.gender}</td>
                                            </tr>
                                            <tr>
                                                <td>Nationality:</td>
                                                <td>${student.nationality}</td>
                                            </tr>

                                            <tr>
                                                <td>Home address:</td>
                                                <td>${student.address}</td>
                                            </tr>

                                            <tr>
                                                <td>Phone Number:</td>
                                                <td>${student.phoneNumber}</td>
                                            </tr>

                                            <tr>
                                                <td>Email</td>
                                                <td><a>${student.email}</a></td>
                                            </tr>













                                            </tbody>
                                        </table>

                                    </div>
                                </div>
                            </div>


                        </div>
                    </div>


                    <div role="tabpanel" class="tab-pane fade" id="parents">
                        <div class="panel panel-info">
                            <div class="panel-heading">
                                <h3 class="panel-title">${student.firstName} ${student.lastName}</h3>
                            </div>
                            <div class="panel-body">
                                <div class="row">
                                    <div class="col-md-3 col-lg-3 " align="center">
                                        <img alt="User Pic" style="width: 170px;height: 170px;" src="${student.imagePath}" class="rounded-circle img-responsive">
                                    </div>
                                    <br>

                                    <div class=" col-md-9 col-lg-9 ">
                                        <table class="table table-user-information">
                                            <tbody>
                                            <tr>
                                                <td>Mother name:</td>
                                                <td>${student.motherName}</td>
                                            </tr>
                                            <tr>
                                                <td>Mother Working Place:</td>
                                                <td>${student.motherWorkingPlace}</td>
                                            </tr>
                                            <tr>
                                                <td>Mother Email:</td>
                                                <td>${student.motherEmail}</td>
                                            </tr>

                                            <tr>
                                                <td>Father name:</td>
                                                <td>${student.fatherName}</td>
                                            </tr>
                                            <tr>
                                                <td>Father Working Place:</td>
                                                <td>${student.fatherWorkingPlace}</td>
                                            </tr>
                                            <tr>
                                                <td>Father Email:</td>
                                                <td>${student.fatherEmail}</td>
                                            </tr>
                                            </tbody>
                                        </table>
                                    </div>
                                </div>
                            </div>


                        </div>

                    </div>
                    <div role="tabpanel" class="tab-pane fade" id="documents">
                        <div class="panel panel-info">
                            <div class="panel-heading">
                                <h3 class="panel-title">${student.firstName} ${student.lastName}</h3>
                            </div>
                            <div class="panel-body">
                                <div class="row">
                                    <div class="col-md-3 col-lg-3 " align="center">
                                        <img alt="User Pic" style="width: 170px;height: 170px;" src="${student.imagePath}" class="rounded-circle img-responsive">
                                    </div>
                                    <br>

                                    <div class=" col-md-9 col-lg-9 ">
                                        <table class="table table-user-information">
                                            <tbody>
                                            <tr>
                                                <td>Document Type:</td>
                                                <td>${student.docType}</td>
                                            </tr>
                                            <tr>
                                                <td>Document number:</td>
                                                <td>${student.docNumber}</td>
                                            </tr>
                                            <tr>
                                                <td>The organization which issued the document:</td>
                                                <td>${student.docOrganization}</td>
                                            </tr>
                                            <tr>
                                                <td>Document Expire Date:</td>
                                                <td>${student.docExpire}</td>
                                            </tr>

                                            </tbody>
                                        </table>

                                    </div>
                                </div>
                            </div>


                        </div>

                    </div>
                    <div role="tabpanel" class="tab-pane fade" id="education">
                        <div class="panel panel-info">
                            <div class="panel-heading">
                                <h3 class="panel-title">${student.firstName} ${student.lastName}</h3>
                            </div>
                            <div class="panel-body">
                                <div class="row">
                                    <div class="col-md-3 col-lg-3 " align="center">
                                        <img alt="User Pic" style="width: 170px;height: 170px;" src="${student.imagePath}" class="rounded-circle img-responsive">
                                    </div>
                                    <br>

                                    <div class=" col-md-9 col-lg-9 ">
                                        <table class="table table-user-information">
                                            <tbody>
                                            <tr>
                                                <td>Faculty:</td>
                                                <td>${student.specialty.faculty.name}</td>
                                            </tr>

                                            <tr>
                                                <td>Specialty:</td>
                                                <td>${student.specialty.name}</td>
                                            </tr>

                                            <tr>
                                                <td>Entry year:</td>
                                                <td>${student.entryYear}</td>
                                            </tr>

                                            <tr>
                                                <td>Education Level:</td>
                                                <td>${student.eduLevel}</td>
                                            </tr>

                                            <tr>
                                                <td>Payment Type:</td>
                                                <td>${student.paymentType}</td>
                                            </tr>


                                            </tbody>
                                        </table>



                                    </div>
                                </div>
                            </div>


                        </div>

                    </div>
                    <div role="tabpanel" class="tab-pane fade" id="education-history">
                        <div class="card mb-3">
                            <div class="card-header">
                                <i class="fa fa-table"></i> List of Education Histories:</div>
                            <div class="card-body">
                                <div class="table-responsive">
                                    <table class="table table-bordered" id="dataTable" width="100%" cellspacing="0">
                                        <thead>
                                        <tr>
                                            <th>Name</th>
                                            <th>Address</th>
                                            <th>During Time</th>

                                        </tr>
                                        </thead>
                                        <tfoot>
                                        <tr>
                                            <th>Name</th>
                                            <th>Address</th>
                                            <th>During Time</th>
                                        </tr>
                                        </tfoot>
                                        <tbody>
                                        <c:forEach items="${edu_histories}" var="history"  >
                                            <tr>
                                                <td>${history.educatedPlaceName}</td>
                                                <td>${history.address}</td>
                                                <td>${history.duringTime}</td>




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
    <!-- /.container-fluid-->
    <!-- /.content-wrapper-->
    <footer class="sticky-footer">
        <div class="container">
            <div class="text-center">
                <small>Copyright © Abzal Sahitov 2017</small>
            </div>
        </div>
    </footer>
    <!-- Scroll to Top Button-->
    <a class="scroll-to-top rounded" href="#page-top">
        <i class="fa fa-angle-up"></i>
    </a>
    <!-- Logout Modal-->
    <div class="modal fade" id="exampleModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
        <div class="modal-dialog" role="document">
            <div class="modal-content">
                <div class="modal-header">
                    <h5 class="modal-title" id="exampleModalLabel">Ready to Leave?</h5>
                    <button class="close" type="button" data-dismiss="modal" aria-label="Close">
                        <span aria-hidden="true">×</span>
                    </button>
                </div>
                <div class="modal-body">Select "Logout" below if you are ready to end your current session.</div>
                <div class="modal-footer">
                    <button class="btn btn-secondary" type="button" data-dismiss="modal">Cancel</button>
                    <a class="btn btn-primary" href="<c:url value="/logout" /> ">Logout</a>
                </div>
            </div>
        </div>
    </div>
    <!-- Bootstrap core JavaScript-->
    <script src="<c:url value="/static/vendor/jquery/jquery.min.js" /> "></script>
    <script src="<c:url value="/static/vendor/bootstrap/js/bootstrap.bundle.min.js" /> "></script>
    <!-- Core plugin JavaScript-->
    <script src="<c:url value="/static/vendor/jquery-easing/jquery.easing.min.js" />"></script>
    <!-- Page level plugin JavaScript-->
    <script src="<c:url value="/static/vendor/datatables/jquery.dataTables.js" /> "></script>
    <script src="<c:url value="/static/vendor/datatables/dataTables.bootstrap4.js" /> "></script>
    <!-- Custom scripts for all pages-->
    <script src="<c:url value="/static/js/sb-admin.min.js" /> "></script>
    <!-- Custom scripts for this page-->
    <script src="<c:url value="/static/js/sb-admin-datatables.min.js" /> "></script>


</div>
</body>

</html>
