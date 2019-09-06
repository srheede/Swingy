import view.Views;
import view.console.ViewConsoleMain;
import view.gui.ViewGUIMain;
import javax.swing.*;

public class Swingy {
    public static void main(String[] args){
        Views view = new Views();
        if (args.length == 1 && args[0].equalsIgnoreCase("GUI")){
            view.toGUI();
        } else {
            view.toConsole();
        }
    }
}
