'use strict';

app.factory('Designation', ['$resource', function ($resource) {
        return $resource('http://localhost:8080/university/des/deslist/:desigId', {desigId: '@desigId'},
            {
                updateObject:{method: 'PUT'}
            }
        );
}]);

app.controller('DesController', ['$scope', 'Designation', function($scope, Designation){
        var ob=this;
        ob.objArray=[];
        ob.obj=new Designation();
        ob.fetchAllObject = function (){
            ob.objArray = Designation.query();
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
            ob.obj=Designation.get({desigId: id}, function () {
                ob.flag='edit';
            });
        };
        
        ob.updateObjectDetail=function (){
           console.log('Inside update');
            if ($scope.objForm.$valid) {
                ob.obj.$updateObject(function (object) {
                    console.log(object);
                    ob.updatedId=object.desigId;
                    ob.reset();
                    ob.flag='updated';
                    ob.fetchAllObject();
                });
            }
        };
        
        ob.deleteObject=function (id) {
           console.log('Inside delete');
           ob.obj=Designation.delete({desigId:id}, function () {
                ob.reset();
                ob.flag='deleted';
                ob.fetchAllObject();
            });
        };
        
        ob.reset=function () {
            ob.obj=new Designation();
            $scope.objForm.$setPristine();
        };
        
        ob.cancelUpdate=function (id) {
            ob.obj=new Designation();
            ob.flag='';
            ob.fetchAllObject();
        };
}]);

