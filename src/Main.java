public class Main {
	public static void main(String[] args) {
		AES aes = new AES();
		BytesAndMatrixManipulation bmm = new BytesAndMatrixManipulation();
		Byte[] plainText = FileManipulation.readBinFile("text.txt");
		Byte[] key = FileManipulation.readBinFile("key.txt");

		Byte[] block = aes.encrypt(key, plainText, 10);

//		Byte[][] plainMatrix = bmm.convertStringToMAtrix("db f2 01 c6 13 0a 01 c6 53 22 01 c6 45 5c 01 c6", false);
//		Byte[][] keyMatrix = bmm.convertStringToMAtrix("ac 19 28 57 77 fa d1 5c 66 dc 29 00 f3 21 41 6a", false);
//		BytesAndMatrixManipulation.printMatrix(bmm.convertBytesToMatrix(plainText, true));
//		BytesAndMatrixManipulation.printMatrix(bmm.convertBytesToMatrix(key, true));

//		BytesAndMatrixManipulation.printMatrix(plainMatrix);
//		BytesAndMatrixManipulation.printMatrix(keyMatrix);
//		BytesAndMatrixManipulation.printMatrix(aes.addRoundKey(plainMatrix, keyMatrix));
//		Byte[] key = bmm.convertStringToByteArray("ea d2 73 21 7f 8d 29 2f 7f 8d 29 2f 7f 8d 29 2f");
//		bmm.printVector(aes.expandKey(key, 10));
//		System.out.println(aes.getKey().length / 4);
	}

}
