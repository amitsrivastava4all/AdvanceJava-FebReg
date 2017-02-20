var speed = 1;
function Ball(x,y){
this.x = x;
this.y = y;
this.color='green';
this.width = 50;
this.height= 50;
this.yVelocity = this.xVelocity = speed;

    
this.move = function(){
    if(this.x>=width){
        this.xVelocity = random(-speed);
    }
    else
    if(this.x <=0){
        this.xVelocity = random(speed);
    }
    else
    if(this.y >=height){
        this.yVelocity = random(-speed);
    } 
    else
    if(this.y<=0){
        this.yVelocity = random(speed);
    }    
    this.x = this.x + this.xVelocity;
    this.y = this.y + this.yVelocity;
    
}

this.ballClicked=function(index){
    var distance = dist(mouseX, mouseY ,this.x , this.y);
    if(distance<=this.width/2){
        isHit = true;
    hits++;
        this.color="yellow";
    balls.splice(index,1);    
    }
    
}

}
