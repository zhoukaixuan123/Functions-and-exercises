
import org.opencv.core.*;
import org.opencv.imgcodecs.Imgcodecs;
import org.opencv.imgproc.Imgproc;
import org.opencv.objdetect.CascadeClassifier;

/**
 *
 * ����ͼƬ�ȶ�
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
        System.out.println("��ʼ����");
        CascadeClassifier faceDetector = new CascadeClassifier();

        //ע��faceDetector.load  ����  Ҫ����true  ������� false   faceDetections  �ᱨ��
       boolean fa =  faceDetector.load(
                "E:\\haarcascades\\haarcascade_frontalface_alt.xml");
       System.out.println(fa);
       //Mat����ͼƬ
        Mat image = Imgcodecs.imread("E:\\kaixuan.jpg");

        MatOfRect faceDetections = new MatOfRect();
        faceDetector.detectMultiScale(image, faceDetections);
        System.out.println(String.format("Detected %s faces", faceDetections.toArray().length));
        for (Rect rect : faceDetections.toArray())
        {
            Imgproc.rectangle(image, new Point(rect.x, rect.y),
                    new Point(rect.x + rect.width, rect.y + rect.height), new Scalar(0, 255, 0));
        }
        //�ȶԽ�������ַ
        String filename = "E:\\ouput.jpg";
        Imgcodecs.imwrite(filename, image);
    }

}









