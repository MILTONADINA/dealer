package dealerHI;

import javax.swing.JFrame;
import javax.swing.JPanel;

import dealerPD.Car;
import dealerPD.Dealer;
import dealerPD.SalesPerson;

import javax.swing.JLabel;
import javax.swing.JTextField;

import dealerDAO.emDAO;

import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.awt.event.ActionEvent;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.Font;

public class CarEdit extends JPanel {
  private JTextField textField;
  private JTextField textField_1;
  private JTextField textField_2;
  private JTextField textField_3;
  private JTextField textField_4;
  private JTextField textField_5;
  private JComboBox comboBox;
  private JTextField textField_6;

  /**
   * Create the panel.
   */
  public CarEdit(JFrame currentFrame, Dealer dealer, Car car, Boolean isAdd) {
    DateTimeFormatter dateFormater = DateTimeFormatter.ofPattern("M/d/yyyy");
    setLayout(new GridBagLayout());
    GridBagConstraints gbc = new GridBagConstraints();
    gbc.insets = new Insets(10, 10, 10, 10);
    gbc.fill = GridBagConstraints.HORIZONTAL;

    // Removed detached refresh calls

    JLabel lblCarEdit = new JLabel("Car Edit");
    lblCarEdit.setFont(new Font("Tahoma", Font.BOLD, 18));
    gbc.gridx = 0;
    gbc.gridy = 0;
    gbc.gridwidth = 2;
    add(lblCarEdit, gbc);

    gbc.gridwidth = 1;

    JLabel lblMake = new JLabel("Make : ");
    gbc.gridx = 0;
    gbc.gridy = 1;
    add(lblMake, gbc);

    textField = new JTextField(car.getMake());
    textField.setColumns(20);
    gbc.gridx = 1;
    gbc.gridy = 1;
    add(textField, gbc);

    JLabel lblModel = new JLabel("Model :");
    gbc.gridx = 0;
    gbc.gridy = 2;
    add(lblModel, gbc);

    textField_1 = new JTextField(car.getModel());
    textField_1.setColumns(20);
    gbc.gridx = 1;
    gbc.gridy = 2;
    add(textField_1, gbc);

    JLabel lblYear = new JLabel("Year :");
    gbc.gridx = 0;
    gbc.gridy = 3;
    add(lblYear, gbc);

    textField_2 = new JTextField(car.getYear());
    textField_2.setColumns(20);
    gbc.gridx = 1;
    gbc.gridy = 3;
    add(textField_2, gbc);

    JLabel lblSerialNumber = new JLabel("Serial Number");
    gbc.gridx = 0;
    gbc.gridy = 4;
    add(lblSerialNumber, gbc);

    textField_3 = new JTextField(car.getSerialNumber());
    textField_3.setColumns(20);
    gbc.gridx = 1;
    gbc.gridy = 4;
    add(textField_3, gbc);

    JLabel lblPrice = new JLabel("Price :");
    gbc.gridx = 0;
    gbc.gridy = 5;
    add(lblPrice, gbc);

    String price = null;
    if (car.getPrice() != null)
      price = car.getPrice().toString();
    textField_6 = new JTextField(price);
    textField_6.setColumns(20);
    gbc.gridx = 1;
    gbc.gridy = 5;
    add(textField_6, gbc);

    JLabel lblDatePurchased = new JLabel("Date Purchased :");
    gbc.gridx = 0;
    gbc.gridy = 6;
    add(lblDatePurchased, gbc);

    String date = null;
    if (car.getDatePurchased() != null)
      date = car.getDatePurchased().format(dateFormater);
    textField_4 = new JTextField(date);
    textField_4.setColumns(20);
    gbc.gridx = 1;
    gbc.gridy = 6;
    add(textField_4, gbc);

    JLabel lblDateSold = new JLabel("Date Sold :");
    gbc.gridx = 0;
    gbc.gridy = 7;
    add(lblDateSold, gbc);

    date = null;
    if (car.getDateSold() != null)
      date = car.getDateSold().format(dateFormater);
    textField_5 = new JTextField(date);
    textField_5.setColumns(20);
    gbc.gridx = 1;
    gbc.gridy = 7;
    add(textField_5, gbc);

    JLabel lblSalesperson = new JLabel("SalesPerson :");
    gbc.gridx = 0;
    gbc.gridy = 8;
    add(lblSalesperson, gbc);

    comboBox = new JComboBox();
    comboBox.addItem(null);
    for (SalesPerson salesPerson : dealer.getSalesPersons())
      comboBox.addItem(salesPerson);
    comboBox.setSelectedItem(car.getSalesPerson());
    gbc.gridx = 1;
    gbc.gridy = 8;
    add(comboBox, gbc);

    JButton btnSave = new JButton("Save");
    btnSave.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        car.setMake(textField.getText());
        car.setModel(textField_1.getText());
        car.setYear(textField_2.getText());
        car.setSerialNumber(textField_3.getText());

        if (!textField_4.getText().isEmpty())
          car.setDatePurchased(LocalDate.parse(textField_4.getText(), dateFormater));
        if (!textField_5.getText().isEmpty())
          car.setDateSold(LocalDate.parse(textField_5.getText(), dateFormater));
        if (!textField_6.getText().isEmpty())
          car.setPrice(new BigDecimal(textField_6.getText()));
        car.setSalesPerson((SalesPerson) comboBox.getSelectedItem());
        if (isAdd) {
          dealer.addCar(car);
        } else {
          dealerDAO.CarDAO.saveCar(car);
        }
        currentFrame.getContentPane().removeAll();
        currentFrame.getContentPane().add(new CarSelection(currentFrame, dealer));
        currentFrame.getContentPane().revalidate();
      }
    });
    gbc.gridx = 0;
    gbc.gridy = 9;
    gbc.fill = GridBagConstraints.NONE;
    gbc.anchor = GridBagConstraints.EAST;
    add(btnSave, gbc);

    JButton btnCancel = new JButton("Cancel");
    btnCancel.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        currentFrame.getContentPane().removeAll();
        currentFrame.getContentPane().add(new CarSelection(currentFrame, dealer));
        currentFrame.getContentPane().revalidate();
      }
    });

    gbc.gridx = 1;
    gbc.gridy = 9;
    gbc.anchor = GridBagConstraints.WEST;
    add(btnCancel, gbc);

  }
}
