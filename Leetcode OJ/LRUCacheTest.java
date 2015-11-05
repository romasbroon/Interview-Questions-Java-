
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Iterator;
import java.util.Map;

class CacheNode{
    int page_key;
    int address;
    CacheNode prev;
    CacheNode next;
    
    CacheNode(int key, int val){
        this.page_key = key;
        this.address=val;
        this.next = null;
        this.prev = null;
    }

    public String toString(){
        return Integer.toString(page_key);
    }
}

class LRUCache {
    int capacity;
    int count;
    
    DLL queue = new DLL();
    HashMap<Integer, CacheNode> key_to_cache_mapping = new HashMap<Integer, CacheNode>();
    private static LRUCache cache = null;

   
    public LRUCache(int capacity) {
        this.capacity = capacity;
        count=0;
    }
    
    public int get(int key) {
        CacheNode page_node = key_to_cache_mapping.get(key);
        if(page_node == null){
            //What to do here?
            return -1;
        }
        else{
            queue.remove(page_node);
            queue.addFirst(page_node);
            return page_node.address;
        }
    }
    
    public void set(int key, int value) {
       //Put in hashmap
       CacheNode page_node = key_to_cache_mapping.get(key);
       
       if(page_node != null){
           page_node.address=value;
           //Push to front of queue
           queue.remove(page_node);
           queue.addFirst(page_node);
       }
       else{
            page_node = new CacheNode(key, value);
            
            if(count==capacity){
                CacheNode current_last = queue.removeLast();
                //System.out.println(current_last);
                key_to_cache_mapping.remove(current_last.page_key);
            }
            else
                count++;
            key_to_cache_mapping.put(key, page_node);
            queue.addFirst(page_node);
       }
                
    }

    public void printCache(){
        queue.printDLL();
    }

    public void printMappings(){
        Iterator it = key_to_cache_mapping.entrySet().iterator();
        while(it.hasNext()){
            Map.Entry entry = (Map.Entry)it.next();
            System.out.println("key: "+entry.getKey()+" value: "+entry.getValue());
        }
    }
}//end of class

class LRUCacheTest{
    public static void main(String args[]){
        LRUCache cache = new LRUCache(1);
        //cache.set(1,1);
        cache.set(2,1);
        cache.set(2,2);
        
        System.out.println(cache.get(2));
        cache.set(1,1);
        cache.set(4,1);
   
        System.out.println(cache.get(2));

    }
}