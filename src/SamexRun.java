import java.util.Scanner;
import java.awt.Desktop;
import java.io.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Random;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import java.security.MessageDigest;
public class SamexRun {
	private static String lastcommand="";
	static int ascii(char c){
		return (int) c;
	}
	static String[] alphasort(String[] a){
		int add=0;
		for(int b=0;b<a.length;b++) {
			for (int x = 0; x < a.length-1; x++) {
             if(ascii(a[x].charAt(0))>ascii(a[x].charAt(0))){
				 String lword=a[x];
				 a[x]=a[x+1];
				 a[x+1]=lword;
			 }
			  else if(ascii(a[x].charAt(0))==ascii(a[x].charAt(0))){
				  add++;
				  while(ascii(a[x].charAt(add))==ascii(a[x].charAt(add))){
					  if(ascii(a[x].charAt(add))>ascii(a[x].charAt(add+1))){
						  String lword=a[add];
						  a[x]=a[add+1];
						  a[x+1]=lword;
						  break;
					  }
					  add++;
				  }
			 }
			}
		}
		return a;
	}
	static String sha(String data){
		try{
			final MessageDigest digest = MessageDigest.getInstance("SHA-256");
			final byte[] hash = digest.digest(data.getBytes("UTF-8"));
			final StringBuilder hexString = new StringBuilder();
			for (int i = 0; i < hash.length; i++) {
				final String hex = Integer.toHexString(0xff & hash[i]);
				if(hex.length() == 1) 
				  hexString.append('0');
				hexString.append(hex);
			}
			return hexString.toString();
		} catch(Exception ex){
		   throw new RuntimeException(ex);
		}
	}
	static String chstr(char[] a){
	 String re="";
	  for(int x=0;x<a.length;x++){
		  re+=a[x];
	  }
	   return re;
	}
	static String encrypt(String data){
		return sha(data);
	}
	static String decrypt(String data){
		return data;//DID THIS BECAUSE TOO LAZY TO CHANGE ALL THE CODE
	}
	static String grc(){
	 Random r=new Random();
	  int till=10;//number of characters in the captcha code
	  char[] a=new char[till];
	  for(int n=0;n<a.length;n++){
           a[n]=(char)r.nextInt(126);
	  }
	 return chstr(a);	
	}
	static String encryp(String str) {
		String fin=str;
		for(int x=0;x<str.length();x++) {
			if(str.charAt(x)=='a') {
				fin=fin.replace('a', 'k');
			}
			if(str.charAt(x)=='b') {
				fin=fin.replace('b', 't');
			}
			if(str.charAt(x)=='c') {
				fin=fin.replace('c', 'j');
			}
			if(str.charAt(x)=='d') {
				fin=fin.replace('d', 'u');
			}
			if(str.charAt(x)=='e') {
				fin=fin.replace('e', 'X');
			}
			if(str.charAt(x)=='f') {
				fin=fin.replace('f', 'N');
			}
			if(str.charAt(x)=='g') {
				fin=fin.replace('g', 'L');
			}
			if(str.charAt(x)=='h') {
				fin=fin.replace('h', 'J');
			}
			if(str.charAt(x)=='i') {
				fin=fin.replace('i', '}');
			}
			if(str.charAt(x)=='j') {
				fin=fin.replace('j', '>');
			}
			if(str.charAt(x)=='k') {
				fin=fin.replace('k', '<');
			}
			if(str.charAt(x)=='l') {
				fin=fin.replace('l', ';');
			}
			if(str.charAt(x)=='m') {
				fin=fin.replace('m', '!');
			}
			if(str.charAt(x)=='n') {
				fin=fin.replace('n', '+');
			}
			if(str.charAt(x)==' ') {
				fin=fin.replace(' ', '?');
			}
			if(str.charAt(x)=='o') {
				fin=fin.replace('o', 'Q');
			}
			if(str.charAt(x)=='p') {
				fin=fin.replace('p', 'Y');
			}
			if(str.charAt(x)=='q') {
				fin=fin.replace('q', ')');
			}
			if(str.charAt(x)=='r') {
				fin=fin.replace('r', '_');
			}
			if(str.charAt(x)=='s') {
				fin=fin.replace('s', '.');
			}
			if(str.charAt(x)=='t') {
				fin=fin.replace('t', ']');
			}
			if(str.charAt(x)=='u') {
				fin=fin.replace('u', ',');
			}
			if(str.charAt(x)=='v') {
				fin=fin.replace('v', ':');
			}
			if(str.charAt(x)=='w') {
				fin=fin.replace('w', '|');
			}
			if(str.charAt(x)=='x') {
				fin=fin.replace('x', '%');
			}
			if(str.charAt(x)=='y') {
				fin=fin.replace('y', '*');
			}
			if(str.charAt(x)=='z') {
				fin=fin.replace('z', '"');
			}
		}
		return fin;
	}
	static String decryp(String str) {
		String fin=str;
		for(int x=0;x<str.length();x++) {
			if(str.charAt(x)=='k') {
				fin=fin.replace('k', 'a');
			}
			if(str.charAt(x)=='t') {
				fin=fin.replace('t', 'b');
			}
			if(str.charAt(x)=='j') {
				fin=fin.replace('j', 'c');
			}
			if(str.charAt(x)=='u') {
				fin=fin.replace('u', 'd');
			}
			if(str.charAt(x)=='X') {
				fin=fin.replace('X', 'e');
			}
			if(str.charAt(x)=='N') {
				fin=fin.replace('N', 'f');
			}
			if(str.charAt(x)=='L') {
				fin=fin.replace('L', 'g');
			}
			if(str.charAt(x)=='J') {
				fin=fin.replace('J', 'h');
			}
			if(str.charAt(x)=='}') {
				fin=fin.replace('}', 'i');
			}
			if(str.charAt(x)=='>') {
				fin=fin.replace('>', 'j');
			}
			if(str.charAt(x)=='<') {
				fin=fin.replace('<', 'k');
			}
			if(str.charAt(x)==';') {
				fin=fin.replace(';', 'l');
			}
			if(str.charAt(x)=='!') {
				fin=fin.replace('!', 'm');
			}
			if(str.charAt(x)=='+') {
				fin=fin.replace('+', 'n');
			}
			if(str.charAt(x)=='?') {
				fin=fin.replace('?', ' ');
			}
			if(str.charAt(x)=='Q') {
				fin=fin.replace('Q', 'o');
			}
			if(str.charAt(x)=='Y') {
				fin=fin.replace('Y', 'p');
			}
			if(str.charAt(x)==')') {
				fin=fin.replace(')', 'q');
			}
			if(str.charAt(x)=='_') {
				fin=fin.replace('_', 'r');
			}
			if(str.charAt(x)=='.') {
				fin=fin.replace('.', 's');
			}
			if(str.charAt(x)==']') {
				fin=fin.replace(']', 't');
			}
			if(str.charAt(x)==',') {
				fin=fin.replace(',', 'u');
			}
			if(str.charAt(x)==':') {
				fin=fin.replace(':', 'v');
			}
			if(str.charAt(x)=='|') {
				fin=fin.replace('|', 'w');
			}
			if(str.charAt(x)=='%') {
				fin=fin.replace('%', 'x');
			}
			if(str.charAt(x)=='*') {
				fin=fin.replace('*', 'y');
			}
			if(str.charAt(x)=='"') {
				fin=fin.replace('"', 'z');
			}
		}
		return fin;
	}
	static String withoutext(String f){
		return f.split(".")[0];
	}
	static String[] genstrfilearray(File[] a){
		String[] n=new String[a.length];
		for(int x=0;x<n.length;x++){
			n[x]=withoutext(a[x].getName());
		}
		return n;
	}
	static String[] alphaf(File a){
		String[] end=genstrfilearray(a.listFiles());
		end=alphasort(end);
		return end;
	}
	static String ats(String[] a){
		int length=a.length-1;
		String sum="";
		for(int x=0;x<=length;x++){
			sum+=a[x];
		}
		return sum;
	}
	static String[] words(File f, int num_lines) throws IOException {
        String[] r = new String[num_lines];
        int counter = 0;
        try (FileReader fileStream = new FileReader(f);
             BufferedReader bufferedReader = new BufferedReader(fileStream)) {
            String line = null;
            while ((line = bufferedReader.readLine()) != null) {
                r[counter] = line;
                counter++;
            }
        }
        return r;
    }
    static String shortword(String word_1,String word_2){
        if(word_1.length()<word_2.length()){
            return word_1;
        }
       else if(word_1.length()>word_2.length()){
           return word_2;
        }
       else{
           return word_1;
        }
    }
    static int points(String word_1,String word_2){
        int see=0;
        int till=shortword(word_1,word_2).length();
        char[] a=word_1.toLowerCase().toCharArray();
        char[] b=word_2.toLowerCase().toCharArray();
        for(int x=0;x<till;x++){
            if(a[x]==b[x]){
                see++;
            }
        }
        return see;
    }
    static String getkey(int value, HashMap<String,Integer> f){
        String word="";
        for ( String key : f.keySet() ) {
            if(f.get(key)==value){
                word=key;
            }
        }
        return word;
    }
    static int maxval(int[] a){
        for(int x=0;x<a.length;x++){
            if(a[0]<a[x]){
                a[0]=a[x];
            }
        }
        return a[0];
    }
    static int getlines(File f) throws IOException {
        int lines = 0;
        try (FileReader fileStream = new FileReader(f);
             BufferedReader bufferedReader = new BufferedReader(fileStream)) {
            String line = null;
            while ((line = bufferedReader.readLine()) != null) {
                lines++;
            }

        }
        return lines;
    }
	static boolean packverify(String id){
		File f=new File(id+".class");
		return f.exists();
	}
    static String soundex(String word) throws IOException {
		String result="";
		if(System.getProperty("os.name").equals("Windows")){
        File f=new File("soundex\\words.txt");
       int file_length=getlines(f);
       int[] values=new int[file_length];
       String[] words=words(f,file_length);
       HashMap<String,Integer> hash=new HashMap<String,Integer>();
       for(int x=0;x<file_length;x++){
           values[x]=points(word,words[x]);
           hash.put(words[x],points(word,words[x]));
       }
       int max=maxval(values);
       result=getkey(max,hash);
	}
	else if(System.getProperty("os.name").equals("Linux")){
		File f=new File("soundex/words.txt");
       int file_length=getlines(f);
       int[] values=new int[file_length];
       String[] words=words(f,file_length);
       HashMap<String,Integer> hash=new HashMap<String,Integer>();
       for(int x=0;x<file_length;x++){
           values[x]=points(word,words[x]);
           hash.put(words[x],points(word,words[x]));
       }
       int max=maxval(values);
       result=getkey(max,hash);
	}
	return result;
    }
	static String time(){
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");  
		LocalDateTime now = LocalDateTime.now();  
		return dtf.format(now);
	}
	
