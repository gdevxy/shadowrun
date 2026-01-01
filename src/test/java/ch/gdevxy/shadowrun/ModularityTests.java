package ch.gdevxy.shadowrun;

import org.junit.jupiter.api.Test;
import org.springframework.modulith.core.ApplicationModules;
import org.springframework.modulith.core.ApplicationModule;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Architecture tests to verify Spring Modulith boundaries are maintained.
 */
class ModularityTests {

	ApplicationModules modules = ApplicationModules.of(ShadowrunApplication.class);

	@Test
	void verifiesModularStructure() {
		modules.verify();
	}

	@Test
	void shouldHaveExpectedModules() {
		assertThat(modules.stream())
			.extracting(ApplicationModule::getName)
			.contains("campaign", "character", "session", "location", "dashboard");
	}

	@Test
	void modulesDoNotHaveCyclicDependencies() {
		modules.verify();  // verify() checks for cycles
	}

	@Test
	void internalPackagesAreNotAccessibleFromOtherModules() {
		// Spring Modulith ensures that 'internal' packages are not accessible
		// from other modules. This test verifies that constraint.
		modules.verify();
	}
}
