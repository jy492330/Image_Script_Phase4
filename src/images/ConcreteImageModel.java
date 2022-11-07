package images;

import java.util.Random;

/**
 * This class represents an image model used for image manipulation & enhancement algorithms.
 * It offers all the operations mandated by the ImageModel interface.
 */
public class ConcreteImageModel implements ImageModel {
  private static final int MINIMUM = 0;
  private static final int MAXIMUM = 255;
  private static final double[][] BLUR_KERNEL = {
      {1.0 / 16, 1.0 / 8, 1.0 / 16},
      {1.0 / 8, 1.0 / 4, 1.0 / 8},
      {1.0 / 16, 1.0 / 8, 1.0 / 16}
  };
  private static final double[][] SHARPEN_KERNEL = {
      {-1.0 / 8, -1.0 / 8, -1.0 / 8, -1.0 / 8, -1.0 / 8},
      {-1.0 / 8, 1.0 / 4, 1.0 / 4, 1.0 / 4, -1.0 / 8},
      {-1.0 / 8, 1.0 / 4, 1.0, 1.0 / 4, -1.0 / 8},
      {-1.0 / 8, 1.0 / 4, 1.0 / 4, 1.0 / 4, -1.0 / 8},
      {-1.0 / 8, -1.0 / 8, -1.0 / 8, -1.0 / 8, -1.0 / 8}
  };
  private static final double[][] GRAYSCALE_FILTER = {
      {0.2126, 0.7152, 0.0722},
      {0.2126, 0.7152, 0.0722},
      {0.2126, 0.7152, 0.0722}
  };
  private static final double[][] SEPIA_FILTER = {
      {0.393, 0.769, 0.189},
      {0.349, 0.686, 0.168},
      {0.272, 0.534, 0.131}
  };
  private int[][][] imageData;


  @Override
  public void loadImage(String filename) throws IllegalArgumentException {
    imageData = ImageUtilities.readImage(filename); //("res/" + filename)
  }

  @Override
  public void saveImage(String filename) throws IllegalArgumentException {
    ImageUtilities.writeImage(imageData, filename);
  }

  @Override
  public void applyBlur() {
    applyFilter(imageData, BLUR_KERNEL);
  }

  @Override
  public void applySharpen() {
    applyFilter(imageData, SHARPEN_KERNEL);
  }

  // Helper method for Blur and Sharpen
  // apply filter to the whole image
  private void applyFilter(int[][][] image, double[][] kernel) {
    int[][][] originalData = image;
    imageData = new int[imageData.length][imageData[0].length][imageData[0][0].length];
    for (int r = 0; r < imageData.length; r++) {
      for (int c = 0; c < imageData[r].length; c++) {
        for (int d = 0; d < imageData[r][c].length; d++) {
          // initializing one cell of the 3d array / one individual element of the 3d array
          // processing all the colors for all pixels of the image
          imageData[r][c][d] = applyFilter(originalData, r, c, d, kernel);
        }
      }
    }
  }

  // Helper method for Blur and Sharpen
  // apply filter to a particular pixel
  private int applyFilter(int[][][] image, int imageR, int imageC, int imageD, double[][] kernel) {
    // identify center of the kernel at position [1][1]
    int centerRow = kernel.length / 2;
    int centerCol = kernel[0].length / 2;
    double newPixColor = 0;  // accumulator (resultant value of the new pixel with kernel overlay)
    //Loop over every pixel in the kernel
    for (int r = 0; r < kernel.length; r++) {
      for (int c = 0; c < kernel[r].length; c++) {
        // (calculate the corresponding index value of the pixel location of the image overlaid
        // by the kernel).
        // neighborRow is the corresponding row value of the pixel in relation to the kernel
        int neighborRow = imageR + (r - centerRow); // imageR is the row index position of the
        // color value of the pixel + (0 - 1), = negative value out of bounds.
        // neighborCol is the corresponding column value of the pixel in relation to the kernel
        int neighborCol = imageC + (c - centerCol); // imageC is the column index position of the
        // color value of the pixel + (0 - 1), this gives a negative value out of bounds
        // to check if the neighborRow and neighborCol are in bounds of the image (below)
        if (neighborRow < image.length && neighborRow > -1 && neighborCol < image[0].length
            && neighborCol > -1) {
          // Calculate the new color value of a pixel based on the kernel filter
          newPixColor += kernel[r][c] * image[neighborRow][neighborCol][imageD];
        }
      }
    }
    return clamp((int) Math.round(newPixColor));
  }

