'use strict';

app.factory('Department', ['$resource', function ($resource) {
        return $resource('http://localhost:8080/university/dep/deplist/:depId', {depId: '@depId'},
            {
                updateObject:{method: 'PUT'}
            }
        );
}]);

app.factory('Grade', ['$resource', function ($resource) {
        return $resource('http://localhost:8080/university/grade/gradelist/:gradeId', {gradeId: '@gradeId'},
            {
                updateObject:{method: 'PUT'}
            }
        );
}]);

app.factory('Program', ['$resource', function ($resource) {
        return $resource('http://localhost:8080/university/pro/prolist/:proId', {proId: '@proId'},
            {
                updateObject:{method: 'PUT'}
            }
        );
}]);

app.factory('StudentInfo', ['$resource', function ($resource) {
        return $resource('http://localhost:8080/university/student/studentlist/:stId', {stId: '@stId'},
            {
                updateObject:{method: 'PUT'}
            }
        );
}]);

app.factory('FinalResult', ['$resource', function ($resource) {
        return $resource('http://localhost:8080/university/finalres/finalreslist/:cgpaId', {cgpaId: '@cgpaId'},
            {
                updateObject:{method: 'PUT'}
            }
        );
}]);

app.controller('FinalResController', ['$scope', 'FinalResult', 'Department', 'Grade', 'Program', 'StudentInfo', function($scope, FinalResult, Department, Grade, Program, StudentInfo){
        var ob=this;
        ob.objArray=[];
        ob.objArray2=[];
        ob.objArray3=[];
        ob.objArray4=[];
        ob.objArray5=[];
        ob.obj= new FinalResult();
        ob.obj2=new Department();
        ob.obj3=new Grade();
        ob.obj4=new Program();
        ob.obj5=new StudentInfo();
        ob.fetchAllObject = function (){
            ob.objArray=FinalResult.query();
            $scope.deps = ob.objArray2 = Department.query();
            $scope.grades = ob.objArray3 = Grade.query();
            $scope.pros = ob.objArray4 = Program.query();
            $scope.students = ob.objArray5 = StudentInfo.query();
        };
        
        console.log($scope.deps+"Hello");
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
            ob.obj=FinalResult.get({cgpaId: id}, function () {
                ob.flag='edit';
            });
        };
        
        ob.updateObjectDetail=function (){
           console.log('Inside update');
            if ($scope.objForm.$valid) {
                ob.obj.$updateObject(function (object) {
                    console.log(object);
                    ob.updatedId=object.cgpaId;
                    ob.reset();
                    ob.flag='updated';
                    ob.fetchAllObject();
                });
            }
        };
        
        ob.deleteObject=function (id) {
           console.log('Inside delete');
           ob.obj=FinalResult.delete({cgpaId:id}, function () {
                ob.reset();
                ob.flag='deleted';
                ob.fetchAllObject();
            });
        };
        
        ob.reset=function () {
            ob.obj=new FinalResult();
            $scope.objForm.$setPristine();
        };
        
        ob.cancelUpdate=function (id) {
            ob.obj=new FinalResult();
            ob.flag='';
            ob.fetchAllObject();
        };
}]);

