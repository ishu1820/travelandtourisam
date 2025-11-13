package travelandtourism;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Dashboard extends JFrame implements ActionListener {
    String username;
    JButton addpersondetails, viewpersonaldetails, updatepersondetails, check, book, view, viewhotels, destinations, bookhotel, viewbookhotel, payments, about, deletepersonaldetails;
    Dashboard(String username) {
        this.username = username;
         //setBounds(0,0,1600,1000);
         setExtendedState(JFrame.MAXIMIZED_BOTH);
         setLayout(null);

         JPanel p1 = new JPanel();
         p1.setLayout(null);
         p1.setBackground(new Color(0,0,102));
         p1.setBounds(0,0,1600,65);
         add(p1);

         ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/dashboard.png"));
         Image i2 = i1.getImage().getScaledInstance(70, 70, Image.SCALE_DEFAULT);
         ImageIcon i3 = new ImageIcon(i2);
         JLabel icon = new JLabel(i3);
         icon.setBounds(5,0, 70, 70);
         p1.add(icon);

         JLabel heading = new JLabel("Dashboard");
         heading.setBounds(80, 10, 300, 40);
         heading.setForeground(Color.WHITE);
         heading.setFont(new Font("Tahoma", Font.BOLD, 19));
         p1.add(heading);

         JPanel p2 = new JPanel();
         p2.setLayout(null);
         p2.setBackground(new Color(0,0,102));
         p2.setBounds(0,65,300,900);
         add(p2);

         addpersondetails = new JButton("Add Person Details");
         addpersondetails.setBounds(0,0,300,50);
         addpersondetails.setBackground(new Color(0,0,102));
         addpersondetails.setForeground(Color.WHITE);
         addpersondetails.setFont(new Font("Tahoma", Font.BOLD,18));
         addpersondetails.setMargin(new Insets(0,0,0,60));
         addpersondetails.addActionListener(this);
         p2.add(addpersondetails);

         updatepersondetails = new JButton("Update Person Details");
         updatepersondetails.setBounds(0,50,300,50);
         updatepersondetails.setBackground(new Color(0,0,102));
         updatepersondetails.setForeground(Color.WHITE);
         updatepersondetails.setFont(new Font("Tahoma", Font.BOLD,18));
         updatepersondetails.setMargin(new Insets(0,0,0,30));
         updatepersondetails.addActionListener(this);
         p2.add(updatepersondetails);

         viewpersonaldetails = new JButton("View Personal Details");
         viewpersonaldetails.setBounds(0,100,300,50);
         viewpersonaldetails.setBackground(new Color(0,0,102));
         viewpersonaldetails.setForeground(Color.WHITE);
         viewpersonaldetails.setFont(new Font("Tahoma", Font.BOLD,18));
         viewpersonaldetails.setMargin(new Insets(0,0,0,40));
         viewpersonaldetails.addActionListener(this);
         p2.add(viewpersonaldetails);

         deletepersonaldetails = new JButton("Delete Personal Details");
         deletepersonaldetails.setBounds(0,150,300,50);
         deletepersonaldetails.setBackground(new Color(0,0,102));
         deletepersonaldetails.setForeground(Color.WHITE);
         deletepersonaldetails.setFont(new Font("Tahoma", Font.BOLD,18));
         deletepersonaldetails.setMargin(new Insets(0,0,0,30));
         deletepersonaldetails.addActionListener(this);
         p2.add(deletepersonaldetails);

         check = new JButton("Check Packages");
         check.setBounds(0,200,300,50);
         check.setBackground(new Color(0,0,102));
         check.setForeground(Color.WHITE);
         check.setFont(new Font("Tahoma", Font.BOLD,18));
         check.setMargin(new Insets(0,0,0,95));
         check.addActionListener(this);
         p2.add(check);

         book = new JButton("Book Package");
         book.setBounds(0,250,300,50);
         book.setBackground(new Color(0,0,102));
         book.setForeground(Color.WHITE);
         book.setFont(new Font("Tahoma", Font.BOLD,18));
         book.setMargin(new Insets(0,0,0,115));
         book.addActionListener(this);
         p2.add(book);

         view = new JButton("View Package");
         view.setBounds(0,300,300,50);
         view.setBackground(new Color(0,0,102));
         view.setForeground(Color.WHITE);
         view.setFont(new Font("Tahoma", Font.BOLD,18));
         view.setMargin(new Insets(0,0,0,115));
         view.addActionListener(this);
         p2.add(view);

         viewhotels = new JButton("View Hotels");
         viewhotels.setBounds(0,350,300,50);
         viewhotels.setBackground(new Color(0,0,102));
         viewhotels.setForeground(Color.WHITE);
         viewhotels.setFont(new Font("Tahoma", Font.BOLD,18));
         viewhotels.setMargin(new Insets(0,0,0,135));
         viewhotels.addActionListener(this);
         p2.add(viewhotels);

         bookhotel = new JButton("Book Hotel");
         bookhotel.setBounds(0,400,300,50);
         bookhotel.setBackground(new Color(0,0,102));
         bookhotel.setForeground(Color.WHITE);
         bookhotel.setFont(new Font("Tahoma", Font.BOLD,18));
         bookhotel.setMargin(new Insets(0,0,0,140));
         bookhotel.addActionListener(this);
         p2.add(bookhotel);

         viewbookhotel = new JButton("View Booked Hotel");
         viewbookhotel.setBounds(0,450,300,50);
         viewbookhotel.setBackground(new Color(0,0,102));
         viewbookhotel.setForeground(Color.WHITE);
         viewbookhotel.setFont(new Font("Tahoma", Font.BOLD,18));
         viewbookhotel.setMargin(new Insets(0,0,0,80));
         viewbookhotel.addActionListener(this);
         p2.add(viewbookhotel);

         destinations = new JButton("Destinations");
         destinations.setBounds(0,500,300,50);
         destinations.setBackground(new Color(0,0,102));
         destinations.setForeground(Color.WHITE);
         destinations.setFont(new Font("Tahoma", Font.BOLD,18));
         destinations.setMargin(new Insets(0,0,0,130));
         destinations.addActionListener(this);
         p2.add(destinations);

         payments = new JButton("Payments");
         payments.setBounds(0,550,300,50);
         payments.setBackground(new Color(0,0,102));
         payments.setForeground(Color.WHITE);
         payments.setFont(new Font("Tahoma", Font.BOLD,18));
         payments.setMargin(new Insets(0,0,0,155));
         payments.addActionListener(this);
         p2.add(payments);




         about = new JButton("About");
         about.setBounds(0,600,300,50);
         about.setBackground(new Color(0,0,102));
         about.setForeground(Color.WHITE);
         about.setFont(new Font("Tahoma", Font.BOLD,18));
         about.setMargin(new Insets(0,0,0,190));
         about.addActionListener(this);
         p2.add(about);

         ImageIcon i4 = new ImageIcon(ClassLoader.getSystemResource("icons/home.jpg"));
         Image i5 = i4.getImage().getScaledInstance(1550, 1000, Image.SCALE_DEFAULT);
         ImageIcon i6 = new ImageIcon(i5);
         JLabel icon1 = new JLabel(i6);
         icon1.setBounds(0,0, 1550, 1000);
         add(icon1);

         JLabel text = new JLabel("Travel and Tourism Management System");
         text.setBounds(400, 70, 1000, 70);
         text.setForeground(Color.DARK_GRAY);
         text.setFont(new Font("Tahoma", Font.BOLD, 36));
         icon1.add(text);
         setVisible(true);
     }
     public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==addpersondetails){
            new AddCustomer(username);
        }else if(ae.getSource()==viewpersonaldetails){
         new ViewCustomer(username);
        } else if (ae.getSource()==updatepersondetails) {
         new UpdateCustomer(username);
        } else if (ae.getSource()==check) {
         new CheckPackage();
        } else if (ae.getSource()==book) {
         new BookPackage(username);
        } else if (ae.getSource()==view) {
         new ViewPackage(username);
        } else if (ae.getSource()==viewhotels) {
         new ViewHotels();
        } else if (ae.getSource()==destinations) {
         new Destinations();
        } else if (ae.getSource()==bookhotel) {
         new BookHotel(username);
        } else if (ae.getSource()==viewbookhotel) {
         new ViewBookedHotel(username);
        } else if (ae.getSource()==payments) {
         new Payment();
        } else if (ae.getSource()==about) {
         new About();
        } else if (ae.getSource()==deletepersonaldetails) {
         new DeleteDetails(username);
        }
     }
    public static void main(String[] args) {
        new Dashboard("");
    }
}
