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

class WaterTankController{
    private AlarmFrame alarmFrame;
    private DisplayFrame displayFrame;
    private SplitterFrame splitterFrame;
    
    private int waterLevel;

    public void setAlarmFrame(AlarmFrame alarmFrame){
        this.alarmFrame = alarmFrame;
    }
    public void setDisplayFrame(DisplayFrame displayFrame){
        this.displayFrame = displayFrame;
    }
    public void setSplitterFrame(SplitterFrame splitterFrame){
        this.splitterFrame = splitterFrame;
    }

    public void setWaterLevel(int waterLevel){
        this.waterLevel = waterLevel;
        notifyObject();
    }

    public void notifyObject(){
        this.displayFrame.setDisplayLableValue(waterLevel);
        this.alarmFrame.setAlarmLableValue(waterLevel);
        this.splitterFrame.setSplitterLableValue(waterLevel);
    }
}

class WaterTankFrame extends JFrame{
    private JSlider slider;
    private WaterTankController waterTankController;
    WaterTankFrame(WaterTankController waterTankController){
        this.waterTankController = waterTankController;
        setSize(400, 400);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setTitle("Water Tank");
        setLayout(new FlowLayout());

        slider = new JSlider(JSlider.VERTICAL);
        slider.setMajorTickSpacing(10);
        slider.setPaintLabels(true);

        slider.addChangeListener(new ChangeListener() {
            public void stateChanged(ChangeEvent e) {
                int waterLevel = slider.getValue();    
                waterTankController.setWaterLevel(waterLevel);
            }
        });

        add(slider);

        setVisible(true);
    }
}

class WaterTank {
    public static void main(String[] args) {
        WaterTankController waterTankController = new WaterTankController();
        waterTankController.setAlarmFrame(new AlarmFrame());
        waterTankController.setDisplayFrame(new DisplayFrame());
        waterTankController.setSplitterFrame(new SplitterFrame());
        new WaterTankFrame(waterTankController);
    
    }
}
