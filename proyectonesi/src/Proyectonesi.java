/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.util.*;
import java.math.*;
/**
 *
 * @author juras
 */
public class Proyectonesi extends JFrame{

    /**
     * @param args the command line arguments
     */
    private JTextField texto = new JTextField();
    private JButton uno = new JButton();
    private JButton dos = new JButton();
    private JButton tres = new JButton();
    private JButton cuatro = new JButton();
    private JButton cinco = new JButton();
    private JButton seis = new JButton();
    private JButton siete = new JButton();
    private JButton ocho = new JButton();
    private JButton nueve = new JButton();
    private JButton cero = new JButton();
    private JButton suma = new JButton();
    private JButton resta = new JButton();
    private JButton multi = new JButton();
    private JButton divi = new JButton();
    private JButton igual = new JButton();
    private JButton borrar = new JButton();
    
    public Proyectonesi(){
        setTitle("Calculadora");
        setSize(420,300);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        nums = new ArrayList<>();
        nums.add(0.0);
    }
    
    public void AddComponentes(JPanel panel){
        //(x, y, ancho, alto)
        texto.setBounds(10, 20, 370, 50);
        panel.add(texto);
        
        uno.setBounds(10,90,80,30);
        uno.setText("1");
        panel.add(uno);
        uno.addActionListener(new java.awt.event.ActionListener(){
            @Override
            public void actionPerformed(java.awt.event.ActionEvent evt){
                unoActionPerformed(evt);
            }
        });
        
        dos.setBounds(100,90,80,30);
        dos.setText("2");
        panel.add(dos);
        dos.addActionListener(new java.awt.event.ActionListener(){
            @Override
            public void actionPerformed(java.awt.event.ActionEvent evt){
                dosActionPerformed(evt);
            }
        });
        
        tres.setBounds(190,90,80,30);
        tres.setText("3");
        panel.add(tres);
        tres.addActionListener(new java.awt.event.ActionListener(){
            @Override
            public void actionPerformed(java.awt.event.ActionEvent evt){
                tresActionPerformed(evt);
            }
        });
        
        cuatro.setBounds(10,130,80,30);
        cuatro.setText("4");
        panel.add(cuatro);
        cuatro.addActionListener(new java.awt.event.ActionListener(){
            @Override
            public void actionPerformed(java.awt.event.ActionEvent evt){
                cuatroActionPerformed(evt);
            }
        });
        
        cinco.setBounds(100,130,80,30);
        cinco.setText("5");
        panel.add(cinco);
        cinco.addActionListener(new java.awt.event.ActionListener(){
            @Override
            public void actionPerformed(java.awt.event.ActionEvent evt){
                cincoActionPerformed(evt);
            }
        });
        
        seis.setBounds(190,130,80,30);
        seis.setText("6");
        panel.add(seis);
        seis.addActionListener(new java.awt.event.ActionListener(){
            @Override
            public void actionPerformed(java.awt.event.ActionEvent evt){
                seisActionPerformed(evt);
            }
        });
        
        siete.setBounds(10,170,80,30);
        siete.setText("7");
        panel.add(siete);
        siete.addActionListener(new java.awt.event.ActionListener(){
            @Override
            public void actionPerformed(java.awt.event.ActionEvent evt){
                sieteActionPerformed(evt);
            }
        });
        
        ocho.setBounds(100,170,80,30);
        ocho.setText("8");
        panel.add(ocho);
        ocho.addActionListener(new java.awt.event.ActionListener(){
            @Override
            public void actionPerformed(java.awt.event.ActionEvent evt){
                ochoActionPerformed(evt);
            }
        });
        
        nueve.setBounds(190,170,80,30);
        nueve.setText("9");
        panel.add(nueve);
        nueve.addActionListener(new java.awt.event.ActionListener(){
            @Override
            public void actionPerformed(java.awt.event.ActionEvent evt){
                nueveActionPerformed(evt);
            }
        });
        
        cero.setBounds(100,210,80,30);
        cero.setText("0");
        panel.add(cero);
        cero.addActionListener(new java.awt.event.ActionListener(){
            @Override
            public void actionPerformed(java.awt.event.ActionEvent evt){
                ceroActionPerformed(evt);
            }
        });
        
        suma.setBounds(300,90,80,30);
        suma.setText("+");
        panel.add(suma);
        suma.addActionListener(new java.awt.event.ActionListener(){
            @Override
            public void actionPerformed(java.awt.event.ActionEvent evt){
                sumaActionPerformed(evt);
            }
        });
       
        resta.setBounds(300,130,80,30);
        resta.setText("-");
        panel.add(resta);
        resta.addActionListener(new java.awt.event.ActionListener(){
            @Override
            public void actionPerformed(java.awt.event.ActionEvent evt){
                restaActionPerformed(evt);
            }
        });
        
        multi.setBounds(300,170,80,30);
        multi.setText("x");
        panel.add(multi);
        multi.addActionListener(new java.awt.event.ActionListener(){
            @Override
            public void actionPerformed(java.awt.event.ActionEvent evt){
                multiActionPerformed(evt);
            }
        });
        
        divi.setBounds(300,210,80,30);
        divi.setText("÷");
        panel.add(divi);
        divi.addActionListener(new java.awt.event.ActionListener(){
            @Override
            public void actionPerformed(java.awt.event.ActionEvent evt){
                diviActionPerformed(evt);
            }
        });
        
        igual.setBounds(190,210,80,30);
        igual.setText("=");
        panel.add(igual);
        igual.addActionListener(new java.awt.event.ActionListener(){
            @Override
            public void actionPerformed(java.awt.event.ActionEvent evt){
                igualActionPerformed(evt);
            }
        });
        
        borrar.setBounds(10,210,80,30);
        borrar.setText("CE");
        panel.add(borrar);
        borrar.addActionListener(new java.awt.event.ActionListener(){
            @Override
            public void actionPerformed(java.awt.event.ActionEvent evt){
                borrarActionPerformed(evt);
            }
        });
    }
    
