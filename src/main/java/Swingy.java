import view.console.ViewConsoleMain;
import view.gui.ViewGUIMain;
import javax.swing.*;
import javax.swing.text.View;

public class Swingy {
    public static View view;

    public static void main(String[] args){
        if (args[0].equalsIgnoreCase("GUI")){
            SwingUtilities.invokeLater(new Runnable() {
                @Override
                public void run() {
                    ViewGUIMain viewGUI = new ViewGUIMain();
                }
            });
        } else {
           ViewConsoleMain viewConsole =  new ViewConsoleMain();
        }
    }
    public static void Error(String message){
        System.out.println(message);
        System.exit(-1);
    }
}
