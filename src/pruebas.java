import java.io.IOException;


public class pruebas {
	public static void main(String[] args) throws IOException {
		int N=6300000;
		System.out.println(N);
		VanEmdeBoas VEB= new VanEmdeBoas(N);
		System.out.println("creación "+N);
		for (int i=0; i<N;i++){
			VEB.insert(i);			
		}
		System.out.println("insercin lista");	
		int ant=3; int curr=0;
		for(int i=1; i<250000;i++){
			//System.out.println(VEB.findNext(4*i));
			curr=VEB.findNext(4*i+3);
			if(curr!= ant+4)
				System.out.println("fail");
			ant=curr;
	
		}
		System.out.println("termin");		
		
	}
}
