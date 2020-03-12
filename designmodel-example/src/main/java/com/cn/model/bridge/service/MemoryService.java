package com.cn.model.bridge.service;


/**
 *  买手机流程：市场有很多手机品牌，比如华为、苹果，
 *  并且不同手机对应的网络信号可能是不同的，如4G、5G
 *  假设我们现在需要购买不同品牌的手机并且内存也是不一样的
 *  那么就会有2*2=4种情况，如果种类更多的话那么实现起来就会更复杂。
 *  因此我们采用了桥接模式：把2个不同维度的东西桥接起来
 *  本例中手机品牌和内存网络型号就是不同维度。
 */
//网络信号接口
public interface MemoryService {
    void showMemory();
}