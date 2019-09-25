class Vacation {
	constructor(organizer, destination, budget) {
		this.organizer = organizer;
		this.destination = destination;
		this.budget = +budget;
		this.kids = {};
	}

	registerChild(name, grade, budget) {
		if (budget < this.budget) {
			return `${name}\'s money is not enough to go on vacation to ${this.destination}.`;
		}
		if ((this.kids[grade] !== undefined) && (this.kids[grade].includes(name + "-" + budget))) {
			return `${name} is already in the list for this ${this.destination} vacation.`;
		}
		if (!this.kids[grade]) {
			this.kids[grade] = [];
		}

		this.kids[grade].push(`${name}-${budget}`);

		return this.kids[grade];
	}

	removeChild(name, grade) {
		let index;
		if ((this.kids[grade] !== undefined)) {
			for (let i = 0; i < this.kids[grade].length; i++) {
				if (this.kids[grade][i].startsWith(name)) {
					index = i;
					break;
				}
			}
		} else {
			return `We couldn't find ${name} in ${grade} grade.`;
		}
		if (index || index == 0) {
			this.kids[grade].splice(index, 1);
			return this.kids[grade];
		} else {
			return `We couldn't find ${name} in ${grade} grade.`;
		}
	}

	toString() {
		let array = Object.keys(this.kids).sort((a, b) => a - b);
		let a = [];
		for (let i = 0; i < array.length; i++) {
			if (this.kids[array[i]].length == 0) {
				a.push(false);
			} else {
				a.push(true);
			}

		}
		let isLegit = true;
		for (let el of a) {
			if (!el) {
				isLegit = false;
				break;
			}
		}
		if (!isLegit) {
			return `No children are enrolled for the trip and the organization of ${this.organizer} falls out...`;
		}
		let str = `${this.organizer} will take ${this.numberOfChildren} children on trip to ${this.destination}\n`;
		for (let i = 0; i < array.length; i++) {
			str += "Grade: " + array[i] + "\n";
			let mid = this.kids[array[i]];
			for (let j = 0; j < mid.length; j++) {
				if (j !== mid.length - 1) {
					str += `${j + 1}. ${mid[j]}\n`;
				} else {
					str += `${j + 1}. ${mid[j]}`;
				}

			}
			str += "\n";
		}
		return str;
	}

	get numberOfChildren() {
		let array = Object.keys(this.kids);
		let num = 0;
		for (let i = 0; i < array.length; i++) {
			num += this.kids[array[i]].length
		}
		return num;
	}
}