import java.awt.FlowLayout;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JSlider;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

class DisplayFrame extends JFrame {
    private JLabel displayLabel;

    DisplayFrame() {
        setSize(400, 400);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setTitle("Display");
        setLayout(new FlowLayout());

        displayLabel = new JLabel("50");
        displayLabel.setFont(new Font("", Font.BOLD, 36));
        add(displayLabel);

        setVisible(true);
    }

    public void setDisplayLableValue(int waterLevel) {
        if (waterLevel >= 0 && waterLevel <= 100) {
            this.displayLabel.setText(Integer.toString(waterLevel));
        }
    }
}

public class WaterTank {

}
