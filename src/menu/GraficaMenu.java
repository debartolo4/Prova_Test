package menu;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import aggiungi.NuovaStrumentazione;
import aggiungi.NuovoDipendente;
import aggiungi.NuovoSpazio;
import elimina.EliminaDipendente;
import elimina.EliminaSpazio;
import elimina.EliminaStrumentazione;
import modifica.ModificaDipendente;
import modifica.ModificaSpazio;
import modifica.ModificaStrumentazione;
import schedario.GestioneSchedario;

import javax.swing.JButton;
import javax.swing.AbstractAction;
import java.awt.event.ActionEvent;
import javax.swing.Action;
import javax.swing.SwingConstants;

/**
 * The Class GraficaMenu.
 */
public class GraficaMenu extends JFrame {

	
	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;
	
	/** The content pane. */
	private JPanel contentPane;
	
	/** The action aggiungi. */
	private final Action action_aggiungi = new SwingAction_aggiungi();
	
	/** The action 1. */
	private final Action action_1 = new SwingAction_1();
	
	/** The action 2. */
	private final Action action_2 = new SwingAction_2();
	
	/** The action 3. */
	private final Action action_3 = new SwingAction_3();
	
	/** The action 4. */
	private final Action action_4 = new SwingAction_4();
	
	/** The action 5. */
	private final Action action_5 = new SwingAction_5();
	
	/** The action 6. */
	private final Action action_6 = new SwingAction_6();
	
	/** The action 7. */
	private final Action action_7 = new SwingAction_7();
	
	/** The action 8. */
	private final Action action_8 = new SwingAction_8();
	
	/** The action 9. */
	private final Action action_9 = new SwingAction_9();

	


	/**
	 * Create the frame.
	 */
	public GraficaMenu() {
		setType(Type.UTILITY);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 623, 477);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnGestioneDipendenti = new JButton("Gestione dipendenti");
		btnGestioneDipendenti.setHorizontalAlignment(SwingConstants.LEFT);
		btnGestioneDipendenti.setBounds(10, 11, 154, 23);
		contentPane.add(btnGestioneDipendenti);
		
		JButton btnEsportaScheda = new JButton("Esporta scheda");
		btnEsportaScheda.setAction(action_3);
		btnEsportaScheda.setBounds(461, 11, 136, 23);
		contentPane.add(btnEsportaScheda);
		
		JButton button = new JButton("Gestione strumenti");
		button.setBounds(170, 11, 145, 23);
		contentPane.add(button);
		
		JButton button_1 = new JButton("Gestione spazi");
		button_1.setBounds(320, 11, 133, 23);
		contentPane.add(button_1);
		
		JButton btnAggiungi = new JButton("Aggiungi");
		btnAggiungi.setAction(action_aggiungi);
		btnAggiungi.setBounds(40, 76, 89, 23);
		contentPane.add(btnAggiungi);
		
		JButton button_2 = new JButton("Aggiungi");
		button_2.setAction(action_1);
		button_2.setBounds(199, 76, 89, 23);
		contentPane.add(button_2);
		
		JButton button_3 = new JButton("Aggiungi");
		button_3.setAction(action_2);
		button_3.setBounds(345, 76, 89, 23);
		contentPane.add(button_3);
		
		JButton btnElimina = new JButton("Elimina");
		btnElimina.setAction(action_4);
		btnElimina.setBounds(40, 123, 89, 23);
		contentPane.add(btnElimina);
		
		JButton button_4 = new JButton("Elimina");
		button_4.setAction(action_5);
		button_4.setBounds(199, 123, 89, 23);
		contentPane.add(button_4);
		
		JButton button_5 = new JButton("Elimina");
		button_5.setAction(action_6);
		button_5.setBounds(345, 123, 89, 23);
		contentPane.add(button_5);
		
		JButton btnModifica = new JButton("Modifica");
		btnModifica.setAction(action_7);
		btnModifica.setBounds(40, 171, 89, 23);
		contentPane.add(btnModifica);
		
