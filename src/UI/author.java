package UI;

import javax.swing.*;
import java.awt.*;

public class author extends JDialog {

    public author(JFrame parent){

        super(parent, "Про авторку", true);
        setSize(300, 540);
        setResizable(false);
        setLocationRelativeTo(parent);
        AuthorPaint dr = new AuthorPaint();
        add(dr);

    }

    class AuthorPaint extends Canvas {
        private Image meImg = new ImageIcon("src/UI/photo/me.jpg").getImage();
        public void paint(Graphics gr) {
            Color bgColor = Color.decode("#FDE9EA");
            gr.setColor(bgColor);
            gr.fillRect(0, 0, getWidth(), getHeight());

            Color textColor = Color.decode("#588061");
            Font aboutFont = new Font("Segoe UI", Font.BOLD, 24);
            String text = "Про Авторку";
            gr.setColor(textColor);
            gr.setFont(aboutFont);
            FontMetrics fm = gr.getFontMetrics();
            int x = (getWidth() - fm.stringWidth(text)) / 2;
            gr.drawString(text, x, 50);

            int imgY = 80;
            int imgHeight = 320;

            if (meImg != null) {
                int imgWidth = 240;
                int imgX = (getWidth() - imgWidth) / 2;

                gr.drawImage(meImg, imgX, imgY, imgWidth, imgHeight, this);
            }

            String me = "Караван Стася";
            fm = gr.getFontMetrics();
            x = (getWidth() - fm.stringWidth(me)) / 2;
            int meY = imgY + imgHeight + 35;
            gr.drawString(me, x, meY);

            Font miniFont = new Font("Segoe UI", Font.PLAIN, 14);
            gr.setFont(miniFont);

            String[] about = {"студентка кафедри ЗІ,", "факультету ІТКІ, група 1ЕХКБ-25б"};
            fm = gr.getFontMetrics();
            int startY = meY + 30; // Початкова висота Y для першого рядка

            for (int i = 0; i < about.length; i++) {
                int textx = (getWidth() - fm.stringWidth(about[i])) / 2;
                int texty = startY + (i * 22);
                gr.drawString(about[i], textx, texty);
            }

        }
    }

}