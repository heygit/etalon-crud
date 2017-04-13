package project.services.impl;

import org.springframework.stereotype.Service;
import project.services.Printer;


@Service
public class PrinterImpl implements Printer {

    public String print() {
        return "Impl";
    }
}
