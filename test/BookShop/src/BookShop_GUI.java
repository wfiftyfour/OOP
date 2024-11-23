import java.awt.EventQueue;
import java.sql.*;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class BookShop_GUI {

	private JFrame frame;
	private JTextField textbname;
	private JTextField textedition;
	private JTextField textprice;
	private JTable table;
	private JTextField textbid;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BookShop_GUI window = new BookShop_GUI();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	Connection con;
	PreparedStatement pst;
	ResultSet rs;

	/**
	 * Create the application.
	 */
	
	

	    
	    public void populateTable(JTable table, ResultSet rs) throws SQLException {
	        ResultSetMetaData metaData = rs.getMetaData();
	        int columnCount = metaData.getColumnCount();
	        
	        DefaultTableModel tableModel = new DefaultTableModel();

	        for (int columnIndex = 1; columnIndex <= columnCount; columnIndex++) {
	            tableModel.addColumn(metaData.getColumnName(columnIndex));
	        }

	        Object[] rowData = new Object[columnCount];
	        while (rs.next()) {
	            for (int columnIndex = 1; columnIndex <= columnCount; columnIndex++) {
	                rowData[columnIndex - 1] = rs.getObject(columnIndex);
	            }
	            tableModel.addRow(rowData);
	        }

	        table.setModel(tableModel);
	    }
	
	
	
	
	public BookShop_GUI() {
		initialize();
		connect();
		tableLoad();
	}
	
	

	public void connect() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/BookShop_db","root","");
		}
		catch(ClassNotFoundException ex) {
			
		}
		catch(SQLException ex) {
			
		}
	}
	public void tableLoad() {
		try {
			pst = con.prepareStatement("Select * from book");
			rs = pst.executeQuery();
			populateTable(table, rs);
		}
		catch(SQLException m){
			m.printStackTrace();
		}
	}
	
	


	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 918, 610);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Book Shop");
		lblNewLabel.setBounds(350, -4, 162, 42);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 30));
		frame.getContentPane().add(lblNewLabel);
		
		JPanel panel = new JPanel();
		panel.setBounds(32, 160, 295, 182);
		panel.setBorder(new TitledBorder(null, "Registration", TitledBorder.LEADING, TitledBorder.ABOVE_TOP, null, null));
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("Book Name");
		lblNewLabel_1.setFont(new Font("Apple Symbols", Font.BOLD, 15));
		lblNewLabel_1.setBounds(31, 56, 61, 16);
		panel.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Edition");
		lblNewLabel_2.setFont(new Font("Apple Symbols", Font.BOLD, 15));
		lblNewLabel_2.setBounds(31, 102, 61, 16);
		panel.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Price");
		lblNewLabel_3.setFont(new Font("Apple Symbols", Font.BOLD, 15));
		lblNewLabel_3.setBounds(31, 149, 61, 16);
		panel.add(lblNewLabel_3);
		
		textbname = new JTextField();
		textbname.setBounds(120, 49, 130, 26);
		panel.add(textbname);
		textbname.setColumns(10);
		
		textedition = new JTextField();
		textedition.setBounds(120, 95, 130, 26);
		panel.add(textedition);
		textedition.setColumns(10);
		
		textprice = new JTextField();
		textprice.setBounds(120, 142, 130, 26);
		panel.add(textprice);
		textprice.setColumns(10);
		
		JButton btnNewButton = new JButton("Save");
		btnNewButton.setBounds(32, 433, 90, 29);
		btnNewButton.setFont(new Font("Lucida Grande", Font.PLAIN, 13));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				String bname, edition, price;
				bname = textbname.getText();
				edition = textedition.getText();
				price = textprice.getText();

				try {
				    pst = con.prepareStatement("SELECT * FROM book WHERE name = ? AND edition = ? AND price = ?");
				    pst.setString(1, bname);
				    pst.setString(2, edition);
				    pst.setString(3, price);
				    
				    rs = pst.executeQuery();
				    
				    if (rs.next()) {
				        JOptionPane.showMessageDialog(null, "Book already exists!");
				    } else {
				        pst = con.prepareStatement("INSERT INTO book(name, edition, price) VALUES(?, ?, ?)");
				        pst.setString(1, bname);
				        pst.setString(2, edition);
				        pst.setString(3, price);
				        pst.executeUpdate();
				        JOptionPane.showMessageDialog(null, "Book added successfully!");
				        tableLoad();
				        textbname.setText("");
				        textedition.setText("");
				        textprice.setText("");
				        textbname.requestFocus();
				    }
				}
				catch (SQLException e) {
				    e.printStackTrace();
				}
			}
		});

