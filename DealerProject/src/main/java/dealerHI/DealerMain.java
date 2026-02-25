package dealerHI;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.Font;

import dealerPD.Dealer;

public class DealerMain extends JPanel {

  /**
   * Create the panel.
   */
  public DealerMain(Dealer dealer) {
    setLayout(new GridBagLayout());
    GridBagConstraints gbc = new GridBagConstraints();
    gbc.insets = new Insets(10, 10, 10, 10);

    JLabel lblNewLabel = new JLabel(dealer.getName());
    lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 24));
    lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);

    gbc.gridx = 0;
    gbc.gridy = 0;
    gbc.anchor = GridBagConstraints.CENTER;
    add(lblNewLabel, gbc);

    JLabel lblCarsForSale = new JLabel("Cars for Sale: " + dealer.getCarForSaleCount());
    lblCarsForSale.setFont(new Font("Tahoma", Font.PLAIN, 16));

    gbc.gridy = 1;
    add(lblCarsForSale, gbc);

  }
}
