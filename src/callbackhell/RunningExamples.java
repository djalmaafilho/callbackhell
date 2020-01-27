package callbackhell;

public class RunningExamples {

	public static void main(String[] args) {
		//Normal execution
		SolveComplexProcess complexProcess = new SolveComplexProcess();
		complexProcess.execFase(SolveComplexProcess.FASE_ONE, null);
		
		//Generating a exception
		complexProcess = new SolveComplexProcess();
		complexProcess.execFase(SolveComplexProcess.FASE_THREE, null);
		
		//Implement using DTO to represent process states
		SolveWithDTO complexProcessWithDTO = new SolveWithDTO();
		FasesDTO dto = new FasesDTO();
		dto.setActualFase(SolveWithDTO.FASE_ONE);
		complexProcessWithDTO.execFase(dto);	
	}	
}
