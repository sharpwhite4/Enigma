package UI;

import javax.swing.*;
import java.awt.*;

public class EnigmaSett  extends JDialog {

    public EnigmaSett(JFrame parent){

        super(parent, "Налаштування Енігми", false);
        setSize(385, 340);
        setResizable(false);
        setLocationRelativeTo(parent);

        EnigmaSett.SettPaint dr = new EnigmaSett.SettPaint();
        add(dr);
        ContextMenu.addTo(this);



    }

    private class SettPaint extends JPanel {

        public SettPaint() {

            setBorder(BorderFactory.createEmptyBorder(85, 45, 20, 45));


            SettPanel panel = new SettPanel();
            setLayout(new BorderLayout(0, 20));
            add(panel, BorderLayout.CENTER);
            add(createSaveButton(), BorderLayout.SOUTH);
        }

        @Override
        protected void paintComponent(Graphics gr) {
            super.paintComponent(gr);

            Color bgColor = Color.decode("#FDE9EA");
            gr.setColor(bgColor);
            gr.fillRect(0, 0, getWidth(), getHeight());

            Color textColor = Color.decode("#588061");
            Font aboutFont = new Font("Segoe UI", Font.BOLD, 24);

            String text = "Налаштування Енігми";

            gr.setColor(textColor);
            gr.setFont(aboutFont);

            FontMetrics fm = gr.getFontMetrics();

            int x = (getWidth() - fm.stringWidth(text)) / 2;

            gr.drawString(text, x, 50);
        }

        private JPanel createSaveButton() {

            JPanel panel = new JPanel();

            panel.setBackground(Color.decode("#FDE9EA"));

            JButton button = new JButton("Зберегти");
            button.setForeground(Color.decode("#588061"));
            panel.add(button);

            return panel;
        }



    }

    private class SettPanel extends JPanel {

        public SettPanel(){

            setBackground(Color.decode("#FFF7F6"));
            setLayout(new GridLayout(1, 3, 20, 0));
            setBorder(BorderFactory.createCompoundBorder(
                    BorderFactory.createLineBorder(Color.decode("#E7B5AC"), 2),
                    BorderFactory.createEmptyBorder(20, 30, 20, 30)
            ));            add(createRotorControls(), BorderLayout.CENTER);

        }

        private JPanel createRotorControls(){

            JPanel panel = new JPanel();

            panel.setBackground(Color.decode("#FFF7F6"));
            panel.setLayout(new GridLayout(3, 3, 20, 5));

            for (int i = 1; i <= 3; i++){

                JLabel label = new JLabel("Ротор " + i);
                label.setHorizontalAlignment(SwingConstants.CENTER);
                label.setFont(new Font("Segoe UI", Font.PLAIN, 14));
                label.setForeground(Color.decode("#588061"));

                panel.add(label);
            }

            for (int i = 1; i <= 3; i++){

                String rotornum[] = {"I","II", "III", "IV", "V"};
                JComboBox<String> rotor = new JComboBox(rotornum);
                rotor.setBackground(Color.decode("#FDE9EA"));
                rotor.setFont(new Font("Segoe UI", Font.PLAIN, 14));

                panel.add(rotor);
            }

            for (int i = 1; i <= 3; i++){

                JSpinner position = new JSpinner(
                        new SpinnerNumberModel(1, 1, 26, 1)
                );

                panel.add(position);
            }

            return panel;
        }


    }

}
