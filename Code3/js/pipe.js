function Pipe(){
	this.x = width;
	this.top = 0;
	this.bottom = random(height/2);
	this.width=50;
	this.height = random(height/2);
	this.velocity = -2;
	this.printPipe=function(){
		fill('green');
		rect(this.x,this.top,this.width, this.height);
		rect(this.x,this.bottom,this.width, this.height);
		this.x = this.x + this.velocity;
		
	}
}