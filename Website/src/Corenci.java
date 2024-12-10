import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;
import java.util.HashMap;
import java.awt.color.*;

public class Corenci {
    private static final HashMap<String, Double> exchangeRates;
    private static final HashMap<String, String> currencyCodes;

    // Conversion December 4, (1030PM)

    // Initialize exchange rates (relative to USD)
    static {
        exchangeRates = new HashMap<>();
        exchangeRates.put("USD", 1.00);
        exchangeRates.put("EUR", 0.9514);
        exchangeRates.put("GBP", 0.7893);
        exchangeRates.put("CAD", 1.4055);
        exchangeRates.put("AUD", 1.5421);
        exchangeRates.put("JPY", 149.5907);
        exchangeRates.put("INR", 84.7323);
        exchangeRates.put("NZD", 1.7000);
        exchangeRates.put("CHF", 0.8859);
        exchangeRates.put("ZAR", 18.1052);
        exchangeRates.put("RUB", 105.6494);
        exchangeRates.put("BGN", 1.8607);
        exchangeRates.put("SGD", 1.3449);
        exchangeRates.put("HKD", 7.7830);
        exchangeRates.put("SEK", 11.0051);
        exchangeRates.put("THB", 34.3687);
        exchangeRates.put("HUF", 394.3107);
        exchangeRates.put("CNY", 7.2911);
        exchangeRates.put("NOK", 11.0614);
        exchangeRates.put("MXN", 20.3289);
        exchangeRates.put("DKK", 7.0982);
        exchangeRates.put("MYR", 4.4691);
        exchangeRates.put("PLN", 4.0835);
        exchangeRates.put("BRL", 6.0658);
        exchangeRates.put("PHP", 58.5245);
        exchangeRates.put("IDR", 15960.7626);
        exchangeRates.put("CZK", 23.9523);
        exchangeRates.put("AED", 3.6725);
        exchangeRates.put("TWD", 32.5449);
        exchangeRates.put("KRW", 1410.7206);
        exchangeRates.put("ILS", 3.6231);
        exchangeRates.put("ARS", 1013.1700);
        exchangeRates.put("CLP", 978.6646);
        exchangeRates.put("EGP", 49.7271);
        exchangeRates.put("TRY", 34.7574);
        exchangeRates.put("RON", 4.7335);
        exchangeRates.put("SAR", 3.7500);
        exchangeRates.put("PKR", 278.2120);
        exchangeRates.put("COP", 4453.9112);
        exchangeRates.put("IQD", 1307.9109);
        exchangeRates.put("SHP", 0.7893);
        exchangeRates.put("FJD", 2.2722);
        exchangeRates.put("KWD", 0.3073);
        exchangeRates.put("BAM", 1.8608);
        exchangeRates.put("ISK", 138.5275);
        exchangeRates.put("MAD", 10.0175);
        exchangeRates.put("VND", 25416.6329);
        exchangeRates.put("JMD", 157.0136);
        exchangeRates.put("JOD", 0.7090);
    }

    // Apelyido per Currency
    static {
        currencyCodes = new HashMap<>();
        currencyCodes.put("US Dollar (USD)", "USD");
        currencyCodes.put("Euro (EUR)", "EUR");
        currencyCodes.put("British Pound (GBP)", "GBP");
        currencyCodes.put("Canadian Dollar (CAD)", "CAD");
        currencyCodes.put("Australian Dollar (AUD)", "AUD");
        currencyCodes.put("Japanese Yen (JPY)", "JPY");
        currencyCodes.put("Indian Rupee (INR)", "INR");
        currencyCodes.put("New Zealand Dollar (NZD)", "NZD");
        currencyCodes.put("Swiss Franc (CHF)", "CHF");
        currencyCodes.put("South African Rand (ZAR)", "ZAR");
        currencyCodes.put("Russian Ruble (RUB)", "RUB");
        currencyCodes.put("Bulgarian Lev (BGN)", "BGN");
        currencyCodes.put("Singapore Dollar (SGD)", "SGD");
        currencyCodes.put("Hong Kong Dollar (HKD)", "HKD");
        currencyCodes.put("Swedish Krona (SEK)", "SEK");
        currencyCodes.put("Thai Baht (THB)", "THB");
        currencyCodes.put("Hungarian Forint (HUF)", "HUF");
        currencyCodes.put("Chinese Yuan Renminbi (CNY)", "CNY");
        currencyCodes.put("Norwegian Krone (NOK)", "NOK");
        currencyCodes.put("Mexican Peso (MXN)", "MXN");
        currencyCodes.put("Danish Krone (DKK)", "DKK");
        currencyCodes.put("Malaysian Ringgit (MYR)", "MYR");
        currencyCodes.put("Polish Zloty (PLN)", "PLN");
        currencyCodes.put("Brazilian Real (BRL)", "BRL");
        currencyCodes.put("Philippine Peso (PHP)", "PHP");
        currencyCodes.put("Indonesian Rupiah (IDR)", "IDR");
        currencyCodes.put("Czech Koruna (CZK)", "CZK");
        currencyCodes.put("Emirati Dirham (AED)", "AED");
        currencyCodes.put("Taiwan New Dollar (TWD)", "TWD");
        currencyCodes.put("South Korean Won (KRW)", "KRW");
        currencyCodes.put("Israeli Shekel (ILS)", "ILS");
        currencyCodes.put("Argentine Peso (ARS)", "ARS");
        currencyCodes.put("Chilean Peso (CLP)", "CLP");
        currencyCodes.put("Egyptian Pound (EGP)", "EGP");
        currencyCodes.put("Turkish Lira (TRY)", "TRY");
        currencyCodes.put("Romanian Leu (RON)", "RON");
        currencyCodes.put("Saudi Arabian Riyal (SAR)", "SAR");
        currencyCodes.put("Pakistani Rupee (PKR)", "PKR");
        currencyCodes.put("Colombian Peso (COP)", "COP");
        currencyCodes.put("Iraqi Dinar (IQD)", "IQD");
        currencyCodes.put("Saint Helenian Pound (SHP)", "SHP");
        currencyCodes.put("Fijian Dollar (FJD)", "FJD");
        currencyCodes.put("Kuwaiti Dinar (KWD)", "KWD");
        currencyCodes.put("Bosnian Convertible Mark (BAM)", "BAM");
        currencyCodes.put("Icelandic Krona (ISK)", "ISK");
        currencyCodes.put("Moroccan Dirham (MAD)", "MAD");
        currencyCodes.put("Vietnamese Dong (VND)", "VND");
        currencyCodes.put("Jamaican Dollar (JMD)", "JMD");
        currencyCodes.put("Jordanian Dinar (JOD)", "JOD");
    }

