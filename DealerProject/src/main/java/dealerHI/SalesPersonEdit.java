package dealerHI;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;

import dealerPD.Dealer;
import dealerPD.SalesPerson;

import javax.swing.JButton;
import javax.swing.JFrame;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.Font;

public class SalesPersonEdit extends JPanel {
  private JTextField textField;
  private JTextField textField_1;

  /**
   * Create the panel.
   */
  public SalesPersonEdit(JFrame currentFrame, Dealer dealer, SalesPerson salesPerson, boolean isAdd) {
    setLayout(new GridBagLayout());
    GridBagConstraints gbc = new GridBagConstraints();
    gbc.insets = new Insets(10, 10, 10, 10);
    gbc.fill = GridBagConstraints.HORIZONTAL;

    // Removed detached refresh

    JLabel lblSalesPersonEdit = new JLabel("Sales Person Edit");
    lblSalesPersonEdit.setFont(new Font("Tahoma", Font.BOLD, 18));
    gbc.gridx = 0;
    gbc.gridy = 0;
    gbc.gridwidth = 2;
    add(lblSalesPersonEdit, gbc);

    gbc.gridwidth = 1;

    JLabel lblName = new JLabel("Name :");
    gbc.gridx = 0;
    gbc.gridy = 1;
    add(lblName, gbc);

    textField = new JTextField(salesPerson.getName());
    textField.setColumns(20);
    gbc.gridx = 1;
    gbc.gridy = 1;
    add(textField, gbc);

    JLabel lblPosition = new JLabel("Position : ");
    gbc.gridx = 0;
    gbc.gridy = 2;
    add(lblPosition, gbc);

    textField_1 = new JTextField(salesPerson.getPosition());
    textField_1.setColumns(20);
    gbc.gridx = 1;
    gbc.gridy = 2;
    add(textField_1, gbc);

    JButton btnSave = new JButton("Save");
    btnSave.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {

        salesPerson.setName(textField.getText());
        salesPerson.setPosition(textField_1.getText());
        if (isAdd) {
          dealer.addSalesPerson(salesPerson);
        } else {
          dealerDAO.SalesPersonDAO.savesalesPerson(salesPerson);
        }
        currentFrame.getContentPane().removeAll();
        currentFrame.getContentPane().add(new SalesPersonSelection(currentFrame, dealer));
        currentFrame.getContentPane().revalidate();
      }
    });
    gbc.gridx = 0;
    gbc.gridy = 3;
    gbc.anchor = GridBagConstraints.EAST;
    gbc.fill = GridBagConstraints.NONE;
    add(btnSave, gbc);

    JButton btnCancel = new JButton("Cancel");
    btnCancel.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        currentFrame.getContentPane().removeAll();
        currentFrame.getContentPane().add(new SalesPersonSelection(currentFrame, dealer));
        currentFrame.getContentPane().revalidate();

      }
    });

    gbc.gridx = 1;
    gbc.gridy = 3;
    gbc.anchor = GridBagConstraints.WEST;
    add(btnCancel, gbc);

  }

}
