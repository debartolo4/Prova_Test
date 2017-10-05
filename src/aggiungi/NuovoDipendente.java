package aggiungi;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.util.ArrayList;

import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.border.EmptyBorder;

import control.Controlli;
import enums.Table;
import support.DBManager;

/**
 * The Class NuovoDipendente.
 */
public class NuovoDipendente extends JFrame {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** The content pane. */
	private JPanel contentPane;

	/** The text field. */
	private JTextField textField;

	/** The text field 1. */
	private JTextField textField_1;

	/** The list 2. */
	private JList<String> lista_2;
	private DefaultListModel<String> listModel = new DefaultListModel<String>();

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
	private JList<String> lista_9;
	private DefaultListModel<String> listModel2 = new DefaultListModel<String>();

	/**
	 * Create the frame.
	 */
	
	public NuovoDipendente() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		int[] Tet = { 100, 100, 450, 300 };
		setBounds(Tet[0], Tet[1], Tet[2], Tet[3]);
		contentPane = new JPanel();
		int[] tetA = { 5, 5, 5, 5 };
		contentPane.setBorder(new EmptyBorder(tetA[0], tetA[1], tetA[2], tetA[3]));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblAggiungiDipendenti = new JLabel("Aggiungi dipendenti");
		int[] tetB = { 165, 11, 142, 31 };
		lblAggiungiDipendenti.setBounds(tetB[0], tetB[1], tetB[2], tetB[3]);
		contentPane.add(lblAggiungiDipendenti);

		JLabel lblNome = new JLabel("Nome");
		int[] tetC = { 28, 64, 46, 14 };
		lblNome.setBounds(tetC[0], tetC[1], tetC[2], tetC[3]);
		contentPane.add(lblNome);

		JLabel lblCognome = new JLabel("Cognome");
		int[] tetD = { 28, 89, 46, 14 };
		lblCognome.setBounds(tetD[0], tetD[1], tetD[2], tetD[3]);
		contentPane.add(lblCognome);

		JLabel lblSesso = new JLabel("Sesso");
		int[] tetE = { 28, 114, 46, 14 };
		lblSesso.setBounds(tetE[0], tetE[1], tetE[2], tetE[3]);
		contentPane.add(lblSesso);

		JLabel lblDataDiNascita = new JLabel("Data di nascita");
		int[] tetF = { 28, 139, 89, 14 };
		lblDataDiNascita.setBounds(tetF[0], tetF[1], tetF[2], tetF[3]);
		contentPane.add(lblDataDiNascita);

		JLabel lblNewLabel = new JLabel("Mail");
		int[] tetG = { 28, 164, 46, 14 };
		lblNewLabel.setBounds(tetG[0], tetG[1], tetG[2], tetG[3]);
		contentPane.add(lblNewLabel);

		JLabel lblTelefono = new JLabel("Telefono");
		int[] tetH = { 28, 189, 46, 14 };
		lblTelefono.setBounds(tetH[0], tetH[1], tetH[2], tetH[3]);
		contentPane.add(lblTelefono);

		JLabel lblDomicilio = new JLabel("Domicilio");
		int[] tetI = { 28, 212, 46, 14 };
		lblDomicilio.setBounds(tetI[0], tetI[1], tetI[2], tetI[3]);
		contentPane.add(lblDomicilio);

		textField = new JTextField();
		int[] tetL = { 109, 61, 86, 20 };
		textField.setBounds(tetL[0], tetL[1], tetL[2], tetL[3]);
		contentPane.add(textField);
		int com = 10;
		textField.setColumns(com);

		textField_1 = new JTextField();
		int[] tetM = { 109, 86, 86, 20 };
		textField_1.setBounds(tetM[0], tetM[1], tetM[2], tetM[3]);
		contentPane.add(textField_1);
		textField_1.setColumns(com);

		listModel.addElement("M");
		listModel.addElement("F");
		lista_2 = new JList<String>(listModel);
		int[] tetN = { 109, 111, 86, 20 };
		lista_2.setBounds(tetN[0], tetN[1], tetN[2], tetN[3]);
		lista_2.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		lista_2.setLayoutOrientation(JList.HORIZONTAL_WRAP);
		lista_2.setVisibleRowCount(-1);
		JScrollPane listScroller = new JScrollPane(lista_2);
		listScroller.setPreferredSize(new Dimension(250, 80));
		contentPane.add(lista_2);

		textField_3 = new JTextField();
		int[] tetO = { 109, 136, 86, 20 };
		textField_3.setBounds(tetO[0], tetO[1], tetO[2], tetO[3]);
		contentPane.add(textField_3);
		textField_3.setColumns(com);

		textField_4 = new JTextField();
		int[] tetP = { 109, 161, 86, 20 };
		textField_4.setBounds(tetP[0], tetP[1], tetP[2], tetP[3]);
		contentPane.add(textField_4);
		textField_4.setColumns(com);

