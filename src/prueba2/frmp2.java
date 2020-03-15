package prueba2;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import java.awt.BorderLayout;
import javax.swing.JTable;
import javax.swing.JButton;
import java.awt.Color;
import javax.swing.JPanel;
import net.miginfocom.swing.MigLayout;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class frmp2 {

	private JFrame frame;
	private JTable table;
	private JTextField txtid_prod;
	private JTextField txtnombre;
	private JTextField txtprecio;
	private JTextField txtid_catego;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frmp2 window = new frmp2();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	conectar cnn = new conectar();
	
	/**
	 * Create the application.
	 */
	public frmp2() {
		initialize();
		conectar cnn = new conectar();
	cnn.mostrar(table);
	}
	

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 761, 404);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JScrollPane scrollPane = new JScrollPane();
		
		txtid_prod = new JTextField();
		txtid_prod.setColumns(10);
		
		txtnombre = new JTextField();
		txtnombre.setColumns(10);
		
		txtprecio = new JTextField();
		txtprecio.setColumns(10);
		
		txtid_catego = new JTextField();
		txtid_catego.setColumns(10);
		
		JButton btnNewButton = new JButton("insertar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int id_prod=Integer.parseInt(txtid_prod.getText());
				String nombre =txtnombre.getText();
				int precio=Integer.parseInt(txtprecio.getText());
				int idcat=Integer.parseInt(txtid_catego.getText());
				cnn.insertar(id_prod, nombre, precio, idcat);
				cnn.mostrar(table);
				
			}
		});
		GroupLayout groupLayout = new GroupLayout(frame.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 446, GroupLayout.PREFERRED_SIZE)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(txtid_prod, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(txtprecio, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addGap(28)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(txtid_catego, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(txtnombre, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(71)
							.addComponent(btnNewButton)))
					.addContainerGap(83, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 336, GroupLayout.PREFERRED_SIZE)
						.addGroup(groupLayout.createSequentialGroup()
							.addContainerGap()
							.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(txtid_prod, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(txtnombre, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addGap(18)
							.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(txtprecio, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(txtid_catego, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addGap(39)
							.addComponent(btnNewButton)))
					.addContainerGap(29, Short.MAX_VALUE))
		);
		
		table = new JTable();
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				if (e.getClickCount()==2) {
					int fila=table.getSelectedRow();
					txtid_prod.setText(table.getValueAt(fila, 0).toString());
					txtnombre.setText(table.getValueAt(fila, 1).toString());
					txtprecio.setText(table.getValueAt(fila, 2).toString());
					txtid_catego.setText(table.getValueAt(fila, 3).toString());
					
				}
			}
		});
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{null},
			},
			new String[] {
				"New column"
			}
		));
		scrollPane.setViewportView(table);
		frame.getContentPane().setLayout(groupLayout);
	}
}
