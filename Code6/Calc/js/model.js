// object style
//var calcObject = {
//add:function (x,y){
//return parseInt(x) + parseInt(y);
//},
//
//subtract:function (x,y){
//	return x - y;
//},
//
//
//multiply:function (x,y){
//return x * y;
//},
//
//divide:function (x,y){
//	return x /y ;
//}
//}

function calculate(firstNo, secondNo, operator){
	var expression = firstNo +operator + secondNo;
	console.log("Expression is ",expression);
	return eval(expression);
}




// functional style
//function add(x,y){
//return parseInt(x) + parseInt(y);
//}
//
//function subtract(x,y){
//	return x - y;
//}
//
//
//function multiply(x,y){
//return x * y;
//}
//
//function divide(x,y){
//	return x /y ;
//}