
package UI;

import javax.swing.*;
import java.awt.*;

public class ContextMenu {

    public static void addTo(JDialog dialog) {

        JPopupMenu popupMenu = new JPopupMenu();

        JMenuItem authorItem = new JMenuItem("Про авторку");
        JMenuItem methodItem = new JMenuItem("Про метод");
        JMenuItem exitItem = new JMenuItem("Вийти");

        popupMenu.add(authorItem);
        popupMenu.add(methodItem);
        popupMenu.addSeparator();
        popupMenu.add(exitItem);

        authorItem.addActionListener(e ->
                new author(null).setVisible(true));

        methodItem.addActionListener(e ->
                new EnigmaAbout(null).setVisible(true));

        exitItem.addActionListener(e -> System.exit(0));

        addPopupToComponents(dialog, popupMenu);
    }

    private static void addPopupToComponents(
            Component component, JPopupMenu popupMenu) {

        if (component instanceof JComponent) {
            ((JComponent) component).setComponentPopupMenu(popupMenu);
        }

        if (component instanceof Container) {
            for (Component child :
                    ((Container) component).getComponents()) {

                addPopupToComponents(child, popupMenu);
            }
        }
    }
}
