import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyledDocument;

public class HomeGui extends JFrame implements ActionListener {
	
	private int courseCounter;
	private Data d;
	private JTextPane footer;
	private JTextPane title;
	private static JButton course1;
	private static JButton course2;
	private static JButton course3;
	private static JButton course4;
	private static JButton course5;
	private static JButton course6;
	private static JButton course7;
	private static JButton course8;
	private  JButton addCourse;
	
	private static JButton editCourse1,editCourse2, editCourse3, editCourse4, editCourse5, editCourse6, editCourse7, editCourse8;
	
	@SuppressWarnings("deprecation")
	public HomeGui() {
		super("Home");
		
		courseCounter = -1;
		d = new Data(8);
		if(FileChanger.checkFile())
		{
			FileChanger.readFile(d);
		}
		else
		{
			FileChanger.createFile();
			FileChanger.readFile(d);
		}
		
		AddCourse courseName = new AddCourse(d, courseCounter);
		
	    JPanel panel = new JPanel();
	    GridLayout layout = new GridLayout(2,4);
	    layout.setVgap(5);
	    layout.setHgap(5);
	    panel.setLayout(layout);
	    panel.setBackground(new Color(200,200,200));
	
	    //Tile 1
	    course1 = new JButton();
	    course1.setText(Data.getCourseName(0));
	    course1.addActionListener(this);
	    this.add(course1);
	    
	    editCourse1 = new JButton();
	    editCourse1.setText("Edit");
	    editCourse1.addActionListener(this);
	    this.add(editCourse1);
	    course1.add(editCourse1);
	    
	    course1.setHorizontalAlignment(JTextField.CENTER);
	    course1.setBackground(new Color(230, 183, 97));
	    course1.setFont(new Font("Antipasta Pro Regular", Font.PLAIN, 30));
	    panel.add(course1);
	    
	    //Tile 2
	    course2 = new JButton();
	    course2.setText(Data.getCourseName(1));
	    course2.addActionListener(this);
	    this.add(course2);
	    
	    editCourse2 = new JButton();
	    editCourse2.setText("Edit");
	    editCourse2.addActionListener(this);
	    this.add(editCourse2);
	    course2.add(editCourse2);
	    
	    course2.setHorizontalAlignment(JTextField.CENTER);
	    course2.setBackground(new Color(230, 183, 97));
	    course2.setFont(new Font("Antipasta Pro Regular", Font.PLAIN, 30));
	    panel.add(course2);
	    
	    //Tile 3
	    course3 = new JButton();
	    course3.setText(Data.getCourseName(2));
	    course3.addActionListener(this);
	    this.add(course3);
	    
	    editCourse3 = new JButton();
	    editCourse3.setText("Edit");
	    editCourse3.addActionListener(this);
	    this.add(editCourse3);
	    course3.add(editCourse3);
	    
	    course3.setHorizontalAlignment(JTextField.CENTER);
	    course3.setBackground(new Color(230, 183, 97));
	    course3.setFont(new Font("Antipasta Pro Regular", Font.PLAIN, 30));
	    this.add(course3);
	    panel.add(course3);
	    
	    //Tile 4
	    course4 = new JButton();
	    course4.setText(Data.getCourseName(3));
	    course4.enable(false);
	    course4.addActionListener(this);
	    this.add(course4);
	    
	    editCourse4 = new JButton();
	    editCourse4.setText("Edit");
	    editCourse4.addActionListener(this);
	    this.add(editCourse4);
	    course4.add(editCourse4);
	    
	    course4.setHorizontalAlignment(JTextField.CENTER);
	    course4.setBackground(new Color(230, 183, 97));
	    course4.setFont(new Font("Antipasta Pro Regular", Font.PLAIN, 30));
	    panel.add(course4);
	    
	    //Tile 5
	    course5 = new JButton();
	    course5.setText(Data.getCourseName(4));
	    course5.addActionListener(this);
	    this.add(course5);
	    
	    editCourse5 = new JButton();
	    editCourse5.setText("Edit");
	    editCourse5.addActionListener(this);
	    this.add(editCourse5);
	    course5.add(editCourse5);
	    
	    course5.setHorizontalAlignment(JTextField.CENTER);
	    course5.setBackground(new Color(230, 183, 97));
	    course5.setFont(new Font("Antipasta Pro Regular", Font.PLAIN, 30));
	    panel.add(course5);
	    
	    //Tile 6
	    course6 = new JButton();
	    course6.setText(Data.getCourseName(5));
	    course6.addActionListener(this);
	    this.add(course6);
	    
	    editCourse6 = new JButton();
	    editCourse6.setText("Edit");
	    editCourse6.addActionListener(this);
	    this.add(editCourse6);
	    course6.add(editCourse6);
	    
	    course6.setHorizontalAlignment(JTextField.CENTER);
	    course6.setBackground(new Color(230, 183, 97));
	    course6.setFont(new Font("Antipasta Pro Regular", Font.PLAIN, 30));
	    panel.add(course6);
	    
	    //Tile 7
	    course7 = new JButton();
	    course7.setText(Data.getCourseName(6));
	    course7.addActionListener(this);
	    this.add(course7);
	    
	    editCourse7 = new JButton();
	    editCourse7.setText("Edit");
	    editCourse7.addActionListener(this);
	    this.add(editCourse7);
	    course7.add(editCourse7);
	    
	    course7.setHorizontalAlignment(JTextField.CENTER);
	    course7.setBackground(new Color(230, 183, 97));
	    course7.setFont(new Font("Antipasta Pro Regular", Font.PLAIN, 30));
	    panel.add(course7);
	    
	    //Tile 8
	    course8 = new JButton();
	    course8.setText(Data.getCourseName(7));
	    course8.addActionListener(this);
	    this.add(course8);
	    
	    editCourse8 = new JButton();
	    editCourse8.setText("Edit");
	    editCourse8.addActionListener(this);
	    this.add(editCourse8);
	    course8.add(editCourse8);
	    
	    course8.setHorizontalAlignment(JTextField.CENTER);
	    course8.setBackground(new Color(230, 183, 97));
	    course8.setFont(new Font("Antipasta Pro Regular", Font.PLAIN, 30));
	    panel.add(course8);
	
	    JPanel header = new JPanel();
	    header.setBackground(new Color(80, 120, 147));
	    title = new JTextPane();
	    title.setText("Schedule Planner");
	    title.setEditable(false);
	    title.setAlignmentX(CENTER_ALIGNMENT);
	    title.setFont(new Font("Antipasta Pro Regular", Font.PLAIN, 40));
	    title.setBackground(new Color(80, 120, 147));
	    
	    Icon plusIcon = new ImageIcon("src/plus.png");
	    addCourse = new JButton(plusIcon);
	    addCourse.addActionListener(this);
	    this.add(addCourse);
	    addCourse.setHorizontalAlignment(JButton.RIGHT);
	    addCourse.setBackground(new Color(80, 120, 147));
	    
	    header.add(title);
	    header.add(addCourse);
	    
	    StyledDocument doc = title.getStyledDocument();
	    SimpleAttributeSet center = new SimpleAttributeSet();
	    StyleConstants.setAlignment(center, StyleConstants.ALIGN_CENTER);
	    doc.setParagraphAttributes(0, doc.getLength(), center, false);
	    
	    JPanel bottomFooter = new JPanel();
	    bottomFooter.setBackground(new Color(160, 187, 92));
	    footer = new JTextPane();
	    footer.setText("test test");
	    footer.setEditable(false);
	    footer.setFont(new Font("Antipasta Pro Regular", Font.PLAIN, 20));
	    footer.setBackground(new Color(160, 187, 92));
	    bottomFooter.add(footer);
	    
	    StyledDocument doc2 = footer.getStyledDocument();
	    SimpleAttributeSet center2 = new SimpleAttributeSet();
	    StyleConstants.setAlignment(center2, StyleConstants.ALIGN_CENTER);
	    doc2.setParagraphAttributes(0, doc2.getLength(), center, false);
	    
	    Container c = getContentPane();
	    c.add(panel, BorderLayout.CENTER);
	    c.add(header, BorderLayout.BEFORE_FIRST_LINE);
	    c.add(bottomFooter, BorderLayout.AFTER_LAST_LINE);
	  }

