app.controller("indexController",function ($controller,$scope,indexService,codeGenerateService) {

    $scope.loginUser = '';
    $scope.getLoginUser = function () {
        indexService.getLoginUser().success(function(response){
            $scope.loginUser = response;
            //
        });
    }

    $scope.codeEntity={basePath:'C:\\',packagePosition:'',className:"",mainKey:0,toStringKey:0,importPackages:[],
        attributes:[]}
    //{attrName:'name',attrType:'String',getterKey:0,setterKey:0}
    $scope.generatePojoCode = function () {

    }

});