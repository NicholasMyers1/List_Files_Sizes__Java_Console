package lab2;
import java.io.File;
import java.util.Scanner;
public class lab2{
	public static Scanner scanInput=new Scanner(System.in);
	public static File dir=null;
	public static void main(String[] args){
	      System.out.println("Enter an existing filepath: ");
	      	String file=scanInput.next();
	      	dir=new File(file);
	      	long size=folderNameAndSize(dir);
	      System.out.println("Total folder size: "+size+" bytes.");
	}
	public static long folderNameAndSize(File directory){
		long length=0;
		for(File file:directory.listFiles()){
			String filename=file.getAbsolutePath();
			if(file.isFile()){
				length+=file.length();
				System.out.println("Filename: "+filename+" \tSize: "+file.length()+" bytes");
			}
			else{
				length+=folderNameAndSize(file);
				System.out.println("FileName: "+filename+" \tSize: "+folderNameAndSize(file)+" bytes");
			}
		}
		return length;
	}
}