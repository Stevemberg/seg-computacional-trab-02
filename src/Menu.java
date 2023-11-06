import java.util.Scanner;

public class Menu {
	private AES aes;
	private AESCTR aesCtr;
	private BytesAndMatrixManipulation bmm;
	private Byte[] plainText;
	private Byte[] key;
	private String openSslResult;
	private Byte[] nonce;
	private Scanner sc;

	public Menu() {
		aes = new AES();
		aesCtr = new AESCTR();
		bmm = new BytesAndMatrixManipulation();
		plainText = FileManipulation.readBinFile("text.txt");
		key = FileManipulation.readBinFile("key.txt");
		openSslResult = FileManipulation.readFile("out.txt");
		nonce = FileManipulation.readBinFile("nonce.txt");
		sc = new Scanner(System.in);
	}

	void initMenu() {
		int option = -1;
		ShellWrapper.clear();
		System.out.println("1 - AES");
		System.out.println("2 - CTR");
		option = sc.nextInt();
		switch (option) {
		case 1:
			menuAES();

			break;
		case 2:
			menuCTR();
			break;

		}

	}

	private void menuAES() {
		String command = "openssl enc -aes-128-ecb -K " + ArrayUtils.printToHex(key) + " -in ./textfiles/text.txt | xxd -p > ./textfiles/out.txt";
		FileManipulation.writeFile("script.sh", command);
		ShellWrapper.runScript(new String[0]);
		openSslResult = FileManipulation.readFile("out.txt");
		System.out.println("Quantos rounds?");
		int rounds = sc.nextInt();
		Byte[] cipherText = aes.encrypt(key, plainText, rounds);
		Byte[] decipherText = aes.decrypt(key, cipherText, rounds);
		System.out.println("Texto plano		: " + ArrayUtils.printToStr(plainText));
		System.out.println("Cifrado(HEX)		: " + ArrayUtils.printToHex(cipherText));
		System.out.println("OpenSSL-10-rounds(HEX)	: " + openSslResult);
		System.out.println("Diferença		: " + ArrayUtils.printToHex(cipherText).compareTo(openSslResult));
		System.out.println("Decifrado		: " + ArrayUtils.printToStr(decipherText));

	}

	private void menuCTR() {
		ShellWrapper.runScript(new String[0]);
		System.out.println("Quantos rounds?");
		int rounds = sc.nextInt();
		System.out.println("Texto plano	: " + ArrayUtils.printToStr(plainText));
		System.out.print("Cifrado(HEX)	: ");
		Byte[] enc = aesCtr.encrypt(key, plainText, rounds, nonce);
		bmm.printVector(enc);
		System.out.println("Decifrado	: " + ArrayUtils.printToStr(aesCtr.decrypt(key, enc, rounds, nonce)));
	}
}
