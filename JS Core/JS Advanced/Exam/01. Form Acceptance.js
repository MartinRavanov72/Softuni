function acceptance() {
	let company = $(`[name="shippingCompany"]`).val();
	let product = $(`[name="productName"]`).val();
	let quantity = $(`[name="productQuantity"]`).val();
	let scrape = $(`[name="productScrape"]`).val();
	if (((isNaN(company)) &&
			(isNaN(product)) &&
			(!isNaN(quantity)) &&
			(!isNaN(scrape)) &&
			company &&
			product &&
			quantity &&
			scrape &&
			(quantity > 0))) {
		$("#warehouse").append(
			$("<div>").append(
				$("<p>").text(`[${company}] ${product} - ${quantity - scrape} pieces`)
			).append(
				$(`<button>Out of stock</button>`).on("click", () => {
					$("#warehouse div").remove();
				})
			)
		);
		$(`[name="shippingCompany"]`).val("");
		$(`[name="productName"]`).val("");
		$(`[name="productQuantity"]`).val("");
		$(`[name="productScrape"]`).val("");
	}
}