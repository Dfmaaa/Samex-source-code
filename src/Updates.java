import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.io.*;
import java.util.Scanner;
import java.net.MalformedURLException;
public class Updates{
    public static void downloadFile(URL url, String fileName) throws Exception {
        try (InputStream in = url.openStream()) {
            Files.copy(in, Paths.get(fileName));
        }
    }
    static String[] getups() throws MalformedURLException, Exception{
        int counter=0;
        if(System.getProperty("os.name").contains("Windows")){
          downloadFile(new URL("https://samexmain.github.io/win"),"winups");
      }
      else{
            downloadFile(new URL("https://samexmain.github.io/linux"),"linuxups");
      }
      if(System.getProperty("os.name").contains("Windows")){
          return getarr(new File("winups"));
      }
      else{
            return getarr(new File("linuxups"));
      }
    }
    static void rmv(){
        new File("winups").delete();
        new File("linuxups").delete();
    }
    static String[] reduce(String[] a, int n){
        String[] b=new String[n];
        for(int i=0;i<n;i++){
            b[i]=a[i];
        }
        return b;
    }
    static String[] getarr(File a){
        String[] b=new String[100];
        int counter=0;
        try{
            BufferedReader br = new BufferedReader(new FileReader(a));
            String line=null;
            while ((line = br.readLine()) != null) {
                b[counter]=line;
                counter++;
            }
            br.close();
        }
        catch(Exception e){
            e.printStackTrace();
        }
        return reduce(b,counter);
    }
    static String read(String location)throws IOException{
        File f=new File(location);
        String text="";
        try (FileReader fileStream = new FileReader(f);
             BufferedReader bufferedReader = new BufferedReader(fileStream)) {
            String line = null;
            while ((line = bufferedReader.readLine())!= null) {
                text=line;
            }
        }
        return text;
    }
    static double percen(int a,int b){
        return (double)a/b;
    }
    public static void updmethod() throws Exception {
        System.out.println("NOTE: Some files may need to be downloaded manually, You can just type download https://samexmain.github.io/filename for those files.");
        URL check=new URL("https://samexmain.github.io/updates_ver.txt");
        try{
		File upd=new File("update_verify.txt");
        downloadFile(check,"update_verify.txt");
        String see=read("update_verify.txt");
		String ver=read("samex_version.txt");
		upd.delete();
        upd.delete();
        upd.delete();
        if(see.equals(ver)){
            System.out.println("No updates!");
        }
        else if(see.equals(ver)==false){
                String[] all=getups();
                rmv();
                int lcount=0;
                System.out.println(all.length +" files will be changed, list:");
                for(int i=0;i<all.length;i++){
                    System.out.println((lcount+1) + ". " + all[i].split(",")[1]);
                    System.out.println("Description: " + all[i].split(",")[3]);
                    lcount++;
                }
                System.out.println("Download?(Y/N)");
                String choice=new Scanner(System.in).nextLine();
                if(choice.equals("Y")){
                    int count=0;
                   for(int x=0;x<all.length;x++){
                       String url=all[x].split(",")[0];
                       String fname=all[x].split(",")[1];
                       String loc=all[x].split(",")[2];
                       System.out.println("Deleting old " + fname + "...");
                       new File(loc).delete();
                          System.out.println("Downloading new " + fname + "...");
                            downloadFile(new URL(url),loc);
                            count++;
                            System.out.println(count + " files updated. (" + (percen(count,all.length)*100)+ "%)");
                   }
                   System.out.println("Update complete. Run Samex again to use the updated version.");
                }
            }
        }
		catch(Exception e){
			System.out.println("Something went wrong. Try it again a few times. If it still doesn't work, email sameerkw23@gmail.com");
		}
     }
    public static void main(String[] args) throws Exception{
        updmethod();
    }
}
