package testing.mocks.ejercicio1;

import org.junit.jupiter.api.Test;

import static org.easymock.EasyMock.*;

public class LogAnalyzerTest {
	@Test
    public void analizeLogErrorUsingMock() {
    	IWebService webService = createMock(IWebService.class);
    	
    	LogAnalyzer lAnalyzer = new LogAnalyzer();
    	lAnalyzer.setWebService( webService );
    	
    	String fileName = "file";
    	
    	// Especificar comportamiento esperado
    	webService.logError( "Filename too short:" + fileName );
    	//crear Mock para el corportamiento anterior
    	replay( webService );
    	
    	lAnalyzer.analyze( fileName );
    	//verificar que se ejercita el comportamiento esperado
    	verify( webService );
    }
	
	@Test
	public void analizeSendEmailUsingMock() {
		IEmailService emailService = createMock(IEmailService.class);
		IWebService webService     = createMock(IWebService.class);
		
		LogAnalyzer lAnalyzer = new LogAnalyzer();
		lAnalyzer.setEmailService( emailService );
		lAnalyzer.setWebService(webService);
		
		String fileName = "file";
		
		Exception e = new RuntimeException();
		
		// Especificar comportamiento esperado
		emailService.sendEmail("a", "subject", e.getMessage());
		
		webService.logError( "Filename too short:" + fileName );
		expectLastCall().andThrow( new RuntimeException() );
		
		// Crear mock para el comportamiento anterior
		replay( emailService );
		replay( webService );
		
		lAnalyzer.analyze( fileName );
		//verificar que se ejercita el comportamiento esperado
		verify( emailService );
	}
}
