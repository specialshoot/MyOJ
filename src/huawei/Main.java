package huawei;

public class Main {
	
	public static byte[] getRes(String[] strs) {
		byte[] bbb=new byte[8];
		for (String str : strs) {
			if (str.contains("malloc")) {
				String[] ss = str.split("malloc");
				String time=ss[0].trim();
				String address = ss[1].trim();
				byte[] bs=address.getBytes();
				for(int i=0;i<8;i++) {
					   bbb[i]=(byte)(bs[i]^bbb[i]);
				}
			}
			if(str.contains("free")){
				String[] ss = str.split("free");
				String time=ss[0].trim();
				String address = ss[1].trim();
				byte[] bs=address.getBytes();
				for(int i=0;i<8;i++) {
					   bbb[i]=(byte)(bs[i]^bbb[i]);
				}
			}
		}
		return bbb;
	}
	
	public static byte[] getRes(String[] mallocStrs,String[] freeStrs){
		byte[] bs=new byte[8];

		byte[] byte1= getRes(mallocStrs);
		byte[] byte2= getRes(freeStrs);
		for(int i=0;i<8;i++){
			bs[i]=(byte)(byte1[i]^byte2[i]);
		}
		return bs;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
