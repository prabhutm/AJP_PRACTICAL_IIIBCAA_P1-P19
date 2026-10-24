import java.io.IOException;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import javax.print.*;

public class PrintWelcomeDirectly {

public static void main(String[] args) {

String message = &quot;Welcome&quot;;

InputStream input =
new ByteArrayInputStream(message.getBytes());

DocFlavor flavor = DocFlavor.INPUT_STREAM.AUTOSENSE;

Doc doc = new SimpleDoc(input, flavor, null);

PrintService printer =
PrintServiceLookup.lookupDefaultPrintService();

if (printer != null) {

DocPrintJob job = printer.createPrintJob();

try {
job.print(doc, null);
System.out.println(&quot;Printing started.&quot;);

} catch (PrintException e) {
System.out.println(&quot;Printing failed.&quot;);
}

} else {

System.out.println(&quot;No printer found.&quot;);
}
}
}