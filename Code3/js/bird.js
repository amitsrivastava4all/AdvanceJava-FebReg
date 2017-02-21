function Bird(){
this.x = width/2-50;
this.y = height/2;
this.height = this.width = 50;
this.gravity = 1;
this.velocity = 1;	
this.fall= function(){
	this.velocity = this.velocity + this.gravity;
	this.y = this.y + this.velocity;
}
this.up = function(){
	this.velocity = -12;
}
}