import java.util.LinkedHashMap;
import java.util.Map;

public class T53 {
    // 定义缓存容量，final 确保容量不可变
    private final int capacity;
    // 使用 LinkedHashMap 作为缓存存储
    // LinkedHashMap 维护插入顺序或访问顺序，这里使用默认的插入顺序
    private final Map<Integer, Integer> cache = new LinkedHashMap<>(); // 内置 LRU

    // 构造函数，初始化缓存容量
    public LRUCache(int capacity) {
        this.capacity = capacity;
    }

    public int get(int key) {
        // 删除 key，并利用返回值判断 key 是否在 cache 中
        // remove() 方法会返回被删除键对应的值，如果键不存在则返回 null
        Integer value = cache.remove(key);
        if (value != null){ // key 在 cache 中
            // 重新插入该键值对，由于 LinkedHashMap 维护插入顺序，
            // 重新插入会使该键变为"最近使用"（在链表末尾）
            cache.put(key, value);
            return value;
        }
        // key 不在 cache 中
        return -1;
    }

    public void put(int key, int value) {
        // 删除 key，并利用返回值判断 key 是否在 cache 中
        if (cache.remove(key) != null){ // key 在 cache 中
            // 如果键已存在，先删除再重新插入，使其变为"最近使用"
            cache.put(key, value);
            return;
        }
        // key 不在 cache 中，那么就把 key 插入 cache，插入前判断 cache 是否满了
        if (cache.size() == capacity){// cache 满了
            // 获取最久未使用的键（LinkedHashMap 的第一个元素）
            // iterator().next() 返回第一个元素，即最久未使用的
            Integer eldestKey = cache.keySet().iterator().next();
            cache.remove(eldestKey);// 删除最久未使用的键
        }// 插入新的键值对
        cache.put(key, value);
    }
}
