public class HandleInput {
    public String handleAirth(String jLabel,String btndata){
       if(jLabel.equals("0")){
           jLabel="";
           if(isOpr(btndata)&&!btndata.equals("-")) {btndata=""; jLabel="0";}

       }
       else {
           String lastchar=""+jLabel.charAt(jLabel.length()-1);
           if((  lastchar.equals(".") || isOpr(lastchar))&&isOpr(btndata)){
               btndata="";
           }
       }


        int index=indexLast(jLabel);
        String dub=jLabel.substring(index);
if(dub.indexOf(".")!=-1&&btndata.equals(".")){
    btndata="";
}


      //  System.out.println(dub);
      return jLabel+btndata;
    }
    public int indexLast(String data){
        int result=-1;
        int d=data.lastIndexOf("/");
        if(d>result) result=d;
        int mp=data.lastIndexOf("*");
        if(mp>result) result=mp;
        int a=data.lastIndexOf("+");
        if(a>result) result=a;
        int mi=data.lastIndexOf("-");
        if(mi>result) result=mi;
        if(result==-1){
            result=0;
        }
        return result;

    }
    public boolean isOpr(String btndata){
        if(btndata.equals("+")||btndata.equals("-")||btndata.equals("*")||btndata.equals("/")){
          return true;
        }
    else {
        return false;
        }
    }

}
