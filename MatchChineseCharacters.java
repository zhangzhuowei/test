package 自定义项目.equb字体转换;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
/**
 * @use 匹配HTML的<a>标签中的中文字符
 * @ProjectName stuff
 * @Author <a href="mailto:mhmyqn@qq.com">mumaoqiang</a></br>
 * @Date 2012-7-24 下午04:59:27 </br>
 * @FullName com.mmq.regex.MatchChineseCharacters.java </br>
 * @JDK 1.6.0 </br>
 * @Version 1.0 </br>
 */
public class MatchChineseCharacters {
	/**
	 * 根据输入的内容，匹配出包含中文但不包含comment的<a>标签中的中文字符
	 * @param source 要匹配的内容
	 * @return <a>标签中的中文字符
	 */
	public static String matchChineseCharacters(String source) {
		//匹配出包含中文但不包含comment的<a>标签
		String reg = "<a((?!comment).)*?>([^<>]*?[\\u4e00-\\u9fa5]+[^<>]*?)+(?=</a>)";
		Pattern pattern = Pattern.compile(reg);
		Matcher matcher = pattern.matcher(source);
		StringBuilder character = new StringBuilder();
		while(matcher.find()){
			String result = matcher.group();
			System.out.println(result);
			//对结果进行二次正则，匹配出中文字符
			String reg1 = "[\\u4e00-\\u9fa5]+";//[\u4e00-\u9fa5]
			Pattern p1 = Pattern.compile(reg1);
			Matcher m1 = p1.matcher(result);
			while(m1.find()){
				character.append(m1.group());
				System.out.println(character.append(m1.group()));
			}
			//System.out.println(character.toString());
		}
		return character.toString();
	}
	
	@SuppressWarnings("static-access")
	public static String test(String str) {
		String reg = "[\\u4e00-\\u9fa5]";
		Pattern pattern = Pattern.compile(reg);
		Matcher matcher = pattern.matcher(str);
		StringBuilder character = new StringBuilder();
		ChangeCode ch=new ChangeCode();
		while(matcher.find()){
			character.append(matcher.quoteReplacement(ch.Change(matcher.group(), false)));
			//System.out.println(character.append(matcher.group()));
		}
		return character.toString();
	}
	
	public static String test1(String str) {
		String reg = "[\\u4e00-\\u9fa5]";
		Pattern pattern = Pattern.compile(reg);
		Matcher matcher = pattern.matcher(str);
		ChangeCode ch=new ChangeCode();
		while(matcher.find()){
			matcher.quoteReplacement(ch.Change(matcher.group(), false));
			//System.out.println(character.append(matcher.group()));
		}
		return str;
	}
	
	public static void main(String[] args) throws IOException {
//		String result = matchChineseCharacters("<a href='www.baidu.comds=id32434#comment'rewr>特432</a>453543<a guhll,,l>a1特123你好123吗？</a><a href=id=32434#comment'ewrer>特2聯系</a><a>标签中的文字</a>");
//		System.out.println(result);
		
//		String str="特2聯系";
//		System.out.println(test(str));
		File fin = new File("D:\\娱乐\\12\\镰池和马 - 創約·魔法禁書目錄4\\OEBPS\\Text\\Section0003.xhtml");
        FileReader finReader = new FileReader(fin);   //基于“字符”的输入操作
        BufferedReader bin_2 = new BufferedReader(finReader);
        
        String ss;
        String str="";
        while( (ss = bin_2.readLine()) != null ){
            //System.out.println(ss);   //输出到命令行窗口
            str+=ss;
        }
        bin_2.close();      //依次关闭，注意关闭顺序
        finReader.close();
        //System.out.println(str);
        //String str="<h2>序&nbsp;<br /></h2><p>&nbsp; &nbsp; 「到底是怎麽了，媽的……」&nbsp;</p>";
        System.out.println(test1(str));
	}
	
}
