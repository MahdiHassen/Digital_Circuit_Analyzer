package Components;

import javax.swing.*;

public class GUI_Test {
    private JButton testButtonButton;
    private JPanel Main_Panel;


    public static void main(String[] args) {
        JFrame frame = new JFrame("GUI_Test");
        frame.setContentPane(new GUI_Test().Main_Panel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}