		textField_5 = new JTextField();
		int[] tetQ = { 109, 186, 86, 20 };
		textField_5.setBounds(tetQ[0], tetQ[1], tetQ[2], tetQ[3]);
		contentPane.add(textField_5);
		textField_5.setColumns(com);

		textField_6 = new JTextField();
		int[] tetR = { 109, 209, 86, 20 };
		textField_6.setBounds(tetR[0], tetR[1], tetR[2], tetR[3]);
		contentPane.add(textField_6);
		textField_6.setColumns(com);

		JLabel lblId = new JLabel("ID");
		int[] tetS = { 231, 129, 18, 14 };
		lblId.setBounds(tetS[0], tetS[1], tetS[2], tetS[3]);
		contentPane.add(lblId);

		textField_7 = new JTextField();
		int[] tetT = { 282, 126, 86, 20 };
		textField_7.setBounds(tetT[0], tetT[1], tetT[2], tetT[3]);
		contentPane.add(textField_7);
		textField_7.setColumns(com);

		JLabel lblNewLabel_1 = new JLabel("CF");
		int[] tetU = { 231, 154, 18, 14 };
		lblNewLabel_1.setBounds(tetU[0], tetU[1], tetU[2], tetU[3]);
		contentPane.add(lblNewLabel_1);

		textField_8 = new JTextField();
		int[] tetV = { 282, 151, 86, 20 };
		textField_8.setBounds(tetV[0], tetV[1], tetV[2], tetV[3]);
		contentPane.add(textField_8);
		textField_8.setColumns(com);

		JButton btnNewButton = new JButton("Aggiungi");
		btnNewButton.setAction(action);
		int plays = 18;
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, plays));
		int[] tetW = { 247, 180, 152, 59 };
		btnNewButton.setBounds(tetW[0], tetW[1], tetW[2], tetW[3]);
		contentPane.add(btnNewButton);

		JLabel lblMansione = new JLabel("Mansione");
		int[] tetX = { 228, 64, 46, 14 };
		lblMansione.setBounds(tetX[0], tetX[1], tetX[2], tetX[3]);
		contentPane.add(lblMansione);

		listModel2.addElement("Direttore");
		listModel2.addElement("Dipendente");
		listModel2.addElement("Collaboratore");
		lista_9 = new JList<String>(listModel2);
		int[] tetZ = { 282, 61, 86, 60 };
		lista_9.setBounds(tetZ[0], tetZ[1], tetZ[2], tetZ[3]);
		lista_9.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
		lista_9.setLayoutOrientation(JList.HORIZONTAL_WRAP);
		lista_9.setVisibleRowCount(-1);
		JScrollPane listScroller2 = new JScrollPane(lista_9);
		listScroller2.setPreferredSize(new Dimension(250, 80));
		contentPane.add(lista_9);
		
	}

	/**
	 * The Class SwingAction.
	 *
	 * @SwingAction
	 */
	
	public class SwingAction extends AbstractAction {

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
		 * @param e
		 *            the e
		 * @actionPerformed
		 */
		
		public void actionPerformed(ActionEvent e) {
			Controlli c = new Controlli();
			boolean on = false;
			try {
				on = c.nameControl(textField) && c.surnameControl(textField_1)
						&& c.dateControl(textField_3) && c.emailControl(textField_4) && c.phoneControl(textField_5)
						&& c.addressControl(textField_6)
						&& c.IDControl(textField_7, Table.DIPENDENTE, this.getClass().getName())
						&& c.cfControl(textField_8);
			} catch (Exception e3) {
				e3.printStackTrace();
			}
			ArrayList<JTextField> textList = new ArrayList<>();
			try {
				if (on) {
					textList.add(textField);
					textList.add(textField_1);
					textList.add(textField_3);
					textList.add(textField_4);
					textList.add(textField_5);
					textList.add(textField_6);
					textList.add(textField_7);
					textList.add(textField_8);
				}
			} catch (Exception e2) {
				e2.printStackTrace();
			}

			if (!textList.isEmpty()) {
				String query = null;
	
				try {
					query = c.getQuery(textList, Table.DIPENDENTE, lista_2, lista_9, "sesso","mansione", "nome", "cognome",
							"data_di_nascita", "mail", "telefono", "domicilio", "ID_Dipendente", "cf");
				} catch (Exception e1) {
					e1.printStackTrace();
				}
				JLabel lblDipendenteAggiuntoCon = new JLabel("Dipendente aggiunto con successo");
				int[] tetZ = { 247, 230, 177, 14 };
				lblDipendenteAggiuntoCon.setBounds(tetZ[0], tetZ[1], tetZ[2], tetZ[3]);
				contentPane.add(lblDipendenteAggiuntoCon);
				DBManager mysql = DBManager.getInstance();
				mysql.query(query);				
			}
		}
	}
}
