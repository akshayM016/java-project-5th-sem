import java.io.*;
import java.util.*;

public class help 
{    int n = 0 , count =0;
    String vno []=new String[10];
    String name []=new String[10];
    String time []=new String[10];
    String time1 []=new String[10];
    String a = "\n";
    
    FileOutputStream f1;
    FileOutputStream f2;
  
    Scanner s = new Scanner(System.in);
    Scanner s1 = new Scanner(System.in);
    Scanner s2 = new Scanner(System.in);
    Scanner s3 = new Scanner(System.in);
    public help() throws FileNotFoundException {
        this.f1=new FileOutputStream("C:\\Users\\Akshay\\Desktop\\entry log.txt");
        this.f2 = new FileOutputStream("C:\\Users\\Akshay\\Desktop\\exit log.txt");
    }
     void display()
     {
         System.out.println("location occupied are  \n");
          for(int i=0;i<10;i++)
          {
              if(name[i]!=null)
              System.out.print("location: "+(i+1)+" NAME: "+name[i]+"\n");
          }
          if(count==0)
          System.out.println("No location occupied   \n");
        
     }
    
     void parkin() 
     {
          System.out.println("avaliabe location to park \n");
          for(int i=0;i<10;i++)
          {
              if(name[i]==null)
              System.out.print((i+1)+" \t");
          }
              
          try{
                
        System.out.println("\nenter location to park \n");
        n=s.nextInt();
        if(name[n-1]==null)
        {
        System.out.println("enter name , vehicle no , check-in time \n");
        name[n-1]=s1.nextLine();
        
        vno[n-1]=s2.nextLine();
        time[n-1]=s3.nextLine();
        byte as[]=a.getBytes();
        
        byte b[]=name[n-1].getBytes();
        f1.write(b);
        f1.write(as);
        byte b2[]=vno[n-1].getBytes();
        f1.write(b2);
        f1.write(as);
        byte b1[]=time[n-1].getBytes();
        f1.write(b1);
        f1.write(as);
        f1.write(as);
        System.out.println("vehicle sucessfully parked  \n");
        count++;
          }
        else
            System.out.println("location not avaliable\n");
     }
              catch (Exception e)
              {
                  System.out.println("INVALID LOCATION \n");
              }
     }
     void remove()
     {
         
    try {
        System.out.println("enter the  parked location \n");
       n=s.nextInt();
        
        if(name[n-1]==null)
        {
         System.out.println("No vehicle present at given location \n");  
      }
        else 
        {
        byte as[]=a.getBytes();
        byte b[]=name[n-1].getBytes();
        f2.write(b);
        f2.write(as);
        byte b2[]=vno[n-1].getBytes();
        f2.write(b2);
        f2.write(as);
        byte b1[]=time[n-1].getBytes();
        f2.write(b1);
        f2.write(as);
        f2.write(as);
        System.out.println("enter check-out time \n");
        time[n-1]=s3.nextLine();
        byte b4[]=time[n-1].getBytes();
        f2.write(b4);
        f2.write(as);
        System.out.println("parking charges 50 rs \n");
        
        System.out.println("sucessful removed vehicle\n");
        
        name[n-1]=null;
        vno[n-1]=null;
        time[n-1]= null;
        time1[n-1]= null;
        count--;
        }
    } catch (Exception e) 
    {
         System.out.println("INVALID LOCATION \n");
         
    }
     }
}

class demo 
{
    public static void main(String args []) throws IOException 
    {   help k = new help();
        System.out.println("Welcome\n");
        int ch;
        Scanner s9 = new Scanner(System.in);
        while(1!=0)
        {
            System.out.println("\n1.park vehicle\n2.remove vehicle\n3.display\n4.exit \n");
            System.out.println("enter choice \n");
            ch=s9.nextInt();
             switch(ch)
            {
                case 1: k.parkin();
                        break;
                case 2:  k.remove();
                        break;
                case 3 :k.display();
                        break;
                case 4:k.f1.close();
                       k.f2.close();
                       System.exit(0);
                default:System.out.println("enter valid choice \n");
           }
       }
    }
}

