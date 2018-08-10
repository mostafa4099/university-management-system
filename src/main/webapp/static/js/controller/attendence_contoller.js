'use strict';

app.factory('AttendenceValue', ['$resource', function ($resource) {
        return $resource('http://localhost:8080/university/value/valuelist/:attValId', {attValId: '@attValId'},
            {
                updateObject:{method: 'PUT'}
            }
        );
}]);

app.factory('ClassHour', ['$resource', function ($resource) {
        return $resource('http://localhost:8080/university/hour/hourlist/:hourId', {hourId: '@hourId'},
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

app.factory('Teachers', ['$resource', function ($resource) {
        return $resource('http://localhost:8080/university/teacher/teacherlist/:teacherId', {teacherId: '@teacherId'},
            {
                updateObject:{method: 'PUT'}
            }
        );
}]);

app.factory('Attendence', ['$resource', function ($resource) {
        return $resource('http://localhost:8080/university/attend/attendlist/:attendId', {attendId: '@attendId'},
            {
                updateObject:{method: 'PUT'}
            }
        );
}]);

app.controller('AttendController', ['$scope', 'Attendence', 'AttendenceValue', 'ClassHour', 'StudentInfo', 'Subject', 'Teachers', function($scope, Attendence, AttendenceValue, ClassHour, StudentInfo, Subject, Teachers){
        var ob=this;
        ob.objArray=[];
        ob.objArray2=[];
        ob.objArray3=[];
        ob.objArray4=[];
        ob.objArray5=[];
        ob.objArray6=[];
        ob.obj= new Attendence();
        ob.obj2=new AttendenceValue();
        ob.obj3=new ClassHour();
        ob.obj4=new StudentInfo();
        ob.obj5=new Subject();
        ob.obj6=new Teachers();
        ob.fetchAllObject = function (){
            ob.objArray=Attendence.query();
            $scope.names = ob.objArray2 = AttendenceValue.query();
            $scope.hours = ob.objArray3 = ClassHour.query();
            $scope.students = ob.objArray4 = StudentInfo.query();
            $scope.subs = ob.objArray5 = Subject.query();
            $scope.tea = ob.objArray6 = Teachers.query();
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
            ob.obj=Attendence.get({attendId: id}, function () {
                ob.flag='edit';
            });
        };
        
        ob.updateObjectDetail=function (){
           console.log('Inside update');
            if ($scope.objForm.$valid) {
                ob.obj.$updateObject(function (object) {
                    console.log(object);
                    ob.updatedId=object.attendId;
                    ob.reset();
                    ob.flag='updated';
                    ob.fetchAllObject();
                });
            }
        };
        
        ob.deleteObject=function (id) {
           console.log('Inside delete');
           ob.obj=Attendence.delete({attendId:id}, function () {
                ob.reset();
                ob.flag='deleted';
                ob.fetchAllObject();
            });
        };
        
        ob.reset=function () {
            ob.obj=new Attendence();
            $scope.objForm.$setPristine();
        };
        
        ob.cancelUpdate=function (id) {
            ob.obj=new Attendence();
            ob.flag='';
            ob.fetchAllObject();
        };
}]);

