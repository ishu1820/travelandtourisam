package travelandtourism;
import javax.swing.*;
import java.awt.*;
import java.sql.Connection;
import java.awt.event.*;
import java.sql.*;
public class ViewPackage extends JFrame implements ActionListener{
    JButton back;
    ViewPackage(String username){
        setBounds(450,200,900,450);
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);

        JLabel text = new JLabel("View Package Details");
        text.setBounds(60,0,300,30);
        text.setFont(new Font("Tahoma", Font.BOLD, 20));
        add(text);

        JLabel lblusername = new JLabel("Username");
        lblusername.setBounds(30,50,150,25);
        add(lblusername);

        JLabel labelusername = new JLabel();
        labelusername.setBounds(220,50,150,25);
        add(labelusername);

        JLabel lblpackage = new JLabel("Package");
        lblpackage.setBounds(30,90,150,25);
        add(lblpackage);

        JLabel labelpackage = new JLabel();
        labelpackage.setBounds(220,90,150,25);
        add(labelpackage);

        JLabel lbltotal = new JLabel("Total Persons");
        lbltotal.setBounds(30,130,150,25);
        add(lbltotal);

        JLabel labeltotal = new JLabel();
        labeltotal.setBounds(220,130,150,25);
        add(labeltotal);

        JLabel lblid = new JLabel("ID");
        lblid.setBounds(30,170,150,25);
        add(lblid);

        JLabel labelid = new JLabel();
        labelid.setBounds(220,170,150,25);
        add(labelid);

        JLabel lblno = new JLabel("Number");
        lblno.setBounds(30,210,150,25);
        add(lblno);

        JLabel labelno = new JLabel();
        labelno.setBounds(220,210,150,25);
        add(labelno);


        JLabel lblphone = new JLabel("Phone");
        lblphone.setBounds(30,250,150,25);
        add(lblphone);

        JLabel labelphone = new JLabel();
        labelphone.setBounds(220,250,150,25);
        add(labelphone);

        JLabel lblprice = new JLabel("Price");
        lblprice.setBounds(30,290,150,25);
        add(lblprice);

        JLabel labelprice = new JLabel();
        labelprice.setBounds(220,290,150,25);
        add(labelprice);


        back= new JButton("Back");
        back.setBounds(130,360,100,25);
        back.setBackground(Color.DARK_GRAY);
        back.setForeground(Color.WHITE);
        back.setFont(new Font("Tahoma", Font.BOLD,14));
        back.addActionListener(this);
        add(back);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/bookedDetails.jpg"));
        Image i2 = i1.getImage().getScaledInstance(500, 450, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel icon = new JLabel(i3);
        icon.setBounds(450,0, 500, 450);
        add(icon);

        try{
            Conn c= new Conn();
            String query = "select * from bookpackage where username = '"+username+"'";
            ResultSet rs = c.s.executeQuery(query);
            while(rs.next()){
                labelusername.setText(rs.getString("username"));
                labelid.setText(rs.getString("id"));
                labelno.setText(rs.getString("number"));
                labelpackage.setText(rs.getString("package"));

                labelprice.setText(rs.getString("price"));
                labeltotal.setText(rs.getString("persons"));


                labelphone.setText(rs.getString("phone"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        setVisible(true);
    }
    public  void actionPerformed(ActionEvent ae){
        setVisible(false);
    }
    public static void main(String[] args) {
        new ViewPackage("ishita11");
    }
}
