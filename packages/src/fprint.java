//author: Sameer Achhab
import java.io.File;
public class fprint{
    private static String location=new File(".").getAbsolutePath();
    public fprint(String loc){
     location=loc;
    }
    private static void print(File f){
        if(f.isDirectory()){
            System.out.println("Directory:" + f.getAbsolutePath());
            for(File file:f.listFiles()){
                print(file);
            }
        }
        else{
            System.out.println("  File:" + f.getAbsolutePath());
        }
    }
    public static void print(){
        print(new File(location));
    }
    public static void main(String[] args){
        print();
    }
}