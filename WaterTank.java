import java.awt.FlowLayout;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JSlider;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

class WaterLevelObserver extends JFrame{
    public void update(int waterLevel){
        //
    }
}

class SMSFrame extends WaterLevelObserver {
    private JLabel smsLabel;

    SMSFrame() {
        setSize(400, 400);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setTitle("SMS");
        setLayout(new FlowLayout());

        smsLabel = new JLabel("SMS Sending : 50");
        smsLabel.setFont(new Font("", Font.BOLD, 36));
        add(smsLabel);

        setVisible(true);
    }

    public void update(int waterLevel) {
        if (waterLevel >= 0 && waterLevel <= 100) {
            this.smsLabel.setText("SMS Sending : " + waterLevel);
        }
    }
}


class DisplayFrame extends WaterLevelObserver {
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

    public void update(int waterLevel) {
        if (waterLevel >= 0 && waterLevel <= 100) {
            this.displayLabel.setText(Integer.toString(waterLevel));
        }
    }
}

class AlarmFrame extends WaterLevelObserver {
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

    public void update(int waterLevel) {
        if (waterLevel >= 0 && waterLevel <= 100) {
            this.alarmLabel.setText(waterLevel >= 75 ? "On" : "Off");
        }
    }
}

class SplitterFrame extends WaterLevelObserver {
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

    public void update(int waterLevel) {
        if (waterLevel >= 0 && waterLevel <= 100) {
            this.splitterLabel.setText(waterLevel >= 90 ? "On" : "Off");
        }
    }
}

class WaterTankController{
    private WaterLevelObserver[] observers = new WaterLevelObserver[0];
    
    private int waterLevel;

    public void setWaterLevelObserver(WaterLevelObserver observer){
        WaterLevelObserver[] temp = new WaterLevelObserver[observers.length + 1];
        for(int i = 0; i < observers.length; i++){
            temp[i] = observers[i];
        }
        temp[temp.length-1] = observer;
        observers = temp;
    }


    public void setWaterLevel(int waterLevel){
        this.waterLevel = waterLevel;
        notifyObject();
    }

    public void notifyObject(){
        for (WaterLevelObserver waterLevelObserver : observers) {
            waterLevelObserver.update(waterLevel);
        }
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
        waterTankController.setWaterLevelObserver(new AlarmFrame());
        waterTankController.setWaterLevelObserver(new DisplayFrame());
        waterTankController.setWaterLevelObserver(new SplitterFrame());
        waterTankController.setWaterLevelObserver(new SMSFrame());
        new WaterTankFrame(waterTankController);
    
    }
}
