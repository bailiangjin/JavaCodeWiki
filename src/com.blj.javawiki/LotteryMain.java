package com.blj.javawiki;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

/**
 * Lottery
 *
 * @author bailiangjin
 * @date 2018/10/18
 */
public class LotteryMain {

    public static void main(String[] args) {

        List<SuperLotto> codeList = generateCode();

        for (SuperLotto superLotto : codeList) {
            System.out.println(superLotto.toString());
        }
    }


    public static List<SuperLotto> generateCode() {
        List<SuperLotto> list = new ArrayList<>();


        List<Integer> frontCodeList = new ArrayList<>();
        for (int i = 1; i <= 35; i++) {
            frontCodeList.add(i);
        }

        List<Integer> backCodeList = new ArrayList<>();
        for (int i = 1; i <= 12; i++) {
            backCodeList.add(i);
        }
        for (int i = 0; i < 6; i++) {

            SuperLotto superLotto = SuperLotto.getSuperLotto(frontCodeList, backCodeList);
            list.add(superLotto);
        }

        List<Integer> backCodeList2 = new ArrayList<>();
        for (int i = 1; i <= 12; i++) {
            backCodeList2.add(i);
        }
        list.add(SuperLotto.getSuperLotto(frontCodeList, backCodeList2));
        return list;
    }


    /**
     * daletou
     */
    static class SuperLotto {
        private Integer[] frontCodeArray;
        private Integer[] backCodeArray;

        public static final int FRONT_CODE_LENGTH = 5;
        public static final int BACK_CODE_LENGTH = 2;


        public SuperLotto(Integer[] frontCodeArray, Integer[] backCodeArray) {
            Arrays.sort(frontCodeArray);
            Arrays.sort(backCodeArray);
            this.frontCodeArray = frontCodeArray;
            ;
            this.backCodeArray = backCodeArray;
        }

        public Integer[] getFrontCodeArray() {
            return frontCodeArray;
        }

        public void setFrontCodeArray(Integer[] frontCodeArray) {
            this.frontCodeArray = frontCodeArray;
        }

        public Integer[] getBackCodeArray() {
            return backCodeArray;
        }

        public void setBackCodeArray(Integer[] backCodeArray) {
            this.backCodeArray = backCodeArray;
        }

        private String formatNum(int number, int length) {
            return String.format("%0" + length + "d", number);
        }

        private static SuperLotto getSuperLotto(List<Integer> frontCodeList, List<Integer> backCodeList) {
            if (null == frontCodeList || frontCodeList.size() < FRONT_CODE_LENGTH || null == backCodeList || backCodeList.size() < BACK_CODE_LENGTH) {
                return null;
            }

            Random random = new Random();
            Integer[] frontCodeArray = new Integer[FRONT_CODE_LENGTH];
            for (int j = 0; j < 5; j++) {
                int curPosition = 1 == frontCodeList.size() ? 0 : random.nextInt(frontCodeList.size() - 1);
                int cuNumber = frontCodeList.get(curPosition);
                frontCodeArray[j] = cuNumber;
                frontCodeList.remove(curPosition);
            }

            Integer[] backCodeArray = new Integer[BACK_CODE_LENGTH];
            for (int j = 0; j < 2; j++) {
                int curPosition = 1 == backCodeList.size() ? 0 : random.nextInt(backCodeList.size() - 1);
                int cuNumber = backCodeList.get(curPosition);
                backCodeArray[j] = cuNumber;
                backCodeList.remove(curPosition);
            }

            return new SuperLotto(frontCodeArray, backCodeArray);
        }

        @Override
        public String toString() {

            StringBuilder sb = new StringBuilder();
            for (Integer num : frontCodeArray) {
                sb.append(formatNum(num, 2) + " ");

            }
            sb.append("| ");
            for (Integer num : backCodeArray) {
                sb.append(formatNum(num, 2) + " ");

            }
            return sb.toString();
        }
    }
}
