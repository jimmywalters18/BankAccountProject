import java.awt.CardLayout;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.event.MenuEvent;
import javax.swing.event.MenuListener;

public class BankAccountMainMenu extends JFrame
{
	static ArrayList<BankAccount> account = new ArrayList<BankAccount>();
	static int bop;
	JMenuItem with;
	JMenuItem transfer;
	JMenuItem both2;
	public BankAccountMainMenu() 
	{
		
		setBounds(100, 100, 300, 300);
		JMenuBar mb = new JMenuBar();
		JMenu menu = new JMenu("HOME");
		mb.add(menu);
		setJMenuBar(mb);
		JMenu menu2 = new JMenu("TRANSACTIONS");
		JMenuItem with = new JMenuItem("Withdraw");
		JMenuItem transfer1 = new JMenuItem("Transfer");
		JMenuItem both2 = new JMenuItem("Withdraw/Deposit");
		menu2.add(both2);
		menu2.add(transfer1);
		mb.add(menu2);
		JMenu manage = new JMenu("MANAGE ACC.");
		mb.add(manage);
		
		JPanel card = new JPanel(new CardLayout());
	
		BankAccountMainJPanel home = new BankAccountMainJPanel(account);
		BankAccountWithdrawDeposit both = new BankAccountWithdrawDeposit(account);
		BankAccountTransfer trans = new BankAccountTransfer(account);
		BankAccountMonitor man = new BankAccountMonitor(account);
		
		card.add(home,"1");
		card.add(both, "2");
		card.add(trans, "3");
		card.add(man, "4");
		CardLayout cl = (CardLayout)(card.getLayout());
		cl.show(card,"1");
	
		
		getContentPane().add(card);
		
		
	
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	
	
		menu.addMenuListener(new MenuListener()
		{
			public void menuSelected(MenuEvent e)
			{
				cl.show(card, "1");	
			}

			public void menuCanceled(MenuEvent arg0) {
			
				
			}

			public void menuDeselected(MenuEvent arg0) {
	
			}
			});
	

		both2.addActionListener(new ActionListener() {
	      public void actionPerformed(ActionEvent e) {
	          cl.show(card,  "2");
	        }});
		transfer1.addActionListener(new ActionListener() {
		      public void actionPerformed(ActionEvent e) {
		          cl.show(card,  "3");
		        }});
		manage.addMenuListener(new MenuListener()
		{
			public void menuSelected(MenuEvent e)
			{
				cl.show(card, "4");	
			}

			public void menuCanceled(MenuEvent arg0) {
			
				
			}

			public void menuDeselected(MenuEvent arg0) {
	
			}
			
		});
		setResizable(false);
	}

	
public static void main(String[] args)
{
	new BankAccountMainMenu();
}
}