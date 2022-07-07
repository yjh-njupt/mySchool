package IO;

import org.junit.Test;

import java.io.*;
import java.util.Scanner;

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


    public static void main(String[] args) {
        File file = new File("D:\\cache\\ffmpeg\\ts\\3.txt");
        /*Scanner sc = new Scanner(System.in);
        StringBuilder sbf = new StringBuilder();
        if (sc.hasNext()) {
            sbf.append(sc.next());
        }
        System.out.println(sbf.toString());*/
        //ffmpeg -f concat -safe 0  -i 3.txt -c copy 2.mp4
        String s = "file 'D:\\cache\\ffmpeg\\ts\\cache\\CLS-1-v1-a1.ts'";
        //String s = "https://vod7eu59.128100.xyz/hls/NTlHBnb1mcH/CLS-1-v1-a1.ts?ip=47.75.127.102&exp=1654086923&hash=340f15821027952f5818ab66edc67269";
        try {
            FileWriter fileWriter = new FileWriter(file);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            for (int i = 1; i <= 572; i++) {
                bufferedWriter.write(s.replace("CLS-1","CLS-"+i) + "\r\n");
                bufferedWriter.flush();
            }

            bufferedWriter.close();
            fileWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}
