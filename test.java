package 自定义项目.equb字体转换;
import java.io.*;
/**
 *
 * @author NJUPT_wly
 */
public class test {
    public static void main(String[] args) throws IOException{
        InputStreamReader isr = new InputStreamReader(System.in);   //定义标准输入流【注：这是“字节”输入流】
        BufferedReader bin_1 = new BufferedReader(isr);                   //获取缓冲输入流【注：它是一个装饰器】
        //注：将BufferedReader/BufferedWriter与文件流一起使用，可以减少 缓冲区功能匹配CPU 与 I/O的处理速度 的差异
        
        File outputFile = new File("D:\\娱乐\\12\\890.txt"); //构造File类实例【接下来就可以对该实例进行相应的操作】
        FileWriter out = new FileWriter(outputFile);    //基于“字符”的输出操作
        BufferedWriter bout = new BufferedWriter(out);  //获取缓冲输出流【注：它是一个装饰器】
        String s;
        System.out.println("-----以下是将要写入outTest文件的数据：(以单行“#”结束)-----");
        try{
            while( (s = bin_1.readLine()) != null ){
                if( "#".equals(s) )
                    break;
                //System.out.println(s);
                bout.write(s);
                bout.newLine();   //转到下一行
            }
        }catch( IOException e ){    //若输入有异常，则执行下面一条语句
            System.out.println("There is a error!");
        }
        bin_1.close();  //最先关闭缓冲输入流
        isr.close();    //在关闭标准输入流
        
        bout.flush();   //清空缓冲区
        bout.close();   //关闭缓冲输出流，释放和这个流相关的系统资源【】
        out.close();    //在关闭文件输出流
        
        System.out.println("-----以下是从outTest文件读出的数据：-----");
        File fin = new File("D:\\\\娱乐\\\\12\\\\890.txt");
        FileReader finReader = new FileReader(fin);   //基于“字符”的输入操作
        BufferedReader bin_2 = new BufferedReader(finReader);
        
        String ss;
        while( (ss = bin_2.readLine()) != null ){
            System.out.println(ss);   //输出到命令行窗口
        }
        bin_2.close();      //依次关闭，注意关闭顺序
        finReader.close();
    }
}

