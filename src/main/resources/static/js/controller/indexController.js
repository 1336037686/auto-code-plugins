app.controller("indexController",function ($controller,$scope,indexService,codeGenerateService) {

    $scope.loginUser = '';
    $scope.getLoginUser = function () {
        indexService.getLoginUser().success(function(response){
            $scope.loginUser = response;
        });
    }


    $scope.codeEntity={basePath:'D:\\',packagePosition:'',className:"",mainKey:1,toStringKey:1,importPackages:[],
        attributes:[]}
    //{attrName:'name',attrType:'String',getterKey:0,setterKey:0}
    $scope.generatePojoCode = function () {
        if(checkAttr()){
            codeGenerateService.generatePojoCode($scope.codeEntity).success(function (response) {
                if(response.success){
                    alert(response.message)
                    $scope.codeEntity={basePath:'D:\\',packagePosition:'',className:"",mainKey:1,toStringKey:1,importPackages:[], attributes:[]}
                }else{
                    alert(response.message)
                }

            })
        }else{
            alert("输入错误,请检查再生成");
        }

    }

    //验证
    checkAttr = function(){
        var attrs = $scope.codeEntity.attributes;
        for(var i = 0; i < attrs.length;i++){
            var attr = attrs[i];
            if(attr.attrName == '' || attr.attrType == '' || attr.getterKey == '' ||  attr.setterKey == ''){
                return false;
            }
        }
        if ($scope.codeEntity.basePath == ''){
            return false;
        }
        if ($scope.codeEntity.className == ''){
            return false;
        }
        return true;
    }

    // //选中
    // checkboxSelect = function(obj,form,filter,key){
    //     form.on('checkbox(' + filter + ')', function(data){
    //         if(data.elem.checked){
    //             obj[key] = 1;
    //         }else{
    //             obj[key] = 0;
    //         }
    //     });
    // }

    //添加属性
    $scope.addAttr = function(){
        var attr = {attrName:'',attrType:'',getterKey:"0",setterKey:"0"};
        $scope.codeEntity.attributes.push(JSON.parse(JSON.stringify(attr)));
    }

    $scope.delAttr = function(index){
        $scope.codeEntity.attributes.splice(index, 1);
    }


    layui.use('form', function() {
        var form = layui.form;
        form.on('select(mainFilter)', function(data){
            $scope.codeEntity.mainKey = parseInt(data.value);
        });

        form.on('select(toStringFilter)', function(data){
            $scope.codeEntity.toStringKey = parseInt(data.value);
        });

        form.render();
    });
});

