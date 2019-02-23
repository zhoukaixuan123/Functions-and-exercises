import com.github.sarxos.webcam.Webcam;
import com.github.sarxos.webcam.WebcamPanel;
import com.github.sarxos.webcam.WebcamResolution;

import javax.swing.*;

/**
 * @Auther: kaixuan
 * @Date: 2019/2/15 21:03
 * @Description:
 *
 *   µ˜”√…„œÒÕ∑
 *
 *
 *
 */
public class demo {

    public  static void main(String[] args){
        Webcam webcam = Webcam.getDefault();

        webcam.setViewSize(WebcamResolution.VGA.getSize());

        WebcamPanel panel = new WebcamPanel(webcam);

        panel.setFPSDisplayed(true);

        panel.setDisplayDebugInfo(true);

        panel.setImageSizeDisplayed(true);

        panel.setMirrored(true);

        JFrame window = new JFrame("Test webcam panel");

        window.add(panel);

        window.setResizable(true);

        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        window.pack();

        window.setVisible(true);

    }
}
