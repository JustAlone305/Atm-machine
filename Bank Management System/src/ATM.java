import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class ATM extends JFrame {
    String cardNo, pin;
    ResizableImagePanel resizableImagePanel;
    public ATM(String cardNo,String pin){
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

        //label
        JLabel title = new JLabel("Please Select Your Transaction");
        title.setFont(new Font("Dialog", Font.BOLD,15));
        title.setBounds(65,10,300,40);
        title.setForeground(Color.WHITE);
        mainScreen.add(title);

        //button
        JButton depositButton = new JButton("DEPOSIT");
        depositButton.setFont(new Font("Dialog",Font.BOLD,12));
        depositButton.setBounds(10,60,160,30);
        depositButton.setFocusable(false);
        depositButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                Deposit deposit = new Deposit(cardNo, pin);
                deposit.setVisible(true);
            }
        });
        mainScreen.add(depositButton);

        JButton fastCashButton = new JButton("FAST CASH");
        fastCashButton.setFont(new Font("Dialog",Font.BOLD,12));
        fastCashButton.setBounds(10,90,160,30);
        fastCashButton.setFocusable(false);
        fastCashButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                FastCash fastCash = new FastCash(cardNo,pin);
                fastCash.setVisible(true);
            }
        });
        mainScreen.add(fastCashButton);

        JButton pinChangeButton = new JButton("PIN CHANGE");
        pinChangeButton.setFont(new Font("Dialog",Font.BOLD,12));
        pinChangeButton.setBounds(10,120,160,30);
        pinChangeButton.setFocusable(false);
        pinChangeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                PinChange pinChange = new PinChange(cardNo,pin);
                pinChange.setVisible(true);
            }
        });
        mainScreen.add(pinChangeButton);

        JButton cashWithdrawalButton = new JButton("CASH WITHDRAWAL");
        cashWithdrawalButton.setFont(new Font("Dialog",Font.BOLD,12));
        cashWithdrawalButton.setBounds(180,60,160,30);
        cashWithdrawalButton.setFocusable(false);
        cashWithdrawalButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                CashWithdrawal cashWithdrawal = new CashWithdrawal(cardNo,pin);
                cashWithdrawal.setVisible(true);
            }
        });
        mainScreen.add(cashWithdrawalButton);

        JButton miniStatementButton = new JButton("MINI STATEMENT");
        miniStatementButton.setFont(new Font("Dialog",Font.BOLD,12));
        miniStatementButton.setBounds(180,90,160,30);
        miniStatementButton.setFocusable(false);
        miniStatementButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                MiniStatement miniStatement = new MiniStatement(cardNo);
                miniStatement.setVisible(true);
            }
        });
        mainScreen.add(miniStatementButton);

        JButton balanceEnquiryButton = new JButton("BALANCE ENQUIRY");
        balanceEnquiryButton.setFont(new Font("Dialog",Font.BOLD,12));
        balanceEnquiryButton.setBounds(180,120,160,30);
        balanceEnquiryButton.setFocusable(false);
        balanceEnquiryButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                BalanceEnquiry balanceEnquiry = new BalanceEnquiry(cardNo, pin);
                balanceEnquiry.setVisible(true);
            }
        });
        mainScreen.add(balanceEnquiryButton);

        JButton exitButton = new JButton("EXIT");
        exitButton.setFont(new Font("Dialog",Font.BOLD,12));
        exitButton.setBounds(180,150,160,30);
        exitButton.setFocusable(false);
        exitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
               dispose();

            }
        });
        mainScreen.add(exitButton);

    }




}
