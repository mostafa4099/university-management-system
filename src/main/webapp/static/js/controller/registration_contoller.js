'use strict';

app.factory('AccountType', ['$resource', function ($resource) {
        return $resource('http://localhost:8080/university/type/typelist/:accTypeId', {accTypeId: '@accTypeId'},
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

app.factory('StudentInfo', ['$resource', function ($resource) {
        return $resource('http://localhost:8080/university/student/studentlist/:stId', {stId: '@stId'},
            {
                updateObject:{method: 'PUT'}
            }
        );
}]);

app.factory('Login', ['$resource', function ($resource) {
        return $resource('http://localhost:8080/university/user/userlist/:loginId', {loginId: '@loginId'},
            {
                updateObject:{method: 'PUT'}
            }
        );
}]);

app.controller('RegController', ['$scope', 'Login', 'AccountType', 'Teachers', 'StudentInfo', function($scope, Login, AccountType, Teachers, StudentInfo){
        var ob=this;
        
        ob.objArray=[];
        ob.objArray2=[];
        ob.objArray3=[];
        ob.objArray4=[];
        ob.obj= new Login();
        ob.obj2=new AccountType();
        ob.obj3=new Teachers();
        ob.obj4=new StudentInfo();
        ob.fetchAllObject = function (){
            ob.objArray=Login.query();
            $scope.typ = ob.objArray2 = AccountType.query();
            $scope.tea = ob.objArray3 = Teachers.query();
            $scope.stu = ob.objArray4 = StudentInfo.query();
        };
        
        console.log($scope.tea+"Hello");
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
        
        ob.reset=function () {
            ob.obj=new Login();
            $scope.objForm.$setPristine();
        };
}]);

