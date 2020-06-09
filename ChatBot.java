package chatbot;
/**
 *
 * @author Aarjav Sheth
 * @github aarjavsheth
 *
 */
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.Random;

import javax.swing.JTextArea;
import javax.swing.JScrollBar;

public class ChatBot extends JFrame {

    private JPanel panel;
    private JTextField messageField;
    private JButton sendBtn;
    private String main = "";
    JTextArea textArea;
    private JScrollBar scrollBar;

    /** Launch the application */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    ChatBot frame = new ChatBot();
                    frame.setVisible(true);
                }
                catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    /** Create the frame */
    public ChatBot() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        setBounds(700, 100, 428, 657);
        panel = new JPanel();
        panel.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(panel);
        panel.setLayout(null);

        messageField = new JTextField();
        messageField.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if(e.getKeyCode() == KeyEvent.VK_ENTER) {
                    action();
                }
            }
        });

        messageField.setFont(new Font("Segoe UI", Font.PLAIN, 18));
        messageField.setBounds(0, 555, 338, 60);
        panel.add(messageField);
        messageField.setColumns(10);

        sendBtn = new JButton("SEND");
        sendBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                action();
            }
        });
        sendBtn.setBounds(341, 555, 75, 59);
        panel.add(sendBtn);

        textArea = new JTextArea();
        textArea.setFont(new Font("Segoe UI", Font.PLAIN, 16));
        textArea.setEditable(false);
        textArea.setBounds(0, 0, 396, 554);
        panel.add(textArea);
    }

    void action() {
        String query = messageField.getText();
        textArea.append(" You: "+query+"\n");
        query.trim();
        query = query.toLowerCase();
        if(query.contains("clear screen") || query.contains("clr") || query.contains("cls")) {
            textArea.setText("");
            messageField.setText("");
        }
        else if(query.contains("hi") || query.contains("hey") || query.contains("hola") || query.contains("hello")) {
            Random rand = new Random();
            int a = rand.nextInt(4);
            if(a == 0) {
                showMessage("Hey,I'm Here");
            }
            else if(a == 1) {
                showMessage("Hey,Wssup?");
            }
            else if(a == 2) {
                showMessage("Hey,How u doing?");
            }
            else if(a == 3) {
                showMessage("Hello,u there?");
            }
            else if(a == 4) {
                showMessage("Hello,How u doing?");
            }
        }
        else if(query.contains("fine") || query.contains("I'm fine") || query.contains("am okay") || query.contains("good")
                || query.contains("great")) {

            Random rand = new Random();
            int a = rand.nextInt(4);
            if(a == 0) {
                showMessage("It's good to know that you are fine");
            }
            else if(a == 1) {
                showMessage("It's pleasure to know that you are fine");
            }
            else if(a == 2) {
                showMessage("Oh,great");
            }
            else if(a == 3) {
                showMessage("Oh,such a great news");
            }
            else if(a == 4) {
                showMessage("Wish,you always remain fine");
            }
        }
        else if(query.contains("wssup") || query.contains("whats up") || query.contains("whatsup") || query.contains("wtsup")
                || query.contains("you doing") || query.contains("u doing") || query.contains("how are you")) {

            showMessage("I'm fine and what about you");
        }
        else if(query.contains("yes") || query.contains("yeah") || query.contains("ya")) {
            Random rand = new Random();
            int a = rand.nextInt(2);
            if(a == 0) {
                showMessage("Oh, Great");
            }
            else if(a == 1) {
                showMessage("Ohh,Great news");
            }
            else if(a == 2) {
                showMessage("Nice");
            }
        }
        else if(query.contains("nthng") || query.contains("nothing") || query.contains("nm")) {
            Random rand = new Random();
            int a = rand.nextInt(2);
            if(a == 0) {
                showMessage("Why?");
            }
            else if(a == 1) {
                showMessage("Why? as per I know you are a very charming person");
            }
            else if(a == 2) {
                showMessage("Why? Don't waste your time this way");
            }
        }
        else if(query.contains("what you doing") || query.contains("u doing")) {
            showMessage("Talking with you XD");
        }
        else {
            Random rand=new Random();
            int a = rand.nextInt(4);
            if(a == 0) {
                showMessage("Sorry,I'cant get you");
            }
            else if(a == 1) {
                showMessage("Plase say it correctly");
            }
            else if(a == 2) {
                showMessage("Please rephrase that");
            }
            else if(a == 3) {
                showMessage("???");
            }
        }
    }


    void showMessage(String s) {
        textArea.append(" Bot: "+s+"\n\n");
        messageField.setText("");
    }
}