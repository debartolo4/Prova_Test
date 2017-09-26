package modifica;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import control.Controlli;
import enums.Table;
import menu.GraficaMenu;
import support.DBManager;


import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.AbstractAction;
import java.awt.event.ActionEvent;

import java.sql.Date;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.Action;
import java.awt.event.ActionListener;


/**
 * The Class ModificaDipendente.
 */
public class ModificaDipendente extends JFrame {

	
	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;
	
	/** The content pane. */
	private JPanel contentPane;
	
	/** The text field. */
	private JTextField textField;
	
	/** The text field 1. */
	private JTextField textField_1;
	
	/** The text field 2. */
	private JTextField textField_2;
	
	/** The text field 3. */
	private JTextField textField_3;
	
	/** The text field 4. */
	private JTextField textField_4;
	
	/** The text field 5. */
	private JTextField textField_5;
	
	/** The text field 6. */
	private JTextField textField_6;
	
	/** The text field 7. */
	private JTextField textField_7;
	
	/** The text field 8. */
	private JTextField textField_8;
	
	/** The action. */
	private final Action action = new SwingAction();
	
	/** The text field 9. */
	private JTextField textField_9;
	
	/** The text field 10. */
	private JTextField textField_10;



	/**
	 * Create the frame.
	 */
	
	public ModificaDipendente() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblAggiungiDipendenti = new JLabel("Modifica dipendente");
		lblAggiungiDipendenti.setBounds(10, 0, 119, 39);
		contentPane.add(lblAggiungiDipendenti);
		
		JLabel lblNome = new JLabel("Nome");
		lblNome.setBounds(28, 64, 46, 14);
		contentPane.add(lblNome);
		
		JLabel lblCognome = new JLabel("Cognome");
		lblCognome.setBounds(28, 89, 46, 14);
		contentPane.add(lblCognome);
		
		JLabel lblSesso = new JLabel("Sesso");
		lblSesso.setBounds(28, 114, 46, 14);
		contentPane.add(lblSesso);
		
		JLabel lblDataDiNascita = new JLabel("Data di nascita");
		lblDataDiNascita.setBounds(28, 139, 89, 14);
		contentPane.add(lblDataDiNascita);
		
		JLabel lblNewLabel = new JLabel("Mail");
		lblNewLabel.setBounds(28, 164, 46, 14);
		contentPane.add(lblNewLabel);
		
		JLabel lblTelefono = new JLabel("Telefono");
		lblTelefono.setBounds(28, 189, 46, 14);
		contentPane.add(lblTelefono);
		
		JLabel lblDomicilio = new JLabel("Domicilio");
		lblDomicilio.setBounds(28, 212, 46, 14);
		contentPane.add(lblDomicilio);
		
