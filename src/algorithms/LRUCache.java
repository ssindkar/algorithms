package algorithms;

import java.util.HashMap;
import java.util.Objects;

public class LRUCache {
    private final int capacity;
    private final HashMap<Integer, CacheEntry<Integer, Integer>> cache;
    private CacheEntry lru;
    private CacheEntry mru;
    private int count;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.cache = new HashMap<>(capacity);
    }

    public int get(int key) {
        if (cache.containsKey(key)) {
            CacheEntry<Integer, Integer> result = cache.get(key);

            if (lru.equals(mru) || result.equals(mru)) {
                //only 1 entry/latest already in place; no updates needed
                return result.value;
            }
            if (lru.equals(result)) {
                CacheEntry oldMru = mru;

                lru = lru.nextLru;
                mru = result;

                mru.nextLru = null;
                lru.nextMru = null;

                mru.nextMru = oldMru;
                mru.nextMru.nextLru = mru;
            } else {
                CacheEntry oldMru = mru;
                CacheEntry oldEntry = cache.get(key);

                oldEntry.nextLru.nextMru = oldEntry.nextMru;
                oldEntry.nextMru.nextLru = oldEntry.nextLru;

                mru = result;
                mru.nextMru = oldMru;
                mru.nextLru = null;
                oldMru.nextLru = mru;
            }

            return result.value;
        }
        return -1;
    }

    public void set(int key, int value) {
        CacheEntry<Integer, Integer> entry = new CacheEntry(key, value);

        if (!cache.containsKey(key)) {
            if (count == 0) {
                lru = entry;
                mru = entry;
                count++;
            } else if (count == capacity) {
                cache.remove(lru.key);
                lru = lru.nextLru;

                if (lru != null) {
                    lru.nextMru = null;
                    CacheEntry temp = mru;
                    mru = entry;
                    entry.nextMru = temp;
                    temp.nextLru = entry;
                } else {
                    lru = entry;
                    mru = entry;
                }
            } else {
                CacheEntry temp = mru;
                mru = entry;
                entry.nextMru = temp;
                temp.nextLru = entry;
                count++;
            }
        } else {
            if (lru.equals(mru) && entry.value == mru.value) {
                //no update needed
                System.out.println();

            } else if (lru.equals(mru)) {
                lru = entry;
                mru = entry;
            } else if (entry.equals(lru)) {  //lru is being accessed
                CacheEntry oldMru = mru;

                lru = lru.nextLru;
                mru = entry;

                mru.nextLru = null;
                lru.nextMru = null;

                mru.nextMru = oldMru;
                mru.nextMru.nextLru = mru;
            } else if (entry.equals(mru)) {
                CacheEntry oldMru = mru;
                mru = entry;
                mru.nextMru = oldMru.nextMru;
                mru.nextMru.nextLru = mru;
            } else { //entry in the middle is being accessed
                CacheEntry oldMru = mru;
                CacheEntry oldEntry = cache.get(key);

                oldEntry.nextLru.nextMru = oldEntry.nextMru;
                oldEntry.nextMru.nextLru = oldEntry.nextLru;

                mru = entry;
                mru.nextMru = oldMru;
                oldMru.nextLru = mru;
                mru.nextLru = null;
            }
        }
        cache.put(key, entry);
    }

    private static class CacheEntry<K, V> {
        K key;
        V value;
        CacheEntry nextMru;
        CacheEntry nextLru;

        CacheEntry(K key, V value) {
            this.key = key;
            this.value = value;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            CacheEntry<?, ?> that = (CacheEntry<?, ?>) o;
            return Objects.equals(key, that.key);
        }

        @Override
        public int hashCode() {
            return Objects.hash(key);
        }

        public String toString() {
            return String.format("(%s=%s)", key, value);
        }

    }

    public void remove(int key) {
        if (count == 0) {
            return;
        } else {
            if (cache.containsKey(key)) {
                if (count == 1) {
                    cache.remove(lru.key);
                    lru = null;
                    mru = null;
                    count = 0;
                } else {
                    CacheEntry entry = cache.get(key);
                    cache.remove(key);
                    count--;

                    if (entry.equals(lru)) {
                        lru = lru.nextLru;
                        lru.nextMru = null;
                    } else if (entry.equals(mru)) {
                        mru = mru.nextMru;
                        mru.nextLru = null;
                    } else {
                        entry.nextLru.nextMru = entry.nextMru;
                        entry.nextMru.nextLru = entry.nextLru;
                    }
                }
            } else {
                return;
            }
        }
    }

    public String toString() {
        StringBuilder buffer = new StringBuilder().append("lru");
        CacheEntry temp = lru;
        while (temp != null) {
            buffer.append(temp);
            temp = temp.nextLru;
        }
        buffer.append("\nmru");
        temp = mru;
        while (temp != null) {
            buffer.append(temp);
            temp = temp.nextMru;
        }
        return buffer.toString();
    }

    public static void main(String[] args) {
        LRUCache cache = new LRUCache(2);
        cache.get(2);
        cache.set(2, 6);
        cache.get(1);
        cache.set(1, 5);
        cache.set(1, 2);
        cache.get(1);
        cache.get(2);

      /*  cache.set(2, 1);
        cache.get(2);
        cache.set(3, 2);
        cache.get(2);
        cache.get(3);*/


/*        System.out.println(cache);
        System.out.println("-----");

        System.out.println("adding 1");
        cache.set(1, 100);
        System.out.println(cache);
        System.out.println("-----");

        System.out.println("accessing 1");
        cache.get(1);
        System.out.println(cache);
        System.out.println("-----");

        System.out.println("setting 1");
        cache.set(1, 1000);
        System.out.println(cache);
        System.out.println("-----");

        System.out.println("setting 1");
        cache.set(1, 1000);
        System.out.println(cache);
        System.out.println("-----");

        System.out.println("adding 2");
        cache.set(2, 200);
        System.out.println(cache);
        System.out.println("-----");

        System.out.println("accessing 1");
        cache.get(1);
        System.out.println(cache);
        System.out.println("-----");

        System.out.println("adding 3");
        cache.set(3, 300);
        System.out.println(cache);
        System.out.println("-----");

        System.out.println("accessing 3");
        cache.get(3);
        System.out.println(cache);
        System.out.println("-----");

        System.out.println("updating 2");
        cache.set(2, 2000);
        System.out.println(cache);
        System.out.println("-----");

        System.out.println("adding 4");
        cache.set(4, 400);
        System.out.println(cache);
        System.out.println("-----");

        System.out.println("accessing 4");
        cache.get(4);
        System.out.println(cache);
        System.out.println("-----");

        System.out.println("adding 5");
        cache.set(5, 500);
        System.out.println(cache);
        System.out.println("-----");

        System.out.println("adding 6");
        cache.set(6, 600);
        System.out.println(cache);
        System.out.println("-----");

        System.out.println("updating 4");
        cache.set(4, 4000);
        System.out.println(cache);
        System.out.println("-----");

        System.out.println("accessing 1");
        cache.get(1);
        System.out.println(cache);
        System.out.println("-----");

        System.out.println("accessing 4");
        cache.get(4);
        System.out.println(cache);
        System.out.println("-----");

        System.out.println("accessing 6");
        cache.get(6);
        System.out.println(cache);
        System.out.println("-----");*/
    }
}
