const memeModel = (function () {
    const create = function (params) {
        var data = {
            title: params.title,
            description: params.description,
            imageUrl: params.imageUrl,
            creator: storage.getData('userInfo').username
        };

        var url = `appdata/${storage.appKey}/memes`;
        return requester.post(url, data);
    };

    const edit = function (params, id) {
        var data = {
            title: params.title,
            description: params.description,
            imageUrl: params.imageUrl,
            creator: storage.getData('userInfo').username
        };

        var url = `appdata/${storage.appKey}/memes/${id}`;
        return requester.update(url, data);
    };

    const getAll = function () {
        let url = `appdata/${storage.appKey}/memes?query={}&sort={"_kmd.ect": -1}`;
        return requester.get(url);
    };

    const getItem = function (id) {
        let url = `appdata/${storage.appKey}/memes/${id}`;
        return requester.get(url);
    };

    const getMine = function () {
        let url = `appdata/${storage.appKey}/memes`;
        let username = storage.getData('userInfo').username;
        url += `?query={"creator":"${username}"}&sort={"_kmd.ect": -1}`;
        return requester.get(url);
    };

    const deleteItem = function (id) {
        let url = `appdata/${storage.appKey}/memes/${id}`;
        return requester.remove(url);
    };

    const getByCreatorName = function (username) {
        let url = `appdata/${storage.appKey}/memes`;
        url += `?query={"creator":"${username}"}&sort={"_kmd.ect": -1}`;
        return requester.get(url);
    };

    return {
        create,
        edit,
        getAll,
        getItem,
        getMine,
        deleteItem,
        getByCreatorName
    };
}());