package yuanma;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class login  {
    public String username ;
    public String str;
    public int a=0;
    public login(){
        jiemian();
    }
    public void jiemian(){
        //创建元件
        JFrame frame = new JFrame("登录");
        JPanel panel = new JPanel();
        JButton button1 =new JButton("登录");
        JButton button2 =new JButton("重置");
        JTextField jTextField = new JTextField();
        JPasswordField jPasswordField = new JPasswordField();
        JLabel jLabel1 = new JLabel("用户名：");
        JLabel jLabel2 = new JLabel("密码 ：");
        frame.setContentPane(panel);
        frame.setBounds(400,300,400,300);
        frame.setDefaultCloseOperation (JFrame.DISPOSE_ON_CLOSE);
        jLabel1.setVisible(true);
        jLabel2.setVisible(true);
        frame.setVisible(true);
        //加元件
        panel.add(button1);
        panel.add(button2);
        panel.add(jTextField);
        panel.add(jPasswordField);
        panel.add(jLabel1);
        panel.add(jLabel2);
        //摆放元件位置
        panel.setLayout(null);
        button1.setBounds(70,180,100,50);
        button2.setBounds(220,180,100,50);
        jTextField.setBounds(130,50,180,30);
        jPasswordField.setBounds(130,100,180,30);
        jLabel1.setBounds(70,45,50,40);
        jLabel2.setBounds(70,95,50,40);
        //聊天窗口对象
        this.username = jTextField.getText();
        System.out.println(this.username);
        login.this.username=username;
        login.this.str=str;
        //按钮绑定
        client cl =new client();
        client.ClientReadAndPrint cc =  cl.new ClientReadAndPrint();
        client.ClientReadAndPrint.LoginListen listener = cc.new LoginListen();
        //kehu.ClientReadAndPrint.LoginListen listener = new kehu.ClientReadAndPrint.LoginListen();// 新建监听类
        listener.setTextField(jTextField);  // 调用PoliceListen类的方法
        listener.setPasswordField(jPasswordField);
        listener.setJFrame(frame);
        jPasswordField.addActionListener(listener);  // 密码框添加监听
        button1.addActionListener(listener);  // 按钮添加监听
        button2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
                jTextField.setText("");
                jPasswordField.setText("");
            }
        });
    }


}
