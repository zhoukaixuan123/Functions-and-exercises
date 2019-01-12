package QRcode;


import java.awt.Graphics2D;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletResponse;



import com.google.zxing.BarcodeFormat;
import com.google.zxing.Binarizer;
import com.google.zxing.BinaryBitmap;
import com.google.zxing.DecodeHintType;
import com.google.zxing.EncodeHintType;
import com.google.zxing.LuminanceSource;
import com.google.zxing.MultiFormatReader;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.Result;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.common.HybridBinarizer;
import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;


/**
 * @Auther: kaixuan
 * @Date: 2019/1/11 17:50
 * @Description:
 *
 *   ���ɶ�ά��
 *   ���й��߰�  core-3.30
 *
 */
public class QRcodeUtil  extends LuminanceSource  {




    // ��ά����ɫ
    private static final int BLACK = 0xFF000000;
    // ��ά����ɫ
    private static final int WHITE = 0xFFFFFFFF;

    private final BufferedImage image;
    private final int left;
    private final int top;

    public QRcodeUtil(BufferedImage image) {
        this(image, 0, 0, image.getWidth(), image.getHeight());
    }

    public QRcodeUtil(BufferedImage image, int left, int top, int width, int height) {
        super(width, height);
        int sourceWidth = image.getWidth();
        int sourceHeight = image.getHeight();
        if (left + width > sourceWidth || top + height > sourceHeight) {
            throw new IllegalArgumentException("Crop rectangle does not fit within image data.");
        }
        for (int y = top; y < top + height; y++) {
            for (int x = left; x < left + width; x++) {
                if ((image.getRGB(x, y) & 0xFF000000) == 0) {
                    image.setRGB(x, y, 0xFFFFFFFF); // = white
                }
            }
        }
        this.image = new BufferedImage(sourceWidth, sourceHeight, BufferedImage.TYPE_BYTE_GRAY);
        this.image.getGraphics().drawImage(image, 0, 0, null);
        this.left = left;
        this.top = top;
    }

    @Override
    public byte[] getRow(int y, byte[] row) {
        if (y < 0 || y >= getHeight()) {
            throw new IllegalArgumentException("Requested row is outside the image: " + y);
        }
        int width = getWidth();
        if (row == null || row.length < width) {
            row = new byte[width];
        }
        image.getRaster().getDataElements(left, top + y, width, 1, row);
        return row;
    }

    @Override
    public byte[] getMatrix() {
        int width = getWidth();
        int height = getHeight();
        int area = width * height;
        byte[] matrix = new byte[area];
        image.getRaster().getDataElements(left, top, width, height, matrix);
        return matrix;
    }

    @Override
    public boolean isCropSupported() {
        return true;
    }

    @Override
    public LuminanceSource crop(int left, int top, int width, int height) {
        return new QRcodeUtil(image, this.left + left, this.top + top, width, height);
    }

    @Override
    public boolean isRotateSupported() {
        return true;
    }

    @Override
    public LuminanceSource rotateCounterClockwise() {
        int sourceWidth = image.getWidth();
        int sourceHeight = image.getHeight();
        AffineTransform transform = new AffineTransform(0.0, -1.0, 1.0, 0.0, 0.0, sourceWidth);
        BufferedImage rotatedImage = new BufferedImage(sourceHeight, sourceWidth, BufferedImage.TYPE_BYTE_GRAY);
        Graphics2D g = rotatedImage.createGraphics();
        g.drawImage(image, transform, null);
        g.dispose();
        int width = getWidth();
        return new QRcodeUtil(rotatedImage, top, sourceWidth - (left + width), getHeight(), width);
    }

    /**
     * @param matrix
     * @return
     */
    private static BufferedImage toBufferedImage(BitMatrix matrix) {
        int width = matrix.getWidth();
        int height = matrix.getHeight();
        BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
        for (int x = 0; x < width; x++) {
            for (int y = 0; y < height; y++) {
                image.setRGB(x, y, matrix.get(x, y) ? BLACK : WHITE);
            }
        }
        return image;
    }

    /**
     * ���ɶ�ά��ͼƬ
     *
     * @param matrix
     * @param format
     * @param file
     * @throws IOException
     */
    public static void writeToFile(BitMatrix matrix, String format, File file) throws IOException {
        BufferedImage image = toBufferedImage(matrix);
        if (!ImageIO.write(image, format, file)) {
            throw new IOException("Could not write an image of format " + format + " to " + file);
        }
    }

