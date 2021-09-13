window.onload = initAll;

function initAll() {
	var now = new Date();
	if(now.toLocaleDateString){
		var date=now.toLocaleDateString();
		var time =now.toLocaleTimeString();
		alert("it is :"+time+" on "+date);
		if(document.getElementById){
			document.getElementById("dataString").innerHTML="It Is :"+time
			+" on "+date;
		}
	}
	else{
	document.write("it is :"+time+" on "+data);
	}
	
	
}
