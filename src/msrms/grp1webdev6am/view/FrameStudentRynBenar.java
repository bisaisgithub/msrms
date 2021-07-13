package msrms.grp1webdev6am.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableModel;

import msrms.grp1webdev6am.controller.LoginDAO;
import msrms.grp1webdev6am.controller.StudentAddDao;
import msrms.grp1webdev6am.controller.StudentDeleteBenarDao;
import msrms.grp1webdev6am.controller.StudentEditBenarDao;
import msrms.grp1webdev6am.controller.StudentGetAllBEnarDao;
import msrms.grp1webdev6am.controller.StudentSearchBenarDao;
import msrms.grp1webdev6am.model.LoginModel;
import msrms.grp1webdev6am.model.StudentAddModel;
import msrms.grp1webdev6am.model.StudentModel;

import java.awt.Color;
import java.awt.Component;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ImageIcon;
import javax.swing.JButton;

import java.sql.SQLException;
import java.util.List;
import javax.swing.border.MatteBorder;
import javax.swing.JLabel;
import java.awt.ComponentOrientation;
import java.awt.Rectangle;

public class FrameStudentRynBenar extends JFrame {

	private JPanel contentPane;
	DefaultTableModel model;
	private JTable table;
	private JScrollPane scrollPane;
	private JTextField txtID;
	private JTextField txtEmailAddress;
	private JTextField txtFullname;
	private JTextField txtMobile;
	private JTextField txtCity;
	private JTextField txtProvince;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrameStudentRynBenar frame = new FrameStudentRynBenar();//edit
					frame.setVisible(true);
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public FrameStudentRynBenar() {
				
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1000, 700);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBackground(Color.WHITE);
		panel.setBounds(0, 0, 986, 663);
		contentPane.add(panel);
		
		JPanel banner = new JPanel();
		banner.setBorder(new MatteBorder(0, 0, 3, 0, (Color) Color.GRAY));
		banner.setBackground(Color.WHITE);
		banner.setBounds(0, 0, 986, 111);
		panel.add(banner);
		banner.setLayout(null);
		
		JLabel mtdiLogo = new JLabel("");
		mtdiLogo.setBounds(48, 28, 124, 61);
		String path = "C:\\\\Users\\\\mar\\\\eclipse-proj1\\\\msrms\\\\src\\\\img\\MTDI.png";
		banner.add(mtdiLogo);
		ImageIcon MyImage = new ImageIcon(path);
		Image logo = MyImage.getImage();
		Image newLogo = logo.getScaledInstance(mtdiLogo.getWidth(), mtdiLogo.getHeight(), Image.SCALE_SMOOTH);
		ImageIcon image = new ImageIcon(newLogo);
		mtdiLogo.setIcon(image);
		
		JButton studentBtn = new JButton("Student");
		studentBtn.setBorder(new MatteBorder(0, 0, 3, 0, (Color) SystemColor.textHighlight));
		studentBtn.setForeground(SystemColor.textHighlight);
		studentBtn.setFont(new Font("SansSerif", Font.PLAIN, 14));
		studentBtn.setBounds(397, 32, 71, 22);
		studentBtn.setOpaque(false);
		studentBtn.setContentAreaFilled(false);		
		banner.add(studentBtn);
		
