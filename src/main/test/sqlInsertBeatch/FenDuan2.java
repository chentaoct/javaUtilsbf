package sqlInsertBeatch;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 陈涛 on 2017/7/5.
 */
public class FenDuan2 {
    /**
     * @param args
     */
    public static void main(String[] args) {

        //1.总记录数
        List<String> oldList = new ArrayList<String>();
        for (int i = 0; i < 401; i++) {
            oldList.add((i)+"");
        }

        //2.分页数据信息
        int totalSize = oldList.size(); //总记录数
        int pageSize = 400; //每页N条
        int totalPage = totalSize/pageSize; //共N页

        if (totalSize % pageSize != 0) {
            totalPage += 1;
            if (totalSize < pageSize) {
                pageSize = oldList.size();
            }
        }
        System.out.println("循环保存的次数："+totalPage);//循环多少次

        for (int pageNum = 1; pageNum < totalPage+1; pageNum++) {
            int starNum = (pageNum-1)*pageSize;
            int endNum = pageNum*pageSize>totalSize?(totalSize):pageNum*pageSize;
            System.out.println("起始："+starNum+"-"+endNum);

            ArrayList<String> strings = new ArrayList<String>();
            String str = "";
            for (int i = starNum; i < endNum; i++) {
                str += oldList.get(i) +"   ";
                strings.add(oldList.get(i));
            }

            System.out.println("第"+pageNum+"批：" +str+"strings:"+strings.size());
        }


    }
}
