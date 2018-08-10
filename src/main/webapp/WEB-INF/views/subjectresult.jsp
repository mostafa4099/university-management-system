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
        <script src="${pageContext.request.contextPath}/static/js/controller/subject_result_contoller.js" type="text/javascript"></script>
        <link href="${pageContext.request.contextPath}/static/css/style.css" rel="stylesheet" type="text/css"/>
        <title>Subject Wise Result</title>
    </head>
    <body ng-app="myApp">
        <div ng-controller="SubResController as objCtrl">
            <h1>Subject Wise Result</h1>
            <form name="objForm" method="POST">
                <table>
                    <tr>
                        <td colspan="2">
                            <div ng-if="objCtrl.flag != 'edit'">
                                <h3>Add A New Subject Result</h3>
                            </div>
                            <div ng-if="objCtrl.flag == 'edit'">
                                <h3>Update Subject Result For ID: {{objCtrl.obj.subResultId}}</h3>
                            </div>
                        </td>
                    </tr>
                    <tr>
                        <td>Student Name:</td>
                        <td>
                            <select ng-model="objCtrl.obj.studentInfo" ng-options="x.stName for x in students"></select>
                        </td>
                    </tr>
                    <tr>
                        <td>Subject:</td>
                        <td>
                            <select ng-model="objCtrl.obj.subject" ng-options="x.subName for x in subs"></select>
                        </td>
                    </tr>
                    <tr>
                        <td>Marks:</td>
                        <td>
                            <input type="text" name="marks" ng-model="objCtrl.obj.marks" required/>
                            <span ng-show="objForm.marks.$error.required" class="msg-val">Marks is required.</span>
                        </td>
                    </tr>
                    <tr>
                        <td>Marks Obtain:</td>
                        <td>
                            <input type="text" name="markObtaine" ng-model="objCtrl.obj.markObtaine" required/>
                            <span ng-show="objForm.markObtaine.$error.required" class="msg-val">Marks Obtain is required.</span>
                        </td>
                    </tr>
                    <tr>
                        <td>GPA:</td>
                        <td>
                            <input type="text" name="gpa" ng-model="objCtrl.obj.gpa" required/>
                            <span ng-show="objForm.gpa.$error.required" class="msg-val">GPA is required.</span>
                        </td>
                    </tr>
                    <tr>
                        <td>Grade:</td>
                        <td>
                            <select ng-model="objCtrl.obj.grade" ng-options="x.gradeName for x in names"></select>
                        </td>
                    </tr>
                    
                    <tr>
                        <td colspan="2">
                            <span ng-if="objCtrl.flag == 'created'" class="msg-success">Subject Result Successfully Added.</span>
                            <span ng-if="objCtrl.flag == 'failed'" class="msg-val">Subject Result already exists.</span>
                        </td>
                    </tr>
                    <tr>
                        <td colspan="2">
                            <div ng-if="objCtrl.flag != 'edit'">
                                <input  type="submit" ng-click="objCtrl.addObject()" value="Add Subject Result"/> 
                                <input type="button" ng-click="objCtrl.reset()" value="Reset"/>
                            </div>
                            <div ng-if="objCtrl.flag == 'edit'">
                                <input  type="submit" ng-click="objCtrl.updateObjectDetail()" value="Update Subject Result"/> 	
                                <input type="button" ng-click="objCtrl.cancelUpdate()" value="Cancel"/>				   
                            </div>
                        </td>
                    </tr>
                    <tr>
                        <td colspan="2"> 
                            <span ng-if="objCtrl.flag == 'deleted'" class="msg-success">Subject Result successfully deleted.</span>
                        </td>   
                    </tr>
                </table>
            </form>
            <table>
                <tr>
                    <th style="white-space:pre">ID </th>
                    <th style="white-space:pre">Student Name</th>
                    <th style="white-space:pre">Subject</th>
                    <th style="white-space:pre">Marks</th>
                    <th style="white-space:pre">Marks Obtain</th>
                    <th style="white-space:pre">GPA</th>
                    <th style="white-space:pre">Grade</th>
                </tr>
                <tr ng-repeat="row in objCtrl.objArray">
                    <td style="white-space:pre"><span ng-bind="row.subResultId"></span></td>
                    <td style="white-space:pre"><span ng-bind="row.studentInfo.stName"></span></td>
                    <td style="white-space:pre"><span ng-bind="row.subject.subName"></span></td>
                    <td style="white-space:pre"><span ng-bind="row.marks"></span></td>
                    <td style="white-space:pre"><span ng-bind="row.markObtaine"></span></td>
                    <td style="white-space:pre"><span ng-bind="row.gpa"></span></td>
                    <td style="white-space:pre"><span ng-bind="row.grade.gradeName"></span></td>
                    <td>
                        <input type="button" ng-click="objCtrl.deleteObject(row.subResultId)" value="Delete" style="white-space:pre"/>
                        <input type="button" ng-click="objCtrl.editObject(row.subResultId)" value="Edit"/>
                        <span ng-if="objCtrl.flag == 'updated' && row.subResultId == objCtrl.updatedId" class="msg-success">Subject Result successfully updated.</span>
                    </td> 
                </tr>	
            </table>
        </div>
    </body>
</html>
