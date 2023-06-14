package co.com.runner;
import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;

import com.github.romankh3.image.comparison.ImageComparison;
import com.github.romankh3.image.comparison.ImageComparisonUtil;
import com.github.romankh3.image.comparison.model.ImageComparisonResult;
import com.github.romankh3.image.comparison.model.ImageComparisonState;

public class newad {

    public static void compareImage(String imageActual, String imageExpect){
        BufferedImage bufferedImage1 = ImageComparisonUtil.readImageFromResources(imageActual);
        BufferedImage bufferedImage2 = ImageComparisonUtil.readImageFromResources(imageExpect);

        File resultDestination = new File( "result.png" );

        //Create ImageComparison object for it.
        ImageComparison imageComparison = new ImageComparison( bufferedImage1, bufferedImage2, resultDestination );

        //Can be used another constructor for it, without destination.
       // new ImageComparison(imageActual, imageExpect);



        //Also can be configured BEFORE comparing next properties:

        //Threshold - it's the max distance between non-equal pixels. By default it's 5.
        imageComparison.setThreshold(0);
        imageComparison.getThreshold();

        //RectangleListWidth - Width of the line that is drawn in the rectangle. By default it's 1.
        imageComparison.setRectangleLineWidth(5);
        imageComparison.getRectangleLineWidth();

        //Destination. Before comparing also can be added destination file for result image.
        imageComparison.setDestination(resultDestination);
        imageComparison.getDestination();

        //MaximalRectangleCount - It means that would get first x biggest rectangles for drawing.
        // by default all the rectangles would be drawn.
        imageComparison.setMaximalRectangleCount(100);
        imageComparison.getMaximalRectangleCount();

        //imageComparison.setAllowingPercentOfDifferentPixels(0);
        imageComparison.setDifferenceRectangleColor(Color.RED);
        System.out.println(imageComparison.getAllowingPercentOfDifferentPixels());

        //MinimalRectangleSize - The number of the minimal rectangle size. Count as (width x height).
        // by default it's 1.
        imageComparison.setMinimalRectangleSize(100);
        imageComparison.getMinimalRectangleSize();

        //After configuring the ImageComparison object, can be executed compare() method:
        ImageComparisonResult comparisonResult = imageComparison.compareImages();

        //Can be found ComparisonState.
        ImageComparisonState comparisonState = comparisonResult.getImageComparisonState();

        //And Result Image
        BufferedImage resultImage = comparisonResult.getResult();

        System.out.println("============================");
        System.out.println(ImageComparisonState.MATCH);
        System.out.println("============================");
        System.out.println(comparisonState);
        System.out.println("============================");
        System.out.println((int) (comparisonResult.getDifferencePercent()*100));
        System.out.println("============================");


        //Image can be saved after comparison, using ImageComparisonUtil.
        ImageComparisonUtil.saveImage(resultDestination, resultImage);
    }

    public static void compareImageCompact(String pathActualImage, String pathExpectedImage) {
        BufferedImage expectedImage = ImageComparisonUtil.readImageFromResources(pathActualImage);
        BufferedImage actualImage = ImageComparisonUtil.readImageFromResources(pathExpectedImage);

        File resultDestination = new File("result.png");

        ImageComparisonResult imageComparisonResult = new ImageComparison(expectedImage, actualImage).compareImages();
        System.out.println("============================");
        System.out.println(ImageComparisonState.MATCH);
        System.out.println("============================");
        System.out.println(imageComparisonResult.getImageComparisonState());
        System.out.println("============================");
        

        ImageComparisonUtil.saveImage(resultDestination, imageComparisonResult.getResult());

    }
}
