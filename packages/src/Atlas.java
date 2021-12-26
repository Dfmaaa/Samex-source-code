import java.util.Scanner;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.io.InputStream;
public class Atlas {
	public static void downloadFile(URL url, String fileName) throws Exception {
        try (InputStream in = url.openStream()) {
            Files.copy(in, Paths.get(fileName));
        }
    }
	//returns the number of countries that start with a letter.
        static int numCont(char x) throws IOException{
		File f=new File("all_countries.txt");
		int counter=0;
		try (FileReader fileStream = new FileReader(f);
                BufferedReader bufferedReader = new BufferedReader(fileStream)) {
               String line = null;
               
               while ((line = bufferedReader.readLine())!= null) {
              	 if(line.toLowerCase().charAt(0)==x){
              		 counter++;
              	 }
  	   }   
        }
		return counter;
	}
        //below method returns a boolean value, it will return true if the all the countries starting with a letter have finished, false if some countries are still there.
	static boolean more(char f, int num) throws IOException {
		if(numCont(f)-num==0) {
			return true;
		}
		else {
			return false;
		}
	}
	//below method checks if a country is real.
	static boolean exist(String a) throws IOException{
		File f=new File("all_countries.txt");
	    int counter=0;
		try (FileReader fileStream = new FileReader(f);
                BufferedReader bufferedReader = new BufferedReader(fileStream)) {
               String line = null;
               while ((line = bufferedReader.readLine())!= null) {
              	 if(line.toLowerCase().equals(a)){
              		 counter++;
              		 break;
              	 }
  	   }   
        }
		if(counter>0){
			return true;
		}
		else {
			return false;
		}
	}
	//below method converts a string array to a string
	static String conv(String[] a){
		String result="";
		for(int x=0;x<=a.length-1;x++){
			result=result+a[x];
		}
		return result;
	}
	//below method removes all the blank charaters from the country
	static String NoSpace(String word){
		String[] med=word.split(" ");
		String word_final=conv(med);
		return word_final;
	}
	//the method below checks if the country has been used before.
    static boolean IfExist(String[] a,String val,int till) {
    	int True_count=0;
    	for(int x=0;x<=till;x++){
    		if(a[x].equals(val)){
    			True_count++;
    		}
    	}
    	if(True_count>0) {
    		return true;
    	}
    	else {
    		return false;
    	}
    }
    //main method
	public static void mthod() throws IOException, Exception {
		if(new File("all_countries.txt").exists()==false){
		 System.out.println("Installing file with all the countries ");
         downloadFile(new URL("https://samexmain.github.io/all_countries.txt"), "all_countries.txt");
		 System.out.println("all_countries.txt successfully installed.\n");
		}
		Scanner input=new Scanner(System.in);
		Scanner input_1=new Scanner(System.in);
		Scanner input_2=new Scanner(System.in);
		int player_move=0;
		System.out.println("How many players?");
		int how_many=input_1.nextInt();
		String[] players=new String[how_many];
		int[] score=new int[how_many];
		for(int x=0;x<=how_many-1;x++){
			System.out.print("Player " + (x+1) + ':');
			players[x]=input_2.nextLine();
			score[x]=0;
		}
		System.out.println("Enter Countries! Type show_countries to see all the countries you have inserted!");
		int a_counter=0;
		int b_counter=0;
		int c_counter=0;
		int d_counter=0;
		int e_Counter=0;
		int f_counter=0;
		int g_counter=0;
		int h_counter=0;
		int i_counter=0;
		int j_counter=0;
		int k_counter=0;
		int l_counter=0;
		int m_counter=0;
		int n_counter=0;
		int o_counter=0;
		int p_counter=0;
		int q_counter=0;
		int r_counter=0;
		int s_counter=0;
		int t_counter=0;
		int u_counter=0;
		int v_Counter=0;
		int x_counter=0;
		int y_counter=0;
		int z_Counter=0;
		String[] a=new String[195];
		String[] countries=new String[195];
		int show_count=a.length;//taking the length of the array.
		int counter=0;
		for(int x=0;x<=a.length-1;x++) {
			a[x]="nothing";//filling the array
		}
		try {
		while(true){
			if(player_move==how_many) {
				player_move=0;
			}
			System.out.print(players[player_move] + ':');
			String country=input.nextLine().toLowerCase();
			char c=country.charAt(0);
			String country_Without_Space=NoSpace(country);
			//incrementing integer variables if a specific letter is used.
			switch(c){
			case 'a':
				a_counter++;
				break;
			case 'b':
				b_counter++;
				break;
			case 'c':
				c_counter++;
				break;
			case 'd':
				d_counter++;
				break;
			case 'e':
				e_Counter++;
				break;
			case 'f':
				f_counter++;
				break;
			case 'g':
				g_counter++;
				break;
			case 'h':
				h_counter++;
				break;
			case 'i':
				i_counter++;
				break;
			case 'j':
				j_counter++;
				break;
			case 'k':
				k_counter++;
				break;
			case 'l':
				l_counter++;
				break;
			case 'm':
				m_counter++;
			case 'n':
				n_counter++;
				break;
			case 'o':
				o_counter++;
				break;
			case 'p':
				p_counter++;
				break;
			case 'q':
				q_counter++;
				break;
			case 'r':
				r_counter++;
				break;
			case 's':
				s_counter++;
				break;
			case 't':
				t_counter++;
				break;
			case 'u':
				u_counter++;
				break;
			case 'x':
				x_counter++;
				break;
			case 'y':
				y_counter++;
				break;
			case 'z':
				z_Counter++;
				break;
			}
			if(counter==0&exist(country)==true&country.equals("show_countries")==false) {
				System.out.println("Country successfully used!");
				a[counter]=country_Without_Space;
				countries[counter]=country;
				counter++;
				show_count-=1;
				System.out.println(show_count + " entries left.");
				System.out.println(counter + " country inserted.");
				player_move++;
			}
			
		   if(IfExist(a,country_Without_Space,counter)==true&country.equals("show_countries")==false&exist(country)==true&counter>1){
				System.out.println("That country has been used. Enter a country again.");
			}
			if(exist(country)==false&country.equals("show_countries")==false){
				System.out.println("The country does not exist.");
			}
			if(counter>=1&country.charAt(0)!=countries[counter-1].charAt(countries[counter-1].length()-1)) {
				System.out.println("Country should start with " +countries[counter-1].charAt(countries[counter-1].length()-1));
			}
			if(IfExist(a,country_Without_Space,counter)==false&country.equals("show_countries")==false&exist(country)==true&country.charAt(0)==countries[counter-1].charAt(countries[counter-1].length()-1)&counter!=0){
				System.out.println("Country successfully used!");
				a[counter]=country_Without_Space;
				countries[counter]=country;
				counter++;
				show_count-=1;
				System.out.println(show_count + " entries left.");
				player_move++;
				if(counter==1) {
					System.out.println(counter + " country inserted.");
				}
				if(counter!=1) {
				System.out.println(counter + " countries inserted.");
				}
				if(c=='a'&more('a',a_counter)==true) {
					System.out.println("The countries starting with a have finished..");
				}
				if(c=='b'&more('b',b_counter)==true) {
					System.out.println("The countries starting with b have finished..");
				}
				if(c=='c'&more('c',c_counter)==true) {
					System.out.println("The countries starting with c have finished..");
				}
				if(c=='d'&more('d',d_counter)==true) {
					System.out.println("The countries starting with d have finished..");
				}
				if(c=='e'&more('e',e_Counter)==true) {
					System.out.println("The countries starting with e have finished..");
				}
				if(c=='f'&more('f',f_counter)==true) {
					System.out.println("The countries starting with f have finished..");
				}
				if(c=='g'&more('g',g_counter)==true) {
					System.out.println("The countries starting with g have finished..");
				}
				if(c=='h'&more('h',h_counter)==true) {
					System.out.println("The countries starting with h have finished..");
				}
				if(c=='i'&more('i',i_counter)==true) {
					System.out.println("The countries starting with i have finished..");
				}
				if(c=='j'&more('j',j_counter)==true) {
					System.out.println("The countries starting with j have finished..");
				}
				if(c=='k'&more('k',k_counter)==true) {
					System.out.println("The countries starting with k have finished..");
				}
				if(c=='l'&more('l',l_counter)==true) {
					System.out.println("The countries starting with l have finished..");
				}
				if(c=='m'&more('m',m_counter)==true) {
					System.out.println("The countries starting with m have finished..");
				}
				if(c=='n'&more('n',n_counter)==true) {
					System.out.println("The countries starting with inhave finished..");
				}
				if(c=='o'&more('o',o_counter)==true) {
					System.out.println("The countries starting with o have finished..");
				}
				if(c=='p'&more('p',p_counter)==true) {
					System.out.println("The countries starting with p have finished..");
				}
				if(c=='q'&more('q',q_counter)==true) {
					System.out.println("The countries starting with q have finished..");
				}
				if(c=='r'&more('r',r_counter)==true) {
					System.out.println("The countries starting with r have finished..");
				}
				if(c=='s'&more('s',s_counter)==true) {
					System.out.println("The countries starting with s have finished..");
				}
				if(c=='t'&more('t',t_counter)==true) {
					System.out.println("The countries starting with t have finished..");
				}
				if(c=='u'&more('u',u_counter)==true) {
					System.out.println("The countries starting with u have finished..");
				}
				if(c=='v'&more('v',v_Counter)==true) {
					System.out.println("The countries starting with v have finished..");
				}
				if(c=='x'&more('x',x_counter)==true) {
					System.out.println("The countries starting with x have finished..");
				}
				if(c=='y'&more('y',y_counter)==true) {
					System.out.println("The countries starting with y have finished..");
				}
				if(c=='z'&more('z',z_Counter)==true) {
					System.out.println("The countries starting with z have finished..");
				}
			}
			
			if(country.equals("show_countries")&counter!=0) {
				System.out.println("Showing...");
				System.out.println(" ");
				for(int x=0;x<=counter-1;x++) {
					System.out.println(countries[x]);
				}
			}
			if(country.equals("show_countries")&counter==0){
				System.out.println("You haven't inserted any countries yet.");
			}
		}
		}
		catch(Exception NoSuchElementException){
			System.out.println("Game successfully stopped!");
		}
	}
	public static void main(String[] args) throws IOException, Exception{
		mthod();
	}
	}
