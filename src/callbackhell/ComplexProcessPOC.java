package callbackhell;

public class ComplexProcessPOC {

	public static void main(String[] args) {
		//Normal execution
		ComplexProcess complexProcess = new ComplexProcess();
		complexProcess.execFase(ComplexProcess.FASE_ONE, null);
		
		//Generating a exception
		complexProcess = new ComplexProcess();
		complexProcess.execFase(ComplexProcess.FASE_THREE, null);
		
		//Implement using DTO to represent process states
		ComplexProcessWithDTO complexProcessWithDTO = new ComplexProcessWithDTO();
		FasesDTO dto = new FasesDTO();
		dto.setActualFase(ComplexProcessWithDTO.FASE_ONE);
		complexProcessWithDTO.execFase(dto);	
	}	
}
