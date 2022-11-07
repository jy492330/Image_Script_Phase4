package imageview;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import  javax.swing.DefaultListModel;
import  javax.swing.ImageIcon;
import  javax.swing.JButton;
import  javax.swing.JCheckBox;
import  javax.swing.JColorChooser;
import  javax.swing.JFileChooser;
import  javax.swing.JFrame;
import  javax.swing.JLabel;
import  javax.swing.JList;
import  javax.swing.JMenu;
import  javax.swing.JMenuBar;
import  javax.swing.JMenuItem;
import  javax.swing.JPanel;
import  javax.swing.JScrollPane;
import  javax.swing.JTextField;
import  javax.swing.ListSelectionModel;
import  javax.swing.ScrollPaneConstants;


/**
 * This class represents the implementation of the GUI view.
 */
public class FrameView extends JFrame implements View {
  private static JList<String> options;
  private static JScrollPane optionPane;
  private static final long serialVersionUID = -7083924619099998893L;
  private JTextField input;
  private JPanel buttonPanel;
  private JLabel display;
  private JPanel optionPanel;
  private JCheckBox sharpenCheck;
  private JCheckBox blurCheck;
  private JCheckBox grayscaleCheck;
  private JCheckBox ditherCheck;
  private JCheckBox sepiaCheck;
  private JCheckBox mosaicCheck;
  private JLabel fileLabel;
  private JTextField fileField;
  private JButton displayButton;
  private JLabel optionLabel;
  private JPanel imagePanel;
  private ImageIcon icon;
  private JLabel imageLabel;
  private JPanel borderPanel;
  private JMenuBar menuBar;
  private JMenu mainMenu;
  private JMenuItem loadOption;
  private JMenuItem saveOption;
  private JMenuItem createScript;
  private JMenuItem runScript;
  private JMenuItem blur;
  private JMenuItem sharpen;
  private JMenuItem grayscale;
  private JMenuItem sepia;
  private JMenuItem dither;
  private JMenu mosaicOption;
  private JMenuItem mosaic1000;
  private JMenuItem mosaic4000;
  private JMenuItem mosaic8000;
  private JMenuItem mosaic15000;
  private JFrame scriptFrame;
  private JPanel scriptPanel;
  private JMenuBar scriptMenuBar;
  private JMenu scriptMainMenu;
  private DefaultListModel<String> listModel;
  private JList optionList;
  private JMenuItem cropImage;
  private JMenuItem edgeDetection;
  private JMenuItem verticalRainbow;
  private JMenuItem horizontalRainbow;
  private JMenuItem checkerBoard;
  private JMenuItem flag;
  private JFrame cropFrame;
  private JButton cropConfirm;
  private JButton cropCancel;
  private JLabel cropLabel;
  private JPanel cropPanel;
  private JFrame generateImageFrame;
  private JPanel generateImagePanel;
  private JLabel generateImageHeightLabel;
  private JTextField generateImageHeightField;
  private JLabel generateImageWidthLabel;
  private JTextField generateImageWidthField;
  private JLabel generateImageNumSquaresLabel;
  private JTextField generateImageNumSquaresField;
  private JColorChooser generateImageColor1;
  private JColorChooser generateImageColor2;
  private JMenuItem generateImage;
  private JPanel generateImageHeightPanel;
  private JPanel generateImageWidthPanel;
  private JLabel generateImageColor1label;
  private JLabel generateImageColor2label;


