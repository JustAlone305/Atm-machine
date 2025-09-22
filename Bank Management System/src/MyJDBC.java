import java.sql.*;

public class MyJDBC {
    Connection connection;
    Statement statement;

    public MyJDBC(){
        try{
            connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/bankmanagementsystem", "root","print.JustAlone305");
            statement = connection.createStatement();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }


    }

    public boolean checkUser(String cardNo, String pin){
        try{
            PreparedStatement checkUserExists = connection.prepareStatement("select * from login where cardNo = ? and pin = ?");
            checkUserExists.setString(1,cardNo);
            checkUserExists.setString(2,pin);
            ResultSet resultSet = checkUserExists.executeQuery();
            if(resultSet.next()){
                return true;
            }else{
                return false;
            }

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public double getBalance(String cardNo){
        try{
            String command = "select balance from bank_system where cardNo = ?";
            PreparedStatement checkBalance = connection.prepareStatement(command);
            checkBalance.setString(1,cardNo);
            ResultSet resultSet = checkBalance.executeQuery();

            if(resultSet.next()){
                return resultSet.getDouble("balance");
            }


        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return 0.00;
    }

    public void updateBalance(String cardNo, double balance){
        try{
            String command = "update bank_system set balance = ? where cardNo = ?";
            PreparedStatement updateBalance = connection.prepareStatement(command);
            updateBalance.setDouble(1,balance);
            updateBalance.setString(2,cardNo);
            updateBalance.execute();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public void historyTransaction(String cardNo, String date, String mode, String amount){
        try{
            String command = "insert into transaction values('"+cardNo+"', '"+date+"','"+mode+"','"+amount+"')";
            statement.executeUpdate(command);
        }catch (Exception e){
            throw new RuntimeException();
        }
    }

    public void updatePin(String cardNo, String pin){
        try{
            String command = "update login set pin = ? where cardNo = ?";
            PreparedStatement updateBalance = connection.prepareStatement(command);
            updateBalance.setString(1,pin);
            updateBalance.setString(2,cardNo);
            updateBalance.execute();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

}