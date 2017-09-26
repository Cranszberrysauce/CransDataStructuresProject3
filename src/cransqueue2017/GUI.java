package cransqueue2017;

import java.awt.Component;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

/******************************************************
***  GUI
***  Nick Crans
******************************************************
*** This is the class that creates the components for
*** the gui and adds all the funtionality to the window
******************************************************
*** 09/24/2017: Class created
*** 09/24/2017: Created components 
*** 09/24/2017: Created method that adds components to frame
*** 09/24/2017: Created event listener
******************************************************/
public class GUI  extends JFrame implements ActionListener
{
    private final GridBagLayout layout;
    private final GridBagConstraints constraints;
    private final JTextArea display;
    private final JButton add;
    private final JButton remove;
    private final JButton displayQueue;
    private final JTextField input;
    private final JScrollPane scroll;
    private final LinkListQueue list;
    
    /******************************************************
    ‘***  GUI
    ‘***  Nick Crans
    ‘******************************************************
    ‘*** Constructor
    ‘*** Initializes all the components for the window
    ‘******************************************************
    ‘*** 09/24/2017
    ‘******************************************************/
    public GUI()
    {
       super("Linked Queue");
       list = new LinkListQueue();
       layout = new GridBagLayout();
       setLayout(layout);
       constraints = new GridBagConstraints();
       
       /***************************************************************
       Help for this code was found on 
       http://docs.oracle.com/javase/tutorial/uiswing/components/scrollpane.html
       */
       display = new JTextArea("Display", 10, 20);
       display.setEditable(false);
       scroll = new JScrollPane(display);
       /**********************************************************/
       add = new JButton("Add");
       remove = new JButton("Remove");
       displayQueue = new JButton("Display");
       input = new JTextField("Enter Integer");
       add.addActionListener(this);
       remove.addActionListener(this);
       displayQueue.addActionListener(this);
       /****************************************************************
       /* Help with code was found on https://www.youtube.com/watch?v=CajXXmhIndI
       Wanted to find a way to clear the text in the text box, because
       constantly having to delete the text first was getting annoying.Luckily
       I found one.
       */
       input.addMouseListener(new MouseAdapter()
       {
           @Override
           public void mousePressed(MouseEvent event)
           {
               input.setText("");
           }
       });
       /****************************************************************/
       constraints.weightx = 1;
       constraints.weighty = 1;
       constraints.fill = GridBagConstraints.BOTH;
       constraints.gridwidth = GridBagConstraints.REMAINDER;
       addComponents(scroll);

       constraints.gridwidth = 1;
       addComponents(add);
       
       constraints.gridwidth = GridBagConstraints.REMAINDER;
       addComponents(input);
       
       constraints.gridwidth = GridBagConstraints.REMAINDER;
       addComponents(remove);
       
       constraints.gridwidth = GridBagConstraints.REMAINDER;
       addComponents(displayQueue);
    }
    
    /******************************************************
    ‘***  addComponents
    ‘***  Nick Crans
    ‘******************************************************
    ‘*** Adds the components to the window. Takes the component
    ‘*** to be added as an parameter
    ‘******************************************************
    ‘*** 09/24/2017
    ‘******************************************************/
    private void addComponents(Component com)
    {
        layout.setConstraints(com, constraints);
        add(com);
    } 
    
    /******************************************************
    ‘***  actionPerformed
    ‘***  Nick Crans
    ‘******************************************************
    ‘*** Adds functionality to the text area and buttons.
    ‘******************************************************
    ‘*** 09/24/2017
    ‘******************************************************/
    @Override
    public void actionPerformed(ActionEvent event)
    {
        if(event.getSource() == add)
        {
            String aNum;
           
            try
            {
                aNum = input.getText();
                if(aNum.isEmpty())
                {
                    EmptyInputException emptyInput = new EmptyInputException(""
                            + "No Integer was entered: Please enter a Integer.");
                    throw emptyInput;
                }
                else
                {
                    Integer.parseInt(aNum);
                    list.add(Integer.parseInt(aNum));
                    input.setText("Enter Integer");
                    display.append("\n" + aNum + " added to queue.");
                }
            }
            catch(NumberFormatException badInput)
            {
                display.append("\nNonInteger entered: Please enter Integer.");
                input.setText("Enter Integer");
            }
            catch(EmptyInputException emptyInput)
            {
                display.append("\n" + emptyInput.getMessage());
                input.setText("Enter Integer");
            }
        }
        else if(event.getSource() == remove)
        {
            try
            {
                display.append("\n" + list.remove()+ " removed from queue.");
            }
            catch(EmptyQueueException empty)
            {
                display.append("\n" + empty.getMessage());
            }
        }
        else if(event.getSource() == displayQueue)
        {
           try
           {
               if(list.empty())
               {
                   EmptyQueueException empty = new EmptyQueueException("Queue"
                           + " empty: No integers to display.");
                   throw empty;
               }
               else
               {
                   display.append("\nValues in queue: " + list.toString());
               }
           }
           catch(EmptyQueueException empty)
           {
               display.append("\n" + empty.getMessage());
           }
        }
    }  
}
