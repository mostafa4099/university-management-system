<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.2/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-Smlep5jCw/wG7hdkwQ/Z5nLIefveQRIY9nfy6xoR1uRYBtpZgI6339F5dgvm/e9B" crossorigin="anonymous">
        <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js" integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49" crossorigin="anonymous"></script>
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.2/js/bootstrap.min.js" integrity="sha384-o+RDsa0aLu++PJvFqy8fFScvbHFLtbvScb8AjopnFD+iEQ7wo/CG0xlczd+2O/em" crossorigin="anonymous"></script>
        <link href="https://bootswatch.com/4/flatly/bootstrap.min.css" rel="stylesheet" type="text/css">
        <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.2.0/css/all.css" integrity="sha384-hWVjflwFxL6sNzntih27bfxkr27PmbbK/iSvJ+a4+0owXq79v+lsFkW54bOGbiDQ" crossorigin="anonymous">
        <script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.7.2/angular.min.js"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/angular-resource/1.7.2/angular-resource.min.js"></script>
        <script src="${pageContext.request.contextPath}/static/js/app.js" type="text/javascript"></script>
        <script src="${pageContext.request.contextPath}/static/js/controller/salary_info_contoller.js" type="text/javascript"></script>
        <link href="${pageContext.request.contextPath}/static/css/style.css" rel="stylesheet" type="text/css"/>
        <title>Mostafa University</title>
    </head>
    <body ng-app="myApp">
        <div class="container-fluid">
            <div>
                <div>
                    <div class="row">
                        <div class="col-sm-12">
                            <nav class="navbar navbar-expand-lg navbar-light bg-light">
                                <a class="navbar-brand" href="${pageContext.request.contextPath}">Main Page</a>
                                <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
                                    <span class="navbar-toggler-icon"></span>
                                </button>
                                <div class="collapse navbar-collapse" id="navbarSupportedContent">
                                    <ul class="navbar-nav mr-auto">
                                        <li class="nav-item active">
                                            <a class="nav-link" href="${pageContext.request.contextPath}/a">Home <span class="sr-only">(current)</span></a>
                                        </li>
                                        <li class="nav-item dropdown">
                                            <a class="nav-link dropdown-toggle" href="#" id="navbardrop" data-toggle="dropdown">
                                                Academic
                                            </a>
                                            <div class="dropdown-menu">
                                                <a class="dropdown-item" href="${pageContext.request.contextPath}/fac/home">Faculty</a>
                                                <a class="dropdown-item" href="${pageContext.request.contextPath}/dep/home">Department</a>
                                                <a class="dropdown-item" href="${pageContext.request.contextPath}/des/home">Designation</a>
                                            </div>
                                        </li>
                                        <li class="nav-item dropdown">
                                            <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                                                Stuff Division
                                            </a>
                                            <div class="dropdown-menu mega-menu meg-col-4" aria-labelledby="navbarDropdown">
                                                <div class="row">
                                                    <div class="col-md-4">
                                                        <p><strong class="sub-menu-heading"><a href="#">Employee</a></strong></p>
                                                        <p><a href="${pageContext.request.contextPath}/emp/home" class="dropdown-item">Add Employee</a></p>
                                                        <p><a href="#" class="dropdown-item">Check Employee</a></p>
                                                        <p><a href="#" class="dropdown-item">Update Employee</a></p>
                                                        <p><a href="#" class="dropdown-item">Remove Employee</a></p>
                                                    </div>
                                                    <div class="col-md-4">
                                                        <p><strong class="sub-menu-heading"><a href="#">Teacher</a></strong></p>
                                                        <p><a href="${pageContext.request.contextPath}/teacher/home" class="dropdown-item">Add Teacher</a></p>
                                                        <p><a href="#" class="dropdown-item">Check Teacher</a></p>
                                                        <p><a href="#" class="dropdown-item">Update Teacher</a></p>
                                                        <p><a href="#" class="dropdown-item">Remove Teacher</a></p>
                                                    </div>
                                                    <div class="col-md-4">
                                                        <p><strong class="sub-menu-heading"><a href="#">Salary</a></strong></p>
                                                        <p><a href="#" class="dropdown-item">Pay Salary</a></p>
                                                        <p><a href="#" class="dropdown-item">Check Salary</a></p>
                                                        <p><a href="#" class="dropdown-item">Update Salary</a></p>
                                                        <p><a href="#" class="dropdown-item">Remove Salary</a></p>
                                                    </div>
                                                </div>
                                            </div>
                                        </li>
                                        <li class="nav-item dropdown">
                                            <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                                                Student Section
                                            </a>
                                            <div class="dropdown-menu mega-menu meg-col-4" aria-labelledby="navbarDropdown">
                                                <div class="row">
                                                    <div class="col-md-4">
                                                        <p><strong class="sub-menu-heading"><a href="#">Student</a></strong></p>
                                                        <p><a href="#" class="dropdown-item">Add Student</a></p>
                                                        <p><a href="#" class="dropdown-item">Check Student Info</a></p>
                                                        <p><a href="#" class="dropdown-item">Update Student</a></p>
                                                        <p><a href="#" class="dropdown-item">Remove Student</a></p>
                                                    </div>
                                                    <div class="col-md-4">
                                                        <p><strong class="sub-menu-heading"><a href="#">Student Assign</a></strong></p>
                                                        <p><a href="#" class="dropdown-item">Assign Student</a></p>
                                                        <p><a href="#" class="dropdown-item">Check Assign Student</a></p>
                                                        <p><a href="#" class="dropdown-item">Update Assign Student</a></p>
                                                        <p><a href="#" class="dropdown-item">Remove Assign Student</a></p>
                                                    </div>
                                                    <div class="col-md-4">
                                                        <p><strong class="sub-menu-heading"><a href="#">Fees</a></strong></p>
                                                        <p><a href="#" class="dropdown-item">Receive Fees</a></p>
                                                        <p><a href="#" class="dropdown-item">Check Fees</a></p>
                                                        <p><a href="#" class="dropdown-item">Update Fees</a></p>
                                                        <p><a href="#" class="dropdown-item">Remove Fees</a></p>
                                                    </div>
                                                </div>
                                            </div>
                                        </li>
                                        <li class="nav-item dropdown">
                                            <a class="nav-link dropdown-toggle" href="#" id="navbardrop" data-toggle="dropdown">
                                                Subject
                                            </a>
                                            <div class="dropdown-menu">
                                                <a class="dropdown-item" href="#">Add Subject</a>
                                                <a class="dropdown-item" href="#">Update Subject</a>
                                                <a class="dropdown-item" href="#">Remove Subject</a>
                                            </div>
                                        </li>
                                        <li class="nav-item dropdown">
                                            <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                                                Examination
                                            </a>
                                            <div class="dropdown-menu mega-menu meg-col-6" aria-labelledby="navbarDropdown">
                                                <div class="row">
                                                    <div class="col-md-6">
                                                        <p><strong class="sub-menu-heading"><a href="#">Exam</a></strong></p>
                                                        <p><a href="#" class="dropdown-item">Add Exam</a></p>
                                                        <p><a href="#" class="dropdown-item">Update Exam</a></p>
                                                        <p><a href="#" class="dropdown-item">Remove Exam</a></p>
                                                    </div>
                                                    <div class="col-md-6">
                                                        <p><strong class="sub-menu-heading"><a href="#">Exam Schedule</a></strong></p>
                                                        <p><a href="#" class="dropdown-item">Add Exam Schedule</a></p>
                                                        <p><a href="#" class="dropdown-item">Update Exam Schedule</a></p>
                                                        <p><a href="#" class="dropdown-item">Remove Exam Schedule</a></p>
                                                    </div>
                                                </div>
                                            </div>
                                        </li>
                                        <li class="nav-item dropdown">
                                            <a class="nav-link dropdown-toggle" href="#" id="navbardrop" data-toggle="dropdown">
                                                Class Routine
                                            </a>
                                            <div class="dropdown-menu">
                                                <a class="dropdown-item" href="#">Add Routine</a>
                                                <a class="dropdown-item" href="#">Update Routine</a>
                                                <a class="dropdown-item" href="#">Remove Routine</a>
                                            </div>
                                        </li>
                                        <li class="nav-item dropdown">
                                            <a class="nav-link dropdown-toggle" href="#" id="navbardrop" data-toggle="dropdown">
                                                Notice
                                            </a>
                                            <div class="dropdown-menu">
                                                <a class="dropdown-item" href="${pageContext.request.contextPath}/notice/home">Add Notice</a>
                                                <a class="dropdown-item" href="${pageContext.request.contextPath}/ncat/home">Notice Category</a>
                                                <a class="dropdown-item" href="#">Update Notice</a>
                                                <a class="dropdown-item" href="#">Remove Notice</a>
                                            </div>
                                        </li>
                                        <li class="nav-item dropdown">
                                            <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                                                Result Section
                                            </a>
                                            <div class="dropdown-menu mega-menu meg-col-4" aria-labelledby="navbarDropdown">
                                                <div class="row">
                                                    <div class="col-md-4">
                                                        <p><strong class="sub-menu-heading"><a href="#">Subject Ways Result</a></strong></p>
                                                        <p><a href="#" class="dropdown-item">Add Result</a></p>
                                                        <p><a href="#" class="dropdown-item">Check Result</a></p>
                                                        <p><a href="#" class="dropdown-item">Update Result</a></p>
                                                        <p><a href="#" class="dropdown-item">Remove Result</a></p>
                                                    </div>
                                                    <div class="col-md-4">
                                                        <p><strong class="sub-menu-heading"><a href="#">Semester Ways Result</a></strong></p>
                                                        <p><a href="#" class="dropdown-item">Add Result</a></p>
                                                        <p><a href="#" class="dropdown-item">Check Result</a></p>
                                                        <p><a href="#" class="dropdown-item">Update Result</a></p>
                                                        <p><a href="#" class="dropdown-item">Remove Result</a></p>
                                                    </div>
                                                    <div class="col-md-4">
                                                        <p><strong class="sub-menu-heading"><a href="#">Final Result</a></strong></p>
                                                        <p><a href="#" class="dropdown-item">Add Result</a></p>
                                                        <p><a href="#" class="dropdown-item">Check Result</a></p>
                                                        <p><a href="#" class="dropdown-item">Update Result</a></p>
                                                        <p><a href="#" class="dropdown-item">Remove Result</a></p>
                                                    </div>
                                                </div>
                                            </div>
                                        </li>
                                    </ul>
                                    <form class="form-inline my-2 my-lg-0">
                                        <button class="btn btn-dark my-2 my-sm-0" type="submit"><i class="fas fa-sign-out-alt">Logout</i></button>
                                    </form>
                                </div>
                            </nav>
                        </div>
                    </div>
                    <div class="row">
                        <div class="col-sm-12" style="padding: 20px 50px;">
                            <div id="demo" class="carousel slide" data-ride="carousel">

                                <!-- Indicators -->
                                <ul class="carousel-indicators">
                                    <li data-target="#demo" data-slide-to="0" class="active"></li>
                                    <li data-target="#demo" data-slide-to="1"></li>
                                    <li data-target="#demo" data-slide-to="2"></li>
                                </ul>

                                <!-- The slideshow -->
                                <div class="carousel-inner">
                                    <div class="carousel-item active">
                                        <img src="${pageContext.request.contextPath}/static/image/carousel/main.jpg" alt="Main Campus" width="100%" height="500" class="mx-auto d-block"/>
                                        <div class="carousel-caption">
                                            <h3>Main Campus</h3>
                                            <p>Main Campus Of University!</p>
                                        </div>
                                    </div>
                                    <div class="carousel-item">
                                        <img src="${pageContext.request.contextPath}/static/image/carousel/graduate.jpeg" alt="University Gateway" width="100%" height="500" class="mx-auto d-block"/>
                                        <div class="carousel-caption">
                                            <h3>Celebration Graduation</h3>
                                            <p>The Graduates celebrate their graduation!</p>
                                        </div>
                                    </div>
                                    <div class="carousel-item">
                                        <img src="${pageContext.request.contextPath}/static/image/carousel/class.jpeg" alt="Class Room" width="100%" height="500" class="mx-auto d-block"/>
                                        <div class="carousel-caption">
                                            <h3>Class Room</h3>
                                            <p>Modern Class Room Of Mostafa University!</p>
                                        </div>
                                    </div>
                                    <div class="carousel-item">
                                        <img src="${pageContext.request.contextPath}/static/image/carousel/library.jpg" alt="Library" width="100%" height="500" class="mx-auto d-block"/>
                                        <div class="carousel-caption">
                                            <h3>Library</h3>
                                            <p>Library Of Mostafa University!</p>
                                        </div>
                                    </div>
                                </div>

                                <!-- Left and right controls -->
                                <a class="carousel-control-prev" href="#demo" data-slide="prev">
                                    <span class="carousel-control-prev-icon"></span>
                                </a>
                                <a class="carousel-control-next" href="#demo" data-slide="next">
                                    <span class="carousel-control-next-icon"></span>
                                </a>

                            </div>
                        </div>
                    </div>
                </div>
                <div class="row">
                    <div class="col-sm-3">
                        <h3 class="text-danger" style="text-align: center">Important Link</h3>
                        <nav style="text-align: center">
                            <ul class="navbar-nav">
                                <li class="nav-item">
                                    <a class="nav-link text-info" href="#">Link 1</a>
                                </li>
                                <li class="nav-item">
                                    <a class="nav-link text-info" href="#">Link 2</a>
                                </li>
                                <li class="nav-item">
                                    <a class="nav-link text-info" href="#">Link 3</a>
                                </li>
                            </ul>

                        </nav>
                    </div>
                    <div class="col-sm-8">
                        <div ng-controller="SalController as objCtrl">
                            <h1 class="text-warning">Salary Info</h1>
                            <form name="objForm" method="POST">
                                <table class="table">
                                    <tr>
                                        <td colspan="2" class="td_border">
                                            <div ng-if="objCtrl.flag != 'edit'">
                                                <h3 class="text-primary">Add New Salary</h3>
                                            </div>
                                            <div ng-if="objCtrl.flag == 'edit'">
                                                <h3 class="text-primary">Update Salary For ID: {{objCtrl.obj.salaryId}}</h3>
                                            </div>
                                        </td>
                                    </tr>
                                    <tr>
                                        <td class="insert_field td_border">Employee Name:</td>
                                        <td class="td_border">
                                            <select ng-model="objCtrl.obj.empInfo" ng-options="x.empName for x in names"></select>
                                        </td>
                                    </tr>
                                    <tr>
                                        <td class="insert_field td_border">Basic Salary:</td>
                                        <td class="td_border">
                                            <input type="text" name="basic" ng-model="objCtrl.obj.basic" ng-change="objCtrl.calc(objCtrl.obj.basic)" required/>
                                            <span ng-show="objForm.basic.$error.required" class="msg-val">Basic Salary is required.</span>
                                        </td>
                                    </tr>
                                    <tr>
                                        <td class="insert_field td_border">Festival:</td>
                                        <td class="td_border">
                                            <input type="text" name="festival" ng-model="objCtrl.obj.festival"/>
                                        </td>
                                    </tr>
                                    <tr>
                                        <td class="insert_field td_border">Others:</td>
                                        <td class="td_border">
                                            <input type="text" name="others" ng-model="objCtrl.obj.others"/>
                                        </td>
                                    </tr>
                                    <tr>
                                        <td class="insert_field td_border">Payment Month:</td>
                                        <td class="td_border">
                                            <input type="date" name="paymentMonth" ng-model="objCtrl.obj.paymentMonth" required/>
                                            <span ng-show="objForm.paymentMonth.$error.required" class="msg-val">Payment Month is required.</span>
                                        </td>
                                    </tr>

                                    <tr>
                                        <td colspan="2" class="td_border">
                                            <span ng-if="objCtrl.flag == 'created'" class="msg-success text-info">Salary Successfully Added.</span>
                                            <span ng-if="objCtrl.flag == 'failed'" class="msg-val text-danger">Salary already exists.</span>
                                        </td>
                                    </tr>
                                    <tr>
                                        <td colspan="2" class="td_border">
                                            <div ng-if="objCtrl.flag != 'edit'">
                                                <input  type="submit" class="text-success" ng-click="objCtrl.addObject()" value="Add Salary"/> 
                                                <input type="button" class="text-success" ng-click="objCtrl.reset()" value="Reset"/>
                                            </div>
                                            <div ng-if="objCtrl.flag == 'edit'">
                                                <input  type="submit" class="text-success" ng-click="objCtrl.updateObjectDetail()" value="Update Salary"/> 	
                                                <input type="button" class="text-success" ng-click="objCtrl.cancelUpdate()" value="Cancel"/>				   
                                            </div>
                                        </td>
                                    </tr>
                                    <tr>
                                        <td colspan="2" class="td_border"> 
                                            <span ng-if="objCtrl.flag == 'deleted'" class="msg-success">Salary successfully deleted.</span>
                                        </td>   
                                    </tr>
                                </table>
                            </form>
                            <table class="table table-hover">
                                <tr class="table-dark">
                                    <th>ID </th>
                                    <th>Name</th>
                                    <th>Basic</th>
                                    <th>House</th>
                                    <th>Medical</th>
                                    <th>Transport</th>
                                    <th>Festival</th>
                                    <th>Others</th>
                                    <th>Total</th>
                                    <th>Month</th>
                                    <th>Date</th>
                                </tr>
                                <tr ng-repeat="row in objCtrl.objArray" class="table-light">
                                    <td><span ng-bind="row.salaryId"></span></td>
                                    <td><span ng-bind="row.empInfo.empName"></span></td>
                                    <td><span ng-bind="row.basic"></span></td>
                                    <td><span ng-bind="row.house"></span></td>
                                    <td><span ng-bind="row.helth"></span></td>
                                    <td><span ng-bind="row.transport"></span></td>
                                    <td><span ng-bind="row.festival"></span></td>
                                    <td><span ng-bind="row.others"></span></td>
                                    <td><span ng-bind="row.total"></span></td>
                                    <td><span ng-bind="row.paymentMonth"></span></td>
                                    <td><span ng-bind="row.payDate"></span></td>
                                    <td>
                                        <input type="button" ng-click="objCtrl.deleteObject(row.salaryId)" value="Delete" style="white-space:pre"/>
                                        <input type="button" ng-click="objCtrl.editObject(row.salaryId)" value="Edit"/>
                                        <span ng-if="objCtrl.flag == 'updated' && row.salaryId == objCtrl.updatedId" class="msg-success text-info">Salary successfully updated.</span>
                                    </td> 
                                </tr>	
                            </table>
                        </div>
                    </div>
                </div>
                <div class="row">
                    <div class="admin-footer col-sm-12 jumbotron bg-secondary">
                        &copy;SNA Management System.
                    </div>
                </div>
            </div>
        </div>

    </body>
</html>
