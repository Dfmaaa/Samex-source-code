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
import java.util.concurrent.ThreadPoolExecutor.AbortPolicy;
import java.io.FileWriter;
import java.util.HashMap;
import java.util.Arrays;
public class PackageInstaller extends SamexRun{
    public static String os=System.getProperty("os.name");
    static void genlist() throws MalformedURLException, IOException, Exception{
        try{
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
catch(Exception e){
    System.out.println("Package not found");
}
    }
    static String[] genstrlist() throws MalformedURLException, IOException, Exception{
    try{
     URL get=new URL("https://samexmain.github.io/available_packages.txt");
     downloadFile(get,"packlst.txt");
    }
    catch(Exception e){
        System.out.println("Error");
    }
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
    static String soundex_pack(String word, String[] a) throws IOException, InterruptedException, Exception{
        int file_length=a.length;
       int[] values=new int[file_length];
       String[] words=a;
       HashMap<String,Integer> hash=new HashMap<String,Integer>();
       for(int x=0;x<file_length;x++){
           values[x]=points(word,words[x]);
           hash.put(words[x],points(word,words[x]));
       }
       return getkey(maxval(values),hash);
}
    static int[] reverse(int[] a){
        int[] b=new int[a.length];
        for(int x=0;x<a.length;x++){
            b[x]=a[a.length-x-1];
        }
        return b;
    }
    public static void install(String id) throws MalformedURLException, Exception{
      System.out.println("Installing...");
      try{
      downloadFile(new URL("https://samexmain.github.io/" + id + ".class" ), id+".class");
      System.out.print(id + " successfully installed");
      }
        catch(Exception e){
            System.out.println("Error.");
        }
    }
    public static void uninstall(String id) throws IOException{
        try{
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
            System.out.println("Uninstallation successful.");
        }
    }
}
        catch(Exception e){
            System.out.println("Error.");
        }
    }
        static String[] msoundex(String a, int b) throws IOException, Exception, InterruptedException{
         String[] n=new String[b];
         String[] farray=genstrlist();
            for(int x=0;x<b;x++){
                n[x]=soundex_pack(a,farray);
                farray=rmelement(farray,n[x]);
         }
         return n;
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
          try{
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
             System.out.println("Tyoe \"search [id] [number of results]\" to search for a package.");
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
                if(comm.split(" ").length==2){
                    String[] prn=msoundex(comm.split(" ")[1],genstrlist().length);
                    for(int x=0;x<prn.length;x++){
                        System.out.println(prn[x]);
                    }
                }
                else if(comm.split(" ").length==3){
                  if(Integer.parseInt(comm.split(" ")[2])>genstrlist().length){
                      System.out.println("There are not enough packages to satisfy your request.");
                  }
                  else{
                      String[] prn=msoundex(comm.split(" ")[1],Integer.parseInt(comm.split(" ")[2]));
                      for(int x=0;x<prn.length;x++){
                          System.out.println(prn[x]);
                      }
                  }
                }
                else{
                    System.out.println("Invalid command.");
                }
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
catch(Exception e){
    System.out.println("Error.");
  }
}
 public static void main(String[] args) throws MalformedURLException, IOException, Exception{
     try{
     method();
     }
        catch(Exception e){
            System.out.println("Error.");
        }
 }
}