window.onload = initAll;

function initAll() {
	var ans= prompt("Are you Sure want to do ","");
	try{
	if(!ans||isNaN(ans) ||ans<0){
		throw new Error("Not a valid number");
	}
	var sqrt = Math.sqrt(ans);
	var message ="The square root of "+ ans +" is "+sqrt;
	alert(message);
	document.write(message);
	}
	catch(errMsg){
		alert(errMsg.message);
	}

}