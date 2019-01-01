package OS;

import java.awt.*;
import java.awt.event.*;
import java.awt.geom.*;
import java.awt.image.BufferedImage;
import java.io.*;
import java.net.*;
import javax.imageio.ImageIO;
import javax.swing.*;
  
public class Scaling
{
    public static void main(String[] args)
    {
        ImageScalingPanel imagePanel = new ImageScalingPanel();
        ImageZoomer zoomer = new ImageZoomer(imagePanel);
        JFrame f = new JFrame();
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //f.getContentPane().add(zoomer.getUIPanel(), "North");
        f.getContentPane().add(new JScrollPane(imagePanel));
        f.setSize(400,400);
        f.setLocation(200,200);
        f.setVisible(true);
    }
}
  
class ImageScalingPanel extends JPanel
{
    BufferedImage image;
    double scale, zoomInc;
  
    public ImageScalingPanel()
    {
        loadImage();
        scale = 1.0;
        zoomInc = 0.01;
        setBackground(Color.white);
    }
  
    protected void paintComponent(Graphics g)
    {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D)g;
        g2.setRenderingHint(RenderingHints.KEY_INTERPOLATION,
                            RenderingHints.VALUE_INTERPOLATION_BICUBIC);
        int w = getWidth();
        int h = getHeight();
        double imageWidth = scale * image.getWidth();
        double imageHeight = scale * image.getHeight();
        double x = (w - imageWidth)/2;
        double y = (h - imageHeight)/2;
        AffineTransform at = AffineTransform.getTranslateInstance(x, y);
        at.scale(scale, scale);
        g2.drawRenderedImage(image, at);
    }
  
    public Dimension getPreferredSize()
    {
        int
            w = (int)(scale * image.getWidth()),
            h = (int)(scale * image.getHeight());
        return new Dimension(w, h);
    }
  
    private void loadImage()
    {
        String fileName = "calc.png";
        try
        {
            URL url = getClass().getResource(fileName);
            image = ImageIO.read(url);
        }
        catch(MalformedURLException mue)
        {
            System.out.println("url: " + mue.getMessage());
        }
        catch(IOException ioe)
        {
            System.out.println("read: " + ioe.getMessage());
        }
    }
}