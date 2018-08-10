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
        <script src="${pageContext.request.contextPath}/static/js/controller/student_info_contoller.js" type="text/javascript"></script>
        <link href="${pageContext.request.contextPath}/static/css/style.css" rel="stylesheet" type="text/css"/>
        <title>Student Info</title>
    </head>
    <body ng-app="myApp">
        <div ng-controller="StudentController as objCtrl">
            <h1>Student Info</h1>
            <form name="objForm" method="POST">
                <table>
                    <tr>
                        <td colspan="2">
                            <div ng-if="objCtrl.flag != 'edit'">
                                <h3>Add New Student</h3>
                            </div>
                            <div ng-if="objCtrl.flag == 'edit'">
                                <h3>Update Student For ID: {{objCtrl.obj.stId}}</h3>
                            </div>
                        </td>
                    </tr>
                    <tr>
                        <td>Name:</td>
                        <td>
                            <input type="text" name="stName" ng-model="objCtrl.obj.stName" required/>
                            <span ng-show="objForm.stName.$error.required" class="msg-val">Name is required.</span>
                        </td>
                    </tr>
                    <tr>
                        <td>Father Name:</td>
                        <td>
                            <input type="text" name="stFather" ng-model="objCtrl.obj.stFather" required/>
                            <span ng-show="objForm.stFather.$error.required" class="msg-val">Father Name is required.</span>
                        </td>
                    </tr>
                    <tr>
                        <td>Mother Name:</td>
                        <td>
                            <input type="text" name="stMother" ng-model="objCtrl.obj.stMother" required/>
                            <span ng-show="objForm.stMother.$error.required" class="msg-val">Mother Name is required.</span>
                        </td>
                    </tr>
                    <tr>
                        <td>Address:</td>
                        <td>
                            <input type="text" name="stAddress" ng-model="objCtrl.obj.stAddress" required/>
                            <span ng-show="objForm.stAddress.$error.required" class="msg-val">Address is required.</span>
                        </td>
                    </tr>
                    <tr>
                        <td>Mobile Number:</td>
                        <td>
                            <input type="text" name="stMobile" ng-model="objCtrl.obj.stMobile" required/>
                            <span ng-show="objForm.stMobile.$error.required" class="msg-val">Mobile Number is required.</span>
                        </td>
                    </tr>
                    <tr>
                        <td>Email:</td>
                        <td>
                            <input type="email" name="stEmail" ng-model="objCtrl.obj.stEmail" required/>
                            <span ng-show="objForm.stEmail.$error.required" class="msg-val">Email is required.</span>
                        </td>
                    </tr>
                    <tr>
                        <td>Date Of Birth:</td>
                        <td>
                            <input type="date" name="stDob" ng-model="objCtrl.obj.stDob" required/>
                            <span ng-show="objForm.stDob.$error.required" class="msg-val">Date Of Birth is required.</span>
                        </td>
                    </tr>
                    <tr>
                        <td>Session:</td>
                        <td>
                            <input type="text" name="stSession" ng-model="objCtrl.obj.stSession" required/>
                            <span ng-show="objForm.stSession.$error.required" class="msg-val">Session is required.</span>
                        </td>
                    </tr>
                    <tr>
                        <td>Roll Number:</td>
                        <td>
                            <input type="text" name="stRoll" ng-model="objCtrl.obj.stRoll" required/>
                            <span ng-show="objForm.stRoll.$error.required" class="msg-val">Roll Number is required.</span>
                        </td>
                    </tr>
                    <tr>
                        <td>Registration Number:</td>
                        <td>
                            <input type="text" name="stReg" ng-model="objCtrl.obj.stReg" required/>
                            <span ng-show="objForm.stReg.$error.required" class="msg-val">Registration Number is required.</span>
                        </td>
                    </tr>
                    <tr>
                        <td>Admission Date:</td>
                        <td>
                            <input type="date" name="admissionDate" ng-model="objCtrl.obj.admissionDate" required/>
                            <span ng-show="objForm.admissionDate.$error.required" class="msg-val">Admission Date Month is required.</span>
                        </td>
                    </tr>
                    <tr>
                        <td>Upload Picture:</td>
                        <td>
                            <input type="text" name="stPic" ng-model="objCtrl.obj.stPic" required/>
                            <span ng-show="objForm.stPic.$error.required" class="msg-val">Upload Picture is required.</span>
                        </td>
                    </tr>
                    
                    <tr>
                        <td colspan="2">
                            <span ng-if="objCtrl.flag == 'created'" class="msg-success">Student Successfully Added.</span>
                            <span ng-if="objCtrl.flag == 'failed'" class="msg-val">Student already exists.</span>
                        </td>
                    </tr>
                    <tr>
                        <td colspan="2">
                            <div ng-if="objCtrl.flag != 'edit'">
                                <input  type="submit" ng-click="objCtrl.addObject()" value="Add Student"/> 
                                <input type="button" ng-click="objCtrl.reset()" value="Reset"/>
                            </div>
                            <div ng-if="objCtrl.flag == 'edit'">
                                <input  type="submit" ng-click="objCtrl.updateObjectDetail()" value="Update Student"/> 	
                                <input type="button" ng-click="objCtrl.cancelUpdate()" value="Cancel"/>				   
                            </div>
                        </td>
                    </tr>
                    <tr>
                        <td colspan="2"> 
                            <span ng-if="objCtrl.flag == 'deleted'" class="msg-success">Student successfully deleted.</span>
                        </td>   
                    </tr>
                </table>
            </form>
            <table>
                <tr>
                    <th style="white-space:pre">ID </th>
                    <th style="white-space:pre">Name</th>
                    <th style="white-space:pre">Father</th>
                    <th style="white-space:pre">Mother</th>
                    <th style="white-space:pre">Address</th>
                    <th style="white-space:pre">Mobile</th>
                    <th style="white-space:pre">Email</th>
                    <th style="white-space:pre">DOB</th>
                    <th style="white-space:pre">Session</th>
                    <th style="white-space:pre">Roll No.</th>
                    <th style="white-space:pre">Reg. No.</th>
                    <th style="white-space:pre">Admission Date</th>
                    <th style="white-space:pre">Picture</th>
                </tr>
                <tr ng-repeat="row in objCtrl.objArray">
                    <td style="white-space:pre"><span ng-bind="row.stId"></span></td>
                    <td style="white-space:pre"><span ng-bind="row.stName"></span></td>
                    <td style="white-space:pre"><span ng-bind="row.stFather"></span></td>
                    <td style="white-space:pre"><span ng-bind="row.stMother"></span></td>
                    <td style="white-space:pre"><span ng-bind="row.stAddress"></span></td>
                    <td style="white-space:pre"><span ng-bind="row.stMobile"></span></td>
                    <td style="white-space:pre"><span ng-bind="row.stEmail"></span></td>
                    <td style="white-space:pre"><span ng-bind="row.stDob"></span></td>
                    <td style="white-space:pre"><span ng-bind="row.stSession"></span></td>
                    <td style="white-space:pre"><span ng-bind="row.stRoll"></span></td>
                    <td style="white-space:pre"><span ng-bind="row.stReg"></span></td>
                    <td style="white-space:pre"><span ng-bind="row.admissionDate"></span></td>
                    <td style="white-space:pre"><span ng-bind="row.stPic"></span></td>
                    <td>
                        <input type="button" ng-click="objCtrl.deleteObject(row.stId)" value="Delete" style="white-space:pre"/>
                        <input type="button" ng-click="objCtrl.editObject(row.stId)" value="Edit"/>
                        <span ng-if="objCtrl.flag == 'updated' && row.stId == objCtrl.updatedId" class="msg-success">Student successfully updated.</span>
                    </td> 
                </tr>	
            </table>
        </div>
    </body>
</html>
