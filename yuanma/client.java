package yuanma;

import java.net.*;
import javax.swing.*;
import java.awt.event.*;
import java.io.*;
import java.util.Date;

public class client {
    public static void main(String[] args) {
        new login();
    }

    //接受服务器发送过来的信息
    class ClientReadAndPrint extends Thread {
        static Socket socket = null;  // 一定要加上static，否则新建线程时会清空
        static JTextField textInput;
        static JTextField textInput2;
        static JTextArea textShow;

        static JTextArea textShow2;
        static JTextArea textShow3;
        static JFrame chatViewJFrame;
        static BufferedReader in = null;
        static PrintWriter out = null;
        static String niame ;
        static String sex ;
        static int peo;
        static String people;
        chat chat=null;
        static String username;
        public void run() {
            try {
                BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                while (true) {
                    String str = in.readLine();
                    textShow.append(str+"\n");
                    try {
                        mysql m = new mysql();
                        m.count();
                        m.people();
                        peo=m.peo;
                        people=m.people;
                        String s = "在线人数："+peo+"\n"+people;
                        textShow2.setText(s);
                    }catch (Exception e){}

                    textShow.setCaretPosition(textShow.getDocument().getLength());
                }
            } catch (Exception e) {
            }
        }

        //登录监听
        class LoginListen implements ActionListener {
            JTextField textField;
            JPasswordField passwordField;
            JFrame frame;

            //String name;
            chat ch = null;

            public void setTextField(JTextField textField) {
                this.textField = textField;
            }

            public void setPasswordField(JPasswordField passwordField) {
                this.passwordField = passwordField;
            }

            public void setJFrame(JFrame jFrame) {
                this.frame = jFrame;
            }

            public void actionPerformed(ActionEvent event) {
                username = textField.getText();
                String userPwd = String.valueOf(passwordField.getPassword());
                int count=0;
                try {
                    mysql m = new mysql();
                    m.usernamepassword=userPwd;
                    m.username=username;
                    m.getConnection();
                    m.getResult();
                    niame = m.name;

                    count=m.count;
                    sex=m.sex;

                }catch (Exception e1){}
                if (count>0) {
                    chat = new chat(username);
                    frame.dispose();
                    try {
                        mysql m1 = new mysql();
                        m1.exit1(niame);
                        m1.people();
                        m1.count();
                        peo=m1.peo;
                        people = m1.people;
                    }catch (Exception e1){}
                    try {
                        InetAddress addr = InetAddress.getByName(null);
                        socket = new Socket(addr, 8081);
                        frame.setVisible(false);
                        out = new PrintWriter(socket.getOutputStream());
                        out.println("用户【" + niame + "】进入聊天室！"+new Date(System.currentTimeMillis()));
                        textShow.append("用户【" + niame + "】进入聊天室！"+new Date(System.currentTimeMillis())+"\n");
                        textShow2.setText("在线人数："+peo+"\n"+people);
                        System.out.println(sex);
                        textShow3.setText(sex);
                        textInput2.setText(niame);
                        //textShow2.append("在线人数："+m1.peo+"\n");
                        out.flush();
                    } catch (Exception e) {
                    }
                    ClientReadAndPrint readAndPrint = new ClientReadAndPrint();
                    readAndPrint.start();
                } else {
                    JOptionPane.showMessageDialog(frame, "账号或密码错误，请重新输入！", "提示", JOptionPane.WARNING_MESSAGE);
                    textField.setText("");
                    passwordField.setText("");
                }

            }
        }
        //聊天监听
        class ChatViewListen implements ActionListener{
            public void setJTextField(JTextField text,JTextField text2) {
                textInput = text;  // 放在外部类，因为其它地方也要用到
                textInput2 = text2;
            }
            public void setJTextArea(JTextArea textArea) {
                textShow = textArea;  // 放在外部类，因为其它地方也要用到
            }
            public void setTextArea(JTextArea textArea,JTextArea text2) {
                textShow2 = textArea;// 放在外部类，因为其它地方也要用到
                textShow3 = text2;
            }
            public void setChatViewJf(JFrame jFrame) {
                chatViewJFrame = jFrame;  // 放在外部类，因为其它地方也要用到
                // 设置关闭聊天界面的监听
                chatViewJFrame.addWindowListener(new WindowAdapter() {
                    public void windowClosing(WindowEvent e) {
                        out.println("用户【" + niame + "】离开聊天室！"+new Date(System.currentTimeMillis()));
                        textShow.append("用户【" + niame + "】离开聊天室！"+new Date(System.currentTimeMillis()));
                        try {
                            mysql m1 = new mysql();
                            m1.exit0(niame);
                        }catch (Exception e1){}
                        out.flush();
                        System.exit(0);
                    }
                });
            }
            // 监听执行函数
            public void actionPerformed(ActionEvent event) {
                try {
                    String str = textInput.getText();
                    // 文本框内容为空
                    if("".equals(str)) {
                        textInput.grabFocus();  // 设置焦点（可行）
                        // 弹出消息对话框（警告消息）
                        JOptionPane.showMessageDialog(chatViewJFrame, "输入为空，请重新输入！", "提示", JOptionPane.WARNING_MESSAGE);
                        return;
                    }
                    out.println(niame + " 说：" + str);  // 输出给服务端
                    textShow.append("（我）" + " 说：" + str+"\n");
                    out.flush();  // 清空缓冲区out中的数据

                    textInput.setText("");  // 清空文本框
                    textInput.grabFocus();  // 设置焦点（可行）
//				    textInput.requestFocus(true);  // 设置焦点（可行）
                } catch (Exception e) {}
            }
        }
    }
}