		JButton btnFrameClass = new JButton("Class");	
		btnFrameClass.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					dispose();
					FrameClassRynBenar frame = new FrameClassRynBenar();
					frame.setVisible(true);
				} catch (Exception ex) {
					ex.printStackTrace();
				}
			}
		});
		btnFrameClass.setBorder(new EmptyBorder(0, 0, 0, 0));
		btnFrameClass.setFont(new Font("SansSerif", Font.PLAIN, 14));
		btnFrameClass.setBounds(526, 31, 71, 20);
		btnFrameClass.setOpaque(false);
		btnFrameClass.setContentAreaFilled(false);
		banner.add(btnFrameClass);
		
		scrollPane = new JScrollPane();
		scrollPane.setBorder(new EmptyBorder(0, 0, 0, 0));
		scrollPane.setBackground(Color.WHITE);
		scrollPane.setBounds(72, 296, 857, 474);
		panel.add(scrollPane);
		
		
		table = new JTable();
		table.setForeground(SystemColor.textHighlight);
		table.setOpaque(false);
		table.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
		table.setBorder(new EmptyBorder(0, 0, 0, 0));
		table.setGridColor(Color.WHITE);
			scrollPane.setViewportView(table);
		JTableHeader THeader = table.getTableHeader();
			THeader.setBackground(new Color(0,0,0,50));	
			THeader.setOpaque(false);
			table.setDefaultRenderer(Object.class, new TableCellRenderer(){
	            private DefaultTableCellRenderer DEFAULT_RENDERER =  new DefaultTableCellRenderer();
	            @Override
	            public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
	                Component c = DEFAULT_RENDERER.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
	                if (row%2 == 0){
	                    c.setBackground(Color.WHITE);
	                }
	                else {
	                    c.setBackground(new Color(230,230,230,230));
	                }                        
	                return c;
	            }

	        });
		table.setRowHeight(30);	
		table.setColumnSelectionAllowed(false);
		table.setCellSelectionEnabled(false);
		table.setFont(new Font("SansSerif", Font.PLAIN, 12));
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"ID", "Email Address", "Full Name", "Mobile", "City", "Province"
			}
		));
        table.addMouseListener(new java.awt.event.MouseAdapter() {
           public void mouseClicked(java.awt.event.MouseEvent evt) {
               jTable_Display_UsersMouseClicked(evt);
           }
        });

	//	scrollPane.setViewportView(table);
		
		txtID = new JTextField();
		txtID.setEditable(false);
		txtID.addFocusListener(new FocusAdapter() {
			
			public void focusGained(FocusEvent e) {
				if(txtID.getText().equals("ID")) 
				{
					txtID.setText("");
					txtID.setForeground(Color.BLACK);				
				}
				
			}
			@Override
			public void focusLost(FocusEvent e) 
			{
				if(txtID.getText().equals("")) 
				{
					txtID.setText("ID");
					txtID.setForeground(new Color(153,153,153,153));				
				}				
			}
		});
		txtID.setForeground(Color.LIGHT_GRAY);
		txtID.setText("");
		txtID.setColumns(10);
		txtID.setBounds(94, 245, 84, 25);
		panel.add(txtID);
		
		txtEmailAddress = new JTextField();
		txtEmailAddress.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) 
			{
				if(txtEmailAddress.getText().equals("email@email.com")) 
				{
					txtEmailAddress.setText("");
					txtEmailAddress.setForeground(Color.BLACK);				
				}
			}
			@Override
			public void focusLost(FocusEvent e) 
			{
				if(txtEmailAddress.getText().equals("")) 
				{
					txtEmailAddress.setText("email@email.com");
					txtEmailAddress.setForeground(new Color(153,153,153,153));				
				}
			}
		});
		txtEmailAddress.setText("email@email.com");
		txtEmailAddress.setForeground(Color.LIGHT_GRAY);
		txtEmailAddress.setColumns(10);
		txtEmailAddress.setBounds(188, 245, 152, 25);
		panel.add(txtEmailAddress);
		
		txtFullname = new JTextField();
		txtFullname.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e)
			{
				if(txtFullname.getText().equals("Name")) 
				{
					txtFullname.setText("");
					txtFullname.setForeground(Color.BLACK);				
				}
			}
			@Override
			public void focusLost(FocusEvent e) 
			{
				if(txtFullname.getText().equals("")) 
				{
					txtFullname.setText("Name");
					txtFullname.setForeground(new Color(153,153,153,153));				
				}
			}
		});
		txtFullname.setForeground(Color.LIGHT_GRAY);
		txtFullname.setText("Name");
		txtFullname.setColumns(10);
		txtFullname.setBounds(350, 245, 143, 25);
		panel.add(txtFullname);
		
		txtMobile = new JTextField();
		txtMobile.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) 
			{
				if(txtMobile.getText().equals("Mobile")) 
				{
					txtMobile.setText("");
					txtMobile.setForeground(Color.BLACK);				
				}
			}
			@Override
			public void focusLost(FocusEvent e) 
			{
				if(txtMobile.getText().equals("")) 
				{
					txtMobile.setText("Mobile");
					txtMobile.setForeground(new Color(153,153,153,153));				
				}
			}
		});
		txtMobile.setForeground(Color.LIGHT_GRAY);
		txtMobile.setText("Mobile");
		txtMobile.setColumns(10);
		txtMobile.setBounds(503, 245, 143, 25);
		panel.add(txtMobile);
		
		txtCity = new JTextField();
		txtCity.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) 
			{
				if(txtCity.getText().equals("City")) 
				{
					txtCity.setText("");
					txtCity.setForeground(Color.BLACK);				
				}
			}
			@Override
			public void focusLost(FocusEvent e) 
			{
				if(txtCity.getText().equals("")) 
				{
					txtCity.setText("City");
					txtCity.setForeground(Color.BLACK);				
				}
			}
		});
		txtCity.setForeground(Color.LIGHT_GRAY);
		txtCity.setText("City");
		txtCity.setColumns(10);
		txtCity.setBounds(656, 245, 143, 25);
		panel.add(txtCity);
		
		txtProvince = new JTextField();
		txtProvince.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) 
			{
				if(txtProvince.getText().equals("Province")) 
				{
					txtProvince.setText("");
					txtProvince.setForeground(Color.BLACK);				
				}
			}
			@Override
			public void focusLost(FocusEvent e) 
			{
				if(txtProvince.getText().equals("")) 
				{
					txtProvince.setText("Province");
					txtProvince.setForeground(new Color(153,153,153,153));				
				}
			}
		});
		txtProvince.setBounds(728, 197, 86, 20);
		txtProvince.setForeground(Color.LIGHT_GRAY);
		txtProvince.setText("Province");
		txtProvince.setColumns(10);
		txtProvince.setBounds(809, 245, 95, 25);
		panel.add(txtProvince);
		
		JButton btnAdd = new JButton("");
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				try {
					String emailAddress = txtEmailAddress.getText();
					String fullname = txtFullname.getText();
					String mobile = txtMobile.getText();
					String city = txtCity.getText();
					String province = txtProvince.getText();

					StudentModel newStudent = new StudentModel(emailAddress, fullname, mobile, city, province);
					System.out.println(newStudent.getEmailAddress());
					System.out.println(newStudent.getFullname());
					System.out.println(newStudent.getMobile());
					System.out.println(newStudent.getCity());
					System.out.println(newStudent.getProvince());
					
					StudentAddDao insertStudentDao = new StudentAddDao();
					insertStudentDao.insertStudent(newStudent);
					showAllStudents();
										
				}catch(SQLException e1){
					e1.printStackTrace();
					JOptionPane.showMessageDialog(null, "Failed Adding the Student");
				}
			}
		});
		btnAdd.setBackground(Color.WHITE);
		btnAdd.setBorder(null);
		path="C:\\Users\\mar\\eclipse-proj1\\msrms\\src\\img\\add.png";
		btnAdd.setBounds(865, 186, 25, 25);
		panel.add(btnAdd);
		ImageIcon MyAdd = new ImageIcon(path);
		Image add = MyAdd.getImage();
		Image newAdd = add.getScaledInstance(btnAdd.getWidth(), btnAdd.getHeight(), Image.SCALE_SMOOTH);
		ImageIcon addImage = new ImageIcon(newAdd);
		btnAdd.setIcon(addImage);
		
		//reset button	
		JButton btnReset = new JButton("");
		btnReset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				resetInputFields();
			}
		});
		btnReset.setBorder(null);
		btnReset.setBackground(Color.WHITE);
		path="C:\\Users\\mar\\eclipse-proj1\\msrms\\src\\img\\risit.png";
		btnReset.setBounds(173, 186, 27, 27);
		panel.add(btnReset);
		ImageIcon myReset = new ImageIcon(path);
		Image reset = myReset.getImage();
		Image newReset = reset.getScaledInstance(btnReset.getWidth(), btnReset.getHeight(), Image.SCALE_SMOOTH);
		ImageIcon resetImage = new ImageIcon(newReset);
		btnReset.setIcon(resetImage);
		
		JButton btnEdit = new JButton("");
		btnEdit.setBackground(new Color(255, 255, 255));
		btnEdit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
					int editID = Integer.parseInt(txtID.getText());
					System.out.println("Not Empty ID");
					StudentModel editStudent = new StudentModel(editID, txtFullname.getText(), txtMobile.getText(), txtCity.getText(), txtProvince.getText());
					StudentEditBenarDao studentEditBenarDao = new StudentEditBenarDao();
					studentEditBenarDao.updateStudent(editStudent);
					showAllStudents();
					
				}catch(Exception ex){
					ex.printStackTrace();
					JOptionPane.showMessageDialog(null, "Empty ID");
				}
				if(Integer.parseInt(txtID.getText()) >= 0) {
					System.out.println("Empty ID");
				}else {
					System.out.println("Empty Not Empty");
				}
			}
		});
	//	btnEdit.setBackground(Color.WHITE);
		
		btnEdit.setBorder(null);
		path = "C:\\Users\\mar\\eclipse-proj1\\msrms\\src\\img\\edit.png";
		btnEdit.setBounds(72, 186, 25, 25);
		panel.add(btnEdit);
		ImageIcon MyEdit = new ImageIcon(path);
		Image edit = MyEdit.getImage();
		Image newEdit = edit.getScaledInstance(btnEdit.getWidth(), btnEdit.getHeight(), Image.SCALE_SMOOTH);
		ImageIcon editImage = new ImageIcon(newEdit);
		btnEdit.setIcon(editImage);
		
		JButton btnDelete = new JButton("");
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					int deleteID = Integer.parseInt(txtID.getText());
					System.out.println("Not Empty ID");
					StudentModel editStudent = new StudentModel(deleteID);
					StudentDeleteBenarDao studentEditBenarDao = new StudentDeleteBenarDao();
					studentEditBenarDao.deleteStudent(deleteID);
					showAllStudents();
					
				}catch(Exception ex){
					ex.printStackTrace();
					JOptionPane.showMessageDialog(null, "Empty ID");
				}
				if(Integer.parseInt(txtID.getText()) >= 0) {
					System.out.println("Empty ID");
				}else {
					System.out.println("Empty Not Empty");
				}
			}
		});
		btnDelete.setBackground(Color.WHITE);
		btnDelete.setBorder(null);
		path="C:\\Users\\mar\\eclipse-proj1\\msrms\\src\\img\\delete.png";
		btnDelete.setBounds(102, 186, 20, 25);
		panel.add(btnDelete);
		ImageIcon myDel = new ImageIcon(path);
		Image del = myDel.getImage();
		Image newDel = del.getScaledInstance(btnDelete.getWidth(), btnDelete.getHeight(), Image.SCALE_SMOOTH);
		ImageIcon delImage = new ImageIcon(newDel);
		btnDelete.setIcon(delImage);
		
		JButton btnSearch = new JButton("");
		btnSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
					String emailAddress = txtEmailAddress.getText();
					String fullname = txtFullname.getText();
					String mobile = txtMobile.getText();
					String city = txtCity.getText();
					String province = txtProvince.getText();

					StudentModel searchStudent = new StudentModel(emailAddress, fullname, mobile, city, province);
					System.out.println("fr"+searchStudent.getEmailAddress());
					System.out.println(searchStudent.getFullname());
					System.out.println(searchStudent.getMobile());
					System.out.println(searchStudent.getCity());
					System.out.println(searchStudent.getProvince());
					
					showSearchStudents(searchStudent);

										
				}catch(Exception e1){
					e1.printStackTrace();
					JOptionPane.showMessageDialog(null, "Failed Searching the Student (fc)");
				}
			}
		});
		btnSearch.setBackground(Color.WHITE);
		btnSearch.setBorder(null);
		path = "C:\\Users\\mar\\eclipse-proj1\\msrms\\src\\img\\search.png";
		btnSearch.setBounds(132, 186, 20, 25);
		panel.add(btnSearch);
		ImageIcon mySearch = new ImageIcon(path);
		Image search = mySearch.getImage();
		Image newSearch = search.getScaledInstance(btnSearch.getWidth(), btnSearch.getHeight(), Image.SCALE_SMOOTH);
		ImageIcon searchImage = new ImageIcon(newSearch);
		btnSearch.setIcon(searchImage);
		
		JLabel studentLabel = new JLabel("Student List");
		studentLabel.setFont(new Font("SansSerif", Font.PLAIN, 14));
		studentLabel.setForeground(SystemColor.textHighlight);
		studentLabel.setBounds(72, 143, 130, 14);
		panel.add(studentLabel);
		
		JLabel greetLabel = new JLabel("Welcome back,");
		greetLabel.setFont(new Font("SansSerif", Font.PLAIN, 12));
		greetLabel.setBounds(799, 143, 84, 14);
		panel.add(greetLabel);
		
		JLabel adminName = new JLabel("Admin");
		adminName.setForeground(new Color(255, 0, 51));
		adminName.setFont(new Font("SansSerif", Font.PLAIN, 12));
		adminName.setBounds(885, 143, 84, 14);
		panel.add(adminName);
	
		
		
