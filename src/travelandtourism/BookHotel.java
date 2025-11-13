package travelandtourism;
import java.awt.BorderLayout;
import java.awt.*;
import java.awt.EventQueue;

import javax.swing.border.EmptyBorder;

import java.awt.Font;
import java.awt.Image;
import java.io.InputStream;
import java.io.Reader;
import java.math.BigDecimal;
import java.net.URL;
import java.sql.*;
import javax.swing.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.Calendar;
import java.util.Map;

public class BookHotel extends JFrame implements ActionListener{


    Choice chotel, cac, cfo;
    JTextField tfpersons, tfdays;
    String username;
    JLabel labelusername, labelid, labelno, labelphone, labeltotal;
    JButton checkprice, bookhotel, back;
    BookHotel(String username){
        this.username = username;
        setBounds(250,100,1100,600);
        setLayout(null);
        getContentPane().setBackground(Color.WHITE);

        JLabel text = new JLabel("BOOK HOTEL");
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

        JLabel lblpack = new JLabel("Select Hotel");
        lblpack.setBounds(40,110,130,20);
        lblpack.setFont(new Font("Tahoma", Font.PLAIN, 16));
        add(lblpack);

        chotel = new Choice();
        chotel.setBounds(250, 110 , 100,20);
        add(chotel);

        try{
            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery("select * from hotel");
            while (rs.next()){
                chotel.add(rs.getString("name"));
            }


        } catch (Exception e) {
            e.printStackTrace();
        }
        JLabel lblperson = new JLabel("Total Persons");
        lblperson.setBounds(40,150,150,20);
        lblperson.setFont(new Font("Tahoma", Font.PLAIN, 16));
        add(lblperson);

        tfpersons = new JTextField("0");
        tfpersons.setBounds(250,150,200,20);
        add(tfpersons);

        JLabel lbldays = new JLabel("No of Days");
        lbldays.setBounds(40,190,150,20);
        lbldays.setFont(new Font("Tahoma", Font.PLAIN, 16));
        add(lbldays);

        tfdays = new JTextField("1");
        tfdays.setBounds(250,190,200,20);
        add(tfdays);

        JLabel lblroom = new JLabel("AC/ Non-AC");
        lblroom.setBounds(40,230,150,20);
        lblroom.setFont(new Font("Tahoma", Font.PLAIN, 16));
        add(lblroom);

        cac = new Choice();
        cac.add("AC");
        cac.add("Non-AC");
        cac.setBounds(250, 230 , 100,20);
        add(cac);

        JLabel lblfood = new JLabel("Food Included");
        lblfood.setBounds(40,270,150,20);
        lblfood.setFont(new Font("Tahoma", Font.PLAIN, 16));
        add(lblfood);

        cfo = new Choice();
        cfo.add("Yes");
        cfo.add("No");
        cfo.setBounds(250, 270 , 100,20);
        add(cfo);

        JLabel lblid = new JLabel("Id");
        lblid.setBounds(40,310,150,20);
        lblid.setFont(new Font("Tahoma", Font.PLAIN, 16));
        add(lblid);

        labelid = new JLabel();
        labelid.setBounds(250,310,200,20);
        labelid.setFont(new Font("Tahoma", Font.PLAIN, 16));
        add(labelid);

        JLabel lblno = new JLabel("Number");
        lblno.setBounds(40,350,150,20);
        lblno.setFont(new Font("Tahoma", Font.PLAIN, 16));
        add(lblno);

        labelno = new JLabel();
        labelno.setBounds(250,350,200,20);
        labelno.setFont(new Font("Tahoma", Font.PLAIN, 16));
        add(labelno);

        JLabel lblphone = new JLabel("Phone-no.");
        lblphone.setBounds(40,390,150,20);
        lblphone.setFont(new Font("Tahoma", Font.PLAIN, 16));
        add(lblphone);

        labelphone = new JLabel();
        labelphone.setBounds(250,390,200,20);
        labelphone.setFont(new Font("Tahoma", Font.PLAIN, 16));
        add(labelphone);

        JLabel lbltotal = new JLabel("Total Price");
        lbltotal.setBounds(40,430,150,20);
        lbltotal.setFont(new Font("Tahoma", Font.PLAIN, 16));
        add(lbltotal);

        labeltotal = new JLabel();
        labeltotal.setBounds(250,430,200,20);
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
        checkprice.setBounds(60, 490, 120, 25);
        checkprice.setBackground(Color.BLACK);
        checkprice.setForeground(Color.WHITE);

        add(checkprice);


        bookhotel = new JButton("Book Hotel");
        bookhotel.setBounds(200,490,120,25);
        bookhotel.setForeground(Color.WHITE);
        bookhotel.setBackground(Color.BLACK);
        bookhotel.addActionListener(this);
        add(bookhotel);

        back = new JButton("Back");
        back.setBounds(340,490,120,25);
        back.setForeground(Color.WHITE);
        back.setBackground(Color.BLACK);
        back.addActionListener(this);
        add(back);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/book.jpg"));
        Image i2 = i1.getImage().getScaledInstance(600, 400, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel icon = new JLabel(i3);
        icon.setBounds(500,50, 600, 400);
        add(icon);


        setVisible(true);
    }
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==checkprice){
            try{
                Conn c = new Conn();
                ResultSet rs = c.s.executeQuery("select * from hotel where name ='"+chotel.getSelectedItem()+"'");
                while(rs.next()){
                    int cost = Integer.parseInt(rs.getString("costperperson"));
                    int food = Integer.parseInt(rs.getString("foodincluded"));
                    int room = Integer.parseInt(rs.getString("acroom"));

                    int person = Integer.parseInt(tfpersons.getText());
                    int days = Integer.parseInt(tfdays.getText());

                    String acselected = cac.getSelectedItem();
                    String foodselected = cfo.getSelectedItem();

                    if(person*days>0){
                        int total = 0;
                        total += acselected.equals("AC") ? room : 0;
                        total += foodselected.equals("Yes") ? food : 0;
                        total += cost;
                        total = total * person * days;
                        labeltotal.setText("Rs" + total);
                    }else{
                        JOptionPane.showMessageDialog(null,"Please enter a valid number");
                    }
                }
                String pack = chotel.getSelectedItem();
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
            } catch (Exception e) {
                e.printStackTrace();
            }


        } else if (ae.getSource()==bookhotel) {

            try{
                Conn c = new Conn();
                c.s.executeUpdate("insert into bookhotel values('"+labelusername.getText()+"', '"+chotel.getSelectedItem()+"','"+tfpersons.getText()+"','"+tfdays.getText()+"','"+cac.getSelectedItem()+"','"+cfo.getSelectedItem()+"','"+labelid.getText()+"','"+labelno.getText()+"','"+labelphone.getText()+"','"+labeltotal.getText()+"')");

                JOptionPane.showMessageDialog(null,"Hotel Booked Successfully");
                setVisible(false);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }else {
            setVisible(false);
        }
    }
    public static void main(String[] args) {
        new BookHotel("ishita11");
    }
}


