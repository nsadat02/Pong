package setup;

import java.util.Random;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.Input;
import org.newdawn.slick.Music;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.Sound;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;
import org.newdawn.slick.state.transition.FadeInTransition;
import org.newdawn.slick.state.transition.FadeOutTransition;


public class EasyMode extends BasicGameState{
    Image paddle,paddle2,ball,pauseMenu,player1,player2;
    Image background=null;
    public Sound beep;
    public Music music;
    int paddleX2;
    int paddleX=20;
    int paddleY=250;
    int paddleY2=250;
    int ballX=390;
    int ballY=290;
    boolean pause=false;
    boolean instruct=false;
    boolean win=false;
    Random r= new Random();
    int y=1;
    int x=1;
    int p1=0,p2=0;
    int splash=0;
    
    public void init(GameContainer gc, StateBasedGame sbg) throws SlickException {
        this.paddle = new Image("paddle.png");
        this.paddle2 = new Image("paddle.png");
        this.ball = new Image("chromeBall.png");
        background = new Image("background.png");
        this.pauseMenu = new Image("pauseMenu.png");
        //beep = new Sound("res//pongbeep.ogg");
        //music = new Music("res//music.wav");
        this.player1 = new Image("player1.png");
        this.player2 = new Image("player2.png");
        
        //music.loop(1.0F,0.1F);
    }


    public void render(GameContainer gc, StateBasedGame sbg, Graphics g) throws SlickException {
        if(win==false){
        if(instruct==false){
        if(pause==false){
        paddleX2=gc.getWidth()-20;
        g.drawImage(background,0,0);
        ball.draw(ballX,ballY);
        paddle.draw(paddleX,paddleY);
        paddle2.draw(paddleX2,paddleY2);
        g.drawString(""+p1,250,30);
        g.drawString(""+p2,450,30);
        }
        else if(pause==true){
            g.drawImage(pauseMenu, 0, 0);
        }
        }
        if(instruct==true){
            g.drawString("Welcome to the Game of PONG!!!", 50, 50);
            g.drawString("Instructions:", 50, 75);
            g.drawString("Player 1 use 'W' key to move paddle up and the 'S' key to move paddle down", 50, 100);
            g.drawString("Player 2 use 'Up' key to move paddle up and the 'Down' key to move paddle down", 50, 125);
            g.drawString("The goal of the game is to make your opponent miss the ball when receiving", 50, 150);
            g.drawString("Press 'Backspace' to go to pause menu", 50, 175);
        }
        }
        if(p1==10 && win==true){
            player1.draw(40,230);
            g.drawString("Return(<--)",650,580);
            
        }
        else if(p2==10 && win==true){
            player2.draw(40,230);
            g.drawString("Return(<--)",650,580);
        }
    }


    public void update(GameContainer gc, StateBasedGame sbg, int i) throws SlickException {
        Input input = gc.getInput();
     if(win==false){
     if(instruct==false){
     if(pause==false){
     if(input.isKeyDown(Input.KEY_P)){
            pause=true;   
        }
   
        if(ballX==390 && ballY==290 && splash==0){
             try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException ex) {
                Logger.getLogger(EasyMode.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        if(input.isKeyDown(Input.KEY_W) && paddleY-1>=0){
            paddleY-=1;
        }
        if(input.isKeyDown(Input.KEY_S) && paddleY+1<gc.getHeight()-paddle.getHeight()){
            paddleY+=1;
        }
        if(input.isKeyDown(Input.KEY_UP) && paddleY2-1>=0){
            paddleY2-=1;
        }
        if(input.isKeyDown(Input.KEY_DOWN) && paddleY2+1<gc.getHeight()-paddle.getHeight()){
            paddleY2+=1;
        }
        if(ballX+20 == paddleX2){
            if(ballY >= paddleY2-19 && ballY+10<paddleY2+41){
                if(y==1){
                    y*=-1;
                }
                x*=-1;
                //beep.play();
            }
            else if(ballY+10>=paddleY2+41 && ballY+20<=paddleY2+102){
                x*=-1;
                if(y==-1){
                    y*=-1;
                }
               //beep.play();
            }
            splash++;

        }
        else if(ballX == paddleX +10){
            if(ballY >= paddleY-19 && ballY+10<paddleY+41){
                if(y==1){
                    y*=-1;
                }
                x*=-1;
                //beep.play();
            }
            else if(ballY+10>=paddleY+41 && ballY+20<=paddleY+102){
                x*=-1;
                if(y==-1){
                    y*=-1;
                }
                //beep.play();
            }
            splash++;
        }
        else if(ballX>0 && ballX +20<gc.getWidth()){
            if(ballY==0){
                y*=-1;
            }
            else if(ballY+20==gc.getHeight()){
                y*=-1;
            }
            //beep.play();
        }
        else if(paddleY+83==ballY){
            y*=-1;
            //beep.play();
        }
        else if(paddleY2+83==ballY){
            y*=-1;
            //beep.play();
        }
        else if(paddleY==ballY+20){
            y*=-1;
            //beep.play();
        }
        else if(paddleY==ballY+20){
            y*=-1;
            //beep.play();
        }
        
        ballX+=x;
        ballY+=y;
        
        if(ballX==0 ){
            p2++;
            ballX=390;
            ballY=290;
            splash=0;
            paddleY=250;
            paddleY2=250;
        }
        else if(ballX+20==gc.getWidth()){
            p1++;
            ballX=390;
            ballY=290;
            splash=0;
            paddleY=250;
            paddleY2=250;
        }
    
    if(p1==10 || p2==10){
         win=true;
    }
     }
     else if(pause==true){
         if(input.isKeyDown(Input.KEY_1)){
            pause=false;   
        }
         if(input.isKeyDown(Input.KEY_2)){
             instruct=true;
        }
         if(input.isKeyDown(Input.KEY_3)){
           pause=false;
           p1=0;
           p2=0;
           ballX=390;
           ballY=290;
           paddleY=250;
           paddleY2=250;
        }
         if(input.isKeyDown(Input.KEY_4)){
             sbg.enterState(0, new FadeOutTransition(), new FadeInTransition());
        }
         if(input.isKeyDown(Input.KEY_5)){
             gc.exit();
        }
     }
     }
     else if(instruct==true){
         if(input.isKeyDown(Input.KEY_BACK)){
            pause=true;   
            instruct=false;
        }
     }
    }
     if(win==true){
     if(input.isKeyDown(Input.KEY_BACK)){
            sbg.enterState(0, new FadeOutTransition(), new FadeInTransition());  
        }
    }
    }
    
    public int getID() {
        return 1;
    }
}
