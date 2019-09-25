const pet = (function () {
    const getCreate = function (ctx) {
        ctx.partial('views/pets/createPet.hbs');
    };

    const postCreate = function (ctx) {
        petModel.create(ctx.params).then(function () {
            ctx.redirect('#/home');
            showInfo("Pet created.");
        });
    };


    const edit = function (ctx) {
        petModel.getItem(ctx.params.petId).then(function (data) {
            ctx.params.name = data.name;
            ctx.params.likes = data.likes;
            ctx.params.imageURL = data.imageURL;
            ctx.params.category = data.category;
            petModel.edit(ctx.params, ctx.params.petId).then(function () {
                ctx.redirect('#/pets/all');
                showInfo("Updated successfully!");
            });
        });
    };

    const all = function (ctx) {
        petModel.getAll().then(function (data) {
            data.sort((a, b) => +b.likes - +a.likes);
            ctx.pets = data;
            for (let i = 0; i < data.length; i++) {
                if (data[i]._acl.creator === storage.getData('userInfo').id) {
                    ctx.pets[i].mine = true;
                } else {
                    ctx.pets[i].mine = false;
                }
            }
            ctx.partial('views/pets/allPets.hbs');
        });

        var maxSpeed = {
            car: 300,
            bike: 60,
            motorbike: 200,
            airplane: 1000,
            helicopter: 400,
            rocket: 8 * 60 * 60
        };
        var sortable = [];
        for (var vehicle in maxSpeed) {
            sortable.push([vehicle, maxSpeed[vehicle]]);
        }

        sortable.sort(function (a, b) {
            return a[1] - b[1];
        });
    };

    const details = function (ctx) {
        petModel.getItem(ctx.params.id).then(function (data) {
            ctx.item = data;
            if (data._acl.creator === storage.getData('userInfo').id) {
                ctx.item.mine = true;
            } else {
                ctx.item.mine = false;
            }
            ctx.partial('views/pets/petDetails.hbs');
        });
    };

    const getDogs = function (ctx) {
        petModel.getAllOfType("Dog").then(function (data) {
            data.sort((a, b) => +b.likes - +a.likes);
            ctx.pets = data;
            for (let i = 0; i < data.length; i++) {
                if (data[i]._acl.creator === storage.getData('userInfo').id) {
                    ctx.pets[i].mine = true;
                } else {
                    ctx.pets[i].mine = false;
                }
            }
            ctx.partial('views/pets/animalTypes.hbs');
        });
    };

    const getCats = function (ctx) {
        petModel.getAllOfType("Cat").then(function (data) {
            data.sort((a, b) => +b.likes - +a.likes);
            ctx.pets = data;
            for (let i = 0; i < data.length; i++) {
                if (data[i]._acl.creator === storage.getData('userInfo').id) {
                    ctx.pets[i].mine = true;
                } else {
                    ctx.pets[i].mine = false;
                }
            }
            ctx.partial('views/pets/animalTypes.hbs');
        });
    };

    const getParrots = function (ctx) {
        petModel.getAllOfType("Parrot").then(function (data) {
            data.sort((a, b) => +b.likes - +a.likes);
            ctx.pets = data;
            for (let i = 0; i < data.length; i++) {
                if (data[i]._acl.creator === storage.getData('userInfo').id) {
                    ctx.pets[i].mine = true;
                } else {
                    ctx.pets[i].mine = false;
                }
            }
            ctx.partial('views/pets/animalTypes.hbs');
        });
    };

    const getReptiles = function (ctx) {
        petModel.getAllOfType("Reptile").then(function (data) {
            data.sort((a, b) => +b.likes - +a.likes);
            ctx.pets = data;
            for (let i = 0; i < data.length; i++) {
                if (data[i]._acl.creator === storage.getData('userInfo').id) {
                    ctx.pets[i].mine = true;
                } else {
                    ctx.pets[i].mine = false;
                }
            }
            ctx.partial('views/pets/animalTypes.hbs');
        });
    };

    const getOthers = function (ctx) {
        petModel.getAllOfType("Other").then(function (data) {
            data.sort((a, b) => +b.likes - +a.likes);
            ctx.pets = data;
            for (let i = 0; i < data.length; i++) {
                if (data[i]._acl.creator === storage.getData('userInfo').id) {
                    ctx.pets[i].mine = true;
                } else {
                    ctx.pets[i].mine = false;
                }
            }
            ctx.partial('views/pets/animalTypes.hbs');
        });
    };

    const mine = function (ctx) {
        petModel.getMine().then(function (data) {
            ctx.pets = data;
            ctx.partial('views/pets/myPets.hbs');
        });
    };

    const deleteItem = function (ctx) {
        petModel.deleteItem(ctx.params.id).then(function () {
            ctx.redirect('#/home');
            showInfo("Pet removed successfully!");
        });
    };

    const petAnimal = function (ctx) {
        petModel.getItem(ctx.params.id).then(function (data) {
            ctx.params.name = data.name;
            ctx.params.imageURL = data.imageURL;
            ctx.params.category = data.category;
            ctx.params.description = data.description;
            ctx.params.likes = +data.likes + 1 + "";
            petModel.edit(ctx.params, ctx.params.id).then(function () {
                ctx.redirect('#/pets/all');
            });
        });
    };

    return {
        getCreate,
        postCreate,
        edit,
        all,
        details,
        mine,
        deleteItem,
        getDogs,
        getCats,
        getReptiles,
        getOthers,
        getParrots,
        petAnimal
    }
}());