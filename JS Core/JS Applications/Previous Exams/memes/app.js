const app = Sammy('#container', function () {
    this.use('Handlebars', 'hbs');

    this.get('#/home', home.index);
    this.get('#/login', user.getLogin);
    this.post('#/login', user.postLogin);
    this.get('#/logout', user.logout);
    this.get('#/register', user.getRegister);
    this.post('#/register', user.postRegister);
    this.get('#/memes/create', meme.getCreate);
    this.post('#/memes/create', meme.postCreate);
    this.get('#/memes/all', meme.all);
    this.get('#/memes/details', meme.details);
    this.get('#/memes/edit', meme.getEdit);
    this.post('#/memes/edit', meme.postEdit);
    this.get('#/users/profile', user.getProfile);
    this.get('#/users/profile/delete', user.deleteProfile);
    this.get('#/memes/delete', meme.deleteItem);

});

$(function () {
    app.run('#/home');
});