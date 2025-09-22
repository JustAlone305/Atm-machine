import javax.swing.*;
import java.awt.*;

public class ResizableImagePanel extends JPanel {
    private Image originalImage;

    public ResizableImagePanel(String imagePath){
        try{
            originalImage = new ImageIcon(imagePath).getImage();

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (originalImage != null) {
            // Scale the image to fit the panel's current size
            g.drawImage(originalImage, 0, 0, getWidth(), getHeight(), this);
        }



    }
}