		textField = new JTextField();
		textField.setBounds(109, 61, 86, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(109, 86, 86, 20);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setBounds(109, 111, 86, 20);
		contentPane.add(textField_2);
		textField_2.setColumns(10);
		
		textField_3 = new JTextField();
		textField_3.setBounds(109, 136, 86, 20);
		contentPane.add(textField_3);
		textField_3.setColumns(10);
		
		textField_4 = new JTextField();
		textField_4.setBounds(109, 158, 86, 20);
		contentPane.add(textField_4);
		textField_4.setColumns(10);
		
		textField_5 = new JTextField();
		textField_5.setBounds(109, 186, 86, 20);
		contentPane.add(textField_5);
		textField_5.setColumns(10);
		
		textField_6 = new JTextField();
		textField_6.setBounds(109, 209, 86, 20);
		contentPane.add(textField_6);
		textField_6.setColumns(10);
		
		JLabel lblId = new JLabel("ID");
		lblId.setBounds(231, 89, 18, 14);
		contentPane.add(lblId);
		
		textField_7 = new JTextField();
		textField_7.setBounds(282, 86, 86, 20);
		contentPane.add(textField_7);
		textField_7.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("CF");
		lblNewLabel_1.setBounds(231, 114, 18, 14);
		contentPane.add(lblNewLabel_1);
		
		textField_8 = new JTextField();
		textField_8.setBounds(282, 111, 86, 20);
		contentPane.add(textField_8);
		textField_8.setColumns(10);
		
		JButton btnNewButton = new JButton("Ok");
		btnNewButton.setAction(action);
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnNewButton.setBounds(267, 149, 110, 39);
		contentPane.add(btnNewButton);
		
		JLabel lblMansione = new JLabel("Mansione");
		lblMansione.setBounds(228, 64, 46, 14);
		contentPane.add(lblMansione);
		
		textField_9 = new JTextField();
		textField_9.setBounds(282, 61, 86, 20);
		contentPane.add(textField_9);
		textField_9.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Ricerca per ID:");
		lblNewLabel_2.setBounds(130, 6, 107, 27);
		contentPane.add(lblNewLabel_2);
		
		textField_10 = new JTextField();
		
		textField_10.addActionListener(new ActionListener() {
			/**
			 * actionPerformed
			 */
			public void actionPerformed(ActionEvent arg0) {
				String id = textField_10.getText();
				
				String query = "SELECT * FROM mydipendente WHERE ID_Dipendente = ?";
				DBManager mysql = DBManager.getInstance();
				ResultSet rs = mysql.querySelect(query, id);
			    
				try {

				      if(rs.next()){
				        
				
				    	  GraficaMenu window = new GraficaMenu();
				  
				    	  window.setVisible(true);
				    	  window.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
				    	  contentPane.setVisible(false);
						
				      }
				      
				    
				} catch (SQLException e1) {
					JOptionPane.showMessageDialog(null, "Errore");
				}

			}
		});
		textField_10.setBounds(215, 9, 86, 20);
		contentPane.add(textField_10);
		textField_10.setColumns(10);
		
		JButton btnOk = new JButton("Ok");
		btnOk.setBounds(321, 8, 89, 23);
		contentPane.add(btnOk);
		
		btnOk.addActionListener(new ActionListener() {
			/**
			 * actionPerformed
			 */
			public void actionPerformed(ActionEvent e) {
				String id = textField_10.getText();
				String query = "SELECT * FROM mydipendente WHERE ID_Dipendente = ?";
				DBManager mysql = DBManager.getInstance();
				ResultSet rs = mysql.querySelect(query, id);
			    
				try {

				      if(rs.next()){
				       String nome= rs.getString("Nome");
				       
				       String cognome= rs.getString("Cognome");
				      
				       String sesso= rs.getString("Sesso");
				      
				       String data= rs.getString("data_di_nascita");
				       
				       String mail= rs.getString("Mail");
				      
				       String numero= rs.getString("Telefono");
				       
				       String domicilio= rs.getString("Domicilio");
				       
				       String mansione= rs.getString("Mansione");
				       
				       String id1= rs.getString("ID_Dipendente");
				      
				       String cf= rs.getString("CF");
				       
				       textField.setText(nome);
				       textField_1.setText(cognome);
				       textField_2.setText(sesso);
				       textField_3.setText(data);
				       textField_4.setText(mail);
				       textField_5.setText(numero);
				       textField_6.setText(domicilio);
				       textField_9.setText(mansione);
				       textField_7.setText(id1);
				       textField_8.setText(cf);
				       
				       
				      }
				      else{
				    	  JOptionPane.showMessageDialog(null, "Errore");
				      }
				    
				} catch (SQLException e1) {
					JOptionPane.showMessageDialog(null, "Errore");
				}
			}
		});
		
	
	}
	
	/**
	 * The Class SwingAction.
	 *
	 * @SwingAction 
	 */
	private class SwingAction extends AbstractAction {
		
		/** The Constant serialVersionUID. */
		private static final long serialVersionUID = 1L;
		
		/**
		 * Instantiates a new swing action.
		 *
		 * @SwingAction 
		 */
		public SwingAction() {
			putValue(NAME, "Modifica");
			putValue(SHORT_DESCRIPTION, "Some short description");
		}
		
		/**
		 * actionPerformed.
		 *
		 * @param e the e
		 */
		public void actionPerformed(ActionEvent e) {
			ArrayList<JTextField> textList = new ArrayList<>();
			
			Controlli c = new Controlli();
			boolean on = false;
			try {
				on = c.controlChar(textField, textField_1, textField_9)&& c.controlSex(textField_2) &&
						c.controlDate(textField_3) && c.controlEmail(textField_4) 
						&& c.controlPhoneNumber(textField_5) && c.controlAddress(textField_6)
						&& c.controlId(textField_7, Table.DIPENDENTE)
						&& c.controlCf(textField_8);
			} catch (Exception e3) {
				e3.printStackTrace();
			}
			
			if(on) {
				textList.add(textField);
				textList.add(textField_1);
				textList.add(textField_2);
				textList.add(textField_3);
				textList.add(textField_4);
				textList.add(textField_5);
				textList.add(textField_6);
				textList.add(textField_9);
				textList.add(textField_7);
				textList.add(textField_8);
				
				if(textList.isEmpty()) {
					
					String query = "UPDATE mydipendente SET Nome= ? AND"
							+ "Cognome= ? AND Sesso= ? AND"
							+ "data_di_nascita = ? AND Mail= ? AND"
							+ "Telefono= ? AND Domicilio= ? AND"
							+ "Mansione= ? AND ID_Dipendente= ? AND CF= ? WHERE ID_Dipendente = ? ;";
						
						
					
					DBManager mysql = DBManager.getInstance();
					mysql.query(query,textField.getText(), textField_1.getText(), textField_2.getText(),
							textField_3.getText(), textField_4.getText(), textField_5.getText(),
							textField_6.getText(), textField_9.getText(), textField_7.getText(),
							textField_8.getText(), textField_10.getText());
					
				
			
				}
			}	
		}
	}
}