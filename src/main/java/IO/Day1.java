package IO;

import org.junit.Test;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Day1 {
    /**
     * 文件有点大 log.log 3MB
     * 目标容器小 4096bit
     * 导致信息丢失。
     *
     * 目前尚不明确，read对超过容器容量的部分数据是如何处置的。
     */
    @Test
    public void demo(){
        try {
            char[] cbuf = new char[1024*1024*4];
            FileReader fio = new FileReader("D:\\cache\\idea\\mySchool\\src\\resource\\log.log");
            FileWriter fou = new FileWriter("D:\\cache\\idea\\mySchool\\src\\resource\\log1.log");
            System.out.println(fio.getEncoding());
            int  i ;

            while (-1!= (i = fio.read(cbuf))) {
            }
            fou.write(cbuf);
            fou.flush();
            fou.close();


            /**
             * 顺势大致计算一下 所有第一个“-”到 第二个 “-”之间的数字和是多少*/


            fio.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}
