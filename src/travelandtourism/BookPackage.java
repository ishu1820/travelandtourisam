package travelandtourism;
import java.awt.BorderLayout;
import java.awt.*;
import java.awt.EventQueue;

import javax.swing.border.EmptyBorder;

import java.awt.Font;
import java.awt.Image;
import java.sql.*;
import javax.swing.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
public class BookPackage extends JFrame implements ActionListener{


    Choice cpackage;
    JTextField tfpersons;
    String username;
    JLabel labelusername, labelid, labelno, labelphone, labeltotal;
    JButton checkprice, bookpackage, back;
    BookPackage(String username){
        this.username = username;
        setBounds(350,200,900,500);
        setLayout(null);
        getContentPane().setBackground(Color.WHITE);

        JLabel text = new JLabel("BOOK PACKAGE");
        text.setBounds(100,10,200,30);
        text.setFont(new Font("Tahoma", Font.BOLD, 20));
        add(text);

        JLabel lblusername = new JLabel("Username");
        lblusername.setBounds(40,70,100,20);
        lblusername.setFont(new Font("Tahoma", Font.PLAIN, 16));
        add(lblusername);

        labelusername = new JLabel();
        labelusername.setBounds(250,70,100,20);
        labelusername.setFont(new Font("Tahoma", Font.PLAIN, 16));
        add(labelusername);

        JLabel lblpack = new JLabel("Select Package");
        lblpack.setBounds(40,110,130,20);
        lblpack.setFont(new Font("Tahoma", Font.PLAIN, 16));
        add(lblpack);

        cpackage = new Choice();
        cpackage.add("Gold Package");
        cpackage.add("Silver Package");
        cpackage.add("Bronze Package");
        cpackage.setBounds(250, 110 , 100,20);
        add(cpackage);

        JLabel lblperson = new JLabel("Total Persons");
        lblperson.setBounds(40,150,150,20);
        lblperson.setFont(new Font("Tahoma", Font.PLAIN, 16));
        add(lblperson);

        tfpersons = new JTextField("0");
        tfpersons.setBounds(250,150,200,20);
        add(tfpersons);

        JLabel lblid = new JLabel("Id");
        lblid.setBounds(40,190,150,20);
        lblid.setFont(new Font("Tahoma", Font.PLAIN, 16));
        add(lblid);

        labelid = new JLabel();
        labelid.setBounds(250,190,200,20);
        labelid.setFont(new Font("Tahoma", Font.PLAIN, 16));
        add(labelid);

        JLabel lblno = new JLabel("Number");
        lblno.setBounds(40,230,150,20);
        lblno.setFont(new Font("Tahoma", Font.PLAIN, 16));
        add(lblno);

        labelno = new JLabel();
        labelno.setBounds(250,230,200,20);
        labelno.setFont(new Font("Tahoma", Font.PLAIN, 16));
        add(labelno);

        JLabel lblphone = new JLabel("Phone-no.");
        lblphone.setBounds(40,270,150,20);
        lblphone.setFont(new Font("Tahoma", Font.PLAIN, 16));
        add(lblphone);

         labelphone = new JLabel();
        labelphone.setBounds(250,270,200,20);
        labelphone.setFont(new Font("Tahoma", Font.PLAIN, 16));
        add(labelphone);

        JLabel lbltotal = new JLabel("Total Price");
        lbltotal.setBounds(40,310,150,20);
        lbltotal.setFont(new Font("Tahoma", Font.PLAIN, 16));
        add(lbltotal);

        labeltotal = new JLabel();
        labeltotal.setBounds(250,310,200,20);
        labeltotal.setFont(new Font("Tahoma", Font.PLAIN, 16));
        add(labeltotal);

        try{
            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery("select * from customer where username = '"+username+"'");
            while(rs.next()){
                labelusername.setText(rs.getString("username"));
                labelid.setText(rs.getString("id"));
                labelno.setText(rs.getString("number"));
                labelphone.setText(rs.getString("phone"));
            }

            rs.close();
        }catch(Exception e){
            e.printStackTrace();
        }


        checkprice = new JButton("Check Price");
        checkprice.addActionListener(this);
        checkprice.setBounds(60, 380, 120, 25);
        checkprice.setBackground(Color.BLACK);
        checkprice.setForeground(Color.WHITE);

        add(checkprice);


        bookpackage = new JButton("Book Package");
        bookpackage.setBounds(200,380,120,25);
        bookpackage.setForeground(Color.WHITE);
        bookpackage.setBackground(Color.BLACK);
        bookpackage.addActionListener(this);
        add(bookpackage);

        back = new JButton("Back");
        back.setBounds(340,380,120,25);
        back.setForeground(Color.WHITE);
        back.setBackground(Color.BLACK);
        back.addActionListener(this);
        add(back);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/bookpackage.jpg"));
        Image i2 = i1.getImage().getScaledInstance(500, 300, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel icon = new JLabel(i3);
        icon.setBounds(550,50, 500, 300);
        add(icon);


                setVisible(true);
    }
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==checkprice){
            String pack = cpackage.getSelectedItem();
            int cost = 0;
            if(pack.equals("Gold Package")){
                cost += 12000;
            } else if (pack.equals("Silver Package")) {
                cost += 25000;
            }else{
                cost += 32000;
            }
            int persons = Integer.parseInt(tfpersons.getText());
            cost *= persons;
            labeltotal.setText("Rs" + cost);
        } else if (ae.getSource()==bookpackage) {

            try{
                Conn c = new Conn();
                c.s.executeUpdate("insert into bookpackage values('"+labelusername.getText()+"', '"+cpackage.getSelectedItem()+"','"+tfpersons.getText()+"','"+labelid.getText()+"','"+labelno.getText()+"','"+labelphone.getText()+"','"+labeltotal.getText()+"')");

                JOptionPane.showMessageDialog(null,"Package Booked Successfully");
                setVisible(false);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }else {
            setVisible(false);
        }
    }
    public static void main(String[] args) {
        new BookPackage("ishita11");
    }
}


