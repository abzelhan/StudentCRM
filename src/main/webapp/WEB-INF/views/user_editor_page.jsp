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
    <link href="<c:url value="/static/vendor/font-awesome/css/font-awesome.min.css" />" rel="stylesheet"
          type="text/css">
    <!-- Page level plugin CSS-->
    <link href="<c:url value="/static/vendor/datatables/dataTables.bootstrap4.css" />" rel="stylesheet">
    <!-- Custom styles for this template-->
    <link href="<c:url value="/static/css/sb-admin.css" />" rel="stylesheet">
</head>

<body class="fixed-nav sticky-footer bg-dark" id="page-top">
<!-- Navigation-->
<nav class="navbar navbar-expand-lg navbar-dark bg-dark fixed-top" id="mainNav">
    <a class="navbar-brand" href="<c:url value="/"/> ">Welcome, ${username}</a>
    <button class="navbar-toggler navbar-toggler-right" type="button" data-toggle="collapse"
            data-target="#navbarResponsive" aria-controls="navbarResponsive" aria-expanded="false"
            aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
    </button>
    <div class="collapse navbar-collapse" id="navbarResponsive">
        <ul class="navbar-nav navbar-sidenav" id="exampleAccordion">
            <li class="nav-item" data-toggle="tooltip" data-placement="right" title="Tables">
                <a class="nav-link" href="<c:url value="/" />">
                    <i class="fa fa-fw fa-table"></i>
                    <span class="nav-link-text">Users</span>
                </a>
            </li>
            <li class="nav-item" data-toggle="tooltip" data-placement="right" title="User Editor">
                <a class="nav-link " href="<c:url value="/registration"></c:url> ">
                    <i class="fa fa-fw fa-wrench"></i>
                    <span class="nav-link-text">User Editor</span>
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
                <i class="fa fa-area-chart"></i> Student information:
            </div>
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
                        <a class="nav-link" href="#education_history" role="tab" data-toggle="tab">Education History</a>
                    </li>
                </ul>

                <!-- Tab panes -->
                <div class="tab-content">
                    <div role="tabpanel" class="tab-pane fade show active" id="profile">

                        <div class=" mx-auto ">
                            <form class="form-horizontal" action="<c:url value="/user/update-basic-${userId}"/>"
                                  method="post">


                                <input type="hidden"
                                       name="${_csrf.parameterName}"
                                       value="${_csrf.token}"/>
                                <div class="form-group">
                                    <label class="col-md-10 control-label" for="Name (Full name)">Name </label>
                                    <div class="col-md-10">
                                        <div class="input-group">
                                            <div class="input-group-addon">
                                                <i class="fa fa-user">
                                                </i>
                                            </div>
                                            <input id="Name (Full name)" name="name" value="${student.firstName}"
                                                   type="text" placeholder="Name" class="form-control input-md">
                                        </div>
                                    </div>
                                </div>

                                <div class="form-group">
                                    <label class="col-md-10 control-label" for="surname">Surname </label>
                                    <div class="col-md-10">
                                        <div class="input-group">
                                            <div class="input-group-addon">
                                                <i class="fa fa-user">
                                                </i>
                                            </div>
                                            <input id="surname" name="surname" value="${student.lastName}" type="text"
                                                   placeholder="Surname" class="form-control input-md">
                                        </div>
                                    </div>
                                </div>

                                <div class="form-group">
                                    <label class="col-md-10 control-label" for="birthDate">Birth date </label>
                                    <div class="col-md-10">
                                        <div class="input-group">
                                            <div class="input-group-addon">
                                                <i class="fa fa-calendar">
                                                </i>
                                            </div>
                                            <input class="form-control" name="birth_date" value="${student.birthDate}"
                                                   type="date" id="birthDate"></div>
                                    </div>
                                </div>


                                <div class="form-group">
                                    <label class="col-md-10 control-label" for="gender">Gender</label>
                                    <div class="col-md-10">
                                        <div class="input-group">
                                            <div class="input-group-addon">
                                                <i class="fa fa-child">
                                                </i>
                                            </div>
                                            <select name="gender" class="form-control" id="gender">

                                                <option value="Male" selected>Male</option>
                                                <option value="Female">Female</option>


                                            </select>
                                        </div>
                                    </div>
                                </div>

                                <div class="form-group">
                                    <label class="col-md-10 control-label" for="nationality">Nationality</label>
                                    <div class="col-md-10">
                                        <div class="input-group">
                                            <div class="input-group-addon">
                                                <i class="fa fa-intersex">
                                                </i>
                                            </div>
                                            <select name="nationality" class="form-control" id="nationality">

                                                <option value="Kazakh" selected>Kazakh</option>
                                                <option value="Russian">Russian</option>


                                            </select>
                                        </div>
                                    </div>
                                </div>


                                <div class="form-group">
                                    <label class="col-md-10 control-label" for="address">Home address </label>
                                    <div class="col-md-10">
                                        <div class="input-group">
                                            <div class="input-group-addon">
                                                <i class="fa fa-home">
                                                </i>
                                            </div>
                                            <input id="address" name="address" type="text" value="${student.address}"
                                                   placeholder="Home address" class="form-control input-md">
                                        </div>
                                    </div>
                                </div>

                                <div class="form-group">
                                    <label class="col-md-10 control-label" for="phone_number">Phone number</label>
                                    <div class="col-md-10">
                                        <div class="input-group">
                                            <div class="input-group-addon">
                                                <i class="fa fa-phone">
                                                </i>
                                            </div>
                                            <input id="phone_number" name="phone_number" value="${student.phoneNumber}"
                                                   type="text" placeholder="Phone number" class="form-control input-md">
                                        </div>
                                    </div>
                                </div>


                                <div class="form-group">
                                    <label class="col-md-10 control-label" for="email">Email</label>
                                    <div class="col-md-10">
                                        <div class="input-group">
                                            <div class="input-group-addon">
                                                <i class="fa fa-envelope">
                                                </i>
                                            </div>
                                            <input id="email" name="email" type="email" value="${student.email}"
                                                   placeholder="Email in format xxx@gmail.com"
                                                   class="form-control input-md">
                                        </div>
                                    </div>
                                </div>

                                <div class="form-group">
                                    <label class="col-md-10 control-label" for="imageURL">Image URL path</label>
                                    <div class="col-md-10">
                                        <div class="input-group">
                                            <div class="input-group-addon">
                                                <i class="fa fa-image">
                                                </i>
                                            </div>
                                            <input id="imageURL" name="imageURL" value="${student.imagePath}"
                                                   type="text" placeholder="URL" class="form-control input-md">
                                        </div>
                                    </div>
                                </div>


                                <div class="form-group">
                                    <label class="col-md-4 control-label"></label>
                                    <div class="col-md-4">
                                        <input class="btn btn-success" type="submit" value="Submit">
                                        <a href="<c:url value="/home"></c:url> " class="btn btn-danger" value=""><span
                                                class="glyphicon glyphicon-remove-sign"></span> Cancel</a>
                                    </div>
                                </div>


                            </form>
                        </div>


                    </div>

                    <div role="tabpanel" class="tab-pane fade" id="parents">
                        <div class=" mx-auto ">
                            <form class="form-horizontal" action="<c:url value="/user/update-parents-${userId}"/>"
                                  method="post">

                                <input type="hidden"
                                       name="${_csrf.parameterName}"
                                       value="${_csrf.token}"/>
                                <div class="form-group">
                                    <label class="col-md-10 control-label" for="mother_name">Mother name</label>
                                    <div class="col-md-10">
                                        <div class="input-group">
                                            <div class="input-group-addon">
                                                <i class="fa fa-user">
                                                </i>
                                            </div>
                                            <input id="mother_name" name="mother_name" value="${student.motherName}"
                                                   type="text" placeholder="Name" class="form-control input-md">
                                        </div>
                                    </div>
                                </div>

                                <div class="form-group">
                                    <label class="col-md-10 control-label" for="mother_working_place">Mother working
                                        place</label>
                                    <div class="col-md-10">
                                        <div class="input-group">
                                            <div class="input-group-addon">
                                                <i class="fa fa-newspaper-o">
                                                </i>
                                            </div>
                                            <input id="mother_working_place" name="mother_working_place"
                                                   value="${student.motherWorkingPlace}" type="text"
                                                   placeholder="Working Place" class="form-control input-md">
                                        </div>
                                    </div>
                                </div>

                                <div class="form-group">
                                    <label class="col-md-10 control-label" for="mother_email">Mother email</label>
                                    <div class="col-md-10">
                                        <div class="input-group">
                                            <div class="input-group-addon">
                                                <i class="fa fa-envelope">
                                                </i>
                                            </div>
                                            <input id="mother_email" name="mother_email" value="${student.motherEmail}"
                                                   type="text" placeholder="Email" class="form-control input-md">
                                        </div>
                                    </div>
                                </div>


                                <div class="form-group">
                                    <label class="col-md-10 control-label" for="father_name">Father name</label>
                                    <div class="col-md-10">
                                        <div class="input-group">
                                            <div class="input-group-addon">
                                                <i class="fa fa-user">
                                                </i>
                                            </div>
                                            <input id="father_name" name="father_name" value="${student.fatherName}"
                                                   type="text" placeholder="Name" class="form-control input-md">
                                        </div>
                                    </div>
                                </div>

                                <div class="form-group">
                                    <label class="col-md-10 control-label" for="father_working_place">Father working
                                        place</label>
                                    <div class="col-md-10">
                                        <div class="input-group">
                                            <div class="input-group-addon">
                                                <i class="fa fa-newspaper-o">
                                                </i>
                                            </div>
                                            <input id="father_working_place" name="father_working_place"
                                                   value="${student.fatherWorkingPlace}" type="text"
                                                   placeholder="Working Place" class="form-control input-md">
                                        </div>
                                    </div>
                                </div>

                                <div class="form-group">
                                    <label class="col-md-10 control-label" for="father_email">Father email</label>
                                    <div class="col-md-10">
                                        <div class="input-group">
                                            <div class="input-group-addon">
                                                <i class="fa fa-envelope">
                                                </i>
                                            </div>
                                            <input id="father_email" name="father_email" value="${student.fatherEmail}"
                                                   type="text" placeholder="Email" class="form-control input-md">
                                        </div>
                                    </div>
                                </div>


                                <div class="form-group">
                                    <label class="col-md-4 control-label"></label>
                                    <div class="col-md-4">
                                        <input class="btn btn-success" type="submit" value="Submit">
                                        <a href="<c:url value="/home"></c:url> " class="btn btn-danger" value=""><span
                                                class="glyphicon glyphicon-remove-sign"></span> Cancel</a>
                                    </div>
                                </div>


                            </form>
                        </div>

                    </div>
                    <div role="tabpanel" class="tab-pane fade" id="documents">


                        <div class=" mx-auto ">
                            <form class="form-horizontal" action="<c:url value="/user/update-documents-${userId}"/>"
                                  method="post">

                                <input type="hidden"
                                       name="${_csrf.parameterName}"
                                       value="${_csrf.token}"/>
                                <div class="form-group">
                                    <label class="col-md-10 control-label" for="doc_number">Document Number</label>
                                    <div class="col-md-10">
                                        <div class="input-group">
                                            <div class="input-group-addon">
                                                <i class="fa fa-sort-numeric-desc">
                                                </i>
                                            </div>
                                            <input id="doc_number" name="doc_number" value="${student.docNumber}"
                                                   type="text" placeholder="Number" class="form-control input-md">
                                        </div>
                                    </div>
                                </div>

                                <div class="form-group">
                                    <label class="col-md-10 control-label" for="doc_type">Document type</label>
                                    <div class="col-md-10">
                                        <div class="input-group">
                                            <div class="input-group-addon">
                                                <i class="fa fa-credit-card-alt">
                                                </i>
                                            </div>
                                            <select name="doc_type" class="form-control" id="doc_type">

                                                <option value="Visa">Visa</option>
                                                <option value="Identity card" selected>Identity card</option>


                                            </select>
                                        </div>
                                    </div>
                                </div>


                                <div class="form-group">
                                    <label class="col-md-10 control-label" for="doc_organization">Document
                                        Organization</label>
                                    <div class="col-md-10">
                                        <div class="input-group">
                                            <div class="input-group-addon">
                                                <i class="fa fa-institution">
                                                </i>
                                            </div>
                                            <input id="doc_organization" name="doc_organization"
                                                   value="${student.docOrganization}" type="text"
                                                   placeholder="Organization" class="form-control input-md">
                                        </div>
                                    </div>
                                </div>


                                <div class="form-group">
                                    <label class="col-md-10 control-label" for="doc_expire">Document Expire Date</label>
                                    <div class="col-md-10">
                                        <div class="input-group">
                                            <div class="input-group-addon">
                                                <i class="fa fa-calendar">
                                                </i>
                                            </div>
                                            <input class="form-control" name="doc_expire" value="${student.docExpire}"
                                                   type="date" id="doc_expire"></div>
                                    </div>
                                </div>

                                <div class="form-group">
                                    <label class="col-md-4 control-label"></label>
                                    <div class="col-md-4">
                                        <input class="btn btn-success" type="submit" value="Submit">
                                        <a href="<c:url value="/home"></c:url> " class="btn btn-danger" value=""><span
                                                class="glyphicon glyphicon-remove-sign"></span> Cancel</a>
                                    </div>
                                </div>

                            </form>

                        </div>

                    </div>
                    <div role="tabpanel" class="tab-pane fade" id="education">
                        <div class=" mx-auto ">
                            <form class="form-horizontal" action="<c:url value="/user/update-education-${userId}"/>"
                                  method="post">

                                <input type="hidden"
                                       name="${_csrf.parameterName}"
                                       value="${_csrf.token}"/>


                                <div class="form-group">
                                    <label class="col-md-10 control-label" for="specialty">Specialty</label>
                                    <div class="col-md-10">
                                        <div class="input-group">
                                            <div class="input-group-addon">
                                                <i class="fa fa-archive">
                                                </i>
                                            </div>
                                            <select name="specialty" class="form-control" id="specialty">
                                                <option selected disabled>Select specialty</option>
                                                <c:forEach items="${specialties}" var="specialty">

                                                    <option value="${specialty.id}">${specialty.name}</option>

                                                </c:forEach>
                                            </select>
                                        </div>
                                    </div>
                                </div>

                                <div class="form-group">
                                    <label class="col-md-10 control-label" for="entryYear">Entry Year</label>
                                    <div class="col-md-10">
                                        <div class="input-group">
                                            <div class="input-group-addon">
                                                <i class="fa fa-calendar">
                                                </i>
                                            </div>
                                            <input class="form-control" name="entry_year" value="${student.entryYear}"
                                                   type="date" id="entryYear"></div>
                                    </div>
                                </div>

                                <div class="form-group">
                                    <label class="col-md-10 control-label" for="edu_levels">Education level</label>
                                    <div class="col-md-10">
                                        <div class="input-group">
                                            <div class="input-group-addon">
                                                <i class="fa fa-book">
                                                </i>
                                            </div>
                                            <select name="edu_level" class="form-control" id="edu_levels">
                                                <option selected disabled>Select education level</option>
                                                <c:forEach items="${edu_levels}" var="level">

                                                    <option value="${level}">${level}</option>

                                                </c:forEach>
                                            </select>
                                        </div>
                                    </div>
                                </div>


                                <div class="form-group">
                                    <label class="col-md-10 control-label" for="payment_type">Payment type</label>
                                    <div class="col-md-10">
                                        <div class="input-group">
                                            <div class="input-group-addon">
                                                <i class="fa fa-credit-card-alt">
                                                </i>
                                            </div>
                                            <select name="payment_type" class="form-control" id="payment_type">
                                                <option selected disabled>Select payment type</option>
                                                <c:forEach items="${payment_types}" var="type">

                                                    <option value="${type}">${type}</option>

                                                </c:forEach>
                                            </select>
                                        </div>
                                    </div>
                                </div>

                                <div class="form-group">
                                    <label class="col-md-4 control-label"></label>
                                    <div class="col-md-4">
                                        <input class="btn btn-success" type="submit" value="Submit">
                                        <a href="<c:url value="/home"></c:url> " class="btn btn-danger" value=""><span
                                                class="glyphicon glyphicon-remove-sign"></span> Cancel</a>
                                    </div>
                                </div>


                            </form>
                        </div>


                    </div>
                    <div role="tabpanel" class="tab-pane fade" id="education_history">

                        <div class=" mx-auto ">
                            <form class="form-horizontal"
                                  action="<c:url value="/user/save-education-history-${userId}"></c:url>" method="post">
                                <input type="hidden"
                                       name="${_csrf.parameterName}"
                                       value="${_csrf.token}"/>

                                <div class="form-group">
                                    <label for="edu_name" class="form-control-label">Education Place Name:</label>
                                    <input type="text" name="name" class="form-control" id="edu_name" required>
                                </div>
                                <div class="form-group">
                                    <label for="edu_address" class="form-control-label">Address:</label>
                                    <input type="text" name="address" class="form-control" id="edu_address" required>
                                </div>
                                <div class="form-group">
                                    <label for="during_time_from" class="form-control-label">During Time From:</label>
                                    <input type="date" name="during_time_from" class="form-control"
                                           id="during_time_from" required>
                                </div>
                                <div class="form-group">
                                    <label for="during_time_to" class="form-control-label">During Time To:</label>
                                    <input type="date" name="during_time_to" class="form-control" id="during_time_to" required>
                                </div>

                                <div class="form-group mx-auto">
                                    <input type="submit" class="btn btn-primary" value="Add">

                                </div>
                            </form>


                            <div class="card mb-3">
                                <div class="card-header">
                                    <i class="fa fa-table"></i> List of Education Histories:
                                </div>
                                <div class="card-body">
                                    <div class="table-responsive">
                                        <table class="table table-bordered" id="dataTable" width="100%" cellspacing="0">
                                            <thead>
                                            <tr>
                                                <th>Name</th>
                                                <th>Address</th>
                                                <th>During Time</th>
                                                <th>Delete</th>


                                            </tr>
                                            </thead>
                                            <tfoot>
                                            <tr>
                                                <th>Name</th>
                                                <th>Address</th>
                                                <th>During Time</th>
                                                <th>Delete</th>
                                            </tr>
                                            </tfoot>
                                            <tbody>
                                            <c:forEach items="${edu_histories}" var="history">
                                                <tr>
                                                    <td>${history.educatedPlaceName}</td>
                                                    <td>${history.address}</td>
                                                    <td>${history.duringTime}</td>
                                                    <td>
                                                        <a href="<c:url value="/user/remove-education-history-${history.id}-${userId}"></c:url> "
                                                           class="btn btn-danger mx-auto custom-width">Delete</a></td>


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
    <div class="modal fade" id="exampleModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel"
         aria-hidden="true">
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
    <script>
        $(function () {
            $('#edu-his').on('submit', function (e) {
                e.preventDefault();
                $.ajax({
                    url: <c:url value="/user/save-education-history-${userId}"></c:url>, //this is the submit URL
                    type: 'POST', //or POST
                    data: $('#edu-his').serialize(),
                    success: function (data) {
                        alert('successfully submitted')
                    }
                });
            });
        });
    </script>
</div>
</body>

</html>
