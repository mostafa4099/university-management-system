'use strict';

app.factory('StudentInfo', ['$resource', function ($resource) {
        return $resource('http://localhost:8080/university/student/studentlist/:stId', {stId: '@stId'},
            {
                updateObject:{method: 'PUT'}
            }
        );
}]);

app.factory('StudentFee', ['$resource', function ($resource) {
        return $resource('http://localhost:8080/university/fee/feelist/:feeId', {feeId: '@feeId'},
            {
                updateObject:{method: 'PUT'}
            }
        );
}]);

app.controller('StFeeController', ['$scope', 'StudentFee', 'StudentInfo', function($scope, StudentFee, StudentInfo){
        var ob=this;
        ob.objArray=[];
        ob.objArray2=[];
        ob.obj= new StudentFee();
        ob.obj2=new StudentInfo();
        ob.fetchAllObject = function (){
            ob.objArray=StudentFee.query();
            $scope.names = ob.objArray2 = StudentInfo.query();
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
            ob.obj=StudentFee.get({feeId: id}, function () {
                ob.flag='edit';
            });
        };
        
        ob.updateObjectDetail=function (){
           console.log('Inside update');
            if ($scope.objForm.$valid) {
                ob.obj.$updateObject(function (object) {
                    console.log(object);
                    ob.updatedId=object.feeId;
                    ob.reset();
                    ob.flag='updated';
                    ob.fetchAllObject();
                });
            }
        };
        
        ob.deleteObject=function (id) {
           console.log('Inside delete');
           ob.obj=StudentFee.delete({feeId:id}, function () {
                ob.reset();
                ob.flag='deleted';
                ob.fetchAllObject();
            });
        };
        
        ob.reset=function () {
            ob.obj=new StudentFee();
            $scope.objForm.$setPristine();
        };
        
        ob.cancelUpdate=function (id) {
            ob.obj=new StudentFee();
            ob.flag='';
            ob.fetchAllObject();
        };
}]);

