package com.xjtu.ssmidea.algorithm;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

/**
 * @program: spring
 * @description:
 * @author: seven
 * @create: 2019/03/20 20:26
 **/
public class StateTest {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        HashMap<String, String> map = new HashMap<>();
        ArrayList<String> res = new ArrayList<>();
        String[] s = sc.nextLine().split(" ");
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < s.length; i++) {
            String[] strings = s[i].split("|");
            if (!map.containsKey(strings[1]) && !"start".equals(strings[2])){
                continue;
            }
            if (!map.containsKey(strings[1])) {
                if ("start".equals(strings[2])) {
                    map.put(strings[1], "start");
                    sb.append(strings[1] + "|" + "submitted;");
                }
            }else {
                String state = strings[2];

                switch (state) {
                    case "app_accepted":
                        if ("submitted".equals(map.get(strings[1])) && "ResourceScheduler".equals(strings[0])){
                            sb.append(strings[1] + "|" + "scheduled;");
                        }
                        break;
                    case "container_allocated":
                        if ("scheduled".equals(map.get(strings[1])) && "RmContainer".equals(strings[0])){
                            sb.append(strings[1] + "|" + "allocated;");
                        }
                        break;
                    case "launched":
                        if ("scheduled".equals(map.get(strings[1])) && "ApplicationMasterLauncher".equals(strings[0])){
                            sb.append(strings[1] + "|" + "running;");
                        }
                        break;
                    case "finished":
                        if ("running".equals(map.get(strings[1])) && "ResourceScheduler".equals(strings[0])){
                            sb.append(strings[1] + "|" + "finished;");
                        }
                        break;
                    case "kill":
                        if (map.get(strings[1]) != "finished" && "ResourceScheduler".equals(strings[0])){
                            sb.append(strings[1] + "|" + "killed;");
                        }
                        break;
                    default:
                        break;
                }
            }
        }
        System.out.println(sb.toString());

    }
}
