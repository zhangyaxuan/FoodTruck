package com.yaxuan.food;

public class HaversineCalculator {
    private static final double EARTH_RADIUS_KM = 6371.0; // 地球半径，单位为公里

    /**
     * 计算地球上两点之间的距离。
     *
     * @param lat1 第一个点的纬度
     * @param lon1 第一个点的经度
     * @param lat2 第二个点的纬度
     * @param lon2 第二个点的经度
     * @return 两点之间的距离（公里）
     */
    public static double haversineDistance(double lat1, double lon1, double lat2, double lon2) {
        // 将角度转换为弧度
        double dLat = Math.toRadians(lat2 - lat1);
        double dLon = Math.toRadians(lon2 - lon1);
        lat1 = Math.toRadians(lat1);
        lat2 = Math.toRadians(lat2);

        // 哈弗辛公式
        double a = Math.pow(Math.sin(dLat / 2), 2)
                + Math.pow(Math.sin(dLon / 2), 2)
                * Math.cos(lat1) * Math.cos(lat2);
        double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));

        return EARTH_RADIUS_KM * c; // 返回最终结果
    }
}
