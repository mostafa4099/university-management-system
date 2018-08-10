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
        <script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.7.2/angular.min.js"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/angular-resource/1.7.2/angular-resource.min.js"></script>
        <script src="${pageContext.request.contextPath}/static/js/app.js" type="text/javascript"></script>
        <script src="${pageContext.request.contextPath}/static/js/controller/exam_contoller.js" type="text/javascript"></script>
        <link href="${pageContext.request.contextPath}/static/css/style.css" rel="stylesheet" type="text/css"/>
        <title>Exam Info</title>
    </head>
    <body ng-app="myApp">
        <div ng-controller="ExamController as objCtrl">
            <h1>Exam Info</h1>
            <form name="objForm" method="POST">
                <table>
                    <tr>
                        <td colspan="2">
                            <div ng-if="objCtrl.flag != 'edit'">
                                <h3>Add New Exam</h3>
                            </div>
                            <div ng-if="objCtrl.flag == 'edit'">
                                <h3>Update Exam For ID: {{objCtrl.obj.examId}}</h3>
                            </div>
                        </td>
                    </tr>
                    <tr>
                        <td>Department:</td>
                        <td>
                            <select ng-model="objCtrl.obj.department" ng-options="x.depName for x in names"></select>
                        </td>
                    </tr>
                    <tr>
                        <td>Program:</td>
                        <td>
                            <select ng-model="objCtrl.obj.program" ng-options="x.proName for x in pro"></select>
                        </td>
                    </tr>
                    <tr>
                        <td>Semester:</td>
                        <td>
                            <select ng-model="objCtrl.obj.semister" ng-options="x.semName for x in sem"></select>
                        </td>
                    </tr>
                    <tr>
                        <td>Exam Name:</td>
                        <td>
                            <input type="text" name="examName" ng-model="objCtrl.obj.examName" required/>
                            <span ng-show="objForm.examName.$error.required" class="msg-val">Exam Name is required.</span>
                        </td>
                    </tr>
                    
                    
                    <tr>
                        <td colspan="2">
                            <span ng-if="objCtrl.flag == 'created'" class="msg-success">Exam Successfully Added.</span>
                            <span ng-if="objCtrl.flag == 'failed'" class="msg-val">Exam already exists.</span>
                        </td>
                    </tr>
                    <tr>
                        <td colspan="2">
                            <div ng-if="objCtrl.flag != 'edit'">
                                <input  type="submit" ng-click="objCtrl.addObject()" value="Add Exam"/> 
                                <input type="button" ng-click="objCtrl.reset()" value="Reset"/>
                            </div>
                            <div ng-if="objCtrl.flag == 'edit'">
                                <input  type="submit" ng-click="objCtrl.updateObjectDetail()" value="Update Exam"/> 	
                                <input type="button" ng-click="objCtrl.cancelUpdate()" value="Cancel"/>				   
                            </div>
                        </td>
                    </tr>
                    <tr>
                        <td colspan="2"> 
                            <span ng-if="objCtrl.flag == 'deleted'" class="msg-success">Exam successfully deleted.</span>
                        </td>   
                    </tr>
                </table>
            </form>
            <table>
                <tr>
                    <th style="white-space:pre">Exam ID </th>
                    <th style="white-space:pre">Exam Name</th>
                    <th style="white-space:pre">Department</th>
                    <th style="white-space:pre">Program</th>
                    <th style="white-space:pre">Semester</th>
                </tr>
                <tr ng-repeat="row in objCtrl.objArray">
                    <td style="white-space:pre"><span ng-bind="row.examId"></span></td>
                    <td style="white-space:pre"><span ng-bind="row.examName"></span></td>
                    <td style="white-space:pre"><span ng-bind="row.department.depName"></span></td>
                    <td style="white-space:pre"><span ng-bind="row.program.proName"></span></td>
                    <td style="white-space:pre"><span ng-bind="row.semister.semName"></span></td>
                    <td>
                        <input type="button" ng-click="objCtrl.deleteObject(row.examId)" value="Delete" style="white-space:pre"/>
                        <input type="button" ng-click="objCtrl.editObject(row.examId)" value="Edit"/>
                        <span ng-if="objCtrl.flag == 'updated' && row.examId == objCtrl.updatedId" class="msg-success">Exam successfully updated.</span>
                    </td> 
                </tr>	
            </table>
        </div>
    </body>
</html>
