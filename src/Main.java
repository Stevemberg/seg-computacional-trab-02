public class Main {
	public static void main(String[] args) {
		AES aes = new AES();
		BytesAndMatrixManipulation bmm = new BytesAndMatrixManipulation();
		Byte[] plainText = FileManipulation.readBinFile("text.txt");
		Byte[] key = FileManipulation.readBinFile("key.txt");
		String verify = FileManipulation.readFile("out.txt");
		Byte[] cipherText = aes.encrypt(key, plainText, 10);
		System.out.println("Criado :" + ArrayUtils.convertToHex(cipherText));
		System.out.println("OpenSSL:" + verify);
		System.out.println("Diff   :" + ArrayUtils.convertToHex(cipherText).compareTo(verify));
		Byte[] decipherText = aes.dencrypt(key, cipherText, 10);
		System.out.println("Decifr :" + ArrayUtils.convertToStr(decipherText));

	}

}
