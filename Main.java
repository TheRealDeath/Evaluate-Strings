import java.util.*;

public class Main 
{
  public static void main(String[] args) 
  {
    Scanner myScanner = new Scanner(System.in);
    int s = myScanner.nextInt();
    myScanner.nextLine();
    for(int i = 0;i<s;i++)
    {
      double l = 0;
      String str = myScanner.nextLine();
      String[] myArray2 = str.split("=");
    	if(myArray2[0].length() > myArray2[1].length())
      {
        l = eval(myArray2[0]);
        System.out.println(l == Integer.parseInt(myArray2[1].trim()));
      }
      else
      {
        l = eval(myArray2[1]);
        System.out.println(l == Integer.parseInt(myArray2[0].trim()));
      }
            
    }
    myScanner.close();
  }
  public static double eval(String s)
  {
    s = s.trim();
    try
    {
			ArrayList<String> myList = new ArrayList<>();
      String str = "";
      s = (((s.replace("*","*a*")).replace("/", "/b/")).replace("-","-c-")).replace("+","+d+");
      String[] myArray = s.split("[-*+/]");
      int j = 0;
      for(int i = 0;i<myArray.length;i++)
      {
        if(myArray[i].equals("a"))
          myList.add((Double.parseDouble(myArray[i-1])*Double.parseDouble(myArray[i+1]))+"");
        else if(myArray[i].equals("b"))
          myList.add(((Double.parseDouble(myArray[i-1]))/Double.parseDouble(myArray[i+1]))+"");
        if(myArray[i].equals("a"))
          myArray[i+1] = myList.get(j++);
        else if(myArray[i].equals("b"))
          myArray[i+1] = myList.get(j++);
      }
      for(int i = 0;i<myArray.length;i++)
      {
        if(myArray[i].equals("c") && myArray.length >= 2)
          myList.add((Double.parseDouble(myArray[i-1])-Double.parseDouble(myArray[i+1]))+"");
        else if(myArray[i].equals("d") && myArray.length >= 2)
          myList.add(((Double.parseDouble(myArray[i-1]))+Double.parseDouble(myArray[i+1]))+"");
        if(myArray[i].equals("c") && myArray.length >= 2)
          myArray[i+1] = myList.get(j++);
        else if(myArray[i].equals("d") && myArray.length >= 2)
          myArray[i+1] = myList.get(j++);
      }
    	return (Double.parseDouble(myArray[myArray.length-1]));
    } catch(Exception e){}
    return 0;
  }
}