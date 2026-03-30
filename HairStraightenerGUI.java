import com.fazecast.jSerialComm.SerialPort;
import javax.swing.*;
import java.io.InputStream;

public class HairStraightenerGUI {

    static SerialPort arduinoPort;
    static JLabel statusLabel;

    public static void main(String[] args) {

        arduinoPort = SerialPort.getCommPort("COM3"); // okulda COM3 yerine COM4/COM5 olabilir
        arduinoPort.setBaudRate(9600);
        arduinoPort.openPort();

        JFrame frame = new JFrame("Hair Straightener Control System");
        frame.setSize(330, 320);
        frame.setLayout(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JButton onBtn = new JButton("POWER ON");
        onBtn.setBounds(50, 20, 220, 35);
        frame.add(onBtn);

        JButton offBtn = new JButton("POWER OFF");
        offBtn.setBounds(50, 70, 220, 35);
        frame.add(offBtn);

        JButton heatBtn = new JButton("HEATING MODE");
        heatBtn.setBounds(50, 120, 220, 35);
        frame.add(heatBtn);

        JButton resetBtn = new JButton("RESET");
        resetBtn.setBounds(50, 170, 220, 35);
        frame.add(resetBtn);

        statusLabel = new JLabel("Status: Waiting...");
        statusLabel.setBounds(50, 225, 240, 30);
        frame.add(statusLabel);

        onBtn.addActionListener(e -> sendCommand("1"));
        offBtn.addActionListener(e -> sendCommand("2"));
        heatBtn.addActionListener(e -> sendCommand("3"));
        resetBtn.addActionListener(e -> sendCommand("4"));

        startReadingFromArduino();

        frame.setVisible(true);
    }

    public static void sendCommand(String command) {
        if (arduinoPort != null && arduinoPort.isOpen()) {
            byte[] buffer = command.getBytes();
            arduinoPort.writeBytes(buffer, buffer.length);
        }
    }

    public static void startReadingFromArduino() {
        Thread thread = new Thread(() -> {
            try {
                InputStream input = arduinoPort.getInputStream();
                StringBuilder message = new StringBuilder();

                while (true) {
                    int data = input.read();

                    if (data == -1) {
                        continue;
                    }

                    if (data == '\n') {
                        String received = message.toString().trim();

                        SwingUtilities.invokeLater(() ->
                            statusLabel.setText("Status: " + received)
                        );

                        System.out.println("Arduino: " + received);
                        message.setLength(0);
                    } else {
                        message.append((char) data);
                    }
                }
            } catch (Exception e) {
                SwingUtilities.invokeLater(() ->
                    statusLabel.setText("Status: Connection Error")
                );
            }
        });

        thread.setDaemon(true);
        thread.start();
    }
}