	@Override
	public void actionPerformed(ActionEvent e) {
		if(courseCounter <= 7 && e.getSource() == addCourse) {
			//AddCourse courseWindow = new AddCourse();
			courseCounter++;
			AddCourse course = new AddCourse(d, courseCounter);
	    	course.setBounds(500, 500, 550, 350);
	    	course.setBackground(new Color(211,211,211));
	    	course.setVisible(true);
		}
		if(e.getSource() == course1) {
			System.out.println("course1 called");
			LinkOpener.openLink(d.getCourseLink(0));
			LinkOpener.openLink(d.getMeetingLink(0));

		}
		if(e.getSource() == course2) {
			System.out.println("course2 called");
			LinkOpener.openLink(d.getCourseLink(1));
			LinkOpener.openLink(d.getMeetingLink(1));
		}
		if(e.getSource() == course3) {
			System.out.println("course3 called");
			LinkOpener.openLink(d.getCourseLink(2));
			LinkOpener.openLink(d.getMeetingLink(2));
		}
		if(e.getSource() == course4) {
			System.out.println("course4 called");
			LinkOpener.openLink(d.getCourseLink(3));
			LinkOpener.openLink(d.getMeetingLink(3));
		}
		if(e.getSource() == course5) {
			System.out.println("course5 called");
			LinkOpener.openLink(d.getCourseLink(4));
			LinkOpener.openLink(d.getMeetingLink(4));
		}
		if(e.getSource() == course6) {
			System.out.println("course6 called");
			LinkOpener.openLink(d.getCourseLink(5));
			LinkOpener.openLink(d.getMeetingLink(5));
		}
		if(e.getSource() == course7) {
			System.out.println("course7 called");
			LinkOpener.openLink(d.getCourseLink(6));
			LinkOpener.openLink(d.getMeetingLink(6));
		}
		if(e.getSource() == course8) {
			System.out.println("course8 called");
			LinkOpener.openLink(d.getCourseLink(7));
			LinkOpener.openLink(d.getMeetingLink(7));
		}
		
		//**************************************************************************
		if(e.getSource() == editCourse1) {
			System.out.println("edit course1 called");
			AddCourse course = new AddCourse(d, 0);
	    	course.setBounds(500, 500, 550, 350);
	    	course.setBackground(new Color(211,211,211));
	    	course.setVisible(true);
		}
		if(e.getSource() == editCourse2) {
			System.out.println("edit course2 called");
			AddCourse course = new AddCourse(d, 1);
	    	course.setBounds(500, 500, 550, 350);
	    	course.setBackground(new Color(211,211,211));
	    	course.setVisible(true);
		}
		if(e.getSource() == editCourse3) {
			System.out.println("edit course3 called");
			AddCourse course = new AddCourse(d, 1);
	    	course.setBounds(500, 500, 550, 350);
	    	course.setBackground(new Color(211,211,211));
	    	course.setVisible(true);
		}
		if(e.getSource() == editCourse4) {
			System.out.println("edit course4 called");
			AddCourse course = new AddCourse(d, 1);
	    	course.setBounds(500, 500, 550, 350);
	    	course.setBackground(new Color(211,211,211));
	    	course.setVisible(true);
		}
		if(e.getSource() == editCourse5) {
			System.out.println("edit course5 called");
			AddCourse course = new AddCourse(d, 1);
	    	course.setBounds(500, 500, 550, 350);
	    	course.setBackground(new Color(211,211,211));
	    	course.setVisible(true);
		}
		if(e.getSource() == editCourse6) {
			System.out.println("edit course6 called");
			AddCourse course = new AddCourse(d, 1);
	    	course.setBounds(500, 500, 550, 350);
	    	course.setBackground(new Color(211,211,211));
	    	course.setVisible(true);
		}
		if(e.getSource() == editCourse7) {
			System.out.println("edit course7 called");
			AddCourse course = new AddCourse(d, 1);
	    	course.setBounds(500, 500, 550, 350);
	    	course.setBackground(new Color(211,211,211));
	    	course.setVisible(true);
		}
		if(e.getSource() == editCourse8) {
			System.out.println("edit course8 called");
			AddCourse course = new AddCourse(d, 1);
	    	course.setBounds(500, 500, 550, 350);
	    	course.setBackground(new Color(211,211,211));
	    	course.setVisible(true);
		}
	}
	
	public static void refresh() {
	    course1.setText(Data.getCourseName(0));
	    course2.setText(Data.getCourseName(1));
	    course3.setText(Data.getCourseName(2));
	    course4.setText(Data.getCourseName(3));
	    course5.setText(Data.getCourseName(4));
	    course6.setText(Data.getCourseName(5));
	    course7.setText(Data.getCourseName(6));
	    course8.setText(Data.getCourseName(7));
	}
	
	public static void main(String [] args) {
		HomeGui courseWindow = new HomeGui();
	    courseWindow.setBounds(500, 500, 1200, 650);
	    courseWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    courseWindow.setBackground(new Color(211,211,211));
	    
	    ImageIcon logo = new ImageIcon("src/logo.png");
		courseWindow.setIconImage(logo.getImage());
	    
		courseWindow.setVisible(true);
	}
}