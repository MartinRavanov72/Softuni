const app = Sammy('#site-content', function () {
    this.use('Handlebars', 'hbs');

    this.get('#/home', home.index);
    this.get('#/login', user.getLogin);
    this.post('#/login', user.postLogin);
    this.get('#/logout', user.logout);
    this.get('#/register', user.getRegister);
    this.post('#/register', user.postRegister);
    this.get('#/pets/create', pet.getCreate);
    this.post('#/pets/create', pet.postCreate);
    this.get('#/pets/all', pet.all);
    this.get('#/pets/parrots', pet.getParrots);
    this.get('#/pets/dogs', pet.getDogs);
    this.get('#/pets/cats', pet.getCats);
    this.get('#/pets/other', pet.getOthers);
    this.get('#/pets/reptiles', pet.getReptiles);
    this.get('#/pets/my', pet.mine);
    this.get('#/pets/details', pet.details);
    this.get('#/pets/delete', pet.deleteItem);
    this.get('#/pets/pet', pet.petAnimal);
    this.post('#/pets/edit', pet.edit);
});

$(function () {
    app.run('#/home');
});