  /**
   * Constructor.
   * 
   * @param caption the value of the caption
   */
  public FrameView(String caption) {
    super(caption);
    borderPanel = new JPanel(new BorderLayout());
    setSize(500, 100);
    setLocation(200, 200);
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    menuBar = new JMenuBar();
    mainMenu = new JMenu("Menu Options");
    loadOption = new JMenuItem("Load Image File");
    saveOption = new JMenuItem("Save Image File");
    createScript = new JMenuItem("Create Script");
    runScript = new JMenuItem("Run Script");
    cropImage = new JMenuItem("Crop Image");
    cropFrame = new JFrame("Crop Options");
    cropPanel = new JPanel();
    cropConfirm = new JButton("Crop Confirm");
    cropCancel = new JButton("Crop Cancel");
    cropLabel = new JLabel();
    edgeDetection = new JMenuItem("Edge Detection");
    verticalRainbow = new JMenuItem("Vertical Rainbow");
    horizontalRainbow = new JMenuItem("Horizontal Rainbow");
    checkerBoard = new JMenuItem("Checkerboard");
    flag = new JMenuItem("National Flag");
    generateImageFrame = new JFrame();
    generateImageHeightPanel = new JPanel(new GridLayout(6, 2));
    //generateImageWidthPanel = new JPanel(new GridLayout(1, 2));
    generateImagePanel = new JPanel(new GridLayout(5, 1));
    generateImageHeightLabel = new JLabel("Height");
    generateImageHeightField = new JTextField(5);
    generateImageWidthLabel = new JLabel("Width");
    generateImageWidthField = new JTextField(5);
    generateImageNumSquaresLabel = new JLabel("Num Squares");
    generateImageNumSquaresField = new JTextField(5);
    generateImageColor1label = new JLabel("Color1");
    generateImageColor1 = new JColorChooser();
    generateImageColor2label = new JLabel("Color2");
    generateImageColor2 = new JColorChooser();
    generateImage = new JMenuItem("Generating Image");

    menuBar.add(mainMenu);
    setJMenuBar(menuBar);
    mainMenu.add(loadOption);
    mainMenu.add(saveOption);
    mainMenu.add(createScript);
    mainMenu.add(runScript);
    mainMenu.add(cropImage);
    mainMenu.add(edgeDetection);
    mainMenu.add(generateImage);
    cropPanel.add(cropConfirm);
    cropPanel.add(cropCancel);
    cropPanel.add(cropLabel);
    cropFrame.getContentPane().add(cropPanel);
    cropFrame.setLocationRelativeTo(null);
    generateImageHeightPanel.add(generateImageHeightLabel);
    generateImageHeightPanel.add(generateImageHeightField);
    generateImageHeightPanel.add(generateImageWidthLabel);
    generateImageHeightPanel.add(generateImageWidthField);
    generateImageHeightPanel.add(generateImageNumSquaresLabel);
    generateImageHeightPanel.add(generateImageNumSquaresField);
    generateImagePanel.add(generateImageHeightPanel);
    generateImagePanel.add(generateImageColor1label);
    generateImagePanel.add(generateImageColor1);
    generateImagePanel.add(generateImageColor2label);
    generateImagePanel.add(generateImageColor2);
    //generateImageFrame.add(generateImagePanel);
    generateImageFrame.getContentPane().add(generateImagePanel);

    display = new JLabel("To be displayed");
    input = new JTextField(10);
    fileLabel = new JLabel("To be displayed");
    fileField = new JTextField(10);

    optionPanel = new JPanel();
    optionPanel.setLayout(new GridLayout(7, 1));
    optionLabel = new JLabel("Select One or More Image Effects");
    optionPanel.add(optionLabel);
    sharpenCheck = new JCheckBox("Sharpen");
    sharpenCheck.setMnemonic(KeyEvent.VK_C);
    sharpenCheck.setSelected(false);
    optionPanel.add(sharpenCheck);

    blurCheck = new JCheckBox("Blur");
    blurCheck.setMnemonic(KeyEvent.VK_G);
    blurCheck.setSelected(false);
    optionPanel.add(blurCheck);

    sepiaCheck = new JCheckBox("Sepia");
    sepiaCheck.setMnemonic(KeyEvent.VK_H);
    sepiaCheck.setSelected(false);
    optionPanel.add(sepiaCheck);

    grayscaleCheck = new JCheckBox("Grayscale");
    grayscaleCheck.setMnemonic(KeyEvent.VK_H);
    grayscaleCheck.setSelected(false);
    optionPanel.add(grayscaleCheck);

    ditherCheck = new JCheckBox("Dither");
    ditherCheck.setMnemonic(KeyEvent.VK_T);
    ditherCheck.setSelected(false);
    optionPanel.add(ditherCheck);

    mosaicCheck = new JCheckBox("Mosaic");
    mosaicCheck.setMnemonic(KeyEvent.VK_T);
    mosaicCheck.setSelected(false);
    optionPanel.add(mosaicCheck);

    buttonPanel = new JPanel();
    buttonPanel.setLayout(new GridLayout(1, 3));

    imagePanel = new JPanel();
    imagePanel.setPreferredSize(new Dimension(700, 500));
    imagePanel.setBackground(Color.BLACK);
    JScrollPane jscrollPane = new JScrollPane(borderPanel,
        ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS,
        ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
    jscrollPane.setPreferredSize(new Dimension(600, 400));

    ImageIcon icon = new ImageIcon();
    imageLabel = new JLabel();
    imageLabel.setIcon(icon);
    imagePanel.add(imageLabel);
    borderPanel.add(imagePanel, BorderLayout.CENTER);
    borderPanel.add(buttonPanel, BorderLayout.SOUTH);
    this.getContentPane().add(jscrollPane);
    scriptFrame = new JFrame("Script");
    scriptFrame.setBackground(Color.BLACK);
    scriptFrame.setVisible(false);
    scriptFrame.setBackground(Color.BLACK);
    cropFrame.setVisible(false);
    generateImageFrame.setVisible(false);
    scriptMenuBar = new JMenuBar();
    scriptMainMenu = new JMenu("Script Options");
    blur = new JMenuItem("Blur Effect");
    blur.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
      }
    });
    sharpen = new JMenuItem("Sharpen Effect");
    grayscale = new JMenuItem("Grayscale Effect");
    sepia = new JMenuItem("Sepia Effect");
    dither = new JMenuItem("Dither Effect");
    mosaicOption = new JMenu("Mosaic Effect");
    mosaic1000 = new JMenuItem("Seeds: 1000");
    mosaic4000 = new JMenuItem("Seeds: 4000");
    mosaic8000 = new JMenuItem("Seeds: 8000");
    mosaic15000 = new JMenuItem("Seeds: 15000");

    scriptMainMenu.add(blur);
    scriptMainMenu.add(sharpen);
    scriptMainMenu.add(grayscale);
    scriptMainMenu.add(sepia);
    scriptMainMenu.add(dither);
    scriptMainMenu.add(mosaicOption);
    mosaicOption.add(mosaic1000);
    mosaicOption.add(mosaic4000);
    mosaicOption.add(mosaic8000);
    mosaicOption.add(mosaic15000);
    scriptMenuBar.add(scriptMainMenu);
    scriptFrame.setJMenuBar(scriptMenuBar);
    scriptPanel = new JPanel(new BorderLayout());
    scriptPanel.setVisible(true);
    optionPane = new JScrollPane();
    optionPane.setVisible(true);
    listModel = new DefaultListModel();
    optionList = new JList(listModel);
    optionList.setVisible(true);
    optionList.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
    optionList.setLayoutOrientation(JList.HORIZONTAL_WRAP);
    optionPane = new JScrollPane(optionList);
    optionPane.setVisible(true);
    optionPane.setPreferredSize(new Dimension(250, 200));
    scriptFrame.setPreferredSize(new Dimension(300, 400));
    optionPane.setViewportView(options);
    scriptFrame.add(optionList);
    scriptPanel.setVisible(true);
    optionPane.setVisible(true);
    generateImageHeightLabel.setPreferredSize(new Dimension(5, 5));
    generateImageWidthLabel.setPreferredSize(new Dimension(5, 5));
    generateImageNumSquaresLabel.setPreferredSize(new Dimension(5, 5));
    generateImageHeightField.setPreferredSize(new Dimension(5, 5));
    generateImageWidthField.setPreferredSize(new Dimension(5, 5));
    generateImageNumSquaresField.setPreferredSize(new Dimension(5, 5));
    generateImageColor1label.setPreferredSize(new Dimension(10, 5));
    generateImageColor2label.setPreferredSize(new Dimension(10, 5));
    cropFrame.setPreferredSize(new Dimension(300, 300));
    cropPanel.setPreferredSize(new Dimension(300, 300));
    cropPanel.setMinimumSize(new Dimension(200, 200));
    generateImageFrame.setPreferredSize(new Dimension(500, 700));
    generateImageFrame.setMinimumSize(new Dimension(500, 500));
    generateImageColor1.setPreferredSize(new Dimension(10, 5));
    generateImageColor2.setPreferredSize(new Dimension(10, 5));
    generateImageHeightPanel.setPreferredSize(new Dimension(40, 5));
    cropFrame.pack();
    scriptFrame.pack();
    generateImageFrame.pack();
    pack();
  }


  @Override
  public void displayWindow() {
    setVisible(true);
  }

  @Override
  public void displayImage(String pngFilePath) {
    try { // must include a try & catch block for ImageIO
      Image newImage = ImageIO.read(new File(pngFilePath));
      ImageIcon i = new ImageIcon(newImage);
      imageLabel.setIcon(i);
      this.repaint();
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  @Override
  public void createScript() {
    scriptFrame.setVisible(true);
  }

  @Override
  public void setListener(ActionListener listener) {
    loadOption.addActionListener(listener);
    saveOption.addActionListener(listener);
    createScript.addActionListener(listener);
    runScript.addActionListener(listener);
    blur.addActionListener(listener);
    sharpen.addActionListener(listener);
    grayscale.addActionListener(listener);
    sepia.addActionListener(listener);
    dither.addActionListener(listener);
    mosaic1000.addActionListener(listener);
    mosaic4000.addActionListener(listener);
    mosaic8000.addActionListener(listener);
    mosaic15000.addActionListener(listener);
    cropImage.addActionListener(listener);
    cropCancel.addActionListener(listener);
    cropConfirm.addActionListener(listener);
    edgeDetection.addActionListener(listener);
    generateImage.addActionListener(listener);
  }

  @Override
  public void setListener(MouseListener listener) {
    imageLabel.addMouseListener(listener);
  }

  @Override
  public void unsetListener(MouseListener listener) {
    imageLabel.removeMouseListener(listener);
  }


  @Override
  public String getFile() {
    // new JFileChooser(Path.of("res").toAbsolutePath().toString())
    final JFileChooser fc = new JFileChooser();
    // without this line it will default to my document directory
    fc.setCurrentDirectory(new File("."));
    // brings up a std open dialog with a file button's action listener e.g. Open or Save
    int returnVal = fc.showOpenDialog(null);
    if (returnVal == JFileChooser.APPROVE_OPTION) {
      return fc.getSelectedFile().getAbsolutePath();
    }
    return null;
  }

  @Override
  public String saveFile() {
    final JFileChooser fc = new JFileChooser();
    fc.setApproveButtonText("Save");
    fc.setCurrentDirectory(new File("."));
    int returnVal = fc.showOpenDialog(null);
    if (returnVal == JFileChooser.APPROVE_OPTION) {
      return fc.getSelectedFile().getAbsolutePath();
    }
    return null;
  }

  @Override
  public void addEffect(String effect) {
    listModel.addElement(effect);
  }

  @Override
  public void displayCropFrame(String imageFilePath) {
    cropFrame.setVisible(true);
    try {
      Image newImage = ImageIO.read(new File(imageFilePath));
      ImageIcon i = new ImageIcon(newImage);
      cropLabel.setIcon(i);
      cropLabel.repaint();
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  @Override
  public void hideCropFrame() {
    cropFrame.setVisible(false);
  }

  @Override
  public void displayGenerateImage() {
    generateImageFrame.setVisible(true);
  }

  @Override
  public void hideGenerateImage() {
    generateImageFrame.setVisible(false);
  }

}
