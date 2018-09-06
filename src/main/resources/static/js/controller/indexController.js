


app.controller("indexController",function ($controller,$scope,indexService,codeGenerateService) {

    $scope.loginUser = '';
    $scope.getLoginUser = function () {
        indexService.getLoginUser().success(function(response){
            $scope.loginUser = response;
            //
        });
    }


    $scope.codeEntity={basePath:'C:\\',packagePosition:'',className:"",mainKey:1,toStringKey:1,importPackages:[],
        attributes:[]}
    //{attrName:'name',attrType:'String',getterKey:0,setterKey:0}
    $scope.generatePojoCode = function () {
        codeGenerateService.generatePojoCode($scope.codeEntity).success(function (response) {
            if(response.success){
                alert(response.message)
                $scope.codeEntity={basePath:'C:\\',packagePosition:'',className:"",mainKey:1,toStringKey:1,importPackages:[], attributes:[]}
            }else{
                alert(response.message)
            }

        })
    }


    layui.use('form', function() {
        var form = layui.form;
        form.on('select(mainFilter)', function(data){
            $scope.codeEntity.mainKey = parseInt(data.value);
        });

        form.on('select(toStringFilter)', function(data){
            $scope.codeEntity.toStringKey = parseInt(data.value);
        });

        form.on('checkbox(setterFilter)', function(data){

        });

        form.on('checkbox(getterFilter)', function(data){

        })
        ;
        form.render();
    });
});

