import images.ImageModel;
import java.util.Arrays;

/**
 * Implement of a mock model to test the Image Enhancements controller.
 */
public class EnhancementMockModel implements ImageModel {
  private final StringBuilder log;


  /**
   * Constructor for the mock model.
   *
   * @param log the model to use
   */
  public EnhancementMockModel(StringBuilder log) {
    this.log = log;
  }


  @Override
  public void loadImage(String filename) throws IllegalArgumentException {
    log.append("Model: load an image ").append(filename);
    log.append((System.lineSeparator()));
  }


  @Override
  public void saveImage(String filename) throws IllegalArgumentException {
    log.append("Model: save an image ").append(filename);
    log.append((System.lineSeparator()));
  }


  @Override
  public void applyBlur() {
    log.append("Model: apply blur effect");
    log.append((System.lineSeparator()));
  }


  @Override
  public void applySharpen() {
    log.append("Model: apply sharpen effect");
    log.append((System.lineSeparator()));
  }


  @Override
  public void applyGrayscale() {
    log.append("Model: apply grayscale effect");
    log.append((System.lineSeparator()));
  }


  @Override
  public void applySepia() {
    log.append("Model: apply sepia effect");
    log.append((System.lineSeparator()));
  }


  @Override
  public void applyDither() {
    log.append("Model: apply dither effect");
    log.append((System.lineSeparator()));
  }


  @Override
  public void applyMosaic(int seeds) throws IllegalArgumentException {
    log.append("Model: apply mosaic effect ").append(seeds);
    log.append((System.lineSeparator()));
  }


  @Override
  public String getImage() {
    return "dummy image path";
  }


  @Override
  public void imageCrop(int startRow, int stopRow, int startCol, int stopCol) {
    log.append("Model: Image Crop Enhancement ").append(startRow).append(" ").append(stopRow)
        .append(" ").append(startCol).append(" ").append(stopCol);
    log.append((System.lineSeparator()));
  }


  @Override
  public void edgeDetection() {
    log.append("Model: Edge Detection Enhancement");
    log.append((System.lineSeparator()));
  }


  @Override
  public void generateVerticalRainbow(int height, int width) {
    log.append("Model: Vertical Rainbow Enhancement ").append(height).append(" ").append(width);
    log.append((System.lineSeparator()));
  }


  @Override
  public void generateHorizontalRainbow(int height, int width) {
    log.append("Model: Horizontal Rainbow Enhancement ").append(height).append(" ").append(width);
    log.append((System.lineSeparator()));
  }


  @Override
  public void generateCheckerBoard(int height, int numSquares, int[] color1, int[] color2) {
    log.append("Model: Checkerboard Enhancement ").append(height).append(" ").append(numSquares)
        .append(" ").append(Arrays.toString(color1)).append(" ").append(Arrays.toString(color2));
    log.append((System.lineSeparator()));
  }


  @Override
  public void generateFlag(int length) {
    log.append("Model: National Flag Enhancement ").append(length);
    log.append((System.lineSeparator()));
  }
}
