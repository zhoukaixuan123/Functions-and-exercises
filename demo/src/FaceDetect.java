
import org.opencv.core.*;
import org.opencv.imgcodecs.Imgcodecs;
import org.opencv.imgproc.Imgproc;
import org.opencv.objdetect.CascadeClassifier;

/**
 *
 * 人脸图片比对
 *
 *
 *
 *
 *
 */

public class FaceDetect {

    public static void main(String[] args)
   throws Exception{
      
        // TODO Auto-generated method stub
        System.loadLibrary(Core.NATIVE_LIBRARY_NAME);
        System.out.println("开始运行");
        CascadeClassifier faceDetector = new CascadeClassifier();

        //注意faceDetector.load  方法  要返回true  如果返回 false   faceDetections  会报错
       boolean fa =  faceDetector.load(
                "E:\\haarcascades\\haarcascade_frontalface_alt.xml");
       System.out.println(fa);
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
        //比对结果输出地址
        String filename = "E:\\ouput.jpg";
        Imgcodecs.imwrite(filename, image);
    }

}









