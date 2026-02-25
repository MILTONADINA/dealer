package dealerHI;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import dealerDAO.DealerDAO;

import dealerPD.Dealer;

import javax.swing.JButton;
import javax.swing.JFrame;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.Font;

public class DealerEdit extends JPanel {
  private JTextField textField;
  private JTextField textField_1;
  private JTextField textField_2;
  private JTextField textField_3;
  private JTextField textField_4;

  /**
   * Create the panel.
   */
  public DealerEdit(JFrame currentFrame, Dealer dealer) {
    setLayout(new GridBagLayout());
    GridBagConstraints gbc = new GridBagConstraints();
    gbc.insets = new Insets(10, 10, 10, 10);
    gbc.fill = GridBagConstraints.HORIZONTAL;

    // Removed detached refresh

    JLabel lblDealerEdit = new JLabel("Dealer Edit");
    lblDealerEdit.setFont(new Font("Tahoma", Font.BOLD, 18));
    lblDealerEdit.setHorizontalAlignment(SwingConstants.CENTER);
    gbc.gridx = 0;
    gbc.gridy = 0;
    gbc.gridwidth = 4;
    add(lblDealerEdit, gbc);

    gbc.gridwidth = 1;

    JLabel lblName = new JLabel("Name :");
    gbc.gridx = 0;
    gbc.gridy = 1;
    add(lblName, gbc);

    textField = new JTextField(dealer.getName());
    textField.setColumns(20);
    gbc.gridx = 1;
    gbc.gridy = 1;
    gbc.gridwidth = 3;
    add(textField, gbc);

    JLabel lblAddress = new JLabel("Address :");
    gbc.gridx = 0;
    gbc.gridy = 2;
    gbc.gridwidth = 1;
    add(lblAddress, gbc);

    textField_1 = new JTextField(dealer.getAddress());
    textField_1.setColumns(20);
    gbc.gridx = 1;
    gbc.gridy = 2;
    gbc.gridwidth = 3;
    add(textField_1, gbc);

    JLabel lblCityStateZip = new JLabel("City, State, Zip :");
    gbc.gridx = 0;
    gbc.gridy = 3;
    gbc.gridwidth = 1;
    add(lblCityStateZip, gbc);

    textField_2 = new JTextField(dealer.getCity());
    textField_2.setColumns(12);
    gbc.gridx = 1;
    gbc.gridy = 3;
    add(textField_2, gbc);

    textField_3 = new JTextField(dealer.getState());
    textField_3.setColumns(2);
    gbc.gridx = 2;
    gbc.gridy = 3;
    add(textField_3, gbc);

    textField_4 = new JTextField(dealer.getZip());
    textField_4.setColumns(5);
    gbc.gridx = 3;
    gbc.gridy = 3;
    add(textField_4, gbc);

    JButton btnSave = new JButton("Save");
    btnSave.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {

        dealer.setName(textField.getText());
        dealer.setAddress(textField_1.getText());
        dealer.setCity(textField_2.getText());
        dealer.setState(textField_3.getText());
        dealer.setZip(textField_4.getText());
        DealerDAO.saveDealer(dealer);

        currentFrame.getContentPane().removeAll();
        currentFrame.getContentPane().add(new DealerMain(dealer));
        currentFrame.getContentPane().revalidate();
      }
    });
    gbc.gridx = 1;
    gbc.gridy = 4;
    gbc.gridwidth = 1;
    gbc.anchor = GridBagConstraints.EAST;
    gbc.fill = GridBagConstraints.NONE;
    add(btnSave, gbc);

    JButton btnCancel = new JButton("Cancel");
    btnCancel.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        currentFrame.getContentPane().removeAll();
        currentFrame.getContentPane().add(new DealerMain(dealer));
        currentFrame.getContentPane().revalidate();
      }
    });

    gbc.gridx = 2;
    gbc.gridy = 4;
    gbc.gridwidth = 2;
    gbc.anchor = GridBagConstraints.WEST;
    add(btnCancel, gbc);

  }
}
