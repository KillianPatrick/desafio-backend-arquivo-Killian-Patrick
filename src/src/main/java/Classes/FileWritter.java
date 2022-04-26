package Classes;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class FileWritter {

    public String newFilePath;

    public void writeFile (String newFilePath, List<Client> clientList, List<Salesman> salesmanList, List<Sale> sales) throws IOException {
        BufferedWriter buffWrite = new BufferedWriter(new FileWriter(String.valueOf(newFilePath)));
        buffWrite.append(countClientNumber(clientList) + "\n");
        buffWrite.append(countSalesmanNumber(salesmanList) + "\n");
        buffWrite.append(bestSaleValidade(sales) + "\n");
        buffWrite.append(worstSalesmanValidate(sales, salesmanList) + "\n");
        buffWrite.close();
    }

    public String countClientNumber (List<Client> clientList) throws IOException {
        String data = String.valueOf(clientList.size());
        data = "Numero total de clientes: " + data;
        return data;
    }

    public String countSalesmanNumber (List<Salesman> salesmanList) throws IOException {
        String data = String.valueOf(salesmanList.size());
        data = "Numero total de vendedores: " + data;
        return data;
    }

    public String bestSaleValidade (List<Sale> sales) throws IOException {
        Double saleValue = Double.valueOf(0);
        Double bestSaleValue = Double.valueOf(0);
        String bestSaleId = "";
        for(Sale sale : sales){
            for(Item item : sale.getItemList()){
                saleValue = saleValue + (item.getItemQuantity() * item.getItemPrice());
            }
            if(saleValue > bestSaleValue){
                bestSaleValue = saleValue;
                bestSaleId = String.valueOf(sale.getSaleId());
                saleValue = Double.valueOf(0);
            }
        }
        String data = "Id da melhor venda: " + bestSaleId;
        return data;
    }

    public String worstSalesmanValidate (List<Sale> sales, List<Salesman> salesmanList) throws IOException {
        Double saleValue = Double.valueOf(0);
        Double worstSalesmanValue = Double.valueOf(0);
        Double bestSalesmanValue = Double.valueOf(0);
        Double profits = Double.valueOf(0);
        String worstSalesman = "";

        for(Sale sale : sales){
            String salesmanName = sale.getSalesmanName();
            for(Item item : sale.getItemList()){
                saleValue = saleValue + (item.getItemQuantity() * item.getItemPrice());
            }
            for(Salesman salesman : salesmanList){
                if(salesman.getName().equals(salesmanName)){
                    profits = profits + saleValue;
                    salesman.totalProfits = profits;
                }
            }
            saleValue = Double.valueOf(0);
            profits = Double.valueOf(0);
        }

        for(Salesman salesman : salesmanList){
            if(salesman.totalProfits > bestSalesmanValue){
                bestSalesmanValue = salesman.totalProfits;
            }
        }
        worstSalesmanValue = bestSalesmanValue;
        for(Salesman salesman : salesmanList){
            if(salesman.totalProfits < worstSalesmanValue){
                worstSalesmanValue = salesman.totalProfits;
                worstSalesman = salesman.getName();
            }
        }
        String data = "O pior vendedor foi: " + worstSalesman;
        return data;
    }
}
