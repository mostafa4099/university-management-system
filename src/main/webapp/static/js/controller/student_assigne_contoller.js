'use strict';

app.factory('StudentInfo', ['$resource', function ($resource) {
        return $resource('http://localhost:8080/university/student/studentlist/:stId', {stId: '@stId'},
            {
                updateObject:{method: 'PUT'}
            }
        );
}]);

app.factory('Department', ['$resource', function ($resource) {
        return $resource('http://localhost:8080/university/dep/deplist/:depId', {depId: '@depId'},
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

app.factory('Subject', ['$resource', function ($resource) {
        return $resource('http://localhost:8080/university/sub/sublist/:subId', {subId: '@subId'},
            {
                updateObject:{method: 'PUT'}
            }
        );
}]);

app.factory('StudentAssigne', ['$resource', function ($resource) {
        return $resource('http://localhost:8080/university/assigne/assignelist/:assigneId', {assigneId: '@assigneId'},
            {
                updateObject:{method: 'PUT'}
            }
        );
}]);

app.controller('AssigneController', ['$scope', 'StudentAssigne', 'StudentInfo', 'Department', 'Program', 'Semister', 'Subject', function($scope, StudentAssigne, StudentInfo, Department, Program, Semister, Subject){
        var ob=this;
        ob.objArray=[];
        ob.objArray2=[];
        ob.objArray3=[];
        ob.objArray4=[];
        ob.objArray5=[];
        ob.objArray6=[];
        ob.obj= new StudentAssigne();
        ob.obj2=new StudentInfo();
        ob.obj3=new Department();
        ob.obj4=new Program();
        ob.obj5=new Semister();
        ob.obj6=new Subject();
        ob.fetchAllObject = function (){
            ob.objArray=StudentAssigne.query();
            $scope.students = ob.objArray2 = StudentInfo.query();
            $scope.departments = ob.objArray3 = Department.query();
            $scope.programs = ob.objArray4 = Program.query();
            $scope.semisters = ob.objArray5 = Semister.query();
            $scope.subs = ob.objArray6 = Subject.query();
        };
        
        console.log($scope.students+"Hello");
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
            ob.obj=StudentAssigne.get({assigneId: id}, function () {
                ob.flag='edit';
            });
        };
        
        ob.updateObjectDetail=function (){
           console.log('Inside update');
            if ($scope.objForm.$valid) {
                ob.obj.$updateObject(function (object) {
                    console.log(object);
                    ob.updatedId=object.assigneId;
                    ob.reset();
                    ob.flag='updated';
                    ob.fetchAllObject();
                });
            }
        };
        
        ob.deleteObject=function (id) {
           console.log('Inside delete');
           ob.obj=StudentAssigne.delete({assigneId:id}, function () {
                ob.reset();
                ob.flag='deleted';
                ob.fetchAllObject();
            });
        };
        
        ob.reset=function () {
            ob.obj=new StudentAssigne();
            $scope.objForm.$setPristine();
        };
        
        ob.cancelUpdate=function (id) {
            ob.obj=new StudentAssigne();
            ob.flag='';
            ob.fetchAllObject();
        };
}]);

