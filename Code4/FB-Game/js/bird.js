function Bird(birdImg,fire){
	this.x = width/2-100;
	this.y = height/2-100;
	this.width = this.height = 50;
	this.birdImg = birdImg;
	this.gravity = 0.5;
	this.velocity = 0.5;
	this.fire = fire;
	this.printBird = function(){
		imageMode(CENTER);
		image(this.birdImg, this.x, this.y , this.width, this.height);
		
	}
	this.fall = function(){
		if(this.y<=height+25){
		this.velocity += this.gravity;
		this.y +=this.velocity;
		}
		else{
		image(this.fire, this.x, this.y-50 , this.width, this.height-200);	
		}
	}
	this.up = function(){
		this.velocity = -10;
	}
	this.hit = function(pipe){
		//console.log(" "+this.x + " "+this.y +" "+pipe.x+" "+pipe.topY+" "+pipe.topHeight +" "+pipe.width);
		if(this.y>=pipe.topY && this.y<=pipe.topHeight){
			if((this.x<=pipe.x + (pipe.width/2)) && (this.x >=pipe.x - (pipe.width/2)) ){
				return true;
			}
		}
	}
}