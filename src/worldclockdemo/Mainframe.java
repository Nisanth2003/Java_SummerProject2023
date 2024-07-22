package worldclockdemo;
//America
//Russia
//Australia
//China
//Brazil
//India
//Canada
//Greenland
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.ZoneId;
import java.time.ZonedDateTime;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.Timer;
import javax.swing.border.EmptyBorder;
import java.awt.event.MouseMotionAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseAdapter;
import java.awt.Color;
import javax.swing.SwingConstants;

public class Mainframe extends JFrame implements ActionListener {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    ZonedDateTime zdt;
    String zoneName = "Asia/Calcutta";
    String cname = "India";
    JLabel lblNewLabel_1;
    JLabel lblNewLabel_4;
    JLabel lblNewLabel_5;
    JLabel lblMouseX;
    JLabel lblMouseY;
    Timer timer;
    private JLabel lblNewLabel_7;

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    Mainframe frame = new Mainframe();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public Mainframe() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 779, 658);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

        setContentPane(contentPane);
        contentPane.setLayout(null);

        timer = new Timer(1000, this);

        JLabel lblNewLabel = new JLabel("Country Name");
        lblNewLabel.setBounds(124, 39, 150, 37);
        lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 20));
        contentPane.add(lblNewLabel);

        lblNewLabel_1 = new JLabel(cname);
        lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
        lblNewLabel_1.setForeground(new Color(255, 0, 0));
        lblNewLabel_1.setBounds(266, 39, 158, 37);
        lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 25));
        contentPane.add(lblNewLabel_1);

        JLabel lblNewLabel_2 = new JLabel("Current Date");
        lblNewLabel_2.setBounds(434, 11, 116, 36);
        lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 17));
        contentPane.add(lblNewLabel_2);

        JLabel lblNewLabel_3 = new JLabel("Current Time");
        lblNewLabel_3.setBounds(422, 72, 116, 37);
        lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 17));
        contentPane.add(lblNewLabel_3);

        lblNewLabel_4 = new JLabel();
        lblNewLabel_4.setForeground(new Color(255, 0, 0));
        lblNewLabel_4.setBounds(560, 15, 150, 29);
        lblNewLabel_4.setFont(new Font("Tahoma", Font.BOLD, 17));
        contentPane.add(lblNewLabel_4);

        lblNewLabel_5 = new JLabel();
        lblNewLabel_5.setForeground(new Color(255, 0, 0));
        lblNewLabel_5.setBounds(548, 75, 207, 31);
        lblNewLabel_5.setFont(new Font("Tahoma", Font.BOLD, 17));
        contentPane.add(lblNewLabel_5);

        JSeparator separator = new JSeparator();
        separator.setBounds(0, 120, 780, 11);
        contentPane.add(separator);

        lblMouseX = new JLabel("X");
        lblMouseX.setFont(new Font("Tahoma", Font.BOLD, 15));
        lblMouseX.setBounds(160, 90, 63, 19);
        contentPane.add(lblMouseX);

        lblMouseY = new JLabel("Y");
        lblMouseY.setFont(new Font("Tahoma", Font.BOLD, 15));
        lblMouseY.setBounds(233, 90, 67, 19);
        contentPane.add(lblMouseY);

        JLabel lblNewLabel_6 = new JLabel();
        lblNewLabel_6.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int x = e.getX();
                int y = e.getY();
                if ((x > 118) && (x < 230) && (y > 210) && (y < 260)) {
                    cname = "America";
                    zoneName = "America/New_York";
                } else if ((x > 406) && (x < 667) && (y > 79) && (y < 200)) {
                    cname = "Russia";
                    zoneName = "Europe/Moscow";
                } else if ((x > 584) && (x < 664) && (y > 355) && (y < 440)) {
                    cname = "Australia";
                    zoneName = "Australia/Sydney";
                } else if ((x > 501) && (x < 610) && (y > 195) && (y < 265)) {
                    cname = "China";
                    zoneName = "Asia/Shanghai";
                }else if ((x > 206) && (x < 282) && (y > 325) && (y < 390)) {
                    cname = "Brazil";
                    zoneName = "America/Sao_Paulo";
                } else if ((x > 495) && (x < 535) && (y > 255) && (y < 315)) {
                    cname = "India";
                    zoneName = "Asia/Kolkata";
                } else if ((x > 105) && (x < 250) && (y > 80) && (y < 210)) {
                    cname = "Canada";
                    zoneName = "America/Toronto";
                } else if ((x > 255) && (x < 330) && (y > 70) && (y < 180)) {
                    cname = "Greenland";
                    zoneName = "America/Godthab";
                }
                zdt = ZonedDateTime.now(ZoneId.of(zoneName));
                lblNewLabel_4.setText(zdt.toLocalDate().toString());
                lblNewLabel_5.setText(zdt.toLocalTime().toString());
                lblNewLabel_1.setText(cname);
            }
        });
        lblNewLabel_6.addMouseMotionListener(new MouseMotionAdapter() {
            @Override
            public void mouseMoved(MouseEvent e) {
                lblMouseX.setText("X: " + e.getX());
                lblMouseY.setText("Y: " + e.getY());
            }
        });
        lblNewLabel_6.setBounds(0, 130, 768, 494);
        lblNewLabel_6.setIcon(new ImageIcon("D:\\java\\worldclockdemo\\images\\2.png"));
        contentPane.add(lblNewLabel_6);

        zdt = ZonedDateTime.now(ZoneId.of(zoneName));
        lblNewLabel_4.setText(zdt.toLocalDate().toString());
        lblNewLabel_5.setText(zdt.toLocalTime().toString());
        
        lblNewLabel_7 = new JLabel("Coordinates:");
        lblNewLabel_7.setFont(new Font("Tahoma", Font.BOLD, 20));
        lblNewLabel_7.setBounds(10, 90, 140, 19);
        contentPane.add(lblNewLabel_7);

        timer.start();
    }

    public void actionPerformed(ActionEvent e) {
        zdt = ZonedDateTime.now(ZoneId.of(zoneName));
        lblNewLabel_4.setText(zdt.toLocalDate().toString());
        lblNewLabel_5.setText(zdt.toLocalTime().toString());
        lblNewLabel_1.setText(cname);
    }
}