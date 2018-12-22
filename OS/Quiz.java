package OS;

import java.util.*;
import java.io.*;

public class Quiz{

    public static void main(String[] args)
    { 
        String csvFile = "Quiz.csv";
        BufferedReader br = null;
        String line = "";
        String cvsSplitBy = ",";

        Map<String, List<String>> qm = new HashMap<String, List<String>>();

        try {
            br = new BufferedReader(new FileReader(csvFile));
            int counter =0;
            while ((line = br.readLine()) != null) {

                // use comma as separator
                String[] data = line.split(cvsSplitBy);

                List<String> values = new ArrayList<String>();
                String qs=(String)data[0];
                values.add(qs.replaceAll("^\"|\"$", ""));
                for(int i=1;i<=data.length-1;i++){
                    String ds=(String)data[i];
                    values.add(ds.replaceAll("^\"|\"$", ""));
                }
                qm.put("Q"+counter, values);
                counter++;

            }
            int score=0;
            int qnum=0;
            HashMap hmk = new HashMap();
            String qkey = "";
            System.out.println("Welcome to Quiz. Enter the answer as A/B/C/D. Good Luck!");
            System.out.println("Press Q to quit");
            for(int j=1;j<=15;j++)
            {
                qnum=(int)(Math.random()*100);
                qkey = "Q"+qnum;
                if(!hmk.containsKey(qkey)) {
                    hmk.put(qkey,"Question"+qkey);
                } else {
                    j--;
                    continue;
                }

                List arr= qm.get(qkey);
                String ch="";

                if(arr!=null )
                {

                    System.out.println("Round :"+j);
                    for (int i=0; i <= arr.size()-2; i++)
                        System.out.println(arr.get(i));

                    for(;;){
                        System.out.println("Enter your option:");
                        Scanner sc=new Scanner(System.in);
                        ch=sc.nextLine();
                        if(ch.equalsIgnoreCase("A")||ch.equalsIgnoreCase("B")||
                        ch.equalsIgnoreCase("C")||ch.equalsIgnoreCase("D")){
                            break;
                        }
                        else{
                            if(ch.equalsIgnoreCase("Q")) {
                                System.out.println("You Gave Up :(");
                                System.exit(0);
                            }
                            System.out.println("Enter A,B,C,D only");
                            continue;
                        }
                    }
                    String akey= (String)arr.get(5);

                    if((akey.trim()).equalsIgnoreCase(ch.trim())){
                        System.out.println("Correct Answer! ");
                        score++;
                    }else {
                        System.out.println("Incorrect!     ---   Correct Answer  : "+arr.get(5));
                    }
                } else{ j--;}
            }
            System.out.println("Your Final score : "+score);


        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

        }

    }}
