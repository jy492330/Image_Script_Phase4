import static org.junit.Assert.assertEquals;

import images.ImageModel;
import imageview.Controller;
import imageview.View;
import java.awt.event.ActionEvent;
import org.junit.Test;


/**
 * Test cases for the Image Enhancements controller, using model and view mocks to independently
 * test the GUI controller.
 */
public class EnhancementControllerTest {

  @Test
  public void testLoadImage() {
    StringBuilder modelLog = new StringBuilder();
    ImageModel model = new EnhancementMockModel(modelLog);
    StringBuilder viewLog = new StringBuilder();
    View view = new EnhancementMockView(viewLog);
    Controller enhancementController = new Controller(model, view);
    enhancementController.actionPerformed(new ActionEvent(new Object(), 12345, "Load Image File"));

    String expectedModel = "Model: load an image abcde file name" + System.lineSeparator();
    assertEquals(expectedModel, modelLog.toString());

    String expectedView = "View: set action listener" + System.lineSeparator()
        + "View: display window" + System.lineSeparator()
        + "View: display image abcde file name" + System.lineSeparator();
    assertEquals(expectedView, viewLog.toString());
  }

  @Test
  public void testSaveImage() {
    StringBuilder modelLog = new StringBuilder();
    ImageModel model = new EnhancementMockModel(modelLog);
    StringBuilder viewLog = new StringBuilder();
    View view = new EnhancementMockView(viewLog);
    Controller enhancementController = new Controller(model, view);
    enhancementController.actionPerformed(new ActionEvent(new Object(), 12345, "Save Image File"));

    String expectedModel = "Model: save an image XYZ file name" + System.lineSeparator();
    assertEquals(expectedModel, modelLog.toString());
  }

  @Test
  public void testCreateScript() {
    StringBuilder modelLog = new StringBuilder();
    ImageModel model = new EnhancementMockModel(modelLog);
    StringBuilder viewLog = new StringBuilder();
    View view = new EnhancementMockView(viewLog);
    Controller enhancementController = new Controller(model, view);
    enhancementController.actionPerformed(new ActionEvent(new Object(), 12345, "Create Script"));

    String expectedView = "View: set action listener" + System.lineSeparator()
        + "View: display window" + System.lineSeparator()
        + "View: create the batch-script" + System.lineSeparator();
    assertEquals(expectedView, viewLog.toString());
  }

  @Test
  public void testBlur() {
    StringBuilder modelLog = new StringBuilder();
    ImageModel model = new EnhancementMockModel(modelLog);
    StringBuilder viewLog = new StringBuilder();
    View view = new EnhancementMockView(viewLog);
    Controller enhancementController = new Controller(model, view);
    enhancementController.actionPerformed(new ActionEvent(new Object(), 12345, "Blur Effect"));

    String expectedModel = "Model: apply blur effect" + System.lineSeparator();
    assertEquals(expectedModel, modelLog.toString());

    String expectedView = "View: set action listener" + System.lineSeparator()
        + "View: display window" + System.lineSeparator()
        + "View: applying blur" + System.lineSeparator()
        + "View: display image dummy image path" + System.lineSeparator();
    assertEquals(expectedView, viewLog.toString());
  }

  @Test
  public void testSharpen() {
    StringBuilder modelLog = new StringBuilder();
    ImageModel model = new EnhancementMockModel(modelLog);
    StringBuilder viewLog = new StringBuilder();
    View view = new EnhancementMockView(viewLog);
    Controller enhancementController = new Controller(model, view);
    enhancementController.actionPerformed(new ActionEvent(new Object(), 12345, "Sharpen Effect"));

    String expectedModel = "Model: apply sharpen effect" + System.lineSeparator();
    assertEquals(expectedModel, modelLog.toString());

    String expectedView = "View: set action listener" + System.lineSeparator()
        + "View: display window" + System.lineSeparator()
        + "View: applying sharpen" + System.lineSeparator()
        + "View: display image dummy image path" + System.lineSeparator();
    assertEquals(expectedView, viewLog.toString());
  }

