package Classes;

import lombok.*;

@Data
@Builder
@With
@AllArgsConstructor
@NoArgsConstructor

public class Client {

    private Long id;
    private Long cnpj;
    private String name;
    private String businessArea;

    public void clientSave(String s){
        String dataString;

        dataString = getDataString(s);
        setId(Long.parseLong(dataString));
        s = s.replace(dataString + "ç", "");

        dataString = getDataString(s);
        setCnpj(Long.parseLong(dataString));
        s = s.replace(dataString + "ç", "");

        dataString = getDataString(s);
        setName(dataString);
        s = s.replace(dataString + "ç", "");

        dataString = getDataString(s);
        setBusinessArea(dataString);
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
