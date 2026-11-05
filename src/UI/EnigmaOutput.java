package UI;

import javax.swing.*;
import java.awt.*;

public class EnigmaOutput extends JDialog {

    public EnigmaOutput(JDialog parent) {
        super(parent, "", false);

        setSize(500, 820);
        setResizable(false);
        setLocation(parent.getX() + 385 + 40, parent.getY() - 240 );

        JPanel textPanel = new JPanel();
        textPanel.setBackground(Color.decode("#FDE9EA"));
        textPanel.setBorder(BorderFactory.createEmptyBorder(50, 40, 25, 40));
        textPanel.setLayout(new BorderLayout(0, 50));

        JLabel title = new JLabel("Вихідний текст");
        title.setFont(new Font("Segoe UI", Font.BOLD, 24));
        title.setForeground(Color.decode("#588061"));
        title.setHorizontalAlignment(SwingConstants.CENTER);

        JTextArea inputText = new JTextArea();
        inputText.setEditable(false);
        inputText.setBackground(Color.decode("#FFF7F6"));
        inputText.setForeground(Color.decode("#588061"));
        inputText.setCaretColor(Color.decode("#588061"));
        inputText.setFont(new Font("Segoe UI", Font.PLAIN, 16));
        inputText.setLineWrap(true);
        inputText.setWrapStyleWord(true);

        JScrollPane scrollPane = new JScrollPane(inputText);
        scrollPane.setBorder(
                BorderFactory.createLineBorder(Color.decode("#E7B5AC"), 2)
        );

        textPanel.add(title, BorderLayout.NORTH);
        textPanel.add(scrollPane, BorderLayout.CENTER);

        JPanel buttonPanel = new JPanel();
        buttonPanel.setBackground(Color.decode("#FDE9EA"));
        buttonPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 15, 0));
        buttonPanel.setBorder(BorderFactory.createEmptyBorder(25, 40, 50, 40));

        JButton saveButton = new JButton("Зберегти як ...");
        saveButton.setForeground(Color.decode("#588061"));
        buttonPanel.add(saveButton);

        add(textPanel, BorderLayout.CENTER);
        add(buttonPanel, BorderLayout.SOUTH);
        ContextMenu.addTo(this);
    }
}