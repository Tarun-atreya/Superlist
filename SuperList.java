public class SuperList<E> {
    private ListNode root, end; 
    private int size;

    public SuperList()
    {
        root = end = null;
        size = 0;
    }

    public void add(E val)
    {
        ListNode<E> newNode = new ListNode<E>(val);
        size++;
        if(size == 1)
        {
            root = end = newNode;
            return;  
        }else{
            newNode.setPrev(end);
            end.setNext(newNode);
            end = newNode;
        }
    }
    public void add(int index, E val)
    {
        if(index > size)
        {
            throw new IndexOutOfBoundsException();
        }
        if(index == size)
        {
            add(val);
            return;
        }
        if(index == 0)
        {
            ListNode<E> newNode = new ListNode<E>(val);
            newNode.setNext(root);
            root.setPrev(newNode);
            root = newNode;
            size++;
            return;
        }
        ListNode<E> curr = root;
        for(int i = 0; i < index; i++)
        {
            curr = curr.getNext();
        }
        ListNode<E> newNode = new ListNode<E>(val);
        newNode.setNext(curr);
        newNode.setPrev(curr.getPrev());
        curr.getPrev().setNext(newNode);
        curr.setPrev(newNode);
        size++;
    }

    public ListNode<E> remove(int index)
    {
        if(index >= size)
        {
            throw new IndexOutOfBoundsException();
        }
        if(index == 0)
        {
            ListNode<E> temp = root;
            root = root.getNext();
            root.setPrev(null);
            size--;
            return temp;
        }
        if(index == size - 1)
        {
            ListNode<E> temp = end;
            end = end.getPrev();
            end.setNext(null);
            size--;
            return temp;
        }
        ListNode<E> curr = root;
        for(int i = 0; i < index; i++)
        {
            curr = curr.getNext();
        }
        curr.getPrev().setNext(curr.getNext());
        curr.getNext().setPrev(curr.getPrev());
        size--;
        return curr;
    }

    public boolean isEmpty()
    {
        return size == 0;
    }

    public void clear()
    {
       root = end = null;
       size = 0;
    }

    public boolean contains(E val)
    {
        ListNode curr = root;
        for(int i =0; i< size; i++)
        {
            if(curr.getVal() == val)
            {
                return true;
            }
        }
        return false; 
    }
    public int size()
    {
        return size;
    }

    public String toString()
    {
        String s = "[";
        ListNode<E> curr = root;
        while(curr != null)
        {
            s += curr.getVal() + ", ";
            curr = curr.getNext();
        }
        try{ s = s.substring(0, s.length() - 2);}catch(Exception e){}
        s += "]";
        return s;
    }

    public static void main(String[] args)
    {
        SuperList<Integer> list = new SuperList<Integer>();
        // Test Basic Add
        int expectedSize = 0;
        for (int i = 0; i < 10; i++){
            list.add((int)(Math.random()*20));
            expectedSize++;
        }
        System.out.println("Size as expected = "+( list.size() == expectedSize));

        // Test add at Start or End
        list.add(0,(int)(Math.random()*20));
        expectedSize++;
        list.add(list.size(),(int)(Math.random()*20));
        expectedSize++;
        System.out.println("Add at ends --> Size as expected = "+( list.size() == expectedSize));

        // Test Add at Random positions
        for (int i = 0; i < 10; i++){
            list.add(  (int)(Math.random()*list.size()) , (int)(Math.random()*20));
            expectedSize++;
        }
        System.out.println("Add at random positions --> Size as expected = "+( list.size() == expectedSize));
    }
}