//				try {
//					pst = con.prepareStatement("insert into book(name, edition, price)values(?, ?, ?)");
//					pst.setString(1, bname);
//					pst.setString(2, edition);
//					pst.setString(3, price);
//					pst.executeUpdate();
//					JOptionPane.showMessageDialog(null, "Book added!");
//					tableLoad();
//					textbname.setText("");
//					textedition.setText("");
//					textprice.setText("");
//					textbname.requestFocus();
//				}
//				catch(SQLException e1) {
//					e1.printStackTrace();
//				}
//			}
		
		frame.getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Exit");
		btnNewButton_1.setBounds(134, 433, 90, 29);
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		frame.getContentPane().add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Clear");
		btnNewButton_2.setBounds(236, 433, 91, 29);
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textbname.setText("");
				textedition.setText("");
				textprice.setText("");
				textbid.setText("");
			}
		});
		frame.getContentPane().add(btnNewButton_2);
		
		JScrollPane bookTable = new JScrollPane();
		bookTable.setBounds(452, 50, 427, 359);
		frame.getContentPane().add(bookTable);
		
		table = new JTable();
		bookTable.setViewportView(table);

		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(32, 54, 295, 53);
		panel_1.setBorder(new TitledBorder(null, "Search Bar", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		frame.getContentPane().add(panel_1);
		panel_1.setLayout(null);
		
		textbid = new JTextField();
		textbid.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent arg0) {
				try {
					String id = textbid.getText();
					pst = con.prepareStatement("Select name, edition, price from book where id = ?");
					pst.setString(1, id);
					ResultSet rs = pst.executeQuery();
					
					if(rs.next() == true) {
						String name = rs.getString(1);
						String edition = rs.getString(2);
						String price = rs.getString(3);
						textbname.setText(name);
						textedition.setText(edition);
						textprice.setText(price);
					}else {
						textbname.setText("");
						textedition.setText("");
						textprice.setText("");
					}
				}
				catch(SQLException d) {
					
				}
			}
		});
		textbid.setColumns(10);
		textbid.setBounds(110, 13, 130, 26);
		panel_1.add(textbid);
		
		JLabel lblNewLabel_2_1 = new JLabel("Book ID");
		lblNewLabel_2_1.setFont(new Font("Apple Symbols", Font.BOLD, 15));
		lblNewLabel_2_1.setBounds(37, 20, 61, 16);
		panel_1.add(lblNewLabel_2_1);
		
		JButton btnNewButton_3 = new JButton("Update");
		btnNewButton_3.setBounds(462, 421, 117, 53);
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				String bname, edition, price, bid;
				bname = textbname.getText();
				edition = textedition.getText();
				price = textprice.getText();
				bid = textbid.getText();

				if (bid.isEmpty()) {
				    JOptionPane.showMessageDialog(null, "ID cannot be empty!");
				    return;
				}
				if (bname.isEmpty() || edition.isEmpty() || price.isEmpty()) {
				    JOptionPane.showMessageDialog(null, "Fields cannot be empty!");
				    return;
				}

				try {
				    pst = con.prepareStatement("update book set name = ?, edition = ?, price = ? where id = ?");
				    pst.setString(1, bname);
				    pst.setString(2, edition);
				    pst.setString(3, price);
				    pst.setString(4, bid);
				    pst.executeUpdate();
				    JOptionPane.showMessageDialog(null, "Book updated!");
				    tableLoad();  
				    textbname.setText("");
				    textedition.setText("");
				    textprice.setText("");
				    textbname.requestFocus();
				}
				catch(SQLException k) {
				    JOptionPane.showMessageDialog(null, "Error updating book: " + k.getMessage());
				}

				
//				String bname, edition, price, bid;
//				bname = textbname.getText();
//				edition = textedition.getText();
//				price = textprice.getText();
//				bid = textbid.getText();
//				try {
//					pst = con.prepareStatement("update book set name = ?, edition = ?, price = ? where id = ?");
//					pst.setString(1, bname);
//					pst.setString(2, edition);
//					pst.setString(3, price);
//					pst.setString(4, bid);
//					pst.executeUpdate();
//					JOptionPane.showMessageDialog(null, "Book updated!");
//					tableLoad();
//					textbname.setText("");
//					textedition.setText("");
//					textprice.setText("");
//					textbname.requestFocus();
//				}
//				catch(SQLException k) {
//					
//				}
			}
		});
		frame.getContentPane().add(btnNewButton_3);
		
		JButton btnNewButton_4 = new JButton("Delete");
		btnNewButton_4.setBounds(762, 421, 117, 53);
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				String bid;
				bid = textbid.getText();
				try {
					pst = con.prepareStatement("delete from book where id = ?");
					pst.setString(1, bid);
					pst.executeUpdate();
					JOptionPane.showMessageDialog(null, "Book deleted");
					tableLoad();
					textbname.setText("");
					textedition.setText("");
					textprice.setText("");
					textbname.requestFocus();
				}
				catch(SQLException j) {
					
				}
			}
		});
		frame.getContentPane().add(btnNewButton_4);
		frame.setResizable(false);
	}
}
	

