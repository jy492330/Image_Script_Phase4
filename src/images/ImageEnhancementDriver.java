package images;

import images.ConcreteImageModel;
import images.ImageModel;

/**
 * This is an optional driver to verify the three image enhancements (Edge Detection,
 * Image Crop, and Generating Images) created in the concrete image model.
 * The Generating Images enhancement consists of vertical rainbow image, horizontal rainbow
 * image, checkerboard pattern and national flag image of Switzerland.
 */
public class ImageEnhancementDriver {
  /**
   * The main program to run image enhancement features: Edge Detection, Image Cropping,
   * and Generating Images.
   *
   * @param args Not used
   */
  public static void main(String[] args) {

    ImageModel model = new ConcreteImageModel();

    /*
     * Implement "Edge Detection" enhancement and save the image in the current/home directory.
     */
    String fileName = "res/brisbane city.png";
    model.loadImage(fileName);
    model.edgeDetection();
    model.applyGrayscale();
    model.saveImage("Edge Detection.png");


    /*
     * Implement "Image Crop" enhancement and save the image in the current/home directory.
     */
    model.imageCrop(50, 200, 50, 500);
    model.saveImage("Crop.png");


    /*
     * Implement "Generating Images" enhancement and save the image in the current/home directory.
     */

    // Generate a vertical rainbow image
    model.generateVerticalRainbow(600, 400);
    model.saveImage("Vertical Rainbow.png");

    // Generate a horizontal rainbow image
    model.generateHorizontalRainbow(400, 600);
    model.saveImage("Horizontal Rainbow.png");

    // Generate a checkerboard image
    int[] red = {255, 0, 0};
    int[] white = {255, 255, 255};
    model.generateCheckerBoard(500, 10, red, white);
    model.saveImage("Checkerboard.png");

    // Generate a national flag
    model.generateFlag(1000);
    model.saveImage("Flag.png");

  }
}
