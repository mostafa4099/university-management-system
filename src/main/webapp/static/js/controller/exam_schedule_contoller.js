'use strict';

app.factory('Exam', ['$resource', function ($resource) {
        return $resource('http://localhost:8080/university/exam/examlist/:examId', {examId: '@examId'},
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

app.factory('ExamSchedule', ['$resource', function ($resource) {
        return $resource('http://localhost:8080/university/schedule/schedulelist/:scheduleId', {scheduleId: '@scheduleId'},
            {
                updateObject:{method: 'PUT'}
            }
        );
}]);

app.controller('ExamScheduleController', ['$scope', 'ExamSchedule', 'Exam', 'Subject', function($scope, ExamSchedule, Exam, Subject){
        var ob=this;
        ob.objArray=[];
        ob.objArray2=[];
        ob.objArray3=[];
        ob.obj= new ExamSchedule();
        ob.obj2=new Exam();
        ob.obj3=new Subject();
        ob.fetchAllObject = function (){
            ob.objArray=ExamSchedule.query();
            $scope.names = ob.objArray2 = Exam.query();
            $scope.subs = ob.objArray3 = Subject.query();
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
            ob.obj=ExamSchedule.get({scheduleId: id}, function () {
                ob.flag='edit';
            });
        };
        
        ob.updateObjectDetail=function (){
           console.log('Inside update');
            if ($scope.objForm.$valid) {
                ob.obj.$updateObject(function (object) {
                    console.log(object);
                    ob.updatedId=object.scheduleId;
                    ob.reset();
                    ob.flag='updated';
                    ob.fetchAllObject();
                });
            }
        };
        
        ob.deleteObject=function (id) {
           console.log('Inside delete');
           ob.obj=ExamSchedule.delete({scheduleId:id}, function () {
                ob.reset();
                ob.flag='deleted';
                ob.fetchAllObject();
            });
        };
        
        ob.reset=function () {
            ob.obj=new ExamSchedule();
            $scope.objForm.$setPristine();
        };
        
        ob.cancelUpdate=function (id) {
            ob.obj=new ExamSchedule();
            ob.flag='';
            ob.fetchAllObject();
        };
}]);

