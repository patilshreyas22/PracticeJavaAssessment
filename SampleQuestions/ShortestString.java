import java.util.*;

class code1{

	public static void main(String args []){
	
	
		Scanner sc = new Scanner(System.in);

		String str = sc.next();

		sc.close();

		StringBuilder sb = new StringBuilder(str);

		boolean OperationPerformed = true;

		while(OperationPerformed){
		
			OperationPerformed = false;

			for(int i = 0 ; i<sb.length()-1 ; i++){
			
				if(sb.charAt(i)=='1' && sb.charAt(i+1)=='0'){
				
					sb.deleteCharAt(i);
					OperationPerformed = true ;
					break;
				}
			
			}
		
		}

		System.out.println(sb.toString());
	
	
	
	}

}
