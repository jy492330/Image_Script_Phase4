package imageview;

import java.awt.event.ActionListener;
import java.awt.event.MouseListener;

/**
 * The interface for the interactive view class.
 */
public interface View {

  /**
   * Set the label that is showing what the model stores.
   *
   * @return the string type file name
   */
  String getFile();

  /**
   * Save the resulting image file with a string type file path.
   *
   * @return the string type file name
   */
  String saveFile();

  /**
   * Set the action listener for any actions.
   *
   * @param listener the listener to use
   */
  void setListener(ActionListener listener);

  /**
   * Set the mouse listener for any actions.
   *
   * @param listener the listener to use
   */
  void setListener(MouseListener listener);

  /**
   * Unset the mouse listener for any actions.
   *
   * @param listener the listener to use
   */
  void unsetListener(MouseListener listener);


  /**
   * Display this image view.
   *
   * @param pngFilePath the file path of the png file
   */
  void displayImage(String pngFilePath);

  /**
   * Display this window view.
   */
  void displayWindow();


  /**
   * Apply image manipulation effect to the image.
   *
   * @param effect this image effect to be applied
   */
  void addEffect(String effect);


  /**
   * Create an interactively user-defined script.
   */
  void createScript();


  /**
   * Display this cropped image in the JFrame.
   *
   * @param imageFilePath the file path of the cropped image
   */
  void displayCropFrame(String imageFilePath);

  /**
   * Hide this cropped image in the JFrame.
   */
  void hideCropFrame();

  /**
   * Display this Generate Image window where it prompts for user-specific inputs in the JFrame.
   */
  void displayGenerateImage();

  /**
   * Hide this Generate Image window in the JFrame.
   */
  void hideGenerateImage();


}
