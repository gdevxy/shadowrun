package ch.gdevxy.shadowrun;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.modulith.core.ApplicationModules;
import org.springframework.modulith.docs.Documenter;
import org.springframework.test.context.ActiveProfiles;

@SpringBootTest
@ActiveProfiles("DEV")
class ShadowrunApplicationTests {

	@Test
	void contextLoads() {
	}

	@Test
	void verifyModularity() {
		var modules = ApplicationModules.of(ShadowrunApplication.class);
		modules.verify();
	}

	@Test
	void writeDocumentationSnippets() {
		var modules = ApplicationModules.of(ShadowrunApplication.class);

		new Documenter(modules)
			.writeModulesAsPlantUml()
			.writeIndividualModulesAsPlantUml();
	}
}
