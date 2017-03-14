var itemOperations = {
	itemList :[],
	itemNo : 0,
	addItem : function( name, desc, price, url){
		this.itemNo++;
		var itemObject = new Item(this.itemNo, name,desc,price, url);
		this.itemList.push(itemObject);
		
	}

}