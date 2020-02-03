package skinDetector;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.*;
import java.io.IOException;

public class SkinTest {

    public static void main(String[] args) throws IOException {

        double[][][] probSkin = new double[256][256][256];
        String[][][] sProbSkin = new String[256][256][256];
        File input=new File("C:\\IIT Files\\5th Semester\\DBMS-2\\ibtd-20200118T175313Z-001\\ibtd\\Zyan2.jpg");
        BufferedImage testImg=null;
        BufferedReader inputFile = new BufferedReader(new FileReader("C:\\IIT Files\\4th Semester\\eclipse-workspace\\output.txt"));

        for (int i=0;i<256;i++)
        {
            for (int j=0;j<256;j++)
            {
                for (int k=0;k<256;k++)
                {
                   String d = inputFile.readLine();
                    try {
                        probSkin[i][j][k]= Double.parseDouble(d);
                    } catch (NullPointerException e) {
                    }
                }
            }
        }



        try {
            testImg= ImageIO.read(input);
        } catch (IOException e) {
            e.printStackTrace();
        }
//            System.out.println(testImg);
        int newHeight=testImg.getHeight();
        int newWidth=testImg.getWidth();





        for (int i = 0; i < newWidth; i++) {

            for (int j = 0; j < newHeight; j++) {

                Color newColor=new Color(testImg.getRGB(i,j));
                if (probSkin[newColor.getRed()][newColor.getGreen()][newColor.getBlue()]<1)
                {
                    testImg.setRGB(i,j,Color.white.getRGB());
                }

//                    else{
//                        testImg.setRGB(i,j,Color.black.getRGB());
//
//                    }




            }

        }

        try {
            ImageIO.write(testImg,"jpg",new File("Photos/output.jpg"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
