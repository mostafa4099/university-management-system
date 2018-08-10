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
        <script src="${pageContext.request.contextPath}/static/js/controller/teachers_contoller.js" type="text/javascript"></script>
        <link href="${pageContext.request.contextPath}/static/css/style.css" rel="stylesheet" type="text/css"/>
        <title>Teacher Info</title>
    </head>
    <body ng-app="myApp">
        <div ng-controller="TeacherController as objCtrl">
            <h1>Teacher Info</h1>
            <form name="objForm" method="POST">
                <table>
                    <tr>
                        <td colspan="2">
                            <div ng-if="objCtrl.flag != 'edit'">
                                <h3>Add New Teacher</h3>
                            </div>
                            <div ng-if="objCtrl.flag == 'edit'">
                                <h3>Update Teacher For ID: {{objCtrl.obj.teacherId}}</h3>
                            </div>
                        </td>
                    </tr>
                    <tr>
                        <td>Employee Id:</td>
                        <td>
                            <select ng-model="objCtrl.obj.empInfo" ng-options="x.empId for x in emps"></select>
                        </td>
                    </tr>
                    <tr ng-show="objCtrl.obj.empInfo">
                        <td>Name:</td>
                        <td>
                            <input type="text" name="empInfo" ng-model="objCtrl.obj.empInfo.empName" disabled="disabled"/>
                        </td>
                    </tr>
                    <tr ng-show="objCtrl.obj.empInfo">
                        <td>Designation:</td>
                        <td>
                            <input type="text" name="empInfo.designation" ng-model="objCtrl.obj.empInfo.designation.desigName" disabled="disabled"/>
                        </td>
                    </tr>
                    <tr>
                        <td>Department:</td>
                        <td>
                            <select ng-model="objCtrl.obj.department" ng-options="x.depName for x in names"></select>
                        </td>
                    </tr>
                    
                    <tr>
                        <td colspan="2">
                            <span ng-if="objCtrl.flag == 'created'" class="msg-success">Teacher Successfully Added.</span>
                            <span ng-if="objCtrl.flag == 'failed'" class="msg-val">Teacher already exists.</span>
                        </td>
                    </tr>
                    <tr>
                        <td colspan="2">
                            <div ng-if="objCtrl.flag != 'edit'">
                                <input  type="submit" ng-click="objCtrl.addObject()" value="Add Teacher"/> 
                                <input type="button" ng-click="objCtrl.reset()" value="Reset"/>
                            </div>
                            <div ng-if="objCtrl.flag == 'edit'">
                                <input  type="submit" ng-click="objCtrl.updateObjectDetail()" value="Update Teacher"/> 	
                                <input type="button" ng-click="objCtrl.cancelUpdate()" value="Cancel"/>				   
                            </div>
                        </td>
                    </tr>
                    <tr>
                        <td colspan="2"> 
                            <span ng-if="objCtrl.flag == 'deleted'" class="msg-success">Teacher successfully deleted.</span>
                        </td>   
                    </tr>
                </table>
            </form>
            <table cellspacing="10">
                <tr>
                    <th style="padding-left: 10px">Teacher ID </th>
                    <th style="padding-left: 10px">Employee Id</th>
                    <th style="padding-left: 10px">Name</th>
                    <th style="padding-left: 10px">Designation</th>
                    <th style="padding-left: 10px">Department</th>
                    <th style="padding-left: 10px">Picture</th>
                    <th style="padding-left: 10px" colspan="2">Action</th>
                </tr>
                <tr ng-repeat="row in objCtrl.objArray">
                    <td style="padding-left: 10px"><span ng-bind="row.teacherId"></span></td>
                    <td style="padding-left: 10px"><span ng-bind="row.empInfo.empId"></span></td>
                    <td style="padding-left: 10px"><span ng-bind="row.empInfo.empFather"></span></td>
                    <td style="padding-left: 10px"><span ng-bind="row.empInfo.designation.desigName"></span></td>
                    <td style="padding-left: 10px"><span ng-bind="row.department.depName"></span></td>
                    <td style="padding-left: 10px"><span ng-bind="row.empInfo.empPic"></span></td>
                    <td style="padding-left: 10px">
                        <input type="button" ng-click="objCtrl.deleteObject(row.teacherId)" value="Delete" style="padding-left: 10px"/>
                        <input type="button" ng-click="objCtrl.editObject(row.teacherId)" value="Edit"/>
                        <span ng-if="objCtrl.flag == 'updated' && row.teacherId == objCtrl.updatedId" class="msg-success">Teacher successfully updated.</span>
                    </td> 
                </tr>	
            </table>
        </div>
    </body>
</html>
