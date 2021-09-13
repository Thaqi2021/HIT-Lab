window.onload = initAll;

function initAll() {
	var ans = prompt("How many prime numbers to display?","10");
	try {
		if (!ans || isNaN(ans) || ans <= 0 || Math.round(ans) != ans) {
			throw new Error("Not a valid number");
		}
		calculatePrimesArray(ans);
	}
	catch (errMsg) {
		alert(errMsg.message);
	}
}

function calculatePrimesArray(numberOfPrimes) {
	// array for primes
	var primes = new Array(0);
	
	// add 2 to prime array
	if (numberOfPrimes >= 1) {
			primes.push(2);
	}
	
	var lastTested = 2;
	// loop while array needs primes added
	while ( primes.length<numberOfPrimes  ) {
		// increment tested number
		lastTested++;
		
		// pass to function to test
		var isPrime = testForPrime(lastTested, primes);
		
		// if prime add to array
		if (isPrime) {
			primes.push(lastTested);
		}
	}
		
	displayPrimes(numberOfPrimes, primes);
}

function testForPrime(numberToTest, primes) {
	var upperLimit = Math.ceil(Math.sqrt(numberToTest));
	
	// loop until prime divisor is greater than upper limit to test
	for (var i = 0; primes[i]<=upperLimit  ; i++) {
		if (  numberToTest % primes[i]==0   ) {
			return false;
		}
	}
	// after loop number must be prime
	return true;
}

function displayPrimes(numberOfPrimes, primes) {
	document.write("You wanted this many primes: " + 
		numberOfPrimes + "<br/>");
	
	var primeString="";
	for(var i=0;i<primes.length-1;i++){
		primeString+=primes[i]+",";
	}
	primeString +=primes[primes.length-1];
	
	// add primes to end of display text
	document.write("The first " + numberOfPrimes + 
		" prime numbers are: "+primeString );
}

