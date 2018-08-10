'use strict';

app.factory('Grade', ['$resource', function ($resource) {
        return $resource('http://localhost:8080/university/grade/gradelist/:gradeId', {gradeId: '@gradeId'},
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

app.factory('Subject', ['$resource', function ($resource) {
        return $resource('http://localhost:8080/university/sub/sublist/:subId', {subId: '@subId'},
            {
                updateObject:{method: 'PUT'}
            }
        );
}]);

app.factory('SubjectResult', ['$resource', function ($resource) {
        return $resource('http://localhost:8080/university/subres/subreslist/:subResultId', {subResultId: '@subResultId'},
            {
                updateObject:{method: 'PUT'}
            }
        );
}]);

app.controller('SubResController', ['$scope', 'SubjectResult', 'Grade', 'StudentInfo', 'Subject', function($scope, SubjectResult, Grade, StudentInfo, Subject){
        var ob=this;
        ob.objArray=[];
        ob.objArray2=[];
        ob.objArray3=[];
        ob.objArray4=[];
        ob.obj= new SubjectResult();
        ob.obj2=new Grade();
        ob.obj3=new StudentInfo();
        ob.obj4=new Subject();
        ob.fetchAllObject = function (){
            ob.objArray=SubjectResult.query();
            $scope.names = ob.objArray2 = Grade.query();
            $scope.students = ob.objArray3 = StudentInfo.query();
            $scope.subs = ob.objArray4 = Subject.query();
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
            ob.obj=SubjectResult.get({subResultId: id}, function () {
                ob.flag='edit';
            });
        };
        
        ob.updateObjectDetail=function (){
           console.log('Inside update');
            if ($scope.objForm.$valid) {
                ob.obj.$updateObject(function (object) {
                    console.log(object);
                    ob.updatedId=object.subResultId;
                    ob.reset();
                    ob.flag='updated';
                    ob.fetchAllObject();
                });
            }
        };
        
        ob.deleteObject=function (id) {
           console.log('Inside delete');
           ob.obj=SubjectResult.delete({subResultId:id}, function () {
                ob.reset();
                ob.flag='deleted';
                ob.fetchAllObject();
            });
        };
        
        ob.reset=function () {
            ob.obj=new SubjectResult();
            $scope.objForm.$setPristine();
        };
        
        ob.cancelUpdate=function (id) {
            ob.obj=new SubjectResult();
            ob.flag='';
            ob.fetchAllObject();
        };
}]);

