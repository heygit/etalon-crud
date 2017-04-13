package project.services.stub;

import org.springframework.stereotype.Service;
import project.services.Printer;


@Service
public class PrinterStub implements Printer {

    public String print() {
        return "Stub";
    }
}
