package imageview;

import images.ConcreteImageModel;
import images.ImageModel;

/**
 * This main program represents a full MVC architecture.
 *
 * <p>The model maintains a single string that is input by the user using the GUI
 * and echoed on the GUI.
 */
public class Main {
  
  /**
   * Starting point of the program.
   * 
   * @param args Not used
   */
  public static void main(String[] args) {
    // Create the model
    ImageModel model = new ConcreteImageModel();
    // Create the view
    View view = new FrameView("Homework 10 - Image Enhancement");
    // Create the controller with the model and the view
    new Controller(model, view);
  }
}
