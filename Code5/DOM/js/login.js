

function test(){
	console.log("test Call");
 test2=function(){
	console.log("test call2");
}
	//test2();
}
//test2();

function clearFields(){
//test = "TEst";	
var arrayLikeObject = document.getElementsByClassName("clear");
for(var i = 0 ; i<arrayLikeObject.length; i++){
	arrayLikeObject[i].value="";
}
}

function isAuth(){
	var userid = document.getElementById("userid").value;
	var password = document.getElementById("pwd").value;
	var useridValidate = validate(userid,"useriderror");
	var pwdValidate = validate(password,"pwderror",true);
	if(useridValidate && pwdValidate){
	if(userid == password){
		document.getElementById("msg").innerHTML="Welcome "+userid;
	}
	else{
		document.getElementById("msg").innerHTML = "Invalid Userid or password";
	}
	}
}

function isInRange(str,range){
	if(str.length>=range){
		return true;
	}
	else{
		return false;
	}
}

function validate(str,errorFieldId,isPwdField){
	var msg ;
	if(isBlank(str)){
		msg =  "Field can't be Blank";
		document.getElementById(errorFieldId).innerHTML=msg;
		return false;
	}
	
	if(isPwdField && !isInRange(str,8)){
		msg =  "Field can't be Less than 8 Char";
		document.getElementById(errorFieldId).innerHTML=msg;
		return false;
	}
	else{
		msg = "";
		document.getElementById(errorFieldId).innerHTML=msg;
		return true;
	}
	
	
	
}

function isBlank(str){
	if(str.trim().length==0){
		return true;
	}
	else{
		return false;
	}
}