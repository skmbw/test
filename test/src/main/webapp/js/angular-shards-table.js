var projectName = '/' + window.location.pathname.split('/')[1];
var shardsTableUrl = {
    'addUrl' : projectName + '/shardsTable/doAdd',
    'deleteUrl' : projectName + '/shardsTable/delete',
    'updateUrl' : projectName + '/shardsTable/update',
    'queryUrl' : projectName + '/shardsTable/list'
};
var shardsTableService = angular.module('shardsTableService', [ 'ngResource' ], angular.noop);
shardsTableService.controller('shardsTableController', function($scope, $resource) {
    var actions = {
        'add' : {
            method : 'PUT',
            isArray : true,
            headers : {
                'Content-Type' : 'application/json'
            }
        },
        'deletes' : {//delete是js的关键字
            method : 'DELETE',
            isArray : true
        },
        'query' : {
            method : 'GET',
            isArray : true
        },
        'update' : {
            method : 'POST',
            isArray : true,
            headers : {
                'Content-Type' : 'application/json'
            }
        }
    };
    var shardsTableList = $resource(shardsTableUrl.queryUrl, {
        page : 1,
        pageSize : 20
    }, actions.query);
    shardsTableList.query({}, function(data) {// 这个会自动执行的
        $scope.mydata = data;
    });

    var shardsTableAdd = $resource(shardsTableUrl.addUrl, {
        page : 1,
        pageSize : 20
    }, actions);
    $scope.addShardsTable = function() {// 类似这种，点击了才执行
    	shardsTableAdd.add($scope.saveData, function(data) {
            $scope.mydata = data;
        });
    };

    var shardsTableUpdate = $resource(shardsTableUrl.updateUrl, {
        page : 1,
        pageSize : 20
    }, actions);
    $scope.updateShardsTableClick = function() {// 实际的更新操作
    	shardsTableUpdate.update($scope.saveData, function(data) {
            $scope.mydata = data;
        });
    };

    var shardsTableDelete = $resource(shardsTableUrl.deleteUrl, {
        page : 1,
        pageSize : 20,
        id : ':id'
    }, actions);
    $scope.deleteUser = function(data) {//删除功能
    	shardsTableDelete.deletes({//userDelete['deletes']也可以
            id : data.id
        }, {}, function(data) {
            $scope.mydata = data;
        });
    };
    $scope.updateShardsTable = function(data) {// 对应列表中的更新功能，将数据添加到更新区域
        $scope.saveData = data;
    };
});