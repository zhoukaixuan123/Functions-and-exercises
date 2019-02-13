import org.opencv.core.Core;
import org.opencv.core.CvType;
import org.opencv.core.Mat;
import org.opencv.core.Scalar;

import java.lang.reflect.Field;

/**
 * @Auther: kaixuan
 * @Date: 2019/2/4 14:29
 * @Description:   使用简单案例演示 是否成功
 *
 *
 *  openvn   java 包使用 使用 需要   opencv-320.jar  包
 *       和对应的驱动  opencv_java320.dll
 *
 *
 *
 */
public class OpencvStudy {






    public static void main(String[] args) {

        System.out.println("Welcome to OpenCV " + Core.VERSION);
        System.loadLibrary(Core.NATIVE_LIBRARY_NAME);
        Mat m = new Mat(5, 10, CvType.CV_8UC1);

        System.out.println("OpenCV Mat data:\n" + m.dump());
    }


}
