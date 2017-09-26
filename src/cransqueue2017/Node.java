package cransqueue2017;

/******************************************************
***  Node
***  Nick Crans
******************************************************
*** This class creates a node in the list. It allows
*** for setting and getting a integer value. It also
*** allows for setting and getting a pointer to the
*** next and previous node in the list.
******************************************************
*** 09/21/2017: Class created.
*** 09/21/2017: Created variables to store values, and
*** reference to the next and previous node.
*** 09/21/2017: Set and get methods written
*** 09/21/2017: Added sets and gets for pointer to 
*** previous Node.
******************************************************/
public class Node 
{
    private int value;
    private Node nextLink;
    private Node prevLink;
    
    /******************************************************
    ‘***  Node()
    ‘***  Nick Crans
    ‘******************************************************
    ‘*** Constructor
    ‘*** This is the default constructor. Sets the value to
    ‘*** 0 and the pointer to the next node to null. Meaning
    ‘*** The default node is the head and tail of the list.
    ‘******************************************************
    ‘*** 09/21/2017
    ‘******************************************************/
    public Node()
    {
        value = 0;
        nextLink = null;
        prevLink = null;
    }
    
    /******************************************************
    ‘***  Node()
    ‘***  Nick Crans
    ‘******************************************************
    ‘*** Constructor
    ‘*** When a new node object is created, it takes the value
    ‘*** to be stored and the reference to the next node.
    ‘******************************************************
    ‘*** 09/21/2017
    ‘******************************************************/
    public Node(int value, Node nextLink, Node prevLink)
    {
        this.value = value;
        this.nextLink = nextLink;
        this.prevLink = prevLink;
    }
    
    /******************************************************
    ‘***  getNextLink()
    ‘***  Nick Crans
    ‘******************************************************
    ‘*** Returns the address of the next node in the link.
    ‘******************************************************
    ‘*** 09/21/2017
    ‘******************************************************/
    public Node getNextLink()
    {
        return nextLink;
    }
    
    /******************************************************
    ‘***  getPrevLink()
    ‘***  Nick Crans
    ‘******************************************************
    ‘*** Returns the address of the previous node in the link.
    ‘******************************************************
    ‘*** 09/21/2017
    ‘******************************************************/
    public Node getPrevLink()
    {
        return prevLink;
    }
    
    /******************************************************
    ‘***  getValue()
    ‘***  Nick Crans
    ‘******************************************************
    ‘*** Returns the value in the Node object
    ‘******************************************************
    ‘*** 09/21/2017
    ‘******************************************************/
    public int getValue()
    {
        return value;
    }
    
    /******************************************************
    ‘***  setNextLink()
    ‘***  Nick Crans
    ‘******************************************************
    ‘*** Assigns a reference of the next object in the list 
    ‘******************************************************
    ‘*** 09/21/2017
    ‘******************************************************/
    public void setNextLink(Node nextLink)
    {
        this.nextLink = nextLink;
    }
    
    /******************************************************
    ‘***  setPrevLink()
    ‘***  Nick Crans
    ‘******************************************************
    ‘*** Assigns a reference to the previous object in the
    ‘*** list
    ‘******************************************************
    ‘*** 09/21/2017
    ‘******************************************************/
    public void setPrevLink(Node prevLink)
    {
        this.prevLink = prevLink;
    }
    
    /******************************************************
    ‘***  setValue()
    ‘***  Nick Crans
    ‘******************************************************
    ‘*** Sets the value in the node.
    ‘******************************************************
    ‘*** 09/21/2017
    ‘******************************************************/
    public void setValue(int value)
    {
        this.value = value;
    }
}
