package setup;
        
import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.StateBasedGame;
     
public class SetUp extends StateBasedGame { 

    public SetUp(String name) {
        super(name);
    }

    
    public static void main(String[] args) throws SlickException{
         AppGameContainer app = new AppGameContainer(new SetUp("Pong"));
         app.setDisplayMode(800, 600, false);
         app.setAlwaysRender(true);
         app.setTargetFrameRate(10000);
         app.start();
    }
    
    @Override
    public void initStatesList(GameContainer gc) throws SlickException {
        
        this.addState(new Menu());
        this.addState(new EasyMode());
        this.addState(new InterMode());
        this.addState(new HardMode());
        //this.addState(new EndGame());
        
        
    }
    
}
