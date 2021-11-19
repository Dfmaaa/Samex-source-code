import java.io.File;
public class Uninstall {
 public static void method(){
	File main=new File("Samex.class");
	File code=new File("SamexRun.class");
	File soundex=new File("soundex\\words.txt");
	File error=new File("sounds\\error.wav");
	File success=new File("sounds\\success.wav");
	File shutdown=new File("sounds/shutdown.wav");
	File soundexl=new File("soundex\\words.txt");
	File errorl=new File("sounds/error.wav");
	File successl=new File("sounds/success.wav");
	File shutdownl=new File("sounds/shutdown.wav");
	File htmlhelp=new File("man/Samex help page.html");
	File pythonhelp=new File("man/Samex Interactive Help.py");
	File htmlwin=new File("man\\Samex help page.html");
	File pywin=new File("man\\Samex Interactive help.py");
	File update=new File("Updates.class");
	File val=new File("validityOfSamex.txt");
	File pass=new File("Samex_Password.txt");
	main.delete();
	code.delete();
	htmlwin.delete();
	pywin.delete();
	soundex.delete();
	soundexl.delete();
	errorl.delete();
	successl.delete();
	shutdownl.delete();
	error.delete();
	success.delete();
	shutdown.delete();
	htmlhelp.delete();
	pythonhelp.delete();
	update.delete();
	val.delete();
	pass.delete();
	File uninst=new File("Uninstall.class");
	uninst.delete();
	File soundir=new File("soundex");
	soundir.delete();
	File sdir=new File("sounds");
	sdir.delete();
  }
	public static void main(String[] args){
	 method();	
	}
 }

