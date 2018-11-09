import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import javax.swing.JComboBox;
import javax.swing.*;
import java.util.Random;

public class Processes extends JPanel
{
    private String[] schedulingAlgo = {"1. FCFS", "2. SJF"};
    private JComboBox algoCombo = new JComboBox(schedulingAlgo);
    private Integer[] processList = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11};
    private JComboBox<Integer> processCombo = new JComboBox(processList);
    private JButton buttonExecute = new JButton("Execute");
    private int numOfProcesses;
    private String algoSelected;
    
    private int[] burstValues;
    private HashMap<Integer, Integer> mapBurst = new HashMap<Integer, Integer>();
    
    private JTextField text1 = new JTextField("0");
    private JTextField text2 = new JTextField("0");
    private JTextField text3 = new JTextField("0");
    private JTextField text4 = new JTextField("0");
    private JTextField text5 = new JTextField("0");
    private JTextField text6 = new JTextField("0");
    private JTextField text7 = new JTextField("0");
    private JTextField text8 = new JTextField("0");
    private JTextField text9 = new JTextField("0");
    private JTextField text10 = new JTextField("0");
    private JTextField text11 = new JTextField("0");
    
    private JLabel label1 = new JLabel("Process 1");
    private JLabel label2 = new JLabel("Process 2");
    private JLabel label3 = new JLabel("Process 3");
    private JLabel label4 = new JLabel("Process 4");
    private JLabel label5 = new JLabel("Process 5");
    private JLabel label6 = new JLabel("Process 6");
    private JLabel label7 = new JLabel("Process 7");
    private JLabel label8 = new JLabel("Process 8");
    private JLabel label9 = new JLabel("Process 9");
    private JLabel label10 = new JLabel("Process 10");
    private JLabel label11 = new JLabel("Process 11");
    
    private JLabel comboLabel = new JLabel("Select number of Processes");
    private JLabel scheduleLabel = new JLabel("Select the algorithm you'd like to use");
    private JButton buttonReset = new JButton("Reset");
    private JButton buttonRandom = new JButton("Random");
    
    private Calculate obj1;
    
    public Processes()
    {
        super();
        setLayout(null);
        setBounds(0, 0, 900, 600);
        drawComboBox();
        drawExecuteButton();
        drawSchedulingAlgos();
        drawResetButton();
        drawRandomizeButton();
        repaint();
    }
    
    public void drawResetButton()
    {
        buttonReset.setBounds(590, 40, 90, 30);
        handleEvent handler = new handleEvent();
        buttonReset.addActionListener(handler);
        add(buttonReset);
    }
    
    public void drawRandomizeButton()
    {
        buttonRandom.setBounds(475, 40, 90, 30);
        handleEvent handler = new handleEvent();
        buttonRandom.addActionListener(handler);
        add(buttonRandom);
        
    }
    
    public void drawComboBox()
    {
        comboLabel.setBounds(15, 15, 180, 20);
        processCombo.setBounds(50, 40, 80, 30);
        add(processCombo);
        add(comboLabel);
        handleEvent handler = new handleEvent();
        processCombo.addActionListener(handler);
    }
    
    public void setNumOfProcess(int numOfProcesses)
    {
        this.numOfProcesses = numOfProcesses;
        //System.out.println("In setNumOfProcess " + this.numOfProcesses);
    }
    
    public int getNumOfProcess()
    {
        //System.out.println("In getNumOfProcesses " + numOfProcesses);
        return numOfProcesses;
    }

    public void drawExecuteButton() 
    {
       buttonExecute.setBounds(705, 40, 90, 30);
       handleEvent handler = new handleEvent();
       buttonExecute.addActionListener(handler);
       add(buttonExecute);
    }

    public void drawSchedulingAlgos() 
    {
        scheduleLabel.setBounds(240, 15, 210, 20);
        algoCombo.setBounds(270, 40, 100, 30);
        handleEvent handler = new handleEvent();
        algoCombo.addActionListener(handler);
        add(algoCombo);
        add(scheduleLabel);
    }
    
    public void setAlgoSelected(String algoSelected)
    {
        this.algoSelected = algoSelected;
    }
    
    public String getAlgoSelected()
    {
        return algoSelected;
    }
 
    public void drawTextAndLabels(int numOfProcesses)
    {
        label1.setBounds(10, 90, 80, 20);
        label2.setBounds(10, 130, 80, 20);
        label3.setBounds(10, 170, 80, 20);
        label4.setBounds(10, 210, 80, 20);
        label5.setBounds(10, 250, 80, 20);
        label6.setBounds(10, 290, 80, 20);
        label7.setBounds(10, 330, 80, 20);
        label8.setBounds(10, 370, 80, 20);
        label9.setBounds(10, 410, 80, 20);
        label10.setBounds(10, 450, 80, 20);
        label11.setBounds(10, 490, 80, 20);
        
        
        text1.setBounds(90, 90, 40, 20);
        text2.setBounds(90, 130, 40, 20);
        text3.setBounds(90, 170, 40, 20);
        text4.setBounds(90, 210, 40, 20);
        text5.setBounds(90, 250, 40, 20);
        text6.setBounds(90, 290, 40, 20);
        text7.setBounds(90, 330, 40, 20);
        text8.setBounds(90, 370, 40, 20);
        text9.setBounds(90, 410, 40, 20);
        text10.setBounds(90, 450, 40, 20);
        text11.setBounds(90, 490, 40, 20);
        
        add(text1);
        add(text2);
        add(text3);
        add(text4);
        add(text5);
        add(text6);
        add(text7);
        add(text8);
        add(text9);
        add(text10);
        add(text11);
        
        add(label1);
        add(label2);
        add(label3);
        add(label4);
        add(label5);
        add(label6);
        add(label7);
        add(label8);
        add(label9);
        add(label10);
        add(label11);
        
        if(numOfProcesses == 1)
        {
            text1.setVisible(true);
            text2.setVisible(false);
            text3.setVisible(false);
            text4.setVisible(false);
            text5.setVisible(false);
            text6.setVisible(false);
            text7.setVisible(false);
            text8.setVisible(false);
            text9.setVisible(false);
            text10.setVisible(false);
            text11.setVisible(false);
            
            label1.setVisible(true);
            label2.setVisible(false);
            label3.setVisible(false);
            label4.setVisible(false);
            label5.setVisible(false);
            label6.setVisible(false);
            label7.setVisible(false);
            label8.setVisible(false);
            label9.setVisible(false);
            label10.setVisible(false);
            label11.setVisible(false);
            
            repaint();
        }
        else if(numOfProcesses == 2)
        {
            text1.setVisible(true);
            text2.setVisible(true);
            text3.setVisible(false);
            text4.setVisible(false);
            text5.setVisible(false);
            text6.setVisible(false);
            text7.setVisible(false);
            text8.setVisible(false);
            text9.setVisible(false);
            text10.setVisible(false);
            text11.setVisible(false);
            
            
            label1.setVisible(true);
            label2.setVisible(true);
            label3.setVisible(false);
            label4.setVisible(false);
            label5.setVisible(false);
            label6.setVisible(false);
            label7.setVisible(false);
            label8.setVisible(false);
            label9.setVisible(false);
            label10.setVisible(false);
            label11.setVisible(false);
            
            repaint();
        }
        else if(numOfProcesses == 3)
        {
            text1.setVisible(true);
            text2.setVisible(true);
            text3.setVisible(true);
            text4.setVisible(false);
            text5.setVisible(false);
            text6.setVisible(false);
            text7.setVisible(false);
            text8.setVisible(false);
            text9.setVisible(false);
            text10.setVisible(false);
            text11.setVisible(false);
            
            label1.setVisible(true);
            label2.setVisible(true);
            label3.setVisible(true);
            label4.setVisible(false);
            label5.setVisible(false);
            label6.setVisible(false);
            label7.setVisible(false);
            label8.setVisible(false);
            label9.setVisible(false);
            label10.setVisible(false);
            label11.setVisible(false);
            
            repaint();
        }
        else if(numOfProcesses == 4)
        {
            text1.setVisible(true);
            text2.setVisible(true);
            text3.setVisible(true);
            text4.setVisible(true);
            text5.setVisible(false);
            text6.setVisible(false);
            text7.setVisible(false);
            text8.setVisible(false);
            text9.setVisible(false);
            text10.setVisible(false);
            text11.setVisible(false);
            
            label1.setVisible(true);
            label2.setVisible(true);
            label3.setVisible(true);
            label4.setVisible(true);
            label5.setVisible(false);
            label6.setVisible(false);
            label7.setVisible(false);
            label8.setVisible(false);
            label9.setVisible(false);
            label10.setVisible(false);
            label11.setVisible(false);
            
            
            repaint();
        }
        else if(numOfProcesses == 5)
        {
            text1.setVisible(true);
            text2.setVisible(true);
            text3.setVisible(true);
            text4.setVisible(true);
            text5.setVisible(true);
            text6.setVisible(false);
            text7.setVisible(false);
            text8.setVisible(false);
            text9.setVisible(false);
            text10.setVisible(false);
            text11.setVisible(false);
            
            label1.setVisible(true);
            label2.setVisible(true);
            label3.setVisible(true);
            label4.setVisible(true);
            label5.setVisible(true);
            label6.setVisible(false);
            label7.setVisible(false);
            label8.setVisible(false);
            label9.setVisible(false);
            label10.setVisible(false);
            label11.setVisible(false);
            
            repaint();
        }
        else if(numOfProcesses == 6)
        {
            text1.setVisible(true);
            text2.setVisible(true);
            text3.setVisible(true);
            text4.setVisible(true);
            text5.setVisible(true);
            text6.setVisible(true);
            text7.setVisible(false);
            text8.setVisible(false);
            text9.setVisible(false);
            text10.setVisible(false);
            text11.setVisible(false);
            
            label1.setVisible(true);
            label2.setVisible(true);
            label3.setVisible(true);
            label4.setVisible(true);
            label5.setVisible(true);
            label6.setVisible(true);
            label7.setVisible(false);
            label8.setVisible(false);
            label9.setVisible(false);
            label10.setVisible(false);
            label11.setVisible(false);
            
            repaint();
        }
        else if(numOfProcesses == 7)
        {
            text1.setVisible(true);
            text2.setVisible(true);
            text3.setVisible(true);
            text4.setVisible(true);
            text5.setVisible(true);
            text6.setVisible(true);
            text7.setVisible(true);
            text8.setVisible(false);
            text9.setVisible(false);
            text10.setVisible(false);
            text11.setVisible(false);
            
            label1.setVisible(true);
            label2.setVisible(true);
            label3.setVisible(true);
            label4.setVisible(true);
            label5.setVisible(true);
            label6.setVisible(true);
            label7.setVisible(true);
            label8.setVisible(false);
            label9.setVisible(false);
            label10.setVisible(false);
            label11.setVisible(false);
            
            repaint();
        }
        else if(numOfProcesses == 8)
        {
            text1.setVisible(true);
            text2.setVisible(true);
            text3.setVisible(true);
            text4.setVisible(true);
            text5.setVisible(true);
            text6.setVisible(true);
            text7.setVisible(true);
            text8.setVisible(true);
            text9.setVisible(false);
            text10.setVisible(false);
            text11.setVisible(false);
            
            label1.setVisible(true);
            label2.setVisible(true);
            label3.setVisible(true);
            label4.setVisible(true);
            label5.setVisible(true);
            label6.setVisible(true);
            label7.setVisible(true);
            label8.setVisible(true);
            label9.setVisible(false);
            label10.setVisible(false);
            label11.setVisible(false);
            
            repaint();
        }
        else if(numOfProcesses == 9)
        {
            text1.setVisible(true);
            text2.setVisible(true);
            text3.setVisible(true);
            text4.setVisible(true);
            text5.setVisible(true);
            text6.setVisible(true);
            text7.setVisible(true);
            text8.setVisible(true);
            text9.setVisible(true);
            text10.setVisible(false);
            text11.setVisible(false);
            
            label1.setVisible(true);
            label2.setVisible(true);
            label3.setVisible(true);
            label4.setVisible(true);
            label5.setVisible(true);
            label6.setVisible(true);
            label7.setVisible(true);
            label8.setVisible(true);
            label9.setVisible(true);
            label10.setVisible(false);
            label11.setVisible(false);
            
            repaint();
        }
        else if(numOfProcesses == 10)
        {
            text1.setVisible(true);
            text2.setVisible(true);
            text3.setVisible(true);
            text4.setVisible(true);
            text5.setVisible(true);
            text6.setVisible(true);
            text7.setVisible(true);
            text8.setVisible(true);
            text9.setVisible(true);
            text10.setVisible(true);
            text11.setVisible(false);
            
            label1.setVisible(true);
            label2.setVisible(true);
            label3.setVisible(true);
            label4.setVisible(true);
            label5.setVisible(true);
            label6.setVisible(true);
            label7.setVisible(true);
            label8.setVisible(true);
            label9.setVisible(true);
            label10.setVisible(true);
            label11.setVisible(false);
            
            repaint();
        }
        else if(numOfProcesses == 11)
        {
            text1.setVisible(true);
            text2.setVisible(true);
            text3.setVisible(true);
            text4.setVisible(true);
            text5.setVisible(true);
            text6.setVisible(true);
            text7.setVisible(true);
            text8.setVisible(true);
            text9.setVisible(true);
            text10.setVisible(true);
            text11.setVisible(true);
            
            label1.setVisible(true);
            label2.setVisible(true);
            label3.setVisible(true);
            label4.setVisible(true);
            label5.setVisible(true);
            label6.setVisible(true);
            label7.setVisible(true);
            label8.setVisible(true);
            label9.setVisible(true);
            label10.setVisible(true);
            label11.setVisible(true);
            
            repaint();
        }
        
    }
    
    public void setText1(int burstTime)
    {
        text1.setText(Integer.toString(burstTime));
        repaint();
    }
    
    public int getText1()
    {
        int x = Integer.parseInt(text1.getText());
        return x;
    }
    
    public void setText2(int burstTime)
    {
        text2.setText(Integer.toString(burstTime));
        repaint();
    }
    
    public int getText2()
    {
        int x = Integer.parseInt(text2.getText());
        return x;
    }
    
    public void setText3(int burstTime)
    {
        text3.setText(Integer.toString(burstTime));
        repaint();
    }
    
    public int getText3()
    {
        int x = Integer.parseInt(text3.getText());
        return x;
    }
    
    public void setText4(int burstTime)
    {
        text4.setText(Integer.toString(burstTime));
        repaint();
    }
    
    public int getText4()
    {
        int x = Integer.parseInt(text4.getText());
        return x;
    }
    
    public void setText5(int burstTime)
    {
        text5.setText(Integer.toString(burstTime));
        repaint();
    }
    
    public int getText5()
    {
        int x = Integer.parseInt(text5.getText());
        return x;
    }
    
    public void setText6(int burstTime)
    {
        text6.setText(Integer.toString(burstTime));
        repaint();
    }
    
    public int getText6()
    {
        int x = Integer.parseInt(text6.getText());
        return x;
    }
    
    public void setText7(int burstTime)
    {
        text7.setText(Integer.toString(burstTime));
        repaint();
    }
    
    public int getText7()
    {
        int x = Integer.parseInt(text7.getText());
        return x;
    }
    
    public void setText8(int burstTime)
    {
        text8.setText(Integer.toString(burstTime));
        repaint();
    }
    
    public int getText8()
    {
        int x = Integer.parseInt(text8.getText());
        return x;
    }
    
    public void setText9(int burstTime)
    {
        text9.setText(Integer.toString(burstTime));
        repaint();
    }
    
    public int getText9()
    {
        int x = Integer.parseInt(text9.getText());
        return x;
    }
    
    public void setText10(int burstTime)
    {
        text10.setText(Integer.toString(burstTime));
        repaint();
    }
    
    public int getText10()
    {
        int x = Integer.parseInt(text10.getText());
        return x;
    }
    
    public void setText11(int burstTime)
    {
        text11.setText(Integer.toString(burstTime));
        repaint();
    }
    
    public int getText11()
    {
        int x = Integer.parseInt(text11.getText());
        return x;
    }
    
    public void randomizerButton()
    {
        int numOfProcesses = getNumOfProcess();
          
        setText1((int) (Math.random() * 25) + 1);
        setText2((int) (Math.random() * 25) + 1);
        setText3((int) (Math.random() * 25) + 1);
        setText4((int) (Math.random() * 25) + 1);
        setText5((int) (Math.random() * 25) + 1);
        setText6((int) (Math.random() * 25) + 1);
        setText7((int) (Math.random() * 25) + 1);
        setText8((int) (Math.random() * 25) + 1);
        setText9((int) (Math.random() * 25) + 1);
        setText10((int) (Math.random() * 25) + 1);
        setText11((int) (Math.random() * 25) + 1);
    }

    private class handleEvent implements ActionListener
    {

        public handleEvent()
        {
            
        }

        @Override
        public void actionPerformed(ActionEvent e) 
        {
            Integer[] burstValues;
            if(e.getSource() == processCombo)
            {
                numOfProcesses =  (Integer) processCombo.getSelectedItem();
                setNumOfProcess(numOfProcesses);
                drawTextAndLabels(numOfProcesses);
            }
            
            else if(e.getSource() == buttonExecute)
            {
                int pro1 = 0;
                int pro2 = 0;
                int pro3 = 0;
                int pro4 = 0;
                int pro5 = 0;
                int pro6 = 0;
                int pro7 = 0;
                int pro8 = 0;
                int pro9 = 0;
                int pro10 = 0;
                int pro11 = 0;
                
               int numberProcess = getNumOfProcess();
               String algo = getAlgoSelected();
               
               //Add object for new data and calculating class here
               
               if(numberProcess == 1)
               {
                pro1 = getText1();
                //burstValues = new Integer[] {pro1};
                mapBurst.put(1, pro1);
                                      
                obj1 = new Calculate(algo, numberProcess, mapBurst);
                   
               }
               else if(numberProcess == 2)
               {
                   pro1 = getText1();
                   pro2 = getText2();
                   //burstValues = new Integer[] {pro1, pro2};
                   
                   mapBurst.put(1, pro1);
                   mapBurst.put(2, pro2);
                                      
                obj1 = new Calculate(algo, numberProcess, mapBurst);
                
               }
               
               else if(numberProcess == 3)
               {
                   pro1 = getText1();
                   pro2 = getText2();
                   pro3 = getText3();
                   //burstValues = new Integer[] {pro1, pro2, pro3};
                   
                   mapBurst.put(1, pro1);
                   mapBurst.put(2, pro2);
                   mapBurst.put(3, pro3);
                   obj1 = new Calculate(algo, numberProcess, mapBurst);
                   
               }
               
               else if(numberProcess == 4)
               {
                   pro1 = getText1();
                   pro2 = getText2();
                   pro3 = getText3();
                   pro4 = getText4();
                   //burstValues = new Integer[] {pro1, pro2, pro3, pro4};
                   
                   mapBurst.put(1, pro1);
                   mapBurst.put(2, pro2);
                   mapBurst.put(3, pro3);
                   mapBurst.put(4, pro4);
                   obj1 = new Calculate(algo, numberProcess, mapBurst);
               }
               
               else if(numberProcess == 5)
               {
                   pro1 = getText1();
                   pro2 = getText2();
                   pro3 = getText3();
                   pro4 = getText4();
                   pro5 = getText5();
                   //burstValues = new Integer[] {pro1, pro2, pro3, pro4, pro5};
                   
                   mapBurst.put(1, pro1);
                   mapBurst.put(2, pro2);
                   mapBurst.put(3, pro3);
                   mapBurst.put(4, pro4);
                   mapBurst.put(5, pro5);
                   obj1 = new Calculate(algo, numberProcess, mapBurst);
               }
               else if(numberProcess == 6)
               {
                   pro1 = getText1();
                   pro2 = getText2();
                   pro3 = getText3();
                   pro4 = getText4();
                   pro5 = getText5();
                   pro6 = getText6();
                   //burstValues = new Integer[] {pro1, pro2, pro3, pro4, pro5};
                   
                   mapBurst.put(1, pro1);
                   mapBurst.put(2, pro2);
                   mapBurst.put(3, pro3);
                   mapBurst.put(4, pro4);
                   mapBurst.put(5, pro5);
                   mapBurst.put(6, pro6);
                   obj1 = new Calculate(algo, numberProcess, mapBurst);
               }
               else if(numberProcess == 7)
               {
                   pro1 = getText1();
                   pro2 = getText2();
                   pro3 = getText3();
                   pro4 = getText4();
                   pro5 = getText5();
                   pro6 = getText6();
                   pro7 = getText7();
                   //burstValues = new Integer[] {pro1, pro2, pro3, pro4, pro5};
                   
                   mapBurst.put(1, pro1);
                   mapBurst.put(2, pro2);
                   mapBurst.put(3, pro3);
                   mapBurst.put(4, pro4);
                   mapBurst.put(5, pro5);
                   mapBurst.put(6, pro6);
                   mapBurst.put(7, pro7);
                   obj1 = new Calculate(algo, numberProcess, mapBurst);
               }
               else if(numberProcess == 8)
               {
                   pro1 = getText1();
                   pro2 = getText2();
                   pro3 = getText3();
                   pro4 = getText4();
                   pro5 = getText5();
                   pro6 = getText6();
                   pro7 = getText7();
                   pro8 = getText8();
                   //burstValues = new Integer[] {pro1, pro2, pro3, pro4, pro5};
                   
                   mapBurst.put(1, pro1);
                   mapBurst.put(2, pro2);
                   mapBurst.put(3, pro3);
                   mapBurst.put(4, pro4);
                   mapBurst.put(5, pro5);
                   mapBurst.put(6, pro6);
                   mapBurst.put(7, pro7);
                   mapBurst.put(8, pro8);
                   obj1 = new Calculate(algo, numberProcess, mapBurst);
               }
               else if(numberProcess == 9)
               {
                   pro1 = getText1();
                   pro2 = getText2();
                   pro3 = getText3();
                   pro4 = getText4();
                   pro5 = getText5();
                   pro6 = getText6();
                   pro7 = getText7();
                   pro8 = getText8();
                   pro9 = getText9();
                   //burstValues = new Integer[] {pro1, pro2, pro3, pro4, pro5};
                   
                   mapBurst.put(1, pro1);
                   mapBurst.put(2, pro2);
                   mapBurst.put(3, pro3);
                   mapBurst.put(4, pro4);
                   mapBurst.put(5, pro5);
                   mapBurst.put(6, pro6);
                   mapBurst.put(7, pro7);
                   mapBurst.put(8, pro8);
                   mapBurst.put(9, pro9);
                   obj1 = new Calculate(algo, numberProcess, mapBurst);
               }
               else if(numberProcess == 10)
               {
                   pro1 = getText1();
                   pro2 = getText2();
                   pro3 = getText3();
                   pro4 = getText4();
                   pro5 = getText5();
                   pro6 = getText6();
                   pro7 = getText7();
                   pro8 = getText8();
                   pro9 = getText9();
                   pro10 = getText10();
                   //burstValues = new Integer[] {pro1, pro2, pro3, pro4, pro5};
                   
                   mapBurst.put(1, pro1);
                   mapBurst.put(2, pro2);
                   mapBurst.put(3, pro3);
                   mapBurst.put(4, pro4);
                   mapBurst.put(5, pro5);
                   mapBurst.put(6, pro6);
                   mapBurst.put(7, pro7);
                   mapBurst.put(8, pro8);
                   mapBurst.put(9, pro9);
                   mapBurst.put(10, pro10);
                   obj1 = new Calculate(algo, numberProcess, mapBurst);
               }
               else if(numberProcess == 11)
               {
                   pro1 = getText1();
                   pro2 = getText2();
                   pro3 = getText3();
                   pro4 = getText4();
                   pro5 = getText5();
                   pro6 = getText6();
                   pro7 = getText7();
                   pro8 = getText8();
                   pro9 = getText9();
                   pro10 = getText10();
                   pro11 = getText11();
                   //burstValues = new Integer[] {pro1, pro2, pro3, pro4, pro5};
                   
                   mapBurst.put(1, pro1);
                   mapBurst.put(2, pro2);
                   mapBurst.put(3, pro3);
                   mapBurst.put(4, pro4);
                   mapBurst.put(5, pro5);
                   mapBurst.put(6, pro6);
                   mapBurst.put(7, pro7);
                   mapBurst.put(8, pro8);
                   mapBurst.put(9, pro9);
                   mapBurst.put(10, pro10);
                   mapBurst.put(11, pro11);
                   obj1 = new Calculate(algo, numberProcess, mapBurst);
               }  
            }
            else if(e.getSource() == algoCombo)
            {
                String algoSelected =  (String) algoCombo.getSelectedItem();
                setAlgoSelected(algoSelected);
            }
            else if(e.getSource() == buttonReset)
            {
            text1.setVisible(false);
            text2.setVisible(false);
            text3.setVisible(false);
            text4.setVisible(false);
            text5.setVisible(false);
            text6.setVisible(false);
            text7.setVisible(false);
            text8.setVisible(false);
            text9.setVisible(false);
            text10.setVisible(false);
            text11.setVisible(false);
            
            label1.setVisible(false);
            label2.setVisible(false);
            label3.setVisible(false);
            label4.setVisible(false);
            label5.setVisible(false);
            label6.setVisible(false);
            label7.setVisible(false);
            label8.setVisible(false);
            label9.setVisible(false);
            label10.setVisible(false);
            label11.setVisible(false);
            
            repaint();
            
            text1.setText("0");
            text2.setText("0");
            text3.setText("0");
            text4.setText("0");
            text5.setText("0");
            text6.setText("0");
            text7.setText("0");
            text8.setText("0");
            text9.setText("0");
            text10.setText("0");
            text11.setText("0");
            }
            else if(e.getSource() == buttonRandom)
            {
                randomizerButton();
            }
        }    
    }
}
