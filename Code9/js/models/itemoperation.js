var itemOperations = {
	itemList :[],
	itemNo : 0,
	addItem : function( name, desc, price, url){
		this.itemNo++;
		var itemObject = new Item(this.itemNo, name,desc,price, url);
		this.itemList.push(itemObject);
		
	},
	sortByPrice:function(){
		this.itemList.sort(function(firstObject, secondObject){
			return firstObject.price - secondObject.price;
		})
	},
	deleteMarkItems:function(){
	this.itemList =  this.itemList.filter(function(itemObject){
		return itemObject.markForDeletion==false;
	});	
	},
	markUnMark:function(id){
		var itemObject =   this.itemList.filter(function(itemObject){
			return itemObject.id==id;
		})[0];
		itemObject.markForDeletion = !itemObject.markForDeletion;
	},
	searchItem:function(price){
		//var subArray = 
		return this.itemList.filter(function(itemObject){
			return itemObject.price>=price;
		});
		//return subArray;
		
	}
	

}