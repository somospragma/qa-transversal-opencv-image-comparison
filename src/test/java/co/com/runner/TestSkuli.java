package co.com.runner;

import java.awt.image.BufferedImage;
import java.io.File;

import com.github.romankh3.image.comparison.ImageComparison;
import com.github.romankh3.image.comparison.ImageComparisonUtil;
import com.github.romankh3.image.comparison.model.ImageComparisonResult;
import com.github.romankh3.image.comparison.model.ImageComparisonState;

public class TestSkuli {
    /**
     * @param args
     */
    public static void main(String[] args) {
        BufferedImage expectedImage = ImageComparisonUtil.readImageFromResources("evidencia/1.jpg");
        BufferedImage actualImage = ImageComparisonUtil.readImageFromResources("evidencia\\screenshot.png");

        File resultDestination = new File("result.png");

        // ImageComparisonResult imageComparisonResult = new
        // ImageComparison(expectedImage, actualImage).compareImages();
        ImageComparisonResult imageComparisonResult = new ImageComparison(expectedImage, actualImage, resultDestination)
                .compareImages();
        System.out.println("============================");
        System.out.println(ImageComparisonState.MATCH);
        System.out.println("============================");
        System.out.println(imageComparisonResult.getImageComparisonState());
        System.out.println("============================");

        ImageComparisonUtil.saveImage(resultDestination, imageComparisonResult.getResult());
    }
}
