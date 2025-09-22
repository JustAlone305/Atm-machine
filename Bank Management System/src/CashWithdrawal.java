import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.*;

public class CashWithdrawal extends JFrame {
    String cardNo, pin;
    ResizableImagePanel resizableImagePanel;
    JTextField tf;
    public CashWithdrawal(String cardNo,String pin){
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

    private void addGuiComponent(){
        JPanel mainScreen = new JPanel();
        mainScreen.setBounds(135,215,345,220);
        mainScreen.setBackground(Color.BLACK);
        mainScreen.setLayout(null);
        this.getContentPane().add(mainScreen);

        JLabel label = new JLabel("ENTER THE AMOUNT WITHDRAWAL");
        label.setFont(new Font("Dialog", Font.BOLD,15));
        label.setBounds(25,50,300,40);
        label.setForeground(Color.WHITE);
        mainScreen.add(label);

        JLabel anotherLabel = new JLabel("MAXIMUM WITHDRAWAL IS RM 10000");
        anotherLabel.setFont(new Font("Dialog", Font.BOLD,12));
        anotherLabel.setBounds(25,0,300,40);
        anotherLabel.setForeground(Color.WHITE);
        mainScreen.add(anotherLabel);

        //text field
        tf = new JTextField();
        tf.setBounds(25,90,300,40);
        tf.setEditable(true);
        tf.setFont(new Font("Dialog", Font.BOLD, 15));
        mainScreen.add(tf);

        JButton withdrawalButton = new JButton("WITHDRAW");
        withdrawalButton.setFont(new Font("Dialog", Font.BOLD, 12));
        withdrawalButton.setBounds(240,150,100,30);
        withdrawalButton.setFocusable(false);
        withdrawalButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                MyJDBC db = new MyJDBC();
                NumberGenerator time = new NumberGenerator();
                if (tf.getText().isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Please enter an amount");
                } else {
                    double balance = db.getBalance(cardNo);
                    double amountWithdraw = Double.parseDouble(tf.getText());

                    if (balance < amountWithdraw) {
                        JOptionPane.showMessageDialog(null, "Withdrawal unsuccessful, balance is too low");
                    }else{
                        balance = balance - amountWithdraw;
                        db.updateBalance(cardNo, balance);
                        db.historyTransaction(cardNo, time.dateTime(),"Withdraw",String.valueOf(amountWithdraw));
                        JOptionPane.showMessageDialog(null, "RM " + amountWithdraw + " Withdraw Successfully");
                    }
                }
            }

        });
        mainScreen.add(withdrawalButton);

        JButton backButton = new JButton("Back");
        backButton.setFont(new Font("Dialog",Font.BOLD,12));
        backButton.setBounds(10,150,100,30);
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
