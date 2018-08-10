'use strict';

app.controller('NoticeListController', function ($scope, $http) {
    var ob = this;
    $scope.names;
    ob.objArray = [];
    ob.objArray2 = [];
    ob.objArray3 = [];
    ob.getFacultyList = function () {
        $http({
            method: "GET",
            url: "http://localhost:8080/university/fac/faclist"
        }).then(
                function (response) {
                    $scope.facs = ob.objArray2 = response.data;
                },
                function (reason) {
                    $scope.error_message = reason.data;
                }
        );
    };

    ob.getFacultyList();

    ob.getNoticeCate = function () {
        $http({
            method: "GET",
            url: "http://localhost:8080/university/ncat/ncatlist"
        }).then(
                function (response) {
                    ob.objArray3 = response.data;
                },
                function (reason) {
                    $scope.error_message = reason.data;
                }
        );
    };

    ob.getNoticeCate();

    console.log(ob.objArray3.length + " Hello");

    ob.fetchNoticeByMenu = function (id) {
        console.log(id + " Notice");
        $http({
            method: "GET",
            url: "http://localhost:8080/university/nbc/nbclist/" + id
        }).then(
                function (response) {
                    ob.objArray = response.data;
                },
                function (reason) {
                    $scope.error_message = reason.data;
                }
        );
    };
});
