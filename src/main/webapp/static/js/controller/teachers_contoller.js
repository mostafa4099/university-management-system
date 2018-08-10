'use strict';

app.factory('Department', ['$resource', function ($resource) {
        return $resource('http://localhost:8080/university/dep/deplist/:depId', {depId: '@depId'},
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

app.factory('Teachers', ['$resource', function ($resource) {
        return $resource('http://localhost:8080/university/teacher/teacherlist/:teacherId', {teacherId: '@teacherId'},
            {
                updateObject:{method: 'PUT'}
            }
        );
}]);

app.controller('TeacherController', ['$scope', 'Teachers', 'Department', 'EmpInfo', function($scope, Teachers, Department, EmpInfo){
        var ob=this;
        ob.objArray=[];
        ob.objArray2=[];
        ob.objArray3=[];
        ob.obj= new Teachers();
        ob.obj2=new Department();
        ob.obj3=new EmpInfo();
        ob.fetchAllObject = function (){
            ob.objArray=Teachers.query();
            $scope.names = ob.objArray2 = Department.query();
            $scope.emps = ob.objArray3 = EmpInfo.query();
        };
        
        console.log($scope.names+"Hello");
        console.log($scope.emps+"Hello");
        
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
            ob.obj=Teachers.get({teacherId: id}, function () {
                ob.flag='edit';
            });
        };
        
        ob.updateObjectDetail=function (){
           console.log('Inside update');
            if ($scope.objForm.$valid) {
                ob.obj.$updateObject(function (object) {
                    console.log(object);
                    ob.updatedId=object.teacherId;
                    ob.reset();
                    ob.flag='updated';
                    ob.fetchAllObject();
                });
            }
        };
        
        ob.deleteObject=function (id) {
           console.log('Inside delete');
           ob.obj=Teachers.delete({teacherId:id}, function () {
                ob.reset();
                ob.flag='deleted';
                ob.fetchAllObject();
            });
        };
        
        ob.reset=function () {
            ob.obj=new Teachers();
            $scope.objForm.$setPristine();
        };
        
        ob.cancelUpdate=function (id) {
            ob.obj=new Teachers();
            ob.flag='';
            ob.fetchAllObject();
        };
}]);

