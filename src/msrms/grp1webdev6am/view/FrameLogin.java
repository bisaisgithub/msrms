package msrms.grp1webdev6am.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.JOptionPane;

import msrms.grp1webdev6am.controller.LoginDAO;
import msrms.grp1webdev6am.model.LoginModel;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.Objects;
import javax.swing.JPasswordField;

public class FrameLogin extends JFrame {

	private JPanel contentPane;
	private JTextField txtEmailAddressLogin;
	private JPasswordField txtPasswordLogin;


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrameLogin frame = new FrameLogin();
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
	public FrameLogin() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1000, 700);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel_2 = new JLabel("Student Record Management System (MSMMS)");
		lblNewLabel_2.setFont(new Font("SansSerif", Font.PLAIN, 11));
		lblNewLabel_2.setBounds(103, 276, 295, 14);
		contentPane.add(lblNewLabel_2);
		
		txtEmailAddressLogin = new JTextField();
		txtEmailAddressLogin.setColumns(10);
		txtEmailAddressLogin.setBounds(103, 350, 312, 31);
		contentPane.add(txtEmailAddressLogin);
		
		JLabel lblEmailAddressLogin = new JLabel("Email Address");
		lblEmailAddressLogin.setFont(new Font("SansSerif", Font.PLAIN, 11));
		lblEmailAddressLogin.setBounds(103, 335, 99, 14);
		contentPane.add(lblEmailAddressLogin);
		
		JLabel lblPasswordLogin = new JLabel("Password");
		lblPasswordLogin.setFont(new Font("SansSerif", Font.PLAIN, 11));
		lblPasswordLogin.setBounds(103, 386, 99, 14);
		contentPane.add(lblPasswordLogin);
		
		JButton btnLogin = new JButton("LOGIN");
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
					String emailAddress = txtEmailAddressLogin.getText();
					String password = txtPasswordLogin.getText();
					
					LoginModel loginModelFrame = new LoginModel();
					
					loginModelFrame.setEmailAddress(emailAddress);
					loginModelFrame.setPassword(password);
//					System.out.println(loginModel.getEmailAddress());
//					System.out.println(loginModel.getPassword());
					
					LoginDAO loginDAO = new LoginDAO();
					
					LoginModel loginModelDB = loginDAO.authenticateUser(loginModelFrame);
					
					System.out.println(loginModelFrame.getEmailAddress());
					System.out.println(loginModelFrame.getPassword());
					System.out.println(loginModelDB.getEmailAddress());
					System.out.println(loginModelDB.getPassword());
					
					if(loginModelFrame.getEmailAddress().equals(loginModelDB.getEmailAddress())) {
						System.out.println("FrameLogin Login Success");
						dispose();
						FrameStudent frameStudent = new FrameStudent();
						frameStudent.show();
					}else {
						JOptionPane.showMessageDialog(null, "Email Address or Password Invalid");
						System.out.println("FrameLogin Login Failed");
						txtEmailAddressLogin.setText("");
						txtPasswordLogin.setText("");
					}
					
					
					
					
//					if(userValidate.equals("SUCCESS")) {
//						System.out.println();
//						System.out.println("Success Login FramLogin");
//					}else {
//						System.out.println("Fail Login FrameLogin");
//					}
					
				}catch(Exception e1){
					e1.printStackTrace();
				}
			}
		});
		btnLogin.setBorder(null);
		btnLogin.setForeground(Color.WHITE);
		btnLogin.setFont(new Font("SansSerif", Font.PLAIN, 11));
		btnLogin.setBackground(new Color(63, 146, 209));
		btnLogin.setBounds(103, 443, 312, 31);
		contentPane.add(btnLogin);
		
		txtPasswordLogin = new JPasswordField();
		txtPasswordLogin.setBounds(103, 402, 312, 31);
		contentPane.add(txtPasswordLogin);
		
		JLabel lblBackgroundLogin = new JLabel("New label");
		lblBackgroundLogin.setIcon(new ImageIcon("C:\\Users\\mar\\eclipse-proj1\\msrms\\src\\img\\loginForm.jpg"));
		lblBackgroundLogin.setBounds(0, 0, 1000, 700);
		contentPane.add(lblBackgroundLogin);
		setLocationRelativeTo(null);
	}
}
