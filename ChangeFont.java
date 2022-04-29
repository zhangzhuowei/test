package 自定义项目.equb字体转换;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class ChangeFont {
	public static void main(String[] args) {
		ChangeFont ch=new ChangeFont();
		List<File> files=new ArrayList<>();
		
		files=ch.getFiles("D:\\娱乐\\12\\镰池和马 - 創約·魔法禁書目錄4\\OEBPS\\Text", files);
		for(File file : files) {
			System.out.println(file.toString());
		}
		String str="<h2></h2>";
	}
	/**
	 * 
	 * @param realpath
	 * @param files
	 * @return
	 */
	public List<File> getFiles(String realpath, List<File> files) {
		File realFile = new File(realpath);
		if (realFile.isDirectory()) {
			File[] subfiles = realFile.listFiles();
			for (File file : subfiles) {
				if (file.isDirectory()) {
					getFiles(file.getAbsolutePath(), files);
				} else {
					files.add(file);
				}
			}
		}
		return files;
	}
}
