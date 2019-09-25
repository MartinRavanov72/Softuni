const car = (function () {
    const getCreate = function (ctx) {
        if (!userModel.isAuthorized()) {
            ctx.redirect('#/login');
        } else {
            ctx.partial('views/cars/createCar.hbs');
        }
    };

    const postCreate = function (ctx) {
        carModel.create(ctx.params).then(function () {
            ctx.redirect('#/cars/all');
            showInfo("Listing created.");
        });
    };

    const getEdit = function (ctx) {
        ctx.partial('views/cars/editCar.hbs').then(function () {
            let form = $('#edit-car-form');
            carModel.getItem(ctx.params.id).then(function (data) {
                form.find('input[name="carId"]').val(ctx.params.id);
                form.find('input[name="title"]').val(data.title);
                form.find('input[name="description"]').val(data.description);
                form.find('input[name="brand"]').val(data.brand);
                form.find('input[name="model"]').val(data.model);
                form.find('input[name="year"]').val(data.year);
                form.find('input[name="imageUrl"]').val(data.imageUrl);
                form.find('input[name="fuel"]').val(data.fuel);
                form.find('input[name="price"]').val(data.price);
            });

        });
    };

    const postEdit = function (ctx) {
        carModel.edit(ctx.params, ctx.params.carId).then(function () {
            ctx.redirect('#/cars/all');
            showInfo(`Listing ${ctx.params.title} updated.`);
        });
    };

    const all = function (ctx) {
        carModel.getAll().then(function (data) {
            ctx.cars = data;
            //data has a property seller(which is way way easier)
            for (let i = 0; i < data.length; i++) {
                if (data[i]._acl.creator === storage.getData('userInfo').id) {
                    ctx.cars[i].mine = true;
                } else {
                    ctx.cars[i].mine = false;
                }
            }
            ctx.partial('views/cars/allCars.hbs');
        });
    };

    const details = function (ctx) {
        carModel.getItem(ctx.params.id).then(function (data) {
            ctx.item = data;
            if (data._acl.creator === storage.getData('userInfo').id) {
                ctx.item.mine = true;
            } else {
                ctx.item.mine = false;
            }
            ctx.partial('views/cars/carDetails.hbs');
        });
    };

    const mine = function (ctx) {
        carModel.getMine().then(function (data) {
            ctx.cars = data;
            ctx.partial('views/cars/myCars.hbs');
        });
    };

    const deleteItem = function (ctx) {
        carModel.deleteItem(ctx.params.id).then(function () {
            ctx.redirect('#/cars/all');
            showInfo("Listing deleted.");
        });
    }

    return {
        getCreate,
        postCreate,
        getEdit,
        postEdit,
        all,
        details,
        mine,
        deleteItem
    }
}());