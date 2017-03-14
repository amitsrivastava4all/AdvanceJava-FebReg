window.addEventListener("load",function(){
	document.getElementById("addBt").addEventListener("click",addNewItem);
});
function addNewItem(){
	var itemName = document.getElementById("itemname").value;
	var itemDesc = document.getElementById("desc").value;
	var price  = document.getElementById("price").value;
	var url = document.getElementById("url").value;
	itemOperations.addItem(itemName,itemDesc,price,url);
	var lastItemObject = itemOperations.itemList[itemOperations.itemList.length-1];
	printRow(lastItemObject);
	
}

function printRow(itemObject){
	var tableBody = document.getElementById("itemTableBody");
	var row = tableBody.insertRow();
	var index =0;
	for(var key in itemObject){
		row.insertCell(index).innerHTML =itemObject[key];
		index++;
		//console.log(key+" " + obj[key]);
	}
	//row.insertCell(0).innerHTML = 
}