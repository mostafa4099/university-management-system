'use strict';

app.factory('EmpInfo', ['$resource', function ($resource) {
        return $resource('http://localhost:8080/university/emp/emplist/:empId', {empId: '@empId'},
            {
                updateObject:{method: 'PUT'}
            }
        );
}]);

app.factory('SalaryInfo', ['$resource', function ($resource) {
        return $resource('http://localhost:8080/university/salary/salarylist/:salaryId', {salaryId: '@salaryId'},
            {
                updateObject:{method: 'PUT'}
            }
        );
}]);

app.controller('SalController', ['$scope', 'SalaryInfo', 'EmpInfo', function($scope, SalaryInfo, EmpInfo){
        var ob=this;
        ob.objArray=[];
        ob.objArray2=[];
        ob.obj= new SalaryInfo();
        ob.obj2=new EmpInfo();
        ob.fetchAllObject = function (){
            ob.objArray=SalaryInfo.query();
            $scope.names = ob.objArray2 = EmpInfo.query();
        };
        
        console.log($scope.names+"Hello");
        ob.fetchAllObject();
        
        ob.addObject=function (){
            console.log('Inside save');
            if($scope.objForm.$valid){
                ob.obj.$save(function (object){
                    console.log(object);
                    ob.flag='created';
                    ob.reset();
                    ob.fetchAllObject();
                    },
                    function (err){
                        console.log(err.status);
                        ob.flag='failed';
                    }
                );
            }
        };
        
        ob.editObject=function (id){
            console.log('Inside edit');
            ob.obj=SalaryInfo.get({salaryId: id}, function () {
                ob.flag='edit';
            });
        };
        
        ob.updateObjectDetail=function (){
           console.log('Inside update');
            if ($scope.objForm.$valid) {
                ob.obj.$updateObject(function (object) {
                    console.log(object);
                    ob.updatedId=object.salaryId;
                    ob.reset();
                    ob.flag='updated';
                    ob.fetchAllObject();
                });
            }
        };
        
        ob.deleteObject=function (id) {
           console.log('Inside delete');
           ob.obj=SalaryInfo.delete({salaryId:id}, function () {
                ob.reset();
                ob.flag='deleted';
                ob.fetchAllObject();
            });
        };
        
        ob.reset=function () {
            ob.obj=new SalaryInfo();
            $scope.objForm.$setPristine();
        };
        
        ob.cancelUpdate=function (id) {
            ob.obj=new SalaryInfo();
            ob.flag='';
            ob.fetchAllObject();
        };
}]);

