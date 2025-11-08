package travelandtourism;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class AddCustomer extends JFrame implements ActionListener {
    JLabel labelusername, labelname;
    JComboBox comboid;
    JTextField tfnumber, tfcountry, tfaddress, tfemail, tfphone;
    JRadioButton male,female;
    JButton add, back;
    AddCustomer(String username){
        setBounds(450,200,850,550);
        setLayout(null);
        getContentPane().setBackground(Color.WHITE);

        JLabel lblusername = new JLabel("Username");
        lblusername.setBounds(30,50,150,25);
        add(lblusername);

        labelusername = new JLabel();
        labelusername.setBounds(220,50,150,25);
        add(labelusername);

        JLabel lblid = new JLabel("Id");
        lblid.setBounds(30,90,150,25);
        add(lblid);

        comboid = new JComboBox(new String[] {"Passport","Aadhaar Card","PAN Card","Ration Card"});
        comboid.setBounds(220,90,150,25);
        comboid.setBackground(Color.WHITE);
        add(comboid);

        JLabel lblno = new JLabel("Number");
        lblno.setBounds(30,130,150,25);
        add(lblno);

        tfnumber = new JTextField();
        tfnumber.setBounds(220,130,150,25);
        add(tfnumber);

        JLabel lblname = new JLabel("Name");
        lblname.setBounds(30,170,150,25);
        add(lblname);

        labelname = new JLabel();
        labelname.setBounds(220,170,150,25);
        add(labelname);

        JLabel lblgender = new JLabel("Gender");
        lblgender.setBounds(30,210,150,25);
        add(lblgender);

        labelname = new JLabel();
        labelname.setBounds(220,170,150,25);
        add(labelname);
        male = new JRadioButton("Male");
        male.setBounds(220,210,70,25);
        male.setBackground(Color.WHITE);
        add(male);
        female = new JRadioButton("Female");
        female.setBounds(300,210,70,25);
        female.setBackground(Color.WHITE);
        add(female);

        ButtonGroup bg = new ButtonGroup();
        bg.add(male);
        bg.add(female);

        JLabel country = new JLabel("Country");
        country.setBounds(30,250,150,25);
        add(country);

        tfcountry = new JTextField();
        tfcountry.setBounds(220,250,150,25);
        add(tfcountry);

        JLabel lbladdress = new JLabel("Address");
        lbladdress.setBounds(30,290,150,25);
        add(lbladdress);

        tfaddress = new JTextField();
        tfaddress.setBounds(220,290,150,25);
        add(tfaddress);

        JLabel email = new JLabel("E-mail");
        email.setBounds(30,330,150,25);
        add(email);

        tfemail = new JTextField();
        tfemail.setBounds(220,330,150,25);
        add(tfemail);

        JLabel phone = new JLabel("Phone");
        phone.setBounds(30,370,150,25);
        add(phone);

        tfaddress = new JTextField();
        tfaddress.setBounds(220,370,150,25);
        add(tfaddress);

        add = new JButton("Add");
        add.setBounds(70,430,100,50);
        add.setBackground(Color.BLACK);
        add.setForeground(Color.WHITE);
        add.setFont(new Font("Tahoma", Font.BOLD,18));
        add.addActionListener(this);
        add(add);

        back = new JButton("Back");
        back.setBounds(220,430,100,50);
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        back.setFont(new Font("Tahoma", Font.BOLD,18));
        back.addActionListener(this);
        add(back);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/newcustomer.jpg"));
        Image i2 = i1.getImage().getScaledInstance(400, 500, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel icon = new JLabel(i3);
        icon.setBounds(440,40, 450, 420);
        add(icon);

        try{
            Conn c= new Conn();
            ResultSet rs = c.s.executeQuery("select * from account where username = ");
            while(rs.next()){
                labelusername.setText(rs.getString("username"));
                labelname.setText(rs.getString("name"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        setVisible(true);
    }
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource() == add){
            String username = labelusername.getText();
            String id = (String) comboid.getSelectedItem();
            String number = tfnumber.getText();
            String name = labelname.getText();
            String gender = null;
            if(male.isSelected()){
                gender = "male";
            }else{
                gender = "female";
            }
            String country = tfcountry.getText();
            String address = tfaddress.getText();
            String phone = tfphone.getText();
            String email = tfemail.getText();

            try{
                Conn c = new Conn();
                String query = "insert into customer (username, id, number, name, gender, country, address, phone, email) values ('"+username+"', '"+id+"', '"+number+"', '"+name+"', '"+gender+"', '"+country+"', '"+address+"', '"+phone+"', '"+email+"')";
                c.s.executeUpdate(query);
                JOptionPane.showMessageDialog(null,"Customer Details Added Successfully");
                setVisible(false);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }else{
            setVisible(false);
        }
    }
    public static void main(String[] args) {
        new AddCustomer("");
    }
}