'use strict';

app.factory('NoticeCategory', ['$resource', function ($resource) {
        return $resource('http://localhost:8080/university/ncat/ncatlist/:ncatId', {ncatId: '@ncatId'},
            {
                updateObject:{method: 'PUT'}
            }
        );
}]);

app.factory('NoticeDetails', ['$resource', function ($resource) {
        return $resource('http://localhost:8080/university/notice/noticelist/:noticeId', {noticeId: '@noticeId'},
            {
                updateObject:{method: 'PUT'}
            }
        );
}]);

app.controller('NoticeController', ['$scope', 'NoticeDetails', 'NoticeCategory', function($scope, NoticeDetails, NoticeCategory){
        var ob=this;
        ob.objArray=[];
        ob.objArray2=[];
        ob.obj= new NoticeDetails();
        ob.obj2=new NoticeCategory();
        ob.fetchAllObject = function (){
            ob.objArray=NoticeDetails.query();
            $scope.names = ob.objArray2 = NoticeCategory.query();
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
            ob.obj=NoticeDetails.get({noticeId: id}, function () {
                ob.flag='edit';
            });
        };
        
        ob.updateObjectDetail=function (){
           console.log('Inside update');
            if ($scope.objForm.$valid) {
                ob.obj.$updateObject(function (object) {
                    console.log(object);
                    ob.updatedId=object.noticeId;
                    ob.reset();
                    ob.flag='updated';
                    ob.fetchAllObject();
                });
            }
        };
        
        ob.deleteObject=function (id) {
           console.log('Inside delete');
           ob.obj=NoticeDetails.delete({noticeId:id}, function () {
                ob.reset();
                ob.flag='deleted';
                ob.fetchAllObject();
            });
        };
        
        ob.reset=function () {
            ob.obj=new NoticeDetails();
            $scope.objForm.$setPristine();
        };
        
        ob.cancelUpdate=function (id) {
            ob.obj=new NoticeDetails();
            ob.flag='';
            ob.fetchAllObject();
        };
}]);

