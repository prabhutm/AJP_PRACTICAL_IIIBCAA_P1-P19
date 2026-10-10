import java.io.IOException;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import javax.print.*;
public class PrintWelcomeDirectly {
public static void main(String[] args) {
String message = "Welcome"; InputStream input =
new ByteArrayInputStream(message.getBytes());
DocFlavor flavor = DocFlavor.INPUT_STREAM.AUTOSENSE;
Doc doc = new SimpleDoc(input, flavor, null);
PrintService printer =
PrintServiceLookup.lookupDefaultPrintService();
if (printer != null) {
DocPrintJob job = printer.createPrintJob();
try {
job.print(doc, null);
System.out.println("Printing started.");
} catch (PrintException e) {
System.out.println("Printing failed.");
}
} else {
System.out.println("No printer found.");
}
}
}