'use strict';

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

app.controller('SubController', ['$scope', 'Subject', 'Department', 'Program', 'Semister', function($scope, Subject, Department, Program, Semister){
        var ob=this;
        ob.objArray=[];
        ob.objArray2=[];
        ob.objArray3=[];
        ob.objArray4=[];
        ob.obj= new Subject();
        ob.obj2=new Department();
        ob.obj3=new Program();
        ob.obj4=new Semister();
        ob.fetchAllObject = function (){
            ob.objArray=Subject.query();
            $scope.names = ob.objArray2 = Department.query();
            $scope.pro = ob.objArray3 = Program.query();
            $scope.sem = ob.objArray4 = Semister.query();
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
            ob.obj=Subject.get({subId: id}, function () {
                ob.flag='edit';
            });
        };
        
        ob.updateObjectDetail=function (){
           console.log('Inside update');
            if ($scope.objForm.$valid) {
                ob.obj.$updateObject(function (object) {
                    console.log(object);
                    ob.updatedId=object.subId;
                    ob.reset();
                    ob.flag='updated';
                    ob.fetchAllObject();
                });
            }
        };
        
        ob.deleteObject=function (id) {
           console.log('Inside delete');
           ob.obj=Subject.delete({subId:id}, function () {
                ob.reset();
                ob.flag='deleted';
                ob.fetchAllObject();
            });
        };
        
        ob.reset=function () {
            ob.obj=new Subject();
            $scope.objForm.$setPristine();
        };
        
        ob.cancelUpdate=function (id) {
            ob.obj=new Subject();
            ob.flag='';
            ob.fetchAllObject();
        };
}]);

