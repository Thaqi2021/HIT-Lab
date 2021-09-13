window.onload = run;


function run() {
	document.getElementById("tryAgain").onclick = run;
	
	var ans = prompt("How many prime numbers to display?","10");
	try {
		if (!ans || isNaN(ans) || ans <= 0 || Math.round(ans) != ans) {
			throw new Error("Not a valid number");
		}
		// other logic added here
		
		
	}
	catch (errMsg) {
		alert(errMsg.message);
	}
}

function displayPrimes(calculator) {
	var numberOfPrimes = calculator.getNumberOfPrimes();
	document.getElementById("numberOfPrimes").innerHTML = "You wanted this many primes: " + 
		numberOfPrimes + "<br/>";
	document.getElementById("numTests").innerHTML = "The number of tests performed: " + 
		calculator.getNumTests() + "<br/>";
	// add primes to end of display text
	document.getElementById("primeString").innerHTML = "The first " + numberOfPrimes + 
		" prime numbers are: " + calculator.getPrimesAsString();
}


// COMPLETE - define the BruteForce constructor function

	// array for primes
	var primes = new Array(0);
	var numTests = 0;
	
	
	// COMPLETE - define the 'calculatePrimesArray' method
		
		// add 2 to prime array
		if (numberOfPrimes >= 1) {
			primes.push(2);
		}
		
		var lastTested = 2;
		// loop while array needs primes added
		while ( primes.length < numberOfPrimes ) {
			// increment tested number
			lastTested++;
		
			// pass to function to test
			var isPrime = this.testForPrime(lastTested);
		
			// if prime add to array
			if (isPrime) {
				primes.push(lastTested);
			}
		}
	}
	
	this.testForPrime = function(numberToTest) {
		var modval = Math.ceil(Math.sqrt(numberToTest));
		// Check all numbers lower than the square root
		for (; modval > 1; modval--) {
			numTests++;
			if (numberToTest % modval == 0) {
				return false;
			}
		}
	
		// after loop number must be prime
		return true;
	}
	
	this.getNumberOfPrimes = function() {
		return primes.length;
	}
	
	this.getNumTests = function() {
		return numTests;
	}
	
	this.getPrimesAsString = function() {
		var primeString = "";
		for (var i = 0; i < primes.length - 1; i++) {
			primeString += primes[i] + ", ";
		}
		primeString += primes[primes.length - 1];
		return primeString;
	}
}





