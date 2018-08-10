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
        <link href="https://bootswatch.com/4/darkly/bootstrap.min.css" rel="stylesheet" type="text/css">
        <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.2.0/css/all.css" integrity="sha384-hWVjflwFxL6sNzntih27bfxkr27PmbbK/iSvJ+a4+0owXq79v+lsFkW54bOGbiDQ" crossorigin="anonymous">
        <script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.7.2/angular.min.js"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/angular-resource/1.7.2/angular-resource.min.js"></script>
        <script src="${pageContext.request.contextPath}/static/js/app.js" type="text/javascript"></script>
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
                                        <li class="nav-item active">
                                            <a class="nav-link" href="${pageContext.request.contextPath}/t">Home <span class="sr-only">(current)</span></a>
                                        </li>
                                        <li class="nav-item dropdown">
                                            <a class="nav-link dropdown-toggle" href="#" id="navbardrop" data-toggle="dropdown">
                                                Profile
                                            </a>
                                            <div class="dropdown-menu">
                                                <a class="dropdown-item" href="#">Check Profile</a>
                                                <a class="dropdown-item" href="#">Update Profile</a>
                                                <a class="dropdown-item" href="#">Salary Info</a>
                                            </div>
                                        </li>
                                        <li class="nav-item dropdown">
                                            <a class="nav-link dropdown-toggle" href="#" id="navbardrop" data-toggle="dropdown">
                                                Result
                                            </a>
                                            <div class="dropdown-menu">
                                                <a class="dropdown-item" href="${pageContext.request.contextPath}/subres/home">Add Result</a>
                                                <a class="dropdown-item" href="#">Check Result</a>
                                                <a class="dropdown-item" href="#">Update Result</a>
                                                <a class="dropdown-item" href="#">Remove Result</a>
                                            </div>
                                        </li>
                                        <li class="nav-item dropdown">
                                            <a class="nav-link dropdown-toggle" href="#" id="navbardrop" data-toggle="dropdown">
                                                Academic
                                            </a>
                                            <div class="dropdown-menu">
                                                <a class="dropdown-item" href="#">Check Student Info</a>
                                                <a class="dropdown-item" href="#">Check Class Routine</a>
                                                <a class="dropdown-item" href="#">Check Exam Schedule</a>
                                            </div>
                                        </li>
                                        <li class="nav-item dropdown">
                                            <a class="nav-link dropdown-toggle" href="#" id="navbardrop" data-toggle="dropdown">
                                                Attendance
                                            </a>
                                            <div class="dropdown-menu">
                                                <a class="dropdown-item" href="${pageContext.request.contextPath}/attend/home">Add Attendance</a>
                                                <a class="dropdown-item" href="#">Check Attendance</a>
                                                <a class="dropdown-item" href="#">Update Attendance</a>
                                                <a class="dropdown-item" href="#">Remove Attendance</a>
                                            </div>
                                        </li>
                                    </ul>
                                    <form class="form-inline my-2 my-lg-0">
                                        <button class="btn btn-danger my-2 my-sm-0" type="submit"><i class="fas fa-sign-out-alt">Logout</i></button>
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
                        <h2 style="font-weight: bolder">Hello {{}}</h2>
                        <p>Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries, but also the leap into electronic typesetting, remaining essentially unchanged. It was popularised in the 1960s with the release of Letraset sheets containing Lorem Ipsum passages, and more recently with desktop publishing software like Aldus PageMaker including versions of Lorem Ipsum.</p>
                        <p>Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries, but also the leap into electronic typesetting, remaining essentially unchanged. It was popularised in the 1960s with the release of Letraset sheets containing Lorem Ipsum passages, and more recently with desktop publishing software like Aldus PageMaker including versions of Lorem Ipsum.</p>
                        <p>Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries, but also the leap into electronic typesetting, remaining essentially unchanged. It was popularised in the 1960s with the release of Letraset sheets containing Lorem Ipsum passages, and more recently with desktop publishing software like Aldus PageMaker including versions of Lorem Ipsum.</p>
                        <p>Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries, but also the leap into electronic typesetting, remaining essentially unchanged. It was popularised in the 1960s with the release of Letraset sheets containing Lorem Ipsum passages, and more recently with desktop publishing software like Aldus PageMaker including versions of Lorem Ipsum.</p>
                        <p>Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries, but also the leap into electronic typesetting, remaining essentially unchanged. It was popularised in the 1960s with the release of Letraset sheets containing Lorem Ipsum passages, and more recently with desktop publishing software like Aldus PageMaker including versions of Lorem Ipsum.</p>
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