    String set;
    Double num;
    int i = 0;
    int j;
    Boolean enc = false;
    ArrayList<Double> nums = new ArrayList();
    ArrayList<Integer> opp = new ArrayList(); //1 = suma, 2 = resta, 3 = multi, 4 = divi
    
        private void unoActionPerformed(ActionEvent evt){
            if(enc){
                set = "";
                enc = false;
                nums.clear();
                nums.add(0.0);
            } else{
                set = texto.getText();
            }
            num = (nums.get(i)*10) + 1;
            texto.setText(set+"1");
            nums.set(i,num);
        }
        
        private void dosActionPerformed(ActionEvent evt){
            if(enc){
                set = "";
                enc = false;
                nums.clear();
                nums.add(0.0);
            } else{
                set = texto.getText();
            }
            texto.setText(set+"2");
            num = (nums.get(i)*10) + 2;
            nums.set(i,num);
        }

        private void tresActionPerformed(ActionEvent evt){
            if(enc){
                set = "";
                enc = false;
                nums.clear();
                nums.add(0.0);
            } else{
                set = texto.getText();
            }
            texto.setText(set+"3");
            num = (nums.get(i)*10) + 3;
            nums.set(i,num);
        }
        
        private void cuatroActionPerformed(ActionEvent evt){
            if(enc){
                set = "";
                enc = false;
                nums.clear();
                nums.add(0.0);
            } else{
                set = texto.getText();
            }
            texto.setText(set+"4");
            num = (nums.get(i)*10) + 4;
            nums.set(i,num);
        }
        
        private void cincoActionPerformed(ActionEvent evt){
            if(enc){
                set = "";
                enc = false;
                nums.clear();
                nums.add(0.0);
            } else{
                set = texto.getText();
            }
            texto.setText(set+"5");
            num = (nums.get(i)*10) + 5;
            nums.set(i,num);
        }

        private void seisActionPerformed(ActionEvent evt){
            if(enc){
                set = "";
                enc = false;
                nums.clear();
                nums.add(0.0);
            } else{
                set = texto.getText();
            }
            texto.setText(set+"6");
            num = (nums.get(i)*10) + 6;
            nums.set(i,num);
        }

