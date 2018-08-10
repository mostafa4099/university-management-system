'use strict';

app.factory('Faculty', ['$resource', function ($resource) {
        return $resource('http://localhost:8080/university/fac/faclist/:facId', {facId: '@facId'},
            {
                updateObject:{method: 'PUT'}
            }
        );
}]);

app.controller('FacController', ['$scope', 'Faculty', function($scope, Faculty){
        var ob=this;
        ob.objArray=[];
        ob.obj=new Faculty();
        ob.fetchAllObject = function (){
            ob.objArray = Faculty.query();
        };
        
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
            ob.obj=Faculty.get({facId: id}, function () {
                ob.flag='edit';
            });
        };
        
        ob.updateObjectDetail=function (){
           console.log('Inside update');
            if ($scope.objForm.$valid) {
                ob.obj.$updateObject(function (object) {
                    console.log(object);
                    ob.updatedId=object.facId;
                    ob.reset();
                    ob.flag='updated';
                    ob.fetchAllObject();
                });
            }
        };
        
        ob.deleteObject=function (id) {
           console.log('Inside delete');
           ob.obj=Faculty.delete({facId:id}, function () {
                ob.reset();
                ob.flag='deleted';
                ob.fetchAllObject();
            });
        };
        
        ob.reset=function () {
            ob.obj=new Faculty();
            $scope.objForm.$setPristine();
        };
        
        ob.cancelUpdate=function (id) {
            ob.obj=new Faculty();
            ob.flag='';
            ob.fetchAllObject();
        };
}]);

