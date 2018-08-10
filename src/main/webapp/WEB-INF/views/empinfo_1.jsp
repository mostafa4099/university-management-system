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
        <script src="${pageContext.request.contextPath}/static/js/controller/emp_info_contoller.js" type="text/javascript"></script>
        <link href="${pageContext.request.contextPath}/static/css/style.css" rel="stylesheet" type="text/css"/>
        <title>Employee Info</title>
    </head>
    <body ng-app="myApp">
        <div ng-controller="EmpController as objCtrl">
            <h1>Employee Info</h1>
            <form name="objForm" method="POST">
                <table>
                    <tr>
                        <td colspan="2">
                            <div ng-if="objCtrl.flag != 'edit'">
                                <h3>Add New Employee</h3>
                            </div>
                            <div ng-if="objCtrl.flag == 'edit'">
                                <h3>Update Employee For ID: {{objCtrl.obj.empId}}</h3>
                            </div>
                        </td>
                    </tr>
                    <tr>
                        <td>Name:</td>
                        <td>
                            <input type="text" name="empName" ng-model="objCtrl.obj.empName" required/>
                            <span ng-show="objForm.empName.$error.required" class="msg-val">Name is required.</span>
                        </td>
                    </tr>
                    <tr>
                        <td>Father Name:</td>
                        <td>
                            <input type="text" name="empFather" ng-model="objCtrl.obj.empFather" required/>
                            <span ng-show="objForm.empFather.$error.required" class="msg-val">Father Name is required.</span>
                        </td>
                    </tr>
                    <tr>
                        <td>Mother Name:</td>
                        <td>
                            <input type="text" name="empMother" ng-model="objCtrl.obj.empMother" required/>
                            <span ng-show="objForm.empMother.$error.required" class="msg-val">Mother Name is required.</span>
                        </td>
                    </tr>
                    <tr>
                        <td>Address:</td>
                        <td>
                            <input type="text" name="empAddress" ng-model="objCtrl.obj.empAddress" required/>
                            <span ng-show="objForm.empAddress.$error.required" class="msg-val">Address is required.</span>
                        </td>
                    </tr>
                    <tr>
                        <td>Date Of Birth:</td>
                        <td>
                            <input type="date" name="empDob" ng-model="objCtrl.obj.empDob" required/>
                            <span ng-show="objForm.empDob.$error.required" class="msg-val">Date Of Birth is required.</span>
                        </td>
                    </tr>
                    <tr>
                        <td>Mobile Number:</td>
                        <td>
                            <input type="text" name="empMobile" ng-model="objCtrl.obj.empMobile" required/>
                            <span ng-show="objForm.empMobile.$error.required" class="msg-val">Mobile Number is required.</span>
                        </td>
                    </tr>
                    <tr>
                        <td>Designation:</td>
                        <td>
                            <select ng-model="objCtrl.obj.designation" ng-options="x.desigName for x in names"></select>
                        </td>
                    </tr>
                    <tr>
                        <td>Joining Date:</td>
                        <td>
                            <input type="date" name="joinDate" ng-model="objCtrl.obj.joinDate" required/>
                            <span ng-show="objForm.joinDate.$error.required" class="msg-val">Joining Date is required.</span>
                        </td>
                    </tr>
                    <tr>
                        <td>Upload Picture:</td>
                        <td>
                            <input type="text" name="empPic" ng-model="objCtrl.obj.empPic" required/>
                            <span ng-show="objForm.empPic.$error.required" class="msg-val">Employee Picture is required.</span>
                        </td>
                    </tr>

                    <tr>
                        <td colspan="2">
                            <span ng-if="objCtrl.flag == 'created'" class="msg-success">Employee Successfully Added.</span>
                            <span ng-if="objCtrl.flag == 'failed'" class="msg-val">Employee already exists.</span>
                        </td>
                    </tr>
                    <tr>
                        <td colspan="2">
                            <div ng-if="objCtrl.flag != 'edit'">
                                <input  type="submit" ng-click="objCtrl.addObject()" value="Add Employee"/> 
                                <input type="button" ng-click="objCtrl.reset()" value="Reset"/>
                            </div>
                            <div ng-if="objCtrl.flag == 'edit'">
                                <input  type="submit" ng-click="objCtrl.updateObjectDetail()" value="Update Employee"/> 	
                                <input type="button" ng-click="objCtrl.cancelUpdate()" value="Cancel"/>				   
                            </div>
                        </td>
                    </tr>
                    <tr>
                        <td colspan="2"> 
                            <span ng-if="objCtrl.flag == 'deleted'" class="msg-success">Employee successfully deleted.</span>
                        </td>   
                    </tr>
                </table>
            </form>
            <table>
                <tr>
                    <th style="padding-left: 10px">ID </th>
                    <th style="padding-left: 10px">Name</th>
                    <th style="padding-left: 10px">Father</th>
                    <th style="padding-left: 10px">Mother</th>
                    <th style="padding-left: 10px">Address</th>
                    <th style="padding-left: 10px">DOB</th>
                    <th style="padding-left: 10px">Mobile</th>
                    <th style="padding-left: 10px">Joining</th>
                    <th style="padding-left: 10px">Designation</th>
                    <th style="padding-left: 10px">Picture</th>
                    <th style="padding-left: 10px" colspan="2">Action</th>
                </tr>
                <tr ng-repeat="row in objCtrl.objArray">
                    <td style="padding-left: 10px"><span ng-bind="row.empId"></span></td>
                    <td style="padding-left: 10px"><span ng-bind="row.empName"></span></td>
                    <td style="padding-left: 10px"><span ng-bind="row.empFather"></span></td>
                    <td style="padding-left: 10px"><span ng-bind="row.empMother"></span></td>
                    <td style="padding-left: 10px"><span ng-bind="row.empAddress"></span></td>
                    <td style="padding-left: 10px"><span ng-bind="row.empDob"></span></td>
                    <td style="padding-left: 10px"><span ng-bind="row.empMobile"></span></td>
                    <td style="padding-left: 10px"><span ng-bind="row.joinDate"></span></td>
                    <td style="padding-left: 10px"><span ng-bind="row.designation.desigName"></span></td>
                    <td style="padding-left: 10px"><span ng-bind="row.empPic"></span></td>
                    <td style="padding-left: 10px">
                        <input type="button" ng-click="objCtrl.deleteObject(row.empId)" value="Delete" style="padding-left: 10px"/>
                        <input type="button" ng-click="objCtrl.editObject(row.empId)" value="Edit"/>
                        <span ng-if="objCtrl.flag == 'updated' && row.empId == objCtrl.updatedId" class="msg-success">Employee successfully updated.</span>
                    </td> 
                </tr>	
            </table>
        </div>
    </body>
</html>
