const userModel = (function () {
    const login = function (username, password) {
        var authString = btoa(`${username}:${password}`);
        var headers = {
            Authorization: 'Basic ' + authString
        };

        var data = {
            username,
            password
        };
        var url = `user/${storage.appKey}/login`;
        return requester.post(url, data, headers);
    };

    const logout = function () {
        var url = `user/${storage.appKey}/_logout`;
        return requester.post(url);
    }

    const register = function (params) {
        var data = {
            username: params.username,
            password: params.password,
            email: params.email,
            avatarUrl: params.avatarUrl
        }

        var authString = btoa(`${storage.appKey}:${storage.appSecret}`);
        var headers = {
            Authorization: 'Basic ' + authString
        };
        var url = 'user/' + storage.appKey;
        return requester.post(url, data, headers);
    };

    const isAuthorized = function () {
        return !!storage.getData('authToken');
    };

    const getUser = function (id) {
        var url = `user/${storage.appKey}/${id}`;
        return requester.get(url);
    };

    const deleteUser = function (id) {
        var url = `user/${storage.appKey}/${id}`;
        return requester.remove(url);
    };

    return {
        login,
        logout,
        register,
        isAuthorized,
        getUser,
        deleteUser
    }
}());