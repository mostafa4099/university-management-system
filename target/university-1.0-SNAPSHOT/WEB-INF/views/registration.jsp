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
        <link href="https://bootswatch.com/4/sketchy/bootstrap.min.css" rel="stylesheet" type="text/css">
        <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.2.0/css/all.css" integrity="sha384-hWVjflwFxL6sNzntih27bfxkr27PmbbK/iSvJ+a4+0owXq79v+lsFkW54bOGbiDQ" crossorigin="anonymous">
        <script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.7.2/angular.min.js"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/angular-resource/1.7.2/angular-resource.min.js"></script>
        <script src="${pageContext.request.contextPath}/static/js/app.js" type="text/javascript"></script>
        <script src="${pageContext.request.contextPath}/static/js/controller/faculty_contoller.js" type="text/javascript"></script>
        <script src="${pageContext.request.contextPath}/static/js/controller/notice_cat_contoller.js" type="text/javascript"></script>
        <script src="${pageContext.request.contextPath}/static/js/controller/registration_contoller.js" type="text/javascript"></script>
        <link href="${pageContext.request.contextPath}/static/css/style.css" rel="stylesheet" type="text/css"/>
        <title>Mostafa University</title>
    </head>
    <body ng-app="myApp">
        <div class="container-fluid">
            <div>
                <div>
                    <div class="row">
                        <div class="col-sm-12">
                            <nav class="navbar navbar-expand-lg navbar-dark bg-primary">
                                <a class="navbar-brand" href="${pageContext.request.contextPath}">Mostafa University</a>
                                <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarColor03" aria-controls="navbarColor03" aria-expanded="false" aria-label="Toggle navigation">
                                    <span class="navbar-toggler-icon"></span>
                                </button>

                                <div class="collapse navbar-collapse" id="navbarColor01">
                                    <ul class="navbar-nav mr-auto">
                                        <li class="nav-item">
                                            <a class="nav-link" href="${pageContext.request.contextPath}">Home <span class="sr-only">(current)</span></a>
                                        </li>
                                        <li class="nav-item dropdown"  ng-controller="FacController as facCtrl">
                                            <a class="nav-link dropdown-toggle" href="#" id="navbardrop" data-toggle="dropdown">
                                                Academic
                                            </a>
                                            <div class="dropdown-menu">
                                                <a class="dropdown-item" href="#"  ng-repeat="row in facCtrl.objArray">
                                                    <span ng-bind="row.facName"></span>
                                                </a>
                                            </div>
                                        </li>
                                        <li class="nav-item">
                                            <a class="nav-link" href="#"></a>
                                        </li>
                                        <li class="nav-item dropdown"  ng-controller="NcatController as ncatCtrl">
                                            <a class="nav-link dropdown-toggle" href="#" id="navbardrop" data-toggle="dropdown">
                                                Notice
                                            </a>
                                            <div class="dropdown-menu">
                                                <a class="dropdown-item" href="${pageContext.request.contextPath}/nbc/home"  ng-repeat="row in ncatCtrl.objArray">
                                                    <span ng-bind="row.ncatName"></span>
                                                </a>
                                            </div>
                                        </li>
                                        <li class="nav-item">
                                            <a class="nav-link" href="#">About</a>
                                        </li>
                                        <li class="nav-item">
                                            <a class="nav-link" href="#">Contact</a>
                                        </li>
                                        <li class="nav-item active dropdown">
                                            <a class="nav-link dropdown-toggle" href="#" id="navbardrop" data-toggle="dropdown">
                                                <i class="fas fa-sign-in-alt"></i> Login
                                            </a>
                                            <div class="dropdown-menu">
                                                <a class="dropdown-item" href="#"><i class="fas fa-sign-in-alt"></i> Login</a>
                                                <a class="dropdown-item active" href="${pageContext.request.contextPath}/user/home"><i class="fas fa-user-plus"></i> Registration</a>
                                            </div>
                                        </li>
                                    </ul>
                                    <form class="form-inline my-2 my-lg-0">
                                        <input class="form-control mr-sm-2" placeholder="Search" type="text">
                                        <button class="btn btn-secondary my-2 my-sm-0" type="submit">Search</button>
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
                        <div ng-controller="RegController as objCtrl">
                            <h1>User Info</h1>
                            <form name="objForm" method="POST">
                                <table>
                                    <tr>
                                        <td colspan="2">
                                            <div>
                                                <h3>Add New User</h3>
                                            </div>
                                        </td>
                                    </tr>
                                    <tr>
                                        <td>Account Type:</td>
                                        <td>
                                            <select ng-model="objCtrl.obj.accountType" ng-options="y.accTypeName for y in typ"></select>
                                        </td>
                                    </tr>
                                    <tr ng-if ="objCtrl.obj.accountType.accTypeName == 'Teacher'">
                                        <td>
                                            <table>
                                                <tr>
                                                    <td>Id:</td>
                                                    <td>
                                                        <select ng-model="objCtrl.obj.teachers" ng-options="y.teacherId for y in tea"></select>
                                                    </td>
                                                </tr>
                                                <tr ng-show="objCtrl.obj.teachers">
                                                    <td>Name:</td>
                                                    <td>
                                                        <input type="text" name="teachers.empInfo" ng-model="objCtrl.obj.teachers.empInfo.empName" disabled="disabled"/>
                                                    </td>
                                                </tr>
                                                <tr ng-show="objCtrl.obj.teachers">
                                                    <td>Department:</td>
                                                    <td>
                                                        <input type="text" name="teachers.department" ng-model="objCtrl.obj.teachers.department.depName" disabled="disabled"/>
                                                    </td>
                                                </tr>
                                                <tr ng-show="objCtrl.obj.teachers">
                                                    <td>Designation:</td>
                                                    <td>
                                                        <input type="text" name="teachers.empInfo.designation" ng-model="objCtrl.obj.teachers.empInfo.designation.desigName" disabled="disabled"/>
                                                    </td>
                                                </tr>
                                                <tr ng-show="objCtrl.obj.teachers.empInfo">
                                                    <td>User Name:</td>
                                                    <td>
                                                        <input type="text" name="uname" ng-model="objCtrl.obj.uname" required/>
                                                        <span ng-show="objForm.uname.$error.required" class="msg-val">User Name is required.</span>
                                                    </td>
                                                </tr>
                                                <tr ng-show="objCtrl.obj.teachers.empInfo">
                                                    <td>Password:</td>
                                                    <td>
                                                        <input type="text" name="pass" ng-model="objCtrl.obj.pass" required/>
                                                        <span ng-show="objForm.pass.$error.required" class="msg-val">Password is required.</span>
                                                    </td>
                                                </tr>
                                            </table>
                                        </td>
                                    </tr>
                                    <tr ng-if="objCtrl.obj.accountType.accTypeName == 'Student'">
                                        <td>
                                            <table>
                                                <tr>
                                                    <td>Student Roll:</td>
                                                    <td>
                                                        <select ng-model="objCtrl.obj.studentInfo" ng-options="y.stRoll for y in stu"></select>
                                                    </td>
                                                </tr>
                                                <tr ng-show="objCtrl.obj.studentInfo">
                                                    <td>Student Name:</td>
                                                    <td>
                                                        <input type="text" name="studentInfo" ng-model="objCtrl.obj.studentInfo.stName" disabled="disabled"/>
                                                    </td>
                                                </tr>
                                                <tr ng-show="objCtrl.obj.studentInfo">
                                                    <td>Student Registration:</td>
                                                    <td>
                                                        <input type="text" name="studentInfo" ng-model="objCtrl.obj.studentInfo.stReg" disabled="disabled"/>
                                                    </td>
                                                </tr>
                                                <tr ng-show="objCtrl.obj.studentInfo">
                                                    <td>User Name:</td>
                                                    <td>
                                                        <input type="text" name="uname" ng-model="objCtrl.obj.uname" required/>
                                                        <span ng-show="objForm.uname.$error.required" class="msg-val">User Name is required.</span>
                                                    </td>
                                                </tr>
                                                <tr ng-show="objCtrl.obj.studentInfo">
                                                    <td>Password:</td>
                                                    <td>
                                                        <input type="text" name="pass" ng-model="objCtrl.obj.pass" required/>
                                                        <span ng-show="objForm.pass.$error.required" class="msg-val">Password is required.</span>
                                                    </td>
                                                </tr>
                                            </table>
                                        </td>
                                    </tr>
                                    <tr ng-if="objCtrl.obj.accountType.accTypeName == 'Admin'">
                                        <td><span class="msg-val">You can create only Teacher or Student Account.</span></td>
                                    </tr>

                                    <tr>
                                        <td colspan="2">
                                            <div>
                                                <input  type="submit" ng-click="objCtrl.addObject()" value="Add User"/> 
                                                <input type="button" ng-click="objCtrl.reset()" value="Reset"/>
                                            </div>
                                        </td>
                                    </tr>
                                    <tr>
                                        <td colspan="2">
                                            <span ng-if="objCtrl.flag == 'created'" class="msg-success">User Successfully Added.</span>
                                            <span ng-if="objCtrl.flag == 'failed'" class="msg-val">User already exists.</span>
                                        </td>
                                    </tr>
                                </table>
                            </form>
                        </div>
                    </div>
                </div>
                <div class="row">
                    <div class="footer col-sm-12 jumbotron">
                        &copy;SNA Management System.
                    </div>
                </div>
            </div>
        </div>

    </body>
</html>
