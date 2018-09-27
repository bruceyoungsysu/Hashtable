import java.util.ArrayList;
import java.util.stream.IntStream;
import java.util.LinkedList;
import java.util.function.BiConsumer;

class Node {
    Object key = null;
    Object value = null;
}

class Hashemelemt {
    Object hashkey = null;
    LinkedList<Node> ll = new LinkedList();
}

public class Hashtable {
    int len = 0;
    int count = 0;
    ArrayList<Hashemelemt> hash = new ArrayList();

    public ArrayList<Hashemelemt> inithash(int l) {
        int i = 0;
        len = l;
        this.hash = new ArrayList();
        IntStream stream = IntStream.range(0, len);
        stream.forEach(item ->
        {
            this.hash.add(new Hashemelemt());
        });
        return this.hash;
    }

    public int inserthash(Object key, Object ob)  //insert an element with key and val=ob
    {
        int hashaddress = key.hashCode();
        int index = 0;
        int hashkey = hashaddress % len;
        System.out.println(hashkey);
        LinkedList<Node> l = new LinkedList();
        Node nd = new Node();
        nd.key = key;
        nd.value = ob;
        hash.get(hashkey).ll.add(nd);
        return 1;

    }

    public void iteratehash(BiConsumer<? super Object, ? super Object> action) {
        this.hash.forEach(he -> he.ll.forEach(nd -> {
            Node node = nd;
            action.accept(node.key, node.value);
        }));
    }


    //public int searchhash(Object key) // search the element with key
    //{

    //}


    public static void main(String[] args) {
        Hashtable h = new Hashtable();
        h.inithash(5);
        h.inserthash("1", "sss");
        System.out.println(h.hash.get(4).ll.get(0).value);
        //System.out.println(h.hash.get(1).ll);
        //System.out.println(h.searchhash("1"));
        h.iteratehash( < "1", "sss" >);
        HashMap map = new HashMap()
    }
}