import java.io.IOException;


public class pruebas {
	public static void main(String[] args) throws IOException {
		int N=16777216;
		VanEmdeBoas VEB= new VanEmdeBoas(N);
		for (int i=0; i<N;i++){
			VEB.insert(i);			
		}
		System.out.println("inserci�n lista");	
		int ant=0; int curr=0;
		for(int i=1; i<250000;i++){
			//System.out.println(VEB.findNext(4*i));
			curr=VEB.findNext(16*i);
			if(curr!= ant+16)
				System.out.println("fail");
			ant=curr;
	
		}
		System.out.println("termin�");		
		
	}
}