    public static void getWindowSize(JFrame frame) {
        Dimension size = Toolkit.getDefaultToolkit().getScreenSize();
        frame.setSize((int) size.getWidth(), (int) size.getHeight());
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Ranny CC24");
        getWindowSize(frame);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setBackground(Color.pink);
        frame.setLayout(null);
        frame.setLocationRelativeTo(null);
        frame.setResizable(true);

        JLabel pic = new JLabel();
        pic.setIcon(new ImageIcon("C:\\Users\\Acer\\Desktop\\Website\\src\\Resources\\soft pink.png"));
        pic.setBounds(-130,-230, 700, 1000);
        frame.add(pic);

        String[] currencyOptions = currencyCodes.keySet().toArray(new String[0]);
        Arrays.sort(currencyOptions); // Sorting alphabetically

        JLabel progTitle = new JLabel("Currency Converter");
        progTitle.setBounds(700, 80, 600, 99);
        progTitle.setFont(new Font("Gyahegi", Font.PLAIN, 40));
        frame.add(progTitle);


        JLabel fromCurrencyLabel = new JLabel("From Currency:");
        fromCurrencyLabel.setBounds(630, 200, 300, 50);
        fromCurrencyLabel.setFont(new Font("Arial Bold", Font.PLAIN, 30));
        frame.add(fromCurrencyLabel);

        JComboBox<String> fromCurrency = new JComboBox<>(currencyOptions);
        fromCurrency.setBounds(950, 210, 300, 35);
        frame.add(fromCurrency);


        JLabel toCurrencyLabel = new JLabel("To Currency:");
        toCurrencyLabel.setBounds(630, 270, 300, 75);
        toCurrencyLabel.setFont(new Font("Arial Bold", Font.PLAIN, 30));
        frame.add(toCurrencyLabel);

        JComboBox<String> toCurrency = new JComboBox<>(currencyOptions);
        toCurrency.setBounds(950, 290, 300, 35);
        frame.add(toCurrency);


        JLabel amountLabel = new JLabel("Enter Amount:");
        amountLabel.setBounds(630, 370, 300, 25);
        amountLabel.setFont(new Font("Arial Bold", Font.PLAIN, 30));
        frame.add(amountLabel);

        JTextField amountInput = new JTextField();
        amountInput.setBounds(950, 370, 300, 35);
        frame.add(amountInput);


        JButton submitButton = new JButton("Convert");
        submitButton.setBounds(710, 440, 150, 40);
        frame.add(submitButton);


        JButton exitButton = new JButton("Exit");
        exitButton.setBounds(930, 440, 150, 40);
        frame.add(exitButton);


        exitButton.addActionListener(e -> System.exit(0));


        submitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    // Parse the amount
                    double amount = Double.parseDouble(amountInput.getText());
                    String fromCurrencyCode = currencyCodes.get((String) fromCurrency.getSelectedItem());
                    String toCurrencyCode = currencyCodes.get((String) toCurrency.getSelectedItem());

                    if (fromCurrencyCode.equals(toCurrencyCode)) {
                        JOptionPane.showMessageDialog(frame, "Same currency selected. No conversion needed.", "Info", JOptionPane.INFORMATION_MESSAGE);
                        return;
                    }

                    if (exchangeRates.containsKey(fromCurrencyCode) && exchangeRates.containsKey(toCurrencyCode)) {
                        //source currency to usd, then sa target currency
                        double usdAmount = amount / exchangeRates.get(fromCurrencyCode);
                        double convertedAmount = usdAmount * exchangeRates.get(toCurrencyCode);

                        String result = String.format("%.2f %s = %.2f %s", amount, fromCurrencyCode, convertedAmount, toCurrencyCode);
                        JOptionPane.showMessageDialog(frame, result, "Converted Amount", JOptionPane.INFORMATION_MESSAGE);
                    } else {
                        JOptionPane.showMessageDialog(frame, "Currency not supported.", "Error", JOptionPane.ERROR_MESSAGE);
                    }
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(frame, "Please enter a valid amount.", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        frame.setVisible(true);
    }
}
