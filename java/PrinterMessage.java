import java.io.PrintStream;
import java.net.InetAddress;
import java.net.Socket;

public class PrinterMessage
{
	public static void main(String[] args) throws Exception
	{
		if (args.length != 2)
		{
			System.err.println("ERROR: Need to specify both a printer address and a message");
			System.exit(1);
		}

		InetAddress printerAddress = InetAddress.getByName(args[0]);
		Socket printerSocket = new Socket(printerAddress, 9100);
		PrintStream out = new PrintStream(printerSocket.getOutputStream());

		String commandString = "\033%-12345X@PJL RDYMSG DISPLAY = \"" + args[1] + "\"\r\n\033%-12345X\r\n";
		out.write(commandString.getBytes("US-ASCII"));

		printerSocket.close();
		out.close();

		System.out.println("Message successfully sent to printer");
	}
}
