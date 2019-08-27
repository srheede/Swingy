package view.gui;

import controller.Methods;
import model.Map;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

import static controller.Methods.*;
import static javax.swing.JOptionPane.showInputDialog;

public class ViewGUIMain extends JFrame {
    public JFrame frame = new JFrame();
    public JPanel panelMain;
    private JButton buttonConsole;
    private JPanel cardLayout;
    public JPanel panelStart;
    public JPanel panelCreateHero;
    private JButton buttonCreateHero;
    private JButton buttonExistingHero;
    public JPanel panelExistingHero;
    private JButton buttonCHMain;
    private JButton buttonEHMain;
    private JButton buttonSpiderman;
    private JButton buttonSuperman;
    private JTextPane supermanTextPane;
    private JTextPane spidermanTextPane;
    public JPanel panelGame;
    private JButton buttonGMain;
    private JButton buttonSave;
    private JTextArea textAreaEH;
    private JButton buttonSelectHero;
    private JTextArea textAreaGame;
    public JTextArea textAreaSpecs;
    private String heroName;

    public ViewGUIMain(view.Views view){
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
        frame.setPreferredSize(new Dimension(520,400));
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
        activateButtons(view);
        frame.setContentPane(panelMain);
        panelMain.setVisible(true);
        cardLayout.setVisible(true);
        panelStart.setVisible(true);
        frame.pack();
            }
        });
    }

    private void activateButtons(view.Views view){
        buttonConsole.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                view.toConsole();
            }
        });
        buttonCreateHero.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                view.setView("createHero");
            }
        });
        buttonExistingHero.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Methods.loadHero();
                if (hero != null){
                    textAreaEH.setText(hero.getHeroInfo());
                } else {
                    textAreaEH.setText("There are no previously saved heros.");
                };
                view.setView("existingHero");
            }
        });
        buttonCHMain.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                view.setView("start");
            }
        });
        buttonEHMain.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                view.setView("start");
            }
        });
        buttonSpiderman.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                heroName = showInputDialog("Please enter hero's name:");
                createHero(heroName, "spiderman");
                loadMap();
               setTextAreaSpecs();
                view.setView("game");
            }
        });
        buttonSuperman.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                heroName = showInputDialog("Please enter hero's name:");
                createHero(heroName, "superman");
                loadMap();
                setTextAreaSpecs();
                view.setView("game");
            }
        });
        buttonGMain.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                view.setView("start");
            }
        });
        buttonSave.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                saveHero();
            }
        });
        buttonSelectHero.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                loadMap();
                setTextAreaSpecs();
                view.setView("game");
            }
        });
    }

    public void setTextAreaSpecs() {
        if (hero != null) {
            textAreaSpecs.setText(hero.getHeroInfo());
        }
        if (Methods.getMap() != null) {
            textAreaGame.setText(Methods.getMap().getString());
        }
    }
}