  @Test
  public void testGrayscale() {
    StringBuilder modelLog = new StringBuilder();
    ImageModel model = new EnhancementMockModel(modelLog);
    StringBuilder viewLog = new StringBuilder();
    View view = new EnhancementMockView(viewLog);
    Controller enhancementController = new Controller(model, view);
    enhancementController.actionPerformed(new ActionEvent(new Object(), 12345, "Grayscale Effect"));

    String expectedModel = "Model: apply grayscale effect" + System.lineSeparator();
    assertEquals(expectedModel, modelLog.toString());

    String expectedView = "View: set action listener" + System.lineSeparator()
        + "View: display window" + System.lineSeparator()
        + "View: applying grayscale" + System.lineSeparator()
        + "View: display image dummy image path" + System.lineSeparator();
    assertEquals(expectedView, viewLog.toString());
  }

  @Test
  public void testSepia() {
    StringBuilder modelLog = new StringBuilder();
    ImageModel model = new EnhancementMockModel(modelLog);
    StringBuilder viewLog = new StringBuilder();
    View view = new EnhancementMockView(viewLog);
    Controller enhancementController = new Controller(model, view);
    enhancementController.actionPerformed(new ActionEvent(new Object(), 12345, "Sepia Effect"));

    String expectedModel = "Model: apply sepia effect" + System.lineSeparator();
    assertEquals(expectedModel, modelLog.toString());

    String expectedView = "View: set action listener" + System.lineSeparator()
        + "View: display window" + System.lineSeparator()
        + "View: applying sepia" + System.lineSeparator()
        + "View: display image dummy image path" + System.lineSeparator();
    assertEquals(expectedView, viewLog.toString());
  }

  @Test
  public void testDither() {
    StringBuilder modelLog = new StringBuilder();
    ImageModel model = new EnhancementMockModel(modelLog);
    StringBuilder viewLog = new StringBuilder();
    View view = new EnhancementMockView(viewLog);
    Controller enhancementController = new Controller(model, view);
    enhancementController.actionPerformed(new ActionEvent(new Object(), 12345, "Dither Effect"));

    String expectedModel = "Model: apply dither effect" + System.lineSeparator();
    assertEquals(expectedModel, modelLog.toString());

    String expectedView = "View: set action listener" + System.lineSeparator()
        + "View: display window" + System.lineSeparator()
        + "View: applying dither" + System.lineSeparator()
        + "View: display image dummy image path" + System.lineSeparator();
    assertEquals(expectedView, viewLog.toString());
  }

  @Test
  public void testMosaic1000() {
    StringBuilder modelLog = new StringBuilder();
    ImageModel model = new EnhancementMockModel(modelLog);
    StringBuilder viewLog = new StringBuilder();
    View view = new EnhancementMockView(viewLog);
    Controller enhancementController = new Controller(model, view);
    enhancementController.actionPerformed(new ActionEvent(new Object(), 12345, "Seeds: 1000"));

    String expectedModel = "Model: apply mosaic effect 1000" + System.lineSeparator();
    assertEquals(expectedModel, modelLog.toString());

    String expectedView = "View: set action listener" + System.lineSeparator()
        + "View: display window" + System.lineSeparator()
        + "View: applying mosaic 1000" + System.lineSeparator()
        + "View: display image dummy image path" + System.lineSeparator();
    assertEquals(expectedView, viewLog.toString());
  }

  @Test
  public void testMosaic4000() {
    StringBuilder modelLog = new StringBuilder();
    ImageModel model = new EnhancementMockModel(modelLog);
    StringBuilder viewLog = new StringBuilder();
    View view = new EnhancementMockView(viewLog);
    Controller enhancementController = new Controller(model, view);
    enhancementController.actionPerformed(new ActionEvent(new Object(), 12345, "Seeds: 4000"));

    String expectedModel = "Model: apply mosaic effect 4000" + System.lineSeparator();
    assertEquals(expectedModel, modelLog.toString());

    String expectedView = "View: set action listener" + System.lineSeparator()
        + "View: display window" + System.lineSeparator()
        + "View: applying mosaic 4000" + System.lineSeparator()
        + "View: display image dummy image path" + System.lineSeparator();
    assertEquals(expectedView, viewLog.toString());
  }

