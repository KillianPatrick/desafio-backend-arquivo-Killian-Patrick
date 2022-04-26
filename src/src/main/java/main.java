
import Classes.*;

import java.io.IOException;
import java.nio.file.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.TimeZone;

public class main {

    public static void main(String[] args) throws IOException, InterruptedException {

        TimeZone.setDefault(TimeZone.getTimeZone("America/Sao_Paulo"));

        WatchService watcher = FileSystems.getDefault().newWatchService();
        Path diretorio = Paths.get("C://Users//SouthSystem//Desktop//DeveloperTest//data//in");
        diretorio.register(watcher, StandardWatchEventKinds.ENTRY_CREATE);

        while (true) {

            WatchKey key = watcher.take();//TESTE DIRETORIO
            Optional<WatchEvent<?>> watchEvent= key.pollEvents().stream().findFirst();//TESTE DIRETORIO
            if (watchEvent.isPresent()) {
                if  (watchEvent.get().kind() == StandardWatchEventKinds.OVERFLOW) {
                    continue;
                }
                Path path = (Path) watchEvent.get().context();

                FileReader reader = new FileReader();
                reader.filePath = Paths.get("C://Users//SouthSystem//Desktop//DeveloperTest//data//in//" + path);
                reader.data = reader.readFile(reader.filePath);

                String newFileName = path.toString().replace(".dat",".done.dat");
                FileWritter writter = new FileWritter();
                writter.newFilePath = "C://Users//SouthSystem//Desktop//DeveloperTest//data//out//flat_file_" + newFileName;

                String s;
                List<Salesman> salesmanList = new ArrayList<Salesman>();
                List<Client> clientList = new ArrayList<Client>();
                List<Sale> sales = new ArrayList<Sale>();

                for (int i = 0; i < reader.data.size(); i++) {
                    switch (reader.data.get(i).codePointBefore(reader.data.get(i).indexOf("ç"))) {
                        case '1':
                            Salesman salesman = new Salesman();
                            s = reader.data.get(i);
                            salesman.salesmanSave(s);
                            salesmanList.add(salesman);
                            break;
                        case '2':
                            Client client = new Client();
                            s = reader.data.get(i);
                            client.clientSave(s);
                            clientList.add(client);
                            break;
                        case '3':
                            s = reader.data.get(i);
                            Sale sale = new Sale();
                            sale.saleSave(s);
                            sales.add(sale);
                            break;
                    }
                }
                writter.writeFile(writter.newFilePath, clientList, salesmanList, sales);
            }
            boolean valid = key.reset();
            if (!valid) {
                break;
            }
        }
    }
}
