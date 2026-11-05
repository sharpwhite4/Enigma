package UI;

import javax.swing.*;
import java.awt.*;


public class EnigmaMiniMenu extends JDialog {

    private final Image[] images = new Image[RabbitPose.values().length];
    private RabbitPose pose = RabbitPose.SIMPLE;

    public EnigmaMiniMenu(JDialog parent){

        super(parent, "", false);
        setSize(385, 200);
        setResizable(false);
        setLocation(parent.getX(), parent.getY() + parent.getHeight() + 40);



        JPanel bunnyPanel = new JPanel();
        bunnyPanel.setBackground(Color.decode("#FDE9EA"));


        add(bunnyPanel);
        ContextMenu.addTo(this);


    }

}


