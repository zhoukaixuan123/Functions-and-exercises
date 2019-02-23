import org.opencv.core.Core;
import org.opencv.core.Mat;
import org.opencv.imgproc.Imgproc;
import org.opencv.videoio.VideoCapture;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 *≤‚ ‘»À¡≥
 *
 *
 */
public class ShowVeda {

    static {
        System.loadLibrary(Core.NATIVE_LIBRARY_NAME);
    }

    private JFrame frame;
    static JLabel label;
    static int flag = 0;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    ShowVeda window = new ShowVeda();
                    window.frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
        //≤Ÿ◊˜
        VideoCapture camera = new VideoCapture();
        camera.open(1);
        if (!camera.isOpened()) {
            System.out.println("Camera Error");
        } else {
            Mat frame = new Mat();
            while (flag == 0) {
                camera.read(frame);
                Mat gray = new Mat(frame.rows(), frame.cols(), frame.type());
                Imgproc.cvtColor(frame, gray, Imgproc.COLOR_RGB2GRAY);
                label.setIcon(new ImageIcon(mat2BufferedImage.matToBufferedImage(gray)));
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    /**
     * Create the application.
     */
    public ShowVeda() {
        initialize();
    }

    /**
     * Initialize the contents of the frame.
     */
    private void initialize() {
        frame = new JFrame();
        frame.setBounds(100, 100, 798, 600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(null);


        JButton btnNewButton = new JButton("≈ƒ’’");
        btnNewButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent arg0) {
                flag = 1;
            }
        });
        btnNewButton.setBounds(20, 20, 113, 27);
        frame.getContentPane().add(btnNewButton);

        label = new JLabel("");
        label.setBounds(50, 50, 640, 480);
        frame.getContentPane().add(label);
    }


}