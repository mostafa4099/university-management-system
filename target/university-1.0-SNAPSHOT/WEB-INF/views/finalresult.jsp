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
        <script src="${pageContext.request.contextPath}/static/js/controller/final_result_contoller.js" type="text/javascript"></script>
        <link href="${pageContext.request.contextPath}/static/css/style.css" rel="stylesheet" type="text/css"/>
        <title>Final Result</title>
    </head>
    <body ng-app="myApp">
        <div ng-controller="FinalResController as objCtrl">
            <h1>Final Result</h1>
            <form name="objForm" method="POST">
                <table>
                    <tr>
                        <td colspan="2">
                            <div ng-if="objCtrl.flag != 'edit'">
                                <h3>Add Final Result</h3>
                            </div>
                            <div ng-if="objCtrl.flag == 'edit'">
                                <h3>Update Result For ID: {{objCtrl.obj.cgpaId}}</h3>
                            </div>
                        </td>
                    </tr>
                    <tr>
                        <td>Department:</td>
                        <td>
                            <select ng-model="objCtrl.obj.department" ng-options="x.depName for x in deps"></select>
                        </td>
                    </tr>
                    <tr>
                        <td>Program:</td>
                        <td>
                            <select ng-model="objCtrl.obj.program" ng-options="x.proName for x in pros"></select>
                        </td>
                    </tr>
                    <tr>
                        <td>Student Name:</td>
                        <td>
                            <select ng-model="objCtrl.obj.studentInfo" ng-options="x.stName for x in students"></select>
                        </td>
                    </tr>
                    <tr>
                        <td>CGPA:</td>
                        <td>
                            <input type="text" name="cgpa" ng-model="objCtrl.obj.cgpa" required/>
                            <span ng-show="objForm.cgpa.$error.required" class="msg-val">CGPA is required.</span>
                        </td>
                    </tr>
                    <tr>
                        <td>Grade:</td>
                        <td>
                            <select ng-model="objCtrl.obj.grade" ng-options="x.gradeName for x in grades"></select>
                        </td>
                    </tr>
                    
                    <tr>
                        <td colspan="2">
                            <span ng-if="objCtrl.flag == 'created'" class="msg-success">Result Successfully Added.</span>
                            <span ng-if="objCtrl.flag == 'failed'" class="msg-val">Result already exists.</span>
                        </td>
                    </tr>
                    <tr>
                        <td colspan="2">
                            <div ng-if="objCtrl.flag != 'edit'">
                                <input  type="submit" ng-click="objCtrl.addObject()" value="Add Result"/> 
                                <input type="button" ng-click="objCtrl.reset()" value="Reset"/>
                            </div>
                            <div ng-if="objCtrl.flag == 'edit'">
                                <input  type="submit" ng-click="objCtrl.updateObjectDetail()" value="Update Result"/> 	
                                <input type="button" ng-click="objCtrl.cancelUpdate()" value="Cancel"/>				   
                            </div>
                        </td>
                    </tr>
                    <tr>
                        <td colspan="2"> 
                            <span ng-if="objCtrl.flag == 'deleted'" class="msg-success">Result successfully deleted.</span>
                        </td>   
                    </tr>
                </table>
            </form>
            <table>
                <tr>
                    <th style="white-space:pre">ID </th>
                    <th style="white-space:pre">Student Name</th>
                    <th style="white-space:pre">Department</th>
                    <th style="white-space:pre">Program</th>
                    <th style="white-space:pre">CGPA</th>
                    <th style="white-space:pre">Grade</th>
                </tr>
                <tr ng-repeat="row in objCtrl.objArray">
                    <td style="white-space:pre"><span ng-bind="row.cgpaId"></span></td>
                    <td style="white-space:pre"><span ng-bind="row.studentInfo.stName"></span></td>
                    <td style="white-space:pre"><span ng-bind="row.department.depName"></span></td>
                    <td style="white-space:pre"><span ng-bind="row.program.proName"></span></td>
                    <td style="white-space:pre"><span ng-bind="row.cgpa"></span></td>
                    <td style="white-space:pre"><span ng-bind="row.grade.gradeName"></span></td>
                    <td>
                        <input type="button" ng-click="objCtrl.deleteObject(row.cgpaId)" value="Delete" style="white-space:pre"/>
                        <input type="button" ng-click="objCtrl.editObject(row.cgpaId)" value="Edit"/>
                        <span ng-if="objCtrl.flag == 'updated' && row.cgpaId == objCtrl.updatedId" class="msg-success">Result successfully updated.</span>
                    </td> 
                </tr>	
            </table>
        </div>
    </body>
</html>
