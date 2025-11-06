package travelandtourism;
import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Login extends  JFrame implements ActionListener {
    JButton login, signup, Forget_password;
    Login(){
        setSize(700, 500);
        setLocation(300, 100);
        setLayout(null);

        getContentPane().setBackground(Color.WHITE);
        JPanel p1 = new JPanel();
        p1.setBackground(new Color(131, 193, 233));
        p1.setBounds(0,0, 330,500);
        p1.setLayout(null);
        add(p1);
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/login.png"));
        Image i2 = i1.getImage().getScaledInstance(200, 200, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(60,120, 200, 200);
        p1.add(image);

        JPanel p2 = new JPanel();
        p2.setLayout(null);
        p2.setBounds(330, 80, 450,300);
        add(p2);

        JLabel lblusername = new JLabel("Username");
        lblusername.setBounds(60, 20 , 100, 25);
        lblusername.setFont(new Font("SAN SERIF", Font.BOLD, 20));
        p2.add(lblusername);

        JTextField tfusername = new JTextField();
        tfusername.setBounds(60, 50, 200, 30);
        tfusername.setBorder(BorderFactory.createEmptyBorder());
        p2.add(tfusername);

        JLabel lblpassword = new JLabel("Password");
        lblpassword.setBounds(60, 110 , 100, 25);
        lblpassword.setFont(new Font("SAN SERIF", Font.BOLD, 20));
        p2.add(lblpassword);

        JTextField tfpassword = new JTextField();
        tfpassword.setBounds(60, 140, 200, 30);
        tfpassword.setBorder(BorderFactory.createEmptyBorder());
        p2.add(tfpassword);

        login = new JButton("Login");
        login.setBounds(60, 190, 80, 30 );
        login.setBackground(new Color(133, 193, 233));
        login.setForeground(Color.WHITE);
        login.setBorder(new LineBorder(new Color(133, 193, 233)));
        login.addActionListener(this);
        p2.add(login);

        signup = new JButton("SignUp");
        signup.setBounds(170, 190, 80, 30 );
        signup.setBackground(new Color(133, 193, 233));
        signup.setForeground(Color.WHITE);
        signup.setBorder(new LineBorder(new Color(133, 193, 233)));
        signup.addActionListener(this);
        p2.add(signup);

        Forget_password = new JButton("Forgot Password");
        Forget_password.setBounds(90, 250, 150, 30 );
        Forget_password.setBackground(new Color(133, 193, 233));
        Forget_password.setForeground(Color.WHITE);
        Forget_password.setBorder(new LineBorder(new Color(133, 193, 233)));
        Forget_password.addActionListener(this);
        p2.add(Forget_password);

        JLabel text = new JLabel("Trouble in Login...");
        text.setBounds(250, 250, 150, 30);
        text.setForeground(Color.RED);
        p2.add(text);
        setVisible(true);
    }
    public void actionPerformed(ActionEvent ae){
        if (ae.getSource() == login){
            
        } else if (ae.getSource()== signup) {
            setVisible(false);
            new Signup();
        }else {
            setVisible(false);
            new ForgetPassword();
        }
    }
    public static void main(String[] args) {
        new Login();
    }
}
