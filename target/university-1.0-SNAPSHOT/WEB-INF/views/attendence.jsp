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
        <script src="${pageContext.request.contextPath}/static/js/controller/attendence_contoller.js" type="text/javascript"></script>
        <link href="${pageContext.request.contextPath}/static/css/style.css" rel="stylesheet" type="text/css"/>
        <title>Attendance Info</title>
    </head>
    <body ng-app="myApp">
        <div ng-controller="AttendController as objCtrl">
            <h1>Attendance Info</h1>
            <form name="objForm" method="POST">
                <table>
                    <tr>
                        <td colspan="2">
                            <div ng-if="objCtrl.flag != 'edit'">
                                <h3>Add New Attendance</h3>
                            </div>
                            <div ng-if="objCtrl.flag == 'edit'">
                                <h3>Update Attendance For ID: {{objCtrl.obj.attendId}}</h3>
                            </div>
                        </td>
                    </tr>
                    <tr>
                        <td>Teacher Id:</td>
                        <td>
                            <select ng-model="objCtrl.obj.teachers" ng-options="x.teacherId for x in tea"></select>
                        </td>
                    </tr>
                    <tr ng-show="objCtrl.obj.teachers">
                        <td>Teacher Name:</td>
                        <td>
                            <input type="text" name="teachers.empInfo" ng-model="objCtrl.obj.teachers.empInfo.empName" disabled="disabled"/>
                        </td>
                    </tr>
                    <tr ng-show="objCtrl.obj.teachers">
                        <td>Teacher Department:</td>
                        <td>
                            <input type="text" name="teachers.department" ng-model="objCtrl.obj.teachers.department.depName" disabled="disabled"/>
                        </td>
                    </tr>
                    <tr>
                        <td>Student Roll:</td>
                        <td>
                            <select ng-model="objCtrl.obj.studentInfo" ng-options="x.stRoll for x in students"></select>
                        </td>
                    </tr>
                    <tr ng-show="objCtrl.obj.studentInfo">
                        <td>Student Name:</td>
                        <td>
                            <input type="text" name="studentInfo" ng-model="objCtrl.obj.studentInfo.stName" disabled="disabled"/>
                        </td>
                    </tr>
                    <tr ng-show="objCtrl.obj.studentInfo">
                        <td>Student Department:</td>
                        <td>
                            <input type="text" name="studentInfo.department" ng-model="objCtrl.obj.studentInfo.department.depName" disabled="disabled"/>
                        </td>
                    </tr>
                    <tr ng-show="objCtrl.obj.studentInfo">
                        <td>Student Program:</td>
                        <td>
                            <input type="text" name="studentInfo.program" ng-model="objCtrl.obj.studentInfo.program.proName" disabled="disabled"/>
                        </td>
                    </tr>
                    <tr ng-show="objCtrl.obj.studentInfo">
                        <td>Student Semester:</td>
                        <td>
                            <input type="text" name="studentInfo.semister" ng-model="objCtrl.obj.studentInfo.semister.semName" disabled="disabled"/>
                        </td>
                    </tr>
                    <tr>
                        <td>Subject:</td>
                        <td>
                            <select ng-model="objCtrl.obj.subject" ng-options="x.subName for x in subs"></select>
                        </td>
                    </tr>
                    <tr ng-show="objCtrl.obj.subject">
                        <td>Subject Department:</td>
                        <td>
                            <input type="text" name="subject.department" ng-model="objCtrl.obj.subject.department.depName" disabled="disabled"/>
                        </td>
                    </tr>
                    <tr ng-show="objCtrl.obj.subject">
                        <td>Subject Program:</td>
                        <td>
                            <input type="text" name="subject.program" ng-model="objCtrl.obj.subject.program.proName" disabled="disabled"/>
                        </td>
                    </tr>
                    <tr ng-show="objCtrl.obj.subject">
                        <td>Subject Semester:</td>
                        <td>
                            <input type="text" name="subject.semister" ng-model="objCtrl.obj.subject.semister.semName" disabled="disabled"/>
                        </td>
                    </tr>
                    <tr>
                        <td>Hour:</td>
                        <td>
                            <select ng-model="objCtrl.obj.classHour" ng-options="x.hourName for x in hours"></select>
                        </td>
                    </tr>
                    <tr>
                        <td>Attendance:</td>
                        <td>
                            <select ng-model="objCtrl.obj.attendenceValue" ng-options="x.attValName for x in names"></select>
                        </td>
                    </tr>
                    <tr>
                        <td>Date:</td>
                        <td>
                            <input type="date" name="attendDate" ng-model="objCtrl.obj.attendDate" required/>
                            <span ng-show="objForm.attendDate.$error.required" class="msg-val">Date is required.</span>
                        </td>
                    </tr>
                    
                    <tr>
                        <td colspan="2">
                            <span ng-if="objCtrl.flag == 'created'" class="msg-success">Attendance Successfully Added.</span>
                            <span ng-if="objCtrl.flag == 'failed'" class="msg-val">Attendance already exists.</span>
                        </td>
                    </tr>
                    <tr>
                        <td colspan="2">
                            <div ng-if="objCtrl.flag != 'edit'">
                                <input  type="submit" ng-click="objCtrl.addObject()" value="Add Attendance"/> 
                                <input type="button" ng-click="objCtrl.reset()" value="Reset"/>
                            </div>
                            <div ng-if="objCtrl.flag == 'edit'">
                                <input  type="submit" ng-click="objCtrl.updateObjectDetail()" value="Update Attendance"/> 	
                                <input type="button" ng-click="objCtrl.cancelUpdate()" value="Cancel"/>				   
                            </div>
                        </td>
                    </tr>
                    <tr>
                        <td colspan="2"> 
                            <span ng-if="objCtrl.flag == 'deleted'" class="msg-success">Attendance successfully deleted.</span>
                        </td>   
                    </tr>
                </table>
            </form>
            <table>
                <tr>
                    <th style="padding-left: 10px">Attend Id </th>
                    <th style="padding-left: 10px">Student Name </th>
                    <th style="padding-left: 10px">Teacher Id</th>
                    <th style="padding-left: 10px">Subject</th>
                    <th style="padding-left: 10px">Hour</th>
                    <th style="padding-left: 10px">Attendance</th>
                    <th style="padding-left: 10px">Date</th>
                    <th style="padding-left: 10px" colspan="2">Action</th>
                </tr>
                <tr ng-repeat="row in objCtrl.objArray">
                    <td style="padding-left: 10px"><span ng-bind="row.attendId"></span></td>
                    <td style="padding-left: 10px"><span ng-bind="row.studentInfo.stName"></span></td>
                    <td style="padding-left: 10px"><span ng-bind="row.teachers.teacherId"></span></td>
                    <td style="padding-left: 10px"><span ng-bind="row.subject.subName"></span></td>
                    <td style="padding-left: 10px"><span ng-bind="row.classHour.hourName"></span></td>
                    <td style="padding-left: 10px"><span ng-bind="row.attendenceValue.attValName"></span></td>
                    <td style="padding-left: 10px"><span ng-bind="row.attendDate"></span></td>
                    <td style="padding-left: 10px">
                        <input type="button" ng-click="objCtrl.deleteObject(row.attendId)" value="Delete" style="padding-left: 10px"/>
                        <input type="button" ng-click="objCtrl.editObject(row.attendId)" value="Edit"/>
                        <span ng-if="objCtrl.flag == 'updated' && row.attendId == objCtrl.updatedId" class="msg-success">Attendance successfully updated.</span>
                    </td> 
                </tr>	
            </table>
        </div>
    </body>
</html>
