package travelandtourism;

import javax.swing.*;
import java.awt.*;

public class Destinations extends JFrame implements Runnable{

    Thread t1;

    JLabel[] label = new JLabel[10];

    JLabel caption;
    public void run(){
        String[] text = new String[]{"JW Marriott Hotel", "Madarin Oriental Hotel","Four Seasons Hotel","Raddison Blue Hotel", "Classio Hotel", "The Bay Club Hotel","Breeze Blow Hotel","The Taj Hotel","Happy Morning Motel","River View Hotel"};
        try{
            for (int i=0; i<=9; i++){
                label[i].setVisible(true);

                Thread.sleep(2500);
                label[i].setVisible(false);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    Destinations(){
        setBounds(200,100,800,600);
        caption = new JLabel();
        caption.setBounds(50,500,1000,70);
        caption.setFont(new Font("Tahoma", Font.PLAIN,40));
        caption.setForeground(Color.WHITE);
        add(caption);

        ImageIcon[] image = new ImageIcon[10];
        Image[] img = new Image[10];
        ImageIcon[] image2 = new ImageIcon[10];

        for (int i =0; i<=9;i++){
            image[i] = new ImageIcon(ClassLoader.getSystemResource("icons/dest"+(i+1)+".jpg"));
            img[i] = image[i].getImage().getScaledInstance(800, 600, Image.SCALE_DEFAULT);
            image2[i] = new ImageIcon(img[i]);
            label[i] = new JLabel(image2[i]);
            label[i].setBounds(0,0, 800, 600);
            add(label[i]);
        }

        t1 = new Thread(this);
        t1.start();

        setVisible(true );
    }



    public static void main(String[] args) {
        new Destinations();
    }
}


