package elimina;

import java.awt.event.ActionEvent;

import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import menu.GraficaMenu;
import support.DBManager;


import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import javax.swing.AbstractAction;
import javax.swing.Action;

/**
 * The Class EliminaDipendente.
 */
public class EliminaDipendente extends JFrame {
	
	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;
	
	/** The content pane. */
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */

	private JTextField textField;
	
	/** The action. */
	private final Action action = new SwingAction();
	
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
	
	/** The text field 9. */
	private JTextField textField_9;
	
	/** The text field 10. */
	private JTextField textField_10;


	/**
	 * Create the frame.
	 */
	public EliminaDipendente() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		int[] metAt = {139, 76, 409, 281};
		setBounds(metAt[0], metAt[1], metAt[2], metAt[3]);
		contentPane = new JPanel();
		int[] met = {5, 5, 5, 5};
		contentPane.setBorder(new EmptyBorder(met[0], met[1], met[2], met[3]));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblModificaDipendenti = new JLabel("Elimina dipendente");
		int[] metA = {11, 11, 106, 23};
		lblModificaDipendenti.setBounds(metA[0], metA[1], metA[2], metA[3]);
		contentPane.add(lblModificaDipendenti);
		
		JLabel lblRicercaDipendente = new JLabel("Ricerca  IDdipendente:");
		int[] metB = {11, 11, 117, 23};
		lblRicercaDipendente.setBounds(metB[0], metB[1], metB[2], metB[3]);
		contentPane.add(lblRicercaDipendente);
		
		JLabel lblNome = new JLabel("Nome");
		int[] metC = {28, 64, 46, 14};
		lblNome.setBounds(metC[0], metC[1], metC[2], metC[3]);
		contentPane.add(lblNome);
		
		JLabel lblCognome = new JLabel("Cognome");
		int[] metD = {28, 89, 46, 14};
		lblCognome.setBounds(metD[0], metD[1], metD[2], metD[3]);
		contentPane.add(lblCognome);
		
		JLabel lblSesso = new JLabel("Sesso");
		int[] metE = {28, 114, 46, 14};
		lblSesso.setBounds(metE[0], metE[1], metE[2], metE[3]);
		contentPane.add(lblSesso);
		
		JLabel lblDataDiNascita = new JLabel("Data di nascita");
		int[] metF = {28, 139, 86, 14};
		lblDataDiNascita.setBounds(metF[0], metF[1], metF[2], metF[3]);
		contentPane.add(lblDataDiNascita);
		
		JLabel lblNewLabel = new JLabel("Mail");
		int[] metG = {28, 164, 46, 14};
		lblNewLabel.setBounds(metG[0], metG[1], metG[2], metG[3]);
		contentPane.add(lblNewLabel);
		
		JLabel lblTelefono = new JLabel("Telefono");
		int[] metH = {28, 189, 46, 14};
		lblTelefono.setBounds(metH[0], metH[1], metH[2], metH[3]);
		contentPane.add(lblTelefono);
		
		
		JLabel lblDomicilio = new JLabel("Domicilio");
		int[] metI = {28, 212, 46, 14};
		lblDomicilio.setBounds(metI[0], metI[1], metI[2], metI[3]);
		contentPane.add(lblDomicilio);
		
		JLabel lblId = new JLabel("ID");
		int[] metL = {231, 89, 18, 14};
		lblId.setBounds(metL[0], metL[1], metL[2], metL[3]);
		contentPane.add(lblId);
		
		JLabel lblNewLabel_1 = new JLabel("CF");
		int[] metM = {231, 114, 18, 14};
		lblNewLabel_1.setBounds(metM[0], metM[1], metM[2], metM[3]);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblMansione = new JLabel("Mansione");
		int[] metN = {228, 64, 46, 14};
		lblMansione.setBounds(metN[0], metN[1], metN[2], metN[3]);
		contentPane.add(lblMansione);
		
