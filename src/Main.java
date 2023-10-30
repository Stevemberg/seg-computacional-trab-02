public class Main {
	public static void main(String[] args) {
		AES aes = new AES();
		BytesAndMatrixManipulation bmm = new BytesAndMatrixManipulation();
		Byte[] plainText = FileManipulation.readBinFile("text.txt");
		Byte[] key = FileManipulation.readBinFile("key.txt");
		Byte[] block = aes.encrypt(key, plainText, 10);
		bmm.printVector(block);

	}

}
