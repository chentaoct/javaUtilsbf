package choujiang.two;

import java.util.*;

/**
 * Created by 陈涛 on 2017/6/2.
 */
public class LottyTest {


    public static void main(String[] args) {
        ruanTime();
    }

    // 抽奖算法
    public static void getlottery(List<String> uList) {
        // 生成随机数
        Random random = new Random();
        // 模拟抽奖，预设10万次，抽中即停
        for (int i = 0; i < 100; i++) {
            System.out.println("第" + i + "次抽奖");
            // 抽取0到9999中任意一个整数随机数；
            int randNum = random.nextInt(9999);
            // 从奖池里随机抽取一个下标
            int jackNum = (int) (Math.random() * uList.size());
            System.out.println(randNum + "==" + jackNum);
            //如果随机数和奖池里随机抽取的下标相同，进入奖池
            if (randNum == jackNum) {
                System.out.println("如果匹配：");
                //获取抽到的奖池内的选项值
                String jackName = uList.get(jackNum);
                //如果是一等奖，通知用户中奖,删除奖池内该选项,并跳出抽奖
                if (jackName == "一等奖") {
                    System.out.println("----------------------------我是可爱的分割线----------------------------");
                    System.out.println(jackName);
                    System.out.println("恭喜您获得一等奖！");
                    // 如果中奖，将奖项从奖池删除
                    uList.remove(jackNum);
                    break;
                } else if (jackName == "二等奖") {//如果是二等奖，通知用户中奖,删除奖池内该选项,并跳出抽奖
                    System.out.println("----------------------------我是可爱的分割线----------------------------");
                    System.out.println(jackName);
                    System.out.println("恭喜您获得二等奖！");
                    // 如果中奖，将奖项从奖池删除
                    uList.remove(jackNum);
                    break;
                } else if (jackName == "三等奖") {//如果是三等奖，通知用户中奖,删除奖池内该选项,并跳出抽奖
                    System.out.println("----------------------------我是可爱的分割线----------------------------");
                    System.out.println(jackName);
                    System.out.println("恭喜您获得三等奖！");
                    // 如果中奖，将奖项从奖池删除
                    uList.remove(jackNum);
                    break;
                } else if (jackName == "四等奖") {//如果是四等奖，通知用户中奖,删除奖池内该选项,并跳出抽奖
                    System.out.println("----------------------------我是可爱的分割线----------------------------");
                    System.out.println(jackName);
                    System.out.println("恭喜您获得四等奖！");
                    // 如果中奖，将奖项从奖池删除
                    uList.remove(jackNum);
                    break;
                } else if (jackName == "未中奖") {//如果是未中奖，通知用户未中奖,删除奖池内该选项,并跳出抽奖
                    System.out.println("----------------------------我是可爱的分割线----------------------------");
                    System.out.println(jackName);
                    System.out.println("很遗憾您未中奖！");
                    // 如果中奖，将奖项从奖池删除
                    uList.remove(jackNum);
                    break;
                }
            } else {
                System.out.println("----------------------------我是可爱的分割线----------------------------");
                System.out.println("如果未中奖：");
                System.out.println("很遗憾，您没中奖！");
            }

        }

        String[] bbbbbbb = uList.toArray(new String[0]);
        System.out.println("----------------------------我是可爱的分割线----------------------------");
        System.out.println("奖池情况：");
        System.out.println("++++++++++++++++++++++++++++++++:" + Arrays.toString(bbbbbbb));
        System.out.println("++++++++++++++++++++++++++++++++" + bbbbbbb.length);
        System.out.println("++++++++++++++++++++++++++++++++");
    }

    // 拼接奖池
    public static List<String> getJackpot() {
        // 数组1，包含1个一等奖、3个二等奖、5个三等奖，共9个
        String[] lottery1 = { "一等奖", "二等奖", "二等奖", "二等奖", "三等奖", "三等奖", "三等奖", "三等奖", "三等奖" };
        // 数组2，四等奖，共50个
        String[] lottery2 = new String[50];
        // 数组3，未中奖，共9940个
        String[] lottery3 = new String[9940];
        // 给数组2，四等奖赋值
        for (int i = 0; i < 50; i++) {
            lottery2[i] = "四等奖";
        }
        // 给数组3，未中奖赋值
        for (int i = 0; i < 9940; i++) {
            lottery3[i] = "未中奖";
        }

        // 创建个list，将三个数组添加到一个list中，拼接起来
        List<String> list = new ArrayList<String>();
        // 遍历数组1，并将值添加到list
        for (String s : lottery1) {
            list.add(s);
        }
        // 遍历数组2，并将值添加到list
        for (String s : lottery2) {
            list.add(s);
        }
        // 遍历数组3，并将值添加到list
        for (String s : lottery3) {
            list.add(s);
        }
        // 给list中的值随机排序
        Collections.shuffle(list);
        // 返回一个无序的list奖池
        return list;
    }

    // 方法耗时测试
    public static void ruanTime() {
        long start = System.currentTimeMillis();
        List<String> jackpotList = getJackpot();
        for (int i = 0; i < 1; i++) {
            getJackpot();
            System.out.println("拼接奖池耗时：" + (System.currentTimeMillis() - start) + "毫秒");
        }
        for (int i = 0; i < 1; i++) {
            getlottery(jackpotList);
            System.out.println("抽奖算法耗时：" + (System.currentTimeMillis() - start) + "毫秒");
        }

    }

}
