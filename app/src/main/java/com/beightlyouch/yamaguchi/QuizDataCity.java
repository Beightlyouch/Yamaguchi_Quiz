package com.beightlyouch.yamaguchi;

public class QuizDataCity {
    private static final String poolcity[] []= new String[][]{{"abu", "bofu", "hagi", "hikari", "hiranama", "iwakuni", "kaminoseki", "mine", "nagato", "sanyoonoda",
            "shimonoseki", "sitamatsu", "suooshima", "syunan", "tabuse", "ube", "wagi", "yamaguchi", "yanai"},

            {"阿武町", "防府市", "萩市", "光市", "平生町", "岩国市", "上関町", "美弥市", "長門市", "山陽小野田市", "下関市",
                    "下松市", "周防大島町", "周南市", "田布施町", "宇部市", "和木町", "山口市", "柳井市"}};

    public static String[][] getPoolcity(){
        return QuizDataCity.poolcity;
    }

    public static int getCityNum(){
        return poolcity.length;
    }
}
