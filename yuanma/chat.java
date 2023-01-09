package yuanma;

import javax.swing.*;
import java.awt.*;

public class chat {
    public String username;
    public int count;

    public String name;
    public String sex;

    public chat(String username){
        this.username = username;
        jiemain();
    }
    public void jiemain (){
        JFrame frame = new JFrame("客户端");
        JPanel panel = new JPanel();
        JButton button = new JButton("发送");
        JLabel label = new JLabel("发送的名字：");
        JLabel label1 = new JLabel("性别：");
        label1.setVisible(true);

        JTextArea jTextArea1 =new JTextArea();
        jTextArea1.setEnabled(false);
        jTextArea1.setDisabledTextColor(Color.black);
        JTextArea jTextArea2 =new JTextArea();
        jTextArea2.setEnabled(false);
        jTextArea2.setDisabledTextColor(Color.black);
        JTextArea jTextArea3 = new JTextArea();
        jTextArea3.setDisabledTextColor(Color.red);
        jTextArea3.setEnabled(false);
        jTextArea3.setVisible(true);

        JTextField jTextField1 = new JTextField();
        jTextField1.setDisabledTextColor(Color.black);
        JTextField jTextField2= new JTextField();
        jTextField2.setDisabledTextColor(Color.red);
        jTextField2.setEnabled(false);
        frame.setContentPane(panel);
        frame.setBounds(400,200,600,650);
        frame.setDefaultCloseOperation (JFrame.DISPOSE_ON_CLOSE);
        frame.setVisible(true);

        //加入元件
        panel.add(button);
        panel.add(jTextArea1);
        panel.add(jTextArea2);
        panel.add(jTextField1);
        panel.add(jTextField2);
        panel.add(label);
        panel.add(label1);
        panel.add(jTextArea3);
        //元件位置
        panel.setLayout(null);
        jTextArea1.setBounds(20,30,350,500);
        jTextArea2.setBounds(400,30,170,500);

        jTextArea3.setBounds(50,565,30,20);
        label1.setBounds(20,560,50,30);

        jTextField1.setBounds(120,560,200,30);
        button.setBounds(350,560,70,30);
        label.setBounds(430,560,70,30);
        jTextField2.setBounds(500,560,80,30);
        //按钮的监听
        client cl =new client();
        client.ClientReadAndPrint cc =  cl.new ClientReadAndPrint();
        client.ClientReadAndPrint.ChatViewListen listener = cc.new ChatViewListen();
        listener.setJTextField(jTextField1,jTextField2);  // 调用PoliceListen类的方法
        listener.setJTextArea(jTextArea1);
        listener.setTextArea(jTextArea2,jTextArea3);
        listener.setChatViewJf(frame);
        jTextField1.addActionListener(listener);  // 文本框添加监听
        button.addActionListener(listener);  // 按钮添加监听


    }
}
