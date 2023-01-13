import java.util.ArrayList;

public class Operation {

    double [] number=new double[30];

    public String calculate(String all_data){
        String result="";
        ArrayList<String> row_value=new ArrayList<>();
        String data="";
        System.out.println(all_data);

for(char c:all_data.toCharArray()){

    if(new HandleInput().isOpr(""+c)){


        row_value.add(data);
        row_value.add(""+c);
        data="";
    }else {
        data+=c;
    }

}
row_value.add(data);



row_value=dsolve(row_value);
row_value=mpsolve(row_value);

int ix=0;
for(String ss:row_value){

if(ss.equals("NaN")||ss.equals("Infinity")){
   result="NaN or Infinity value Entered";
}
    System.out.print(ss);
if(ix==0){
  if(ss.equals(""))row_value.set(0,"-");}
ix++;
}

if(result.equals("")){
      result=""+  plusMinusFilter(row_value);
}
return result;
    }

public ArrayList<String> dsolve(ArrayList<String> value ){
    int index=0;
    ArrayList<String> result=new ArrayList<>();
    int asize= value.size();;
    for (int i=0;i<asize;i++){
        if(value.get(i).equals("/")){
            Double d1=Double.parseDouble(value.get(index-1).trim());
            Double d2=Double.parseDouble(value.get(index+1).trim());
            value.set(index,null);
            value.set(index-1,null);
            value.set(index+1,""+(d1/d2));
            System.out.println(value.get(index+1));
        }
        index++;//10/3
     
    }
    for(String v:value){
        if(v!=null)
        result.add(v);
    }

    return result;
}



    public ArrayList<String> mpsolve(ArrayList<String> value ){
        int index=0;
        ArrayList<String> result=new ArrayList<>();
        int asize= value.size();;
        for (int i=0;i<asize;i++){
            if(value.get(i).equals("*")){
                Double d1=Double.parseDouble(value.get(index-1).trim());
                Double d2=Double.parseDouble(value.get(index+1).trim());
                value.set(index,null);
                value.set(index-1,null);
                value.set(index+1,""+(d1*d2));
                System.out.println(value.get(index+1));
            }
            index++;
        }

        for(String v:value){
            if(v!=null)
                result.add(v);
        }
        return result;
    }


    public float plusMinusFilter(ArrayList<String > str){
        String mark="+";

        float plsCount=0f;
        float minusCount=0f;
int index=0;
        for(String p_or_m:str){

            if(p_or_m.equals("+")||p_or_m.equals("-")){
             mark=p_or_m;
            }else {

                if(mark.equals("+")){
                   plsCount+=Float.parseFloat(p_or_m) ;
                }

                if(mark.equals("-"))
                {
                    minusCount+=Float.parseFloat(p_or_m) ;
                }
            }
index++;
        }
        return (plsCount-minusCount);
    }
}
