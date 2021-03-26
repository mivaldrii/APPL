// ******************************************************************
// RatePanel.java
//
// Panel for a program that converts different currencies to
// U.S. Dollars
// ******************************************************************
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
public class RatePanel extends JPanel
{
	private double[] rate; // exchange rates
	private String[] currencyName;
	private JLabel result;
	
	private JComboBox comboBox;
	private JTextField textField;
	// ------------------------------------------------------------
	// Sets up a panel to convert cost from one of 6 currencies
	// into U.S. Dollars. The panel contains a heading, a text
	// field for the cost of the item, a combo box for selecting
	// the currency, and a label to display the result.
	// ------------------------------------------------------------
	public RatePanel ()
	{
		this.setLayout(new BorderLayout());
		
		JLabel title = new JLabel ("How much is that in dollars?");
		JPanel header = new JPanel();
		
		title.setAlignmentX (Component.CENTER_ALIGNMENT);
		title.setFont (new Font ("Helvetica", Font.BOLD, 20));
		
		// Set up the arrays for the currency conversions
		currencyName = new String[] {"Select the currency..",
				"European Euro", "Canadian Dollar",
				"Japanese Yen", "Australian Dollar",
				"Indian Rupee", "Mexican Peso"};
		rate = new double [] {0.0, 1.2103, 0.7351,
				0.0091, 0.6969,
				0.0222, 0.0880};
		result = new JLabel (" ------------ ");
		header.add(title);
		header.add(result);
		
		//set up combo box
		comboBox = new JComboBox(currencyName);
		comboBox.addActionListener(new ComboListener());
		
		//set up field
		JPanel textField_panel = new JPanel();
		JLabel textField_label = new JLabel("Amount");
		textField = new JTextField(12);
		textField.setPreferredSize(new Dimension(120, 20));
		textField_panel.add(textField_label);
		textField_panel.add(textField);
	    
	    add(header, BorderLayout.NORTH);
	    add(comboBox, BorderLayout.CENTER);
	    add(textField_panel, BorderLayout.SOUTH);
	}
	
	
	// ******************************************************
	// Represents an action listener for the combo box.
	// ******************************************************
	private class ComboListener implements ActionListener
	{
		// --------------------------------------------------
		// Determines which currency has been selected and
		// the value in that currency then computes and
		// displays the value in U.S. Dollars.
		// --------------------------------------------------
		public void actionPerformed (ActionEvent event)
		{
			try 
			{
				int index = comboBox.getSelectedIndex();
                double amount = Double.valueOf(textField.getText());
                result.setText(amount +" " + currencyName[index]
                        + " = " + rate[index]*amount + " U.S. Dollars");
			} 
			catch (NumberFormatException e) 
			{
				result.setText("Error! Please enter a number in text field.");
			}
		}
	}
}