	static String showtime(){
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("HH:mm:ss");  
		LocalDateTime now = LocalDateTime.now();  
		return dtf.format(now);
	}
	public static void playSound(String location) {
		if(System.getProperty("os.name").equals("Windows")){
		try {
			AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File("sounds\\" + location).getAbsoluteFile());
			Clip clip = AudioSystem.getClip();
			clip.open(audioInputStream);
			clip.start();
            
		} catch(Exception ex) {
			System.out.println("Can't play sound. Contact sameerkw23@gmail.com");
		}
	}
	else if(System.getProperty("os.name").equals("Linux")){
		if(System.getProperty("os.name").equals("Windows")){
			try {
				AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File("sounds/" + location).getAbsoluteFile());
				Clip clip = AudioSystem.getClip();
				clip.open(audioInputStream);
				clip.start();
				
			} catch(Exception ex) {
				System.out.println("Can't play sound. Contact sameerkw23@gmail.com");
			}
	}
	}
}
	//TODO: use this method for soundex and don't forget cd [path] and dir [path] boolean checks.(DONE)
	static boolean incorrectcmd(String command){
		if(command.equals("help")==false&command.equals("packages")==false&command.equals("update")==false&command.equals("content")==false&command.equals("restart")==false&command.equals("lastcmd")==false&command.equals("Atlas")==false&command.equals("rock paper scissors")==false&command.equals("settings")==false&command.equals("showalpha")==false&command.equals("emdir")==false&command.equals("playfile")==false&command.equals("goto")==false&command.equals("getlines")==false&command.equals("remove duplicates")==false&command.equals("time")==false&command.equals("change password")==false&&command.equals("secret files")==false&command.equals("set password")==false&command.equals("create")==false&command.equals("remove")==false&command.equals("history")==false&command.equals("clear history")==false&command.equals("write")==false&command.equals("remove password")==false&command.equals("exists")==false&check(command.split(" "),"cd")==false&check(command.split(" "),"dir")==false&command.equals("download")==false&command.equals("shutdown")==false){
         return true;
		}
		else{
			return false;
		}
	}
	static String conv(String[] a){
		 String result="";
		 for(int x=0;x<=a.length-1;x++) {
			 result=result+a[x]+"\r\n";
		 }
		 return result;
	 }
	static boolean check(String[] a, String element){
		int length=a.length-1;
		int counter=0;
		for(int x=0;x<=length;x++) {
			if(a[x].equals(element)){
				counter++;
			}
		}
		if(counter>0) {
			return true;
		}
		else{
			return false;
		}
	}
	 public static void downloadFile(URL url, String fileName) throws Exception {
        try (InputStream in = url.openStream()) {
            Files.copy(in, Paths.get(fileName));
        }
    }
	static String read(String location) throws IOException{
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
	public static void deletefiles(String[] a,int length){
		for(int i=0;i<length;i++){
			File f=new File(a[i]);
			f.delete();
			f=null;
		}
	}
	static String getextension(String name){
		String[] af=name.split(".");
		return af[af.length-1];
	}
	static String gotoln(File f, int ln) throws IOException{
		//reading
		String giveln=null;
		int lncounter=0;
        	try (FileReader fileStream = new FileReader(f);
            BufferedReader bufferedReader = new BufferedReader(fileStream)) {
           String line = null;
           while ((line = bufferedReader.readLine())!= null) {
          	 if(lncounter==ln){
				   giveln=line;
			   }
			   lncounter++;
	   }   
        }
		return giveln;
	}
	static String getfileline(File a, int lne) throws IOException{
		String text="";
		try (FileReader fileStream = new FileReader(a);
			 BufferedReader bufferedReader = new BufferedReader(fileStream)) {
		  String line = null;
		  int count=0;
		  while ((line = bufferedReader.readLine())!= null) {
			if(count==lne){
			 text=line;
			}
			count++;
		  }
		}
		return text;
	  }
	  static int getfilelinenum(File a) throws FileNotFoundException, IOException{
		  int count=0;
		  try (FileReader fileStream = new FileReader(a);
				 BufferedReader bufferedReader = new BufferedReader(fileStream)) {
			  String line = null;
			  while ((line = bufferedReader.readLine())!= null) {
				count++;
			  }
			}
			return count;
	  }
	  static String percentage(int x, int y){
		  double m=(x/y)*100;
		  return Double.toString(m) + "%";
	  }
	  public static void autorepair(){
		  String[] files=gmf();
		  System.out.print(files.length + " vital files are missing from your device. Start autorepair?(Y/N)");
		  Scanner inp=new Scanner(System.in);
		  String achoice=inp.nextLine();
		  if(achoice.equals("Y")){
		  System.out.println("Starting auto-repair...");
		  try{
		  for(int x=0;x<files.length;x++){
			  downloadFile(new URL("https://samexmain.github.io/" + new File(files[x]).getName()),files[x]);
			  System.out.println(x+1 + " of " + files.length + " files downloaded.(" + percentage(x+1,files.length) + ")");
	  }
	}
	catch(Exception e){
		System.out.println("Error. Please try again.");
	}
	}
	if(achoice.equals("N")){
		System.out.println("Auto-repair canceled.");
	}
	}
	  //TODO: UPDATE INCORRECTCMD METHOD
   public static void run(String main_location) throws IOException, InterruptedException, Exception{
	   Scanner input=new Scanner(System.in);
	   run_direct(main_location,"start");
	   while(true){
		   System.out.print("samex$ ");
           String command=input.nextLine();
		   lastcommand=command;
		   if(command.split(" ")[0].equals("exec")){
			   try{
               File cmdfile=new File(command.split(" ")[1]);
			   int lines=getfilelinenum(cmdfile);
			   for(int x=0;x<lines;x++){
				  if(incorrectcmd(getfileline(cmdfile,x))){
					  System.out.println("Invalid command at line " + x + " , did you mean " + soundex(getfileline(cmdfile,x)) + " ?");
				  }
				  else{
					  run_direct(main_location,getfileline(cmdfile,x));
				  }
			   }
			}
			catch(Exception er){
				er.printStackTrace();
			}
		   }
		   else if(command.equals("lastcmd")){
			   run_direct(main_location, lastcommand);
		   }
		   else{
			   run_direct(main_location,command);
		   }
	   }
	   }
   static boolean checkforfileslin(){
	File[] win=new File[4];
	    win[0]=new File("Samex.class");
	   win[1]=new File("SamexRun.class");
	   win[2]=new File("soundex/words.txt");
	   win[3]=new File("PackageInstaller.class");
	   boolean mainval=true;
	   for(int x=0;x<win.length;x++){
		   if(win[x].exists()==false){
			   mainval=false;
		   }
	   }
	   return mainval;
   }
   static boolean checkforfileswin(){
	   File[] win=new File[4];
	    win[0]=new File("Samex.class");
	   win[1]=new File("SamexRun.class");
	   win[2]=new File("soundex\\words.txt");
	   win[3]=new File("PackageInstaller.class");
	   boolean mainval=true;
	   for(int x=0;x<win.length;x++){
		   if(win[x].exists()==false){
			   mainval=false;
		   }
	   }
	   return mainval;
   }
   static boolean cffdriver(){
	   String os=System.getProperty("os.name");
	   if(os.equals("Windows")){
		   return checkforfileswin();
	   }
	   else{
		   return checkforfileslin();
	   }
   }
   static String[] gmf(){
	   String os=System.getProperty("os.name");
	   String[] marray=new String[4];
	   int counter=0;
	   if(os.equals("Windows")){
		File[] win=new File[4];
	    win[0]=new File("Samex.class");
	   win[1]=new File("SamexRun.class");
	   win[2]=new File("soundex\\words.txt");
	   win[3]=new File("PackageInstaller.class");
	   for(int x=0;x<marray.length;x++){
		   if(win[x].exists()==false){
			   marray[counter]=win[x].getAbsolutePath();
			   counter++;
		   }
	   }
	   }
	   else if(os.equals("Linux")){
		   File[] lin=new File[4];
		   lin[0]=new File("Samex.class");
		   lin[1]=new File("SamexRun.class");
		   lin[2]=new File("soundex/words.txt");
		   lin[3]=new File("PackageInstaller.class");
		   for(int x=0;x<marray.length;x++){
			   if(lin[x].exists()==false){
				   marray[counter]=lin[x].getAbsolutePath();
				   counter++;
			   }
		   }
	   }
	   String[] rarray=new String[counter];
	   for(int x=0;x<rarray.length;x++){
		   rarray[x]=marray[x];
	   }
	   return rarray;
   }
   public static void run_direct(String main_location, String mcommand) throws IOException, InterruptedException, Exception {
    	String location=main_location;
		boolean noexist=new File("noconf000.samex").exists();
    	File pass=new File("Samex_Password.txt");
	   File main_loc=new File(main_location);
		Scanner input=new Scanner(System.in);
		if(mcommand.equals("start")){

		
		System.out.println("\r\n"
				+ "████████████████████████████████████████████████████████████████████████████████████████\r\n"
				+ "█░░░░░░░░░░░░░░█░░░░░░░░░░░░░░█░░░░░░██████████░░░░░░█░░░░░░░░░░░░░░█░░░░░░░░██░░░░░░░░█\r\n"
				+ "█░░▄▀▄▀▄▀▄▀▄▀░░█░░▄▀▄▀▄▀▄▀▄▀░░█░░▄▀░░░░░░░░░░░░░░▄▀░░█░░▄▀▄▀▄▀▄▀▄▀░░█░░▄▀▄▀░░██░░▄▀▄▀░░█\r\n"
				+ "█░░▄▀░░░░░░░░░░█░░▄▀░░░░░░▄▀░░█░░▄▀▄▀▄▀▄▀▄▀▄▀▄▀▄▀▄▀░░█░░▄▀░░░░░░░░░░█░░░░▄▀░░██░░▄▀░░░░█\r\n"
				+ "█░░▄▀░░█████████░░▄▀░░██░░▄▀░░█░░▄▀░░░░░░▄▀░░░░░░▄▀░░█░░▄▀░░███████████░░▄▀▄▀░░▄▀▄▀░░███\r\n"
				+ "█░░▄▀░░░░░░░░░░█░░▄▀░░░░░░▄▀░░█░░▄▀░░██░░▄▀░░██░░▄▀░░█░░▄▀░░░░░░░░░░███░░░░▄▀▄▀▄▀░░░░███\r\n"
				+ "█░░▄▀▄▀▄▀▄▀▄▀░░█░░▄▀▄▀▄▀▄▀▄▀░░█░░▄▀░░██░░▄▀░░██░░▄▀░░█░░▄▀▄▀▄▀▄▀▄▀░░█████░░▄▀▄▀▄▀░░█████\r\n"
				+ "█░░░░░░░░░░▄▀░░█░░▄▀░░░░░░▄▀░░█░░▄▀░░██░░░░░░██░░▄▀░░█░░▄▀░░░░░░░░░░███░░░░▄▀▄▀▄▀░░░░███\r\n"
				+ "█████████░░▄▀░░█░░▄▀░░██░░▄▀░░█░░▄▀░░██████████░░▄▀░░█░░▄▀░░███████████░░▄▀▄▀░░▄▀▄▀░░███\r\n"
				+ "█░░░░░░░░░░▄▀░░█░░▄▀░░██░░▄▀░░█░░▄▀░░██████████░░▄▀░░█░░▄▀░░░░░░░░░░█░░░░▄▀░░██░░▄▀░░░░█\r\n"
				+ "█░░▄▀▄▀▄▀▄▀▄▀░░█░░▄▀░░██░░▄▀░░█░░▄▀░░██████████░░▄▀░░█░░▄▀▄▀▄▀▄▀▄▀░░█░░▄▀▄▀░░██░░▄▀▄▀░░█\r\n"
				+ "█░░░░░░░░░░░░░░█░░░░░░██░░░░░░█░░░░░░██████████░░░░░░█░░░░░░░░░░░░░░█░░░░░░░░██░░░░░░░░█\r\n"
				+ "████████████████████████████████████████████████████████████████████████████████████████");
		//config
        if(pass.exists()==false&noexist==false) {
			System.out.println("Would you like to keep a password(Y/N):");
			Scanner config=new Scanner(System.in);
			String chg=config.nextLine();
			if(chg.equals("Y")){
        	System.out.println("Enter a password for Samex.");
        	String new_pass=input.nextLine();
        	pass.createNewFile();
        	FileWriter j=new FileWriter(pass);
        	j.write(encrypt(new_pass));
        	j.close();
			}
			else if(chg.equals("N")){
			 File nocreate=new File("noconf000.samex");
			 nocreate.createNewFile();
			 noexist=true;
			}
        }
        if(pass.exists()==true&noexist==false) {
        	boolean access=false;
        	String entered_pass=null;
        	try (FileReader fileStream = new FileReader(pass);
            BufferedReader bufferedReader = new BufferedReader(fileStream)) {
           String line = null;
           while ((line = bufferedReader.readLine())!= null) {
          	 entered_pass=line;
	   }   
        }
        	System.out.print("Password:");
        	String ask=input.nextLine();
        	if(sha(ask).equals(decrypt(entered_pass))) {
        		access=true;
        		System.out.println("Access granted.");
        	}
        	else {
        		
        			System.out.println("Invalid password.");
			        Scanner for_cap=new Scanner(System.in);
			        
			        System.out.println("You must enter what we tell you to, to prove you are human(WARNING: IF YOU GET IT WRONG, ALL THE FILES WILL BE DELETED.)");
			        String captcha=grc();
			        try{
			        System.out.println("Enter " + captcha);
			        String entered_captcha=input.nextLine();
			        if(captcha.equals(entered_captcha)==false){
			          Uninstall uns=new Uninstall();
			          uns.method();
				}
			   else if(captcha.equals(entered_captcha)==true){
			          System.out.println("Ok! Run the file again!");
				}
				}
			     catch(Exception exp){
				     Uninstall n=new Uninstall();
				     n.method();
			     }
        		System.exit(0);
                	
        		}
        	}
		
        System.out.println("Samex 3.4 2021. Type help for a list of commands.");
		}
			try{	
        	String inp=mcommand;
        	boolean inp_cd=check(inp.split(" "),"cd");
        	String with=ats(inp.split(" "));
        	String no_cd=ats(with.split("cd"));
        	String with_2=ats(with.split("dir"));
        	boolean inp_dir=check(inp.split(" "),"dir");
			//soundex
			if(incorrectcmd(inp)==true&inp.equals("start")==false){
				try{
				  boolean soun=new File("soundexconfig.samex").exists();
				  if(soun==true){
				  inp=soundex(inp);
				  }
				  else{
					  System.out.println("Did you mean " + soundex(inp));
					  playSound("error.wav");
				  }
				}
				catch(Exception exps){
					System.out.println("Something is wrong with the file that has all the commands.");
					playSound("error.wav");
				}
			 }
        	if(inp.equals("shutdown")) {
			 playSound("shutdown.wav");
        	 System.exit(0);
			}
        	if(inp.equals("help")) {
        		System.out.println("Type \"shutdown\" to shutdown.");
        		System.out.println("Type \"content\" to see the contents of a file. ");
        		System.out.println("Type \"write\" to write into a file. ");
        		System.out.println("Type \"remove\" to delete files.");
        		System.out.println("Type \"create\" to create new files.");
        		System.out.println("Type \"exists\" to check if a file exists.");
        		System.out.println("Type \"cd [path] \" to open files");
        		System.out.println("Type \"dir [path]\" to view all the files in a directory or a folder.");
        		System.out.println("Type \"restart\" to restart.");
        		System.out.println("Type \"rename\" to rename a file.");
        		System.out.println("Type \"change password\" to change the password.");
				System.out.println("Type \"download\" to download files from the web.");
				System.out.println("Type \"history\" to see all the file interactions you have performed with Samex." );
				System.out.println("Type \"clear history\" to clear history.");
				System.out.println("Type \"remove password\" to remove the password.");
				System.out.println("Type \"set password\" to set a password.");
				System.out.println("Type \"secret files\" to create and view files with encrypted content.");
				System.out.println("Type \"time\" to view the time.");
				System.out.println("Type \"remove duplicates\"to remove duplicate files from a directory.");
				System.out.println("You can go to settings by typing \"settings\" ");
				System.out.println("Type \"getlines \" to get the number of lines in a file.");
				System.out.println("Type \"goto\" to go to a line in a file." );
				System.out.println("Type \"emdir\" to delete all the files in a directory.");
				System.out.println("Type \"showalpha\" to show all the nanes alphabetically z-a, in a directory");
				System.out.println("Type \"playfile\" to play audio files NOTE:- requires you to download the package \"playsound\"");
				System.out.println("Type \"packages\" to use commands for  packages.");
				System.out.println("Type \"rock paper scissors\" to play rock paper scissors.[PACKAGE]");
				System.out.println("Type \"Atlas\" to play Atlas.[PACKAGE]");
				System.out.println("Type \"exec [path to file]\" to run a bunch of commands together");
				System.out.println("Type \"update\" to update Samex.");
				System.out.println("Type \"lastcmd\" to run the last command you runned.");
        	}
			if(inp.equals("update")){
				Updates up=new Updates();
				up.updmethod();
			}
			if(inp.equals("Atlas")){
				if(packverify("Atlas")==false){
					System.out.println("You do not have Atlas. Try installing the package \"Atlas\"");
				}
               else{
				   Atlas at=new Atlas();
                   at.mthod();
			   }
			}
			if(inp.equals("packages")){
             PackageInstaller use=new PackageInstaller();
			 use.method();
			}
			if(inp.equals("rock paper scissors")){
                 if(packverify("rockpaperscissors")==false){
					 System.out.println("You need to install the package \"rockpaperscissors\" to use this command.");
				 }
				 else{
					 rockpaperscissors rps=new rockpaperscissors();
					 rps.meth();
				 }
			}
			if(inp.equals("playfile")){
				if(packverify("playsound")){
					playsound pl=new playsound();
					System.out.println("Location:");
					String lotion=input.nextLine();
                    pl.playSound(lotion);
				}
				else{
					System.out.println("You don't have this package, Try typing Packages and then type \"install playfile\"");
				}
			}
			if(inp.equals("goto")){
				System.out.println("Location:");
				String llm=input.nextLine();
				System.out.println("Line:");
				Scanner strin=new Scanner(System.in);
				int linenum=strin.nextInt();
                System.out.println(gotoln(new File("llm"),linenum));
			}
			if(inp.equals("getlines")){
				System.out.print("Location:");
				String llmao=input.nextLine();
				System.out.println(getlines(new File(llmao)));
			}
			if(inp.equals("settings")){
				System.out.println("Type 1 then type Y or N (use commands returned by soundex)");
				Scanner ininp=new Scanner(System.in);
				int choi=ininp.nextInt();
				if(choi==1){
					System.out.print("choice:");
					String choi2=input.nextLine();
					if(choi2.equals("Y")){
						File yes=new File("soundexconfig.samex");
						if(yes.exists()==true){
							System.out.println("This is the option you are currently using.");
							playSound("error.wav");
						}
						else{
							yes.createNewFile();
							System.out.println("Option selected!");
							playSound("success.wav");
						}
					}
					else if(choi2.equals("N")){
						File no=new File("soundexconfig.samex");
						if(no.exists()==false){
							System.out.println("You don't use the Y option.");
						}
						else{
							no.delete();
							System.out.println("Option selected!");
							playSound("success.wav");
						}
					}
				}
			}
			if(inp.equals("time")){
				System.out.println(showtime());
			}
			if(inp.equals("remove duplicates")){
             System.out.print("Location(use 2 backslashes for 1 backslash, please):");
			 String lo=input.nextLine();
			 boolean exe=new File(lo).exists();
			 if(exe==false){
				 System.out.println("Doesn't exist.");
			 }
			 else{
				 boolean ifdir=new File(lo).listFiles().length==0;
				 if(ifdir==true){
					 System.out.println("Not a directory or the directory doesn't have files.");
				 }
				 else{
					 try{
					 File[] aa=new File(lo).listFiles();
					 String[] aa2=new String[aa.length];
					 //getting their paths
                   for(int fir=0;fir<aa.length;fir++){
					   for(int fir2=0;fir2<aa.length;fir2++){
						   if(read(aa[fir].getAbsolutePath()).equals(read(aa[fir2].getAbsolutePath()))&fir!=fir2){
							   aa[fir2].delete();
						   }
					   }
				   }
				  System.out.println("Deleted duplicate files in the directory.");
				 }
				 catch(Exception lmao){
					
				 }
			 }
			}
			}
			if(inp.equals("remove password")){
				if(noexist==false&pass.exists()==true){
					pass.delete();
					File createno=new File("noconf000.samex");
					createno.createNewFile();
					System.out.println("password successfully removed.");
					playSound("success.wav");
				}
				else{
					System.out.println("You don't have a password.");
					playSound("error.wav");
				}
			}
			if(inp.equals("set password")){
				if(pass.exists()==false&noexist==true){
					System.out.print("Enter the password you want to set(Must be lowercase and no special characters):");
					Scanner passset=new Scanner(System.in);
					String newpass=passset.nextLine();
                   File nodelete=new File("noconf000.samex");
				   nodelete.delete();
				   pass.createNewFile();
				   FileWriter newwr=new FileWriter(pass);
					newwr.write(encrypt(newpass));
					newwr.close();
					System.out.println("Password successfully set.");
					playSound("success.wav");
				}
			}
			if(inp.equals("secret files")){
				 System.out.println("This feature has been deprecated.");
				}
			if(inp.equals("clear history")){
				System.out.println("Clearing history.");
				File clearhis=new File("Main_File.txt");
				clearhis.delete();
				clearhis.createNewFile();
				System.out.println("Cleared history.");
			}
			if(inp.equals("download")){
				Scanner down=new Scanner(System.in);
				System.out.print("URL:");
				String addr=down.nextLine();
				URL ur=new URL(addr);
				System.out.print("Output file:");
				String output=down.nextLine();
				try{
					downloadFile(ur,output);
				}
				catch(Exception nn){
					System.out.println("Something went wrong.");
				}
			}
        	if(inp.equals("change password")) {
				if(noexist==false&pass.exists()){
        		System.out.print("Enter your old password:");
        		String check=null;
        		String old_pass=input.nextLine();
        		try (FileReader fileStream = new FileReader(pass);
        	            BufferedReader bufferedReader = new BufferedReader(fileStream)) {
        	           String line = null;
        	           while ((line = bufferedReader.readLine())!= null) {
        	          	 check=decrypt(line);
        		   }   
        	        }
        		if(sha(check).equals(old_pass)) {
        			System.out.print("New password:");
        			String enter_new=input.nextLine();
        			pass.delete();
        			pass.createNewFile();
        			FileWriter n=new FileWriter(pass);
        			n.write(encrypt(enter_new));
        			n.close();
        			System.out.println("New password set.");
        		}
        		else if(check.equals(decrypt(old_pass))==false){
        			System.out.println("Invalid old password.");
        		}
			 }
			 else if(noexist==true&pass.exists()==false){
				 System.out.println("Please type \"set password\" to set a password.");
			 }
        	}
			if(inp.equals("emdir")){
			System.out.println("Enter directory location:");
			String dirloc=input.nextLine();
			 File[] em =new File(dirloc).listFiles();
			 for(int x=0;x<em.length;x++){
				 try{
				 em[x].delete();
				 }
				 catch(Exception oof){

				 }
			 }
			}
        	if(inp.equals("rename")){
        		System.out.println("Location:");
        		String loc=input.nextLine();
        		System.out.println("New name(with location):");
        		String new_loc=input.nextLine();
        		File old=new File(loc);
        		File new_old=new File(new_loc);
        		if(old.exists()==true) {
        		boolean flag=old.renameTo(new_old);
        		if(flag) {
        			System.out.println("File successfully renamed.");
        			if(flag==false) {
        				System.out.println("Failed.");
        			}
        		}
        		}
        		else {
        			System.out.println("file does not exist");
        		}
        	}
        	if(inp.equals("create")){
        		System.out.print("Enter location of the file:");
        		String loc=input.nextLine();
        		File f=new File(loc);
        		if(f.exists()==true){
        			System.out.println("The file already exists.");
        		}
        		else {
        			f.createNewFile();
        			System.out.println("File has been successfully created.");
        		}
				File crese=new File("Main_File.txt");
				FileWriter cresewr=new FileWriter(crese);
				cresewr.write(read("Main_File.txt") + "\n" + crese.getName() + " " + crese.getAbsolutePath() + " " + crese.length() + " " + time() + " attempted to create the file");
				cresewr.close();
        		f=null;
        	}
        	if(inp_cd==true) {
        		File f=new File(no_cd);
        		if(f.exists()==true) {
        			Desktop desktop=Desktop.getDesktop();
        			if(!Desktop.isDesktopSupported()) {
        				System.out.println("Not supported.");
        			}
        			else {
        				desktop.open(f);
        			}
        		}
        		f=null;
        	}
        	if(inp_dir==true){
        		File f=new File(with_2);
        		if(f.exists()==true) {
        			try {
        				System.out.println(conv(f.list()));
        			}
        			catch(java.lang.NullPointerException exp) {
        				System.out.println("Invalid directory.");
        			}
        		}
        		else {
        			System.out.println("Invalid location.");
        		}
        		f=null;
        	}
        	
        	if(inp.equals("content")) {
        		System.out.print("Location:");
        		String locat=input.nextLine();
        		 File fileToRead = new File(locat);
        		 FileWriter wr=new FileWriter(main_loc);
                 try (FileReader fileStream = new FileReader(fileToRead);
                      BufferedReader bufferedReader = new BufferedReader(fileStream)) {
                     String line = null;
                     while ((line = bufferedReader.readLine())!= null) {
                    	 System.out.println(line);
        	   }   
              }
			  File cons=new File("Main_File.txt");
			  FileWriter conswr=new FileWriter(cons);
			  conswr.write(read("Main_File.txt") + "\n" + cons.getName() + " " + cons.getAbsolutePath() + " " + cons.length() + " " + time() + " Attempted to see the contents of the file.");
			  conswr.close();
        	 }
        	if(inp.equals("write")) {
        		System.out.print("Location:");
        		String name=input.nextLine();
        		 File file = new File(name);
                 FileWriter write = new FileWriter(file);
                 System.out.println("Enter the text you would like to write into " + file.getName());
                 String text=input.nextLine();
                 write.write(text);
                 write.close();
				 File main_=new File("Main_File.txt");
				 FileWriter mainwr=new FileWriter(main_);
				 mainwr.write(read("Main_File.txt") + "\n" + file.getName()+ " " + file.getAbsolutePath() + " " + file.length() + " " +time() + " typed " + text + " in the file");
				 mainwr.close();
        	}
        	if(inp.equals("history")) {
				System.out.println("Format: Name, Path, size, time, task");
        		System.out.println(read("Main_File.txt"));
        }
        if(inp.equals("remove")) {
        	System.out.print("location:");
        	String locationf=input.nextLine();
        	File filed=new File(locationf);
            File ms=new File("Main_File.txt");
			FileWriter mswr=new FileWriter(ms);
			String earltext=read("Main_File.txt");
			mswr.write(earltext + "\n" + filed.getName() + " " +  filed.getAbsolutePath() + " " + filed.length() + " " + time() + " " + " attempted to delete the file");
            if(filed.delete()==true) {
            	System.out.println(filed.getName() + " has been successfully deleted.");
            }
            else {
            	System.out.println(filed.getName() + "can't be deleted for some reason.");
            }
            filed=null;
        }
		if(inp.equals("showalpha")){
			System.out.print("Location:");
			Scanner inpfile=new Scanner(System.in);
			String lmao_loc=inpfile.nextLine();
			String[] f_ar=alphaf(new File(lmao_loc));
			System.out.println("-------------------------------------");
			System.out.println(" ");
			System.out.println(" ");
			for(int x=f_ar.length;x>=0;x--){
				System.out.println(x + ". " + f_ar[x]);
			}
			System.out.println(" ");
			System.out.println(" ");
			System.out.println("-------------------------------------");
		}
        if(inp.equals("exists")){
        	System.out.print("Location:");
        	String loc=input.nextLine();
        	File f=new File(loc);
			File fd=new File("Main_File.txt");
			FileWriter fdwr=new FileWriter(fd);
			fdwr.write(read("Main_File.txt") + "\n " + f.getName() + " " + f.getAbsolutePath() + " " + f.length() + " " + time() + " " + "checked if the file exists");
        	if(f.exists()==true) {
        		System.out.println("The file does exist.");
        	}
        	else {
        		System.out.println("The file does not exist.");
        	}
        	f=null;
        }
        if(inp.equals("restart")) {
        	System.out.println("Shutting down.");
        	Thread.sleep(4000);
        	System.out.println("\r\n"
        			+ "████████████████████████████████████████████████████████████████████████████████████████\r\n"
        			+ "█░░░░░░░░░░░░░░█░░░░░░░░░░░░░░█░░░░░░██████████░░░░░░█░░░░░░░░░░░░░░█░░░░░░░░██░░░░░░░░█\r\n"
        			+ "█░░▄▀▄▀▄▀▄▀▄▀░░█░░▄▀▄▀▄▀▄▀▄▀░░█░░▄▀░░░░░░░░░░░░░░▄▀░░█░░▄▀▄▀▄▀▄▀▄▀░░█░░▄▀▄▀░░██░░▄▀▄▀░░█\r\n"
        			+ "█░░▄▀░░░░░░░░░░█░░▄▀░░░░░░▄▀░░█░░▄▀▄▀▄▀▄▀▄▀▄▀▄▀▄▀▄▀░░█░░▄▀░░░░░░░░░░█░░░░▄▀░░██░░▄▀░░░░█\r\n"
        			+ "█░░▄▀░░█████████░░▄▀░░██░░▄▀░░█░░▄▀░░░░░░▄▀░░░░░░▄▀░░█░░▄▀░░███████████░░▄▀▄▀░░▄▀▄▀░░███\r\n"
        			+ "█░░▄▀░░░░░░░░░░█░░▄▀░░░░░░▄▀░░█░░▄▀░░██░░▄▀░░██░░▄▀░░█░░▄▀░░░░░░░░░░███░░░░▄▀▄▀▄▀░░░░███\r\n"
        			+ "█░░▄▀▄▀▄▀▄▀▄▀░░█░░▄▀▄▀▄▀▄▀▄▀░░█░░▄▀░░██░░▄▀░░██░░▄▀░░█░░▄▀▄▀▄▀▄▀▄▀░░█████░░▄▀▄▀▄▀░░█████\r\n"
        			+ "█░░░░░░░░░░▄▀░░█░░▄▀░░░░░░▄▀░░█░░▄▀░░██░░░░░░██░░▄▀░░█░░▄▀░░░░░░░░░░███░░░░▄▀▄▀▄▀░░░░███\r\n"
        			+ "█████████░░▄▀░░█░░▄▀░░██░░▄▀░░█░░▄▀░░██████████░░▄▀░░█░░▄▀░░███████████░░▄▀▄▀░░▄▀▄▀░░███\r\n"
        			+ "█░░░░░░░░░░▄▀░░█░░▄▀░░██░░▄▀░░█░░▄▀░░██████████░░▄▀░░█░░▄▀░░░░░░░░░░█░░░░▄▀░░██░░▄▀░░░░█\r\n"
        			+ "█░░▄▀▄▀▄▀▄▀▄▀░░█░░▄▀░░██░░▄▀░░█░░▄▀░░██████████░░▄▀░░█░░▄▀▄▀▄▀▄▀▄▀░░█░░▄▀▄▀░░██░░▄▀▄▀░░█\r\n"
        			+ "█░░░░░░░░░░░░░░█░░░░░░██░░░░░░█░░░░░░██████████░░░░░░█░░░░░░░░░░░░░░█░░░░░░░░██░░░░░░░░█\r\n"
        			+ "████████████████████████████████████████████████████████████████████████████████████████");
        	System.out.println("Samex 3.4 2021. Type help for a list of commands.");
        }
	}
	catch(Exception error){
		System.out.println("Error.");
		playSound("error.wav");
	}
  }
  public static void main(String[] args) throws IOException, InterruptedException, Exception{
	  System.out.println("You are supposed to run Samex.java,some features may break, running..");
      run("Main_File.txt");
  }
 }