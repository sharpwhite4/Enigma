package UI;

import javax.swing.*;
import java.awt.*;

public class EnigmaMenu extends JFrame {
    public EnigmaMenu(){
        super ("Головне меню");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(330, 500);
        setLocationRelativeTo(null);
        MenuPaint dr = new MenuPaint();
        add(dr);

        JButton benter = new JButton("Розпочати шифрування"),
                babout = new JButton("Про метод"),
                bauthor = new JButton("Про Авторку"),
                bexit = new JButton("Вийти");

        benter.setForeground(Color.decode("#588061"));
        babout.setForeground(Color.decode("#588061"));
        bauthor.setForeground(Color.decode("#588061"));
        bexit.setForeground(Color.decode("#588061"));

        bexit.addActionListener(e -> System.exit(0));

        babout.addActionListener(e -> {
            EnigmaAbout aboutWindow = new EnigmaAbout(this);
            aboutWindow.setVisible(true);
        });

        bauthor.addActionListener(e -> {
            author authorWindow = new author(this);
            authorWindow.setVisible(true);
        });

        benter.addActionListener(e -> {
            setVisible(false);

            EnigmaSett settWindow = new EnigmaSett(this);
            settWindow.setVisible(true);

            EnigmaMiniMenu miniMenuWindow = new EnigmaMiniMenu(settWindow);
            miniMenuWindow.setVisible(true);

            EnigmaMode modeWindow = new EnigmaMode(settWindow);
            modeWindow.setVisible(true);

            EnigmaInput inputWindow = new EnigmaInput(settWindow);
            inputWindow.setVisible(true);

            EnigmaOutput outputWindow = new EnigmaOutput(settWindow);
            outputWindow.setVisible(true);


        });

        JPanel buttoncard = new JPanel();
        buttoncard.setBackground(Color.decode("#F9E0DB"));
        buttoncard.setPreferredSize(new Dimension(450, 105));
        buttoncard.setBorder(BorderFactory.createEmptyBorder(0, 25, 0, 25));

        buttoncard.add(benter);
        buttoncard.add(babout);
        buttoncard.add(bauthor);
        buttoncard.add(bexit);

        add(buttoncard, BorderLayout.SOUTH);
    }


}

class MenuPaint extends Canvas {
    private Image keybImg = new ImageIcon("src/UI/photo/enigma.png").getImage();
    public void paint(Graphics gr) {
        Color bgColor = Color.decode("#FDE9EA");
        gr.setColor(bgColor);
        gr.fillRect(0, 0, getWidth(), getHeight());

        Color textColor = Color.decode("#588061");
        Font textFont = new Font("Segoe UI", Font.BOLD, 30);
        String text = "шифр Енігми";
        gr.setColor(textColor);
        gr.setFont(textFont);
        FontMetrics fm = gr.getFontMetrics();
        int x = (getWidth() - fm.stringWidth(text)) / 2;
        gr.drawString(text, x, 50);

        if (keybImg != null) {
            int imgWidth = 228;
            int imgHeight = 273;
            int imgX = (getWidth() - imgWidth) / 2;
            int imgY = 80;

            gr.drawImage(keybImg, imgX, imgY, imgWidth, imgHeight, this);
        }
    }
}