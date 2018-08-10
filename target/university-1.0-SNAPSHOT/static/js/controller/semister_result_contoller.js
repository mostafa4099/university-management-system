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

app.factory('Semister', ['$resource', function ($resource) {
        return $resource('http://localhost:8080/university/sem/semlist/:semId', {semId: '@semId'},
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

app.factory('SemisterResult', ['$resource', function ($resource) {
        return $resource('http://localhost:8080/university/semres/semreslist/:semResultId', {semResultId: '@semResultId'},
            {
                updateObject:{method: 'PUT'}
            }
        );
}]);

app.controller('SemResController', ['$scope', 'SemisterResult', 'Department', 'Grade', 'Program', 'Semister', 'StudentInfo', function($scope, SemisterResult, Department, Grade, Program, Semister, StudentInfo){
        var ob=this;
        ob.objArray=[];
        ob.objArray2=[];
        ob.objArray3=[];
        ob.objArray4=[];
        ob.objArray5=[];
        ob.objArray6=[];
        ob.obj= new SemisterResult();
        ob.obj2=new Department();
        ob.obj3=new Grade();
        ob.obj4=new Program();
        ob.obj5=new Semister();
        ob.obj6=new StudentInfo();
        ob.fetchAllObject = function (){
            ob.objArray=SemisterResult.query();
            $scope.deps = ob.objArray2 = Department.query();
            $scope.grades = ob.objArray3 = Grade.query();
            $scope.pros = ob.objArray4 = Program.query();
            $scope.sems = ob.objArray5 = Semister.query();
            $scope.students = ob.objArray6 = StudentInfo.query();
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
            ob.obj=SemisterResult.get({semResultId: id}, function () {
                ob.flag='edit';
            });
        };
        
        ob.updateObjectDetail=function (){
           console.log('Inside update');
            if ($scope.objForm.$valid) {
                ob.obj.$updateObject(function (object) {
                    console.log(object);
                    ob.updatedId=object.semResultId;
                    ob.reset();
                    ob.flag='updated';
                    ob.fetchAllObject();
                });
            }
        };
        
        ob.deleteObject=function (id) {
           console.log('Inside delete');
           ob.obj=SemisterResult.delete({semResultId:id}, function () {
                ob.reset();
                ob.flag='deleted';
                ob.fetchAllObject();
            });
        };
        
        ob.reset=function () {
            ob.obj=new SemisterResult();
            $scope.objForm.$setPristine();
        };
        
        ob.cancelUpdate=function (id) {
            ob.obj=new SemisterResult();
            ob.flag='';
            ob.fetchAllObject();
        };
}]);

