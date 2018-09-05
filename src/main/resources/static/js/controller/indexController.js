app.controller("indexController",function ($controller,$scope,indexService,$http) {

    $scope.loginUser = '';

        $scope.codeEntity={basePath:'D:\\item\\',packagePosition:'com.fjut',className:"HelloWorld",mainKey:1,toStringKey:1,importPackages:['Date','Map','Set','List'],attributes:[{attrName:'name',attrType:'String',getterKey:1,setterKey:1},{attrName:'age',attrType:'Integer',getterKey:1,setterKey:1}]}
    $scope.getLoginUser = function () {
        indexService.getLoginUser().success(function(response){
            $scope.loginUser = response;
            $http.post("/codegenerate/getAttr",$scope.codeEntity)
        });
    }



});