  // Helper method for Blur and Sharpen
  private int clamp(int value) {
    if (value < MINIMUM) {
      value = MINIMUM;
    }
    if (value > MAXIMUM) {
      value = MAXIMUM;
    }
    return value;
  }

  @Override
  public void applyGrayscale() {
    applyLinearFilter(GRAYSCALE_FILTER);
  }

  // Helper method for Grayscale and Sepia
  private void applyLinearFilter(double[][] filter) {
    for (int r = 0; r < imageData.length; r++) {
      for (int c = 0; c < imageData[r].length; c++) {
        int red = clamp((int) Math.round(filter[0][0] * imageData[r][c][0]
            + filter[0][1] * imageData[r][c][1] + filter[0][2] * imageData[r][c][2]));
        int green = clamp((int) Math.round(filter[1][0] * imageData[r][c][0]
            + filter[1][1] * imageData[r][c][1] + filter[1][2] * imageData[r][c][2]));
        int blue = clamp((int) Math.round(filter[2][0] * imageData[r][c][0]
            + filter[2][1] * imageData[r][c][1] + filter[2][2] * imageData[r][c][2]));
        imageData[r][c][0] = red;
        imageData[r][c][1] = green;
        imageData[r][c][2] = blue;
      }
    }
  }

  @Override
  public void applySepia() {
    applyLinearFilter(SEPIA_FILTER);
  }

  @Override
  public void applyDither() {
    applyLinearFilter(GRAYSCALE_FILTER);
    for (int r = 0; r < imageData.length; r++) {
      for (int c = 0; c < imageData[r].length; c++) {
        for (int d = 0; d < imageData[r][c].length; d++) {
          int oldColor = imageData[r][c][0];
          int newColor;
          if (255 - oldColor < oldColor) {
            newColor = 255;
          } else {
            newColor = 0;
          }
          int error = oldColor - newColor;
          imageData[r][c][d] = newColor;
          applyError(7 / 16.0 * error, r, c + 1, d);
          applyError(3 / 16.0 * error, r + 1, c - 1, d);
          applyError(5 / 16.0 * error, r + 1, c, d);
          applyError(1 / 16.0 * error, r + 1, c + 1, d);
        }
      }
    }
  }

  // Helper method for Dither
  private void applyError(double weight, int r, int c, int d) {
    if (r < imageData.length && r > -1 && c < imageData[0].length
        && c > -1) {
      imageData[r][c][d] = clamp(imageData[r][c][d] + (int) Math.round(weight));
    }
  }

  /**
   * This inner class represents a cluster of pixels affected by the random seed.
   */
  static class Cluster {
    public int col;
    public int[] depth;
    public int numPixels;
    public int row;

    /**
     * Constructor of a cluster of pixels affected by the random seed with
     * row, column and depth locations.
     *
     * @param row the row location of the seed
     * @param col the col location of the seed
     * @param d   the depth value - color of the seed
     */
    public Cluster(int row, int col, int[] d) { // d is the color of the seed
      this.row = row; // row location of the seed
      this.col = col; // col location of the seed
      this.numPixels = 1; // count the seed as one pixel
      this.depth = new int[d.length];
      for (int i = 0; i < this.depth.length; i++) {
        this.depth[i] = d[i];
      }
    }

    /**
     * Add color (depth value) of a pixel incrementally.
     *
     * @param d the depth value - color of the pixel
     */
    public void addCell(int[] d) {
      for (int i = 0; i < this.depth.length; i++) {
        this.depth[i] += d[i];
      }
      this.numPixels++;
    }

    /**
     * Get color of the pixels.
     *
     * @param i the position value 0, 1 or 2 of the color for the pixel
     */
    public int getColor(int i) {
      return depth[i] / numPixels;
    }
  }

  @Override
  public void applyMosaic(int seeds) throws IllegalArgumentException {

    Random random = new Random();
    int[][] mosaicImage = new int[imageData.length][imageData[0].length];
    Cluster[] allSeeds = new Cluster[seeds];
    for (int r = 0; r < imageData.length; r++) {
      for (int c = 0; c < imageData[r].length; c++) {
        mosaicImage[r][c] = -1;
      }
    }
    for (int i = 0; i < seeds; ) {
      int r = random.nextInt(imageData.length);
      int c = random.nextInt(imageData[0].length);
      if (mosaicImage[r][c] == -1) {
        mosaicImage[r][c] = i;
        allSeeds[i] = new Cluster(r, c, imageData[r][c]);
        i++;
      }
    }

    for (int r = 0; r < imageData.length; r++) {
      for (int c = 0; c < imageData[r].length; c++) {
        if (mosaicImage[r][c] == -1) {
          int minSeed = -1;
          float minDistance = Float.MAX_VALUE;
          for (int i = 0; i < seeds; i++) {
            float deltaX = (c - allSeeds[i].col);
            float deltaY = (r - allSeeds[i].row);
            float dist = deltaX * deltaX + deltaY * deltaY;
            if (dist < minDistance) {
              minSeed = i;
              minDistance = dist;
            }
          }

          mosaicImage[r][c] = minSeed;
          allSeeds[minSeed].addCell(imageData[r][c]);
        }
      }
    }
    for (int r = 0; r < imageData.length; r++) {
      for (int c = 0; c < imageData[r].length; c++) {
        int seed = mosaicImage[r][c];
        for (int d = 0; d < imageData[r][c].length; d++) {
          int color = allSeeds[seed].getColor(d);
          imageData[r][c][d] = color;
          imageData[r][c][d] = clamp(imageData[r][c][d]);
        }
      }
    }
  }

