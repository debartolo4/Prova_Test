package schedario;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import support.DBManager;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.AbstractAction;
import java.awt.event.ActionEvent;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;

import javax.swing.Action;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import control.Controlli;

import javax.swing.JScrollPane;

/**
 * The Class GestioneSchedario
 */
public class GestioneSchedario extends JFrame {
	
	JComboBox<String> comboBox;
	JComboBox<String> comboBox_1;
	JComboBox<String> comboBox_2;
	
	static int count = 0;
	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;
	
	/** The content pane. */
	private JPanel contentPane;
	
	/** The action. */
	private final Action action = new SwingAction();
	private JTable table;
	
	DBManager mysql = DBManager.getInstance();
	
	public DefaultTableModel modelTable = new DefaultTableModel(null,new Object[] { "Dipendenti", 
			"Spazi" ,"Strumentazioni"});
	String arr[] = new String[3];

	/**
	 * Create the frame.
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public GestioneSchedario() {
		Controlli c = new Controlli();
		setType(Type.UTILITY);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 514, 629);
		
		modelTable.addRow(arr);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		comboBox = new JComboBox();
		ArrayList<String> listaDipendenti = new ArrayList<>(); 

		try {
			comboBox.setModel(new DefaultComboBoxModel(c.listUtility(listaDipendenti,
					"SELECT ID_Dipendente from dipendente", "ID_Dipendente").toArray(new String[20])));
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		comboBox.setBounds(42, 116, 118, 20);
		contentPane.add(comboBox);
		
		comboBox_1 = new JComboBox();
		ArrayList<String> listaSpazi = new ArrayList<>();

		try {
			comboBox_1.setModel(new DefaultComboBoxModel( c.listUtility(listaSpazi,
					"SELECT ID_Spazio from spazio", "ID_Spazio").toArray(new String[20])));
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		comboBox_1.setBounds(184, 116, 118, 20);
		contentPane.add(comboBox_1);
		
		comboBox_2 = new JComboBox();
		ArrayList<String> listaStrumentazioni = new ArrayList<>();

		try {
			comboBox_2.setModel(new DefaultComboBoxModel(c.listUtility(listaStrumentazioni,
					"SELECT ID_Strumento from strumentazione", "ID_Strumento").toArray(new String[20])));
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		comboBox_2.setBounds(327, 116, 118, 20);
		contentPane.add(comboBox_2);
		
		JButton btnNewButton = new JButton("Aggiungi");
		btnNewButton.setAction(action);
		btnNewButton.setBounds(177, 147, 136, 54);
		contentPane.add(btnNewButton);
		
		JLabel lblNewLabel = new JLabel("ID Dipendente");
		lblNewLabel.setBounds(52, 77, 123, 14);
		contentPane.add(lblNewLabel);
		
		JLabel lblIdSpazio = new JLabel("ID Spazio");
		lblIdSpazio.setBounds(199, 77, 91, 14);
		contentPane.add(lblIdSpazio);
		
		JLabel lblIdStrumentazione = new JLabel("ID Strumentazione");
		lblIdStrumentazione.setBounds(340, 77, 136, 14);
		contentPane.add(lblIdStrumentazione);
		
		String q = "SELECT ID_Dipendente FROM schedario;"; 		
		
		countDipendenti(q);		
	}

	private void countDipendenti(String q) {
		
		ResultSet rs = mysql.querySelect(q);
		
		try {
			while(rs.next()) {
				count++;
			}
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, e.getMessage());
		}
	}
	
	private void clearAllRows(DefaultTableModel tableModel) {
		if(tableModel.getRowCount() > 0) {
		    for(int i = tableModel.getRowCount() - 1; i > -1; i--) {
		        tableModel.removeRow(i);
		    }
		}
	}

	private void getTable() throws FileNotFoundException {
		
		clearAllRows(modelTable);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(83, 233, 335, 226);
		contentPane.add(scrollPane);
		
		table = new JTable();
		 
		String que = "SELECT * FROM schedario;"; 
		 
		ResultSet rs = mysql.querySelect(que);
		
		File fila = new File("Schedario.txt");
		PrintStream scrivi = new PrintStream(fila);		
		
		try {
			while(rs.next()) {
				
				String[] infos = new String[3];
				infos[0] = rs.getString("ID_Dipendente");
				infos[1] = rs.getString("ID_Spazio");
				infos[2] = rs.getString("ID_Strumento");
				modelTable.addRow(infos);
				scrivi.println("Dipendente:" + infos[0] + "\t" +
						"Spazio:" + infos[1] + "\t" +
						"Strumento:" + infos[2]);
			}
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, e.getMessage());
		}
		
		scrivi.flush();
		scrivi.close();
	
		table.setModel(modelTable);
		scrollPane.setViewportView(table);
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
			putValue(NAME, "Aggiungi");
			putValue(SHORT_DESCRIPTION, "Some short description");
		}
		
		/**
		 * actionPerformed.
		 *
		 * @param e the e
		 */
		public void actionPerformed(ActionEvent e) {
			
			String query = "INSERT INTO schedario (ID_Dipendente, ID_Spazio, ID_Strumento) VALUES ";
			
			String vTemp = "(?, ?, ?);";
			
			queryInsert(mysql, query, vTemp);
			
			try {
				getTable();
			} catch (FileNotFoundException e1) {
				JOptionPane.showMessageDialog(null, e1.getMessage());
			}			
		}

		private void queryInsert(DBManager mysql, String query, String vTemp) {
			String x = String.valueOf(comboBox.getSelectedItem().toString());
			String y = String.valueOf(comboBox_1.getSelectedItem().toString());
			String z = String.valueOf(comboBox_2.getSelectedItem().toString());
			query = query + vTemp;
			mysql.query(query, x, y, z);
		}	
	}
}