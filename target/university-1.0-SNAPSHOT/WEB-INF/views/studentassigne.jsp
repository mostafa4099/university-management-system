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
        <script src="${pageContext.request.contextPath}/static/js/controller/student_assigne_contoller.js" type="text/javascript"></script>
        <link href="${pageContext.request.contextPath}/static/css/style.css" rel="stylesheet" type="text/css"/>
        <title>Student Assign</title>
    </head>
    <body ng-app="myApp">
        <div ng-controller="AssigneController as objCtrl">
            <h1>Student Assign</h1>
            <form name="objForm" method="POST">
                <table>
                    <tr>
                        <td colspan="2">
                            <div ng-if="objCtrl.flag != 'edit'">
                                <h3>New Student Assign</h3>
                            </div>
                            <div ng-if="objCtrl.flag == 'edit'">
                                <h3>Update Assigned Student For ID: {{objCtrl.obj.assigneId}}</h3>
                            </div>
                        </td>
                    </tr>
                    <tr>
                        <td>Roll Number:</td>
                        <td>
                            <select ng-model="objCtrl.obj.studentInfo" ng-options="x.stRoll for x in students"></select>
                        </td>
                    </tr>
                    <tr ng-show="objCtrl.obj.studentInfo">
                        <td>Name:</td>
                        <td>
                            <input type="text" name="studentInfo" ng-model="objCtrl.obj.studentInfo.stName" disabled="disabled"/>
                        </td>
                    </tr>
                    <tr ng-show="objCtrl.obj.studentInfo">
                        <td>Session:</td>
                        <td>
                            <input type="text" name="studentInfo" ng-model="objCtrl.obj.studentInfo.stSession" disabled="disabled"/>
                        </td>
                    </tr>
                    <tr>
                        <td>Department:</td>
                        <td>
                            <select ng-model="objCtrl.obj.department" ng-options="x.depName for x in departments"></select>
                        </td>
                    </tr>
                    <tr>
                        <td>Program:</td>
                        <td>
                            <select ng-model="objCtrl.obj.program" ng-options="x.proName for x in programs"></select>
                        </td>
                    </tr>
                    <tr>
                        <td>Semester:</td>
                        <td>
                            <select ng-model="objCtrl.obj.semister" ng-options="x.semName for x in semisters"></select>
                        </td>
                    </tr>
                    <tr>
                        <td>Subject:</td>
                        <td>
                            <select ng-model="objCtrl.obj.subject" ng-options="x.subName for x in subs"></select>
                        </td>
                    </tr>

                    <tr>
                        <td colspan="2">
                            <span ng-if="objCtrl.flag == 'created'" class="msg-success">Student Assigned Successful.</span>
                            <span ng-if="objCtrl.flag == 'failed'" class="msg-val">Subject already Assigned.</span>
                        </td>
                    </tr>
                    <tr>
                        <td colspan="2">
                            <div ng-if="objCtrl.flag != 'edit'">
                                <input  type="submit" ng-click="objCtrl.addObject()" value="Assignee Student"/> 
                                <input type="button" ng-click="objCtrl.reset()" value="Reset"/>
                            </div>
                            <div ng-if="objCtrl.flag == 'edit'">
                                <input  type="submit" ng-click="objCtrl.updateObjectDetail()" value="Update Assigned Student"/> 	
                                <input type="button" ng-click="objCtrl.cancelUpdate()" value="Cancel"/>				   
                            </div>
                        </td>
                    </tr>
                    <tr>
                        <td colspan="2"> 
                            <span ng-if="objCtrl.flag == 'deleted'" class="msg-success">Assigned Student successfully deleted.</span>
                        </td>   
                    </tr>
                </table>
            </form>
            <table>
                <tr>
                    <th style="white-space:pre">Assignee ID </th>
                    <th style="white-space:pre">Student Name</th>
                    <th style="white-space:pre">Session</th>
                    <th style="white-space:pre">Roll Number</th>
                    <th style="white-space:pre">Department</th>
                    <th style="white-space:pre">Program</th>
                    <th style="white-space:pre">Semester</th>
                    <th style="white-space:pre">Subject Name</th>
                </tr>
                <tr ng-repeat="row in objCtrl.objArray">
                    <td style="white-space:pre"><span ng-bind="row.assigneId"></span></td>
                    <td style="white-space:pre"><span ng-bind="row.studentInfo.stName"></span></td>
                    <td style="white-space:pre"><span ng-bind="row.studentInfo.stSession"></span></td>
                    <td style="white-space:pre"><span ng-bind="row.studentInfo.stRoll"></span></td>
                    <td style="white-space:pre"><span ng-bind="row.department.depName"></span></td>
                    <td style="white-space:pre"><span ng-bind="row.program.proName"></span></td>
                    <td style="white-space:pre"><span ng-bind="row.semiste.semName"></span></td>
                    <td style="white-space:pre"><span ng-bind="row.subject.subName"></span></td>
                    <td>
                        <input type="button" ng-click="objCtrl.deleteObject(row.assigneId)" value="Delete" style="white-space:pre"/>
                        <input type="button" ng-click="objCtrl.editObject(row.assigneId)" value="Edit"/>
                        <span ng-if="objCtrl.flag == 'updated' && row.assigneId == objCtrl.updatedId" class="msg-success">Assigned Student successfully updated.</span>
                    </td> 
                </tr>	
            </table>
        </div>
    </body>
</html>