  @Override
  public String getImage() {
    String path = "temp.png";
    saveImage(path);
    return path;
  }

  @Override
  public void imageCrop(int startRow, int stopRow, int startCol, int stopCol) {
    if (startRow > stopRow) {
      int temp = startRow;
      startRow = stopRow;
      stopRow = temp;
    }
    if (startCol > stopCol) {
      int temp = startCol;
      startCol = stopCol;
      stopCol = temp;
    }
    if (startRow < 0) {
      startRow = 0;
    }
    if (startCol < 0) {
      startCol = 0;
    }
    if (stopRow > imageData.length) {
      stopRow = imageData.length;
    }
    if (stopCol > imageData[0].length) {
      stopCol = imageData[0].length;
    }
    if (startRow > imageData.length) {
      return;
    }
    if (startCol > imageData[0].length) {
      return;
    }
    int[][][] cropImage = new int[stopRow - startRow][stopCol - startCol][imageData[0][0].length];
    for (int r = 0; r < stopRow - startRow; r++) {
      for (int c = 0; c < stopCol - startCol; c++) {
        for (int d = 0; d < imageData[0][0].length; d++) {
          cropImage[r][c][d] = imageData[r + startRow][c + startCol][d];

        }
      }
    }
    imageData = cropImage;
  }

  @Override
  public void edgeDetection() {
    int[][][] edgeImage = new int[imageData.length][imageData[0].length][imageData[0][0].length];
    int[] minVal = new int[imageData[0][0].length];
    int[] maxVal = new int[imageData[0][0].length];
    for (int d = 0; d < imageData[0][0].length; d++) {
      minVal[d] = Integer.MAX_VALUE;
      maxVal[d] = Integer.MIN_VALUE;
    }

    for (int r = 1; r < imageData.length - 1; r++) {
      for (int c = 1; c < imageData[r].length - 1; c++) {
        for (int d = 0; d < imageData[r][c].length; d++) {

          int val00 = imageData[r - 1][c - 1][d];
          int val01 = imageData[r - 1][c][d];
          int val02 = imageData[r - 1][c + 1][d];

          int val10 = imageData[r][c - 1][d];
          int val11 = imageData[r][c][d];
          int val12 = imageData[r][c + 1][d];

          int val20 = imageData[r + 1][c - 1][d];
          int val21 = imageData[r + 1][c][d];
          int val22 = imageData[r + 1][c + 1][d];

          int gx = (((-1 * val00) + (0 * val01) + (1 * val02)) + ((-2 * val10) + (0 * val11)
              + (2 * val12)) + ((-1 * val20) + (0 * val21) + (1 * val22)));
          int gy = (((-1 * val00) + (-2 * val01) + (-1 * val02)) + ((0 * val10) + (0 * val11)
              + (0 * val12)) + ((1 * val20) + (2 * val21) + (1 * val22)));

          double gval = Math.sqrt((gx * gx) + (gy * gy));
          int v = (int) gval;
          if (v < minVal[d]) {
            minVal[d] = v;
          }
          if (v > maxVal[d]) {
            maxVal[d] = v;
          }
          edgeImage[r][c][d] = v;
        }
      }
    }
    for (int r = 1; r < imageData.length - 1; r++) {
      for (int c = 1; c < imageData[r].length - 1; c++) {
        for (int d = 0; d < imageData[r][c].length; d++) {
          imageData[r][c][d] = (edgeImage[r][c][d] - minVal[d]) * 255 / (maxVal[d] - minVal[d]);

        }
      }
    }
  }

