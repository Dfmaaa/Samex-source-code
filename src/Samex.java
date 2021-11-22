import java.util.Scanner;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
public class Samex extends SamexRun{
 public static void main(String[] args) throws IOException, InterruptedException, Exception{
	 boolean argsexist=false;
	 boolean normal=false;
	 try{
		 String experi=args[0]+"testing";
		 argsexist=true;
		 experi=null;
	 }
	 catch(Exception no){

	 }
	 if(argsexist==true){
	 if(args[0].equals("--reset")){
		 System.out.println("Password:");
		 String realpass=decrypt(read("Samex_Password.txt"));
		 Scanner ask=new Scanner(System.in);
		 String password=ask.nextLine();
		 if(password.equals(realpass)){
		 System.out.println("Starting process...");
		 System.out.println("NOTE: .secret files will not be deleted, or any other files created with samex will not be deleted..");
		 File reset=new File("Main_File.txt");
		 File reset1=new File("Samex_Password.txt");
		 File reset2=new File("soundexconfig.samex");
		 reset.delete();
		 reset1.delete();
		 reset2.delete();
		 System.out.println("Done!");
		 normal=true;
		 }
		 else{
			 System.out.println("Invalid password.");
			 System.exit(0);
		 }
	 }
	 if(args[0].equals("--uninstall")){
		 Uninstall un=new Uninstall();
		 un.method();
		 normal=true;
	 }
	 if(args[0].equals("--update")){
		 Updates updae=new Updates();
		 updae.updmethod();
		 normal=true;
	 }
	}
	if(normal==false){
    File ff=new File("validityOfSamex.txt");
    if(ff.exists()==false) {
		File version=new File("samex_version.txt");
	version.createNewFile();
	FileWriter ver=new FileWriter(version);
    ver.write("3.2");
	ver.close();
    	File default_file=new File("Main_File.txt");
    	default_file.createNewFile();
    	ff.createNewFile();
    	System.out.println("You can now use Samex!");
    }
    else if(ff.exists()==true){
    	SamexRun runFinal=new SamexRun();
        	   runFinal.run("Main_File.txt");
      }
    }
  }
}  