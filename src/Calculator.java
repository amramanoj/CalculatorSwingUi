import javax.swing.*;
import java.awt.*;

public class Calculator {
     JLabel jLabel;
    public  void addbtn(){
        String[] cal={
                "1","2","3","/",
                "4","5","6","*" ,
                "7","8","9" ,"-"   ,
                ".","0","+" ,"="
               ,"C"

        };
        JFrame f=new JFrame("JAVA TEAM (TCG) S_C_R_B");

        Panel panel=new Panel();
        Panel panel1=new Panel();
        jLabel=new JLabel("0");
        jLabel.setFont(new Font("Serif", Font.BOLD, 24));
        panel1.add(jLabel);



        String value="";
        for(int i=0;i<17;i++) {

            value=""+(i+1);
            JButton b1 = new JButton(cal[i]);
            b1.setFont(new Font("Serif", Font.BOLD, 24));
            panel.add(b1);

            b1.addActionListener(e -> {

                if(b1.getText().equals("=")){
                    String data=jLabel.getText();

                    if(new HandleInput().isOpr(""+data.charAt(data.length()-1))||(data.charAt(data.length()-1)=='.')){
                  data=data.substring(0,data.length()-1);
                        if(new HandleInput().isOpr(""+data.charAt(data.length()-1))||(data.charAt(data.length()-1)=='.')){ data=data.substring(0,data.length()-1);}

                  jLabel.setText(data);
                    }


                    if(data.length()>0&&new HandleInput().indexLast(data)>0) {
                      jLabel.setText(  new Operation().calculate(data));
                    }else {
                        System.out.println("wrong input");
                    }

                } else if (b1.getText().equals("C")){ jLabel.setText("0");}
                else {
jLabel.setText(new HandleInput().handleAirth(jLabel.getText(),b1.getText()));

                }



            });
        }
        panel.setSize(400,400);
        panel.setLayout(new GridLayout(5,4));
        f.setLayout(new BorderLayout());
        f.setSize(450,400);
        f.setVisible(true);

        f.add(panel1,BorderLayout.NORTH);
        f.add(panel,BorderLayout.CENTER);

    }

    public boolean isOprt(String data){

        if(data.equals("+")||data.equals("-")||data.equals("*")||data.equals("/")){
            return true;
        }
else {
      return false;}
    }
    public boolean isNum(String data){
        if(data.equals("1")||data.equals("2")||data.equals("3")||data.equals("4")||data.equals("5")||data.equals("6")
                ||data.equals("7")||data.equals("8")||data.equals("9")||data.equals("0")){
            return true;
        }else {
            return false;
        }
    }
}
