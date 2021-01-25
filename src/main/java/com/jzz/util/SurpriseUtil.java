package com.jzz.util;

import java.util.ArrayList;

/**
 * @author:jzz
 * @date:2021/1/19
 */
public class SurpriseUtil {

    private static final Integer PRIZE_01 = 3000;
    private static final Integer PRIZE_02 = 10000;

    public static int isSurprise (Integer pSize) {
        Integer size = 0;
        //找到当前人数的下一次抽奖的人数
        Integer a = pSize / PRIZE_01 + (pSize%PRIZE_01==0?1:1);
        Integer b = pSize / PRIZE_02 + (pSize%PRIZE_02==0?1:1);
        //获取差值，哪个小用那个
        Integer count = a * PRIZE_01 - pSize;
        Integer count1 = b * PRIZE_02 - pSize;
        size = count > count1 ? count1 < 0 ? count : count1 : count < 0 ? count1 : count;
        return size;
    }
}
