package UI;

import javax.swing.*;
import java.awt.*;

public class EnigmaMode extends JDialog {

    public EnigmaMode(JDialog parent) {
        super(parent, "", false);

        setSize(385, 200);
        setResizable(false);
        setLocation(parent.getX(), parent.getY() - 240);

        JMenuBar menuBar = new JMenuBar();
        menuBar.setOpaque(true);
        menuBar.setBackground(Color.decode("#FDE9EA"));

        JMenu menu = new JMenu("Меню");
        menu.setOpaque(true);
        menu.setForeground(Color.decode("#588061"));
        menu.setBackground(Color.decode("#FDE9EA"));


        JMenuItem authorItem = new JMenuItem("Про авторку");
        JMenuItem methodItem = new JMenuItem("Про метод");
        JMenuItem exitItem = new JMenuItem("Вийти");
        menu.add(authorItem);
        menu.add(methodItem);
        menu.add(exitItem);

        menuBar.add(Box.createHorizontalGlue());
        menuBar.add(menu);
        menuBar.add(Box.createHorizontalGlue());
        setJMenuBar(menuBar);

        authorItem.addActionListener(e ->
                new author(null).setVisible(true)
        );
        methodItem.addActionListener(e ->
                new EnigmaAbout(null).setVisible(true)
        );
        exitItem.addActionListener(e -> System.exit(0));

        JPanel panel = new JPanel();
        panel.setBackground(Color.decode("#FDE9EA"));
        panel.setBorder(BorderFactory.createEmptyBorder(30, 20, 30, 20));
        panel.setLayout(new GridLayout(1, 2, 15, 0));

        JButton encryptButton = new JButton("Шифрування");
        JButton decryptButton = new JButton("Розшифрування");

        Color white = Color.WHITE;
        Color selectedColor = Color.decode("#F9E0DB");
        Color green = Color.decode("#588061");
        Color borderColor = Color.decode("#E7B5AC");

        // Налаштування кнопок
        JButton[] buttons = {encryptButton, decryptButton};

        for (JButton button : buttons) {
            button.setBackground(white);
            button.setForeground(green);
            button.setFont(new Font("Segoe UI", Font.PLAIN, 14));

            button.setOpaque(true);
            button.setContentAreaFilled(true);
            button.setFocusPainted(false);

            button.setBorder(BorderFactory.createLineBorder(borderColor, 2));
        }

        // Вибір режиму шифрування
        encryptButton.addActionListener(e -> {
            encryptButton.setBackground(selectedColor);
            decryptButton.setBackground(white);
        });

        // Вибір режиму розшифрування
        decryptButton.addActionListener(e -> {
            decryptButton.setBackground(selectedColor);
            encryptButton.setBackground(white);
        });

        panel.add(encryptButton);
        panel.add(decryptButton);


        add(panel);
        ContextMenu.addTo(this);

    }
}

