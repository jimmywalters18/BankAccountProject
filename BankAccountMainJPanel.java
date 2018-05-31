import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class BankAccountMainJPanel extends JPanel
{
	static ArrayList<BankAccount> account = new ArrayList<BankAccount>();
	public BankAccountMainJPanel(ArrayList<BankAccount> a) 
	{
	
		setLayout(null);
		JLabel newAccounts = new JLabel("New Account:");
		JButton manage = new JButton("Manage Accounts");
		JLabel name = new JLabel("Name:");
		JTextField name1 = new JTextField();
		JButton create = new JButton ("Create");
		JLabel transaction = new JLabel("Transactions:");
		JButton WithDep = new JButton("Withdraw/Deposit");
		JButton transfer = new JButton("Transfer");
		
		
		String[] accounts = { "Checking", "Savings" };
		JComboBox accountType  = new JComboBox(accounts);
		JLabel accountType1 = new JLabel("Account Type:");
		
		JLabel iniBal =  new JLabel("Balance: ");
		JTextField iniBal1 = new JTextField();
			
		newAccounts.setBounds(60,40,150,40);
//		manage.setBounds(350,50,150,20);
		name.setBounds(60,80,50,20);
		name1.setBounds(130, 80, 100, 20);
		accountType.setBounds(150, 110, 80, 20);
		accountType1.setBounds(60,110,100,20);
		create.setBounds(150,50,80,20);
//		transaction.setBounds(350,80,100,20);
//		WithDep.setBounds(350,110, 150,20);
//		transfer.setBounds(350, 140, 150,20);
		
		iniBal.setBounds(60,140,100,20);
		iniBal1.setBounds(130,140,100,20);
		
		
		add(manage);
		add(newAccounts);
		add(name);
		add(name1);
		add(accountType);
		add(accountType1);
		add(create);
//		add(transaction);
//		add(WithDep);
//		add(transfer);
	
		add(iniBal);
		add(iniBal1);
		
		create.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e) 
			{

				double intBal;
				String aname = name1.getText();
				if (iniBal1.getText().equals(""))
				{
					intBal = 0;
				}
				else
				{
					intBal = Double.parseDouble(iniBal1.getText());
				}
				int bonk = accountType.getSelectedIndex();
				
				
					if (bonk == 0)
					{
						a.add(new CheckingAccount(aname, intBal, 15, 1.5, 10));
						
					}
					else
					{
						a.add(new SavingsAccount(aname, intBal, .0025, 300, 10));
					}
					name1.setText("");
					iniBal1.setText("");
				
			}
			});
		setVisible(true);
		
	}
	public static void main(String[] args)
	{
		new BankAccountMainJPanel(account);
	}
}
