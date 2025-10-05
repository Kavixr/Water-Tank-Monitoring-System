import java.awt.FlowLayout;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JSlider;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

//Implemented the Display Frame 
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

//Implemented the  Alarm Frame
class AlarmFrame extends JFrame {
    private JLabel alarmLabel;

    AlarmFrame() {
        setSize(400, 400);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setTitle("Alarm");
        setLayout(new FlowLayout());

        alarmLabel = new JLabel("Off");
        alarmLabel.setFont(new Font("", Font.BOLD, 36));
        add(alarmLabel);

        setVisible(true);
    }

    public void setAlarmLableValue(int waterLevel) {
        if (waterLevel >= 0 && waterLevel <= 100) {
            this.alarmLabel.setText(waterLevel >= 75 ? "On" : "Off");
        }
    }
}

//Implement the Splitter Frame
class SplitterFrame extends JFrame {
    private JLabel splitterLabel;

    SplitterFrame() {
        setSize(400, 400);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setTitle("Splitter");
        setLayout(new FlowLayout());

        splitterLabel = new JLabel("Off");
        splitterLabel.setFont(new Font("", Font.BOLD, 36));
        add(splitterLabel);

        setVisible(true);
    }

    public void setSplitterLableValue(int waterLevel) {
        if (waterLevel >= 0 && waterLevel <= 100) {
            this.splitterLabel.setText(waterLevel >= 90 ? "On" : "Off");
        }
    }
}




public class WaterTank {
    
}
