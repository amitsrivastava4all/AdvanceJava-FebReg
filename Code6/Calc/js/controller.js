//alert("Here....");
window.addEventListener("load",function(){
var buttons = document.getElementsByClassName("opr");
Array.prototype.forEach.apply(buttons,[function(button){
	button.addEventListener("click",compute);
}])	;
//document.getElementById("addBt").addEventListener("click",addNumber);
//
//document.getElementById("subtractBt").addEventListener("click",subtractNumber);

});
function compute(){
	//var currentOperation  = this.getAttribute("data-operation");
	var output;
	var firstNo = document.getElementById("firstno").value;
	var secondNo = document.getElementById("secondno").value;
	//var currentButton = this.innerHTML;
	var operator = this.innerHTML;
	//output = calcObject[currentOperation](firstNo,secondNo);
	output = calculate(firstNo,secondNo,operator);
//	if(currentButton =="+"){
//	
//		//output = calcObject.add(firstNo,secondNo);
//		//output = add(firstNo,secondNo); 
//	}
//	else
//	if(currentButton=="-"){
//		output = subtract(firstNo,secondNo);
//	}
//	else
//	if(currentButton == "*"){
//		output = multiply(firstNo,secondNo);
//	}
//	else
//	if(currentButton=="/"){
//		output  = divide(firstNo,secondNo); 
//	}	
	document.getElementById("result").innerHTML = output;
	
}
//function addNumber(){
//	var firstNo = document.getElementById("firstno").value;
//	var secondNo = document.getElementById("secondno").value;
//	var output = add(firstNo,secondNo);
//	document.getElementById("result").innerHTML = output;
//}
//
//
//function subtractNumber(){
//	var firstNo = document.getElementById("firstno").value;
//	var secondNo = document.getElementById("secondno").value;
//	var output = subtract(firstNo,secondNo);
//	document.getElementById("result").innerHTML = output;
//}
