const app = Sammy('#container', function () {
    this.use('Handlebars', 'hbs');

    this.get('#/home', home.index);
    this.get('#/login', user.getLogin);
    this.post('#/login', user.postLogin);
    this.get('#/logout', user.logout);
    this.get('#/register', user.getRegister);
    this.post('#/register', user.postRegister);
    this.get('#/cars/create', car.getCreate);
    this.post('#/cars/create', car.postCreate);
    this.get('#/cars/all', car.all);
    this.get('#/cars/details', car.details);
    this.get('#/cars/edit', car.getEdit);
    this.post('#/cars/edit', car.postEdit);
    this.get('#/cars/my', car.mine);
    this.get('#/cars/delete', car.deleteItem);
});

$(function () {
    app.run('#/home');
});