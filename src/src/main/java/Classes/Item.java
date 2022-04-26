package Classes;

import lombok.*;

@Data
@Builder
@With
@AllArgsConstructor
@NoArgsConstructor
public class Item {

    private Long id;
    private Long itemQuantity;
    private Double itemPrice;

    public void itemSave(String s){
        String dataString;

        dataString = getDataString(s);
        setId(Long.parseLong(dataString));
        s = s.replace(dataString + "-", "");

        dataString = getDataString(s);
        setItemQuantity(Long.parseLong(dataString));
        s = s.replace(dataString + "-", "");

        dataString = getDataString(s);
        setItemPrice(Double.parseDouble(dataString));
        s = s.replace(dataString + "-", "");
    }

    public String getDataString (String s){
        String dataString;
        Long mark;
        if(s.contains("-")) {
            mark = Long.valueOf(s.indexOf("-"));
            dataString = s.substring(0, mark.intValue());
            return dataString;
        }else{
            dataString = s;
            return dataString;
        }
    }

    public String getDataStringItem (String s){
        String dataString;
        Long mark;
        if(s.contains(",")) {
            mark = Long.valueOf(s.indexOf(","));
            dataString = s.substring(0, mark.intValue());
            return dataString;
        }else{
            dataString = s;
            return dataString;
        }
    }

}
