
package UI;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import enigma.EnigmaSave;

public class EnigmaSett extends JDialog {

    private final List<JComboBox<String>> rotorBoxes = new ArrayList<>();
    private final List<JSpinner> positionSpinners = new ArrayList<>();
    private JComboBox<String> reflectorBox;

    public EnigmaSett(JFrame parent) {

        super(parent, "Налаштування Енігми", false);
        setSize(385, 400);
        setResizable(false);
        setLocationRelativeTo(parent);

        EnigmaSett.SettPaint dr = new EnigmaSett.SettPaint();
        add(dr);
        ContextMenu.addTo(this);
    }

    private void saveSettings() {

        int[] numbers = new int[3];
        int[] positions = new int[3];

        for (int i = 0; i < 3; i++) {
            numbers[i] = rotorBoxes.get(i).getSelectedIndex() + 1;
            positions[i] = (int) positionSpinners.get(i).getValue();
        }

        if (numbers[0] == numbers[1] ||
                numbers[0] == numbers[2] ||
                numbers[1] == numbers[2]) {

            JOptionPane.showMessageDialog(this, "Оберіть три різні ротори");
            return;
        }

        EnigmaSave.rotorNumbers = numbers;
        EnigmaSave.positions = positions;
        EnigmaSave.reflector = (String) reflectorBox.getSelectedItem();

        System.out.println(
                java.util.Arrays.toString(numbers) + " " +
                        java.util.Arrays.toString(positions) + " " +
                        EnigmaSave.reflector
        );

        JOptionPane.showMessageDialog(this, "Налаштування збережено");
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
            button.addActionListener(e -> saveSettings());

            panel.add(button);

            return panel;
        }
    }

    private class SettPanel extends JPanel {

        public SettPanel() {

            setBackground(Color.decode("#FFF7F6"));

            setLayout(new GridLayout(1, 1));

            setBorder(BorderFactory.createCompoundBorder(
                    BorderFactory.createLineBorder(Color.decode("#E7B5AC"), 2),
                    BorderFactory.createEmptyBorder(20, 10, 20, 10)
            ));

            add(createRotorControls());
        }

        private JPanel createRotorControls() {

            JPanel panel = new JPanel();

            panel.setBackground(Color.decode("#FFF7F6"));
            panel.setLayout(new GridLayout(4, 3, 5, 5));

            for (int i = 1; i <= 3; i++) {

                JLabel label = new JLabel("Ротор " + i);
                label.setHorizontalAlignment(SwingConstants.CENTER);
                label.setFont(new Font("Segoe UI", Font.PLAIN, 14));
                label.setForeground(Color.decode("#588061"));

                panel.add(label);
            }

            for (int i = 1; i <= 3; i++) {

                String rotornum[] = {"I", "II", "III", "IV", "V"};

                JComboBox<String> rotor = new JComboBox<>(rotornum);
                rotor.setBackground(Color.decode("#FDE9EA"));
                rotor.setFont(new Font("Segoe UI", Font.PLAIN, 14));
                rotor.setSelectedIndex(EnigmaSave.rotorNumbers[i - 1] - 1);

                rotorBoxes.add(rotor);
                panel.add(rotor);
            }

            for (int i = 1; i <= 3; i++) {

                JSpinner position = new JSpinner(
                        new SpinnerNumberModel(
                                EnigmaSave.positions[i - 1], 0, 25, 1
                        )
                );

                positionSpinners.add(position);
                panel.add(position);
            }

            JLabel reflectorLabel = new JLabel("Рефлектор");
            reflectorLabel.setHorizontalAlignment(SwingConstants.CENTER);
            reflectorLabel.setFont(new Font("Segoe UI", Font.PLAIN, 14));
            reflectorLabel.setForeground(Color.decode("#588061"));

            reflectorBox = new JComboBox<>(new String[]{"B", "C"});
            reflectorBox.setBackground(Color.decode("#FDE9EA"));
            reflectorBox.setFont(new Font("Segoe UI", Font.PLAIN, 14));
            reflectorBox.setSelectedItem(EnigmaSave.reflector);

            // Назва в першій колонці
            panel.add(reflectorLabel);

            // Порожня друга колонка
            panel.add(new JLabel());

            // Список у третій колонці
            panel.add(reflectorBox);

            return panel;
        }
    }
}
