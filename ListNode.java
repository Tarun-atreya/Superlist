public class ListNode<E> {
    public E val;
    public ListNode<E> next;
    public ListNode<E> prev;
    public ListNode (E v)
    {
        val = v;
        prev = next = null;
    }
    public E getVal()
    {
        return val;
    }
    public ListNode<E> getNext()
    {
        return next;
    }
    public ListNode<E> getPrev()
    {
        return prev;
    }
    public void setVal(E v)
    {
        val = v;
    }
    public void setNext(ListNode<E> n)
    {
        next = n;
    }
    public void setPrev(ListNode<E> p)
    {
        prev = p;
    }

    public boolean hasNext()
    {
        return next != null;
    }
    public boolean hasPrev()
    {
        return prev != null;
    }

}