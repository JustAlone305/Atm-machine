import java.time.LocalDate;
import java.util.Random;
import java.time.LocalDateTime; // Import the LocalDateTime class
import java.time.format.DateTimeFormatter; // Import the DateTimeFormatter class


public class NumberGenerator {
    Random random;
    private String pin;
    private String cardNo;
    public NumberGenerator(){
        random = new Random();
        pin = pinGenerator();
        cardNo = cardNoGenerator(pin);
    }
    public String pinGenerator() {
        int pinNumber = random.nextInt(9000)+1000;
        String pin = ""+ pinNumber;
        return pin;
    }

    public String cardNoGenerator(String pin){
        StringBuilder stringBuilder = new StringBuilder();
        for(int i = 0;i < 3;i++){
            int fourDigitGenerator = random.nextInt(9000)+1000;
            stringBuilder.append(fourDigitGenerator);
        }
        String cardNo = stringBuilder+ pin;
        return cardNo;
    }

    public String dateTime(){
        LocalDateTime dateTime = LocalDateTime.now();
        DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");

        String formattedDate = dateTime.format(myFormatObj);
        String dateToString = formattedDate.toString();
        return dateToString;
    }

    public String getPin() {
        return pin;
    }

    public void setPin(String pin) {
        this.pin = pin;
    }

    public String getCardNo() {
        return cardNo;
    }

    public void setCardNo(String cardNo) {
        this.cardNo = cardNo;
    }
}