		textField = new JTextField();
		textField.addActionListener(new ActionListener() {
			/**
			 * actionPerformed
			 */
			public void actionPerformed(ActionEvent e) {

				String id = textField.getText();
				
				String query = "SELECT * FROM dipendente WHERE ID_Dipendente = ?";

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
		
		int[] metO = {229, 11, 57, 23};
		textField.setBounds(metO[0], metO[1], metO[2], metO[3]);
		contentPane.add(textField);
		textField.setColumns(10);		
		
		JButton btnOk = new JButton("OK");
		btnOk.addActionListener(new ActionListener() {
			/**
			 * actionPerformed
			 */
			public void actionPerformed(ActionEvent e) {
				String id = textField.getText();
				String query = "SELECT * FROM dipendente WHERE ID_Dipendente = ?";
				DBManager mysql = DBManager.getInstance();
				ResultSet rs = mysql.querySelect(query, id);
			    
				try {

					if(rs.next()){

						String nome= rs.getString("Nome");
				       
						String cognome= rs.getString("Cognome");
				      
						String sesso= rs.getString("Sesso");
				      
						String data= rs.getString("Data_Di_Nascita");
				       
						String mail= rs.getString("Mail");
				      
						String numero= rs.getString("Telefono");
				       
						String domicilio= rs.getString("Domicilio");
				       
						String mansione= rs.getString("Mansione");
				       
						String id1= rs.getString("ID_Dipendente");
				      
						String cf= rs.getString("CF");				       
				       
						textField_1.setText(nome);
						textField_2.setText(cognome);
						textField_3.setText(sesso);
						textField_4.setText(data);
						textField_5.setText(mail);
						textField_6.setText(numero);
				       	textField_7.setText(domicilio);
				       	textField_8.setText(mansione);
				       	textField_9.setText(id1);
				       	textField_10.setText(cf);				       
				      }
				      else{
				    	  JOptionPane.showMessageDialog(null, "Errore");
				      }
				    
				} catch (SQLException e1) {
					JOptionPane.showMessageDialog(null, "Errore");
				}
			}
		});
		
		int[] metP = {294, 11, 89, 23};
		btnOk.setBounds(metP[0], metP[1], metP[2], metP[3]);
		contentPane.add(btnOk);
		
		JButton btnElimina = new JButton("Elimina");
		btnElimina.setAction(action);
		int[] metQ = {278, 208, 89, 23};
		btnElimina.setBounds(metQ[0], metQ[1], metQ[2], metQ[3]);
		contentPane.add(btnElimina);
		
		textField_1 = new JTextField();
		int[] metR = {84, 61, 127, 20};
		textField_1.setBounds(metR[0], metR[1], metR[2], metR[3]);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		int[] metS = {84, 86, 108, 20};
		textField_2.setBounds(metS[0], metS[1], metS[2], metS[3]);
		contentPane.add(textField_2);
		textField_2.setColumns(10);
		
		textField_3 = new JTextField();
		int[] metT = {84, 111, 86, 20};
		textField_3.setBounds(metT[0], metT[1], metT[2], metT[3]);
		contentPane.add(textField_3);
		textField_3.setColumns(10);
		
		textField_4 = new JTextField();
		int[] metU = {114, 136, 105, 20};
		textField_4.setBounds(metU[0], metU[1], metU[2], metU[3]);
		contentPane.add(textField_4);
		textField_4.setColumns(10);
		
		textField_5 = new JTextField();
		int[] metV = {68, 161, 124, 20};
		textField_5.setBounds(metV[0], metV[1], metV[2], metV[3]);
		contentPane.add(textField_5);
		textField_5.setColumns(10);
		
		textField_6 = new JTextField();
		int[] metW = {84, 186, 108, 20};
		textField_6.setBounds(metW[0], metW[1], metW[2], metW[3]);
		contentPane.add(textField_6);
		textField_6.setColumns(10);
		
		textField_7 = new JTextField();
		int[] metX = {84, 209, 147, 20};
		textField_7.setBounds(metX[0], metX[1], metX[2], metX[3]);
		contentPane.add(textField_7);
		textField_7.setColumns(10);
		
		textField_8 = new JTextField();
		int[] metY = {284, 61, 99, 20};
		textField_8.setBounds(metY[0], metY[1], metY[2], metY[3]);
		contentPane.add(textField_8);
		textField_8.setColumns(10);
		
		textField_9 = new JTextField();
		int[] metZ = {259, 86, 86, 20};
		textField_9.setBounds(metZ[0], metZ[1], metZ[2], metZ[3]);
		contentPane.add(textField_9);
		textField_9.setColumns(10);
		
		textField_10 = new JTextField();
		int[] metZa = {259, 111, 124, 20};
		textField_10.setBounds(metZa[0], metZa[1], metZa[2], metZa[3]);
		contentPane.add(textField_10);
		textField_10.setColumns(10);
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
			putValue(NAME, "Elimina");
			putValue(SHORT_DESCRIPTION, "Some short description");
		}
		
		/**
		 * actionPerformed.
		 *
		 * @param e the e
		 */
		public void actionPerformed(ActionEvent e) {
			String id = textField.getText();
			String query = "DELETE FROM dipendente WHERE ID_Dipendente = ?";
			DBManager mysql = DBManager.getInstance();
			mysql.query(query, id);			
		}
	}
}
