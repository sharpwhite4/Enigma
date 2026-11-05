package UI;

import javax.swing.*;
import java.awt.*;

public class EnigmaAbout extends JDialog {

    public EnigmaAbout(JFrame parent) {

        super(parent, "Про метод", true);
        setSize(1000, 560);
        setResizable(false);
        setLocationRelativeTo(parent);
        AboutPaint dr = new AboutPaint();
        add(dr);

    }

    class AboutPaint extends Canvas {
        private Image abImg = new ImageIcon("src/UI/photo/aboutenigma.png").getImage();

        public void paint(Graphics gr) {
            Color bgColor = Color.decode("#FDE9EA");
            gr.setColor(bgColor);
            gr.fillRect(0, 0, getWidth(), getHeight());

            int imgX = 40;
            int imgY = 115;
            int imgWidth = 340;
            int imgHeight = 340;

            if (abImg != null) {
                gr.drawImage(abImg, imgX, imgY, imgWidth, imgHeight, this);
            }

            Color textColor = Color.decode("#588061");
            Font aboutFont = new Font("Segoe UI", Font.BOLD, 24);
            Font miniFont = new Font("Segoe UI", Font.PLAIN, 14);

            String headtext = "Про метод";
            gr.setColor(textColor);
            gr.setFont(aboutFont);

            FontMetrics fm = gr.getFontMetrics();
            int textx = ((getWidth() - fm.stringWidth(headtext)) / 2) + 190;
            gr.drawString(headtext, textx, 80);

            gr.setFont(miniFont);

            gr.drawString("«Енігма» — це метод шифрування, реалізований в однойменній", 430, 120);
            gr.drawString("електромеханічній шифрувальній машині, яку розробив німецький", 430, 140);
            gr.drawString("інженер Артур Шербіус (Arthur Scherbius) на початку XX століття.", 430, 160);
            gr.drawString("Машина отримала широке застосування в Німеччині, зокрема під час", 430, 180);
            gr.drawString("Другої світової війни.", 430, 200);

            gr.drawString("Її робота ґрунтується на заміні кожної літери повідомлення на іншу", 430, 240);
            gr.drawString("за допомогою спеціальної системи роторів. У найпростішому варіанті", 430, 260);
            gr.drawString("використовуються три ротори. Кожен ротор має власну відповідність", 430, 280);
            gr.drawString("між літерами алфавіту.", 430, 300);

            gr.drawString("Коли користувач вводить символ, він проходить послідовно через", 430, 340);
            gr.drawString("ротори, де декілька разів змінюється його значення. Після обробки", 430, 360);
            gr.drawString("кожного символу ротори повертаються на певну кількість позицій.", 430, 380);
            gr.drawString("Через це однакові літери можуть перетворюватися на різні символи.", 430, 400);

            gr.drawString("Під час розшифрування використовується той самий принцип і", 430, 440);
            gr.drawString("початкові налаштування роторів. Завдяки цьому зашифрований текст", 430, 460);
            gr.drawString("можна перетворити назад у початкове повідомлення.", 430, 480);


        }
    }


}