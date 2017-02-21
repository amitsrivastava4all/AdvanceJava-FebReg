var bird ;
var pipe;
function setup(){
createCanvas(500,500);
bird = new Bird();
pipe = new Pipe();	
}
function draw(){
	background('black');
	ellipse(bird.x,bird.y,bird.width,bird.height);
	bird.fall();
	pipe.printPipe();
}

function keyPressed(){
	const SPACE = 32;
	//console.log("Space KeyCode is ",keyCode);
	if(keyCode === SPACE ){
		bird.up();
		//console.log("Space KeyCode is ",keyCode);
	}
}