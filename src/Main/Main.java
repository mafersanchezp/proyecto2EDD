package Main;


import GUI.MainMenu;
import Interfaces.Excel;

/**
 *
 * @author Mafer
 */
public class Main implements Excel{
    
    public static <T> void main(String[] args) throws NoSuchFieldException {
        new MainMenu().setVisible(true);

    }
    
}
