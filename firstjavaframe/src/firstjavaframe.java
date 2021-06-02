import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class firstjavaframe extends Frame implements ActionListener {

    Label label;
    public firstjavaframe() {

        Frame frame = new Frame("helllo bhai");

        TextArea textArea = new TextArea("");
        textArea.setBounds(250,40,200,200);

        TextField textField = new TextField();
        textField.setBackground(Color.blue);
       textField.setBounds(40,250,150,30);

        label = new Label("hello Bhai");
        label.setBackground(Color.cyan);
        label.setBounds(20,90,80,30);

        Button button = new Button("Click Me");
        button.setBackground(Color.red);
        button.setForeground(Color.white);
        button.setBounds(20,40,80,30);

        Checkbox checkbox = new Checkbox("JAVA");
        checkbox.setBounds(20,120,50,30);

        Checkbox checkbox1 = new Checkbox("PYTHON");
        checkbox1.setBounds(20,150,50,30);

//        button.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                label.setText("button click successfuly");
//          }
//        });

        button.addActionListener(this);

        frame.add(checkbox);
        frame.add(checkbox1);

        frame.add(textArea);

     frame.add(textField);

        frame.add(label);

        frame.add(button);

        frame.setSize(700, 500);
        frame.setLayout(null);
        frame.setVisible(true);

        frame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                frame.dispose();
            }
        });
    }

    public static void main(String[] args) {
        //   new firstjavaframe();

        firstjavaframe object = new firstjavaframe();

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        label.setText("button click successfully");

    }
}

