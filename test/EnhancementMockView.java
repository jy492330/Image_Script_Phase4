import imageview.View;
import java.awt.event.ActionListener;
import java.awt.event.MouseListener;

/**
 * Implement of a mock view to test the Image Enhancements controller.
 */
public class EnhancementMockView implements View {
  private final StringBuilder log;

  /**
   * Constructor only created to pass in the StreamBuilder.
   *
   * @param log the model to use
   */
  public EnhancementMockView(StringBuilder log) {
    this.log = log;
  }


  @Override
  public String getFile() {
    return "abcde file name";
  }


  @Override
  public String saveFile() {
    return "XYZ file name";
  }

  @Override
  public void setListener(ActionListener listener) {
    log.append("View: set action listener");
    log.append((System.lineSeparator()));
  }

  @Override
  public void setListener(MouseListener listener) {
    log.append("View: set mouse listener");
    log.append((System.lineSeparator()));
  }

  @Override
  public void unsetListener(MouseListener listener) {
    log.append("View: unset mouse listener");
    log.append((System.lineSeparator()));
  }



  @Override
  public void displayImage(String pngFilePath) {
    log.append("View: display image ").append(pngFilePath);
    log.append((System.lineSeparator()));
  }


  @Override
  public void displayWindow() {
    log.append("View: display window");
    log.append((System.lineSeparator()));
  }


  @Override
  public void addEffect(String effect) {
    log.append("View: applying ").append(effect);
    log.append((System.lineSeparator()));
  }


  @Override
  public void createScript() {
    log.append("View: create the batch-script");
    log.append((System.lineSeparator()));
  }

  @Override
  public void displayCropFrame(String imageFilePath) {
    log.append("View: display crop frame");
    log.append((System.lineSeparator()));
  }


  @Override
  public void hideCropFrame() {
    log.append("View: hide crop frame");
    log.append((System.lineSeparator()));
  }

  @Override
  public void displayGenerateImage() {
    log.append("View: display generate image");
    log.append((System.lineSeparator()));
  }

  @Override
  public void hideGenerateImage() {
    log.append("View: hide generate image");
    log.append((System.lineSeparator()));
  }



}