        private void sieteActionPerformed(ActionEvent evt){
            if(enc){
                set = "";
                enc = false;
                nums.clear();
                nums.add(0.0);
            } else{
                set = texto.getText();
            }
            texto.setText(set+"7");
            num = (nums.get(i)*10) + 7;
            nums.set(i,num);
        }

        private void ochoActionPerformed(ActionEvent evt){
            if(enc){
                set = "";
                enc = false;
                nums.clear();
                nums.add(0.0);
            } else{
                set = texto.getText();
            }
            texto.setText(set+"8");
            num = (nums.get(i)*10) + 8;
            nums.set(i,num);
        }

        private void nueveActionPerformed(ActionEvent evt){
            if(enc){
                set = "";
                enc = false;
                nums.clear();
                nums.add(0.0);
            } else{
                set = texto.getText();
            }
            texto.setText(set+"9");
            num = (nums.get(i)*10) + 9;
            nums.set(i,num);
        }

        private void ceroActionPerformed(ActionEvent evt){
            if(enc){
                set = "";
                enc = false;
                nums.clear();
                nums.add(0.0);
            } else{
                set = texto.getText();
            }
            texto.setText(set+"0");
            num = (nums.get(i)*10);
            nums.set(i,num);
        }
        
        private void sumaActionPerformed(ActionEvent evt){
            set = texto.getText();
            if(enc){
                enc = false;
            }
            texto.setText(set+" + ");
            opp.add(1);
            i++;
            nums.add(0.0);
        }
        
        private void restaActionPerformed(ActionEvent evt){
            set = texto.getText();
            if(enc){
                enc = false;
            }
            texto.setText(set+" - ");
            i++;
            opp.add(2);
            nums.add(0.0);
        }
        
        private void multiActionPerformed(ActionEvent evt){
            set = texto.getText();
            if(enc){
                enc = false;
            }
            texto.setText(set+" x ");
            opp.add(3);
            i++;
            nums.add(0.0);
        }
        
        private void diviActionPerformed(ActionEvent evt){
            set = texto.getText();
            if(enc){
                enc = false;
            }
            texto.setText(set+" ÷ ");
            opp.add(4);
            i++;
            nums.add(0.0);
        }
        
        private void igualActionPerformed(ActionEvent evt){
            for(j=0;j<opp.size();j++){
                if(opp.get(j)==3){
                    nums.set(j+1,Math.round((nums.get(j) * nums.get(j+1)) * 1000.0) / 1000.0);
                    nums.remove(j);
                    opp.remove(j);
                    j--;
                } else if(opp.get(j)==4){
                    nums.set(j+1,Math.round((nums.get(j) / nums.get(j+1)) * 1000.0) / 1000.0);
                    nums.remove(j);
                    opp.remove(j);
                    j--;
                }
            }
            for(j=0;j<opp.size();j++){
                if(opp.get(j)==1){
                    nums.set(j+1,Math.round((nums.get(j) + nums.get(j+1)) * 1000.0) / 1000.0);
                    nums.remove(j);
                    opp.remove(j);
                    j--;
                } else if(opp.get(j)==2){
                    nums.set(j+1,Math.round((nums.get(j) - nums.get(j+1)) * 1000.0) / 1000.0);
                    nums.remove(j);
                    opp.remove(j);
                    j--;
                }
            }
            texto.setText(String.valueOf(nums.get(0)));
            opp.clear();
            i = 0;
            enc = true;
        }
        
        private void borrarActionPerformed(ActionEvent evt){
            texto.setText("");
            nums.clear();
            opp.clear();
            i = 0;
            nums.add(0.0);
        }
        
    public static void main(String[] args) {
        // TODO code application logic here
        Proyectonesi ventana = new Proyectonesi();
                
        JPanel panel = new JPanel();
        panel.setLayout(null);
        
        ventana.getContentPane().add(panel);
        ventana.AddComponentes(panel);
        
        ventana.setVisible(true);
    }    
}