		JButton button_6 = new JButton("Modifica");
		button_6.setAction(action_8);
		button_6.setBounds(199, 171, 89, 23);
		contentPane.add(button_6);
		
		JButton button_7 = new JButton("Modifica");
		button_7.setAction(action_9);
		button_7.setBounds(345, 171, 89, 23);
		contentPane.add(button_7);
		
	}
	
	/**
	 * The Class SwingAction_aggiungi.
	 *
	 * @SwingAction 
	 */
	private class SwingAction_aggiungi extends AbstractAction {
		
		/** The Constant serialVersionUID. */
		private static final long serialVersionUID = 1L;
		
		/**
		 * Instantiates a new swing action aggiungi.
		 *
		 * @SwingAction 
		 */
		public SwingAction_aggiungi() {
			putValue(NAME, "Aggiungi");
		}
		
		/**
		 * actionPerformed.
		 *
		 * @param e the e
		 */
		public void actionPerformed(ActionEvent e) {
			NuovoDipendente newWindow = new NuovoDipendente();
			
			newWindow.setVisible(true);
			newWindow.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		}
	}
	
	/**
	 * The Class SwingAction_1.
	 *
	 * @SwingAction 
	 */
	private class SwingAction_1 extends AbstractAction {
		
		/** The Constant serialVersionUID. */
		private static final long serialVersionUID = 1L;
		
		/**
		 * Instantiates a new swing action 1.
		 *
		 * @SwingAction 
		 */
		public SwingAction_1() {
			putValue(NAME, "Aggiungi");
			putValue(SHORT_DESCRIPTION, "Some short description");
		}
		
		/**
		 * actionPerformed.
		 *
		 * @param e the e
		 */
		public void actionPerformed(ActionEvent e) {
			NuovaStrumentazione newWindow = new NuovaStrumentazione();
			
			newWindow.setVisible(true);
			newWindow.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		}
	}
	
	/**
	 * The Class SwingAction_2.
	 *
	 * @SwingAction 
	 */
	private class SwingAction_2 extends AbstractAction {
		
		/** The Constant serialVersionUID. */
		private static final long serialVersionUID = 1L;
		
		/**
		 * Instantiates a new swing action 2.
		 *
		 * @SwingAction 
		 */
		public SwingAction_2() {
			putValue(NAME, "Aggiungi");
			putValue(SHORT_DESCRIPTION, "Some short description");
		}
		
		/**
		 * actionPerformed.
		 *
		 * @param e the e
		 */
		public void actionPerformed(ActionEvent e) {
			NuovoSpazio newWindow = new NuovoSpazio();

			newWindow.setVisible(true);
			newWindow.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		}
	}
	
	/**
	 * The Class SwingAction_3.
	 *
	 * @SwingAction 
	 */
	private class SwingAction_3 extends AbstractAction {
		
		/** The Constant serialVersionUID. */
		private static final long serialVersionUID = 1L;
		
		/**
		 * Instantiates a new swing action 3.
		 *
		 * @SwingAction 
		 */
		public SwingAction_3() {
			putValue(NAME, "Esporta scheda");
			putValue(SHORT_DESCRIPTION, "Some short description");
		}
		
		/**
		 * actionPerformed.
		 *
		 * @param e the e
		 */
		public void actionPerformed(ActionEvent e) {
			GestioneSchedario newWindow = new GestioneSchedario();
			
			newWindow.setVisible(true);
			newWindow.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		}
	}
	
	/**
	 * The Class SwingAction_4.
	 *
	 * @SwingAction 
	 */
	private class SwingAction_4 extends AbstractAction {
		
		/** The Constant serialVersionUID. */
		private static final long serialVersionUID = 1L;
		
		/**
		 * Instantiates a new swing action 4.
		 *
		 * @SwingAction 
		 */
		public SwingAction_4() {
			putValue(NAME, "Elimina");
			putValue(SHORT_DESCRIPTION, "Some short description");
		}
		
		/**
		 * actionPerformed.
		 *
		 * @param e the e
		 */
		public void actionPerformed(ActionEvent e) {
			EliminaDipendente newWindow = new EliminaDipendente();
			newWindow.setVisible(true);
			newWindow.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		}
	}
	
	
	
	
	
	
	
	/**
	 * The Class SwingAction_5.
	 *
	 * @SwingAction 
	 */
	private class SwingAction_5 extends AbstractAction {
		
		/** The Constant serialVersionUID. */
		private static final long serialVersionUID = 1L;
		
		/**
		 * Instantiates a new swing action 5.
		 *
		 * @SwingAction 
		 */
		public SwingAction_5() {
			putValue(NAME, "Elimina");
			putValue(SHORT_DESCRIPTION, "Some short description");
		}
		
		/**
		 * actionPerformed.
		 *
		 * @param e the e
		 */
		public void actionPerformed(ActionEvent e) {
			EliminaStrumentazione newWindow = new EliminaStrumentazione();
			newWindow.setVisible(true);
			newWindow.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		}
	}
	
	
	
	/**
	 * The Class SwingAction_6.
	 *
	 * @SwingAction 
	 */
	private class SwingAction_6 extends AbstractAction {
		
		/** The Constant serialVersionUID. */
		private static final long serialVersionUID = 1L;
		
		/**
		 * Instantiates a new swing action 6.
		 *
		 * @SwingAction 
		 */
		public SwingAction_6() {
			putValue(NAME, "Elimina");
			putValue(SHORT_DESCRIPTION, "Some short description");
		}
		
		/**
		 * actionPerformed.
		 *
		 * @param e the e
		 */
		public void actionPerformed(ActionEvent e) {
			EliminaSpazio newWindow = new EliminaSpazio();
			newWindow.setVisible(true);
			newWindow.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		}
	}
	
	
	/**
	 * The Class SwingAction_7.
	 *
	 * @SwingAction 
	 */
	private class SwingAction_7 extends AbstractAction {
		
		/** The Constant serialVersionUID. */
		private static final long serialVersionUID = 1L;
		
		/**
		 * Instantiates a new swing action 7.
		 *
		 * @SwingAction 
		 */
		public SwingAction_7() {
			putValue(NAME, "Modifica");
			putValue(SHORT_DESCRIPTION, "Some short description");
		}
		
		/**
		 * actionPerformed.
		 *
		 * @param e the e
		 */
		public void actionPerformed(ActionEvent e) {
			ModificaDipendente newWindow = new ModificaDipendente();
			newWindow.setVisible(true);
			newWindow.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		}
	}
	
	


	/**
	 * The Class SwingAction_8.
	 *
	 * @SwingAction 
	 */
	private class SwingAction_8 extends AbstractAction {
		
		/** The Constant serialVersionUID. */
		private static final long serialVersionUID = 1L;
		
		/**
		 * Instantiates a new swing action 8.
		 *
		 * @SwingAction 
		 */
		public SwingAction_8() {
			putValue(NAME, "Modifica");
			putValue(SHORT_DESCRIPTION, "Some short description");
		}
		
		/**
		 * actionPerformed.
		 *
		 * @param e the e
		 */
		public void actionPerformed(ActionEvent e) {
			ModificaStrumentazione newWindow = new ModificaStrumentazione();
			newWindow.setVisible(true);
			newWindow.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		}
	}
	
	
	/**
	 * The Class SwingAction_9.
	 *
	 * @SwingAction 
	 */
	private class SwingAction_9 extends AbstractAction {
		
		/** The Constant serialVersionUID. */
		private static final long serialVersionUID = 1L;
		
		/**
		 * Instantiates a new swing action 9.
		 *
		 * @SwingAction 
		 */
		public SwingAction_9() {
			putValue(NAME, "Modifica");
			putValue(SHORT_DESCRIPTION, "Some short description");
		}
		
		/**
		 * actionPerformed.
		 *
		 * @param e the e
		 */
		public void actionPerformed(ActionEvent e) {
			ModificaSpazio newWindow = new ModificaSpazio();
			newWindow.setVisible(true);
			newWindow.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		}
	}
}
