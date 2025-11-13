package travelandtourism;
import javax.swing.*;
import java.awt.*;
import java.sql.Connection;
import java.awt.event.*;
import java.sql.*;
public class ViewBookedHotel extends JFrame implements ActionListener{
    JButton back;
    ViewBookedHotel(String username){
        setBounds(300,100,1000,600);
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);

        JLabel text = new JLabel("View Booked Hotel Details");
        text.setBounds(60,0,400,30);
        text.setFont(new Font("Tahoma", Font.BOLD, 20));
        add(text);

        JLabel lblusername = new JLabel("Username");
        lblusername.setBounds(30,50,150,25);
        add(lblusername);

        JLabel labelusername = new JLabel();
        labelusername.setBounds(220,50,150,25);
        add(labelusername);

        JLabel lblhotel = new JLabel("Booked Hotel");
        lblhotel.setBounds(30,90,150,25);
        add(lblhotel);

        JLabel labelhotel = new JLabel();
        labelhotel.setBounds(220,90,150,25);
        add(labelhotel);

        JLabel lbltotal = new JLabel("Total Persons");
        lbltotal.setBounds(30,130,150,25);
        add(lbltotal);

        JLabel labeltotal = new JLabel();
        labeltotal.setBounds(220,130,150,25);
        add(labeltotal);

        JLabel lbldays = new JLabel("Total Days");
        lbldays.setBounds(30,170,150,25);
        add(lbldays);

        JLabel labeldays = new JLabel();
        labeldays.setBounds(220,170,150,25);
        add(labeldays);

        JLabel lblacroom = new JLabel("AC / Non-AC");
        lblacroom.setBounds(30,210,150,25);
        add(lblacroom);

        JLabel labelacroom = new JLabel();
        labelacroom.setBounds(220,210,150,25);
        add(labelacroom);

        JLabel lblfood = new JLabel("Food Included?");
        lblfood.setBounds(30,250,150,25);
        add(lblfood);

        JLabel labelfood = new JLabel();
        labelfood.setBounds(220,250,150,25);
        add(labelfood);

        JLabel lblid = new JLabel("ID");
        lblid.setBounds(30,290,150,25);
        add(lblid);

        JLabel labelid = new JLabel();
        labelid.setBounds(220,290,150,25);
        add(labelid);

        JLabel lblno = new JLabel("Number");
        lblno.setBounds(30,330,150,25);
        add(lblno);

        JLabel labelno = new JLabel();
        labelno.setBounds(220,330,150,25);
        add(labelno);


        JLabel lblphone = new JLabel("Phone");
        lblphone.setBounds(30,370,150,25);
        add(lblphone);

        JLabel labelphone = new JLabel();
        labelphone.setBounds(220,370,150,25);
        add(labelphone);

        JLabel lblprice = new JLabel("Price");
        lblprice.setBounds(30,410,150,25);
        add(lblprice);

        JLabel labelprice = new JLabel();
        labelprice.setBounds(220,410,150,25);
        add(labelprice);


        back= new JButton("Back");
        back.setBounds(130,460,100,25);
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
            String query = "select * from bookhotel where username = '"+username+"'";
            ResultSet rs = c.s.executeQuery(query);
            while(rs.next()){
                labelusername.setText(rs.getString("username"));
                labelid.setText(rs.getString("id"));
                labelno.setText(rs.getString("number"));
                labelhotel.setText(rs.getString("name"));
                labeldays.setText(rs.getString("days"));
                labelprice.setText(rs.getString("totalprice"));
                labeltotal.setText(rs.getString("totalpersons"));
                labelacroom.setText(rs.getString("ac"));
                labelfood.setText(rs.getString("food"));


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
        new ViewBookedHotel("ishita11");
    }
}
