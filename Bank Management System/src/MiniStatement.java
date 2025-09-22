import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class MiniStatement extends JFrame {
    String cardNo;
    public MiniStatement(String cardNo){
        this.cardNo = cardNo;
        this.setSize(400,600);
        this.setLocation(20,20);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        addGuiComponent();

    }

    private void addGuiComponent(){
        JLabel title = new JLabel("Super Bank");
        title.setBounds(150,20,100,20);
        this.add(title);

        JLabel cardLabel = new JLabel("Card No: "+cardNo);
        cardLabel.setBounds(20,80,300,20);
        this.add(cardLabel);

        JLabel statement = new JLabel();

        try{
            MyJDBC conn = new MyJDBC();
            ResultSet rs = conn.statement.executeQuery("select * from transaction where cardNo = '"+ cardNo +"'");
            while(rs.next()){
                statement.setText(statement.getText() + "<html>" + rs.getString("date") + "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"+ rs.getString("mode")+ "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"+rs.getString("amount")+"<br><br><html>");
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        this.add(statement);

    }
}
