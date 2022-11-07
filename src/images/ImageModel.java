package images;

/**
 * A ImageModel representation that manipulates color images.
 */
public interface ImageModel {

  /**
   * Load an image into the image model.
   * 
   * @param filename the name of the file containing the image.
   * @throws IllegalArgumentException if the filename is invalid or if something
   *                                  goes wrong loading the image
   */
  void loadImage(String filename) throws IllegalArgumentException;

  /**
   * Save the data in the image model to a file.
   * 
   * @param filename the name of the file to save to
   * @throws IllegalArgumentException if the filename is invalid or if something
   *                                  goes wrong saving the file
   */
  void saveImage(String filename) throws IllegalArgumentException;

  /**
   * Apply the blur filter to the data in the image model.
   */
  void applyBlur();

  /**
   * Apply the sharpen filter to the data in the image model.
   */
  void applySharpen();

  /**
   * Apply the grayscale color transformation to the data in the image model.
   */
  void applyGrayscale();

  /**
   * Apply the sepia color transformation to the data in the image model.
   */
  void applySepia();

  /**
   * Apply the dithering effect to the data in the image model.
   */
  void applyDither();

  /**
   * Apply the mosaic effect to the data in the image model.
   * 
   * @param seeds the number of seeds to use in the mosaic
   * @throws IllegalArgumentException if the number of seeds is not positive
   */
  void applyMosaic(int seeds) throws IllegalArgumentException;

  /**
   * This gets the resulting image file path of the temp.png file.
   *
   * @return the string path of the temp.png file
   */
  String getImage();

  /**
   * Apply image crop enhancement to an image in the image model.
   *
   * @param startRow the starting row value of an image to be cropped
   * @param stopRow the ending row value of an image to be cropped
   * @param startCol the starting column value of an image to be cropped
   * @param stopCol the ending column value of an image to be cropped
   */
  void imageCrop(int startRow, int stopRow, int startCol, int stopCol);

  /**
   * Apply edge detection enhancement to an image in the image model.
   */
  void edgeDetection();

  /**
   * Generate a vertically stripped rainbow image with standard ROYGBiV colors in the image model.
   *
   * @param height the height of the vertical rainbow image
   * @param width the width of the vertical rainbow image
   */
  void generateVerticalRainbow(int height, int width);

  /**
   * Generate a horizontally stripped rainbow image with standard ROYGBiV colors in the image model.
   *
   * @param height the height of the horizontal rainbow image
   * @param width the width of the horizontal rainbow image
   */
  void generateHorizontalRainbow(int height, int width);

  /**
   * Generate a checkerboard pattern with two alternating colors in the image model.
   *
   * @param height the height of the checkerboard
   * @param numSquares the number of squares per side of the checkerboard
   * @param color1 the first color input from the user
   * @param color2 the second color input from the user
   */
  void generateCheckerBoard(int height, int numSquares, int[] color1, int[] color2);

  /**
   * Generate a flag image of a country in the image model.
   *
   * @param length the length of the national flag image
   */
  void generateFlag(int length);

}
