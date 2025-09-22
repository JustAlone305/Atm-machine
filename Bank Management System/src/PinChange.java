import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.PreparedStatement;

public class PinChange extends JFrame {
    String cardNo,pin;
    ResizableImagePanel resizableImagePanel;
    JPasswordField currentPinTf, newPinTf, reenterPinTf;
    public PinChange(String cardNo,String pin){
        this.cardNo = cardNo;
        this.pin = pin;
        this.setTitle("AUTOMATED TELLER MACHINE");
        resizableImagePanel = new ResizableImagePanel("C:\\Users\\User\\IdeaProjects\\Bank Management System\\src\\img2.png");
        resizableImagePanel.setLayout(null);
        this.setSize(900,700);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setContentPane(resizableImagePanel);
        addGuiComponent();


    }
    private void addGuiComponent() {
        JPanel mainScreen = new JPanel();
        mainScreen.setBounds(135, 215, 345, 220);
        mainScreen.setBackground(Color.BLACK);
        mainScreen.setLayout(null);
        this.getContentPane().add(mainScreen);

        JLabel label = new JLabel("CHANGE YOUR PIN");
        label.setFont(new Font("Dialog", Font.BOLD,18));
        label.setBounds(100,5,300,30);
        label.setForeground(Color.WHITE);
        mainScreen.add(label);

        JLabel currentPinLabel = new JLabel("Current PIN:");
        currentPinLabel.setFont(new Font("Dialog",Font.BOLD,15));
        currentPinLabel.setBounds(5,50,200,30);
        currentPinLabel.setForeground(Color.WHITE);
        mainScreen.add(currentPinLabel);

        JLabel newPinLabel = new JLabel("New PIN:");
        newPinLabel.setFont(new Font("Dialog",Font.BOLD,15));
        newPinLabel.setBounds(5,90,200,30);
        newPinLabel.setForeground(Color.WHITE);
        mainScreen.add(newPinLabel);

        JLabel reenterPinLabel = new JLabel("Re-Enter New PIN:");
        reenterPinLabel.setFont(new Font("Dialog",Font.BOLD,15));
        reenterPinLabel.setBounds(5,130,200,30);
        reenterPinLabel.setForeground(Color.WHITE);
        mainScreen.add(reenterPinLabel);

        currentPinTf = new JPasswordField();
        currentPinTf.setFont(new Font("Dialog",Font.BOLD,15));
        currentPinTf.setBounds(200,50,100,30);
        currentPinTf.setEditable(true);
        mainScreen.add(currentPinTf);

        newPinTf = new JPasswordField();
        newPinTf.setFont(new Font("Dialog",Font.BOLD,15));
        newPinTf.setBounds(200,90,100,30);
        newPinTf.setEditable(true);
        mainScreen.add(newPinTf);

        reenterPinTf = new JPasswordField();
        reenterPinTf.setFont(new Font("Dialog",Font.BOLD,15));
        reenterPinTf.setBounds(200,130,100,30);
        reenterPinTf.setEditable(true);
        mainScreen.add(reenterPinTf);

        JButton pinChangeButton = new JButton("CHANGE PIN");
        pinChangeButton.setFont(new Font("Dialog", Font.BOLD, 12));
        pinChangeButton.setBounds(185,180,160,30);
        pinChangeButton.setFocusable(false);
        pinChangeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                    String currentPin = currentPinTf.getText();
                    String newPin = newPinTf.getText();
                    String reenterPin = reenterPinTf.getText();
                    if(!(currentPin.length() == 4 && newPin.length() == 4 && reenterPin.length() ==4)){
                        JOptionPane.showMessageDialog(null,"PIN must be in 4-digits");
                    }else if(!currentPin.equals(pin)){
                        JOptionPane.showMessageDialog(null,"Wrong current pin");
                    }else if(!newPin.equals(reenterPin)){
                        JOptionPane.showMessageDialog(null,"Re-Enter PIN and new PIN is different");
                    }else{
                        MyJDBC db = new MyJDBC();
                        db.updatePin(cardNo,newPin);
                        JOptionPane.showMessageDialog(null,"PIN change successful");
                    }

                } catch (Exception ex) {
                    throw new RuntimeException(ex);
                }
            }
        });
        mainScreen.add(pinChangeButton);

        JButton backButton = new JButton("Back");
        backButton.setFont(new Font("Dialog",Font.BOLD,12));
        backButton.setBounds(10,180,100,30);
        backButton.setFocusable(false);
        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ATM atm = new ATM(cardNo, pin);
                atm.setVisible(true);
                dispose();
            }
        });
        mainScreen.add(backButton);



    }
}
