import org.opencv.core.Core;
import org.opencv.core.CvType;
import org.opencv.core.Mat;
import org.opencv.core.Scalar;

import java.lang.reflect.Field;

/**
 * @Auther: kaixuan
 * @Date: 2019/2/4 14:29
 * @Description:   ʹ�ü򵥰�����ʾ �Ƿ�ɹ�
 *
 *
 *  openvn   java ��ʹ�� ʹ�� ��Ҫ   opencv-320.jar  ��
 *       �Ͷ�Ӧ������  opencv_java320.dll
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