  @Override
  public void generateVerticalRainbow(int height, int width) {
    imageData = new int[height][width][3];
    int minWidth = width / 6;
    int extras = width % 6;
    int currentMax = minWidth;
    if (extras > 0) {
      currentMax++;
      extras--;
    }
    int currentColor = 0;
    int[][] color = {{255, 0, 0},  // red
        {255, 165, 0}, // orange
        {255, 255, 0}, // yellow
        {0, 128, 0},  // green
        {0, 0, 255},  // blue
        {155, 38, 182}}; // purple

    for (int c = 0; c < imageData[0].length; c++) {
      if (c == currentMax) {
        currentMax += minWidth;
        if (extras > 0) {
          currentMax++;
          extras--;
        }
        ++currentColor;
      }
      for (int r = 0; r < imageData.length; r++) {
        for (int d = 0; d < imageData[r][c].length; d++) {
          imageData[r][c][d] = color[currentColor][d];
        }
      }

    }
  }

  @Override
  public void generateHorizontalRainbow(int height, int width) {
    imageData = new int[height][height][3];
    int minHeight = height / 6;
    int extras = height % 6;
    int currentMax = minHeight;
    if (extras > 0) {
      currentMax++;
      extras--;
    }
    int currentColor = 0;

    int[][] color = {{255, 0, 0},  // red
        {255, 165, 0}, // orange
        {255, 255, 0}, // yellow
        {0, 128, 0},  // green
        {0, 0, 255},  // blue
        {155, 38, 182}}; // purple
    for (int r = 0; r < imageData.length; r++) {
      if (r == currentMax) {
        currentMax += minHeight;
        if (extras > 0) {
          currentMax++;
          extras--;
        }
        ++currentColor;
      }
      for (int c = 0; c < imageData[r].length; c++) {
        for (int d = 0; d < imageData[r][c].length; d++) {
          imageData[r][c][d] = color[currentColor][d];
        }
      }
    }
  }

  @Override
  public void generateCheckerBoard(int height, int numSquares, int[] color1, int[] color2) {
    imageData = new int[height][height][3];
    int minSize = height / numSquares;
    int extraRow = height % numSquares;

    int currentMaxRow = minSize;
    if (extraRow > 0) {
      currentMaxRow++;
      extraRow--;
    }

    boolean color1Even = true;
    for (int r = 0; r < imageData.length; r++) {
      if (r == currentMaxRow) {
        currentMaxRow += minSize;
        if (extraRow > 0) {
          currentMaxRow++;  //
          extraRow--;
        }
        color1Even = !color1Even;
      }

      int extraCol = height % numSquares;
      int currentMaxCol = minSize;
      if (extraCol > 0) {
        currentMaxCol++;
        extraCol--;
      }
      int currentSquare = 0;

      for (int c = 0; c < imageData[r].length; c++) {
        if (c == currentMaxCol) {
          currentMaxCol += minSize;
          if (extraCol > 0) {
            currentMaxCol++;
            extraCol--;
          }
          ++currentSquare;
        }
        for (int d = 0; d < imageData[r][c].length; d++) {
          int[] myColor = color2;

          if (color1Even && (currentSquare % 2) == 0) {
            myColor = color1;
          } else if (!color1Even && (currentSquare % 2) == 1) {
            myColor = color1;
          }
          imageData[r][c][d] = myColor[d];
        }
      }
    }
  }

  @Override
  public void generateFlag(int length) {
    length = length / 32 * 32;
    int multiple = length / 32;
    int[] sections = {6, 7, 6, 7, 6};
    int[][] sectionColors = {{0, 0, 0, 0, 0},  // section colors in row1
        {0, 0, 1, 0, 0},  // section colors in row2
        {0, 1, 1, 1, 0},  // section colors in row3
        {0, 0, 1, 0, 0},  // section colors in row4
        {0, 0, 0, 0, 0}}; // section colors in row5
    imageData = new int[length][length][3]; //
    int[][] flagColors = {{255, 0, 0}, {255, 255, 255}};
    for (int r = 0; r < imageData.length; r++) {
      int limit = 0;
      int rowIndex;
      for (rowIndex = 0; rowIndex < sections.length; rowIndex++) {
        limit += sections[rowIndex] * multiple;
        if (r < limit) {
          break;
        }
      }
      for (int c = 0; c < imageData[r].length; c++) {
        limit = 0;
        int colIndex;
        for (colIndex = 0; colIndex < sections.length; colIndex++) {
          limit += sections[colIndex] * multiple;
          if (c < limit) {
            break;
          }
        }
        int flagPixelColor = sectionColors[rowIndex][colIndex];
        for (int d = 0; d < imageData[r][c].length; d++) {
          imageData[r][c][d] = flagColors[flagPixelColor][d];
        }
      }
    }
  }

}