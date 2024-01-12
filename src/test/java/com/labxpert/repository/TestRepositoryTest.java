package com.labxpert.repository;


import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import com.labxpert.model.Test;

@DataJpaTest
public class TestRepositoryTest {

    @Autowired
    private TestRepository testRepository;

    @ParameterizedTest
    @CsvFileSource(resources = "/listTest.csv", numLinesToSkip = 1)
    public void testSaveTestFromCsv(String nomDuTest, double valeurMin, double valeurMax, String uniteDeMesure) {
    
        Test test = new Test();
        test.setNom_du_test(nomDuTest);
        test.setValeur_min(valeurMin);
        test.setValeur_max(valeurMax);
        test.setUnite_de_mesure(uniteDeMesure);

 
        Test savedTest = testRepository.save(test);

        Test retrievedTest = testRepository.findById(savedTest.getId()).orElse(null);

        assertEquals(nomDuTest, retrievedTest.getNom_du_test());
        assertEquals(valeurMin, retrievedTest.getValeur_min());
        assertEquals(valeurMax, retrievedTest.getValeur_max());
        assertEquals(uniteDeMesure, retrievedTest.getUnite_de_mesure());
    }
}
