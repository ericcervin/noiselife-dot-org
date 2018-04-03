(ns noiselife_dot_org.representations.20180402)

(def template-20180402 "
<!DOCTYPE html>
  <html lang=\"en\">
  <head>
    <title>noiselife-dot-org</title>
    <meta charset=\"UTF-8\">
    <script language=\"javascript\" type=\"text/javascript\" src=\"https://cdnjs.cloudflare.com/ajax/libs/p5.js/0.6.0/p5.min.js\"></script>
  </head>
  <script type=\"text/javascript\">
  
  text_array = [\"n\",\"o\",\"i\",\"s\",\"e\",\"l\",\"i\",\"f\",\"e\"];    //text that will appear in each splash. 
                                                                            

  display_width = 1200;                        //width of the display window
  display_height = 600;                       //height of the display window

  letter_list = [];
  letter_spread = 36/text_array.length;

function LetSplash(temp_x,temp_y,temp_age,temp_chr){
                                             
        min_circ_lightness = 55;             //minimum lightness for each circle
        max_circ_lightness = 200;            //maximum lightness for each circle
                                             //0 = pure black. 255 = pure white
                                             
        max_circ_diameter = 100;             //maximum diameter of circles around each letter
                                             
        this.x = temp_x;
        this.y = temp_y;
        this.char = temp_chr;
        this.age = temp_age;
        this.child_diameter = [];
        this.child_hue = [];
        for (var i = 0; i < 36; i++){
            this.child_diameter.push(random(25,max_circ_diameter))
            this.child_hue.push(random(min_circ_lightness,max_circ_lightness))
            }

     this.render = function(){
        textSize(20);
        if (mouseIsPressed){
            fill(255);
        } else {
            fill(0);
        }
        rectMode(CORNER);
        text(this.char,this.x-5,this.y+5)
        
        noFill();
        strokeWeight(2);
        ellipseMode(CENTER);
        for (var i = 0; i < this.age + 1; i++){         
            if (mouseIsPressed){
                stroke(255 - this.child_hue[i]);
            } else {
                stroke(this.child_hue[i]);
            }
            ellipse(this.x,this.y,this.child_diameter[i],this.child_diameter[i]);
         }
	   
	   }     
}

function setup(){
    createCanvas(display_width,display_height);    
    frameRate(24);
    for (var i = 0; i < 36; i++){
        if ((i % letter_spread) == 0){
            letter_list.push(new LetSplash(random(display_width),random(display_height),i,text_array[(i / letter_spread)]));
        } else {
            letter_list.push(\"_\");
	    }
	 }
	}
    
    
    
function draw(){
    if (mouseIsPressed){
        background(0);
    } else {
        background(255);
    }
            
    for (var i = 0; i < 36; i++){
        if ((i % letter_spread) == 0){
            letter_list[i].render();
            letter_list[i].age += 1;
            if (letter_list[i].age > 35){
               letter_list[i] = new LetSplash(random(width),random(height),0,text_array[(i / letter_spread)])

            }
        }
    }
}
  </script>
  </body>
  </html>")
