import java.io.File;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Scanner;
import java.io.FileWriter;
import java.util.HashMap;
public class PackageInstaller extends SamexRun{
    static String spacestr(String[] a){
        String s = "";
        for(int i = 0; i < a.length; i++){
            s += a[i] + " ";
        }
        return s;
    }
    static String[] rmspacestr(String s){
        return s.split(" ");
    }
    public static String os=System.getProperty("os.name");
    public static void man(URL a,String name) throws Exception{
        if(System.getProperty("os.name").equals("Linux")){
          downloadFile(a,"man/" + name);
        }
        else if(System.getProperty("os.name").equals("Windows")){
            downloadFile(a,"man\\" + name);
        }
    }
    static void genlist() throws MalformedURLException, IOException, Exception{
        URL get=new URL("https://samexmain.github.io/available_packages.txt");
        System.out.println("Getting list of available packages...");
        downloadFile(get,"packlst.txt");
        System.out.println("Reading list...");
        try (FileReader fileStream = new FileReader(new File("packlst.txt"));
        BufferedReader bufferedReader = new BufferedReader(fileStream)) {
       String line = null;
       while ((line = bufferedReader.readLine())!= null) {
           System.out.println(line);
       }
   }
        File f=new File("packlst.txt");
        f.delete();
    }
    static String[] genstrlist() throws MalformedURLException, IOException, Exception{
     URL get=new URL("https://samexmain.github.io/available_packages.txt");
     downloadFile(get,"packlst.txt");
     String[] a=new String[getfilelinenum(new File("packlst.txt"))];
     int counter=0;
     try (FileReader fileStream = new FileReader(new File("packlst.txt"));
        BufferedReader bufferedReader = new BufferedReader(fileStream)) {
       String line = null;
       while ((line = bufferedReader.readLine())!= null) {
           a[counter]=line;
           counter++;
       }
   }
   new File("packlst.txt").delete();
   return a;
    }
    static String soundex_pack(String word) throws IOException, InterruptedException, Exception{
		String result="";
       int file_length=genstrlist().length;
       int[] values=new int[file_length];
       String[] words=genstrlist();
       HashMap<String,Integer> hash=new HashMap<String,Integer>();
       for(int x=0;x<file_length;x++){
           values[x]=points(word,words[x]);
           hash.put(words[x],points(word,words[x]));
       }
       int max=maxval(values);
       result=getkey(max,hash);
	   return result;
}
    public static void install(String id) throws MalformedURLException, Exception{
      System.out.println("Installing...");
      downloadFile(new URL("https://samexmain.github.io/" + id + ".class" ), id+".class");
      FileWriter inwr=new FileWriter(new File("inst_packages.txt"));
      String s=read("inst_packages.txt");
        inwr.write(s + id + " ");
        inwr.close();
      System.out.print(id + " successfully installed");
    }
    public static void uninstall(String id) throws IOException{
        File unst=new File(id+ ".class");
        if(unst.exists()==false){
            System.out.println("You do not have this package.");
        }
        else{
        System.out.println("Uninstalling " + id + "...");
        unst.delete();
        if(unst.exists()){
            System.out.println("Uninstallation unsuccessful.");
        }
        else if(unst.exists()==false){
            FileWriter unwr=new FileWriter(new File("inst_packages.txt"));
            String un=read("inst_packages.txt");
            String[] una=rmelement(filetostrarray(new File("inst_packages.txt")),id);
            unwr.write(spacestr(una));
            unwr.close();
            System.out.println("Uninstallation successful.");
        }
    }
    }
        static String str(String[] a){
         String ret="";
         for(int x=0;x<a.length;x++){
             ret+=a[x];
         }
         return ret;
        }
        static String[] filetostrarray(File a) throws IOException{
            String[] ret=new String[(int)getlines(a)];
            try (FileReader fileStream = new FileReader(a);
                 BufferedReader bufferedReader = new BufferedReader(fileStream)) {
                String line = null;
                int x=0;
                while ((line = bufferedReader.readLine())!= null) {
                    ret[x]=line;
                    x++;
                }
            }
            return ret;
        }
        static String[] rmelement(String[] a, String id){
            String[] ret=new String[a.length-1];
            int x=0;
            for(int y=0;y<a.length;y++){
                if(a[y].equals(id)==false){
                    ret[x]=a[y];
                    x++;
                }
            }
            return ret;
        }
        public static void method() throws MalformedURLException, IOException, Exception{
           if(new File("inst_packages.txt").exists()==false){
                File f=new File("inst_packages.txt");
                f.createNewFile();
           }
           else{
           Scanner input=new Scanner(System.in);
           while(true){
            System.out.print("PackageInstaller$ ");
            String comm=input.nextLine();
            boolean inst=comm.split(" ")[0].equals("install");
            boolean uninst=comm.split(" ")[0].equals("uninstall");
            boolean sea=comm.split(" ")[0].equals("search");
            if(comm.equals("help")){
             System.out.println(" ");
             System.out.println("Type \"list\" to get a list of all the available packages.");
             System.out.println("Type \"install [package id]\" to install packages.");
             System.out.println("Type \"uninstall [package id]\" to uninstall packages.");
             System.out.println("Tyoe \"search [id]\" to search for a package.");
             System.out.println("Type \"exit\" to stop this application.");
            }
           else if(comm.equals("list")){
            System.out.println(" ");
            genlist();
            }
            else if(inst){
                System.out.println(" ");
                install(comm.split(" ")[1]);
            }
            else if(uninst){
                System.out.println(" ");
                uninstall(comm.split(" ")[1]);
            }
            else if(sea){
                System.out.println(soundex_pack(comm.split(" ")[1]));
            }
            else if(comm.equals("exit")){
                break;
            }
            else{
                System.out.println(" ");
                System.out.println("Invalid command. Type \"help\" to see all the commands,");
            }
     }
 }
}
 public static void main(String[] args) throws MalformedURLException, IOException, Exception{
     method();
 }
}