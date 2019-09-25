const petModel = (function () {
    const create = function (params) {
        var data = {
            name: params.name,
            description: params.description,
            imageURL: params.imageURL,
            category: params.category,
            likes: 0 + ""
        };

        var url = `appdata/${storage.appKey}/pets`;

        return requester.post(url, data);
    };

    const edit = function (params, id) {
        var data = {
            name: params.name,
            description: params.description,
            imageURL: params.imageURL,
            category: params.category,
            likes: params.likes
        };

        var url = `appdata/${storage.appKey}/pets/${id}`;

        return requester.update(url, data);
    };

    const getAll = function () {
        let url = `appdata/${storage.appKey}/pets?query={}&sort={"likes": -1}`;

        return requester.get(url);
    };

    const getItem = function (id) {
        let url = `appdata/${storage.appKey}/pets/${id}`;

        return requester.get(url);
    };

    const getMine = function () {
        let url = `appdata/${storage.appKey}/pets/`;
        let userId = storage.getData('userInfo').id;
        url += `?query={"_acl.creator":"${userId}"}`;

        return requester.get(url);
    };

    const getAllOfType = function (type) {
        let url = `appdata/${storage.appKey}/pets/`;
        url += `?query={"category":"${type}"}`;

        return requester.get(url);
    };

    const deleteItem = function (id) {
        let url = `appdata/${storage.appKey}/pets/${id}`;

        return requester.remove(url);
    };

    return {
        create,
        edit,
        getAll,
        getItem,
        getMine,
        deleteItem,
        getAllOfType
    };
}());