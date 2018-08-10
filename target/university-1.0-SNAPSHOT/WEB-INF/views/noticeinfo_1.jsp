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
        <script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.7.2/angular.min.js"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/angular-resource/1.7.2/angular-resource.min.js"></script>
        <script src="${pageContext.request.contextPath}/static/js/app.js" type="text/javascript"></script>
        <script src="${pageContext.request.contextPath}/static/js/controller/department_contoller.js" type="text/javascript"></script>
        <script src="${pageContext.request.contextPath}/static/js/controller/notice_cat_contoller.js" type="text/javascript"></script>
        <script src="${pageContext.request.contextPath}/static/js/controller/notice_details_contoller.js" type="text/javascript"></script>
        <link href="${pageContext.request.contextPath}/static/css/style.css" rel="stylesheet" type="text/css"/>
        <title>Notice</title>
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
                                        <li class="nav-item active">
                                            <a class="nav-link" href="${pageContext.request.contextPath}">Home <span class="sr-only">(current)</span></a>
                                        </li>
                                        <li class="nav-item dropdown"  ng-controller="DepController as depCtrl">
                                            <a class="nav-link dropdown-toggle" href="#" id="navbardrop" data-toggle="dropdown">
                                                Department
                                            </a>
                                            <div class="dropdown-menu">
                                                <a class="dropdown-item" href="#"  ng-repeat="row in depCtrl.objArray">
                                                    <span ng-bind="row.depName"></span>
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
                                                <a class="dropdown-item" href="#"  ng-repeat="row in ncatCtrl.objArray">
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
                        <div ng-controller="NoticeController as objCtrl">
                            <h1>Notice</h1>
                            <form name="objForm" method="POST">
                                <table>
                                    <tr>
                                        <td colspan="2">
                                            <div ng-if="objCtrl.flag != 'edit'">
                                                <h3>Add New Notice</h3>
                                            </div>
                                            <div ng-if="objCtrl.flag == 'edit'">
                                                <h3>Update Notice For ID: {{objCtrl.obj.depId}}</h3>
                                            </div>
                                        </td>
                                    </tr>
                                    <tr>
                                        <td>Heading:</td>
                                        <td>
                                            <input type="text" name="heading" ng-model="objCtrl.obj.heading" required/>
                                            <span ng-show="objForm.heading.$error.required" class="msg-val">Heading is required.</span>
                                        </td>
                                    </tr>
                                    <tr>
                                        <td>Main Content:</td>
                                        <td>
                                            <input type="text" name="mainContent" ng-model="objCtrl.obj.mainContent" required/>
                                            <span ng-show="objForm.mainContent.$error.required" class="msg-val">Main Content is required.</span>
                                        </td>
                                    </tr>
                                    <tr>
                                        <td>Category:</td>
                                        <td>
                                            <select ng-model="objCtrl.obj.noticeCategory" ng-options="x.ncatName for x in names"></select>
                                        </td>
                                    </tr>
                                    <tr>
                                        <td>End Date:</td>
                                        <td>
                                            <input type="date" name="endDate" ng-model="objCtrl.obj.endDate" required/>
                                            <span ng-show="objForm.endDate.$error.required" class="msg-val">End Date is required.</span>
                                        </td>
                                    </tr>

                                    <tr>
                                        <td colspan="2">
                                            <span ng-if="objCtrl.flag == 'created'" class="msg-success">Notice Successfully Added.</span>
                                            <span ng-if="objCtrl.flag == 'failed'" class="msg-val">Notice already exists.</span>
                                        </td>
                                    </tr>
                                    <tr>
                                        <td colspan="2">
                                            <div ng-if="objCtrl.flag != 'edit'">
                                                <input  type="submit" ng-click="objCtrl.addObject()" value="Add Notice"/> 
                                                <input type="button" ng-click="objCtrl.reset()" value="Reset"/>
                                            </div>
                                            <div ng-if="objCtrl.flag == 'edit'">
                                                <input  type="submit" ng-click="objCtrl.updateObjectDetail()" value="Update Notice"/> 	
                                                <input type="button" ng-click="objCtrl.cancelUpdate()" value="Cancel"/>				   
                                            </div>
                                        </td>
                                    </tr>
                                    <tr>
                                        <td colspan="2"> 
                                            <span ng-if="objCtrl.flag == 'deleted'" class="msg-success">Notice successfully deleted.</span>
                                        </td>   
                                    </tr>
                                </table>
                            </form>
                            <table>
                                <tr>
                                    <th style="white-space:pre">ID </th>
                                    <th style="white-space:pre">Heading</th>
                                    <th style="white-space:pre">Main Content</th>
                                    <th style="white-space:pre">Category</th>
                                    <th style="white-space:pre">Publish Date</th>
                                    <th style="white-space:pre">End Date</th>
                                </tr>
                                <tr ng-repeat="row in objCtrl.objArray">
                                    <td style="white-space:pre"><span ng-bind="row.noticeId"></span></td>
                                    <td style="white-space:pre;  max-width: 200px"><span ng-bind="row.heading"></span></td>
                                    <td style="white-space:pre;  max-width: 300px"><span ng-bind="row.mainContent"></span></td>
                                    <td style="white-space:pre"><span ng-bind="row.noticeCategory.ncatName"></span></td>
                                    <td style="white-space:pre"><span ng-bind="row.publishDate"></span></td>
                                    <td style="white-space:pre"><span ng-bind="row.endDate"></span></td>
                                    <td>
                                        <input type="button" ng-click="objCtrl.deleteObject(row.noticeId)" value="Delete" style="white-space:pre"/>
                                        <input type="button" ng-click="objCtrl.editObject(row.noticeId)" value="Edit"/>
                                        <span ng-if="objCtrl.flag == 'updated' && row.depId == objCtrl.updatedId" class="msg-success">Notice successfully updated.</span>
                                    </td> 
                                </tr>	
                            </table>
                        </div>
                    </div>
                </div>
                <div class="row">
                    <div class="footer col-sm-12">
                        &copy;SNA Management System.
                    </div>
                </div>
            </div>
        </div>
    </body>
</html>
