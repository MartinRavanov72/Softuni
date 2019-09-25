describe("azis", () => {
	let sofunify = new SoftUniFy();
	beforeEach(() => {
		sofunify = new SoftUniFy();
	});
	it("azis", () => {
		sofunify.downloadSong('Azis', 'Hop', 'Aidee');
		assert.equal(sofunify.allSongs["Azis"]["songs"][0], "Hop - Aidee");
	});
	it("azis", () => {
		sofunify.downloadSong('Azis', 'Hop', 'Aidee');
		sofunify.downloadSong('Azis', 'Sen Trope', 'Vsichki');
		assert.equal(sofunify.allSongs["Azis"]["songs"][0], "Hop - Aidee");
		assert.equal(sofunify.allSongs["Azis"]["songs"][1], "Sen Trope - Vsichki");
	});
	it("azis", () => {
		sofunify.downloadSong('Azis', 'Hop', 'Aidee');
		sofunify.downloadSong('Mitko', 'Sen Trope', 'Vsichki');
		assert.equal(sofunify.allSongs["Azis"]["songs"].length, 1);
		assert.equal(sofunify.allSongs["Mitko"]["songs"].length, 1);

	});
	it("azis", () => {
		sofunify.downloadSong('Azis', 'Hop', 'Aidee');
		sofunify.downloadSong('Mitko', 'Sen Trope', 'Vsichki');
		assert.equal(sofunify.allSongs["Azis"]["songs"].length, 1);
		expect(() => sofunify.allSongs["Ashli"]["songs"][0]).to.throw();
	});
	it("azis", () => {
		assert.equal(sofunify.downloadSong('Mitko', 'Sen Trope', 'Vsichki'), sofunify);
	});


	it("azis", () => {
		sofunify.downloadSong('Azis', 'Hop', 'Aidee');
		sofunify.downloadSong('Mitko', 'Sen Trope', 'Vsichki');
		assert.equal(sofunify.playSong("Hop"), "Azis:\n" + "Hop - Aidee\n");
	});
	it("azis", () => {
		sofunify.downloadSong('Azis', 'Hop', 'Aidee');
		sofunify.downloadSong('Mitko', 'Hop', 'Vsichki');
		assert.equal(sofunify.playSong("Hop"), "Azis:\nHop - Aidee\nMitko:\nHop - Vsichki\n")
	});
	it("azis", () => {
		sofunify.downloadSong('Azis', 'Hop', 'Aidee');
		sofunify.downloadSong('Mitko', 'Hop', 'Vsichki');
		assert.equal(sofunify.playSong("Azka"), "You have not downloaded a Azka song yet. Use SoftUniFy's function downloadSong() to change that!")
	});


	it("azis", () => {
		assert.equal(sofunify.songsList, "Your song list is empty");
	});
	it("azis", () => {
		sofunify.downloadSong('Azis', 'Hop', 'Aidee');
		assert.equal(sofunify.songsList, "Hop - Aidee");
	});
	it("azis", () => {
		sofunify.downloadSong('Azis', 'Hop', 'Aidee');
		sofunify.downloadSong('Mitko', 'Tochilka', 'Taam');
		assert.equal(sofunify.songsList, "Hop - Aidee\nTochilka - Taam");
	});


	it("azis", () => {
		sofunify.downloadSong('Azis', 'Hop', 'Aidee');
		assert.equal(sofunify.rateArtist('Azis'), 0);
	});
	it("azis", () => {
		sofunify.downloadSong('Azis', 'Hop', 'Aidee');
		assert.equal(sofunify.rateArtist('Azis', 10), 10);
	});
	it("azis", () => {
		sofunify.downloadSong('Azis', 'Hop', 'Aidee');
		assert.equal(sofunify.rateArtist('Azis'), 0);
		assert.equal(sofunify.rateArtist('Azis', 10), 10)
		assert.equal(sofunify.rateArtist('Azis'), 10);
	});
	it("azis", () => {
		sofunify.downloadSong('Azis', 'Hop', 'Aidee');
		sofunify.downloadSong('asd', 'Hopqwr', 'Aidasfee');
		sofunify.downloadSong('asdd', 'Horqqwp', 'Aideqwee');
		sofunify.downloadSong('dasdasdas', 'Hoqwp', 'Aqrwidee');
		assert.equal(sofunify.rateArtist('Azis', 10), 10);
	});
	it("azis", () => {
		sofunify.downloadSong('Azasdis', 'Hop', 'Aidee');
		sofunify.downloadSong('asd', 'Hopqwr', 'Aidasfee');
		sofunify.downloadSong('asdd', 'Horqqwp', 'Aideqwee');
		sofunify.downloadSong('dasdasdas', 'Hoqwp', 'Aqrwidee');
		assert.equal(sofunify.rateArtist('Azis', 10), "The Azis is not on your artist list.");
	});
	it("azis", () => {
		sofunify.downloadSong('Azasdis', 'Hop', 'Aidee');
		sofunify.downloadSong('asd', 'Hopqwr', 'Aidasfee');
		sofunify.downloadSong('asdd', 'Horqqwp', 'Aideqwee');
		sofunify.downloadSong('dasdasdas', 'Hoqwp', 'Aqrwidee');
		assert.equal(sofunify.rateArtist('Azis'), "The Azis is not on your artist list.");
	});

});