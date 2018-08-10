'use strict';

app.factory('Faculty', ['$resource', function ($resource) {
        return $resource('http://localhost:8080/university/fac/faclist/:facId', {facId: '@facId'},
            {
                updateObject:{method: 'PUT'}
            }
        );
}]);

app.factory('Department', ['$resource', function ($resource) {
        return $resource('http://localhost:8080/university/dep/deplist/:depId', {depId: '@depId'},
            {
                updateObject:{method: 'PUT'}
            }
        );
}]);

app.controller('DepController', ['$scope', 'Department', 'Faculty', function($scope, Department, Faculty){
        var ob=this;
        ob.objArray=[];
        ob.objArray2=[];
        ob.obj=new Department();
        ob.obj2=new Faculty();
        ob.fetchAllObject = function (){
            ob.objArray = Department.query();
            $scope.facs = ob.objArray2=Faculty.query();
        };
        
        console.log($scope.facs+"Hello");
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
            ob.obj=Department.get({depId: id}, function () {
                ob.flag='edit';
            });
        };
        
        ob.updateObjectDetail=function (){
           console.log('Inside update');
            if ($scope.objForm.$valid) {
                ob.obj.$updateObject(function (object) {
                    console.log(object);
                    ob.updatedId=object.depId;
                    ob.reset();
                    ob.flag='updated';
                    ob.fetchAllObject();
                });
            }
        };
        
        ob.deleteObject=function (id) {
           console.log('Inside delete');
           ob.obj=Department.delete({depId:id}, function () {
                ob.reset();
                ob.flag='deleted';
                ob.fetchAllObject();
            });
        };
        
        ob.reset=function () {
            ob.obj=new Department();
            $scope.objForm.$setPristine();
        };
        
        ob.cancelUpdate=function (id) {
            ob.obj=new Department();
            ob.flag='';
            ob.fetchAllObject();
        };
}]);

