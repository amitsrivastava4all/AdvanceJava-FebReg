window.addEventListener("load",function(){
	document.getElementById("addBt").addEventListener("click",addNewItem);
	document.getElementById("search").addEventListener("click",searchItem);
	
	document.getElementById("delete").addEventListener("click",deleteMarkItems);
	
	document.getElementById("sort").addEventListener("click",sortByPrice);
});

function sortByPrice(){
	itemOperations.sortByPrice();
	printItems(itemOperations.itemList);
}

function deleteMarkItems(){
	itemOperations.deleteMarkItems();
	printItems(itemOperations.itemList);
}

function searchItem(){
	
	var price = parseInt(document.getElementById("price").value);
	
	var subArray = itemOperations.searchItem(price);
	printItems(subArray);
}
function printItems(itemArray){
	clearTable();
	itemArray.forEach(printRow);
}
function clearTable(){
	 document.getElementById("itemTableBody").innerHTML="";
}
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
	var id = 0;
	for(var key in itemObject){
		if(key=='id'){
			id = itemObject[key];
		}
		if(key=='markForDeletion'){
			continue;
		}
		if(key=='url'){
			// <img src='path'
			row.insertCell(index).innerHTML="<img src='"+itemObject[key]+"' width='100' height='100'>";
		}
		else{
		row.insertCell(index).innerHTML =itemObject[key];
		}
			index++;
		//console.log(key+" " + obj[key]);
	}
	
	// Operations
	var deleteImg = document.createElement("img");
	deleteImg.src = "images/delete.png";
	deleteImg.className="showcursor";
	var editImg = document.createElement("img");
	editImg.src = "images/edit.png";
	
	editImg.className="showcursor";
	var td = row.insertCell(index);
	td.append(deleteImg);
	deleteImg.addEventListener("click",markForDeletion);
	deleteImg.setAttribute("data-params",id);
	//deleteImg.onclick=markForDeletion(id);
	td.append(editImg);
	//row.insertCell(0).innerHTML = 
}

function markForDeletion(event){
	var id =event.srcElement.getAttribute("data-params");
	console.log("Id is ",id);
	itemOperations.markUnMark(id);
	var currentTR = event.srcElement.parentElement.parentElement;
	currentTR.classList.toggle("showred");
	
	//console.log();
	//alert("Ready For Delete");
}