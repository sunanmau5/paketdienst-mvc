package klausur;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import praxisteil.Paket;
import praxisteil.Paketdienst;

class PaketMockito {

	Paket p;
	Paketdienst pd;
	
	@BeforeEach
	void setUp() {
		p = Mockito.mock(Paket.class);
		pd = new Paketdienst();
	}
	
	@Test
	void zustandAendern() {
		
	}

}
