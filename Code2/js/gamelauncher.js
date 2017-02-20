function setup(){
    createCanvas(500,500);
    prepareBalls();
    gameTimer();
}
function draw(){
    background('black');
    printBalls();
    printScore();
    gameOver();
}


function prepareBalls(){
    for(var i = 1; i<=50 ; i++){
        var ball = new Ball(random(width),random(height));
        balls.push(ball);
    }
}

function printScore(){
    fill("red");
    textSize(18);
    text("Score Hits "+hits+" Miss "+miss+" Time Left "+timeLeft, 10, 30);
}

function printBalls(){
    
    for(var i = 0 ; i<balls.length; i++){
        fill(balls[i].color);
        balls[i].move();
        ellipse(balls[i].x, balls[i].y, balls[i].width, balls[i].height);
    }
}
var timeLeft = 6;
var timer ;
function gameTimer(){
   timer  = setInterval(function(){
       timeLeft --;
},1000);
}

function gameOver(){
    var gameOverText = "Game Over";
    if(timeLeft<=0){
        clearInterval(timer);
        balls=[];
        background('black');
        textSize(32);
        fill('red');
        text(gameOverText,((width/2)-(gameOverText.length*16)/2) ,height/2)
    }
}

function mousePressed(){
    for(var i = 0 ; i<balls.length; i++){
        balls[i].ballClicked(i);
    }
    miss++;
    if(isHit){
      miss--;
        isHit =false;
    }
    
    //console.log("CLicked....");
}