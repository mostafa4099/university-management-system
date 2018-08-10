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
        <script src="${pageContext.request.contextPath}/static/js/controller/routine_contoller.js" type="text/javascript"></script>
        <link href="${pageContext.request.contextPath}/static/css/style.css" rel="stylesheet" type="text/css"/>
        <title>Routine Info</title>
    </head>
    <body ng-app="myApp">
        <div ng-controller="RoutineController as objCtrl">
            <h1>Routine Info</h1>
            <form name="objForm" method="POST">
                <table>
                    <tr>
                        <td colspan="2">
                            <div ng-if="objCtrl.flag != 'edit'">
                                <h3>Add New Routine</h3>
                            </div>
                            <div ng-if="objCtrl.flag == 'edit'">
                                <h3>Update Routine For ID: {{objCtrl.obj.routineId}}</h3>
                            </div>
                        </td>
                    </tr>
                    <tr>
                        <td>Subject:</td>
                        <td>
                            <select ng-model="objCtrl.obj.subject" ng-options="x.subName for x in subs"></select>
                        </td>
                    </tr>
                    <tr>
                        <td>Day:</td>
                        <td>
                            <select ng-model="objCtrl.obj.classDay" ng-options="x.dayName for x in names"></select>
                        </td>
                    </tr>
                    <tr>
                        <td>Hour:</td>
                        <td>
                            <select ng-model="objCtrl.obj.classHour" ng-options="x.hourName for x in hours"></select>
                        </td>
                    </tr>
                    <tr>
                        <td>Teacher Id:</td>
                        <td>
                            <select ng-model="objCtrl.obj.teachers" ng-options="x.teacherId for x in tea"></select>
                        </td>
                    </tr>
                    
                    <tr>
                        <td colspan="2">
                            <span ng-if="objCtrl.flag == 'created'" class="msg-success">Routine Successfully Added.</span>
                            <span ng-if="objCtrl.flag == 'failed'" class="msg-val">Routine already exists.</span>
                        </td>
                    </tr>
                    <tr>
                        <td colspan="2">
                            <div ng-if="objCtrl.flag != 'edit'">
                                <input  type="submit" ng-click="objCtrl.addObject()" value="Add Routine"/> 
                                <input type="button" ng-click="objCtrl.reset()" value="Reset"/>
                            </div>
                            <div ng-if="objCtrl.flag == 'edit'">
                                <input  type="submit" ng-click="objCtrl.updateObjectDetail()" value="Update Routine"/> 	
                                <input type="button" ng-click="objCtrl.cancelUpdate()" value="Cancel"/>				   
                            </div>
                        </td>
                    </tr>
                    <tr>
                        <td colspan="2"> 
                            <span ng-if="objCtrl.flag == 'deleted'" class="msg-success">Routine successfully deleted.</span>
                        </td>   
                    </tr>
                </table>
            </form>
            <table>
                <tr>
                    <th style="white-space:pre">Routine ID </th>
                    <th style="white-space:pre">Subject</th>
                    <th style="white-space:pre">Day</th>
                    <th style="white-space:pre">Hour</th>
                    <th style="white-space:pre">Teacher</th>
                </tr>
                <tr ng-repeat="row in objCtrl.objArray">
                    <td style="white-space:pre"><span ng-bind="row.routineId"></span></td>
                    <td style="white-space:pre"><span ng-bind="row.subject.subName"></span></td>
                    <td style="white-space:pre"><span ng-bind="row.classDay.dayName"></span></td>
                    <td style="white-space:pre"><span ng-bind="row.classHour.hourName"></span></td>
                    <td style="white-space:pre"><span ng-bind="row.teachers.teacherId"></span></td>
                    <td>
                        <input type="button" ng-click="objCtrl.deleteObject(row.routineId)" value="Delete" style="white-space:pre"/>
                        <input type="button" ng-click="objCtrl.editObject(row.routineId)" value="Edit"/>
                        <span ng-if="objCtrl.flag == 'updated' && row.routineId == objCtrl.updatedId" class="msg-success">Routine successfully updated.</span>
                    </td> 
                </tr>	
            </table>
        </div>
    </body>
</html>
