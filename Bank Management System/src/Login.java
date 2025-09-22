import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

public class Login extends JFrame implements ActionListener {
    JButton signupButton, loginButton, clearButton;
    JTextField cardNoTf;
    JPasswordField pinTf;
    Login(){
        this.setTitle("AUTOMATED TELLER MACHINE");
        this.setSize(700,500);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setLayout(null);
        this.getContentPane().setBackground(Color.LIGHT_GRAY);
        addImageIcon();
        addGuiComponent();

    }
    private void addImageIcon(){
        ImageIcon imageIcon = new ImageIcon(getClass().getResource("/img.png"));
        Image scaleImage = imageIcon.getImage().getScaledInstance(80,80,Image.SCALE_SMOOTH);
        ImageIcon resizedIcon = new ImageIcon(scaleImage);

        JLabel imageLabel = new JLabel(resizedIcon);
        imageLabel.setBounds(90,50,80,80);
        this.add(imageLabel);
    }

    private void addGuiComponent(){
        //label
        //title label
        JLabel title = new JLabel("WELCOME TO ATM");
        title.setFont(new Font("Dialog",Font.BOLD,40));
        title.setBounds(200,60,400,60);
        title.setHorizontalAlignment(SwingConstants.CENTER);
        title.setForeground(Color.BLACK);
        this.add(title);

        //card no label
        JLabel cardNo = new JLabel("Card No:");
        cardNo.setFont(new Font("Dialog", Font.BOLD, 25));
        cardNo.setBounds(80,200,150,30);
        cardNo.setForeground(Color.BLACK);
        this.add(cardNo);

        //pin label
        JLabel pinLabel = new JLabel("Pin:");
        pinLabel.setFont(new Font("Dialog", Font.BOLD, 25));
        pinLabel.setBounds(80,250,100,30);
        pinLabel.setForeground(Color.BLACK);
        this.add(pinLabel);

        //text field
        //card no text field
        cardNoTf = new JTextField();
        cardNoTf.setBackground(Color.LIGHT_GRAY);
        cardNoTf.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        cardNoTf.setFont(new Font("Dialog",Font.PLAIN,20));
        cardNoTf.setBounds(300,200,250,30);
        cardNoTf.setEditable(true);
        cardNoTf.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                cardNoTf.setBackground(Color.WHITE);
                cardNoTf.setBorder(BorderFactory.createLineBorder(Color.BLACK,3));
            }

            @Override
            public void focusLost(FocusEvent e) {
                cardNoTf.setBackground(Color.LIGHT_GRAY);
                cardNoTf.setBorder(BorderFactory.createLineBorder(Color.BLACK));

            }
        });
        this.add(cardNoTf);

        //pin text field
        pinTf = new JPasswordField(4);
        pinTf.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        pinTf.setBackground(Color.LIGHT_GRAY);
        pinTf.setBounds(300,250,250,30);
        pinTf.setEditable(true);
        pinTf.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                pinTf.setBackground(Color.WHITE);
                pinTf.setBorder(BorderFactory.createLineBorder(Color.BLACK,3));
            }

            @Override
            public void focusLost(FocusEvent e) {
                pinTf.setBackground(Color.LIGHT_GRAY);
                pinTf.setBorder(BorderFactory.createLineBorder(Color.BLACK));

            }
        });
        this.add(pinTf);

        //button
        //login button
        loginButton = new JButton("LOGIN");
        loginButton.setBounds(300,300,100,30);
        loginButton.setFont(new Font("Dialog",Font.PLAIN,18));
        loginButton.setBackground(Color.BLACK);
        loginButton.setForeground(Color.WHITE);
        loginButton.setFocusable(false);
        loginButton.addActionListener(this);
        this.add(loginButton);

        //clear button
        clearButton = new JButton("CLEAR");
        clearButton.setBounds(450,300,100,30);
        clearButton.setFont(new Font("Dialog",Font.PLAIN,18));
        clearButton.setBackground(Color.BLACK);
        clearButton.setForeground(Color.WHITE);
        clearButton.setFocusable(false);
        clearButton.addActionListener(this);
        this.add(clearButton);

        //sign up button
        signupButton = new JButton("SIGN UP");
        signupButton.setBounds(300,350,255,30);
        signupButton.setFont(new Font("Dialog",Font.PLAIN,18));
        signupButton.setHorizontalAlignment(SwingConstants.CENTER);
        signupButton.setBackground(Color.BLACK);
        signupButton.setForeground(Color.WHITE);
        signupButton.setFocusable(false);
        signupButton.addActionListener(this);
        this.add(signupButton);






    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == clearButton){
            pinTf.setText("");
            cardNoTf.setText("");
        }
        if(e.getSource() == signupButton){
            ApplicationForm applicationForm = new ApplicationForm();
            applicationForm.setVisible(true);
            this.dispose();
        }
        if(e.getSource() == loginButton){
            MyJDBC myJDBC = new MyJDBC();
            String cardNo = cardNoTf.getText();
            String pin = pinTf.getText();
            if(myJDBC.checkUser(cardNo, pin)){
                JOptionPane.showMessageDialog(null,"Login Successful");
                ATM atm = new ATM(cardNo,pin);
                atm.setVisible(true);
                this.dispose();
            }else{
                JOptionPane.showMessageDialog(null,"Wrong card number or wrong pin");
            }
        }
    }


}
