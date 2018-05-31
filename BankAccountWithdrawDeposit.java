import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class BankAccountWithdrawDeposit extends JPanel
{
	static ArrayList<BankAccount> account = new ArrayList<BankAccount>();
	
	public BankAccountWithdrawDeposit(ArrayList<BankAccount> a )
	{
		setLayout(null);
		JLabel accountNumber = new JLabel("Account number: ");
		JTextField accountNumber1 = new JTextField();
		JButton accountQuestion = new JButton("What's my Acc. #?");
		
		
		String[] transType = { "Deposit", "Withdraw" };
		JComboBox transType1  = new JComboBox(transType);
		JLabel transType2 = new JLabel("Transaction: ");
		JLabel amount = new JLabel("Amount");
		JTextField amount1= new JTextField();
		JButton transact = new JButton("TRANSACT AMOUNT");

		
		accountNumber.setBounds(60,20,120,20);
		accountNumber1.setBounds(170,20,60,20);
		transType1.setBounds(150,50,80,20);
		transType2.setBounds(60,50,80,20);
		amount.setBounds(60,80,80,20);
		amount1.setBounds(150, 80, 80, 20);
		accountQuestion.setBounds(60,110,160,20);
		transact.setBounds(60,140,160,20);
		
		add(accountNumber);
		add(accountNumber1);
		add(transType1);
		add(transType2);
		add(amount);
		add(amount1);
		
		add(transact);
		setVisible(true);
		
		transact.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e) 
			{
				String bonk = (String) transType1.getSelectedItem();
				
				int intBal = Integer.parseInt(accountNumber1.getText());
				int amt = Integer.parseInt(amount1.getText());;
				
					if (bonk.equals("Deposit"))
					{
						a.get(intBal - 1).deposit(amt);
						
					}
					else
					{
						a.get(intBal-1).withdraw(amt);
					}
				accountNumber.setText("");
				amount.setText("");
				
			}
			});
		setVisible(true);
	}
	public static void main(String[] args)
	{
	new BankAccountWithdrawDeposit(account);
	}
	}
