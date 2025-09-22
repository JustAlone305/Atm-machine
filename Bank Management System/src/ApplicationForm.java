import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.util.Random;

import com.toedter.calendar.*;
public class ApplicationForm extends JFrame implements ActionListener {
    JTextField nameTf, fatherNameTf, motherNameTf, emailAddressTf, addressTf, cityTf, poscodeTf, stateTf;
    JDateChooser calendar;
    JRadioButton maleRadioButton, femaleRadioButton, marriedRadioButton,unmarriedRadioButton;
    JButton submitButton;
    JCheckBox declaration;
    NumberGenerator numberGenerator;



    ApplicationForm(){
        this.setTitle("NEW ACCOUNT APPLICATION FORM");
        this.setSize(650,850);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setLayout(null);
        addImageIcon();
        addGuiComponent();

    }


    private void addImageIcon() {
        ImageIcon imageIcon = new ImageIcon(getClass().getResource("/img.png"));
        Image scaleImage = imageIcon.getImage().getScaledInstance(80, 80, Image.SCALE_SMOOTH);
        ImageIcon resizedIcon = new ImageIcon(scaleImage);

        JLabel imageLabel = new JLabel(resizedIcon);
        imageLabel.setBounds(50, 30, 80, 80);
        this.add(imageLabel);
    }
    private void addGuiComponent(){
        numberGenerator = new NumberGenerator();
        //label
        //title
        JLabel title = new JLabel("APPLICATION FORM");
        title.setFont(new Font("Dialog",Font.BOLD,40));
        title.setForeground(Color.BLACK);
        title.setBounds(165,50,450,60);
        this.add(title);

        //small title
        JLabel smallTitle = new JLabel("Page 1: Personal Details");
        smallTitle.setFont(new Font("Dialog",Font.BOLD,25));
        smallTitle.setForeground(Color.BLACK);
        smallTitle.setBounds(100,100,450,60);
        smallTitle.setHorizontalAlignment(SwingConstants.CENTER);
        this.add(smallTitle);

        //label and text field
        //name
        JLabel name = new JLabel("Name:");
        name.setFont(new Font("Dialog",Font.BOLD,20));
        name.setForeground(Color.BLACK);
        name.setBounds(50,160,150,50);
        this.add(name);




        nameTf = new JTextField();
        nameTf.setFont(new Font("Dialog",Font.PLAIN,20));
        nameTf.setBackground(Color.WHITE);
        nameTf.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        nameTf.setBounds(250,170,350,30);
        nameTf.setEditable(true);
        nameTf.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                nameTf.setBackground(Color.YELLOW);
                nameTf.setBorder(BorderFactory.createLineBorder(Color.BLACK,3));
            }

