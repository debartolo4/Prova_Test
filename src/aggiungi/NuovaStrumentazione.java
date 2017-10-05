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
 * The Class NuovaStrumentazione.
 */
public class NuovaStrumentazione extends JFrame {


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
	
	/** The action. */
	private final Action action = new SwingAction();
	

	/**
	 * Create the frame.
	 */
	public NuovaStrumentazione() {
		setType(Type.UTILITY);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		int[] set = {100, 100, 450, 300};
		setBounds(set[0], set[1], set[2], set[3]);
		contentPane = new JPanel();
		int[] setA = {5, 5, 5, 5};
		contentPane.setBorder(new EmptyBorder(setA[0], setA[1], setA[2], setA[3]));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBorder(new EmptyBorder(setA[0], setA[1], setA[2], setA[3]));
		int[] setB = {0, 0, 434, 261};
		panel.setBounds(setB[0], setB[1], setB[2], setB[3]);
		contentPane.add(panel);
		
		JLabel lblAggiungiStrumentazione = new JLabel("Aggiungi Strumentazione");
		int[] setC = {146, 27, 188, 14};
		lblAggiungiStrumentazione.setBounds(setC[0], setC[1], setC[2], setC[3]);
		panel.add(lblAggiungiStrumentazione);
		
		JLabel label_1 = new JLabel("ID");
		int[] setD = {38, 70, 18, 14};
		label_1.setBounds(setD[0], setD[1], setD[2], setD[3]);
		panel.add(label_1);
		
		JLabel label_2 = new JLabel("Nome");
		int[] setE = {38, 163, 36, 14};
		label_2.setBounds(setE[0], setE[1], setE[2], setE[3]);
		panel.add(label_2);
		
		JLabel lblMarca = new JLabel("Marca");
		int[] setF = {38,  101, 64, 14};
		lblMarca.setBounds(setF[0], setF[1], setF[2], setF[3]);
		panel.add(lblMarca);
		
		textField = new JTextField();
		int col = 10;
		textField.setColumns(col);
		int[] setG = {92, 67, 86, 20};
		textField.setBounds(setG[0], setG[1], setG[2], setG[3]);
		panel.add(textField);
		
		textField_1 = new JTextField();
		textField_1.setColumns(col);
		int[] setH = {92, 98, 86, 20};
		textField_1.setBounds(setH[0], setH[1], setH[2], setH[3]);
		panel.add(textField_1);
		
		textField_2 = new JTextField();
		textField_2.setColumns(col);
		int[] setI = {92, 129, 86, 20};
		textField_2.setBounds(setI[0], setI[1], setI[2], setI[3]);
		panel.add(textField_2);
		
		JButton button = new JButton("AGGIUNGI");
		button.setAction(action);
		int play = 24;
		button.setFont(new Font("Tahoma", Font.PLAIN, play));
		int[] setL = {146, 205, 162, 45};
		button.setBounds(setL[0], setL[1], setL[2], setL[3]);
		panel.add(button);
		
		textField_3 = new JTextField();
		textField_3.setColumns(col);
		int[] setM = {285, 67, 86, 20};
		textField_3.setBounds(setM[0], setM[1], setM[2], setM[3]);
		panel.add(textField_3);
		
		textField_4 = new JTextField();
		textField_4.setColumns(col);
		int[] setN = {285, 108, 86, 20};
		textField_4.setBounds(setN[0], setN[1], setN[2], setN[3]);
		panel.add(textField_4);
		
		textField_5 = new JTextField();
		textField_5.setColumns(col);
		int[] setO = {285, 146, 86, 20};
		textField_5.setBounds(setO[0], setO[1], setO[2], setO[3]);
		panel.add(textField_5);
		
		textField_6 = new JTextField();
		textField_6.setColumns(col);
		int[] setP = {92, 160, 86, 20};
		textField_6.setBounds(setP[0], setP[1], setP[2], setP[3]);
		panel.add(textField_6);
		
		JLabel lblModello = new JLabel("Modello");
		int[] setQ = {25, 132, 49, 14};
		lblModello.setBounds(setQ[0], setQ[1], setQ[2], setQ[3]);
		panel.add(lblModello);
		
		JLabel lblTipologia = new JLabel("Tipologia");
		int[] setR = {221, 70, 64, 14};
		lblTipologia.setBounds(setR[0], setR[1], setR[2], setR[3]);
		panel.add(lblTipologia);
		
		JLabel lblNunit = new JLabel("NUnit\u00E0");
		int[] setS = {228, 111, 36, 14};
		lblNunit.setBounds(setS[0], setS[1], setS[2], setS[3]);
		panel.add(lblNunit);
		
		JLabel lblAnnoAcquisto = new JLabel("Data acquisto");
		int[] setT = {188, 149, 87, 14};
		lblAnnoAcquisto.setBounds(setT[0], setT[1], setT[2], setT[3]);
		panel.add(lblAnnoAcquisto);	
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
			putValue(NAME, "AGGIUNGI");
			putValue(SHORT_DESCRIPTION, "Some short description");
		}
		
		/**
		 * Action performed.
		 *
		 * @param e the e
		 * @action 
		 */
		public void actionPerformed(ActionEvent e) {
			ArrayList<JTextField> textList = new ArrayList<>();
			Controlli c = new Controlli();
			boolean on = false;
			
			try {
				on = c.IDControl(textField, Table.STRUMENTAZIONE, this.getClass().getName()) && 
						c.notEmptyStringControl(textField_1) && c.notEmptyStringControl(textField_2) && 
						c.notEmptyStringControl(textField_6) && c.notEmptyStringControl(textField_3) &&
						c.onlyNumFieldControl(textField_4) && c.dateControl(textField_5);
			} catch (Exception e2) {
				e2.printStackTrace();
			}

			if(on) {
				textList.add(textField);
				textList.add(textField_1);
				textList.add(textField_2);
				textList.add(textField_6);
				textList.add(textField_3);
				textList.add(textField_4);
				textList.add(textField_5);
				
				if(!textList.isEmpty()){
					
					JLabel lblSpazioAggiuntoCon = new JLabel("Strumentazione aggiunta con successo");
					int[] setU = {48, 188, 278, 14};
					lblSpazioAggiuntoCon.setBounds(setU[0], setU[1], setU[2], setU[3]);
					contentPane.add(lblSpazioAggiuntoCon);
					
					
					String query = null;
					try {
						query = c.getQuery(textList, Table.STRUMENTAZIONE, "ID_Strumento", "Marca", "Modello",
								"Nome", "Tipologia", "Nr_Unita_Possedute", "Anno_Acquisto");
					} catch (Exception e1) {
						
						e1.printStackTrace();
					}
					DBManager mysql = DBManager.getInstance();
					mysql.query(query);
			}
			
			
			}
		}
	}
	
	/**
	 * Checks for empty.
	 *
	 * @param textField the text field
	 * @return true, if successful
	 * @hasEmpty 
	 */

	public boolean controlName(JTextField jt) {
		return true;
	}
	
}
