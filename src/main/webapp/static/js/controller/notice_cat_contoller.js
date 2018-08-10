'use strict';

app.factory('NoticeCategory', ['$resource', function ($resource) {
        return $resource('http://localhost:8080/university/ncat/ncatlist/:ncatId', {ncatId: '@ncatId'},
            {
                updateObject:{method: 'PUT'}
            }
        );
}]);

app.controller('NcatController', ['$scope', 'NoticeCategory', function($scope, NoticeCategory){
        var ob=this;
        ob.objArray=[];
        ob.obj=new NoticeCategory();
        ob.fetchAllObject = function (){
            ob.objArray = NoticeCategory.query();
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
            ob.obj=NoticeCategory.get({ncatId: id}, function () {
                ob.flag='edit';
            });
        };
        
        ob.updateObjectDetail=function (){
           console.log('Inside update');
            if ($scope.objForm.$valid) {
                ob.obj.$updateObject(function (object) {
                    console.log(object);
                    ob.updatedId=object.ncatId;
                    ob.reset();
                    ob.flag='updated';
                    ob.fetchAllObject();
                });
            }
        };
        
        ob.deleteObject=function (id) {
           console.log('Inside delete');
           ob.obj=NoticeCategory.delete({ncatId:id}, function () {
                ob.reset();
                ob.flag='deleted';
                ob.fetchAllObject();
            });
        };
        
        ob.reset=function () {
            ob.obj=new NoticeCategory();
            $scope.objForm.$setPristine();
        };
        
        ob.cancelUpdate=function (id) {
            ob.obj=new NoticeCategory();
            ob.flag='';
            ob.fetchAllObject();
        };
}]);

