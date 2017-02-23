function Pipe(){
	this.x = width;
	this.topY = 0;
	this.bottomY = height-10;
	this.width = 50;
	this.topHeight = random(height/2);
	this.bottomHeight = random(height/2);
	this.speed = -2;
	this.printPipe=function(){
		fill('green');
		rectMode(CENTER);
		rect(this.x, this.topY , this.width , this.topHeight);
		rect(this.x, this.bottomY , this.width , this.bottomHeight);
		this.x += this.speed;
	}
	this.outOfScreen = function(){
		if(this.x<=0){
			return true;
		}
		else{
			return false;
		}
	}
}