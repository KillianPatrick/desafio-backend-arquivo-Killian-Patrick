package Classes;

import lombok.*;



@Data
@Builder
@With
@AllArgsConstructor
@NoArgsConstructor

public class Salesman {

    private Long id;
    private Long cpf;
    private String name;
    private Double salary;
    public Double totalProfits;

    public void salesmanSave(String s){
        String dataString;
        setTotalProfits(Double.valueOf(0));

        dataString = getDataString(s);
        setId(Long.parseLong(dataString));
        s = s.replace(dataString + "ç", "");

        dataString = getDataString(s);
        setCpf(Long.parseLong(dataString));
        s = s.replace(dataString + "ç", "");

        dataString = getDataString(s);
        setName(dataString);
        s = s.replace(dataString + "ç", "");

        dataString = getDataString(s);
        setSalary(Double.parseDouble(dataString));
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
