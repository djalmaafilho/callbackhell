package callbackhell;

import java.util.ArrayList;
import java.util.List;

public class FasesDTO {

	private int actualFase;
	private List<Object> fasesResult = new ArrayList<>();
			
	
	public void addFaseResult(Integer fase, Object result) {
		this.actualFase = fase.intValue();
		fasesResult.add(result);
	}
	
	public int getActualFase() {
		return actualFase;
	}
	
	public List<Object> getFasesResult() {
		return fasesResult;
	}
	
	public void setActualFase(int actualFase) {
		this.actualFase = actualFase;
	}
}
