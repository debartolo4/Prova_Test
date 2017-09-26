package aggiungi;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.util.ArrayList;

import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import control.Controlli;
import enums.Table;
import support.DBManager;

/**
 * The Class NuovoSpazio.
 */
public class NuovoSpazio extends JFrame {

	
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
	
	/** The action. */
	private final Action action = new SwingAction();

	/**
	 * Create the frame.
	 */
	public NuovoSpazio() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		int[] ret = {100, 100, 450, 300};
		setBounds(ret[0], ret[1], ret[2], ret[3]);
		contentPane = new JPanel();
		int[] retA = {5, 5, 5, 5};
		contentPane.setBorder(new EmptyBorder(retA[0], retA[1], retA[2], retA[3]));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblAggiungiSpazio = new JLabel("Aggiungi Spazio");
		int[] retB = {161, 28, 127, 14};
		lblAggiungiSpazio.setBounds(retB[0], retB[1], retB[2], retB[3]);
		contentPane.add(lblAggiungiSpazio);
		
		JLabel lblId = new JLabel("ID");
		int[] retC = {92, 70, 18, 14};
		lblId.setBounds(retC[0], retC[1], retC[2], retC[3]);
		contentPane.add(lblId);
		
		JLabel lblNome = new JLabel("Nome");
		int[] retD = {92, 111, 36, 14};
		lblNome.setBounds(retD[0], retD[1], retD[2], retD[3]);
		contentPane.add(lblNome);
		
		JLabel lblDescrizione = new JLabel("Descrizione");
		int[] retE = {92, 149, 64, 14};
		lblDescrizione.setBounds(retE[0], retE[1], retE[2], retE[3]);
		contentPane.add(lblDescrizione);
		
		textField = new JTextField();
		int[] retF = {161, 67, 86, 20};
		textField.setBounds(retF[0], retF[1], retF[2], retF[3]);
		contentPane.add(textField);
		int lol = 10;
		textField.setColumns(lol);
		
		textField_1 = new JTextField();
		int[] retG = {161, 111, 86, 20};
		textField_1.setBounds(retG[0], retG[1], retG[2], retG[3]);
		contentPane.add(textField_1);
		textField_1.setColumns(lol);
		
		textField_2 = new JTextField();
		int[] retH = {161, 149, 86, 20};
		textField_2.setBounds(retH[0], retH[1], retH[2], retH[3]);
		contentPane.add(textField_2);
		textField_2.setColumns(lol);
		
		JButton btnAggiungi = new JButton("AGGIUNGI");
		btnAggiungi.setAction(action);
		btnAggiungi.setFont(new Font("Tahoma", Font.PLAIN, 24));
		int[] retI = {146, 205, 162, 45};
		btnAggiungi.setBounds(retI[0], retI[1], retI[2], retI[3]);
		contentPane.add(btnAggiungi);
		
	
		
		
		
	}
	
	/**
	 * SwingAction.
	 */
	private class SwingAction extends AbstractAction {
		
		/** The Constant serialVersionUID. */
		private static final long serialVersionUID = 1L;
		
		/**
		 * Instantiates a new swing action.
		 */
		public SwingAction() {
			putValue(NAME, "AGGIUNGI");
			putValue(SHORT_DESCRIPTION, "Some short description");
			
			
						
			
		}
		
		/**
		 * actionPerformed.
		 *
		 * @param e the e
		 */
		public void actionPerformed(ActionEvent e) {
			Controlli c = new Controlli();
			ArrayList<JTextField> textList = new ArrayList<>();
			
			boolean on = false;
			
			try {
				on = c.controlId(textField, Table.SPAZIO) && c.controlChar(textField_1, textField_2);
			} catch (Exception e2) {
				e2.printStackTrace();
			}
			
			
			if(on) {
				textList.add(textField);
				textList.add(textField_1);
				textList.add(textField_2);
				if(!textList.isEmpty()) {
					String query = null;
					try {
						query = c.getQuery(textList, Table.SPAZIO, "ID_Spazio", "Nome", "Descrizione");
					} catch (Exception e1) {
						e1.printStackTrace();
					}
					
					
					JLabel lblSpazioAggiuntoCon = new JLabel("Spazio aggiunto con successo");
					int[] retL = {146, 180, 213, 14};
					lblSpazioAggiuntoCon.setBounds(retL[0], retL[1], retL[2], retL[3]);
					contentPane.add(lblSpazioAggiuntoCon);
				
					DBManager mysql = DBManager.getInstance();
					mysql.query(query); 

				}
			}	
		}
	}
}
