import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.io.*;
public class Updates{
    public static void downloadFile(URL url, String fileName) throws Exception {
        try (InputStream in = url.openStream()) {
            Files.copy(in, Paths.get(fileName));
        }
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
               if(System.getProperty("os.name").equals("Windows")){
                System.out.println("Updating...");
                File samex=new File("Samex.class");
                File samexRun=new File("SamexRun.class");
                File uninstall=new File("Uninstall.class");
                File helphtml=new File("man\\Samex help page.html");
                File helpy=new File("man\\Samex Interactive Help.py");
                File word=new File("soundex\\words.txt");
                URL update_1=new URL("https://samexmain.github.io/Samex.class");
                URL update_2=new URL("https://samexmain.github.io/SamexRun.class");
                URL update_3=new URL("https://samexmain.github.io/Uninstall.class");
                URL update_4=new URL("https://samexmain.github.io/samex_help_page.html");
                URL update_5=new URL("https://samexmain.github.io/samex_py_help.py");
                URL update_w=new URL("https://samexmain.github.io/words.txt");
                System.out.println("Updating Samex.class");
                samex.delete();
				System.out.println("old file deleted");
                downloadFile(update_1,"Samex.class");
                System.out.println("Updating SamexRun.class");
				System.out.println("old file deleted.");
                samexRun.delete();
                downloadFile(update_2,"SamexRun.class");
                System.out.println("Updating Uninstall.class");
                uninstall.delete();
				System.out.println("old file deleted.");
                downloadFile(update_3,"Uninstall.class");
                System.out.println("Updating Samex help page.html");
                helphtml.delete();
				System.out.println("old file deleted.");
                downloadFile(update_4,"man\\Samex help page.html");
                System.out.println("Updating Samex Interactive help.py");
                helpy.delete();
				System.out.println("old file deleted.");
                downloadFile(update_5,"man\\Samex Interactive Help.py");
                word.delete();
                System.out.println("Downloading words.txt");
                downloadFile(update_w,"soundex\\words.txt");
                System.out.println("Finished! You can use Samex now!");
				File version=new File("samex_version.txt");
	            FileWriter verw=new FileWriter(version);
                verw.write(see);
	            verw.close();
        }
        else{
            System.out.println("Updating...");
                File samex=new File("Samex.class");
                File samexRun=new File("SamexRun.class");
                File uninstall=new File("Uninstall.class");
                File helphtml=new File("man/Samex help page.html");
                File helpy=new File("man/Samex Interactive Help.py");
                File word=new File("soundex/words.txt");
                URL update_1=new URL("https://samexmain.github.io/Samex.class");
                URL update_2=new URL("https://samexmain.github.io/SamexRun.class");
                URL update_3=new URL("https://samexmain.github.io/Uninstall.class");
                URL update_4=new URL("https://samexmain.github.io/samex_help_page.html");
                URL update_5=new URL("https://samexmain.github.io/samex_py_help.py");
                URL update_w=new URL("https://samexmain.github.io/words.txt");
                System.out.println("Updating Samex.class");
                samex.delete();
				System.out.println("old file deleted");
                downloadFile(update_1,"Samex.class");
                System.out.println("Updating SamexRun.class");
				System.out.println("old file deleted.");
                samexRun.delete();
                downloadFile(update_2,"SamexRun.class");
                System.out.println("Updating Uninstall.class");
                uninstall.delete();
				System.out.println("old file deleted.");
                downloadFile(update_3,"Uninstall.class");
                System.out.println("Updating Samex help page.html");
                helphtml.delete();
				System.out.println("old file deleted.");
                downloadFile(update_4,"man/Samex help page.html");
                System.out.println("Updating Samex Interactive help.py");
                helpy.delete();
				System.out.println("old file deleted.");
                downloadFile(update_5,"man/Samex Interactive Help.py");
                word.delete();
                System.out.println("Downloading words.txt");
                downloadFile(update_w,"soundex/words.txt");
                System.out.println("Finished! You can use Samex now!");
				File version=new File("samex_version.txt");
	            FileWriter verw=new FileWriter(version);
                verw.write(see);
	            verw.close();
        }
    }
		}
		catch(Exception e){
            e.printStackTrace();
			System.out.println("Something went wrong. Try it again a few times. If it still doesn't work, email sameerkw23@gmail.com");
		}
    }
    public static void main(String[] args) throws Exception{
        updmethod();
    }
}