            @Override
            public void focusLost(FocusEvent e) {
                nameTf.setBackground(Color.WHITE);
                nameTf.setBorder(BorderFactory.createLineBorder(Color.BLACK));

            }
        });
        this.add(nameTf);





        //father's name
        JLabel fatherName = new JLabel("Father's Name:");
        fatherName.setFont(new Font("Dialog",Font.BOLD,20));
        fatherName.setForeground(Color.BLACK);
        fatherName.setBounds(50,220,150,50);
        this.add(fatherName);

        fatherNameTf = new JTextField();
        fatherNameTf.setFont(new Font("Dialog",Font.PLAIN,20));
        fatherNameTf.setBackground(Color.WHITE);
        fatherNameTf.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        fatherNameTf.setBounds(250,230,350,30);
        fatherNameTf.setEditable(true);
        fatherNameTf.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                fatherNameTf.setBackground(Color.YELLOW);
                fatherNameTf.setBorder(BorderFactory.createLineBorder(Color.BLACK,3));
            }

            @Override
            public void focusLost(FocusEvent e) {
                fatherNameTf.setBackground(Color.WHITE);
                fatherNameTf.setBorder(BorderFactory.createLineBorder(Color.BLACK));

            }
        });
        this.add(fatherNameTf);




        //mother's name
        JLabel motherName = new JLabel("Mother's Name:");
        motherName.setFont(new Font("Dialog",Font.BOLD,20));
        motherName.setForeground(Color.BLACK);
        motherName.setBounds(50,280,150,50);
        this.add(motherName);

        motherNameTf = new JTextField();
        motherNameTf.setFont(new Font("Dialog",Font.PLAIN,20));
        motherNameTf.setBackground(Color.WHITE);
        motherNameTf.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        motherNameTf.setBounds(250,290,350,30);
        motherNameTf.setEditable(true);
        motherNameTf.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                motherNameTf.setBackground(Color.YELLOW);
                motherNameTf.setBorder(BorderFactory.createLineBorder(Color.BLACK,3));
            }

            @Override
            public void focusLost(FocusEvent e) {
                motherNameTf.setBackground(Color.WHITE);
                motherNameTf.setBorder(BorderFactory.createLineBorder(Color.BLACK));

            }
        });
        this.add(motherNameTf);

        //date of birth
        JLabel dateOfBirth = new JLabel("Date of Birth:");
        dateOfBirth.setFont(new Font("Dialog",Font.BOLD,20));
        dateOfBirth.setForeground(Color.BLACK);
        dateOfBirth.setBounds(50,340,150,50);
        this.add(dateOfBirth);


        calendar = new JDateChooser();
        calendar.setBounds(250,350,350,30);
        this.add(calendar);

        //gender
        JLabel gender = new JLabel("Gender:");
        gender.setFont(new Font("Dialog",Font.BOLD,20));
        gender.setForeground(Color.BLACK);
        gender.setBounds(50,400,150,50);
        this.add(gender);

        maleRadioButton = new JRadioButton("Male");
        maleRadioButton.setFont(new Font("Dialog",Font.PLAIN,15));
        maleRadioButton.setBounds(250,410,100,40);
        maleRadioButton.setFocusable(false);

        femaleRadioButton = new JRadioButton("Female");
        femaleRadioButton.setFont(new Font("Dialog",Font.PLAIN,15));
        femaleRadioButton.setBounds(350,410,100,40);
        femaleRadioButton.setFocusable(false);

        ButtonGroup genderButtonGroup = new ButtonGroup();
        genderButtonGroup.add(maleRadioButton);
        genderButtonGroup.add(femaleRadioButton);

        this.add(maleRadioButton);
        this.add(femaleRadioButton);

        //email address
        JLabel emailAddress = new JLabel("Email Address:");
        emailAddress.setFont(new Font("Dialog",Font.BOLD,20));
        emailAddress.setForeground(Color.BLACK);
        emailAddress.setBounds(50,460,150,50);
        this.add(emailAddress);

        emailAddressTf = new JTextField();
        emailAddressTf.setFont(new Font("Dialog",Font.PLAIN,20));
        emailAddressTf.setBackground(Color.WHITE);
        emailAddressTf.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        emailAddressTf.setBounds(250,470,350,30);
        emailAddressTf.setEditable(true);
        emailAddressTf.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                emailAddressTf.setBackground(Color.YELLOW);
                emailAddressTf.setBorder(BorderFactory.createLineBorder(Color.BLACK,3));
            }

            @Override
            public void focusLost(FocusEvent e) {
                emailAddressTf.setBackground(Color.WHITE);
                emailAddressTf.setBorder(BorderFactory.createLineBorder(Color.BLACK));

            }
        });
        this.add(emailAddressTf);

        //martial status
        JLabel martialStatus = new JLabel("Martial Status:");
        martialStatus.setFont(new Font("Dialog",Font.BOLD,20));
        martialStatus.setForeground(Color.BLACK);
        martialStatus.setBounds(50,520,150,50);
        this.add(martialStatus);


        marriedRadioButton = new JRadioButton("Married");
        marriedRadioButton.setFont(new Font("Dialog",Font.PLAIN,15));
        marriedRadioButton.setBounds(250,530,100,40);
        marriedRadioButton.setFocusable(false);

        unmarriedRadioButton = new JRadioButton("Unmarried");
        unmarriedRadioButton.setFont(new Font("Dialog",Font.PLAIN,15));
        unmarriedRadioButton.setBounds(350,530,100,40);
        unmarriedRadioButton.setFocusable(false);

        ButtonGroup statusButtonGroup = new ButtonGroup();
        statusButtonGroup.add(marriedRadioButton);
        statusButtonGroup.add(unmarriedRadioButton);

        this.add(marriedRadioButton);
        this.add(unmarriedRadioButton);

        //Address
        JLabel address = new JLabel("Address:");
        address.setFont(new Font("Dialog",Font.BOLD,20));
        address.setForeground(Color.BLACK);
        address.setBounds(50,580,150,50);
        this.add(address);

        addressTf = new JTextField();
        addressTf.setFont(new Font("Dialog",Font.PLAIN,20));
        addressTf.setBackground(Color.WHITE);
        addressTf.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        addressTf.setBounds(250,590,350,30);
        addressTf.setEditable(true);
        addressTf.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                addressTf.setBackground(Color.YELLOW);
                addressTf.setBorder(BorderFactory.createLineBorder(Color.BLACK,3));
            }

            @Override
            public void focusLost(FocusEvent e) {
                addressTf.setBackground(Color.WHITE);
                addressTf.setBorder(BorderFactory.createLineBorder(Color.BLACK));

            }
        });
        this.add(addressTf);

        //city
        JLabel city = new JLabel("City:");
        city.setFont(new Font("Dialog",Font.BOLD,20));
        city.setForeground(Color.BLACK);
        city.setBounds(50,640,50,50);
        this.add(city);

        cityTf = new JTextField();
        cityTf.setFont(new Font("Dialog",Font.PLAIN,20));
        cityTf.setBackground(Color.WHITE);
        cityTf.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        cityTf.setBounds(250,650,140,30);
        cityTf.setEditable(true);
        cityTf.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                cityTf.setBackground(Color.YELLOW);
                cityTf.setBorder(BorderFactory.createLineBorder(Color.BLACK,3));
            }

            @Override
            public void focusLost(FocusEvent e) {
                cityTf.setBackground(Color.WHITE);
                cityTf.setBorder(BorderFactory.createLineBorder(Color.BLACK));

            }
        });
        this.add(cityTf);

        //poscode
        JLabel poscode = new JLabel("Poscode:");
        poscode.setFont(new Font("Dialog",Font.BOLD,20));
        poscode.setForeground(Color.BLACK);
        poscode.setBounds(400,640,100,50);
        poscode.setHorizontalAlignment(SwingConstants.CENTER);
        this.add(poscode);

        poscodeTf = new JTextField();
        poscodeTf.setFont(new Font("Dialog",Font.PLAIN,20));
        poscodeTf.setBackground(Color.WHITE);
        poscodeTf.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        poscodeTf.setBounds(500,650,100,30);
        poscodeTf.setEditable(true);
        poscodeTf.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                poscodeTf.setBackground(Color.YELLOW);
                poscodeTf.setBorder(BorderFactory.createLineBorder(Color.BLACK,3));
            }

            @Override
            public void focusLost(FocusEvent e) {
                poscodeTf.setBackground(Color.WHITE);
                poscodeTf.setBorder(BorderFactory.createLineBorder(Color.BLACK));

            }
        });
        this.add(poscodeTf);

        //state
        JLabel state = new JLabel("State:");
        state.setFont(new Font("Dialog",Font.BOLD,20));
        state.setForeground(Color.BLACK);
        state.setBounds(50,700,100,50);
        this.add(state);

        stateTf = new JTextField();
        stateTf.setFont(new Font("Dialog",Font.PLAIN,20));
        stateTf.setBackground(Color.WHITE);
        stateTf.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        stateTf.setBounds(250,710,350,30);
        stateTf.setEditable(true);
        stateTf.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                stateTf.setBackground(Color.YELLOW);
                stateTf.setBorder(BorderFactory.createLineBorder(Color.BLACK,3));
            }

            @Override
            public void focusLost(FocusEvent e) {
                stateTf.setBackground(Color.WHITE);
                stateTf.setBorder(BorderFactory.createLineBorder(Color.BLACK));

            }
        });
        this.add(stateTf);

        declaration =new JCheckBox("I hereby declares that the above entered details correct to the best of knowledge.");
        declaration.setBounds(20,750,390,30);
        declaration.setFont(new Font("Dialog", Font.BOLD, 9));
        declaration.setFocusable(false);
        this.add(declaration);

        //button
        submitButton =new JButton("Submit");
        submitButton.setBounds(520,750,100,30);
        submitButton.setFont(new Font("Dialog",Font.BOLD,15));
        submitButton.setBackground(Color.BLACK);
        submitButton.setForeground(Color.WHITE);
        submitButton.setFocusable(false);
        submitButton.addActionListener(this);
        this.add(submitButton);

        JButton backButton = new JButton("Back");
        backButton.setBounds(420,750,80,30);
        backButton.setFont(new Font("Dialog",Font.BOLD,15));
        backButton.setHorizontalAlignment(SwingConstants.CENTER);
        backButton.setBackground(Color.BLACK);
        backButton.setForeground(Color.WHITE);
        backButton.setFocusable(false);
        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Login loginForm = new Login();
                loginForm.setVisible(true);
                dispose();
            }
        });
        this.add(backButton);






    }

    @Override
    public void actionPerformed(ActionEvent e) {
        double balance = 0.00;
        String pin = numberGenerator.getPin();
        String cardNo = numberGenerator.getCardNo();
        String name = nameTf.getText();
        String fatherName = fatherNameTf.getText();
        String motherName = motherNameTf.getText();
        String dateOfBirth = ((JTextField)calendar.getDateEditor().getUiComponent()).getText();
        String gender = null;
        if(maleRadioButton.isSelected()){
            gender = "Male";
        }else if(femaleRadioButton.isSelected()){
            gender = "Female";
        }
        String email = emailAddressTf.getText();
        String address = addressTf.getText();
        String martialStatus = null;
        if(marriedRadioButton.isSelected()){
            martialStatus = "Married";
        }else if (unmarriedRadioButton.isSelected()){
            martialStatus = "Unmarried";
        }
        String poscode = poscodeTf.getText();
        String city = cityTf.getText();
        String state = stateTf.getText();

        try{
            if(!declaration.isSelected()){
                JOptionPane.showMessageDialog(null,"Please declare the information entered");
            }
            else if (name.equals("")){
                JOptionPane.showMessageDialog(null, "Name is Required");
            }else{
                MyJDBC connection = new MyJDBC();
                String userData = "insert into user_data values('"+cardNo+"','"+name+"','"+fatherName+"','"+motherName+"','"+dateOfBirth+"','"+gender+"','"+email+"','"+martialStatus+"','"+address+"','"+poscode+"','"+city+"','"+state+"')";
                connection.statement.executeUpdate(userData);
                JOptionPane.showMessageDialog(null,"Card No:" + cardNo + "\n Pin:"+pin);
                String login = "insert into login values('"+cardNo+"','"+pin+"')";
                connection.statement.executeUpdate(login);
                String bankSystem = "insert into bank_system values('"+cardNo+"', "+balance+")";
                connection.statement.executeUpdate(bankSystem);
                Login loginWindow = new Login();
                loginWindow.setVisible(true);
                this.dispose();

            }
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }

    }
}
