import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BalanceEnquiry extends JFrame {
    ResizableImagePanel resizableImagePanel;
    double balance;
    String cardNo, pin;
    public BalanceEnquiry(String cardNo, String pin){
        this.cardNo = cardNo;
        this.pin = pin;
        this.setTitle("AUTOMATED TELLER MACHINE");
        resizableImagePanel = new ResizableImagePanel("C:\\Users\\User\\IdeaProjects\\Bank Management System\\src\\img2.png");
        resizableImagePanel.setLayout(null);
        this.setSize(900,700);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setContentPane(resizableImagePanel);
        MyJDBC db =new MyJDBC();
        balance = db.getBalance(cardNo);
        addGuiComponent();

    }

    public void addGuiComponent(){
        //the black frame
        JPanel mainScreen = new JPanel();
        mainScreen.setBounds(135,215,345,220);
        mainScreen.setBackground(Color.BLACK);
        mainScreen.setLayout(null);
        this.getContentPane().add(mainScreen);



        //label
        JLabel title = new JLabel("Your Current Account Balance is RM "+ balance);
        title.setFont(new Font("Dialog", Font.BOLD,15));
        title.setBounds(10,10,350,40);
        title.setForeground(Color.WHITE);
        mainScreen.add(title);

        //button
        JButton backButton = new JButton("Back");
        backButton.setFont(new Font("Dialog",Font.BOLD,12));
        backButton.setBounds(240,150,100,30);
        backButton.setFocusable(false);
        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                ATM atm = new ATM(cardNo,pin);
                atm.setVisible(true);

            }
        });
        mainScreen.add(backButton);

    }


}
