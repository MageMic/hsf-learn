package com.zju.ad.utils;

import java.util.Map;
import java.util.function.Supplier;

/**
 * @author magemic
 * @date 2020/6/1
 */
public class CommonUtils {

    public static <K, V> V getOrCreate(K key, Map<K, V> map, Supplier<V> factory) {
        return map.computeIfAbsent(key, k -> factory.get());
    }
}
