package mz.gov.mogovolas.expedientes;
import org.junit.jupiter.api.Test; import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder; import static org.junit.jupiter.api.Assertions.*;
class SecurityConfigTest { @Test void passwordDeveSerHash(){var e=new BCryptPasswordEncoder(12);String hash=e.encode("teste-local");assertNotEquals("teste-local",hash);assertTrue(e.matches("teste-local",hash));}}
