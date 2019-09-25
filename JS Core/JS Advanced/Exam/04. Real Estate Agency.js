function realEstateAgency() {
	$(`[name="regOffer"]`).on("click", regOffer);
	$(`[name="findOffer"]`).on("click", findOffer);



	function regOffer() {
		$("#message").empty();
		let rent = $(`[name="apartmentRent"]`).val();
		let apartment = $(`[name="apartmentType"]`).val();
		let commission = $(`[name="agencyCommission"]`).val();
		if (rent > 0 && apartment != "" && commission >= 0 && +commission <= 100 && apartment.indexOf(':') < 0) {
			$("#building").append(
				$("<div>").addClass("apartment").append(
					$("<p>").text("Rent: " + rent)
				).append(
					$("<p>").text("Type: " + apartment)
				).append(
					$("<p>").text("Commission: " + commission)
				)
			);
			$("#message").text('Your offer was created successfully.');


		} else {
			$("#message").text('Your offer registration went wrong, try again.');


		}
		$(`[name="apartmentRent"]`).val("");
		$(`[name="apartmentType"]`).val("");
		$(`[name="agencyCommission"]`).val("");

	}

	function findOffer() {
		$("#message").empty();
		let budget = $(`[name="familyBudget"]`).val();
		let apartment = $(`[name="familyApartmentType"]`).val();
		let name = $(`[name="familyName"]`).val();
		if (budget > 0 && apartment != "" && name != "") {
			let allApartments = $(".apartment");
			for (let apartmentSeached of allApartments) {
				if ($(apartmentSeached.children[1]).text().slice(6) === apartment) {
					let rent = +$(apartmentSeached.children[0]).text().slice(6);
					let percentage = +$(apartmentSeached.children[2]).text().slice(12) / 100 + 1;
					if (percentage * rent <= budget) {
						let profit = ((percentage - 1) * rent) * 2;
						let result = +$($("#roof h1")[0]).text().split(" ")[2] + profit;
						$($("#roof h1")[0]).text("Agency profit: " + result + " lv.")
						$("#message").text('Enjoy your new home! :))');
						$(apartmentSeached).css("border", "2px solid red");
						$(apartmentSeached).empty();
						$(apartmentSeached).append(
							$("<p>").text(name)
						).append(
							$("<p>").text("live here now")
						)
						$(apartmentSeached).append(
							$("<button>").text("MoveOut").on("click", function () {

								$("#message").text(`They had found cockroaches in ${$($(this.parent()).children[0]).text()}\'s apartment`);
								$($(this.parent()).children[0]).remove();
							})
						);

					} else {
						$("#message").text('We were unable to find you a home, so sorry :(');
					}
				} else {
					$("#message").text('We were unable to find you a home, so sorry :(');
				}
			}

		}
		$(`[name="familyBudget"]`).val("");
		$(`[name="familyApartmentType"]`).val("");
		$(`[name="familyName"]`).val("");
	}

}