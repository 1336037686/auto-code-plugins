app.service("indexService",function ($http) {

    this.getLoginUser = function() {
        return $http.get("/user/getLoginUser");
    }
});