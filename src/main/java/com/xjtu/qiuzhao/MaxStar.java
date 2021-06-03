package com.xjtu.qiuzhao;


public class MaxStar {
    public static void main(String[] args) {
        String[] times = {"1:12-16:hangzhou",
                "15:10-14:shanghai",
                "16:16-17:beijing"};
//        String[] activities = {"1:10-12:beijing:1",
//                "1:10-14:hangzhou:3",
//                "14:10-14:shanghai:2",
//                "15:11-12:shanghai:0.5",
//                "15:13-14:shanghai:2",
//                "16:16-17:beijing:1"};
        String[] activities = {"1:10-12:beijing:1",
                "1:10-14:hangzhou:3",
                "15:10-13:shanghai:2",
                "15:11-14:shanghai:5",
                "15:13-14:shanghai:4",
                "16:16-17:beijing:1"};

        double maxStar = getMaxStar(times, activities);
        System.out.println(maxStar);

    }

    public static double getMaxStar(String[] times, String[] activities) {
        double[][] star = new double[activities.length+1][times.length+1];
//        for (int i = 0; i < star.length; i++) {
//            star[i][0] = 0;
//        }
//        for (int i = 0; i < star[0].length; i++) {
//            star[0][i] = 0;
//        }

        for (int i = 1; i < star.length; i++) {
            String[] a_sp = activities[i-1].split(":");
            int a_day = Integer.parseInt(a_sp[0]);
            int a_s = Integer.parseInt(a_sp[1].split("-")[0]);
            int a_e = Integer.parseInt(a_sp[1].split("-")[1]);
            String a_city = a_sp[2];
            double a_star = Double.parseDouble(a_sp[3]);
            for (int j = 1; j < star[0].length; j++) {
                String[] t_sp = times[j-1].split(":");
                int t_day = Integer.parseInt(t_sp[0]);
                int t_s = Integer.parseInt(t_sp[1].split("-")[0]);
                int t_e = Integer.parseInt(t_sp[1].split("-")[1]);
                String t_city = t_sp[2];

                if (t_day == a_day && t_city.equals(a_city) && t_s <= a_s && t_e >= a_e) {
                    int index = i-1;
                    while (index > 0) {
                        String[] i_sp = activities[index-1].split(":");
                        int i_day = Integer.parseInt(i_sp[0]);
                        int i_s = Integer.parseInt(i_sp[1].split("-")[0]);
                        int i_e = Integer.parseInt(i_sp[1].split("-")[1]);
                        String i_city = a_sp[2];
                        if (i_day == a_day && i_e > a_s && i_city.equals(a_city)) {
                            index--;
                        } else {
                            break;
                        }
                    }
                    star[i][j] = Math.max(star[i-1][j-1], star[index][j]) + a_star;
                } else {
                    star[i][j] = star[i-1][j];
                }
            }
        }
        return star[star.length-1][star[0].length-1];

    }
}
