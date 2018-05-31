import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class BankAccountMonitor extends JPanel
	{
		static ArrayList<BankAccount> account = new ArrayList<BankAccount>();
		
			public BankAccountMonitor(ArrayList<BankAccount> a )
			{
				setLayout(null);
				JLabel accName =new JLabel("Acc. Name: ");
				JTextField accName1 = new JTextField();
				JButton find = new JButton("FIND ACCOUNTS");
				
				JLabel accNum =new JLabel("Acc. Num: ");
				JTextField accNum1 = new JTextField();
				JButton find1 = new JButton ("FIND BALANCE");
				
				accName.setBounds(60,20,120,20);
				accName1.setBounds(130,20,80,20);
				find.setBounds(59,40,150,20);
				
				accNum.setBounds(60,70,120,20);
				accNum1.setBounds(130,70,80,20);
				find1.setBounds(59,90,150,20);
				
				add(accName);
				add(accName1);
				add(find);
				add(accNum);
				add(accNum1);
				add(find1);
				
				
				find.addActionListener(new ActionListener()
				{
					public void actionPerformed(ActionEvent o) 
					{
						
						
						String name = new String(accName1.getText());
						for (int i = 0; i<a.size(); i++)
						{
							if (a.get(i).getName().equals(name))
							{
								System.out.println(a.get(i).toString());
							}
							if (!(a.get(i).getName().equals(name)) && i == a.size()-1)	
							{
								System.out.println("No Accounts under that name");
								
							}
							
						}
					}
					});
				find1.addActionListener(new ActionListener()
				{
					public void actionPerformed(ActionEvent o) 
					{
						
						double temp = Double.parseDouble(accNum1.getText());
						for (int i = 0; i<a.size(); i++)
						{
							if (a.get(i).getAccountNumber() == temp)
							{
								System.out.println(a.get(i).getBalance());
								break;
								
							}
							else if (!(a.get(i).getAccountNumber() == temp) && i == a.size()-1)	
							{
								System.out.println("No Accounts under that number");
								
							}
						}
						accName1.setText("");
						accNum1.setText("");
					}
					});
			}
		
		
	}
