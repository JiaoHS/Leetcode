//package offer.baidu;
//
//import java.util.Arrays;
//
///**
// * @program: spring
// * @description:
// * @author: seven
// * @create: 2019/04/02 19:42
// **/
//public class CalScoreTest {
//    public static void main(String[] args) {
//        CalScoreTest calScoreTest = new CalScoreTest();
//        int min = calScoreTest.min(3, 4, 1, new int[]{6, 4, 1});
//        System.out.println(min);
//    }
//
//    public int min(int num, int projCmptDec, int restDec, int[] errorScore) {
//        int count = 0;
//        Arrays.sort(errorScore);
//        int lastIndex = errorScore.length-1;
//        while (errorScore[lastIndex] > 0) {
//            count++;
//            errorScore[lastIndex] = (errorScore[lastIndex] - projCmptDec) < 0? 0: (errorScore[lastIndex] - projCmptDec);
//            for (int j = 0; j < lastIndex; j++) {
//                if (errorScore[j] > 0) {
//                    errorScore[j] = (errorScore[j] - restDec) < 0? 0: (errorScore[j] - restDec);
//                }
//            }
//            Arrays.sort(errorScore);
//        }
//
//        return count;
//    }
//}