    /**
     * ���ɶ�ά��ͼƬ��
     *
     * @param matrix
     * @param format
     * @param stream
     * @throws IOException
     */
    public static void writeToStream(BitMatrix matrix, String format, OutputStream stream) throws IOException {
        BufferedImage image = toBufferedImage(matrix);
        if (!ImageIO.write(image, format, stream)) {
            throw new IOException("Could not write an image of format " + format);
        }
    }

    /**
     * �������ݣ�����ָ����ߡ�ָ����ʽ�Ķ�ά��ͼƬ
     *
     * @param text   ����
     * @param width  ��
     * @param height ��
     * @param format ͼƬ��ʽ
     * @return ���ɵĶ�ά��ͼƬ·��
     * @throws Exception
     */
    private static String generateQRCode(String text, int width, int height, String format, String pathName)
            throws Exception {
        Hashtable<EncodeHintType, Object> hints = new Hashtable<EncodeHintType, Object>();
        hints.put(EncodeHintType.CHARACTER_SET, "utf-8");// ָ�������ʽ
        hints.put(EncodeHintType.ERROR_CORRECTION, ErrorCorrectionLevel.L);// ָ������ȼ�
        hints.put(EncodeHintType.MARGIN, 1); // �ױߴ�С��ȡֵ��Χ0~4
        BitMatrix bitMatrix = new MultiFormatWriter().encode(text, BarcodeFormat.QR_CODE, width, height, hints);
        File outputFile = new File(pathName);
        writeToFile(bitMatrix, format, outputFile);
        return pathName;
    }

    /**
     * �����ά��ͼƬ��
     *
     * @param text ��ά������
     * @param width ��ά���
     * @param height ��ά���
     * @param format ͼƬ��ʽeg: png, jpg, gif
     * @param response HttpServletResponse
     * @throws Exception
     */
    public static void generateQRCode(String text, int width, int height, String format, HttpServletResponse response)
            throws Exception {
        Hashtable<EncodeHintType, Object> hints = new Hashtable<EncodeHintType, Object>();
        hints.put(EncodeHintType.CHARACTER_SET, "utf-8");// ָ�������ʽ
        hints.put(EncodeHintType.ERROR_CORRECTION, ErrorCorrectionLevel.L);// ָ������ȼ�
        hints.put(EncodeHintType.MARGIN, 1); // �ױߴ�С��ȡֵ��Χ0~4
        BitMatrix bitMatrix = new MultiFormatWriter().encode(text, BarcodeFormat.QR_CODE, width, height, hints);
        writeToStream(bitMatrix, format, response.getOutputStream());
    }

    /**
     * ����ָ��·���µĶ�ά��ͼƬ
     *
     * @param filePath ��ά��ͼƬ·��
     * @return
     */
    public static String parseQRCode(String filePath) {
        String content = "";
        try {
            File file = new File(filePath);
            BufferedImage image = ImageIO.read(file);
            LuminanceSource source = new QRcodeUtil(image);
            Binarizer binarizer = new HybridBinarizer(source);
            BinaryBitmap binaryBitmap = new BinaryBitmap(binarizer);
            Map<DecodeHintType, Object> hints = new HashMap<DecodeHintType, Object>();
            hints.put(DecodeHintType.CHARACTER_SET, "UTF-8");
            MultiFormatReader formatReader = new MultiFormatReader();
            Result result = formatReader.decode(binaryBitmap, hints);

            System.out.print("result Ϊ��" + result.toString());
            System.out.print("resultFormat Ϊ��" + result.getBarcodeFormat());
            System.out.print("resultText Ϊ��" + result.getText());
            // ���÷���ֵ
            content = result.getText();
        } catch (Exception e) {
            System.out.print(e.getMessage());
        }
        return content;
    }

    public static void main(String[] args) {
        String text = "hello world!"; // ���������֤��
        System.out.println("����룺 " + text);
        int width = 100; // ��ά��ͼƬ�Ŀ�
        int height = 100; // ��ά��ͼƬ�ĸ�
        String format = "png"; // ��ά��ͼƬ�ĸ�ʽ

        try {
            // ���ɶ�ά��ͼƬ��������ͼƬ·��
            String pathName = generateQRCode(text, width, height, format, "D:/new.png");
            System.out.println("���ɶ�ά���ͼƬ·���� " + pathName);

            String content = parseQRCode(pathName);
            System.out.println("��������ά���ͼƬ������Ϊ�� " + content);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}


