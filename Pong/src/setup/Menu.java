package setup;

import java.util.ArrayList;
import org.lwjgl.input.Mouse;
import org.newdawn.slick.geom.Circle;
import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;
import org.newdawn.slick.state.transition.FadeInTransition;
import org.newdawn.slick.state.transition.FadeOutTransition;



public class Menu extends BasicGameState{
Image menu;
    public void init(GameContainer gc, StateBasedGame sbg) throws SlickException {
        this.menu=new Image("menu.png");
    }
    
    public void update(GameContainer gc, StateBasedGame sbg, int i) throws SlickException {
        if(gc.getInput().isKeyPressed(Input.KEY_1)){
            sbg.enterState(1, new FadeOutTransition(), new FadeInTransition());
        }
        if(gc.getInput().isKeyPressed(Input.KEY_2)){
            sbg.enterState(2, new FadeOutTransition(), new FadeInTransition());
        }
        if(gc.getInput().isKeyPressed(Input.KEY_3)){
            sbg.enterState(3, new FadeOutTransition(), new FadeInTransition());
        }
        if(gc.getInput().isKeyPressed(Input.KEY_ESCAPE)){
            gc.exit();
        }        
        
        int posX = Mouse.getX();
        int posY = Mouse.getY();
        
        if((posX>50 && posX<100) && (posY>50 && posY<100)){
            if(Mouse.isButtonDown(0)){
                sbg.enterState(1, new FadeOutTransition(), new FadeInTransition());
            }
        }
        
    }

    public void render(GameContainer gc, StateBasedGame sbg, Graphics g) throws SlickException {
        menu.draw(0,0);
        g.drawString("Press ESCAPE to EXIT game!",10,550);
    }

    public int getID() {
        return 0;
    }
    
}
