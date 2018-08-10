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
        <script src="${pageContext.request.contextPath}/static/js/controller/student_fee_contoller.js" type="text/javascript"></script>
        <link href="${pageContext.request.contextPath}/static/css/style.css" rel="stylesheet" type="text/css"/>
        <title>Student Fee Info</title>
    </head>
    <body ng-app="myApp">
        <div ng-controller="StFeeController as objCtrl">
            <h1>Student Fee Info</h1>
            <form name="objForm" method="POST">
                <table>
                    <tr>
                        <td colspan="2">
                            <div ng-if="objCtrl.flag != 'edit'">
                                <h3>Add New Fee</h3>
                            </div>
                            <div ng-if="objCtrl.flag == 'edit'">
                                <h3>Update Fee For ID: {{objCtrl.obj.feeId}}</h3>
                            </div>
                        </td>
                    </tr>
                    <tr>
                        <td>Student Roll Number:</td>
                        <td>
                            <select ng-model="objCtrl.obj.studentInfo" ng-options="x.stRoll for x in names"></select>
                        </td>
                    </tr>
                    <tr>
                        <td>Application Fee:</td>
                        <td>
                            <input type="text" name="applyFee" ng-model="objCtrl.obj.applyFee" required/>
                            <span ng-show="objForm.applyFee.$error.required" class="msg-val">Application Fee is required.</span>
                        </td>
                    </tr>
                    <tr>
                        <td>Registration Fee:</td>
                        <td>
                            <input type="text" name="regFee" ng-model="objCtrl.obj.regFee" required/>
                            <span ng-show="objForm.regFee.$error.required" class="msg-val">Registration Fee is required.</span>
                        </td>
                    </tr>
                    <tr>
                        <td>Tuition Fee:</td>
                        <td>
                            <input type="text" name="tutionFee" ng-model="objCtrl.obj.tutionFee" required/>
                            <span ng-show="objForm.tutionFee.$error.required" class="msg-val">Tuition Fee is required.</span>
                        </td>
                    </tr>
                    <tr>
                        <td>Exam Fee:</td>
                        <td>
                            <input type="text" name="examFee" ng-model="objCtrl.obj.examFee" required/>
                            <span ng-show="objForm.examFee.$error.required" class="msg-val">Exam Fee is required.</span>
                        </td>
                    </tr>
                    <tr>
                        <td>Others Fee:</td>
                        <td>
                            <input type="text" name="othersFee" ng-model="objCtrl.obj.othersFee" required/>
                            <span ng-show="objForm.othersFee.$error.required" class="msg-val">Others Fee is required.</span>
                        </td>
                    </tr>
                    
                    <tr>
                        <td colspan="2">
                            <span ng-if="objCtrl.flag == 'created'" class="msg-success">Fee Successfully Added.</span>
                            <span ng-if="objCtrl.flag == 'failed'" class="msg-val">Fee already exists.</span>
                        </td>
                    </tr>
                    <tr>
                        <td colspan="2">
                            <div ng-if="objCtrl.flag != 'edit'">
                                <input  type="submit" ng-click="objCtrl.addObject()" value="Add Fee"/> 
                                <input type="button" ng-click="objCtrl.reset()" value="Reset"/>
                            </div>
                            <div ng-if="objCtrl.flag == 'edit'">
                                <input  type="submit" ng-click="objCtrl.updateObjectDetail()" value="Update Fee"/> 	
                                <input type="button" ng-click="objCtrl.cancelUpdate()" value="Cancel"/>				   
                            </div>
                        </td>
                    </tr>
                    <tr>
                        <td colspan="2"> 
                            <span ng-if="objCtrl.flag == 'deleted'" class="msg-success">Fee successfully deleted.</span>
                        </td>   
                    </tr>
                </table>
            </form>
            <table>
                <tr>
                    <th style="white-space:pre">Fee ID </th>
                    <th style="white-space:pre">Name</th>
                    <th style="white-space:pre">Roll</th>
                    <th style="white-space:pre">Apply Fee</th>
                    <th style="white-space:pre">Reg. Fee</th>
                    <th style="white-space:pre">Tuition Fee</th>
                    <th style="white-space:pre">Exam Fee</th>
                    <th style="white-space:pre">Others Fee</th>
                    <th style="white-space:pre">Total Fee</th>
                    <th style="white-space:pre">Pay Date</th>
                </tr>
                <tr ng-repeat="row in objCtrl.objArray">
                    <td style="white-space:pre"><span ng-bind="row.feeId"></span></td>
                    <td style="white-space:pre"><span ng-bind="row.studentInfo.stName"></span></td>
                    <td style="white-space:pre"><span ng-bind="row.studentInfo.stRoll"></span></td>
                    <td style="white-space:pre"><span ng-bind="row.applyFee"></span></td>
                    <td style="white-space:pre"><span ng-bind="row.regFee"></span></td>
                    <td style="white-space:pre"><span ng-bind="row.tutionFee"></span></td>
                    <td style="white-space:pre"><span ng-bind="row.examFee"></span></td>
                    <td style="white-space:pre"><span ng-bind="row.othersFee"></span></td>
                    <td style="white-space:pre"><span ng-bind="row.totalFee"></span></td>
                    <td style="white-space:pre"><span ng-bind="row.payDate"></span></td>
                    <td>
                        <input type="button" ng-click="objCtrl.deleteObject(row.feeId)" value="Delete" style="white-space:pre"/>
                        <input type="button" ng-click="objCtrl.editObject(row.feeId)" value="Edit"/>
                        <span ng-if="objCtrl.flag == 'updated' && row.feeId == objCtrl.updatedId" class="msg-success">Fee successfully updated.</span>
                    </td> 
                </tr>	
            </table>
        </div>
    </body>
</html>
