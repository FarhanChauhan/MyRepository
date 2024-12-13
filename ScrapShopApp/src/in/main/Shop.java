package in.main;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.time.LocalDate;
import java.util.Properties;
import java.util.Scanner;

public class Shop{

	private Float quantity=0.0f;
	private String productName="";
	private String printBill="";
	
	public Float getQuantity() {
		return quantity;
	}
	public void setQuantity(Float quantity) {
		this.quantity = quantity;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public Shop(Float quantity, String productName) {
		super();
		this.quantity = quantity;
		this.productName = productName;
	}
	
	public Shop(String name) throws FileNotFoundException  {		
		// TODO Auto-generated constructor stub
		
		Scanner sc= new Scanner(System.in);
		Float bill=0.0f;
		Float result=0.0f;
		FileReader reader =new FileReader("Materials.properties");
		Properties prop =new Properties();
		try {
			prop.load(reader);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    
        while(true) {
        	try {
        	   System.out.println("PRODUCT NAME : ");
               productName =sc.next();
        	}catch(Exception e) {
        		continue;
        	}
        	try {
               System.out.println("QUANTITY : ");
               quantity = sc.nextFloat();
        	}catch(Exception e) {
        		System.out.println("Wrong Input ....please try later");
        		System.out.println("######## Start Application Again ########");
        	}
 
       		if(productName.equalsIgnoreCase("pu")) {
       			if(name.contains("hannu")||name.contains("juned")) {
       				result=quantity*(Integer.parseInt(prop.getProperty("puttha"))+1);
       			}else if(name.isBlank()) {
       				result=quantity*(Integer.parseInt(prop.getProperty("puttha"))-1);      				
       			}else {
       				result=quantity*Integer.parseInt(prop.getProperty("puttha"));
       			}
				System.out.println("Puttha  "+quantity+ " kg   = "+result );
				printBill =printBill.concat("Puttha     "+quantity+ " kg   = "+result+"\n") ;
    		}
       		else if(productName.equalsIgnoreCase("rn")) {
       			if(name.contains("hannu")||name.contains("juned")) {
       				result=quantity*(Integer.parseInt(prop.getProperty("rangeen"))+1);
       			}else {
       				result=quantity*Integer.parseInt(prop.getProperty("rangeen")); 				
       			}
       			System.out.println("Rangeen  "+quantity+ " kg   = "+result );
       			printBill = printBill.concat("Rangeenn     "+quantity+ " kg   = "+result+"\n") ;
       		}
    		else if(productName.equalsIgnoreCase("ph")) {
    			result=quantity*Integer.parseInt(prop.getProperty("phugga"));
				System.out.println("Phugga  "+quantity+ " kg   = "+result );
				printBill = printBill.concat("Phugga     "+quantity+ " kg   = "+result+"\n") ;
    		}
    		else if(productName.equalsIgnoreCase("Ra")) {
    			result=quantity*Integer.parseInt(prop.getProperty("pustak"));
				System.out.println("Raddi  "+quantity+ " kg   = "+result );
				printBill = printBill.concat("Raddi     "+quantity+ " kg   = "+result+"\n") ;
    		}
    		else if(productName.equalsIgnoreCase("Ta")) {
    			result=quantity*Integer.parseInt(prop.getProperty("tapre"));
				System.out.println("Tapre  "+quantity+ " kg   = "+result );
				printBill =printBill.concat("Tapre     "+quantity+ " kg   = "+result+"\n") ;
    		}
    		else if(productName.equalsIgnoreCase("Bh")) {
    			result=quantity*Integer.parseInt(prop.getProperty("bhangar"));
				System.out.println("Bhangar  "+quantity+ " kg   = "+result );
				printBill =printBill.concat("Bhangar     "+quantity+ " kg   = "+result+"\n") ;
    		}
    		else if(productName.equalsIgnoreCase("Co")) {
    			result=quantity*Integer.parseInt(prop.getProperty("tamba"));
    			System.out.println("Tamba  "+quantity+ " kg   = "+result );
    			printBill =printBill.concat("Tamba     "+quantity+ " kg   = "+result+"\n") ;
    		}
    		else if(productName.equalsIgnoreCase("Ja")) {
    			result=quantity*Integer.parseInt(prop.getProperty("jarman"));
				System.out.println("Jarman  "+quantity+ " kg   = "+result );
				printBill =printBill.concat("Jarman     "+quantity+ " kg   = "+result+"\n") ;
    		}
    		else if(productName.equalsIgnoreCase("Pi")) {
    			result=quantity*Integer.parseInt(prop.getProperty("pital"));
				System.out.println("Pital  "+quantity+ " kg   = "+result );
				printBill =printBill.concat("Pital     "+quantity+ " kg   = "+result+"\n") ;
    		}
    		else if(productName.equalsIgnoreCase("St")) {
    			result=quantity*Integer.parseInt(prop.getProperty("steel"));
				System.out.println("Steel  "+quantity+ " kg   = "+result );
				printBill =printBill.concat("Steel     "+quantity+ " kg   = "+result+"\n") ;
    		}
    		else if(productName.equalsIgnoreCase("Go")) {
    			result=quantity*Integer.parseInt(prop.getProperty("gota"));
				System.out.println("Gota  "+quantity+ " kg   = "+result );
				printBill =printBill.concat("Gota     "+quantity+ " kg   = "+result+"\n") ;
    		}
    		else if(productName.equalsIgnoreCase("Na")) {
    			result=quantity*Integer.parseInt(prop.getProperty("nalli"));
				System.out.println("Nalli  "+quantity+ " kg   = "+result);
				printBill =printBill.concat("Nalli     "+quantity+ " kg   = "+result+"\n") ;
    		}
    		else if(productName.equalsIgnoreCase("Sl")) {
    			result=quantity*Integer.parseInt(prop.getProperty("saline"));
    			System.out.println("Saline  "+quantity+ " kg   = "+result );
    			printBill =printBill.concat("Saline     "+quantity+ " kg   = "+result+"\n") ;
    		}
    		else if(productName.equalsIgnoreCase("OSl")) {
    			result=quantity*Integer.parseInt(prop.getProperty("ogSaline"));
    			System.out.println("OG Saline  "+quantity+ " kg   = "+result );
    			printBill =printBill.concat("OG Saline     "+quantity+ " kg   = "+result+"\n") ;
    		}
    		else if(productName.equalsIgnoreCase("Ct")) {
    			result=quantity*Integer.parseInt(prop.getProperty("chhotaTyre"));
    			System.out.println("Chhote Tyre  "+quantity+ " kg   = "+result );
    			printBill =printBill.concat("Chhote Tyre     "+quantity+ " kg   = "+result+"\n") ;
    		}
    		else if(productName.equalsIgnoreCase("Bl")) {
    			result=quantity*Integer.parseInt(prop.getProperty("blue"));
				System.out.println("Blue  "+quantity+ " kg   = "+result );
				printBill =printBill.concat("Blue     "+quantity+ " kg   = "+result+"\n") ;
    		}
    		else if(productName.equalsIgnoreCase("Bo")) {
    			result=quantity*Integer.parseInt(prop.getProperty("booch"));
				System.out.println("Booch  "+quantity+ " kg   = "+result );
				printBill =printBill.concat("Booch     "+quantity+ " kg   = "+result+"\n") ;
    		}
    		else if(productName.equalsIgnoreCase("Ar")) {
    			result=quantity*Integer.parseInt(prop.getProperty("armiture"));
				System.out.println("Armiture  "+quantity+ " kg   = "+result );
				printBill =printBill.concat("Armiture     "+quantity+ " kg   = "+result+"\n") ;
    		}
    		else if(productName.equalsIgnoreCase("Li")) {
    			result=quantity*Integer.parseInt(prop.getProperty("liner"));
				System.out.println("Liner  "+quantity+ " kg   = "+result );
				printBill =printBill.concat("Liner     "+quantity+ " kg   = "+result+"\n") ;
    		}
    		else if(productName.equalsIgnoreCase("Sn")) {
    			result=quantity*Integer.parseInt(prop.getProperty("syntax"));
    			System.out.println("Syntax  "+quantity+ " kg   = "+result );
    			printBill =printBill.concat("Syntax     "+quantity+ " kg   = "+result+"\n") ;
    		}
    		else if(productName.equalsIgnoreCase("Ka")) {
    			result=quantity*Integer.parseInt(prop.getProperty("kaala"));
    			System.out.println("Kaala  "+quantity+ " kg   = "+result );
    			printBill =printBill.concat("Kaala     "+quantity+ " kg   = "+result+"\n") ;
    		}
    		else if(productName.equalsIgnoreCase("Pk")) {
    			result=quantity*Integer.parseInt(prop.getProperty("paaniKadak"));
    			System.out.println("Paani Kadak  "+quantity+ " kg   = "+result );
    			printBill =printBill.concat("Paani Kadak     "+quantity+ " kg   = "+result+"\n") ;
    		}
    		else if(productName.equalsIgnoreCase("Bt")) {
    			result=quantity*Integer.parseInt(prop.getProperty("badaTyre"));
    			System.out.println("Bada Tyre  "+quantity+ " kg   = "+result );
    			printBill =printBill.concat("Bada Tyre     "+quantity+ " kg   = "+result+"\n") ;
    		}
    		else if(productName.equalsIgnoreCase("Ju")) {
    			result=quantity*Integer.parseInt(prop.getProperty("jute"));
    			System.out.println("Jute  "+quantity+ " kg   = "+result );
    			printBill =printBill.concat("Jute     "+quantity+ " kg   = "+result+"\n") ;
    		}
    		else if(productName.equalsIgnoreCase("Ca")) {
    			result=quantity*Integer.parseInt(prop.getProperty("cashting"));
    			System.out.println("Cashting  "+quantity+ " kg   = "+result );
    			printBill =printBill.concat("Cashting     "+quantity+ " kg   = "+result+"\n") ;
    		}
    		else {
    			System.out.println("######## Invalid Product Code ########");
    			System.out.println(" Enter product from above list only ......");
    			continue;
    		}

    		bill=bill+result;

    		System.out.println();
    		System.out.println("1. Add Product");
            System.out.println("2. Generate Bill");
       
            
            if(sc.nextInt()==2) {
            	System.out.println("----------------------------------------------");
               	System.out.println("**********Your Bill is Generating*************");
            	System.out.println("----------------------------------------------");
            	System.out.println("Name : "+name+"        "+LocalDate.now());
            	System.out.println("----------------------------------------------");
            	System.out.println(printBill);
            	System.out.println("----------------------------------------------");
            	System.out.println("Total           "+bill+" rs");
            	System.out.println("----------------------------------------------");
            	try {
            		String filename = "D:\\Shop\\bills.txt";
            		FileWriter fw = new FileWriter(filename,true);
            		fw.write(name+"         "+LocalDate.now()+"\n------------------------------\n");
            		fw.write(printBill+"---------------------------------\n");
            		fw.write("Total               "+bill+" rs ");
            		fw.write("\n-----------------------------------\n\n");
            		fw.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
            	System.out.println("****************Thank You*********************");
            	break;
            }
        }
	}

	}
	class Test{
		public static void main(String[] args) throws FileNotFoundException {
    		
    		// TODO Auto-generated method stub
    	
    		
    		  System.out.println("---------------------------------------------------------------------------------------------------");
    	      System.out.println("************************************** MARIYA PLASTIC ********************************************");
    	      System.out.println("---------------------------------------------------------------------------------------------------");
    	      System.out.println("Puttha = Pu   Phugga = Ph    Raddi = Ra   Tapre = Ta  	 Bhangar = Bh      Rangeen = Rn");
    	      System.out.println("Nalli = Na    Saline = Sl    Blue = Bl    Booch = Bo       Armiture = Ar     PaniKadak = Pk ");
    	      System.out.println("Syntax = Sn   Kaala = Ka     Jute = Ju    OGSaline = OSl   ChhotaTyre = Ct   BadaTyre = Bt   ");
    	      System.out.println("Tamba = Co    Jarman = Ja    Pital = Pi   Steel = St 	   Gota = Go    Liner = Li    Cashting = Ca");
    	      System.out.println("----------------------------------------------------------------------------------------------------");

    	      System.out.println();
    	      
    		  	Scanner sc= new Scanner(System.in);
    	        
    	        System.out.println("ENTER NAME : ");
    	        String name = sc.nextLine();
    	        
    	        Shop s = new Shop(name);
    	
    	  	}

	}


