import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Deposit extends JFrame {
    String cardNo, pin;
    ResizableImagePanel resizableImagePanel;
    JTextField tf;
    public Deposit(String cardNo,String pin){
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
        //the black frame
        JPanel mainScreen = new JPanel();
        mainScreen.setBounds(135,215,345,220);
        mainScreen.setBackground(Color.BLACK);
        mainScreen.setLayout(null);
        this.getContentPane().add(mainScreen);

        //label
        JLabel label = new JLabel("ENTER THE AMOUNT DEPOSIT");
        label.setFont(new Font("Dialog", Font.BOLD,15));
        label.setBounds(25,50,300,40);
        label.setForeground(Color.WHITE);
        mainScreen.add(label);

        //text field
        tf = new JTextField();
        tf.setBounds(25,90,300,40);
        tf.setEditable(true);
        tf.setFont(new Font("Dialog", Font.BOLD, 15));
        mainScreen.add(tf);

        //button
        JButton depositButton = new JButton("DEPOSIT");
        depositButton.setFont(new Font("Dialog", Font.BOLD, 12));
        depositButton.setBounds(240,150,100,30);
        depositButton.setFocusable(false);
        depositButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                MyJDBC db = new MyJDBC();
                NumberGenerator time = new NumberGenerator();
                if(tf.getText().isEmpty()){
                    JOptionPane.showMessageDialog(null,"Please enter an amount");
                }else {
                    double balance = db.getBalance(cardNo);
                    double amountDeposit = Double.parseDouble(tf.getText());
                    balance = balance +amountDeposit;
                    db.updateBalance(cardNo,balance);
                    db.historyTransaction(cardNo, time.dateTime(),"Deposit",String.valueOf(amountDeposit));
                    JOptionPane.showMessageDialog(null,"RM "+ amountDeposit +" Deposited Successfully");
                }
            }
        });
        mainScreen.add(depositButton);

        JButton backButton = new JButton("Back");
        backButton.setFont(new Font("Dialog",Font.BOLD,12));
        backButton.setBounds(10,150,100,30);
        backButton.setFocusable(false);
        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                ATM atm = new ATM(cardNo, pin);
                atm.setVisible(true);

            }
        });
        mainScreen.add(backButton);
    }




}
