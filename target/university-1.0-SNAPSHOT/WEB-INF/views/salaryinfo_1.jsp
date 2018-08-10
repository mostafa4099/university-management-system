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
        <script src="${pageContext.request.contextPath}/static/js/controller/salary_info_contoller.js" type="text/javascript"></script>
        <link href="${pageContext.request.contextPath}/static/css/style.css" rel="stylesheet" type="text/css"/>
        <title>Salary Info</title>
    </head>
    <body ng-app="myApp">
        <div ng-controller="SalController as objCtrl">
            <h1>Salary Info</h1>
            <form name="objForm" method="POST">
                <table>
                    <tr>
                        <td colspan="2">
                            <div ng-if="objCtrl.flag != 'edit'">
                                <h3>Add New Salary</h3>
                            </div>
                            <div ng-if="objCtrl.flag == 'edit'">
                                <h3>Update Salary For ID: {{objCtrl.obj.salaryId}}</h3>
                            </div>
                        </td>
                    </tr>
                    <tr>
                        <td>Employee Name:</td>
                        <td>
                            <select ng-model="objCtrl.obj.empInfo" ng-options="x.empName for x in names"></select>
                        </td>
                    </tr>
                    <tr>
                        <td>Basic Salary:</td>
                        <td>
                            <input type="text" name="basic" ng-model="objCtrl.obj.basic" required/>
                            <span ng-show="objForm.basic.$error.required" class="msg-val">Basic Salary is required.</span>
                        </td>
                    </tr>
<!--                    <tr>
                        <td>House Rent:</td>
                        <td>
                            <input type="text" name="house" ng-model="objCtrl.obj.house" disabled="disabled"/>
                        </td>
                    </tr>
                    <tr>
                        <td>Medical:</td>
                        <td>
                            <input type="text" name="helth" ng-model="objCtrl.obj.helth" disabled="disabled"/>
                        </td>
                    </tr>
                    <tr>
                        <td>Transport:</td>
                        <td>
                            <input type="text" name="transport" ng-model="objCtrl.obj.transport" disabled="disabled"/>
                        </td>
                    </tr>-->
                    <tr>
                        <td>Festival:</td>
                        <td>
                            <input type="text" name="festival" ng-model="objCtrl.obj.festival"/>
                        </td>
                    </tr>
                    <tr>
                        <td>Others:</td>
                        <td>
                            <input type="text" name="others" ng-model="objCtrl.obj.others"/>
                        </td>
                    </tr>
<!--                    <tr>
                        <td>Total:</td>
                        <td>
                            <input type="text" name="total" ng-model="objCtrl.obj.total" disabled="disabled"/>
                        </td>
                    </tr>-->
                    <tr>
                        <td>Payment Month:</td>
                        <td>
                            <input type="date" name="paymentMonth" ng-model="objCtrl.obj.paymentMonth" required/>
                            <span ng-show="objForm.paymentMonth.$error.required" class="msg-val">Payment Month is required.</span>
                        </td>
                    </tr>
                    
                    <tr>
                        <td colspan="2">
                            <span ng-if="objCtrl.flag == 'created'" class="msg-success">Salary Successfully Added.</span>
                            <span ng-if="objCtrl.flag == 'failed'" class="msg-val">Salary already exists.</span>
                        </td>
                    </tr>
                    <tr>
                        <td colspan="2">
                            <div ng-if="objCtrl.flag != 'edit'">
                                <input  type="submit" ng-click="objCtrl.addObject()" value="Add Salary"/> 
                                <input type="button" ng-click="objCtrl.reset()" value="Reset"/>
                            </div>
                            <div ng-if="objCtrl.flag == 'edit'">
                                <input  type="submit" ng-click="objCtrl.updateObjectDetail()" value="Update Salary"/> 	
                                <input type="button" ng-click="objCtrl.cancelUpdate()" value="Cancel"/>				   
                            </div>
                        </td>
                    </tr>
                    <tr>
                        <td colspan="2"> 
                            <span ng-if="objCtrl.flag == 'deleted'" class="msg-success">Salary successfully deleted.</span>
                        </td>   
                    </tr>
                </table>
            </form>
            <table>
                <tr>
                    <th style="white-space:pre">ID </th>
                    <th style="white-space:pre">Name</th>
                    <th style="white-space:pre">Basic</th>
                    <th style="white-space:pre">House</th>
                    <th style="white-space:pre">Medical</th>
                    <th style="white-space:pre">Transport</th>
                    <th style="white-space:pre">Festival</th>
                    <th style="white-space:pre">Others</th>
                    <th style="white-space:pre">Total</th>
                    <th style="white-space:pre">Payment Month</th>
                    <th style="white-space:pre">Pay Date</th>
                </tr>
                <tr ng-repeat="row in objCtrl.objArray">
                    <td style="white-space:pre"><span ng-bind="row.salaryId"></span></td>
                    <td style="white-space:pre"><span ng-bind="row.empInfo.empName"></span></td>
                    <td style="white-space:pre"><span ng-bind="row.basic"></span></td>
                    <td style="white-space:pre"><span ng-bind="row.house"></span></td>
                    <td style="white-space:pre"><span ng-bind="row.helth"></span></td>
                    <td style="white-space:pre"><span ng-bind="row.transport"></span></td>
                    <td style="white-space:pre"><span ng-bind="row.festival"></span></td>
                    <td style="white-space:pre"><span ng-bind="row.others"></span></td>
                    <td style="white-space:pre"><span ng-bind="row.total"></span></td>
                    <td style="white-space:pre"><span ng-bind="row.paymentMonth"></span></td>
                    <td style="white-space:pre"><span ng-bind="row.payDate"></span></td>
                    <td>
                        <input type="button" ng-click="objCtrl.deleteObject(row.salaryId)" value="Delete" style="white-space:pre"/>
                        <input type="button" ng-click="objCtrl.editObject(row.salaryId)" value="Edit"/>
                        <span ng-if="objCtrl.flag == 'updated' && row.salaryId == objCtrl.updatedId" class="msg-success">Salary successfully updated.</span>
                    </td> 
                </tr>	
            </table>
        </div>
    </body>
</html>