  @Test
  public void testMosaic8000() {
    StringBuilder modelLog = new StringBuilder();
    ImageModel model = new EnhancementMockModel(modelLog);
    StringBuilder viewLog = new StringBuilder();
    View view = new EnhancementMockView(viewLog);
    Controller enhancementController = new Controller(model, view);
    enhancementController.actionPerformed(new ActionEvent(new Object(), 12345, "Seeds: 8000"));

    String expectedModel = "Model: apply mosaic effect 8000" + System.lineSeparator();
    assertEquals(expectedModel, modelLog.toString());

    String expectedView = "View: set action listener" + System.lineSeparator()
        + "View: display window" + System.lineSeparator()
        + "View: applying mosaic 8000" + System.lineSeparator()
        + "View: display image dummy image path" + System.lineSeparator();
    assertEquals(expectedView, viewLog.toString());
  }

  @Test
  public void testMosaic15000() {
    StringBuilder modelLog = new StringBuilder();
    ImageModel model = new EnhancementMockModel(modelLog);
    StringBuilder viewLog = new StringBuilder();
    View view = new EnhancementMockView(viewLog);
    Controller enhancementController = new Controller(model, view);
    enhancementController.actionPerformed(new ActionEvent(new Object(), 12345, "Seeds: 15000"));

    String expectedModel = "Model: apply mosaic effect 15000" + System.lineSeparator();
    assertEquals(expectedModel, modelLog.toString());

    String expectedView = "View: set action listener" + System.lineSeparator()
        + "View: display window" + System.lineSeparator()
        + "View: applying mosaic 15000" + System.lineSeparator()
        + "View: display image dummy image path" + System.lineSeparator();
    assertEquals(expectedView, viewLog.toString());
  }

  @Test
  public void testCropImage() {
    StringBuilder modelLog = new StringBuilder();
    ImageModel model = new EnhancementMockModel(modelLog);
    StringBuilder viewLog = new StringBuilder();
    View view = new EnhancementMockView(viewLog);
    Controller enhancementController = new Controller(model, view);
    enhancementController.actionPerformed(new ActionEvent(new Object(), 12345, "Crop Image"));

    String expectedView = "View: set action listener" + System.lineSeparator()
        + "View: display window" + System.lineSeparator()
        + "View: set mouse listener" + System.lineSeparator();
    assertEquals(expectedView, viewLog.toString());
  }

  @Test
  public void testCropConfirm() {
    StringBuilder modelLog = new StringBuilder();
    ImageModel model = new EnhancementMockModel(modelLog);
    StringBuilder cropModelLog = new StringBuilder();
    ImageModel cropModel = new EnhancementMockModel(cropModelLog);
    StringBuilder viewLog = new StringBuilder();
    View view = new EnhancementMockView(viewLog);
    Controller enhancementController = new Controller(model, cropModel, view);
    enhancementController.actionPerformed(new ActionEvent(new Object(), 12345, "Crop Confirm"));

    String expectedCropModel = "Model: save an image " + enhancementController.getCropPath()
        + System.lineSeparator();
    assertEquals(expectedCropModel, cropModelLog.toString());

    String expectedModel = "Model: load an image " + enhancementController.getCropPath()
        + System.lineSeparator();
    assertEquals(expectedModel, modelLog.toString());

    String expectedView = "View: set action listener" + System.lineSeparator()
        + "View: display window" + System.lineSeparator()
        + "View: hide crop frame" + System.lineSeparator()
        + "View: display image dummy image path" + System.lineSeparator();
    assertEquals(expectedView, viewLog.toString());
  }

  @Test
  public void testCropCancel() {
    StringBuilder modelLog = new StringBuilder();
    ImageModel model = new EnhancementMockModel(modelLog);
    StringBuilder viewLog = new StringBuilder();
    View view = new EnhancementMockView(viewLog);
    Controller enhancementController = new Controller(model, view);
    enhancementController.actionPerformed(new ActionEvent(new Object(), 12345, "Crop Cancel"));

    String expectedView = "View: set action listener" + System.lineSeparator()
        + "View: display window" + System.lineSeparator()
        + "View: hide crop frame" + System.lineSeparator();
    assertEquals(expectedView, viewLog.toString());
  }

  @Test
  public void testEdgeDetection() {
    StringBuilder modelLog = new StringBuilder();
    ImageModel model = new EnhancementMockModel(modelLog);
    StringBuilder viewLog = new StringBuilder();
    View view = new EnhancementMockView(viewLog);
    Controller enhancementController = new Controller(model, view);
    enhancementController.actionPerformed(new ActionEvent(new Object(), 12345, "Edge Detection"));

    String expectedModel = "Model: Edge Detection Enhancement" + System.lineSeparator()
        + "Model: apply grayscale effect" + System.lineSeparator();
    assertEquals(expectedModel, modelLog.toString());

    String expectedView = "View: set action listener" + System.lineSeparator()
        + "View: display window" + System.lineSeparator()
        + "View: display image dummy image path" + System.lineSeparator();
    assertEquals(expectedView, viewLog.toString());
  }

