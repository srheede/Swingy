package view.gui;

import view.View;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class ViewGUIMain extends JFrame {
    private JPanel panelMain;
    private JButton buttonConsole;
    private JPanel cardLayout;
    private JPanel panelStart;
    private JPanel panelCreateHero;
    private JButton buttonCreateHero;
    private JButton ButtonExistingHero;
    private JPanel panelExistingHero;

    public ViewGUIMain(){
        JFrame frame = new JFrame();
        frame.setPreferredSize(new Dimension(500,400));
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
        buttonConsole.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.setVisible(false);
            }
        });
        frame.setContentPane(panelMain);
        frame.setVisible(true);
        panelMain.setVisible(true);
        cardLayout.setVisible(true);
        panelStart.setVisible(true);
        frame.pack();
    }
}
