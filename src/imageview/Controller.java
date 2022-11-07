package imageview;

import images.ConcreteImageModel;
import images.ImageModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;


/**
 * Implementation of the controller for the model image.
 */
public class Controller implements ActionListener, MouseListener {
  private ImageModel model;
  private View view;
  private int cropStartRow;
  private int cropStopRow;
  private int cropStartCol;
  private int cropStopCol;
  private final String cropPath = "crop_temp.png";
  private ImageModel croppedModel;


  /**
   * Constructor.
   *
   * @param m the model to use
   * @param v the view to use
   */
  public Controller(ImageModel m, View v) {
    model = m;
    croppedModel = null;
    view = v;
    view.setListener((ActionListener) this);
    view.displayWindow();
  }

  /**
   * Constructor for mock tests only.
   *
   * @param m the model to use
   * @param cm the crop model to use
   * @param v the view to use
   */
  public Controller(ImageModel m, ImageModel cm, View v) {
    model = m;
    croppedModel = cm;
    view = v;
    view.setListener((ActionListener) this);
    view.displayWindow();
  }

  @Override
  public void actionPerformed(ActionEvent e) {
    String path;

    switch (e.getActionCommand()) {
      case "Load Image File":
        path = view.getFile();
        if (path != null) {
          System.out.println("File: " + path);
          model.loadImage(path);
          view.displayImage(path);
        }
        break;

      case "Save Image File":
        path = view.saveFile();
        if (path != null) {
          model.saveImage(path);
        }
        break;

      case "Create Script":
        view.createScript();
        break;

      case "Run Script":
        break;

      case "Blur Effect":
        view.addEffect("blur");
        model.applyBlur();
        view.displayImage(model.getImage());
        break;

      case "Sharpen Effect":
        view.addEffect("sharpen");
        model.applySharpen();
        view.displayImage(model.getImage());
        break;

      case "Grayscale Effect":
        view.addEffect("grayscale");
        model.applyGrayscale();
        view.displayImage(model.getImage());
        break;

      case "Sepia Effect":
        view.addEffect("sepia");
        model.applySepia();
        view.displayImage(model.getImage());
        break;

      case "Dither Effect":
        view.addEffect("dither");
        model.applyDither();
        view.displayImage(model.getImage());
        break;

      case "Seeds: 1000":
        view.addEffect("mosaic 1000");
        model.applyMosaic(1000);
        view.displayImage(model.getImage());
        break;

      case "Seeds: 4000":
        view.addEffect("mosaic 4000");
        model.applyMosaic(4000);
        view.displayImage(model.getImage());
        break;

      case "Seeds: 8000":
        view.addEffect("mosaic 8000");
        model.applyMosaic(8000);
        view.displayImage(model.getImage());
        break;

      case "Seeds: 15000":
        view.addEffect("mosaic 15000");
        model.applyMosaic(15000);
        view.displayImage(model.getImage());
        break;

      case "Crop Image":
        // System.out.println("Crop Image");
        view.setListener((MouseListener) this);
        break;

      case "Crop Cancel":
        view.hideCropFrame();
        break;

      case "Crop Confirm":
        croppedModel.saveImage(cropPath);
        model.loadImage(cropPath); // reloaded the cropped image to the model
        view.hideCropFrame(); // crop frame disappears before displaying the cropped image
        view.displayImage(model.getImage());
        break;

      case "Edge Detection":
        model.edgeDetection();
        model.applyGrayscale();
        view.displayImage(model.getImage());
        break;

      case "Generating Image":
        view.displayGenerateImage();
        break;

      case "Vertical Rainbow":
        model.generateVerticalRainbow(500, 500);
        view.displayImage(model.getImage());
        break;

      case "Horizontal Rainbow":
        model.generateHorizontalRainbow(500, 500);
        view.displayImage(model.getImage());
        break;

      case "Checkerboard":
        int [] color1 = {255, 0, 0};
        int [] color2 = {255, 255, 255};
        model.generateCheckerBoard(500, 10, color1, color2);
        view.displayImage(model.getImage());
        break;

      case "National Flag":
        model.generateFlag(500);
        view.displayImage(model.getImage());
        break;

      default:
        throw new IllegalStateException("Error: unknown input");
    }
  }


  @Override
  public void mouseClicked(MouseEvent e) {
  }


  @Override
  public void mousePressed(MouseEvent e) {
    cropStartCol = e.getX(); // get the x val of the pixel where the mouse was pressed
    cropStartRow = e.getY(); // get the y val of the pixel where the mouse was pressed

  }

  @Override
  public void mouseReleased(MouseEvent e) {
    cropStopCol = e.getX();
    cropStopRow = e.getY();
    System.out.println(cropPath + " " + cropStartRow + " " + cropStartCol + " "
        + cropStopRow + " " + cropStopCol);
    model.saveImage(cropPath);
    croppedModel = new ConcreteImageModel();
    croppedModel.loadImage(cropPath);
    croppedModel.imageCrop(cropStartRow, cropStopRow, cropStartCol, cropStopCol);
    view.displayCropFrame(croppedModel.getImage());
    view.unsetListener(this); // prevents mouse events from being used by the controller
  }

  @Override
  public void mouseEntered(MouseEvent e) {
  }

  @Override
  public void mouseExited(MouseEvent e) {
  }

  /**
   * Get the file path of the cropped image.
   *
   * @return the string path of the image file
   */
  public String getCropPath() {
    return cropPath;
  }

}
