app.controller("indexController",function ($controller,$scope,indexService) {

    $scope.loginUser = '';
    $scope.getLoginUser = function () {
        indexService.getLoginUser().success(function(response){
            $scope.loginUser = response;
        });
    }
});