  @Test
  public void testGeneratingImages() {
    StringBuilder modelLog = new StringBuilder();
    ImageModel model = new EnhancementMockModel(modelLog);
    StringBuilder viewLog = new StringBuilder();
    View view = new EnhancementMockView(viewLog);
    Controller enhancementController = new Controller(model, view);
    enhancementController.actionPerformed(new ActionEvent(new Object(), 12345, "Generating Image"));

    String expectedView = "View: set action listener" + System.lineSeparator()
        + "View: display window" + System.lineSeparator()
        + "View: display generate image" + System.lineSeparator();
    assertEquals(expectedView, viewLog.toString());
  }

  @Test
  public void testVerticalRainbow() {
    StringBuilder modelLog = new StringBuilder();
    ImageModel model = new EnhancementMockModel(modelLog);
    StringBuilder viewLog = new StringBuilder();
    View view = new EnhancementMockView(viewLog);
    Controller enhancementController = new Controller(model, view);
    enhancementController.actionPerformed(new ActionEvent(new Object(), 12345,
        "Vertical Rainbow"));

    String expectedModel = "Model: Vertical Rainbow Enhancement 500 500" + System.lineSeparator();
    assertEquals(expectedModel, modelLog.toString());

    String expectedView = "View: set action listener" + System.lineSeparator()
        + "View: display window" + System.lineSeparator()
        + "View: display image dummy image path" + System.lineSeparator();
    assertEquals(expectedView, viewLog.toString());
  }

  @Test
  public void testHorizontalRainbow() {
    StringBuilder modelLog = new StringBuilder();
    ImageModel model = new EnhancementMockModel(modelLog);
    StringBuilder viewLog = new StringBuilder();
    View view = new EnhancementMockView(viewLog);
    Controller enhancementController = new Controller(model, view);
    enhancementController.actionPerformed(new ActionEvent(new Object(), 12345,
        "Horizontal Rainbow"));

    String expectedModel = "Model: Horizontal Rainbow Enhancement 500 500" + System.lineSeparator();
    assertEquals(expectedModel, modelLog.toString());

    String expectedView = "View: set action listener" + System.lineSeparator()
        + "View: display window" + System.lineSeparator()
        + "View: display image dummy image path" + System.lineSeparator();
    assertEquals(expectedView, viewLog.toString());
  }

  @Test
  public void testCheckerboard() {
    StringBuilder modelLog = new StringBuilder();
    ImageModel model = new EnhancementMockModel(modelLog);
    StringBuilder viewLog = new StringBuilder();
    View view = new EnhancementMockView(viewLog);
    Controller enhancementController = new Controller(model, view);
    enhancementController.actionPerformed(new ActionEvent(new Object(), 12345, "Checkerboard"));

    String expectedModel = "Model: Checkerboard Enhancement 500 10 [255, 0, 0] [255, 255, 255]"
        + System.lineSeparator();
    assertEquals(expectedModel, modelLog.toString());

    String expectedView = "View: set action listener" + System.lineSeparator()
        + "View: display window" + System.lineSeparator()
        + "View: display image dummy image path" + System.lineSeparator();
    assertEquals(expectedView, viewLog.toString());
  }

  @Test
  public void testNationalFlag() {
    StringBuilder modelLog = new StringBuilder();
    ImageModel model = new EnhancementMockModel(modelLog);
    StringBuilder viewLog = new StringBuilder();
    View view = new EnhancementMockView(viewLog);
    Controller enhancementController = new Controller(model, view);
    enhancementController.actionPerformed(new ActionEvent(new Object(), 12345, "National Flag"));

    String expectedModel = "Model: National Flag Enhancement 500" + System.lineSeparator();
    assertEquals(expectedModel, modelLog.toString());

    String expectedView = "View: set action listener" + System.lineSeparator()
        + "View: display window" + System.lineSeparator()
        + "View: display image dummy image path" + System.lineSeparator();
    assertEquals(expectedView, viewLog.toString());
  }

}
