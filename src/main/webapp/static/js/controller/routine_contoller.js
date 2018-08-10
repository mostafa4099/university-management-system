'use strict';

app.factory('ClassDay', ['$resource', function ($resource) {
        return $resource('http://localhost:8080/university/day/daylist/:dayId', {dayId: '@dayId'},
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

app.factory('Routine', ['$resource', function ($resource) {
        return $resource('http://localhost:8080/university/routine/routinelist/:routineId', {routineId: '@routineId'},
            {
                updateObject:{method: 'PUT'}
            }
        );
}]);

app.controller('RoutineController', ['$scope', 'Routine', 'ClassDay', 'ClassHour', 'Subject', 'Teachers', function($scope, Routine, ClassDay, ClassHour, Subject, Teachers){
        var ob=this;
        ob.objArray=[];
        ob.objArray2=[];
        ob.objArray3=[];
        ob.objArray4=[];
        ob.objArray5=[];
        ob.obj= new Routine();
        ob.obj2=new ClassDay();
        ob.obj3=new ClassHour();
        ob.obj4=new Subject();
        ob.obj5=new Teachers();
        ob.fetchAllObject = function (){
            ob.objArray=Routine.query();
            $scope.names = ob.objArray2 = ClassDay.query();
            $scope.hours = ob.objArray3 = ClassHour.query();
            $scope.subs = ob.objArray4 = Subject.query();
            $scope.tea = ob.objArray5 = Teachers.query();
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
            ob.obj=Routine.get({routineId: id}, function () {
                ob.flag='edit';
            });
        };
        
        ob.updateObjectDetail=function (){
           console.log('Inside update');
            if ($scope.objForm.$valid) {
                ob.obj.$updateObject(function (object) {
                    console.log(object);
                    ob.updatedId=object.routineId;
                    ob.reset();
                    ob.flag='updated';
                    ob.fetchAllObject();
                });
            }
        };
        
        ob.deleteObject=function (id) {
           console.log('Inside delete');
           ob.obj=Routine.delete({routineId:id}, function () {
                ob.reset();
                ob.flag='deleted';
                ob.fetchAllObject();
            });
        };
        
        ob.reset=function () {
            ob.obj=new Routine();
            $scope.objForm.$setPristine();
        };
        
        ob.cancelUpdate=function (id) {
            ob.obj=new Routine();
            ob.flag='';
            ob.fetchAllObject();
        };
}]);

