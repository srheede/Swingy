package view.gui;

import controller.Methods;
import model.Map;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

import static controller.Game.conflict;
import static controller.Game.nextLevel;
import static controller.Methods.*;
import static javax.swing.JOptionPane.showInputDialog;

public class ViewGUIMain extends JFrame {
    public JFrame frame = new JFrame();
    public JPanel panelMain;
    public JButton buttonConsole;
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
    private KeyListener listener;

    public ViewGUIMain(view.Views view) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                frame.setPreferredSize(new Dimension(520, 400));
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.addWindowListener(new WindowAdapter() {
                    public void windowClosing(WindowEvent e) {
                        System.exit(0);
                    }
                });
                activateButtons(view);
                frame.setContentPane(panelMain);
                frame.setVisible(true);
                panelMain.setVisible(true);
                cardLayout.setVisible(true);
                panelStart.setVisible(true);
                frame.pack();
                listener = new KeyListener() {
                    @Override
                    public void keyTyped(KeyEvent e) {
                    }

                    @Override
                    public void keyPressed(KeyEvent e) {
                        switch (e.getKeyCode()) {
                            case KeyEvent.VK_DOWN:
                                if (++hero.i > Map.getSize() - 1) {
                                    nextLevel();
                                } else {
                                    Map.refreshMap();
                                    if (Map.map[hero.i][hero.j] == 'X') {
                                        conflict();
                                    }
                                }
                                break;
                            case KeyEvent.VK_UP:
                                if (--hero.i < 0) {
                                    nextLevel();
                                } else {
                                    Map.refreshMap();
                                    if (Map.map[hero.i][hero.j] == 'X') {
                                        conflict();
                                    }
                                }
                                break;
                            case KeyEvent.VK_LEFT:
                                if (--hero.j < 0) {
                                    nextLevel();
                                } else {
                                    Map.refreshMap();
                                    if (Map.map[hero.i][hero.j] == 'X') {
                                        conflict();
                                    }
                                }
                                break;
                            case KeyEvent.VK_RIGHT:
                                if (++hero.j > Map.getSize() - 1) {
                                    nextLevel();
                                } else {
                                    Map.refreshMap();
                                    if (Map.map[hero.i][hero.j] == 'X') {
                                        conflict();
                                    }
                                }
                                break;
                        }
                        setTextAreaSpecs();
                    }

                    @Override
                    public void keyReleased(KeyEvent e) {

                    }
                };

            }
        });
    }

    public void keyListener(boolean active) {
        if (active) {
            buttonConsole.addKeyListener(listener);
            buttonSave.addKeyListener(listener);
        } else {
            buttonConsole.removeKeyListener(listener);
            buttonSave.removeKeyListener(listener);
        }
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
                    buttonSelectHero.setVisible(true);
                    textAreaEH.setText(hero.getHeroInfo());
                } else {
                    buttonSelectHero.setVisible(false);
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
                if (heroName != null) {
                    createHero(heroName, "spiderman");
                    loadMap();
                    loadGame();
                    setTextAreaSpecs();
                    view.setView("game");
                }
            }
        });
        buttonSuperman.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                heroName = showInputDialog("Please enter hero's name:");
                if (heroName != null) {
                    createHero(heroName, "superman");
                    loadMap();
                    loadGame();
                    setTextAreaSpecs();
                    view.setView("game");
                }
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
                loadGame();
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
            setMapSize();
            if (hero.getLevel() == 4 || hero.getLevel() == 0){
                keyListener(false);
                buttonSave.setVisible(false);
            } else {
                buttonSave.setVisible(true);
            }
            textAreaGame.setText(Methods.getMap().getString());
        }
    }

    private void setMapSize() {
        Font font;
        switch (hero.getLevel()) {
            case 1:
                font = new Font(Font.DIALOG, Font.PLAIN, 20);
                textAreaGame.setFont(font);
                break;
            case 2:
                font = new Font(Font.DIALOG, Font.PLAIN, 12);
                textAreaGame.setFont(font);
                break;
            case 3:
                font = new Font(Font.DIALOG, Font.BOLD, 10);
                textAreaGame.setFont(font);
                break;
        }
    }
}
