(ns noiselife_dot_org.representations.20170225c)

(def template-20170225c "
<!DOCTYPE html>
  <html lang=\"en\">
  <head>
    <title>noiselife-dot-org</title>
    <meta charset=\"UTF-8\">
    <script language=\"javascript\" type=\"text/javascript\" src=\"https://cdnjs.cloudflare.com/ajax/libs/p5.js/0.6.0/p5.min.js\"></script>
  </head>
  <script type=\"text/javascript\">
  function Bloom(temp_x,temp_y){
        blossom_spread_x = 80; //maximum width of blossom
        this.x = temp_x;
        this.y = temp_y;
        this.child_x = [];
        this.child_y = [];
        this.child_ts = [];
        this.child_fill = [];
        for (var i = 0; i < 36; i++){
            this.child_x.push(this.x - (blossom_spread_x/2) + random(blossom_spread_x));
            this.child_y.push(this.y - 40 + random(81));
            this.child_ts.push(random(10,40));
            this.child_fill.push(random(90));
            }
        

        this.blossom = function(steps,txt){
         for (var i = 0; i < steps; i++){            
            fill(this.child_fill[i])
			textSize(this.child_ts[i])
            text(txt,this.child_x[i],this.child_y[i])
         }
        }
  }  

var x,y,z;
  
  function setup(){
    createCanvas(1200,600);    
    frameRate(24);
    x = new Bloom(100,100);
    y = new Bloom(100,200);
    z = new Bloom(100,300);
}

  function draw(){
  

    if ((frameCount % 36) == 0){
       px = random(width); py = random(height);
       x = new Bloom(px,py);
	 }
    if (((frameCount - 24) % 36) == 0){
       px = random(width); py = random(height);
       y = new Bloom(px,py);
	 }
    if (((frameCount - 12) % 36) == 0){
       px = random(width); py = random(height);
       z = new Bloom(px,py);
     }   
    background(255)
    if (frameCount >= 24){
        x.blossom((frameCount % 36),\"*\");
        y.blossom(((frameCount - 24) % 36),\"x\");
        z.blossom(((frameCount - 12) % 36),\"#\");
     }


} </script>
  </body>
  </html>")
