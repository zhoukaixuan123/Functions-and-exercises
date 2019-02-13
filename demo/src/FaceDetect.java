
import org.opencv.core.Core;
import org.opencv.core.Mat;
import org.opencv.core.MatOfRect;
import org.opencv.core.Point;
import org.opencv.core.Rect;
import org.opencv.core.Scalar;
import org.opencv.imgcodecs.Imgcodecs;
import org.opencv.imgproc.Imgproc;
import org.opencv.objdetect.CascadeClassifier;




public class FaceDetect {

    public static void main(String[] args)
    {
        // TODO Auto-generated method stub
        System.loadLibrary(Core.NATIVE_LIBRARY_NAME);
        System.out.println("开始运行");
        CascadeClassifier faceDetector = new CascadeClassifier();
        faceDetector.load(
                "E:\\安装包\\spencv\\opencv-3.2.0-vc14\\opencv\\sources\\data\\haarcascades\\haarcascade_frontalface_alt.xml");
       //Mat创建图片
        Mat image = Imgcodecs.imread("E:\\kaixuan.jpg");

        MatOfRect faceDetections = new MatOfRect();
        faceDetector.detectMultiScale(image, faceDetections);
        System.out.println(String.format("Detected %s faces", faceDetections.toArray().length));
        for (Rect rect : faceDetections.toArray())
        {
            Imgproc.rectangle(image, new Point(rect.x, rect.y),
                    new Point(rect.x + rect.width, rect.y + rect.height), new Scalar(0, 255, 0));
        }

        String filename = "F:\\ouput.jpg";
        Imgcodecs.imwrite(filename, image);
    }

}









