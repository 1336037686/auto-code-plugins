app.service("codeGenerateService",function ($http) {
    this.generatePojoCode = function(codeEntity) {
        return $http.post("/codegenerate/generatePojoCode",codeEntity);
    }
});