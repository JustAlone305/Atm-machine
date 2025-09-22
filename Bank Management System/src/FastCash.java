import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FastCash extends JFrame implements ActionListener{
    String cardNo, pin;
    ResizableImagePanel resizableImagePanel;
    JButton hundreadButton,fiveHundreadButton,twoThousandButton,fiveThousandButton,thousandButton,millionButton;
    public FastCash(String cardNo,String pin) {
        this.cardNo = cardNo;
        this.pin = pin;
        this.setTitle("AUTOMATED TELLER MACHINE");
        resizableImagePanel = new ResizableImagePanel("C:\\Users\\User\\IdeaProjects\\Bank Management System\\src\\img2.png");
        resizableImagePanel.setLayout(null);
        this.setSize(900, 700);
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

        JLabel title = new JLabel("Please Select Withdrawal amount");
        title.setFont(new Font("Dialog", Font.BOLD,15));
        title.setBounds(65,10,300,40);
        title.setForeground(Color.WHITE);
        mainScreen.add(title);

        //button
        hundreadButton = new JButton("RM 100");
        hundreadButton.setFont(new Font("Dialog",Font.BOLD,12));
        hundreadButton.setBounds(10,60,160,30);
        hundreadButton.setFocusable(false);
        hundreadButton.addActionListener(this);
        mainScreen.add(hundreadButton);

        thousandButton = new JButton("RM 1000");
        thousandButton.setFont(new Font("Dialog",Font.BOLD,12));
        thousandButton.setBounds(10,90,160,30);
        thousandButton.setFocusable(false);
        thousandButton.addActionListener(this);
        mainScreen.add(thousandButton);

        fiveThousandButton = new JButton("RM 5000");
        fiveThousandButton.setFont(new Font("Dialog",Font.BOLD,12));
        fiveThousandButton.setBounds(10,120,160,30);
        fiveThousandButton.setFocusable(false);
        fiveThousandButton.addActionListener(this);
        mainScreen.add(fiveThousandButton);

        fiveHundreadButton = new JButton("RM 500");
        fiveHundreadButton.setFont(new Font("Dialog",Font.BOLD,12));
        fiveHundreadButton.setBounds(180,60,160,30);
        fiveHundreadButton.setFocusable(false);
        fiveHundreadButton.addActionListener(this);
        mainScreen.add(fiveHundreadButton);

        twoThousandButton = new JButton("RM 2000");
        twoThousandButton.setFont(new Font("Dialog",Font.BOLD,12));
        twoThousandButton.setBounds(180,90,160,30);
        twoThousandButton.setFocusable(false);
        twoThousandButton.addActionListener(this);
        mainScreen.add(twoThousandButton);

        millionButton = new JButton("RM 10000");
        millionButton.setFont(new Font("Dialog",Font.BOLD,12));
        millionButton.setBounds(180,120,160,30);
        millionButton.setFocusable(false);
        millionButton.addActionListener(this);
        mainScreen.add(millionButton);

        JButton backButton = new JButton("BACK");
        backButton.setFont(new Font("Dialog",Font.BOLD,12));
        backButton.setBounds(180,150,160,30);
        backButton.setFocusable(false);
        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ATM atm = new ATM(cardNo, pin);
                atm.setVisible(true);
            }
        });
        mainScreen.add(backButton);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        double amountWithdraw;
        MyJDBC db = new MyJDBC();
        NumberGenerator time = new NumberGenerator();
        if (e.getSource() == hundreadButton){
            amountWithdraw = 100.00;

            double balance = db.getBalance(cardNo);

            if (balance < amountWithdraw) {
                JOptionPane.showMessageDialog(null, "Withdrawal unsuccessful, balance is too low");
            }else{
                balance = balance - amountWithdraw;
                db.updateBalance(cardNo, balance);
                db.historyTransaction(cardNo, time.dateTime(),"Withdraw",String.valueOf(amountWithdraw));
                JOptionPane.showMessageDialog(null, "RM " + amountWithdraw + " Withdraw Successfully");
            }
        }
        if(e.getSource() == fiveHundreadButton){
            amountWithdraw = 500.00;
            double balance = db.getBalance(cardNo);
            if (balance < amountWithdraw) {
                JOptionPane.showMessageDialog(null, "Withdrawal unsuccessful, balance is too low");
            }else{
                balance = balance - amountWithdraw;
                db.updateBalance(cardNo, balance);
                db.historyTransaction(cardNo, time.dateTime(),"Withdraw",String.valueOf(amountWithdraw));
                JOptionPane.showMessageDialog(null, "RM " + amountWithdraw + " Withdraw Successfully");
            }
        }
        if(e.getSource() == thousandButton){
            amountWithdraw = 1000.00;
            double balance = db.getBalance(cardNo);
            if (balance < amountWithdraw) {
                JOptionPane.showMessageDialog(null, "Withdrawal unsuccessful, balance is too low");
            }else{
                balance = balance - amountWithdraw;
                db.updateBalance(cardNo, balance);
                db.historyTransaction(cardNo, time.dateTime(),"Withdraw",String.valueOf(amountWithdraw));
                JOptionPane.showMessageDialog(null, "RM " + amountWithdraw + " Withdraw Successfully");
            }
        }
        if(e.getSource() == twoThousandButton){
            amountWithdraw = 2000.00;
            double balance = db.getBalance(cardNo);
            if (balance < amountWithdraw) {
                JOptionPane.showMessageDialog(null, "Withdrawal unsuccessful, balance is too low");
            }else{
                balance = balance - amountWithdraw;
                db.updateBalance(cardNo, balance);
                db.historyTransaction(cardNo, time.dateTime(),"Withdraw",String.valueOf(amountWithdraw));
                JOptionPane.showMessageDialog(null, "RM " + amountWithdraw + " Withdraw Successfully");
            }
        }
        if (e.getSource() == fiveThousandButton){
            amountWithdraw = 5000.00;
            double balance = db.getBalance(cardNo);
            if (balance < amountWithdraw) {
                JOptionPane.showMessageDialog(null, "Withdrawal unsuccessful, balance is too low");
            }else{
                balance = balance - amountWithdraw;
                db.updateBalance(cardNo, balance);
                db.historyTransaction(cardNo, time.dateTime(),"Withdraw",String.valueOf(amountWithdraw));
                JOptionPane.showMessageDialog(null, "RM " + amountWithdraw + " Withdraw Successfully");
            }
        }
        if(e.getSource() == millionButton){
            amountWithdraw = 10000.00;
            double balance = db.getBalance(cardNo);
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
}