//		model=new DefaultTableModel();
//		Object [] column = {"ID", "Email Address", "Full Name", "Mobile", "City", "Province"};
//		Object [] row = new Object[0];
//		model.setColumnIdentifiers(column);
		showAllStudents();
	}
	public void showSearchStudents(StudentModel studentSearchBenarDao){
		   
		   StudentSearchBenarDao getSearchBenarDao = new StudentSearchBenarDao();
	       List<StudentModel> list = getSearchBenarDao.getSearchStudents(studentSearchBenarDao);
	       DefaultTableModel model = (DefaultTableModel)table.getModel();
	       model.setRowCount(0);
	       Object[] row = new Object[6];
	       for(int i = 0; i < list.size(); i++)
	       {
	           row[0] = list.get(i).getId();
	           row[1] = list.get(i).getEmailAddress();
	           row[2] = list.get(i).getFullname();
	           row[3] = list.get(i).getMobile();
	           row[4] = list.get(i).getCity();
	           row[5] = list.get(i).getProvince();
	           
	           model.addRow(row);
	           System.out.println("fr"+i);	       }
	    }
	public void showAllStudents(){
	   
		   StudentGetAllBEnarDao getAllBenarDao = new StudentGetAllBEnarDao();
	       List<StudentModel> list = getAllBenarDao.getAllStudents();
	       DefaultTableModel model = (DefaultTableModel)table.getModel();
	       model.setRowCount(0);
	       Object[] row = new Object[6];
	       for(int i = 0; i < list.size(); i++)
	       {
	           row[0] = list.get(i).getId();
	           row[1] = list.get(i).getEmailAddress();
	           row[2] = list.get(i).getFullname();
	           row[3] = list.get(i).getMobile();
	           row[4] = list.get(i).getCity();
	           row[5] = list.get(i).getProvince();
	           
	           model.addRow(row);
	       }
	    }
	   private void jTable_Display_UsersMouseClicked(java.awt.event.MouseEvent evt) {                                                  
	       // Get The Index Of The Slected Row 
	        int i = table.getSelectedRow();
//	        System.out.println("table clicked");

	        TableModel model = table.getModel();
	        
	         // Display Slected Row In JTexteFields
	        txtID.setText(model.getValueAt(i,0).toString());
	        txtEmailAddress.setText(model.getValueAt(i,1).toString());
	        txtFullname.setText(model.getValueAt(i,2).toString());
	        txtMobile.setText(model.getValueAt(i,3).toString());
	        txtCity.setText(model.getValueAt(i,4).toString());
	        txtProvince.setText(model.getValueAt(i,5).toString());
	        
	        txtID.setForeground(Color.BLACK);	
	        txtEmailAddress.setForeground(Color.BLACK);	
	        txtFullname.setForeground(Color.BLACK);	
	        txtMobile.setForeground(Color.BLACK);	
	        txtCity.setForeground(Color.BLACK);	
	        txtProvince.setForeground(Color.BLACK);	
	    }
	   public void resetInputFields() {
	        txtID.setText("");
	        txtEmailAddress.setText("");
	        txtFullname.setText("");
	        txtMobile.setText("");
	        txtCity.setText("");
	        txtProvince.setText(""); 
	   }
}
