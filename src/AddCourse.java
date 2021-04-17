import java.awt.*;
import java.awt.event.*;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import javax.swing.*;

@SuppressWarnings("serial")
/**
 * Used by HomeGui to alter the Data object through another GUI
 * 
 * @author Alex Wang, Connor Chow, Kamran Hussain
 * @version 4/17/2021
 */
public class AddCourse extends JFrame implements ActionListener {
  private JTextField inputCourseName, inputMeetingLink, inputCourseLink; //input variables
  private String courseName, courseLink, meetingLink;
  private JButton addClass;
  private Data d;
  private int num;
  
  
  @SuppressWarnings("static-access")
/**
 * Creates an AddCourse
 * @param d
 * @param num
 */
public AddCourse(Data d, int num) {
    super("Class Scheduler");
    
    this.d = d;
    this.num = num;
    
    JPanel panel = new JPanel();
    GridLayout layout = new GridLayout(3,3);
    layout.setVgap(30);
    panel.setLayout(layout);
    panel.setBackground(new Color(200,200,200));
    
    
    JLabel nameLabel = new JLabel("   Course Name:\n");
    nameLabel.setFont(new Font("Montserrat", Font.PLAIN, 17));
    panel.add(nameLabel);
    inputCourseName = new JTextField(20);
    inputCourseName.setHorizontalAlignment(JTextField.RIGHT);
    inputCourseName.setBackground(new Color(230,230,225));
    inputCourseName.setFont(new Font("Montserrat", Font.PLAIN, 17));
    inputCourseName.setText(d.getCourseName(num));
    panel.add(inputCourseName);
    
    JLabel courseLabel = new JLabel("   Course Link:\n");
    courseLabel.setFont(new Font("Montserrat", Font.PLAIN, 17));
    panel.add(courseLabel);
    inputCourseLink = new JTextField(20);
    inputCourseLink.setHorizontalAlignment(JTextField.RIGHT);
    inputCourseLink.setBackground(new Color(225,225,225));
    inputCourseLink.setFont(new Font("Montserrat", Font.PLAIN, 17));
    inputCourseLink.setText(d.getCourseLink(num));
    panel.add(inputCourseLink);

    JLabel linkLabel = new JLabel("   Meeting Link:\n");
    linkLabel.setFont(new Font("Montserrat", Font.PLAIN, 17));
    panel.add(linkLabel);
    inputMeetingLink = new JTextField(20);
    inputMeetingLink.setHorizontalAlignment(JTextField.RIGHT);
    inputMeetingLink.setBackground(new Color(225,225,225));
    inputMeetingLink.setFont(new Font("Montserrat", Font.PLAIN, 17));
    inputMeetingLink.setText(d.getMeetingLink(num));
    panel.add(inputMeetingLink);

    addClass = new JButton("Add Class");
    addClass.addActionListener(this);
    addClass.setBackground(new Color(79, 93, 117));
    addClass.setFont(new Font("Montserrat", Font.PLAIN, 20));
    addClass.setForeground(new Color(255,255,255));

    Container c = getContentPane();
    c.add(panel, BorderLayout.CENTER);
    c.add(addClass, BorderLayout.SOUTH);
  }

  public void actionPerformed(ActionEvent e) {
	 ImageIcon logo = new ImageIcon("src/logo.png");
	 
    courseName = inputCourseName.getText();
    courseLink = inputCourseLink.getText();
    meetingLink = inputMeetingLink.getText();
    
    if(LinkOpener.urlValid(courseLink) == true && LinkOpener.urlValid(meetingLink) == true) {    	
    	String s = courseName + ";" + courseLink + ";" + meetingLink;
	    d.replaceStrings(num, s);
	    try {
			FileChanger.writeFile(d.returnStrings());
		} catch (IOException e1) {
			System.out.println("AddCourse writing file failed");
			e1.printStackTrace();
		}
	    
	    // sleeps
	    try {
			TimeUnit.MILLISECONDS.sleep(200);
		} catch (InterruptedException e1) {
			System.out.println("AddCourse sleep timer error.");
			e1.printStackTrace();
		}
	    
	    // destroys window
	    setVisible(false);
	    dispose();
	    
	    HomeGui.refresh();
	} else {
		System.out.println("Error 400 Bad Request Error");
		ErrorMessage errorMessage1 = new ErrorMessage();
    	errorMessage1.setBounds(500, 500, 300, 170);
    	errorMessage1.setBackground(new Color(211,211,211));
    	errorMessage1.setVisible(true);
    	
    	errorMessage1.setIconImage(logo.getImage());
	}
    
    if(ErrorMessage.isDismissed()==true) {
    	 String s = courseName + ";" + courseLink + ";" + meetingLink;
    	    d.replaceStrings(num, s);
    	    try {
    			FileChanger.writeFile(d.returnStrings());
    		} catch (IOException e1) {
    			System.out.println("AddCourse writing file failed");
    			e1.printStackTrace();
    		}
    	    
    	    // sleeps
    	    try {
    			TimeUnit.MILLISECONDS.sleep(200);
    		} catch (InterruptedException e1) {
    			System.out.println("AddCourse sleep timer error.");
    			e1.printStackTrace();
    		}
    } 
  }
}