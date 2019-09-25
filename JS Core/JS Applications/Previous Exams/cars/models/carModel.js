const carModel = (function () {
    const create = function (params) {
        var data = {
            brand: params.brand,
            description: params.description,
            fuel: params.fuel,
            imageUrl: params.imageUrl,
            model: params.model,
            price: params.price,
            seller: storage.getData('userInfo').username,
            title: params.title,
            year: params.year
        };

        var url = `appdata/${storage.appKey}/cars`;

        return requester.post(url, data);
    };

    const edit = function (params, id) {
        var data = {
            brand: params.brand,
            description: params.description,
            fuel: params.fuel,
            imageUrl: params.imageUrl,
            model: params.model,
            price: params.price,
            seller: storage.getData('userInfo').username,
            title: params.title,
            year: params.year
        };

        var url = `appdata/${storage.appKey}/cars/${id}`;

        return requester.update(url, data);
    };

    const getAll = function () {
        let url = `appdata/${storage.appKey}/cars?query={}&sort={"_kmd.ect": -1}`;

        return requester.get(url);
    };

    const getItem = function (id) {
        let url = `appdata/${storage.appKey}/cars/${id}`;

        return requester.get(url);
    };

    const getMine = function () {
        let url = `appdata/${storage.appKey}/cars/`;
        let userId = storage.getData('userInfo').id;
        url += `?query={"_acl.creator":"${userId}"}&sort={"_kmd.ect": -1}`;

        return requester.get(url);
    };

    const deleteItem = function (id) {
        let url = `appdata/${storage.appKey}/cars/${id}`;

        return requester.remove(url);
    };

    return {
        create,
        edit,
        getAll,
        getItem,
        getMine,
        deleteItem
    };
}());