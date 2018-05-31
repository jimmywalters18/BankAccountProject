import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class BankAccountTransfer extends JPanel
{
	static ArrayList<BankAccount> account = new ArrayList<BankAccount>();
	static int bop = 0;
	
	public BankAccountTransfer(ArrayList<BankAccount> a)
	{
	//	BankAccountManage man = new BankAccountManage(a);
		setLayout(null);
		JLabel transferAmt = new JLabel("Transfer Amount:");
		JTextField transferAmt1 = new JTextField();
		JLabel sender = new JLabel("Account # Transferring: ");
		JLabel reciever = new JLabel("Account # Recieving: ");
		JButton accNum = new JButton ("What's my Acc. #?");
		
		JTextField sender1 = new JTextField();
		JTextField reciever1 = new JTextField();
		JButton send = new JButton("TRANSFER");
		
		transferAmt.setBounds(60,20,120,20);
		transferAmt1.setBounds(200,20,40,20);
		sender.setBounds(60,50,180,20);
		sender1.setBounds(200,50,40,20);
		reciever.setBounds(60, 80, 180, 20);
		reciever1.setBounds(200,80,40,20);
		accNum.setBounds(60,110,160,20);
		
		send.setBounds(60,140,160,20);
		
		add(transferAmt);
		add(transferAmt1);
		add(sender);
		add(sender1);
		add(reciever);
		add(reciever1);
		add(accNum);
		add(send);
		
		send.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent o) 
			{
			 int temp = Integer.parseInt(sender1.getText());
				for (int i = 0; i<a.size()-1; i++)
				{
					if (a.get(i).getAccountNumber() == temp)
					{
						a.get(i).transfer(a.get(Integer.parseInt(reciever1.getText())-1), Double.parseDouble(transferAmt1.getText()));
					}
				}
			}
			});
		accNum.addActionListener(new ActionListener()
				{
					public void actionPerformed(ActionEvent z) {
					
						
					}
				
				});
		setVisible(true);
		
		
		
		
	}
	
}
