package edu.nuaa.wwn.ad.index;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: WeinanWu
 * Date: 2020-08-30
 * Time: 12:13
 */
public interface IndexAware<K, V> {

    V get(K key);

    void add(K key, V value);

    void update(K key, V value);

    void delete(K key, V value);
}
