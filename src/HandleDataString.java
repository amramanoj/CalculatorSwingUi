public class HandleDataString {
    public String dataString(String allData,String clickData){
        if(allData.equals("0")){allData="";}
        if(allData.indexOf(".")!=-1&&clickData.equals(".")){

            clickData="";

        }
        if(allData.length()>0){


            char last_all=allData.charAt(allData.length()-1);
            if((!new Calculator().isNum(""+last_all)&&(!new Calculator().isNum(clickData)))){clickData="";}

        }else {
            if(!new Calculator().isNum(clickData)){clickData=""; allData="0";}
        }
        allData+=clickData;
        return allData;

    }
}
