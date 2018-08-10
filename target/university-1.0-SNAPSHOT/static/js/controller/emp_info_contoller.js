'use strict';

app.factory('Designation', ['$resource', function ($resource) {
        return $resource('http://localhost:8080/university/des/deslist/:desigId', {desigId: '@desigId'},
            {
                updateObject:{method: 'PUT'}
            }
        );
}]);

app.factory('EmpInfo', ['$resource', function ($resource) {
        return $resource('http://localhost:8080/university/emp/emplist/:empId', {empId: '@empId'},
            {
                updateObject:{method: 'PUT'}
            }
        );
}]);

app.controller('EmpController', ['$scope', 'EmpInfo', 'Designation', function($scope, EmpInfo, Designation){
        var ob=this;
        ob.objArray=[];
        ob.objArray2=[];
        ob.obj= new EmpInfo();
        ob.obj2=new Designation();
        ob.fetchAllObject = function (){
            ob.objArray=EmpInfo.query();
            $scope.names = ob.objArray2 = Designation.query();
        };
        
        console.log($scope.names+"Hello")
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
            ob.obj=EmpInfo.get({empId: id}, function () {
                ob.flag='edit';
            });
        };
        
        ob.updateObjectDetail=function (){
           console.log('Inside update');
            if ($scope.objForm.$valid) {
                ob.obj.$updateObject(function (object) {
                    console.log(object);
                    ob.updatedId=object.empId;
                    ob.reset();
                    ob.flag='updated';
                    ob.fetchAllObject();
                });
            }
        };
        
        ob.deleteObject=function (id) {
           console.log('Inside delete');
           ob.obj=EmpInfo.delete({empId:id}, function () {
                ob.reset();
                ob.flag='deleted';
                ob.fetchAllObject();
            });
        };
        
        ob.reset=function () {
            ob.obj=new EmpInfo();
            $scope.objForm.$setPristine();
        };
        
        ob.cancelUpdate=function (id) {
            ob.obj=new EmpInfo();
            ob.flag='';
            ob.fetchAllObject();
        };
}]);

