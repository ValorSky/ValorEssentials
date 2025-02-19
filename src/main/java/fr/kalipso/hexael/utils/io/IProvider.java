package fr.kalipso.hexael.utils.io;

import java.io.IOException;

public interface IProvider<K, V> {

    void provide(K key, V value);

    void remove(K key) throws IOException;

    V get(K key);

}