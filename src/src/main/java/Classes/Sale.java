package Classes;

import lombok.*;

import java.util.ArrayList;
import java.util.List;



@Data
@Builder
@With
@AllArgsConstructor
@NoArgsConstructor

public class Sale {

    private Long id;
    private Long saleId;
    private List<Item> itemList=  new ArrayList<Item>();
    private String salesmanName;

    public void saleSave(String s){
        String dataString;
        String dataStringList;
        String dataStringItem;
        int MkList = 0;

        dataString = getDataString(s);
        setId(Long.parseLong(dataString));
        s = s.replace(dataString + "ç", "");

        dataString = getDataString(s);
        setSaleId(Long.parseLong(dataString));
        s = s.replace(dataString + "ç", "");

        dataString = getDataString(s);
        if(s.indexOf("ç") > s.indexOf("[")){
            dataStringList = s.substring(dataString.indexOf("[")+1, dataString.indexOf("]"));
            while(!dataStringList.equals("")){
                Item itemSaved = new Item();
                dataStringItem = itemSaved.getDataStringItem(dataStringList);
                itemSaved.itemSave(dataStringItem);
                if(dataStringList.contains(",")) {
                    dataStringList = dataStringList.replace(dataStringItem + ",", "");
                }else{
                    dataStringList = dataStringList.replace(dataStringItem, "");
                }
                itemList.add(MkList,itemSaved);
                MkList++;
            }
        }
        s = s.replace(dataString + "ç", "");

        dataString = getDataString(s);
        setSalesmanName(dataString);
        s = s.replace(dataString + "ç", "");
    }

    public String getDataString (String s){
        String dataString;
        Long mark;
        if(s.contains("ç")) {
            mark = Long.valueOf(s.indexOf("ç"));
            dataString = s.substring(0, mark.intValue());
            return dataString;
        }else{
            dataString = s;
            return dataString;
        }
    }
}
