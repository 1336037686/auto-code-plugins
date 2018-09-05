app.controller("loginController",function ($controller,$scope,loginService) {

    $scope.login = function () {

        loginService.login($scope.entity).success(function(response){
            if (response.success){
                alert(response.message);
                location.href="/autoCodeIndexView"
            }else{
                alert(response.message);
                $scope.entity={userName:'',password:''};
            }
        });
    }
});