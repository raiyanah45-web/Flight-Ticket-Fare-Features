import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
 
public class FlightFareFrame extends JFrame implements ActionListener, MouseListener {
    ImageIcon img1, img2;
    JLabel fromLabel, toLabel, classLabel, passengerLabel, resultLabel;
    JLabel imageLabel1, imageLabel2;
    JComboBox<String> fromCB, toCB, classCB;
    JTextField passengerTF;
    JButton calcBtn, exitBtn;
    JTextArea taPurchaseArea;
 
public FlightFareFrame() {
   setTitle("Flight Ticket Fare Calculator");
   setSize(700, 600);
   setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
   setLayout(new BorderLayout(10, 10));
 
   img1 = new ImageIcon("plane1.png");
   img2 = new ImageIcon("plane2.png");

    imageLabel1 = new JLabel(img1);
    imageLabel2 = new JLabel(img2);

    JPanel imagePanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 20, 20));
    imagePanel.setBackground(new Color(173, 216, 230));
    imagePanel.add(imageLabel1);
    imagePanel.add(imageLabel2);
    imagePanel.setBorder(BorderFactory.createEmptyBorder(20, 10, 20, 10));
 
       
   JPanel formPanel = new JPanel(new GridLayout(6, 2, 10, 10));
   formPanel.setBackground(new Color(240, 248, 255));
   fromLabel = new JLabel("From:");
   toLabel = new JLabel("To:");
   classLabel = new JLabel("Class:");
   passengerLabel = new JLabel("Passengers:");
   resultLabel = new JLabel("Total Fare: ---");
   resultLabel.setForeground(Color.BLUE);
   resultLabel.setFont(new Font("Arial", Font.BOLD, 16));
   String[] cities = {"Dhaka", "Chittagong", "Sylhet", "Rajshahi"};
 
   fromCB = new JComboBox<>(cities);
   toCB = new JComboBox<>(cities);
 
   String[] classes = {"Economy", "Business", "First Class"};
   classCB = new JComboBox<>(classes);
   passengerTF = new JTextField();
   calcBtn = new JButton("Calculate Fare");
   calcBtn.setBackground(new Color(50, 205, 50));
   calcBtn.setForeground(Color.WHITE);
   exitBtn = new JButton("Exit");
   exitBtn.setBackground(new Color(220, 20, 60));
   exitBtn.setForeground(Color.WHITE);
   formPanel.add(fromLabel); formPanel.add(fromCB);
   formPanel.add(toLabel); formPanel.add(toCB);
   formPanel.add(classLabel); formPanel.add(classCB);
   formPanel.add(passengerLabel); formPanel.add(passengerTF);
   formPanel.add(calcBtn); formPanel.add(exitBtn);
   formPanel.add(new JLabel("")); formPanel.add(resultLabel);
 
    
	taPurchaseArea = new JTextArea();
    taPurchaseArea.setEditable(false);
    
	taPurchaseArea.setBorder(BorderFactory.createLineBorder(Color.BLACK));
    taPurchaseArea.setPreferredSize(new Dimension(650, 100));
    JScrollPane scrollPane = new JScrollPane(taPurchaseArea);
 
    add(imagePanel, BorderLayout.NORTH);
    add(formPanel, BorderLayout.CENTER);
    add(scrollPane, BorderLayout.SOUTH);
 
   calcBtn.addActionListener(this);
   exitBtn.addActionListener(e -> System.exit(0));
   taPurchaseArea.addMouseListener(this);
 
   setLocationRelativeTo(null);
   setVisible(true);
    }
 
   public void actionPerformed(ActionEvent e) {
   try {

   String from = (String) fromCB.getSelectedItem();
   String to = (String) toCB.getSelectedItem();
   String cls = (String) classCB.getSelectedItem();
   int passengers = Integer.parseInt(passengerTF.getText());
    if (from.equals(to)) {

   JOptionPane.showMessageDialog(this,
   "Departure and destination cannot be the same!",
    "Input Error",
   JOptionPane.WARNING_MESSAGE);
   return;
            }
 
   int baseFare = switch (cls) {
   case "Economy" -> 3000;
   case "Business" -> 6000;
   default -> 10000;
            };
 
   int totalFare = baseFare * passengers;
   resultLabel.setText("Total Fare: " + totalFare + " BDT");
   taPurchaseArea.append("From: " + from + " | To: " + to +
   " | Class: " + cls + " | Passengers: " + passengers +
   " | Total: " + totalFare + " BDT\n");
 
   } catch (NumberFormatException ex) {

   JOptionPane.showMessageDialog(this,
     "Please enter a valid number of passengers!",
     "Error", JOptionPane.ERROR_MESSAGE);
   }
  }
 
    

    public void mouseClicked(MouseEvent e) {
   if (e.getSource() == taPurchaseArea && e.getClickCount() == 1) {
   String selected = taPurchaseArea.getSelectedText();
   if (selected != null && !selected.isEmpty()) {
   JOptionPane.showMessageDialog(this,
   "You selected: " + selected,
   "Text Selected",
   JOptionPane.INFORMATION_MESSAGE);
    }
   }
  }

   public void mousePressed(MouseEvent e) {
	   
   }
   public void mouseReleased(MouseEvent e) {
	   
   }
   public void mouseEntered(MouseEvent e) {
	   
   }
   public void mouseExited(MouseEvent e) {
	   
   }
}
 
 
 