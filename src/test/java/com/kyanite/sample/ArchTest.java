package com.kyanite.sample;

import static com.tngtech.archunit.lang.syntax.ArchRuleDefinition.noClasses;

import com.tngtech.archunit.core.domain.JavaClasses;
import com.tngtech.archunit.core.importer.ClassFileImporter;
import com.tngtech.archunit.core.importer.ImportOption;
import org.junit.jupiter.api.Test;

class ArchTest {

    @Test
    void servicesAndRepositoriesShouldNotDependOnWebLayer() {
        JavaClasses importedClasses = new ClassFileImporter()
            .withImportOption(ImportOption.Predefined.DO_NOT_INCLUDE_TESTS)
            .importPackages("com.kyanite.sample");

        noClasses()
            .that()
            .resideInAnyPackage("com.kyanite.sample.service..")
            .or()
            .resideInAnyPackage("com.kyanite.sample.repository..")
            .should()
            .dependOnClassesThat()
            .resideInAnyPackage("..com.kyanite.sample.web..")
            .because("Services and repositories should not depend on web layer")
            .check(importedClasses);
    }
}
