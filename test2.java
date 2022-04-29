package 自定义项目.equb字体转换;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class test2 {
	public static void main(String[] args) {
	        // 创建一个正则表达式模式，用以匹配一个单词（\b=单词边界）
	        String patt = "\\b[\\u4e00-\\u9fa5]\\b";

	        // 用于测试的输入字符串
	        String input = "<h2>序&nbsp;<br /></h2><p>&nbsp; &nbsp; 「到底是怎麽了，媽的……」&nbsp;</p>";
	        //System.out.println("Input:" + input);

	        // 从正则表达式实例中运行方法并查看其如何运行
	        Pattern r = Pattern.compile(patt);
	        Matcher m = r.matcher(input);
	        Matcher newm=r.matcher(input);
	        StringBuffer character = new StringBuffer();
			ChangeCode ch=new ChangeCode();
			while(m.find()){
//				//character.append(m.quoteReplacement(ch.Change(m.group(), false)));
//				//System.out.println(character.append(matcher.group()));
//				//m.quoteReplacement(ch.Change(m.group(), false));
				m.appendReplacement(character, ch.Change(m.group(), false));
//				System.out.println("ReplaceAll:" + m.quoteReplacement("b"));
			}
			System.out.println("m:"+m.hashCode()+"\nnewm:"+newm.hashCode());
			System.out.println(character.toString());
	        // appendReplacement方法
//	        m.reset();
//	        StringBuffer sb = new StringBuffer();
//	        while (m.find()) {
//	            // 将匹配之前的字符串复制到sb,再将匹配结果替换为："favour"，并追加到sb
//	            m.appendReplacement(sb, "favour");
//	        }
//	        //System.out.println(sb.toString());
//	        m.appendTail(sb);
	        //System.out.println(sb.toString());
	    }
}
