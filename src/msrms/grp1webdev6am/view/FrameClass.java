package msrms.grp1webdev6am.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class FrameClass extends JFrame {

	private JPanel contentPane;
	DefaultTableModel model;
	private JTable table;
	private JScrollPane scrollPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrameClass frame = new FrameClass();
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
	public FrameClass() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1000, 700);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		panel.setBounds(0, 0, 986, 663);
		contentPane.add(panel);
		panel.setLayout(null);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(67, 135, 857, 474);
		panel.add(scrollPane);
		
		table = new JTable();
		table.setColumnSelectionAllowed(true);
		table.setCellSelectionEnabled(true);
		table.setFont(new Font("Tahoma", Font.PLAIN, 30));
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"ID", "Email Address", "Full Name", "Class Name", "Instructor", "Status"
			}
		));
		scrollPane.setViewportView(table);
		
		textField = new JTextField();
		textField.setBounds(67, 100, 143, 25);
		panel.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(209, 100, 143, 25);
		panel.add(textField_1);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(352, 100, 143, 25);
		panel.add(textField_2);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(494, 100, 143, 25);
		panel.add(textField_3);
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setBounds(635, 100, 143, 25);
		panel.add(textField_4);
		
		textField_5 = new JTextField();
		textField_5.setColumns(10);
		textField_5.setBounds(776, 100, 143, 25);
		panel.add(textField_5);
		
		JButton btnAdd = new JButton("");
		btnAdd.setBackground(Color.WHITE);
		btnAdd.setBorder(null);
		btnAdd.setIcon(new ImageIcon("C:\\Users\\mar\\eclipse-proj1\\msrms\\src\\img\\add.png"));
		btnAdd.setBounds(871, 57, 39, 33);
		panel.add(btnAdd);
		
		JButton btnEdit = new JButton("");
		btnEdit.setBackground(Color.WHITE);
		btnEdit.setBorder(null);
		btnEdit.setIcon(new ImageIcon("C:\\Users\\mar\\eclipse-proj1\\msrms\\src\\img\\edit.png"));
		btnEdit.setBounds(67, 51, 45, 39);
		panel.add(btnEdit);
		
		JButton btnDelete = new JButton("");
		btnDelete.setBackground(Color.WHITE);
		btnDelete.setBorder(null);
		btnDelete.setIcon(new ImageIcon("C:\\Users\\mar\\eclipse-proj1\\msrms\\src\\img\\delete.png"));
		btnDelete.setBounds(122, 51, 45, 39);
		panel.add(btnDelete);
		
		JButton btnSearch = new JButton("");
		btnSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnSearch.setBackground(Color.WHITE);
		btnSearch.setBorder(null);
		btnSearch.setIcon(new ImageIcon("C:\\Users\\mar\\eclipse-proj1\\msrms\\src\\img\\search.png"));
		btnSearch.setBounds(177, 51, 45, 39);
		panel.add(btnSearch);
		model=new DefaultTableModel();
		Object [] column = {"ID", "Email Address", "Full Name", "Class Name", "Instructor", "Status"};
		Object [] row = new Object[0];
		model.setColumnIdentifiers(column);
	}
}
