package cransqueue2017;
/******************************************************
***  Node
***  Nick Crans
******************************************************
*** This class allows a user to queue and dequeue 
*** numbers from the queue implemented by a link list.
******************************************************
*** 09/21/2017: Class created.
*** 09/21/2017: Created and finished method to add
*** integers to list
*** 09/21/2017: Created and finished empty method
*** 09/21/2017: Created remove and recRemove methods
*** 09/21/2017: Created and finished toString and recToString
*** 09/23/2017: Finished the recRmove method
******************************************************/
public class LinkListQueue 
{
    private Node list;
    private int size;
    
    /******************************************************
    ‘***  LinkListQueue
    ‘***  Nick Crans
    ‘******************************************************
    ‘*** Constructor. Initializes the list to null and the
    ‘*** size to 0
    ‘******************************************************
    ‘*** 09/21/2017
    ‘******************************************************/
    public LinkListQueue()
    {
        list = null;
        size = 0;
    }
    
    /******************************************************
    ‘***  add()
    ‘***  Nick Crans
    ‘******************************************************
    ‘*** Adds a number to the list. If list is null then
    ‘*** the newly created node is assigned to the list.
    ‘*** If the list is not null then the new node is 
    ‘*** added to the list.
    ‘******************************************************
    ‘*** 09/21/2017
    ‘******************************************************/
    public void add(int aNum)
    {
        Node newNode = new Node(aNum, null, null);
        
        if(list == null)
            list = newNode;
        else
        {
            list.setPrevLink(newNode);
            newNode.setNextLink(list);
            list = newNode;
        }
        
        size++;
    }
    
    /******************************************************
    ‘***  empty()
    ‘***  Nick Crans
    ‘******************************************************
    ‘*** Tests if the queue, or list, is empty. Returns 0
    ‘*** if the list is empty.
    ‘******************************************************
    ‘*** 09/21/2017
    ‘******************************************************/
    public boolean empty()
    {
        boolean isEmpty = false;
        
        if(size == 0)
            isEmpty = true;
        
        return isEmpty;
    }
    
    /******************************************************
    ‘***  remove()
    ‘***  Nick Crans
    ‘******************************************************
    ‘*** This method is called to get to the recursive 
    ‘*** method to remove elements from the queue. It
    ‘*** throws an EmptyQueue exception if the queue
    ‘*** is empty and the method is called.
    ‘******************************************************
    ‘*** 09/21/2017
    ‘******************************************************/
    public int remove() throws EmptyQueueException
    {
        if(empty())
        {
            EmptyQueueException message = new EmptyQueueException("Queue empty:"
                    + " Cannot dequeue.");
            throw message;
        }

        return recRemove(list);
    }
    
    /******************************************************
    ‘***  recRemove()
    ‘***  Nick Crans
    ‘******************************************************
    ‘*** If the previous link and next link are null, then
    ‘*** it just returns the value in the current node and
    ‘*** assigned the node to null. Otherwise the list is
    ‘*** assigned the link to the previous node. Then the
    ‘*** next link is assigned null to cut the first value
    ‘*** added to the queue off the list.
    ‘******************************************************
    ‘*** 09/21/2017
    ‘******************************************************/
    private int recRemove(Node aLink)
    {
        if(aLink.getNextLink() == null)
        {
            Node temp = aLink;
            if(aLink.getPrevLink() == null && aLink.getNextLink() == null)
            {
                list = null;
                size--;
                return temp.getValue();
            }
            else
            {
                aLink = aLink.getPrevLink();
                aLink.setNextLink(null);
                list = aLink;    
                size--;
            }
            
            return temp.getValue(); 
        }
 
        return recRemove(aLink.getNextLink());
    }
    
    /******************************************************
    ‘***  toString
    ‘***  Nick Crans
    ‘******************************************************
    ‘*** Allows access to the method that concatenates the 
    ‘*** string that is printed in the gui.
    ‘******************************************************
    ‘*** 09/21/2017
    ‘******************************************************/
    @Override
    public String toString()
    {
        String values = "[";
        
        return recToString(values, list);
    }
    
    /******************************************************
    ‘***  recToString
    ‘***  Nick Crans
    ‘******************************************************
    ‘*** Concatenates a string with the values that were
    ‘*** added first is displayed last and returns the 
    ‘*** string to be displayed. 
    ‘******************************************************
    ‘*** 09/21/2017
    ‘******************************************************/
    private String recToString(String queueNums, Node aLink)
    {
        if(aLink.getNextLink() == null)
        {
            queueNums += aLink.getValue() + "]";
            
            return queueNums;
        }
        
        queueNums += aLink.getValue() + ", ";
        
        return recToString(queueNums, aLink.getNextLink()); 
    }
}
