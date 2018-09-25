class Node
{
    Object key = null;
    Object val = null;
    Node next = null;
}

class Hashemelemt
{
    Object hashkey = null;
    Node data = null;
}


public class Hashtable
{
    int len = 0;
    int count = 0;
    Hashemelemt[] hash = new Hashemelemt[0];
    public Hashemelemt[] inithash(int l)
    {
        int i;
        len = l;
        hash = new Hashemelemt[len];

        count = 0;
        for(i=0;i<len;i++)
        {
            hash[i] = new Hashemelemt();
        }
        return hash;
    }

    public int inserthash(Object key, Object ob)  //insert an element with key and val=ob
    {
        int hashaddress = key.hashCode();
        int index = 0;
        if(this.searchhash(key)== -1)
        {
            index = count;
            count += 1;
        }
        else
        {
            index = this.searchhash(key);
        }

        hash[index].hashkey = hashaddress;
        Node d = hash[index].data;

        Node node = new Node();
        node.key = key;
        node.val = ob;
        node.next = d;
        hash[index].data = node;
        return 1;

    }

    public int searchhash(Object key) // search the element with key
    {
        int search_count;
        Node content = new Node();
        Object hashkey = key.hashCode();
        //for(search_count=0;search_count<=this.len;search_count++)
        for (Hashemelemt ele: hash) {

        }
        {
            if(this.hash[search_count].hashkey == hashkey)
            {
                content = this.hash[search_count].data;
                break;
            }
            else
            {
                return -1;
            }
        }
        while(content != null)
        {
            if(content.key == key)
            {
                return search_count;
            }
            else
            {
                content = content.next;
            }
        }
        return -1;
    }

    public int deletehash(Object key, Object val)  // delete the element with key and val
    {
        int hashaddress = key.hashCode();
        int del_index = 0;
        Node pre = new Node();
        Node cur = new Node();
        if(this.searchhash(key)== -1)
        {
            System.out.println("Cannot find this object in hashtable ! \n");
            return -1;
        }
        else
        {
            del_index = this.searchhash(key);

        }
        pre = cur = this.hash[del_index].data;
        while (cur != null)
        {
            if(cur.key == key && cur.val==val)
                {pre.next = cur.next;
                cur.next = null;
                return 1;}
            else
                {pre = cur;
                cur = cur.next;}
        }
        return -1;
    }

    public static void main (String[] args){
        Hashtable h = new Hashtable();
        h.inithash(5);
        h.inserthash("1","sss");
        System.out.println(h.hash[0].data.val);
        System.out.println(h.searchhash("1"));
}
}